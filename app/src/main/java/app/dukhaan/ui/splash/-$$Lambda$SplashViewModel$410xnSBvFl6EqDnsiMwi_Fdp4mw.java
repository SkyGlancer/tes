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

public final class -$$Lambda$SplashViewModel$410xnSBvFl6EqDnsiMwi_Fdp4mw
implements Consumer {
    public final /* synthetic */ SplashViewModel f$0;

    public /* synthetic */ -$$Lambda$SplashViewModel$410xnSBvFl6EqDnsiMwi_Fdp4mw(SplashViewModel splashViewModel) {
        this.f$0 = splashViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$fetchOrders$5$SplashViewModel((OrdersListResponse)object);
    }
}

