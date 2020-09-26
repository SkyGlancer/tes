/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  java.lang.Object
 */
package app.dukhaan.util;

import app.dukhaan.util.AppUpdateUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final class -$$Lambda$AppUpdateUtils$BKnhZ04h1EJXR7vY1-Wit8T2baQ
implements OnCompleteListener {
    public final /* synthetic */ AppUpdateUtils f$0;
    public final /* synthetic */ AppUpdateUtils.AppUpdateUtilsListener f$1;

    public /* synthetic */ -$$Lambda$AppUpdateUtils$BKnhZ04h1EJXR7vY1-Wit8T2baQ(AppUpdateUtils appUpdateUtils, AppUpdateUtils.AppUpdateUtilsListener appUpdateUtilsListener) {
        this.f$0 = appUpdateUtils;
        this.f$1 = appUpdateUtilsListener;
    }

    public final void onComplete(Task task) {
        this.f$0.lambda$checkForAppUpdate$0$AppUpdateUtils(this.f$1, task);
    }
}

