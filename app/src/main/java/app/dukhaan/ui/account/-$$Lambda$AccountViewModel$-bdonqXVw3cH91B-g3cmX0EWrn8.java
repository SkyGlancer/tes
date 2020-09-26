/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.account.AccountViewModel
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.account;

import app.dukhaan.network.model.AwardStatsResponse;
import app.dukhaan.ui.account.AccountViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$AccountViewModel$-bdonqXVw3cH91B-g3cmX0EWrn8
implements Consumer {
    public final /* synthetic */ AccountViewModel f$0;

    public /* synthetic */ -$$Lambda$AccountViewModel$-bdonqXVw3cH91B-g3cmX0EWrn8(AccountViewModel accountViewModel) {
        this.f$0 = accountViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$getAwardsStats$7$AccountViewModel((AwardStatsResponse)object);
    }
}

