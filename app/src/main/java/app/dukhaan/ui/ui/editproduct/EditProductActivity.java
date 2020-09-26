package app.dukhaan.ui.ui.editproduct;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.text.Html;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.Product;
import app.dukhaan.data.model.UploadImage;
import app.dukhaan.data.model.Variant;
import app.dukhaan.databinding.ActivityEditProductBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.AddProductRequest;
import app.dukhaan.network.model.AddProductResponse;
import app.dukhaan.network.model.BaseCreateProduct;
import app.dukhaan.network.model.Category;
import app.dukhaan.network.model.CategoryListResponse;
import app.dukhaan.network.model.DeleteProductResponse;
import app.dukhaan.network.model.EditProductRequest;
import app.dukhaan.network.model.EditProductResponse;
import app.dukhaan.ui.editproduct.EditProductActivity.1;
import app.dukhaan.ui.editproduct.EditProductActivity.2;
import app.dukhaan.ui.editproduct.EditProductActivity.3;
import app.dukhaan.ui.editproduct.EditProductActivity.4;
import app.dukhaan.ui.editproduct.EditProductActivity.5;
import app.dukhaan.ui.editproduct.EditProductActivity.6;
import app.dukhaan.ui.editproduct.EditProductActivity.7;
import app.dukhaan.ui.editproduct.EditProductActivity.8;
import app.dukhaan.ui.editproduct.EditProductActivity.9;
import app.dukhaan.ui.editproduct.EditProductNavigator;
import app.dukhaan.ui.editproduct.EditProductViewModel;
import app.dukhaan.ui.imagepicker.MultiImagePickerActivity;
import app.dukhaan.ui.products.AddProductCategoryListAdapter;
import app.dukhaan.ui.products.AddProductCategoryListAdapter.categoryItemClick;
import app.dukhaan.ui.views.customdialog.IdialogItemClickListner;
import app.dukhaan.ui.views.products.ProductImagesListAdapter;
import app.dukhaan.ui.views.products.ProductImagesListAdapter.ProductImagesListAdapterListener;
import app.dukhaan.ui.views.units.ProductUnitAdapter;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.IpopUpMenuItem;
import app.dukhaan.util.ModalDialogs;
import app.dukhaan.util.PricingUtils;
import app.dukhaan.util.RecyclerViewItemDecoration;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder;
import com.karumi.dexter.Dexter;
import io.branch.referral.util.BranchEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

public class EditProductActivity extends BaseActivity<ActivityEditProductBinding, EditProductViewModel> implements IpopUpMenuItem, EditProductNavigator, categoryItemClick, IdialogItemClickListner, ProductImagesListAdapterListener {
   static boolean active;
   private AddProductCategoryListAdapter addProductCategoryListAdapter;
   private ActivityEditProductBinding binding;
   private String blockCharacterSet = "\",',\\";
   private Business business;
   private Category category;
   private ArrayList<Category> categoryArrayList;
   private String currency;
   private Drawable drawable = null;
   List<String> extraUnitsArray = null;
   private String finalVariantString = null;
   private Category fromCategoriesModel;
   private ArrayList<Uri> imgArrayList;
   private boolean isFromUpdate;
   private boolean loading = true;
   private ProductImagesListAdapter mAdapter;
   private FirebaseRemoteConfig mFirebaseRemoteConfig;
   private LinearLayoutManager mLayoutManager;
   private EditProductViewModel mViewModel;
   private int pagination = 1;
   private int pastVisibleItems;
   private PopupWindow popUp;
   private Product product = null;
   private List<String> productImages;
   private LinkedHashMap<String, String> productImagesMap;
   private InputFilter productNameFilter = new 1(this);
   private int totalItemCount;
   private int uploadingCount = 0;
   private int uploadingTotal = 0;
   private int visibleItemCount;

   public EditProductActivity() {
   }

   private void appendProductImage(String var1) {
      this.productImages.add(0, var1);
      this.mAdapter.notifyItemInserted(0);
      this.binding.recyclerview.scrollToPosition(0);
      if (this.productImages.size() == 8) {
         this.mAdapter.disableAddImage();
      }

   }

   private int getQuantityInput() {
      boolean var1 = TextUtils.isEmpty(this.binding.etQuantity.getText());
      byte var2 = 1;
      int var3 = var2;
      if (!var1) {
         int var4;
         try {
            var4 = Integer.parseInt(this.binding.etQuantity.getText().toString());
         } catch (Exception var6) {
            var3 = var2;
            return var3;
         }

         var3 = var2;
         if (var4 > 0) {
            var3 = var4;
         }
      }

      return var3;
   }

