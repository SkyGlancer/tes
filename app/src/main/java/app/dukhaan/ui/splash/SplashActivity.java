/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationUtils
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  androidx.databinding.ViewDataBinding
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.databinding.ActivitySplashBinding
 *  app.dukhaan.ui.splash.-$
 *  app.dukhaan.ui.splash.-$$Lambda
 *  app.dukhaan.ui.splash.-$$Lambda$SplashActivity
 *  app.dukhaan.ui.splash.-$$Lambda$SplashActivity$VXoMl5ZdMemShhRK5X9Yr-J2icc
 *  app.dukhaan.ui.splash.-$$Lambda$SplashActivity$elu-VySIuRiahsi2MmrNMKKlClI
 *  app.dukhaan.ui.splash.SplashActivity$1
 *  app.dukhaan.ui.splash.SplashNavigator
 *  app.dukhaan.ui.splash.SplashViewModel
 *  com.clevertap.android.sdk.CleverTapAPI
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.OnFailureListener
 *  com.google.android.gms.tasks.Task
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfig
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings$Builder
 *  io.branch.referral.Branch
 *  io.branch.referral.Branch$BranchReferralInitListener
 *  io.branch.referral.Branch$InitSessionBuilder
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  timber.log.Timber
 */
package app.dukhaan.ui.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.ActivitySplashBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.addbusiness.AddBusinessActivity;
import app.dukhaan.ui.killswitch.KillswitchActivity;
import app.dukhaan.ui.main.MainActivity;
import app.dukhaan.ui.onboarding.OnBoardingActivity;
import app.dukhaan.ui.splash.-$;
import app.dukhaan.ui.splash.SplashActivity;
import app.dukhaan.ui.splash.SplashNavigator;
import app.dukhaan.ui.splash.SplashViewModel;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.ModalDialogs;
import com.clevertap.android.sdk.CleverTapAPI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import io.branch.referral.Branch;
import timber.log.Timber;

public class SplashActivity
extends BaseActivity<ActivitySplashBinding, SplashViewModel>
implements SplashNavigator {
    private ActivitySplashBinding binding;
    private Branch.BranchReferralInitListener branchReferralInitListener = new 1(this);
    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private SplashViewModel mViewModel;

    private void animateLogo() {
        Animation animation = AnimationUtils.loadAnimation((Context)this, (int)2130771996);
        Animation animation2 = AnimationUtils.loadAnimation((Context)this, (int)2130771998);
        this.binding.logo.startAnimation(animation);
        this.binding.splashFooterContainer.startAnimation(animation);
        this.binding.splashTextContainer.startAnimation(animation2);
        animation2.setAnimationListener(new Animation.AnimationListener(this){
            final /* synthetic */ SplashActivity this$0;
            {
                this.this$0 = splashActivity;
            }

            public void onAnimationEnd(Animation animation) {
                this.this$0.checkForRemoteConfig();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
    }

    private void initCleverTap() {
        CleverTapAPI cleverTapAPI = CleverTapAPI.getDefaultInstance((Context)this.getApplicationContext());
        CleverTapUtils.registerFcmToken((Context)this);
        cleverTapAPI.enableDeviceNetworkInfoReporting(true);
    }

    public void checkForRemoteConfig() {
        this.getFirebaseRemoteConfig().fetchAndActivate().addOnCompleteListener((Activity)this, (OnCompleteListener)new -$.Lambda.SplashActivity.VXoMl5ZdMemShhRK5X9Yr-J2icc(this)).addOnFailureListener((OnFailureListener)new -$.Lambda.SplashActivity.elu-VySIuRiahsi2MmrNMKKlClI(this));
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
        return 2131558448;
    }

    @Override
    public Class<SplashViewModel> getViewModel() {
        return SplashViewModel.class;
    }

    public /* synthetic */ void lambda$checkForRemoteConfig$0$SplashActivity(Task task) {
        if (task.isSuccessful()) {
            Timber.d((String)"REMOTE CONFIG: success", (Object[])new Object[0]);
            if (this.getFirebaseRemoteConfig().getBoolean("killswitch_engage")) {
                this.startActivity(new Intent((Context)this, KillswitchActivity.class));
                return;
            }
            Timber.d((String)"REMOTE CONFIG: disengage", (Object[])new Object[0]);
            this.mViewModel.verifyAuthToken();
        }
    }

    public /* synthetic */ void lambda$checkForRemoteConfig$1$SplashActivity(Exception exception) {
        Timber.d((String)"REMOTE CONFIG: failure", (Object[])new Object[0]);
        this.mViewModel.checkSession((Context)this);
    }

    public void launchAddBusiness() {
        Intent intent = new Intent((Context)this, AddBusinessActivity.class);
        intent.setFlags(268468224);
        this.startActivity(intent);
    }

    public void launchCheckSession() {
        this.mViewModel.checkSession((Context)this);
    }

    public void launchHome() {
        CleverTapUtils.trackUser((Context)this, this.mViewModel.getDataManager().getBusiness());
        Intent intent = new Intent((Context)this, MainActivity.class);
        intent.setFlags(268468224);
        this.startActivity(intent);
    }

    public void launchSignIn() {
        Intent intent = new Intent((Context)this, OnBoardingActivity.class);
        intent.setFlags(268468224);
        this.startActivity(intent);
    }

    public void onApiError(ErrorResponse errorResponse) {
        ModalDialogs.showUnknownError((Activity)this);
    }

    @Override
    protected void onCreate(Bundle bundle, SplashViewModel splashViewModel, ActivitySplashBinding activitySplashBinding) {
        this.mViewModel = splashViewModel;
        this.binding = activitySplashBinding;
        splashViewModel.setNavigator((Object)this);
        this.animateLogo();
        this.initCleverTap();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.setIntent(intent);
        Branch.sessionBuilder((Activity)this).withCallback(this.branchReferralInitListener).reInit();
    }

    @Override
    public void onStart() {
        super.onStart();
        Branch.InitSessionBuilder initSessionBuilder = Branch.sessionBuilder((Activity)this).withCallback(this.branchReferralInitListener);
        Uri uri = this.getIntent() != null ? this.getIntent().getData() : null;
        initSessionBuilder.withData(uri).init();
    }
}

