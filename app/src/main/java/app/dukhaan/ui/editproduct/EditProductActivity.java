/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcelable
 *  android.text.Editable
 *  android.text.Html
 *  android.text.InputFilter
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.WindowManager
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.LinearLayout
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.Space
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.appcompat.widget.Toolbar
 *  androidx.core.content.ContextCompat
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.FragmentActivity
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ItemDecoration
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$OnScrollListener
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.data.model.Product
 *  app.dukhaan.data.model.Variant
 *  app.dukhaan.databinding.ActivityEditProductBinding
 *  app.dukhaan.network.model.AddProductRequest
 *  app.dukhaan.network.model.Category
 *  app.dukhaan.network.model.EditProductRequest
 *  app.dukhaan.ui.editproduct.-$
 *  app.dukhaan.ui.editproduct.-$$Lambda
 *  app.dukhaan.ui.editproduct.-$$Lambda$EditProductActivity
 *  app.dukhaan.ui.editproduct.-$$Lambda$EditProductActivity$jbMu29pQqjznZYZhx432hh8vP8s
 *  app.dukhaan.ui.editproduct.EditProductActivity$5
 *  app.dukhaan.ui.editproduct.EditProductActivity$6
 *  app.dukhaan.ui.editproduct.EditProductActivity$7
 *  app.dukhaan.ui.editproduct.EditProductActivity$8
 *  app.dukhaan.ui.editproduct.EditProductActivity$9
 *  app.dukhaan.ui.editproduct.EditProductNavigator
 *  app.dukhaan.ui.editproduct.EditProductViewModel
 *  app.dukhaan.ui.products.AddProductCategoryListAdapter
 *  app.dukhaan.ui.views.products.ProductImagesListAdapter
 *  app.dukhaan.ui.views.units.ProductUnitAdapter
 *  app.dukhaan.util.RecyclerViewItemDecoration
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.RequestBuilder
 *  com.bumptech.glide.request.BaseRequestOptions
 *  com.bumptech.glide.request.FutureTarget
 *  com.bumptech.glide.request.RequestListener
 *  com.bumptech.glide.request.RequestOptions
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfig
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings$Builder
 *  com.karumi.dexter.Dexter
 *  io.branch.referral.util.BranchEvent
 *  io.realm.RealmList
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 *  timber.log.Timber
 */
package app.dukhaan.ui.editproduct;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
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
import app.dukhaan.ui.addvariant.AddVariantActivity;
import app.dukhaan.ui.createcategory.CreateCategoryActivity;
import app.dukhaan.ui.editproduct.-$;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductActivity$-qfVTWZiRspKiKquTx3AMmGnhf4;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductActivity$0iFVauTzYJh1R5aFt7QVL3Gq_-M;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductActivity$BP6P3JxBVbIcJjb4Es7w_i4y5KQ;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductActivity$IQ2qRjwMTztOt44l0alOCqZQWCI;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductActivity$TMgC_T3G0wg89ERiQe-C4WeNzJo;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductActivity$WC20narYYTt_u8lEgWjLfzepjTU;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductActivity$eoBroNNh-IfdEsic0wHanIAckFc;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductActivity$o7Ngdb4y8y_rvmYod0sTfm2CjWA;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductActivity$pc0U14r8SHMl2gJxNhZX3s79iZQ;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductActivity$uqVGB8OrT1X2XIWHA0EToRjdcbQ;
import app.dukhaan.ui.editproduct.EditProductActivity;
import app.dukhaan.ui.editproduct.EditProductNavigator;
import app.dukhaan.ui.editproduct.EditProductViewModel;
import app.dukhaan.ui.imagepicker.MultiImagePickerActivity;
import app.dukhaan.ui.products.AddProductCategoryListAdapter;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.ui.views.SpinnerImage;
import app.dukhaan.ui.views.customdialog.IdialogItemClickListner;
import app.dukhaan.ui.views.products.ProductImagesListAdapter;
import app.dukhaan.ui.views.units.ProductUnitAdapter;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.DialogType;
import app.dukhaan.util.IpopUpMenuItem;
import app.dukhaan.util.ModalDialogs;
import app.dukhaan.util.PricingUtils;
import app.dukhaan.util.RecyclerViewItemDecoration;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.DexterBuilder;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import io.branch.referral.util.BranchEvent;
import io.realm.RealmList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