   private String getQuantityUnit() {
      Product var1 = this.product;
      if (var1 != null && var1.getBaseQty() != null) {
         String[] var2 = this.product.getBaseQty().split("\\s+");
         return var2.length > 1 ? var2[var2.length - 1] : this.product.getBaseQty();
      } else {
         return "";
      }
   }

   private String getQuantityValue() {
      Product var1 = this.product;
      String var2 = "1";
      String var3 = var2;
      if (var1 != null) {
         if (var1.getBaseQty() == null) {
            var3 = var2;
         } else {
            String[] var4 = this.product.getBaseQty().split("\\s+");
            var3 = var2;
            if (var4.length > 1) {
               var3 = var2;
               if (this.isInteger(var4[0])) {
                  var3 = var4[0];
               }
            }
         }
      }

      return var3;
   }

   private String getUnitPlural(String var1) {
      String var3;
      try {
         int var2 = this.getResources().getIdentifier(var1, "plurals", this.getPackageName());
         var3 = this.getResources().getQuantityString(var2, this.getQuantityInput());
      } catch (NotFoundException var4) {
         return var1;
      }

      var1 = var3;
      return var1;
   }

   private void handleUCropResult(Intent var1) {
      this.imgArrayList = var1.getParcelableArrayListExtra("path");
      int var2 = 8 - this.productImagesMap.size();
      int var3 = this.imgArrayList.size();
      if (var3 < var2) {
         var2 = var3;
      }

      this.uploadingTotal = var2;

      for(var3 = 0; var3 < var2; ++var3) {
         this.uploadProductImage((Uri)this.imgArrayList.get(var3), var3, this.imgArrayList.size());
      }

      if (var1 == null) {
         Toast.makeText(this.getApplicationContext(), this.getString(R.string.msg_error_unable_select_profile_pic), 1).show();
      }

   }

   private void hideKeyboard(Activity var1) {
      InputMethodManager var2 = (InputMethodManager)var1.getSystemService("input_method");
      View var3 = var1.getCurrentFocus();
      View var4 = var3;
      if (var3 == null) {
         var4 = new View(var1);
      }

      if (var2 != null) {
         var2.hideSoftInputFromWindow(var4.getWindowToken(), 0);
      }

   }

   private void hideSellingPriceError() {
      this.binding.etSellingPrice.setBackgroundDrawable(this.getResources().getDrawable(editext_background));
      this.binding.etMrp.setBackgroundDrawable(this.getResources().getDrawable(editext_background));
      this.binding.priceError.setVisibility(8);
      this.binding.costDescription.setVisibility(0);
   }

   private void initProductImages() {
      if (this.productImages == null) {
         this.productImages = new ArrayList();
      }

      if (this.productImagesMap == null) {
         this.productImagesMap = new LinkedHashMap();
      }

      Product var1 = this.product;
      if (var1 != null && !TextUtils.isEmpty(var1.getImage()) && !this.product.getImage().equalsIgnoreCase("https://dukaan-api.1kg.me/static/images/category-def.jpg")) {
         this.productImages.add(this.product.getImage());
         this.productImagesMap.put(this.product.getImage(), this.product.getImage());
      }

      var1 = this.product;
      if (var1 != null && var1.realmGet$variants() != null && this.product.realmGet$variants().size() > 0) {
         Iterator var3 = this.product.realmGet$variants().iterator();

         while(var3.hasNext()) {
            String var2 = (String)var3.next();
            this.productImages.add(var2);
            this.productImagesMap.put(var2, var2);
         }
      }

      this.mAdapter = new ProductImagesListAdapter(this, this.productImages);
      LinearLayoutManager var4 = new LinearLayoutManager(this, 0, false);
      this.binding.recyclerview.addItemDecoration(new RecyclerViewItemDecoration(AppUtils.dpToPx(12), 0));
      this.binding.recyclerview.setLayoutManager(var4);
      this.binding.recyclerview.setAdapter(this.mAdapter);
      if (this.productImagesMap.keySet().size() == 8) {
         this.mAdapter.disableAddImage();
      }

   }

