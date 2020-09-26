/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.home.HomeViewModel
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.home;

import app.dukhaan.network.model.OrdersListResponse;
import app.dukhaan.ui.home.HomeViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$HomeViewModel$n8m4lnUJAHmoTYhzNUzjOBbrftw
implements Consumer {
    public final /* synthetic */ HomeViewModel f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ -$$Lambda$HomeViewModel$n8m4lnUJAHmoTYhzNUzjOBbrftw(HomeViewModel homeViewModel, int n, boolean bl, String string2) {
        this.f$0 = homeViewModel;
        this.f$1 = n;
        this.f$2 = bl;
        this.f$3 = string2;
    }

    public final void accept(Object object) {
        this.f$0.lambda$fetchOrders$6$HomeViewModel(this.f$1, this.f$2, this.f$3, (OrdersListResponse)object);
    }
}

