/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  java.lang.Object
 */
package app.dukhaan.ui.splash;

import app.dukhaan.ui.splash.SplashActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final class -$$Lambda$SplashActivity$VXoMl5ZdMemShhRK5X9Yr-J2icc
implements OnCompleteListener {
    public final /* synthetic */ SplashActivity f$0;

    public /* synthetic */ -$$Lambda$SplashActivity$VXoMl5ZdMemShhRK5X9Yr-J2icc(SplashActivity splashActivity) {
        this.f$0 = splashActivity;
    }

    public final void onComplete(Task task) {
        this.f$0.lambda$checkForRemoteConfig$0$SplashActivity(task);
    }
}