   private void initUI() {
      this.binding.etQuantity.setText(this.getQuantityValue());
      this.binding.etProductName.addTextChangedListener(new app.dukhaan.ui.editproduct.EditProductActivity.CustomTextWatcher(this));
      this.binding.etSellingPrice.addTextChangedListener(new app.dukhaan.ui.editproduct.EditProductActivity.CustomTextWatcher(this));
      this.binding.etMrp.addTextChangedListener(new app.dukhaan.ui.editproduct.EditProductActivity.CustomTextWatcher(this));
      this.binding.etDesc.addTextChangedListener(new app.dukhaan.ui.editproduct.EditProductActivity.CustomTextWatcher(this));
      this.binding.etCategory.addTextChangedListener(new app.dukhaan.ui.editproduct.EditProductActivity.CustomTextWatcher(this));
      this.binding.etProductName.setFilters(new InputFilter[]{this.productNameFilter});
      if (AppPref.getInstance().getCurrency() != null) {
         this.currency = AppUtils.getCurrencySymbol(AppPref.getInstance().getCurrency());
      }

      if (!TextUtils.isEmpty(this.currency)) {
         this.drawable = AppUtils.getSymbol(this, this.currency, this.binding.etSellingPrice.getTextSize(), ContextCompat.getColor(R.color.this, colorInputValue));
      } else {
         this.drawable = AppUtils.getSymbol(this, "₹", this.binding.etSellingPrice.getTextSize(), ContextCompat.getColor(R.color.this, colorInputValue));
      }

      this.binding.etSellingPrice.setCompoundDrawablesWithIntrinsicBounds(this.drawable, (Drawable)null, (Drawable)null, (Drawable)null);
      this.binding.etMrp.setCompoundDrawablesWithIntrinsicBounds(this.drawable, (Drawable)null, (Drawable)null, (Drawable)null);
      MultiImagePickerActivity.clearCache(this);
      this.binding.etCategory.setOnClickListener(new _$$Lambda$EditProductActivity$_qfVTWZiRspKiKquTx3AMmGnhf4(this));
      this.binding.etUnit.setOnClickListener(new _$$Lambda$EditProductActivity$eoBroNNh_IfdEsic0wHanIAckFc(this));
      this.binding.llDelete.setOnClickListener(new _$$Lambda$EditProductActivity$BP6P3JxBVbIcJjb4Es7w_i4y5KQ(this));
      this.binding.addProduct.setOnClickListener(new _$$Lambda$EditProductActivity$pc0U14r8SHMl2gJxNhZX3s79iZQ(this));
      this.binding.etQuantity.addTextChangedListener(new 2(this));
      this.binding.etMrp.addTextChangedListener(new 3(this));
      this.binding.etSellingPrice.addTextChangedListener(new 4(this));
      this.binding.btnAddVariant.setOnClickListener(new _$$Lambda$EditProductActivity$WC20narYYTt_u8lEgWjLfzepjTU(this));
      this.binding.lblAddVariant.setOnClickListener(new _$$Lambda$EditProductActivity$o7Ngdb4y8y_rvmYod0sTfm2CjWA(this));
      this.initProductImages();
      this.updateButtonStatus();
      this.previewUnitDescription();
   }

   private boolean isInteger(String var1) {
      try {
         Integer.parseInt(var1);
         return true;
      } catch (Exception var2) {
         return false;
      }
   }

   private void launchCameraIntent() {
      Intent var1 = new Intent(this, MultiImagePickerActivity.class);
      var1.putExtra("image_picker_option", 0);
      var1.putExtra("lock_aspect_ratio", true);
      var1.putExtra("aspect_ratio_x", 1);
      var1.putExtra("aspect_ratio_Y", 1);
      var1.putExtra("set_bitmap_max_width_height", true);
      var1.putExtra("max_width", 1000);
      var1.putExtra("max_height", 1000);
      this.startActivityForResult(var1, 100);
   }

   private void launchGalleryIntent() {
      Intent var1 = new Intent(this, MultiImagePickerActivity.class);
      var1.putExtra("image_picker_option", 1);
      var1.putExtra("lock_aspect_ratio", true);
      var1.putExtra("aspect_ratio_x", 1);
      var1.putExtra("aspect_ratio_Y", 1);
      this.startActivityForResult(var1, 100);
   }

