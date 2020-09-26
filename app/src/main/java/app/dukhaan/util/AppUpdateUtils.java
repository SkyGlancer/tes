/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  app.dukhaan.util.-$
 *  app.dukhaan.util.-$$Lambda
 *  app.dukhaan.util.-$$Lambda$AppUpdateUtils
 *  app.dukhaan.util.-$$Lambda$AppUpdateUtils$BKnhZ04h1EJXR7vY1-Wit8T2baQ
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfig
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings$Builder
 *  java.lang.Object
 *  java.lang.String
 *  timber.log.Timber
 */
package app.dukhaan.util;

import android.app.Activity;
import app.dukhaan.util.-$;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import timber.log.Timber;

public class AppUpdateUtils {
    private FirebaseRemoteConfig mFirebaseRemoteConfig;

    public void checkForAppUpdate(Activity activity, AppUpdateUtilsListener appUpdateUtilsListener) {
        this.getFirebaseRemoteConfig().fetchAndActivate().addOnCompleteListener(activity, (OnCompleteListener)new -$.Lambda.AppUpdateUtils.BKnhZ04h1EJXR7vY1-Wit8T2baQ(this, appUpdateUtilsListener));
    }

    public FirebaseRemoteConfig getFirebaseRemoteConfig() {
        if (this.mFirebaseRemoteConfig == null) {
            this.mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
            FirebaseRemoteConfigSettings firebaseRemoteConfigSettings = new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(3600L).build();
            this.mFirebaseRemoteConfig.setConfigSettingsAsync(firebaseRemoteConfigSettings);
        }
        return this.mFirebaseRemoteConfig;
    }

    public /* synthetic */ void lambda$checkForAppUpdate$0$AppUpdateUtils(AppUpdateUtilsListener appUpdateUtilsListener, Task task) {
        if (task.isSuccessful()) {
            int n = (int)this.getFirebaseRemoteConfig().getDouble("latest_version_code");
            boolean bl = this.getFirebaseRemoteConfig().getBoolean("is_immediate_update");
            Object[] arrobject = new Object[]{n, bl};
            Timber.e((String)"Firebase remote config: latestVersionCode(%d), isImmediateUpdate(%b)", (Object[])arrobject);
            if (n > 47) {
                if (bl) {
                    appUpdateUtilsListener.onImmediateUpdateAvailable();
                    return;
                }
                appUpdateUtilsListener.onFlexibleUpdateAvailable();
            }
        }
    }

    public static interface AppUpdateUtilsListener {
        public void onFlexibleUpdateAvailable();

        public void onImmediateUpdateAvailable();
    }

}

