/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.orders_list;

import app.dukhaan.ui.orders_list.OrdersListViewModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$OrdersListViewModel$H53nvhKTOMJyt5ZPXooD2Lsg6_g
implements Consumer {
    public final /* synthetic */ OrdersListViewModel f$0;

    public /* synthetic */ -$$Lambda$OrdersListViewModel$H53nvhKTOMJyt5ZPXooD2Lsg6_g(OrdersListViewModel ordersListViewModel) {
        this.f$0 = ordersListViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$fetchOrders$0$OrdersListViewModel((Disposable)object);
    }
}

