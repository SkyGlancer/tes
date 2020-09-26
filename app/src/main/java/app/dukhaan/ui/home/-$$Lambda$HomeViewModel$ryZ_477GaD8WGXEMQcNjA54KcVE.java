/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.network.model.Order
 *  app.dukhaan.ui.home.HomeViewModel
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.home;

import app.dukhaan.network.model.Order;
import app.dukhaan.network.model.UpdateOrderStatusResponse;
import app.dukhaan.ui.home.HomeViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$HomeViewModel$ryZ_477GaD8WGXEMQcNjA54KcVE
implements Consumer {
    public final /* synthetic */ HomeViewModel f$0;
    public final /* synthetic */ Order f$1;

    public /* synthetic */ -$$Lambda$HomeViewModel$ryZ_477GaD8WGXEMQcNjA54KcVE(HomeViewModel homeViewModel, Order order) {
        this.f$0 = homeViewModel;
        this.f$1 = order;
    }

    public final void accept(Object object) {
        this.f$0.lambda$updateOrderStatus$10$HomeViewModel(this.f$1, (UpdateOrderStatusResponse)object);
    }
}

