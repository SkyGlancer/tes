/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.TextView
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.FragmentManager
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.databinding.ActivityOnboardingBinding
 *  app.dukhaan.ui.account.AccountViewModel
 *  app.dukhaan.ui.onboarding.-$
 *  app.dukhaan.ui.onboarding.-$$Lambda
 *  app.dukhaan.ui.onboarding.-$$Lambda$OnBoardingActivity
 *  app.dukhaan.ui.onboarding.-$$Lambda$OnBoardingActivity$ZpWxkzjXson4CbzeaNVnaWWkVNg
 *  app.dukhaan.ui.onboarding.-$$Lambda$OnBoardingActivity$ZwgjWDoiFPV6MZoJUAX7pIujdkM
 *  com.clevertap.android.sdk.CleverTapAPI
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.OnFailureListener
 *  com.google.android.gms.tasks.Task
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfig
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings$Builder
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Objects
 *  timber.log.Timber
 */
package app.dukhaan.ui.onboarding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import app.dukhaan.app.Constants;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.databinding.ActivityOnboardingBinding;
import app.dukhaan.ui.account.AccountViewModel;
import app.dukhaan.ui.chagnelanguage.BottomSheetSelectLanguage;
import app.dukhaan.ui.onboarding.-$;
import app.dukhaan.ui.onboarding.-$$Lambda$OnBoardingActivity$o5nNz0jt2rbv3b6ePU2OG_vMzTI;
import app.dukhaan.ui.verifymobile.VerifyMobileActivity;
import app.dukhaan.ui.views.PrimaryButton;
import com.clevertap.android.sdk.CleverTapAPI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.util.Objects;
import timber.log.Timber;

public class OnBoardingActivity
extends BaseActivity<ActivityOnboardingBinding, AccountViewModel>
implements BottomSheetSelectLanguage.OnLanguageSelectListener {
    private ActivityOnboardingBinding binding;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;

    private void updateRemoteDetails(String string2, String string3) {
        TextView textView = (TextView)this.findViewById(2131362198);
        TextView textView2 = (TextView)this.findViewById(2131362173);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            textView.setText((CharSequence)string2);
        }
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            textView2.setText((CharSequence)string3);
        }
    }

    public void checkForRemoteConfig() {
        this.getFirebaseRemoteConfig().fetchAndActivate().addOnCompleteListener((Activity)this, (OnCompleteListener)new -$.Lambda.OnBoardingActivity.ZwgjWDoiFPV6MZoJUAX7pIujdkM(this)).addOnFailureListener((OnFailureListener)new -$.Lambda.OnBoardingActivity.ZpWxkzjXson4CbzeaNVnaWWkVNg(this));
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
        return 2131558443;
    }

    @Override
    public Class<AccountViewModel> getViewModel() {
        return AccountViewModel.class;
    }

    public /* synthetic */ void lambda$checkForRemoteConfig$1$OnBoardingActivity(Task task) {
        if (task.isSuccessful()) {
            String string2 = this.getFirebaseRemoteConfig().getString("onboarding_title");
            String string3 = this.getFirebaseRemoteConfig().getString("onboarding_desc");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FIREBASE: Title-");
            stringBuilder.append(string2);
            Timber.d((String)stringBuilder.toString(), (Object[])new Object[0]);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("FIREBASE: Desc-");
            stringBuilder2.append(string3);
            Timber.d((String)stringBuilder2.toString(), (Object[])new Object[0]);
            this.updateRemoteDetails(string2, string3);
        }
    }

    public /* synthetic */ void lambda$checkForRemoteConfig$2$OnBoardingActivity(Exception exception) {
        this.updateRemoteDetails(this.getResources().getString(2131951978), this.getResources().getString(2131951977));
    }

    public /* synthetic */ void lambda$onCreate$0$OnBoardingActivity(View view) {
        try {
            ((CleverTapAPI)Objects.requireNonNull((Object)CleverTapAPI.getDefaultInstance((Context)this))).pushEvent("Start Button Clicked");
        }
        catch (Exception exception) {
            Timber.e((Throwable)exception);
        }
        if (Constants.IS_MULTI_LANGUAGE_SUPPORTED) {
            BottomSheetSelectLanguage bottomSheetSelectLanguage = new BottomSheetSelectLanguage();
            bottomSheetSelectLanguage.setListener(this);
            bottomSheetSelectLanguage.show(this.getSupportFragmentManager(), bottomSheetSelectLanguage.getTag());
            return;
        }
        this.startActivity(new Intent((Context)this, VerifyMobileActivity.class));
    }

    @Override
    protected void onCreate(Bundle bundle, AccountViewModel accountViewModel, ActivityOnboardingBinding activityOnboardingBinding) {
        this.binding = activityOnboardingBinding;
        Window window = this.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.flags = -67108865 & layoutParams.flags;
        window.setAttributes(layoutParams);
        if (Build.VERSION.SDK_INT >= 23) {
            window.getDecorView().setSystemUiVisibility(9472);
        }
        ((ActivityOnboardingBinding)DataBindingUtil.setContentView((Activity)this, (int)2131558443)).idBtnStart.setOnClickListener(new -$$Lambda$OnBoardingActivity$o5nNz0jt2rbv3b6ePU2OG_vMzTI(this));
        try {
            this.checkForRemoteConfig();
            return;
        }
        catch (Exception exception) {
            this.updateRemoteDetails(this.getResources().getString(2131951978), this.getResources().getString(2131951977));
            return;
        }
    }

    @Override
    public void onLanguageSelected(String string2) {
        AppPref.getInstance().setLocale(string2);
        this.updateBaseContextLocale((Context)this);
        this.startActivity(new Intent((Context)this, VerifyMobileActivity.class));
    }
}

