package app.dukhaan.ui.ui.verifymobile;

import android.content.Intent;
import android.os.Bundle;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Country;
import app.dukhaan.databinding.ActivityVerifyMobileBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.selectcountry.SelectCountryActivity;
import app.dukhaan.ui.verifymobile.VerifyMobileActivity.1;
import app.dukhaan.ui.verifymobile.VerifyMobileNavigator;
import app.dukhaan.ui.verifymobile.VerifyMobileViewModel;
import app.dukhaan.util.CountData;

public class VerifyMobileActivity extends BaseActivity<ActivityVerifyMobileBinding, VerifyMobileViewModel> implements VerifyMobileNavigator {
   private ActivityVerifyMobileBinding binding;
   private VerifyMobileViewModel mViewModel;
   private Country selectedCountry;

   public VerifyMobileActivity() {
   }

   private void init() {
      if (this.getSupportActionBar() != null) {
         this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         this.getSupportActionBar().setTitle("");
         this.getSupportActionBar().setHomeAsUpIndicator(ic_back_arrow_black);
      }

      this.binding.idInputMobile.setOnTouchListener(new _$$Lambda$VerifyMobileActivity$zTu74DE_MqHiNPvQKZ2_7WbokDM(this));
      AppPref.getInstance().setCurrency("INR");
      this.binding.toolbar.setNavigationOnClickListener(new _$$Lambda$VerifyMobileActivity$9VF_XCFcQx_eKZSAzxxMdqBqFnI(this));
      this.binding.idInputMobile.addTextChangedListener(new 1(this));
      this.binding.idBtnNext.setOnClickListener(new _$$Lambda$VerifyMobileActivity$0oHOv0MdF1E4CytxDZYpVxr_rkI(this));
      this.binding.flagContainer.setOnClickListener(new _$$Lambda$VerifyMobileActivity$pBEUuOOt7CuCNgW0o9ClKwxjIrY(this));
      this.binding.idImgCountryFlag.setOnClickListener(new _$$Lambda$VerifyMobileActivity$zAaB6i0PlGoyVSHXHRVZlSX406I(this));
      this.setSelectedCountry("IN");
   }

   private void launchCountryPicker() {
      Intent var1 = new Intent(this, SelectCountryActivity.class);
      var1.putExtra("country", this.selectedCountry);
      this.startActivityForResult(var1, 1);
   }

   private void setSelectedCountry(String var1) {
      Country[] var2 = CountData.COUNTRIES;
      int var3 = var2.length;
      int var4 = 0;

      Country var6;
      while(true) {
         if (var4 >= var3) {
            var6 = null;
            break;
         }

         Country var5 = var2[var4];
         if (var5.getCode().equalsIgnoreCase(var1)) {
            var6 = var5;
            break;
         }

         ++var4;
      }

      if (var6 != null) {
         this.selectedCountry = var6;
      }

   }

   public int getLayoutId() {
      return activity_verify_mobile;
   }

   public Class<VerifyMobileViewModel> getViewModel() {
      return VerifyMobileViewModel.class;
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var1 == 1 && var2 == -1) {
         String var4 = var3.getStringExtra("dialCode");
         String var5 = var3.getStringExtra("countryCode");
         var1 = var3.getIntExtra("flag", 0);
         String var6 = var3.getStringExtra("currency");
         if (var6 != null) {
            AppPref.getInstance().setCurrency(var6);
         }

         this.binding.idLblCountryCode.setText(var4);
         this.binding.idImgCountryFlag.setImageResource(var1);
         this.setSelectedCountry(var5);
      }

   }

   public void onApiError(ErrorResponse var1) {
   }

   protected void onCreate(Bundle var1, VerifyMobileViewModel var2, ActivityVerifyMobileBinding var3) {
      this.mViewModel = var2;
      this.binding = var3;
      var2.setNavigator(this);
      this.changeStatusBarColor();
      this.setSupportActionBar(var3.toolbar);
      this.init();
   }
}
