package app.dukhaan.ui.ui.editbusiness;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.app.GlideApp;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.Country;
import app.dukhaan.data.model.UploadImage;
import app.dukhaan.databinding.ActivityBusinessDetailsEditBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.EditBusinessRequest;
import app.dukhaan.ui.editbusiness.EditBusinessActivity.1;
import app.dukhaan.ui.editbusiness.EditBusinessActivity.2;
import app.dukhaan.ui.editbusiness.EditBusinessActivity.3;
import app.dukhaan.ui.editbusiness.EditBusinessActivity.4;
import app.dukhaan.ui.editbusiness.EditBusinessActivity.5;
import app.dukhaan.ui.editbusiness.EditBusinessActivity.6;
import app.dukhaan.ui.editbusiness.EditBusinessActivity.7;
import app.dukhaan.ui.editbusiness.EditBusinessActivity.8;
import app.dukhaan.ui.editbusiness.EditBusinessNavigator;
import app.dukhaan.ui.editbusiness.EditBusinessViewModel;
import app.dukhaan.ui.imagepicker.ImagePickerActivity;
import app.dukhaan.ui.selectcountry.CountriesAdapter;
import app.dukhaan.ui.selectcountry.CountriesAdapter.OnCountrySelectedListener;
import app.dukhaan.util.CountData;
import app.dukhaan.util.ModalDialogs;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.karumi.dexter.Dexter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import okhttp3.MultipartBody.Part;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EditBusinessActivity extends BaseActivity<ActivityBusinessDetailsEditBinding, EditBusinessViewModel> implements OnCountrySelectedListener, EditBusinessNavigator {
   static boolean active;
   private ActivityBusinessDetailsEditBinding binding;
   private Business business;
   private List<Country> countries;
   private CountriesAdapter countriesAdapter;
   Part filePart;
   Uri fileUri;
   private boolean isProfileChanged = false;
   boolean isStoreUrlChanged = false;
   private double lat;
   private double lng;
   private PopupWindow popUp;
   private List<Country> searchResults;
   private Country selectedCountry;
   private EditBusinessViewModel viewModel;

   public EditBusinessActivity() {
   }

   private String getStoreBaseUrl() {
      return "https://mydukaan.io/".replace("https://", "");
   }

   private void hideBusinessNameError() {
      this.binding.idEtBusinessName.setBackgroundDrawable(this.getResources().getDrawable(editext_background));
      this.binding.errorBusinessName.setVisibility(8);
   }

   private void hideStoreUrlTakenError() {
      this.binding.businessLink.setBackgroundDrawable(this.getResources().getDrawable(editext_background));
      this.binding.errorStoreTaken.setVisibility(8);
   }

   private void launchCameraIntent() {
      Intent var1 = new Intent(this, ImagePickerActivity.class);
      var1.putExtra("image_picker_option", 0);
      var1.putExtra("lock_aspect_ratio", true);
      var1.putExtra("aspect_ratio_x", 1);
      var1.putExtra("aspect_ratio_Y", 1);
      var1.putExtra("set_bitmap_max_width_height", true);
      var1.putExtra("max_width", 800);
      var1.putExtra("max_height", 800);
      this.startActivityForResult(var1, 100);
   }

   private void launchGalleryIntent() {
      Intent var1 = new Intent(this, ImagePickerActivity.class);
      var1.putExtra("image_picker_option", 1);
      var1.putExtra("lock_aspect_ratio", true);
      var1.putExtra("aspect_ratio_x", 1);
      var1.putExtra("aspect_ratio_Y", 1);
      this.startActivityForResult(var1, 100);
   }

   private void loadProfile(String var1) {
      GlideApp.with(this).load(var1).into(this.binding.idProfilePic);
   }

   private void onProductImageClick() {
      Dexter.withActivity(this).withPermissions(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}).withListener(new 6(this)).check();
   }

   private void search(String var1) {
      this.searchResults.clear();
      Iterator var2 = this.countries.iterator();

      while(var2.hasNext()) {
         Country var3 = (Country)var2.next();
         if (var3.getName().toLowerCase(Locale.ENGLISH).contains(var1.toLowerCase())) {
            this.searchResults.add(var3);
         }
      }

      this.sortCountries(this.searchResults);
      this.countriesAdapter.notifyDataSetChanged();
   }

   private void setProfileImage() {
      this.loadProfile(this.fileUri.toString());
      this.showFullscreenLoader();
      Glide.with(this).asBitmap().load(this.fileUri).apply((new RequestOptions()).override(800)).listener(new 8(this)).submit();
   }

   private void showCountyPicker(View var1) {
      DisplayMetrics var5 = new DisplayMetrics();
      this.getWindowManager().getDefaultDisplay().getMetrics(var5);
      int var2 = var5.heightPixels;
      int var3 = var5.widthPixels;
      var1 = LayoutInflater.from(this).inflate(popup_country_picker, (ViewGroup)null, false);
      PopupWindow var4 = new PopupWindow(var1, var3, var2 / 2 - 20, false);
      this.popUp = var4;
      var4.setTouchable(true);
      this.popUp.setFocusable(true);
      this.popUp.setOutsideTouchable(true);
      if (VERSION.SDK_INT >= 21) {
         this.popUp.setElevation(8.0F);
      }

      this.popUp.showAsDropDown(this.binding.idEtCountryName);
      RecyclerView var7 = (RecyclerView)var1.findViewById(countries_recycler_view);
      EditText var6 = (EditText)var1.findViewById(country_code_picker_search);
      var7.setAdapter(this.countriesAdapter);
      var6.addTextChangedListener(new 3(this));
      var6.setOnEditorActionListener(new 4(this, var6));
      this.popUp.setOnDismissListener(new 5(this));
   }

   private void showEmptyBusinessNameError() {
      this.binding.errorBusinessName.setText(this.getString(R.string.error_enter_business_name));
      this.binding.idEtBusinessName.setBackgroundDrawable(this.getResources().getDrawable(editext_error_background));
      this.binding.errorBusinessName.setVisibility(0);
   }

   private void showImagePickerOptions() {
      ImagePickerActivity.showImagePickerOptions(this, new 7(this));
   }

   private void showStoreUrlTakenError(boolean var1) {
      if (var1) {
         this.binding.errorStoreTaken.setText(this.getString(R.string.error_enter_store_url));
      } else {
         this.binding.errorStoreTaken.setText(this.getString(R.string.error_store_name_taken));
      }

      this.binding.businessLink.setBackgroundDrawable(this.getResources().getDrawable(editext_error_background));
      this.binding.errorStoreTaken.setVisibility(0);
   }

   private void sortCountries(List<Country> var1) {
      Collections.sort(var1, _$$Lambda$EditBusinessActivity$lAuXI4x_XYUzf6Xwj_rRlm9Cf0Q.INSTANCE);
   }

   private void updateBusinessDetails(String var1, boolean var2) {
      EditBusinessRequest var3 = new EditBusinessRequest();
      String var4 = this.binding.businessLink.getText().toString().replace(this.getStoreBaseUrl(), "");
      if (TextUtils.isEmpty(this.binding.idEtBusinessName.getText())) {
         this.showEmptyBusinessNameError();
      } else if (TextUtils.isEmpty(var4)) {
         this.showStoreUrlTakenError(true);
      } else {
         if (!this.business.realmGet$link().equals(var4)) {
            var3.link = var4;
            this.isStoreUrlChanged = true;
         }

         var3.name = this.binding.idEtBusinessName.getText().toString();
         var3.address = this.binding.idEtInputAddress.getText().toString();
         var3.country = this.binding.idEtCountryName.getText().toString();
         var3.imageUrl = var1;
         var3.latitude = this.lat;
         var3.longitude = this.lng;
         this.showFullscreenLoader();
         this.viewModel.updateBusinessDetails(this.business.realmGet$id(), var3, var2);
      }
   }

   private void validateForm() {
      if (!TextUtils.isEmpty(this.binding.idEtBusinessName.getText())) {
         if (this.selectedCountry != null) {
            if (!TextUtils.isEmpty(this.binding.idEtInputAddress.getText())) {
               this.binding.btnSave.setEnabled(true);
            }
         }
      }
   }

   public int getLayoutId() {
      return activity_business_details_edit;
   }

   public Class<EditBusinessViewModel> getViewModel() {
      return EditBusinessViewModel.class;
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var1 == 100) {
         if (var2 == -1) {
            this.fileUri = (Uri)var3.getParcelableExtra("path");
            this.setProfileImage();
         }
      } else if (var1 == 225) {
         this.binding.idEtInputAddress.setClickable(true);
         if (var2 == -1) {
            if (var3 == null) {
               return;
            }

            String var4 = var3.getStringExtra("userAddress");
            this.lat = var3.getDoubleExtra("lat", 0.0D);
            this.lng = var3.getDoubleExtra("lng", 0.0D);
            this.binding.idEtInputAddress.setText(var4);
         }
      }

   }

   public void onApiError(ErrorResponse var1) {
      if (var1.detail != null && var1.detail.errorCode == 100) {
         this.showStoreUrlTakenError(false);
      } else {
         ModalDialogs.showUnknownError(this);
      }

      this.hideFullscreenLoader();
   }

   @Subscribe(
      threadMode = ThreadMode.MAIN
   )
   public void onAppEvent(AppEvent var1) {
      if (var1.type == AppEvent.INTERNET_CONNECTION_CHECK && active) {
         this.hideFullscreenLoader();
      }

   }

   public void onCountrySelected(Country var1) {
      this.selectedCountry = var1;
      this.popUp.dismiss();
      this.binding.idEtCountryName.setText(var1.getName());
   }

   protected void onCreate(Bundle var1, EditBusinessViewModel var2, ActivityBusinessDetailsEditBinding var3) {
      this.viewModel = var2;
      this.binding = var3;
      var2.setNavigator(this);
      this.setSupportActionBar(var3.toolbar);
      this.enableToolbarUpNavigation();
      var3.toolbar.setNavigationOnClickListener(new _$$Lambda$EditBusinessActivity$Kq0OZAPlGzZSjIkAO5LtMopQyYw(this));
      ImagePickerActivity.clearCache(this);
      this.business = var2.getDataManager().getBusiness();
      float var4 = this.getResources().getDimension(dp_10);
      var3.idProfilePic.setShapeAppearanceModel(var3.idProfilePic.getShapeAppearanceModel().toBuilder().setAllCorners(0, var4).build());
      GlideApp.with(this).load(this.business.realmGet$thumbnail()).placeholder(rectangle).into(var3.idProfilePic);
      if (this.business.realmGet$thumbnail().equals("https://dukaan-api.1kg.me/static/images/store-def.jpg")) {
         var3.btnRemoveProfilePic.setVisibility(4);
         var3.lblUpdateImage.setVisibility(0);
      } else {
         var3.btnRemoveProfilePic.setVisibility(0);
         var3.lblUpdateImage.setVisibility(4);
      }

      this.countries = new ArrayList(Arrays.asList(CountData.COUNTRIES));
      ArrayList var5 = new ArrayList();
      this.searchResults = var5;
      var5.addAll(this.countries);
      this.countriesAdapter = new CountriesAdapter(this, this.searchResults, new _$$Lambda$b4ZKQkHElZ_f1UkpcnmvBqDbNXg(this));
      var3.idEtCountryName.setOnClickListener(new _$$Lambda$EditBusinessActivity$aHVYuWF3_6EYvRU21LlP7Hdc2AY(this, var3));
      if (this.business != null) {
         var3.idEtBusinessName.setText(this.business.realmGet$name());
         var3.businessLink.setText(String.format("%s%s", this.getStoreBaseUrl(), this.business.realmGet$link()));
         var3.idEtCountryName.setText(this.business.realmGet$country());
         var3.idEtInputAddress.setText(this.business.realmGet$address());
         this.lat = this.business.realmGet$latitude();
         this.lng = this.business.realmGet$longitude();
      }

      if (!TextUtils.isEmpty(AppPref.getInstance().getMobile())) {
         var3.idEtInputMobile.setText(AppPref.getInstance().getMobile());
      }

      var3.idProfilePic.setOnClickListener(new _$$Lambda$EditBusinessActivity$6U3lxYdzMotnkNBEfZEE0smf4AY(this));
      var3.btnSave.setOnClickListener(new _$$Lambda$EditBusinessActivity$jseTFu9u80RdWcWwjv1EdudwUos(this));
      var3.btnRemoveProfilePic.setOnClickListener(new _$$Lambda$EditBusinessActivity$DsnL9t33NMQ5T_rJsJ4QuWzogBY(this));
      var3.idEtInputAddress.setOnClickListener(new _$$Lambda$EditBusinessActivity$1IvXlX7nr_hLCwbbi_BII9z86IY(this, var3));
      var3.businessLink.addTextChangedListener(new 1(this, var3));
      var3.idEtBusinessName.addTextChangedListener(new 2(this));
   }

   public void onStart() {
      super.onStart();
      active = true;
   }

   public void onStop() {
      super.onStop();
      active = false;
   }

   public void updatedBusinessDetails(boolean var1) {
      this.hideFullscreenLoader();
      if (var1) {
         this.isProfileChanged = var1;
         this.business = this.viewModel.getDataManager().getBusiness();
         GlideApp.with(this).load(this.business.realmGet$thumbnail()).into(this.binding.idProfilePic);
         if (this.business.realmGet$thumbnail().equals("https://dukaan-api.1kg.me/static/images/store-def.jpg")) {
            this.binding.btnRemoveProfilePic.setVisibility(4);
            this.binding.lblUpdateImage.setVisibility(0);
         } else {
            this.binding.btnRemoveProfilePic.setVisibility(0);
            this.binding.lblUpdateImage.setVisibility(4);
         }
      } else {
         if (this.isStoreUrlChanged) {
            Toast.makeText(this.getApplicationContext(), msg_store_url_updated_successfully, 1).show();
         }

         Intent var2 = new Intent();
         var2.putExtra("isUpdated", true);
         this.setResult(-1, var2);
         this.finish();
      }

   }

   public void uploadedImage(UploadImage var1) {
      if (var1.getStatus().equals("success")) {
         StringBuilder var2 = new StringBuilder();
         var2.append("https://dukaan-api.1kg.me");
         var2.append(var1.getData().getChildData().file);
         this.updateBusinessDetails(var2.toString(), true);
      }

   }
}
