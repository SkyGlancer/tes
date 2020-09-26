/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.FragmentActivity
 *  app.dukhaan.app.GlideRequest
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.databinding.ActivityKillswitchBinding
 *  app.dukhaan.ui.account.AccountViewModel
 *  app.dukhaan.ui.killswitch.-$
 *  app.dukhaan.ui.killswitch.-$$Lambda
 *  app.dukhaan.ui.killswitch.-$$Lambda$KillswitchActivity
 *  app.dukhaan.ui.killswitch.-$$Lambda$KillswitchActivity$39R9rbTRi425-gg2rUa9pZzGw9k
 *  app.dukhaan.ui.killswitch.-$$Lambda$KillswitchActivity$JDD7wJszEogihcsbbX5zl5QTy38
 *  com.bumptech.glide.request.target.ViewTarget
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
 *  java.util.HashMap
 *  timber.log.Timber
 */
package app.dukhaan.ui.killswitch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import app.dukhaan.app.GlideApp;
import app.dukhaan.app.GlideRequest;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.databinding.ActivityKillswitchBinding;
import app.dukhaan.ui.account.AccountViewModel;
import app.dukhaan.ui.chagnelanguage.BottomSheetSelectLanguage;
import app.dukhaan.ui.killswitch.-$;
import app.dukhaan.ui.killswitch.-$$Lambda$KillswitchActivity$HCwp62DCH38obLpBKs1Sny27h70;
import app.dukhaan.ui.verifymobile.VerifyMobileActivity;
import com.bumptech.glide.request.target.ViewTarget;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.util.HashMap;
import timber.log.Timber;

public class KillswitchActivity
extends BaseActivity<ActivityKillswitchBinding, AccountViewModel>
implements BottomSheetSelectLanguage.OnLanguageSelectListener {
    private ActivityKillswitchBinding binding;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;

    static /* synthetic */ void lambda$checkForRemoteConfig$1(Exception exception) {
        Timber.e((String)"FAILED REMOTE CONFIG", (Object[])new Object[0]);
    }

    private void updateRemoteDetails(HashMap<String, String> hashMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("REMOTE CONFIG: ");
        stringBuilder.append(hashMap.toString());
        Timber.d((String)stringBuilder.toString(), (Object[])new Object[0]);
        ImageView imageView = (ImageView)this.findViewById(2131362159);
        TextView textView = (TextView)this.findViewById(2131362199);
        TextView textView2 = (TextView)this.findViewById(2131362174);
        Button button = (Button)this.findViewById(2131362164);
        Object[] arrobject = new Object[]{Uri.parse((String)((String)hashMap.get((Object)"banner")))};
        Timber.d((String)"REMOTE CONFIG : Banner => %s", (Object[])arrobject);
        GlideApp.with((FragmentActivity)this).load((String)hashMap.get((Object)"banner")).into(imageView);
        textView.setText((CharSequence)hashMap.get((Object)"title"));
        textView2.setText((CharSequence)hashMap.get((Object)"desc"));
        button.setText((CharSequence)hashMap.get((Object)"btnText"));
        button.setOnClickListener((View.OnClickListener)new -$$Lambda$KillswitchActivity$HCwp62DCH38obLpBKs1Sny27h70(this, hashMap));
    }

    public void checkForRemoteConfig() {
        this.getFirebaseRemoteConfig().fetchAndActivate().addOnCompleteListener((Activity)this, (OnCompleteListener)new -$.Lambda.KillswitchActivity.39R9rbTRi425-gg2rUa9pZzGw9k(this)).addOnFailureListener((OnFailureListener)-$.Lambda.KillswitchActivity.JDD7wJszEogihcsbbX5zl5QTy38.INSTANCE);
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
        return 2131558440;
    }

    @Override
    public Class<AccountViewModel> getViewModel() {
        return AccountViewModel.class;
    }

    public /* synthetic */ void lambda$checkForRemoteConfig$0$KillswitchActivity(Task task) {
        if (task.isSuccessful()) {
            Timber.d((String)"REMOTE CONFIG: killswitch success", (Object[])new Object[0]);
            HashMap hashMap = new HashMap();
            hashMap.put((Object)"title", (Object)this.getFirebaseRemoteConfig().getString("killswitch_title"));
            hashMap.put((Object)"desc", (Object)this.getFirebaseRemoteConfig().getString("killswitch_description"));
            hashMap.put((Object)"banner", (Object)this.getFirebaseRemoteConfig().getString("killswitch_banner"));
            hashMap.put((Object)"btnText", (Object)this.getFirebaseRemoteConfig().getString("killswitch_button_text"));
            hashMap.put((Object)"btnLink", (Object)this.getFirebaseRemoteConfig().getString("killswitch_button_link"));
            this.updateRemoteDetails((HashMap<String, String>)hashMap);
        }
    }

    public /* synthetic */ void lambda$updateRemoteDetails$2$KillswitchActivity(HashMap hashMap, View view) {
        this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)((String)hashMap.get((Object)"btnLink")))));
    }

    @Override
    protected void onCreate(Bundle bundle, AccountViewModel accountViewModel, ActivityKillswitchBinding activityKillswitchBinding) {
        this.binding = activityKillswitchBinding;
        Window window = this.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.flags = -67108865 & layoutParams.flags;
        window.setAttributes(layoutParams);
        if (Build.VERSION.SDK_INT >= 23) {
            window.getDecorView().setSystemUiVisibility(9472);
        }
        (ActivityKillswitchBinding)DataBindingUtil.setContentView((Activity)this, (int)2131558440);
        try {
            this.checkForRemoteConfig();
            return;
        }
        catch (Exception exception) {
            HashMap hashMap = new HashMap();
            hashMap.put((Object)"title", (Object)"Install New App");
            hashMap.put((Object)"desc", (Object)"We have migrated to a new address now. Don't worry. Your stores are perfectly safe. Simply login with the same number on the new app to recover your app.");
            hashMap.put((Object)"banner", (Object)"https://dukaan-api.1kg.me/static/images/store-def.jpg");
            hashMap.put((Object)"btnText", (Object)"Download Now");
            hashMap.put((Object)"btnLink", (Object)"https://mydukaan.io");
            this.updateRemoteDetails((HashMap<String, String>)hashMap);
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

