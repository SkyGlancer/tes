/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.clevertap.android.sdk.CleverTapAPI
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  java.lang.Object
 */
package app.dukhaan.util;

import app.dukhaan.util.CleverTapUtils;
import com.clevertap.android.sdk.CleverTapAPI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final class -$$Lambda$CleverTapUtils$a0RsO26B2-lf7ZA0Xs9kcR3ABEI
implements OnCompleteListener {
    public final /* synthetic */ CleverTapAPI f$0;

    public /* synthetic */ -$$Lambda$CleverTapUtils$a0RsO26B2-lf7ZA0Xs9kcR3ABEI(CleverTapAPI cleverTapAPI) {
        this.f$0 = cleverTapAPI;
    }

    public final void onComplete(Task task) {
        CleverTapUtils.lambda$registerFcmToken$0(this.f$0, task);
    }
}

