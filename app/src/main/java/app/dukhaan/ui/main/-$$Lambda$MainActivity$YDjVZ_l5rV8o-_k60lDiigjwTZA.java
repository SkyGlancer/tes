/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  app.dukhaan.ui.main.MainActivity
 *  com.google.android.play.core.appupdate.AppUpdateInfo
 *  java.lang.Object
 *  java.lang.Runnable
 */
package app.dukhaan.ui.main;

import android.app.Activity;
import app.dukhaan.ui.main.MainActivity;
import com.google.android.play.core.appupdate.AppUpdateInfo;

public final class -$$Lambda$MainActivity$YDjVZ_l5rV8o-_k60lDiigjwTZA
implements Runnable {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ AppUpdateInfo f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ Activity f$3;

    public /* synthetic */ -$$Lambda$MainActivity$YDjVZ_l5rV8o-_k60lDiigjwTZA(MainActivity mainActivity, AppUpdateInfo appUpdateInfo, int n, Activity activity) {
        this.f$0 = mainActivity;
        this.f$1 = appUpdateInfo;
        this.f$2 = n;
        this.f$3 = activity;
    }

    public final void run() {
        this.f$0.lambda$startUpdate$8$MainActivity(this.f$1, this.f$2, this.f$3);
    }
}

