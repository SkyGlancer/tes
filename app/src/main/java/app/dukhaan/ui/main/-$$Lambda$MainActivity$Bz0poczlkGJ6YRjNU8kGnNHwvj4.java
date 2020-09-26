/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  java.lang.Object
 */
package app.dukhaan.ui.main;

import app.dukhaan.ui.main.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final class -$$Lambda$MainActivity$Bz0poczlkGJ6YRjNU8kGnNHwvj4
implements OnCompleteListener {
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ -$$Lambda$MainActivity$Bz0poczlkGJ6YRjNU8kGnNHwvj4(MainActivity mainActivity) {
        this.f$0 = mainActivity;
    }

    public final void onComplete(Task task) {
        this.f$0.lambda$checkForRemoteVideoConfig$4$MainActivity(task);
    }
}

