/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.main;

import app.dukhaan.network.model.BusinessStatsResponse;
import app.dukhaan.ui.main.MainActivityViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$MainActivityViewModel$xv35ldJ6asiPNLOA1Qb6MCKTegs
implements Consumer {
    public final /* synthetic */ MainActivityViewModel f$0;

    public /* synthetic */ -$$Lambda$MainActivityViewModel$xv35ldJ6asiPNLOA1Qb6MCKTegs(MainActivityViewModel mainActivityViewModel) {
        this.f$0 = mainActivityViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$getBusinessStats$3$MainActivityViewModel((BusinessStatsResponse)object);
    }
}

