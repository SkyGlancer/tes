/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Observer
 *  java.lang.Boolean
 *  java.lang.Object
 */
package app.dukhaan.ui.addbusiness;

import androidx.lifecycle.Observer;
import app.dukhaan.ui.views.PrimaryButton;

public final class -$$Lambda$KHtUc-LthR3-ruJY9LhEVbNuE9k
implements Observer {
    public final /* synthetic */ PrimaryButton f$0;

    public /* synthetic */ -$$Lambda$KHtUc-LthR3-ruJY9LhEVbNuE9k(PrimaryButton primaryButton) {
        this.f$0 = primaryButton;
    }

    public final void onChanged(Object object) {
        this.f$0.setBusy((Boolean)object);
    }
}