public class EditProductActivity
extends BaseActivity<ActivityEditProductBinding, EditProductViewModel>
implements IpopUpMenuItem,
EditProductNavigator,
AddProductCategoryListAdapter.categoryItemClick,
IdialogItemClickListner,
ProductImagesListAdapter.ProductImagesListAdapterListener {
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
    private InputFilter productNameFilter = new InputFilter(this){
        final /* synthetic */ EditProductActivity this$0; (view) -> {
        {
            this.this$0 = editProductActivity;
        }

        public CharSequence filter(CharSequence charSequence, int n, int n2, android.text.Spanned spanned, int n3, int n4) {
            if (charSequence != null) {
                String string2 = EditProductActivity.access$000(this.this$0);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append((Object)charSequence);
                if (string2.contains((CharSequence)stringBuilder.toString())) {
                    return "";
                }
            }
            return null;
        }
    };
    private int totalItemCount;
    private int uploadingCount = 0;
    private int uploadingTotal = 0;
    private int visibleItemCount;

    static /* synthetic */ String access$000(EditProductActivity editProductActivity) { (view) -> {
        return editProductActivity.blockCharacterSet;
    }

    static /* synthetic */ void access$100(EditProductActivity editProductActivity) { (view) -> {
        editProductActivity.previewUnitDescription();
    }

    static /* synthetic */ int access$1000(EditProductActivity editProductActivity) { (view) -> {
        return editProductActivity.totalItemCount;
    }

    static /* synthetic */ int access$1002(EditProductActivity editProductActivity, int n) { (view) -> {
        editProductActivity.totalItemCount = n;
        return n;
    }

    static /* synthetic */ int access$1100(EditProductActivity editProductActivity) { (view) -> {
        return editProductActivity.pastVisibleItems;
    }

    static /* synthetic */ int access$1102(EditProductActivity editProductActivity, int n) { (view) -> {
        editProductActivity.pastVisibleItems = n;
        return n;
    }

    static /* synthetic */ boolean access$1200(EditProductActivity editProductActivity) { (view) -> {
        return editProductActivity.loading;
    }

    static /* synthetic */ boolean access$1202(EditProductActivity editProductActivity, boolean bl) { (view) -> {
        editProductActivity.loading = bl;
        return bl;
    }

    static /* synthetic */ Business access$1300(EditProductActivity editProductActivity) { (view) -> {
        return editProductActivity.business;
    }

    static /* synthetic */ int access$1400(EditProductActivity editProductActivity) { (view) -> {
        return editProductActivity.pagination;
    }

    static /* synthetic */ EditProductViewModel access$1500(EditProductActivity editProductActivity) { (view) -> {
        return editProductActivity.mViewModel;
    }

    static /* synthetic */ void access$200(EditProductActivity editProductActivity) { (view) -> {
        editProductActivity.previewCostDescription();
    }

    static /* synthetic */ void access$300(EditProductActivity editProductActivity) { (view) -> {
        editProductActivity.showImagePickerOptions();
    }

    static /* synthetic */ void access$400(EditProductActivity editProductActivity) { (view) -> {
        editProductActivity.launchCameraIntent();
    }

    static /* synthetic */ void access$500(EditProductActivity editProductActivity) { (view) -> {
        editProductActivity.launchGalleryIntent();
    }

    static /* synthetic */ PopupWindow access$600(EditProductActivity editProductActivity) { (view) -> {
        return editProductActivity.popUp;
    }

    static /* synthetic */ ActivityEditProductBinding access$700(EditProductActivity editProductActivity) { (view) -> {
        return editProductActivity.binding;
    }

    static /* synthetic */ int access$800(EditProductActivity editProductActivity) { (view) -> {
        return editProductActivity.visibleItemCount;
    }

    static /* synthetic */ int access$802(EditProductActivity editProductActivity, int n) { (view) -> {
        editProductActivity.visibleItemCount = n;
        return n;
    }

    static /* synthetic */ LinearLayoutManager access$900(EditProductActivity editProductActivity) { (view) -> {
        return editProductActivity.mLayoutManager;
    }

    private void appendProductImage(String string2) {
        this.productImages.add(0, (Object)string2);
        this.mAdapter.notifyItemInserted(0);
        this.binding.recyclerview.scrollToPosition(0);
        if (this.productImages.size() == 8) {
            this.mAdapter.disableAddImage();
        }
    }

    /*
     * Exception decompiling
     */
    private int getQuantityInput() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    private String getQuantityUnit() {
        Product product = this.product;
        if (product != null && product.getBaseQty() != null) {
            String[] arrstring = this.product.getBaseQty().split("\\s+");
            if (arrstring.length > 1) {
                return arrstring[arrstring.length - 1];
            }
            return this.product.getBaseQty();
        }
        return "";
    }

    private String getQuantityValue() {
        Product product = this.product;
        String string2 = "1";
        if (product != null) {
            if (product.getBaseQty() == null) {
                return string2;
            }
            String[] arrstring = this.product.getBaseQty().split("\\s+");
            if (arrstring.length > 1 && this.isInteger(arrstring[0])) {
                string2 = arrstring[0];
            }
        }
        return string2;
    }

    private String getUnitPlural(String string2) {
        try {
            int n = this.getResources().getIdentifier(string2, "plurals", this.getPackageName());
            string2 = this.getResources().getQuantityString(n, this.getQuantityInput());
        }
        catch (Resources.NotFoundException notFoundException) {}
        return string2;
    }

    private void handleUCropResult(Intent intent) {
        this.imgArrayList = intent.getParcelableArrayListExtra("path");
        int n = 8 - this.productImagesMap.size();
        int n2 = this.imgArrayList.size();
        if (n2 < n) {
            n = n2;
        }
        this.uploadingTotal = n;
        for (int i = 0; i < n; ++i) {
            this.uploadProductImage((Uri)this.imgArrayList.get(i), i, this.imgArrayList.size());
        }
        if (intent == null) {
            Toast.makeText((Context)this.getApplicationContext(), (CharSequence)this.getString(2131951832), (int)1).show();
        }
    }

    private void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)activity.getSystemService("input_method");
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View((Context)activity);
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void hideSellingPriceError() {
        this.binding.etSellingPrice.setBackgroundDrawable(this.getResources().getDrawable(2131230951));
        this.binding.etMrp.setBackgroundDrawable(this.getResources().getDrawable(2131230951));
        this.binding.priceError.setVisibility(8);
        this.binding.costDescription.setVisibility(0);
    }

    private void initProductImages() {
        Product product;
        Product product2;
        if (this.productImages == null) {
            this.productImages = new ArrayList();
        }
        if (this.productImagesMap == null) {
            this.productImagesMap = new LinkedHashMap();
        }
        if ((product = this.product) != null && !TextUtils.isEmpty((CharSequence)product.getImage()) && !this.product.getImage().equalsIgnoreCase("https://dukaan-api.1kg.me/static/images/category-def.jpg")) {
            this.productImages.add((Object)this.product.getImage());
            this.productImagesMap.put((Object)this.product.getImage(), (Object)this.product.getImage());
        }
        if ((product2 = this.product) != null && product2.realmGet$variants() != null && this.product.realmGet$variants().size() > 0) {
            for (String string2 : this.product.realmGet$variants()) {
                this.productImages.add((Object)string2);
                this.productImagesMap.put((Object)string2, (Object)string2);
            }
        }
        this.mAdapter = new ProductImagesListAdapter((ProductImagesListAdapter.ProductImagesListAdapterListener)this, this.productImages);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context)this, 0, false);
        this.binding.recyclerview.addItemDecoration((RecyclerView.ItemDecoration)new RecyclerViewItemDecoration(AppUtils.dpToPx(12), 0));
        this.binding.recyclerview.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.binding.recyclerview.setAdapter((RecyclerView.Adapter)this.mAdapter);
        if (this.productImagesMap.keySet().size() == 8) {
            this.mAdapter.disableAddImage();
        }
    }

    private void initUI() {
        this.binding.etQuantity.setText((CharSequence)this.getQuantityValue());
        this.binding.etProductName.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
                if (EditProductActivity.this.validateForm()) {
                    EditProductActivity.access$700((EditProductActivity)EditProductActivity.this).addProduct.setEnabled(true);
                    return;
                }
                EditProductActivity.access$700((EditProductActivity)EditProductActivity.this).addProduct.setEnabled(false);
            }
        });
        this.binding.etSellingPrice.addTextChangedListener(new /* invalid duplicate definition of identical inner class */);
        this.binding.etMrp.addTextChangedListener(new /* invalid duplicate definition of identical inner class */);
        this.binding.etDesc.addTextChangedListener(new /* invalid duplicate definition of identical inner class */);
        this.binding.etCategory.addTextChangedListener(new /* invalid duplicate definition of identical inner class */);
        AppCompatEditText appCompatEditText = this.binding.etProductName;
        InputFilter[] arrinputFilter = new InputFilter[]{this.productNameFilter};
        appCompatEditText.setFilters(arrinputFilter);
        if (AppPref.getInstance().getCurrency() != null) {
            this.currency = AppUtils.getCurrencySymbol(AppPref.getInstance().getCurrency());
        }
        this.drawable = !TextUtils.isEmpty((CharSequence)this.currency) ? AppUtils.getSymbol((Context)this, this.currency, this.binding.etSellingPrice.getTextSize(), ContextCompat.getColor((Context)this, (int)2131099722)) : AppUtils.getSymbol((Context)this, "\u20b9", this.binding.etSellingPrice.getTextSize(), ContextCompat.getColor((Context)this, (int)2131099722));
        this.binding.etSellingPrice.setCompoundDrawablesWithIntrinsicBounds(this.drawable, null, null, null);
        this.binding.etMrp.setCompoundDrawablesWithIntrinsicBounds(this.drawable, null, null, null);
        MultiImagePickerActivity.clearCache((Context)this);
        this.binding.etCategory.setOnClickListener((View.OnClickListener)new -$$Lambda$EditProductActivity$-qfVTWZiRspKiKquTx3AMmGnhf4(this));
        this.binding.etUnit.setOnClickListener((View.OnClickListener)new -$$Lambda$EditProductActivity$eoBroNNh-IfdEsic0wHanIAckFc(this));
        this.binding.llDelete.setOnClickListener((View.OnClickListener)new -$$Lambda$EditProductActivity$BP6P3JxBVbIcJjb4Es7w_i4y5KQ(this));
        this.binding.addProduct.setOnClickListener(new -$$Lambda$EditProductActivity$pc0U14r8SHMl2gJxNhZX3s79iZQ(this));
        this.binding.etQuantity.addTextChangedListener(new TextWatcher(this){
            final /* synthetic */ EditProductActivity this$0; (view) -> {
            {
                this.this$0 = editProductActivity;
            }

            public void afterTextChanged(Editable editable) {
                EditProductActivity.access$100(this.this$0);
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }
        });
        this.binding.etMrp.addTextChangedListener(new TextWatcher(this){
            final /* synthetic */ EditProductActivity this$0; (view) -> {
            {
                this.this$0 = editProductActivity;
            }

            public void afterTextChanged(Editable editable) {
                EditProductActivity.access$200(this.this$0);
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }
        });
        this.binding.etSellingPrice.addTextChangedListener(new TextWatcher(this){
            final /* synthetic */ EditProductActivity this$0; (view) -> {
            {
                this.this$0 = editProductActivity;
            }

            public void afterTextChanged(Editable editable) {
                EditProductActivity.access$200(this.this$0);
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }
        });
        this.binding.btnAddVariant.setOnClickListener((View.OnClickListener)new -$$Lambda$EditProductActivity$WC20narYYTt_u8lEgWjLfzepjTU(this));
        this.binding.lblAddVariant.setOnClickListener((View.OnClickListener)new -$$Lambda$EditProductActivity$o7Ngdb4y8y_rvmYod0sTfm2CjWA(this));
        this.initProductImages();
        this.updateButtonStatus();
        this.previewUnitDescription();
    }

    private boolean isInteger(String string2) {
        try {
            Integer.parseInt((String)string2);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    private void launchCameraIntent() {
        Intent intent = new Intent((Context)this, MultiImagePickerActivity.class);
        intent.putExtra("image_picker_option", 0);
        intent.putExtra("lock_aspect_ratio", true);
        intent.putExtra("aspect_ratio_x", 1);
        intent.putExtra("aspect_ratio_Y", 1);
        intent.putExtra("set_bitmap_max_width_height", true);
        intent.putExtra("max_width", 1000);
        intent.putExtra("max_height", 1000);
        this.startActivityForResult(intent, 100);
    }

    private void launchGalleryIntent() {
        Intent intent = new Intent((Context)this, MultiImagePickerActivity.class);
        intent.putExtra("image_picker_option", 1);
        intent.putExtra("lock_aspect_ratio", true);
        intent.putExtra("aspect_ratio_x", 1);
        intent.putExtra("aspect_ratio_Y", 1);
        this.startActivityForResult(intent, 100);
    }

    private void onProductImageClick() {
        Dexter.withContext((Context)this).withPermissions("android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE").withListener((MultiplePermissionsListener)new 5(this)).check();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void prepareProductImagesPayload(BaseCreateProduct baseCreateProduct) throws JSONException {
        JSONArray jSONArray;
        block10 : {
            JSONArray jSONArray2;
            if (baseCreateProduct == null) {
                return;
            }
            LinkedHashMap<String, String> linkedHashMap = this.productImagesMap;
            if (linkedHashMap == null) {
                return;
            }
            Object[] arrobject = new Object[]{linkedHashMap, this.productImages};
            Timber.e((String)"Products image map: %s | %s", (Object[])arrobject);
            jSONArray = new JSONArray();
            if (baseCreateProduct.variants == null) {
                baseCreateProduct.variants = new ArrayList();
            }
            Iterator iterator = this.productImagesMap.entrySet().iterator();
            int n = 0;
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                if (n == 0) {
                    baseCreateProduct.image = (String)entry.getValue();
                } else if (!TextUtils.isEmpty((CharSequence)((CharSequence)entry.getValue()))) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("VARIANTS 0 : ");
                    stringBuilder.append((String)entry.getValue());
                    Timber.d((String)stringBuilder.toString(), (Object[])new Object[0]);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", (Object)"0");
                    jSONObject.put("value", entry.getValue());
                    jSONArray.put((Object)jSONObject);
                }
                ++n;
            }
            try {
                jSONArray2 = new JSONArray(this.finalVariantString);
            }
            catch (Exception exception) {
                Timber.e((Throwable)exception);
                break block10;
            }
            for (int i = 0; i < jSONArray2.length(); ++i) {
                jSONArray.put(jSONArray2.get(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VARIANTS JSON: ");
        stringBuilder.append(this.finalVariantString);
        Timber.d((String)stringBuilder.toString(), (Object[])new Object[0]);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("VARIANTS FINAL: ");
        stringBuilder2.append(jSONArray.toString());
        Timber.d((String)stringBuilder2.toString(), (Object[])new Object[0]);
        baseCreateProduct.variants.add((Object)jSONArray.toString());
    }

    private void previewCostDescription() {
        if (TextUtils.isEmpty((CharSequence)this.binding.etMrp.getText())) {
            return;
        }
        if (TextUtils.isEmpty((CharSequence)this.binding.etSellingPrice.getText())) {
            TextView textView = this.binding.costDescription;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Price: \u20b9");
            stringBuilder.append((Object)this.binding.etMrp.getText());
            textView.setText((CharSequence)stringBuilder.toString());
            return;
        }
        TextView textView = this.binding.costDescription;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Price: \u20b9");
        stringBuilder.append((Object)this.binding.etSellingPrice.getText());
        stringBuilder.append(" <strike>\u20b9");
        stringBuilder.append((Object)this.binding.etMrp.getText());
        stringBuilder.append("</strike >");
        textView.setText((CharSequence)Html.fromHtml((String)stringBuilder.toString()));
    }

    private void previewUnitDescription() {
        if (TextUtils.isEmpty((CharSequence)this.binding.etQuantity.getText())) {
            TextView textView = this.binding.unitDescription;
            Object[] arrobject = new Object[]{"1", this.getUnitPlural(this.binding.etUnit.getText().toString())};
            textView.setText((CharSequence)this.getString(2131952010, arrobject));
            return;
        }
        TextView textView = this.binding.unitDescription;
        Object[] arrobject = new Object[]{this.binding.etQuantity.getText().toString(), this.getUnitPlural(this.binding.etUnit.getText().toString())};
        textView.setText((CharSequence)this.getString(2131952010, arrobject));
        this.binding.unitDescription.setVisibility(0);
    }

    private void showCategoryList() {
        ArrayList arrayList;
        LinearLayoutManager linearLayoutManager;
        AddProductCategoryListAdapter addProductCategoryListAdapter;
        PopupWindow popupWindow;
        this.mViewModel.getCategoryList(this.business.realmGet$id(), this.pagination);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int n = displayMetrics.widthPixels;
        View view = LayoutInflater.from((Context)this).inflate(2131558601, null, false);
        this.popUp = popupWindow = new PopupWindow(view, n, -2, false);
        popupWindow.setTouchable(true);
        this.popUp.setFocusable(true);
        this.popUp.setOutsideTouchable(true);
        if (Build.VERSION.SDK_INT >= 21) {
            this.popUp.setElevation(3.0f);
        }
        this.popUp.showAsDropDown((View)this.binding.etCategory);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(2131362416);
        TextView textView = (TextView)view.findViewById(2131362138);
        this.categoryArrayList = arrayList = new ArrayList();
        this.addProductCategoryListAdapter = addProductCategoryListAdapter = new AddProductCategoryListAdapter((List)arrayList);
        addProductCategoryListAdapter.setCategoryItemClick((AddProductCategoryListAdapter.categoryItemClick)this);
        recyclerView.setAdapter((RecyclerView.Adapter)this.addProductCategoryListAdapter);
        this.mLayoutManager = linearLayoutManager = new LinearLayoutManager((Context)this);
        recyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        recyclerView.addOnScrollListener((RecyclerView.OnScrollListener)new 8(this));
        textView.setOnClickListener((View.OnClickListener)new -$$Lambda$EditProductActivity$uqVGB8OrT1X2XIWHA0EToRjdcbQ(this));
        this.popUp.setOnDismissListener((PopupWindow.OnDismissListener)new -$$Lambda$EditProductActivity$IQ2qRjwMTztOt44l0alOCqZQWCI(this));
    }

    private void showImagePickerOptions() {
        MultiImagePickerActivity.showImagePickerOptions((Context)this, new 6(this));
    }

    private void showProductUnitsDropdown() {
        LinearLayoutManager linearLayoutManager;
        PopupWindow popupWindow;
        this.hideKeyboard((Activity)this);
        List list = Arrays.asList((Object[])this.getResources().getStringArray(2130903040));
        List<String> list2 = this.extraUnitsArray;
        if (list2 != null) {
            Timber.d((String)list2.toString(), (Object[])new Object[0]);
            ArrayList arrayList = new ArrayList((Collection)list);
            arrayList.addAll(this.extraUnitsArray);
            Timber.d((String)arrayList.toString(), (Object[])new Object[0]);
            list = arrayList;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int n = this.binding.etUnit.getWidth();
        View view = LayoutInflater.from((Context)this).inflate(2131558604, null, false);
        this.popUp = popupWindow = new PopupWindow(view, n + AppUtils.dpToPx(32), -2, false);
        popupWindow.setTouchable(true);
        this.popUp.setFocusable(true);
        this.popUp.setOutsideTouchable(true);
        if (Build.VERSION.SDK_INT >= 21) {
            this.popUp.setElevation(3.0f);
        }
        this.popUp.showAsDropDown((View)this.binding.etUnit);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(2131362414);
        recyclerView.setAdapter((RecyclerView.Adapter)new ProductUnitAdapter(list, (ProductUnitAdapter.UnitItemClickListener)new 7(this, list)));
        this.mLayoutManager = linearLayoutManager = new LinearLayoutManager((Context)this);
        recyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.popUp.setOnDismissListener((PopupWindow.OnDismissListener)new -$$Lambda$EditProductActivity$0iFVauTzYJh1R5aFt7QVL3Gq_-M(this));
    }

    private void showSellingPriceError() {
        this.binding.etSellingPrice.setBackgroundDrawable(this.getResources().getDrawable(2131230952));
        this.binding.etMrp.setBackgroundDrawable(this.getResources().getDrawable(2131230952));
        this.binding.priceError.setVisibility(0);
        this.binding.costDescription.setVisibility(8);
    }

    private void updateButtonStatus() {
        if (this.fromCategoriesModel != null) {
            this.binding.etCategory.setText((CharSequence)this.fromCategoriesModel.realmGet$name());
            this.category = this.fromCategoriesModel;
        }
        if (this.isFromUpdate) {
            this.binding.addProduct.setText(this.getString(2131952012));
            this.binding.llDelete.setVisibility(0);
            this.binding.deleteSpacer.setVisibility(0);
            this.binding.toolTitle.setText((CharSequence)this.getString(2131952014));
            if (this.product != null) {
                this.binding.etUnit.setText((CharSequence)this.getQuantityUnit());
                this.binding.etProductName.setText((CharSequence)this.product.getName());
                if (this.product.getBaseCost() > 0.0 && this.product.getBaseCost() < this.product.getOriginalCost()) {
                    this.binding.etSellingPrice.setText((CharSequence)PricingUtils.formatPrice(this.product.getBaseCost()));
                }
                if (this.product.getOriginalCost() > 0.0) {
                    this.binding.etMrp.setText((CharSequence)PricingUtils.formatPrice(this.product.getOriginalCost()));
                }
                AppCompatEditText appCompatEditText = this.binding.etDesc;
                String string2 = this.product.getDescription();
                String string3 = "";
                String string4 = string2 == null ? string3 : this.product.getDescription();
                appCompatEditText.setText((CharSequence)string4);
                AppCompatEditText appCompatEditText2 = this.binding.etCategory;
                if (this.product.getCategoryName() != null) {
                    string3 = this.product.getCategoryName();
                }
                appCompatEditText2.setText((CharSequence)string3);
                return;
            }
        } else {
            this.binding.etSellingPrice.setCompoundDrawablesWithIntrinsicBounds(this.drawable, null, null, null);
            this.binding.addProduct.setText(this.getString(2131951652));
            this.binding.llDelete.setVisibility(8);
            this.binding.deleteSpacer.setVisibility(8);
            this.binding.toolTitle.setText((CharSequence)this.getString(2131951652));
        }
    }

    private void uploadProductImage(Uri uri, int n, int n2) {
        this.appendProductImage(uri.toString());
        this.productImagesMap.put((Object)uri.toString(), (Object)"");
        Glide.with((FragmentActivity)this).asBitmap().load(uri).apply(new RequestOptions().override(800)).listener((RequestListener)new 9(this, uri, n, n2)).submit();
    }

    public void checkForRemoteConfig() {
        this.getFirebaseRemoteConfig().fetchAndActivate().addOnCompleteListener((Activity)this, (OnCompleteListener)new -$.Lambda.EditProductActivity.jbMu29pQqjznZYZhx432hh8vP8s(this));
    }

    public void createNewProduct() {
        if (!this.validateForm()) {
            this.binding.addProduct.setBusy(false);
            return;
        }
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.name = this.binding.etProductName.getText().toString();
        boolean bl = TextUtils.isEmpty((CharSequence)this.binding.etSellingPrice.getText());
        double d = 0.0;
        double d2 = !bl ? Double.parseDouble((String)this.binding.etSellingPrice.getText().toString().replace((CharSequence)",", (CharSequence)"")) : d;
        addProductRequest.baseCost = d2;
        if (!TextUtils.isEmpty((CharSequence)this.binding.etMrp.getText())) {
            d = Double.parseDouble((String)this.binding.etMrp.getText().toString().replace((CharSequence)",", (CharSequence)""));
        }
        addProductRequest.originalCost = d;
        addProductRequest.baseQty = this.binding.etUnit.getText().toString();
        addProductRequest.description = this.binding.etDesc.getText().toString();
        try {
            if (this.uploadingCount < this.uploadingTotal) {
                Toast.makeText((Context)this, (CharSequence)"Please wait. Uploading images...", (int)0).show();
                return;
            }
            this.prepareProductImagesPayload((BaseCreateProduct)addProductRequest);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        if (TextUtils.isEmpty((CharSequence)addProductRequest.image)) {
            addProductRequest.image = "https://dukaan-api.1kg.me/static/images/category-def.jpg";
        }
        if (!TextUtils.isEmpty((CharSequence)this.binding.etQuantity.getText())) {
            Object[] arrobject = new Object[]{this.binding.etQuantity.getText().toString(), addProductRequest.baseQty};
            addProductRequest.baseQty = String.format((String)"%s %s", (Object[])arrobject);
        } else {
            Object[] arrobject = new Object[]{"1", addProductRequest.baseQty};
            addProductRequest.baseQty = String.format((String)"%s %s", (Object[])arrobject);
        }
        Category category = this.category;
        if (category != null) {
            addProductRequest.category = category.realmGet$id();
        }
        addProductRequest.businessId = this.business.realmGet$id();
        this.mViewModel.addProduct(this.business.realmGet$id(), addProductRequest);
    }

    public FirebaseRemoteConfig getFirebaseRemoteConfig() {
        if (this.mFirebaseRemoteConfig == null) {
            this.mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
            FirebaseRemoteConfigSettings firebaseRemoteConfigSettings = new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(5L).build();
            this.mFirebaseRemoteConfig.setConfigSettingsAsync(firebaseRemoteConfigSettings);
        }
        return this.mFirebaseRemoteConfig;
    }

    @Override
    public int getLayoutId() {
        return 2131558438;
    }

    @Override
    public Class<EditProductViewModel> getViewModel() {
        return EditProductViewModel.class;
    }

    public /* synthetic */ void lambda$checkForRemoteConfig$10$EditProductActivity(Task task) { (view) -> {
        if (task.isSuccessful()) {
            this.extraUnitsArray = Arrays.asList((Object[])this.getFirebaseRemoteConfig().getString("qty_types").split(","));
        }
    }

    public /* synthetic */ void lambda$initUI$1$EditProductActivity(View view) { (view) -> {
        this.hideKeyboard((Activity)this);
        this.pagination = 1;
        this.showCategoryList();
        this.binding.spinnerChooseCategory.rotate();
    }

    public /* synthetic */ void lambda$initUI$2$EditProductActivity(View view) { (view) -> {
        this.showProductUnitsDropdown();
        this.binding.spinnerUnit.rotate();
    }

    public /* synthetic */ void lambda$initUI$3$EditProductActivity(View view) { (view) -> {
        ModalDialogs.showCustomDialog((Context)this, DialogType.DELETE, this);
    }

    public /* synthetic */ void lambda$initUI$4$EditProductActivity(View view) { (view) -> {
        if (this.isFromUpdate) {
            this.updateProductDetails();
            return;
        }
        this.createNewProduct();
    }

    public /* synthetic */ void lambda$initUI$5$EditProductActivity(View view) { (view) -> {
        Intent intent = new Intent((Context)this, AddVariantActivity.class);
        intent.putExtra("variants", this.finalVariantString);
        this.startActivityForResult(intent, 101);
    }

    public /* synthetic */ void lambda$initUI$6$EditProductActivity(View view) { (view) -> {
        Intent intent = new Intent((Context)this, AddVariantActivity.class);
        intent.putExtra("variants", this.finalVariantString);
        this.startActivityForResult(intent, 101);
    }

    public /* synthetic */ void lambda$onCreate$0$EditProductActivity(View view) { (view) -> {
        this.onBackPressed();
    }

    public /* synthetic */ void lambda$showCategoryList$8$EditProductActivity(View view) { (view) -> {
        this.startActivityForResult(new Intent((Context)this, CreateCategoryActivity.class), 222);
        this.popUp.dismiss();
    }

    public /* synthetic */ void lambda$showCategoryList$9$EditProductActivity() { (view) -> {
        this.popUp.dismiss();
        this.binding.spinnerChooseCategory.rotate();
        this.pagination = 1;
    }

    public /* synthetic */ void lambda$showProductUnitsDropdown$7$EditProductActivity() { (view) -> {
        this.popUp.dismiss();
        this.binding.spinnerUnit.rotate();
    }

    @Override
    public void menuItem(MenuItem menuItem) {
        this.binding.etUnit.setText(menuItem.getTitle());
    }

    protected void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n == 222 && n2 == -1 && intent.getBooleanExtra("isCreated", false)) {
            Category category;
            this.category = category = this.mViewModel.getDataManager().getCategory();
            if (category != null) {
                this.binding.etCategory.setText((CharSequence)this.category.realmGet$name());
            }
            this.mViewModel.getCategoryList(this.business.realmGet$id(), this.pagination);
        }
        if (n == 100 && n2 == -1) {
            this.handleUCropResult(intent);
        }
        if (n == 101 && n2 == -1) {
            Timber.d((String)intent.getStringExtra("variants"), (Object[])new Object[0]);
            int n3 = intent.getIntExtra("variant_size", 0);
            if (n3 > 0) {
                TextView textView = this.binding.lblAddVariant;
                Object[] arrobject = new Object[]{n3};
                textView.setText((CharSequence)String.format((String)"%d variant(s)", (Object[])arrobject));
                this.finalVariantString = intent.getStringExtra("variants");
                this.binding.lblAddVariant.setVisibility(0);
            }
        }
    }

    public void onApiError(ErrorResponse errorResponse) {
        this.binding.addProduct.setBusy(false);
        ModalDialogs.showUnknownError((Activity)this);
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onAppEvent(AppEvent appEvent) {
        if (appEvent.type == AppEvent.INTERNET_CONNECTION_CHECK && active) {
            this.binding.addProduct.setBusy(false);
        }
    }

    public void onCategoryListFetched(CategoryListResponse categoryListResponse) {
        if (categoryListResponse != null && categoryListResponse.getResults().size() > 0) {
            ArrayList<Category> arrayList;
            ArrayList<Category> arrayList2;
            if (this.pagination == 1 && (arrayList2 = this.categoryArrayList) != null) {
                arrayList2.clear();
            }
            if ((arrayList = this.categoryArrayList) != null) {
                arrayList.addAll(categoryListResponse.getResults());
                if (!TextUtils.isEmpty((CharSequence)categoryListResponse.getNext())) {
                    this.loading = true;
                    this.pagination = 1 + this.pagination;
                }
                this.addProductCategoryListAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onCreate(Bundle bundle, EditProductViewModel editProductViewModel, ActivityEditProductBinding activityEditProductBinding) {
        this.binding = activityEditProductBinding;
        this.mViewModel = editProductViewModel;
        editProductViewModel.setNavigator((Object)this);
        this.setSupportActionBar((Toolbar)activityEditProductBinding.toolbar);
        this.enableToolbarUpNavigation();
        this.business = editProductViewModel.getDataManager().getBusiness();
        activityEditProductBinding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$EditProductActivity$TMgC_T3G0wg89ERiQe-C4WeNzJo(this));
        Intent intent = this.getIntent();
        this.isFromUpdate = intent.getBooleanExtra("Add", false);
        this.product = (Product)intent.getParcelableExtra("PRODUCT");
        if (intent.getParcelableExtra("Category") != null) {
            this.fromCategoriesModel = (Category)intent.getParcelableExtra("Category");
        }
        try {
            if (!intent.getBooleanExtra("local_variant", false)) {
                this.mViewModel.getVariants(this.product.getId());
            }
        }
        catch (Exception exception) {
            Timber.e((Throwable)exception);
        }
        this.initUI();
        this.checkForRemoteConfig();
    }

    public void onProductDelete(DeleteProductResponse deleteProductResponse) {
        if (deleteProductResponse != null) {
            Intent intent = new Intent();
            intent.putExtra("refresh", true);
            this.setResult(-1, intent);
            this.finish();
        }
    }

    @Override
    public void onProductImageAddClicked() {
        this.onProductImageClick();
    }

    @Override
    public void onProductImageRemoved(int n, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VARIANT PRODUCT IMG REMOVE: ");
        stringBuilder.append(string2);
        Timber.d((String)stringBuilder.toString(), (Object[])new Object[0]);
        this.productImagesMap.remove((Object)string2);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("VARIANT PRODUCT IMG AFTER REMOVE: ");
        stringBuilder2.append(this.productImagesMap.toString());
        Timber.d((String)stringBuilder2.toString(), (Object[])new Object[0]);
        if (this.productImages.size() < 8) {
            this.mAdapter.enableAddImage();
        }
    }

    public void onProductImageUploadedToCloud(UploadImage uploadImage, String string2, int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VARIANTS MULTI : ");
        stringBuilder.append(n);
        stringBuilder.append(" : ");
        stringBuilder.append(this.imgArrayList.get(n));
        Timber.d((String)stringBuilder.toString(), (Object[])new Object[0]);
        this.productImagesMap.put((Object)string2, (Object)uploadImage.getData().getChildData().getFile());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("VARIANTS MAP : ");
        stringBuilder2.append(this.productImagesMap.toString());
        Timber.d((String)stringBuilder2.toString(), (Object[])new Object[0]);
        this.uploadingCount = 1 + this.uploadingCount;
    }

    public void onProductUpdateResponse(EditProductResponse editProductResponse) {
        if (editProductResponse != null) {
            this.binding.addProduct.setBusy(false);
            Intent intent = new Intent();
            intent.putExtra("refresh", true);
            this.setResult(-1, intent);
            this.finish();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        active = true;
    }

    public void onStop() {
        super.onStop();
        active = false;
    }

    public void productAdded(AddProductResponse addProductResponse) {
        this.binding.addProduct.setBusy(false);
        if (addProductResponse != null) {
            Business business = this.business;
            if (business != null) {
                CleverTapUtils.trackProductAdded((Context)this, business.realmGet$id());
                new BranchEvent("Product Added").addCustomDataProperty("phone", this.business.realmGet$mobile()).addCustomDataProperty("link", this.business.realmGet$link()).setCustomerEventAlias("product_added").logEvent((Context)this);
            }
            Intent intent = new Intent();
            intent.putExtra("refresh", true);
            intent.putExtra("productAdded", true);
            this.setResult(-1, intent);
            this.finish();
        }
    }

    @Override
    public void selectCategoryItem(Category category) {
        PopupWindow popupWindow;
        this.category = category;
        if (category != null && !TextUtils.isEmpty((CharSequence)category.realmGet$name())) {
            this.binding.etCategory.setText((CharSequence)category.realmGet$name());
        }
        if ((popupWindow = this.popUp) != null) {
            popupWindow.dismiss();
        }
    }

    public void updateProductDetails() {
        this.binding.addProduct.setBusy(true);
        if (!this.validateForm()) {
            this.binding.addProduct.setBusy(false);
            return;
        }
        EditProductRequest editProductRequest = new EditProductRequest();
        editProductRequest.name = this.binding.etProductName.getText().toString().trim();
        if (!TextUtils.isEmpty((CharSequence)this.binding.etSellingPrice.getText())) {
            String string2 = this.binding.etSellingPrice.getText().toString().trim();
            editProductRequest.baseCost = string2.contains((CharSequence)"\u20b9") ? Double.parseDouble((String)string2.replace((CharSequence)"\u20b9", (CharSequence)"").trim().replace((CharSequence)",", (CharSequence)"").trim()) : Double.parseDouble((String)this.binding.etSellingPrice.getText().toString().trim().replace((CharSequence)",", (CharSequence)"").trim());
        }
        if (!TextUtils.isEmpty((CharSequence)this.binding.etMrp.getText())) {
            editProductRequest.originalCost = Double.parseDouble((String)this.binding.etMrp.getText().toString().trim().replace((CharSequence)",", (CharSequence)""));
            if (editProductRequest.baseCost == 0.0) {
                editProductRequest.baseCost = editProductRequest.originalCost;
            }
        }
        try {
            if (this.uploadingCount < this.uploadingTotal) {
                Toast.makeText((Context)this, (CharSequence)"Please wait. Uploading images...", (int)0).show();
                return;
            }
            this.prepareProductImagesPayload((BaseCreateProduct)editProductRequest);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        editProductRequest.setHidden(this.product.isHidden());
        editProductRequest.baseQty = this.binding.etUnit.getText().toString().trim();
        editProductRequest.description = !TextUtils.isEmpty((CharSequence)this.binding.etDesc.getText().toString().trim()) ? this.binding.etDesc.getText().toString().trim() : "";
        Category category = this.category;
        editProductRequest.category = category != null ? category.realmGet$id() : this.product.getCategoryId();
        Object[] arrobject = new Object[]{this.getQuantityInput(), editProductRequest.baseQty};
        editProductRequest.baseQty = String.format((String)"%s %s", (Object[])arrobject);
        this.mViewModel.updateProduct(editProductRequest, this.product.getId());
    }

    public boolean validCategoryName() {
        return true ^ this.binding.etCategory.getText().toString().trim().isEmpty();
    }

    public boolean validPriceName() {
        return true ^ this.binding.etMrp.getText().toString().trim().isEmpty();
    }

    public boolean validProductName() {
        return true ^ this.binding.etProductName.getText().toString().trim().isEmpty();
    }

    public boolean validateForm() {
        String string2 = TextUtils.isEmpty((CharSequence)this.binding.etSellingPrice.getText()) ? null : this.binding.etSellingPrice.getText().toString().replace((CharSequence)",", (CharSequence)"");
        String string3 = TextUtils.isEmpty((CharSequence)this.binding.etMrp.getText()) ? null : this.binding.etMrp.getText().toString().replace((CharSequence)",", (CharSequence)"");
        try {
            if (!TextUtils.isEmpty((CharSequence)string2) && !TextUtils.isEmpty(string3) && Double.parseDouble((String)string2) > Double.parseDouble((String)string3)) {
                this.showSellingPriceError();
                return false;
            }
        }
        catch (Exception exception) {
            Timber.e((Throwable)exception);
        }
        this.hideSellingPriceError();
        boolean bl = this.validProductName();
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = this.validPriceName();
            bl2 = false;
            if (bl3) {
                boolean bl4 = this.validCategoryName();
                bl2 = false;
                if (bl4) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    public void variantsFound(List<Variant> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); ++i) {
            if (((Variant)list.get(i)).realmGet$type() == 0) continue;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", ((Variant)list.get(i)).realmGet$type());
                jSONObject.put("value", (Object)((Variant)list.get(i)).realmGet$value());
                jSONArray.put((Object)jSONObject);
                continue;
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
        }
        if (jSONArray.length() > 0) {
            TextView textView = this.binding.lblAddVariant;
            Object[] arrobject = new Object[]{jSONArray.length()};
            textView.setText((CharSequence)String.format((String)"%s variants", (Object[])arrobject));
            this.finalVariantString = jSONArray.toString();
            this.binding.lblAddVariant.setVisibility(0);
        }
    }

    @Override
    public void yesMakeIt() {
        Product product = this.product;
        if (product != null) {
            this.mViewModel.deleteProduct(product.getId());
        }
    }

}

