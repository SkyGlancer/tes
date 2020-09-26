/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  java.lang.Object
 */
package app.dukhaan.ui.account;

import app.dukhaan.ui.account.AccountFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final class -$$Lambda$AccountFragment$fKyCZYZP4SH40es4fEjw_xZ0adU
implements OnCompleteListener {
    public final /* synthetic */ AccountFragment f$0;

    public /* synthetic */ -$$Lambda$AccountFragment$fKyCZYZP4SH40es4fEjw_xZ0adU(AccountFragment accountFragment) {
        this.f$0 = accountFragment;
    }

    public final void onComplete(Task task) {
        this.f$0.lambda$checkForRemoteConfig$10$AccountFragment(task);
    }
}

