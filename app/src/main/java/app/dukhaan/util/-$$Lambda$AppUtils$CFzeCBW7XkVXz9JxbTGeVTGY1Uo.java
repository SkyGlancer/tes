/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.tasks.OnFailureListener
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.util;

import android.content.Context;
import app.dukhaan.util.AppUtils;
import com.google.android.gms.tasks.OnFailureListener;

public final class -$$Lambda$AppUtils$CFzeCBW7XkVXz9JxbTGeVTGY1Uo
implements OnFailureListener {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ -$$Lambda$AppUtils$CFzeCBW7XkVXz9JxbTGeVTGY1Uo(Context context, String string2, String string3, String string4) {
        this.f$0 = context;
        this.f$1 = string2;
        this.f$2 = string3;
        this.f$3 = string4;
    }

    public final void onFailure(Exception exception) {
        AppUtils.lambda$shareOnWhatsApp$1(this.f$0, this.f$1, this.f$2, this.f$3, exception);
    }
}

