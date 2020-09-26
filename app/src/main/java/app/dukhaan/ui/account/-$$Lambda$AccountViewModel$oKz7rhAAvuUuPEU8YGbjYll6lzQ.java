/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.account.AccountViewModel
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.account;

import app.dukhaan.network.model.AddBusinessResponse;
import app.dukhaan.ui.account.AccountViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$AccountViewModel$oKz7rhAAvuUuPEU8YGbjYll6lzQ
implements Consumer {
    public final /* synthetic */ AccountViewModel f$0;

    public /* synthetic */ -$$Lambda$AccountViewModel$oKz7rhAAvuUuPEU8YGbjYll6lzQ(AccountViewModel accountViewModel) {
        this.f$0 = accountViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$updateBusinessDetails$1$AccountViewModel((AddBusinessResponse)object);
    }
}

