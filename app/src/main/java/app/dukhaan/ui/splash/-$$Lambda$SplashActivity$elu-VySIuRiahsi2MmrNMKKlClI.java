/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnFailureListener
 *  java.lang.Exception
 *  java.lang.Object
 */
package app.dukhaan.ui.splash;

import app.dukhaan.ui.splash.SplashActivity;
import com.google.android.gms.tasks.OnFailureListener;

public final class -$$Lambda$SplashActivity$elu-VySIuRiahsi2MmrNMKKlClI
implements OnFailureListener {
    public final /* synthetic */ SplashActivity f$0;

    public /* synthetic */ -$$Lambda$SplashActivity$elu-VySIuRiahsi2MmrNMKKlClI(SplashActivity splashActivity) {
        this.f$0 = splashActivity;
    }

    public final void onFailure(Exception exception) {
        this.f$0.lambda$checkForRemoteConfig$1$SplashActivity(exception);
    }
}

