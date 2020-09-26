/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.splash;

import app.dukhaan.network.model.OrdersListResponse;
import app.dukhaan.ui.splash.SplashViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$SplashViewModel$A147F_F8ri9HzhvuyccrYm5IgjY
implements Consumer {
    public final /* synthetic */ SplashViewModel f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ -$$Lambda$SplashViewModel$A147F_F8ri9HzhvuyccrYm5IgjY(SplashViewModel splashViewModel, boolean bl) {
        this.f$0 = splashViewModel;
        this.f$1 = bl;
    }

    public final void accept(Object object) {
        this.f$0.lambda$fetchOrders$6$SplashViewModel(this.f$1, (OrdersListResponse)object);
    }
}

