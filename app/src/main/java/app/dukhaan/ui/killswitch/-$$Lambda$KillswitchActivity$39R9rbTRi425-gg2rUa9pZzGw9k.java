/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  java.lang.Object
 */
package app.dukhaan.ui.killswitch;

import app.dukhaan.ui.killswitch.KillswitchActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final class -$$Lambda$KillswitchActivity$39R9rbTRi425-gg2rUa9pZzGw9k
implements OnCompleteListener {
    public final /* synthetic */ KillswitchActivity f$0;

    public /* synthetic */ -$$Lambda$KillswitchActivity$39R9rbTRi425-gg2rUa9pZzGw9k(KillswitchActivity killswitchActivity) {
        this.f$0 = killswitchActivity;
    }

    public final void onComplete(Task task) {
        this.f$0.lambda$checkForRemoteConfig$0$KillswitchActivity(task);
    }
}