   private void onProductImageClick() {
      Dexter.withContext(this).withPermissions(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}).withListener(new 5(this)).check();
   }

   private void prepareProductImagesPayload(BaseCreateProduct var1) throws JSONException {
      if (var1 != null) {
         LinkedHashMap var2 = this.productImagesMap;
         if (var2 != null) {
            Timber.e("Products image map: %s | %s", new Object[]{var2, this.productImages});
            JSONArray var9 = new JSONArray();
            if (var1.variants == null) {
               var1.variants = new ArrayList();
            }

            Iterator var3 = this.productImagesMap.entrySet().iterator();

            int var4;
            for(var4 = 0; var3.hasNext(); ++var4) {
               Entry var5 = (Entry)var3.next();
               if (var4 == 0) {
                  var1.image = (String)var5.getValue();
               } else if (!TextUtils.isEmpty((CharSequence)var5.getValue())) {
                  StringBuilder var6 = new StringBuilder();
                  var6.append("VARIANTS 0 : ");
                  var6.append((String)var5.getValue());
                  Timber.d(var6.toString(), new Object[0]);
                  JSONObject var13 = new JSONObject();
                  var13.put("type", "0");
                  var13.put("value", var5.getValue());
                  var9.put(var13);
               }
            }

            label49: {
               Exception var10000;
               label59: {
                  JSONArray var10;
                  boolean var10001;
                  try {
                     var10 = new JSONArray(this.finalVariantString);
                  } catch (Exception var8) {
                     var10000 = var8;
                     var10001 = false;
                     break label59;
                  }

                  var4 = 0;

                  while(true) {
                     try {
                        if (var4 >= var10.length()) {
                           break label49;
                        }

                        var9.put(var10.get(var4));
                     } catch (Exception var7) {
                        var10000 = var7;
                        var10001 = false;
                        break;
                     }

                     ++var4;
                  }
               }

               Exception var11 = var10000;
               Timber.e(var11);
            }

            StringBuilder var12 = new StringBuilder();
            var12.append("VARIANTS JSON: ");
            var12.append(this.finalVariantString);
            Timber.d(var12.toString(), new Object[0]);
            var12 = new StringBuilder();
            var12.append("VARIANTS FINAL: ");
            var12.append(var9.toString());
            Timber.d(var12.toString(), new Object[0]);
            var1.variants.add(var9.toString());
         }
      }
   }

   private void previewCostDescription() {
      if (!TextUtils.isEmpty(this.binding.etMrp.getText())) {
         TextView var1;
         StringBuilder var2;
         if (TextUtils.isEmpty(this.binding.etSellingPrice.getText())) {
            var1 = this.binding.costDescription;
            var2 = new StringBuilder();
            var2.append("Price: ₹");
            var2.append(this.binding.etMrp.getText());
            var1.setText(var2.toString());
         } else {
            var1 = this.binding.costDescription;
            var2 = new StringBuilder();
            var2.append("Price: ₹");
            var2.append(this.binding.etSellingPrice.getText());
            var2.append(" <strike>₹");
            var2.append(this.binding.etMrp.getText());
            var2.append("</strike >");
            var1.setText(Html.fromHtml(var2.toString()));
         }

      }
   }

   private void previewUnitDescription() {
      if (TextUtils.isEmpty(this.binding.etQuantity.getText())) {
         this.binding.unitDescription.setText(this.getString(R.string.unit_description_calculation, new Object[]{"1", this.getUnitPlural(this.binding.etUnit.getText().toString())}));
      } else {
         this.binding.unitDescription.setText(this.getString(R.string.unit_description_calculation, new Object[]{this.binding.etQuantity.getText().toString(), this.getUnitPlural(this.binding.etUnit.getText().toString())}));
         this.binding.unitDescription.setVisibility(0);
      }
   }

   private void showCategoryList() {
      this.mViewModel.getCategoryList(this.business.realmGet$id(), this.pagination);
      DisplayMetrics var1 = new DisplayMetrics();
      this.getWindowManager().getDefaultDisplay().getMetrics(var1);
      int var2 = var1.widthPixels;
      View var3 = LayoutInflater.from(this).inflate(popup_category_picker, (ViewGroup)null, false);
      PopupWindow var5 = new PopupWindow(var3, var2, -2, false);
      this.popUp = var5;
      var5.setTouchable(true);
      this.popUp.setFocusable(true);
      this.popUp.setOutsideTouchable(true);
      if (VERSION.SDK_INT >= 21) {
         this.popUp.setElevation(3.0F);
      }

      this.popUp.showAsDropDown(this.binding.etCategory);
      RecyclerView var6 = (RecyclerView)var3.findViewById(recyclerview_category);
      TextView var7 = (TextView)var3.findViewById(idAddNewCategory);
      ArrayList var4 = new ArrayList();
      this.categoryArrayList = var4;
      AddProductCategoryListAdapter var8 = new AddProductCategoryListAdapter(var4);
      this.addProductCategoryListAdapter = var8;
      var8.setCategoryItemClick(this);
      var6.setAdapter(this.addProductCategoryListAdapter);
      LinearLayoutManager var9 = new LinearLayoutManager(this);
      this.mLayoutManager = var9;
      var6.setLayoutManager(var9);
      var6.addOnScrollListener(new 8(this));
      var7.setOnClickListener(new _$$Lambda$EditProductActivity$uqVGB8OrT1X2XIWHA0EToRjdcbQ(this));
      this.popUp.setOnDismissListener(new _$$Lambda$EditProductActivity$IQ2qRjwMTztOt44l0alOCqZQWCI(this));
   }

   private void showImagePickerOptions() {
      MultiImagePickerActivity.showImagePickerOptions(this, new 6(this));
   }

   private void showProductUnitsDropdown() {
      this.hideKeyboard(this);
      List var1 = Arrays.asList(this.getResources().getStringArray(product_units));
      List var2 = this.extraUnitsArray;
      Object var3 = var1;
      if (var2 != null) {
         Timber.d(var2.toString(), new Object[0]);
         var3 = new ArrayList(var1);
         ((List)var3).addAll(this.extraUnitsArray);
         Timber.d(var3.toString(), new Object[0]);
      }

      DisplayMetrics var5 = new DisplayMetrics();
      this.getWindowManager().getDefaultDisplay().getMetrics(var5);
      int var4 = this.binding.etUnit.getWidth();
      View var6 = LayoutInflater.from(this).inflate(popup_unit_picker, (ViewGroup)null, false);
      PopupWindow var8 = new PopupWindow(var6, var4 + AppUtils.dpToPx(32), -2, false);
      this.popUp = var8;
      var8.setTouchable(true);
      this.popUp.setFocusable(true);
      this.popUp.setOutsideTouchable(true);
      if (VERSION.SDK_INT >= 21) {
         this.popUp.setElevation(3.0F);
      }

      this.popUp.showAsDropDown(this.binding.etUnit);
      RecyclerView var7 = (RecyclerView)var6.findViewById(recyclerview);
      var7.setAdapter(new ProductUnitAdapter((List)var3, new 7(this, (List)var3)));
      LinearLayoutManager var9 = new LinearLayoutManager(this);
      this.mLayoutManager = var9;
      var7.setLayoutManager(var9);
      this.popUp.setOnDismissListener(new _$$Lambda$EditProductActivity$0iFVauTzYJh1R5aFt7QVL3Gq__M(this));
   }

   private void showSellingPriceError() {
      this.binding.etSellingPrice.setBackgroundDrawable(this.getResources().getDrawable(editext_error_background));
      this.binding.etMrp.setBackgroundDrawable(this.getResources().getDrawable(editext_error_background));
      this.binding.priceError.setVisibility(0);
      this.binding.costDescription.setVisibility(8);
   }

   private void updateButtonStatus() {
      if (this.fromCategoriesModel != null) {
         this.binding.etCategory.setText(this.fromCategoriesModel.realmGet$name());
         this.category = this.fromCategoriesModel;
      }

      if (this.isFromUpdate) {
         this.binding.addProduct.setText(this.getString(R.string.update));
         this.binding.llDelete.setVisibility(0);
         this.binding.deleteSpacer.setVisibility(0);
         this.binding.toolTitle.setText(this.getString(R.string.update_product));
         if (this.product != null) {
            this.binding.etUnit.setText(this.getQuantityUnit());
            this.binding.etProductName.setText(this.product.getName());
            if (this.product.getBaseCost() > 0.0D && this.product.getBaseCost() < this.product.getOriginalCost()) {
               this.binding.etSellingPrice.setText(PricingUtils.formatPrice(this.product.getBaseCost()));
            }

            if (this.product.getOriginalCost() > 0.0D) {
               this.binding.etMrp.setText(PricingUtils.formatPrice(this.product.getOriginalCost()));
            }

            AppCompatEditText var1 = this.binding.etDesc;
            String var2 = this.product.getDescription();
            String var3 = "";
            if (var2 == null) {
               var2 = "";
            } else {
               var2 = this.product.getDescription();
            }

            var1.setText(var2);
            var1 = this.binding.etCategory;
            if (this.product.getCategoryName() == null) {
               var2 = var3;
            } else {
               var2 = this.product.getCategoryName();
            }

            var1.setText(var2);
         }
      } else {
         this.binding.etSellingPrice.setCompoundDrawablesWithIntrinsicBounds(this.drawable, (Drawable)null, (Drawable)null, (Drawable)null);
         this.binding.addProduct.setText(this.getString(R.string.add_product));
         this.binding.llDelete.setVisibility(8);
         this.binding.deleteSpacer.setVisibility(8);
         this.binding.toolTitle.setText(this.getString(R.string.add_product));
      }

   }

   private void uploadProductImage(Uri var1, int var2, int var3) {
      this.appendProductImage(var1.toString());
      this.productImagesMap.put(var1.toString(), "");
      Glide.with(this).asBitmap().load(var1).apply((new RequestOptions()).override(800)).listener(new 9(this, var1, var2, var3)).submit();
   }

   public void checkForRemoteConfig() {
      this.getFirebaseRemoteConfig().fetchAndActivate().addOnCompleteListener(this, new _$$Lambda$EditProductActivity$jbMu29pQqjznZYZhx432hh8vP8s(this));
   }

   public void createNewProduct() {
      if (!this.validateForm()) {
         this.binding.addProduct.setBusy(false);
      } else {
         AddProductRequest var1 = new AddProductRequest();
         var1.name = this.binding.etProductName.getText().toString();
         boolean var2 = TextUtils.isEmpty(this.binding.etSellingPrice.getText());
         double var3 = 0.0D;
         double var5;
         if (!var2) {
            var5 = Double.parseDouble(this.binding.etSellingPrice.getText().toString().replace(",", ""));
         } else {
            var5 = 0.0D;
         }

         var1.baseCost = var5;
         var5 = var3;
         if (!TextUtils.isEmpty(this.binding.etMrp.getText())) {
            var5 = Double.parseDouble(this.binding.etMrp.getText().toString().replace(",", ""));
         }

         var1.originalCost = var5;
         var1.baseQty = this.binding.etUnit.getText().toString();
         var1.description = this.binding.etDesc.getText().toString();

         try {
            if (this.uploadingCount < this.uploadingTotal) {
               Toast.makeText(this, "Please wait. Uploading images...", 0).show();
               return;
            }

            this.prepareProductImagesPayload(var1);
         } catch (JSONException var8) {
            var8.printStackTrace();
         }

         if (TextUtils.isEmpty(var1.image)) {
            var1.image = "https://dukaan-api.1kg.me/static/images/category-def.jpg";
         }

         if (!TextUtils.isEmpty(this.binding.etQuantity.getText())) {
            var1.baseQty = String.format("%s %s", this.binding.etQuantity.getText().toString(), var1.baseQty);
         } else {
            var1.baseQty = String.format("%s %s", "1", var1.baseQty);
         }

         Category var7 = this.category;
         if (var7 != null) {
            var1.category = var7.realmGet$id();
         }

         var1.businessId = this.business.realmGet$id();
         this.mViewModel.addProduct(this.business.realmGet$id(), var1);
      }
   }

   public FirebaseRemoteConfig getFirebaseRemoteConfig() {
      if (this.mFirebaseRemoteConfig == null) {
         this.mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
         FirebaseRemoteConfigSettings var1 = (new Builder()).setMinimumFetchIntervalInSeconds(5L).build();
         this.mFirebaseRemoteConfig.setConfigSettingsAsync(var1);
      }

      return this.mFirebaseRemoteConfig;
   }

   public int getLayoutId() {
      return activity_edit_product;
   }

   public Class<EditProductViewModel> getViewModel() {
      return EditProductViewModel.class;
   }

   public void menuItem(MenuItem var1) {
      this.binding.etUnit.setText(var1.getTitle());
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var1 == 222 && var2 == -1 && var3.getBooleanExtra("isCreated", false)) {
         Category var4 = this.mViewModel.getDataManager().getCategory();
         this.category = var4;
         if (var4 != null) {
            this.binding.etCategory.setText(this.category.realmGet$name());
         }

         this.mViewModel.getCategoryList(this.business.realmGet$id(), this.pagination);
      }

      if (var1 == 100 && var2 == -1) {
         this.handleUCropResult(var3);
      }

      if (var1 == 101 && var2 == -1) {
         Timber.d(var3.getStringExtra("variants"), new Object[0]);
         var1 = var3.getIntExtra("variant_size", 0);
         if (var1 > 0) {
            this.binding.lblAddVariant.setText(String.format("%d variant(s)", var1));
            this.finalVariantString = var3.getStringExtra("variants");
            this.binding.lblAddVariant.setVisibility(0);
         }
      }

   }

   public void onApiError(ErrorResponse var1) {
      this.binding.addProduct.setBusy(false);
      ModalDialogs.showUnknownError(this);
   }

   @Subscribe(
      threadMode = ThreadMode.MAIN
   )
   public void onAppEvent(AppEvent var1) {
      if (var1.type == AppEvent.INTERNET_CONNECTION_CHECK && active) {
         this.binding.addProduct.setBusy(false);
      }

   }

   public void onCategoryListFetched(CategoryListResponse var1) {
      if (var1 != null && var1.getResults().size() > 0) {
         ArrayList var2;
         if (this.pagination == 1) {
            var2 = this.categoryArrayList;
            if (var2 != null) {
               var2.clear();
            }
         }

         var2 = this.categoryArrayList;
         if (var2 != null) {
            var2.addAll(var1.getResults());
            if (!TextUtils.isEmpty(var1.getNext())) {
               this.loading = true;
               ++this.pagination;
            }

            this.addProductCategoryListAdapter.notifyDataSetChanged();
         }
      }

   }

   protected void onCreate(Bundle var1, EditProductViewModel var2, ActivityEditProductBinding var3) {
      this.binding = var3;
      this.mViewModel = var2;
      var2.setNavigator(this);
      this.setSupportActionBar(var3.toolbar);
      this.enableToolbarUpNavigation();
      this.business = var2.getDataManager().getBusiness();
      var3.toolbar.setNavigationOnClickListener(new _$$Lambda$EditProductActivity$TMgC_T3G0wg89ERiQe_C4WeNzJo(this));
      Intent var5 = this.getIntent();
      this.isFromUpdate = var5.getBooleanExtra("Add", false);
      this.product = (Product)var5.getParcelableExtra("PRODUCT");
      if (var5.getParcelableExtra("Category") != null) {
         this.fromCategoriesModel = (Category)var5.getParcelableExtra("Category");
      }

      try {
         if (!var5.getBooleanExtra("local_variant", false)) {
            this.mViewModel.getVariants(this.product.getId());
         }
      } catch (Exception var4) {
         Timber.e(var4);
      }

      this.initUI();
      this.checkForRemoteConfig();
   }

   public void onProductDelete(DeleteProductResponse var1) {
      if (var1 != null) {
         Intent var2 = new Intent();
         var2.putExtra("refresh", true);
         this.setResult(-1, var2);
         this.finish();
      }

   }

   public void onProductImageAddClicked() {
      this.onProductImageClick();
   }

   public void onProductImageRemoved(int var1, String var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("VARIANT PRODUCT IMG REMOVE: ");
      var3.append(var2);
      Timber.d(var3.toString(), new Object[0]);
      this.productImagesMap.remove(var2);
      StringBuilder var4 = new StringBuilder();
      var4.append("VARIANT PRODUCT IMG AFTER REMOVE: ");
      var4.append(this.productImagesMap.toString());
      Timber.d(var4.toString(), new Object[0]);
      if (this.productImages.size() < 8) {
         this.mAdapter.enableAddImage();
      }

   }

   public void onProductImageUploadedToCloud(UploadImage var1, String var2, int var3, int var4) {
      StringBuilder var5 = new StringBuilder();
      var5.append("VARIANTS MULTI : ");
      var5.append(var3);
      var5.append(" : ");
      var5.append(this.imgArrayList.get(var3));
      Timber.d(var5.toString(), new Object[0]);
      this.productImagesMap.put(var2, var1.getData().getChildData().getFile());
      StringBuilder var6 = new StringBuilder();
      var6.append("VARIANTS MAP : ");
      var6.append(this.productImagesMap.toString());
      Timber.d(var6.toString(), new Object[0]);
      ++this.uploadingCount;
   }

   public void onProductUpdateResponse(EditProductResponse var1) {
      if (var1 != null) {
         this.binding.addProduct.setBusy(false);
         Intent var2 = new Intent();
         var2.putExtra("refresh", true);
         this.setResult(-1, var2);
         this.finish();
      }

   }

   public void onStart() {
      super.onStart();
      active = true;
   }

   public void onStop() {
      super.onStop();
      active = false;
   }

   public void productAdded(AddProductResponse var1) {
      this.binding.addProduct.setBusy(false);
      if (var1 != null) {
         Business var2 = this.business;
         if (var2 != null) {
            CleverTapUtils.trackProductAdded(this, var2.realmGet$id());
            (new BranchEvent("Product Added")).addCustomDataProperty("phone", this.business.realmGet$mobile()).addCustomDataProperty("link", this.business.realmGet$link()).setCustomerEventAlias("product_added").logEvent(this);
         }

         Intent var3 = new Intent();
         var3.putExtra("refresh", true);
         var3.putExtra("productAdded", true);
         this.setResult(-1, var3);
         this.finish();
      }

   }

   public void selectCategoryItem(Category var1) {
      this.category = var1;
      if (var1 != null && !TextUtils.isEmpty(var1.realmGet$name())) {
         this.binding.etCategory.setText(var1.realmGet$name());
      }

      PopupWindow var2 = this.popUp;
      if (var2 != null) {
         var2.dismiss();
      }

   }

   public void updateProductDetails() {
      this.binding.addProduct.setBusy(true);
      if (!this.validateForm()) {
         this.binding.addProduct.setBusy(false);
      } else {
         EditProductRequest var1 = new EditProductRequest();
         var1.name = this.binding.etProductName.getText().toString().trim();
         if (!TextUtils.isEmpty(this.binding.etSellingPrice.getText())) {
            String var2 = this.binding.etSellingPrice.getText().toString().trim();
            if (var2.contains("₹")) {
               var1.baseCost = Double.parseDouble(var2.replace("₹", "").trim().replace(",", "").trim());
            } else {
               var1.baseCost = Double.parseDouble(this.binding.etSellingPrice.getText().toString().trim().replace(",", "").trim());
            }
         }

         if (!TextUtils.isEmpty(this.binding.etMrp.getText())) {
            var1.originalCost = Double.parseDouble(this.binding.etMrp.getText().toString().trim().replace(",", ""));
            if (var1.baseCost == 0.0D) {
               var1.baseCost = var1.originalCost;
            }
         }

         try {
            if (this.uploadingCount < this.uploadingTotal) {
               Toast.makeText(this, "Please wait. Uploading images...", 0).show();
               return;
            }

            this.prepareProductImagesPayload(var1);
         } catch (JSONException var3) {
            var3.printStackTrace();
         }

         var1.setHidden(this.product.isHidden());
         var1.baseQty = this.binding.etUnit.getText().toString().trim();
         if (!TextUtils.isEmpty(this.binding.etDesc.getText().toString().trim())) {
            var1.description = this.binding.etDesc.getText().toString().trim();
         } else {
            var1.description = "";
         }

         Category var4 = this.category;
         if (var4 != null) {
            var1.category = var4.realmGet$id();
         } else {
            var1.category = this.product.getCategoryId();
         }

         var1.baseQty = String.format("%s %s", this.getQuantityInput(), var1.baseQty);
         this.mViewModel.updateProduct(var1, this.product.getId());
      }
   }

   public boolean validCategoryName() {
      return this.binding.etCategory.getText().toString().trim().isEmpty() ^ true;
   }

   public boolean validPriceName() {
      return this.binding.etMrp.getText().toString().trim().isEmpty() ^ true;
   }

   public boolean validProductName() {
      return this.binding.etProductName.getText().toString().trim().isEmpty() ^ true;
   }

   public boolean validateForm() {
      boolean var1 = TextUtils.isEmpty(this.binding.etSellingPrice.getText());
      String var2 = null;
      String var3;
      if (var1) {
         var3 = null;
      } else {
         var3 = this.binding.etSellingPrice.getText().toString().replace(",", "");
      }

      if (!TextUtils.isEmpty(this.binding.etMrp.getText())) {
         var2 = this.binding.etMrp.getText().toString().replace(",", "");
      }

      boolean var4 = false;

      try {
         if (!TextUtils.isEmpty(var3) && !TextUtils.isEmpty(var2) && Double.parseDouble(var3) > Double.parseDouble(var2)) {
            this.showSellingPriceError();
            return false;
         }
      } catch (Exception var5) {
         Timber.e(var5);
      }

      this.hideSellingPriceError();
      var1 = var4;
      if (this.validProductName()) {
         var1 = var4;
         if (this.validPriceName()) {
            var1 = var4;
            if (this.validCategoryName()) {
               var1 = true;
            }
         }
      }

      return var1;
   }

   public void variantsFound(List<Variant> var1) {
      JSONArray var2 = new JSONArray();

      for(int var3 = 0; var3 < var1.size(); ++var3) {
         if (((Variant)var1.get(var3)).realmGet$type() != 0) {
            JSONObject var4 = new JSONObject();

            try {
               var4.put("type", ((Variant)var1.get(var3)).realmGet$type());
               var4.put("value", ((Variant)var1.get(var3)).realmGet$value());
               var2.put(var4);
            } catch (JSONException var5) {
               var5.printStackTrace();
            }
         }
      }

      if (var2.length() > 0) {
         this.binding.lblAddVariant.setText(String.format("%s variants", var2.length()));
         this.finalVariantString = var2.toString();
         this.binding.lblAddVariant.setVisibility(0);
      }

   }

   public void yesMakeIt() {
      Product var1 = this.product;
      if (var1 != null) {
         this.mViewModel.deleteProduct(var1.getId());
      }

   }
}
