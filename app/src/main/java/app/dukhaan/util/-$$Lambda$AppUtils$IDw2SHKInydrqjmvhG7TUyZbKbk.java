/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfig
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.util;

import android.content.Context;
import app.dukhaan.util.AppUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class -$$Lambda$AppUtils$IDw2SHKInydrqjmvhG7TUyZbKbk
implements OnCompleteListener {
    public final /* synthetic */ FirebaseRemoteConfig f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ Context f$4;

    public /* synthetic */ -$$Lambda$AppUtils$IDw2SHKInydrqjmvhG7TUyZbKbk(FirebaseRemoteConfig firebaseRemoteConfig, String string2, String string3, String string4, Context context) {
        this.f$0 = firebaseRemoteConfig;
        this.f$1 = string2;
        this.f$2 = string3;
        this.f$3 = string4;
        this.f$4 = context;
    }

    public final void onComplete(Task task) {
        AppUtils.lambda$shareOnWhatsApp$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, task);
    }
}

