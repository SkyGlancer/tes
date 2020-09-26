/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.play.core.appupdate.AppUpdateInfo
 *  com.google.android.play.core.tasks.OnSuccessListener
 *  com.google.android.play.core.tasks.Task
 *  java.lang.Object
 */
package app.dukhaan.ui.main;

import app.dukhaan.ui.main.MainActivity;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;

public final class -$$Lambda$MainActivity$IvV-lCtjXTkwhdc9hXL3ypery8k
implements OnSuccessListener {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ Task f$1;

    public /* synthetic */ -$$Lambda$MainActivity$IvV-lCtjXTkwhdc9hXL3ypery8k(MainActivity mainActivity, Task task) {
        this.f$0 = mainActivity;
        this.f$1 = task;
    }

    public final void onSuccess(Object object) {
        this.f$0.lambda$onFlexibleUpdateAvailable$7$MainActivity(this.f$1, (AppUpdateInfo)object);
    }
}

