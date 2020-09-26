package app.dukhaan.ui.ui.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.databinding.ActivityOnboardingBinding;
import app.dukhaan.ui.account.AccountViewModel;
import app.dukhaan.ui.chagnelanguage.BottomSheetSelectLanguage.OnLanguageSelectListener;
import app.dukhaan.ui.verifymobile.VerifyMobileActivity;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder;

public class OnBoardingActivity extends BaseActivity<ActivityOnboardingBinding, AccountViewModel> implements OnLanguageSelectListener {
   private ActivityOnboardingBinding binding;
   private FirebaseRemoteConfig mFirebaseRemoteConfig;

   public OnBoardingActivity() {
   }

   private void updateRemoteDetails(String var1, String var2) {
      TextView var3 = (TextView)this.findViewById(id_title);
      TextView var4 = (TextView)this.findViewById(id_desc);
      if (!TextUtils.isEmpty(var1)) {
         var3.setText(var1);
      }

      if (!TextUtils.isEmpty(var2)) {
         var4.setText(var2);
      }

   }

   public void checkForRemoteConfig() {
      this.getFirebaseRemoteConfig().fetchAndActivate().addOnCompleteListener(this, new _$$Lambda$OnBoardingActivity$ZwgjWDoiFPV6MZoJUAX7pIujdkM(this)).addOnFailureListener(new _$$Lambda$OnBoardingActivity$ZpWxkzjXson4CbzeaNVnaWWkVNg(this));
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
      return activity_onboarding;
   }

   public Class<AccountViewModel> getViewModel() {
      return AccountViewModel.class;
   }

   protected void onCreate(Bundle var1, AccountViewModel var2, ActivityOnboardingBinding var3) {
      this.binding = var3;
      Window var6 = this.getWindow();
      LayoutParams var5 = var6.getAttributes();
      var5.flags &= -67108865;
      var6.setAttributes(var5);
      if (VERSION.SDK_INT >= 23) {
         var6.getDecorView().setSystemUiVisibility(9472);
      }

      ((ActivityOnboardingBinding)DataBindingUtil.setContentView(this, activity_onboarding)).idBtnStart.setOnClickListener(new _$$Lambda$OnBoardingActivity$o5nNz0jt2rbv3b6ePU2OG_vMzTI(this));

      try {
         this.checkForRemoteConfig();
      } catch (Exception var4) {
         this.updateRemoteDetails(this.getResources().getString(R.string.str_onbording_title), this.getResources().getString(R.string.str_onbording_desc));
      }

   }

   public void onLanguageSelected(String var1) {
      AppPref.getInstance().setLocale(var1);
      this.updateBaseContextLocale(this);
      this.startActivity(new Intent(this, VerifyMobileActivity.class));
   }
}
