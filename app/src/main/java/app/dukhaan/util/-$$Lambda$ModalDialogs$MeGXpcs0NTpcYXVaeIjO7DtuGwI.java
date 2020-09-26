/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package app.dukhaan.util;

import android.app.Activity;
import app.dukhaan.util.ModalDialogs;

public final class -$$Lambda$ModalDialogs$MeGXpcs0NTpcYXVaeIjO7DtuGwI
implements Runnable {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ ModalDialogs.ButtonClickListener f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ -$$Lambda$ModalDialogs$MeGXpcs0NTpcYXVaeIjO7DtuGwI(Activity activity, ModalDialogs.ButtonClickListener buttonClickListener, String string2, String string3) {
        this.f$0 = activity;
        this.f$1 = buttonClickListener;
        this.f$2 = string2;
        this.f$3 = string3;
    }

    public final void run() {
        ModalDialogs.lambda$showUnauthorizedError$1(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

