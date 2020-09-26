package app.dukhaan.ui.ui.splash;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.databinding.ActivitySplashBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.addbusiness.AddBusinessActivity;
import app.dukhaan.ui.main.MainActivity;
import app.dukhaan.ui.onboarding.OnBoardingActivity;
import app.dukhaan.ui.splash.SplashActivity.1;
import app.dukhaan.ui.splash.SplashActivity.2;
import app.dukhaan.ui.splash.SplashNavigator;
import app.dukhaan.ui.splash.SplashViewModel;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.ModalDialogs;
import com.clevertap.android.sdk.CleverTapAPI;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder;
import io.branch.referral.Branch;
import io.branch.referral.Branch.BranchReferralInitListener;
import io.branch.referral.Branch.InitSessionBuilder;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {
   private ActivitySplashBinding binding;
   private BranchReferralInitListener branchReferralInitListener = new 1(this);
   private FirebaseRemoteConfig mFirebaseRemoteConfig;
   private SplashViewModel mViewModel;

   public SplashActivity() {
   }

   private void animateLogo() {
      Animation var1 = AnimationUtils.loadAnimation(this, fade_in);
      Animation var2 = AnimationUtils.loadAnimation(this, fade_in_text);
      this.binding.logo.startAnimation(var1);
      this.binding.splashFooterContainer.startAnimation(var1);
      this.binding.splashTextContainer.startAnimation(var2);
      var2.setAnimationListener(new 2(this));
   }

   private void initCleverTap() {
      CleverTapAPI var1 = CleverTapAPI.getDefaultInstance(this.getApplicationContext());
      CleverTapUtils.registerFcmToken(this);
      var1.enableDeviceNetworkInfoReporting(true);
   }

   public void checkForRemoteConfig() {
      this.getFirebaseRemoteConfig().fetchAndActivate().addOnCompleteListener(this, new _$$Lambda$SplashActivity$VXoMl5ZdMemShhRK5X9Yr_J2icc(this)).addOnFailureListener(new _$$Lambda$SplashActivity$elu_VySIuRiahsi2MmrNMKKlClI(this));
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
      return activity_splash;
   }

   public Class<SplashViewModel> getViewModel() {
      return SplashViewModel.class;
   }

   public void launchAddBusiness() {
      Intent var1 = new Intent(this, AddBusinessActivity.class);
      var1.setFlags(268468224);
      this.startActivity(var1);
   }

   public void launchCheckSession() {
      this.mViewModel.checkSession(this);
   }

   public void launchHome() {
      CleverTapUtils.trackUser(this, this.mViewModel.getDataManager().getBusiness());
      Intent var1 = new Intent(this, MainActivity.class);
      var1.setFlags(268468224);
      this.startActivity(var1);
   }

   public void launchSignIn() {
      Intent var1 = new Intent(this, OnBoardingActivity.class);
      var1.setFlags(268468224);
      this.startActivity(var1);
   }

   public void onApiError(ErrorResponse var1) {
      ModalDialogs.showUnknownError(this);
   }

   protected void onCreate(Bundle var1, SplashViewModel var2, ActivitySplashBinding var3) {
      this.mViewModel = var2;
      this.binding = var3;
      var2.setNavigator(this);
      this.animateLogo();
      this.initCleverTap();
   }

   protected void onNewIntent(Intent var1) {
      super.onNewIntent(var1);
      this.setIntent(var1);
      Branch.sessionBuilder(this).withCallback(this.branchReferralInitListener).reInit();
   }

   public void onStart() {
      super.onStart();
      InitSessionBuilder var1 = Branch.sessionBuilder(this).withCallback(this.branchReferralInitListener);
      Uri var2;
      if (this.getIntent() != null) {
         var2 = this.getIntent().getData();
      } else {
         var2 = null;
      }

      var1.withData(var2).init();
   }
}
