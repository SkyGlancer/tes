/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.base;

import app.dukhaan.base.BaseActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final class -$$Lambda$BaseActivity$QYC8qzw_XpXwFxvK9v-HUbNaWwg
implements OnCompleteListener {
    public final /* synthetic */ String f$0;

    public /* synthetic */ -$$Lambda$BaseActivity$QYC8qzw_XpXwFxvK9v-HUbNaWwg(String string2) {
        this.f$0 = string2;
    }

    public final void onComplete(Task task) {
        BaseActivity.lambda$unsubscribeFromFcm$0(this.f$0, task);
    }
}

