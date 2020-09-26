/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.orders_list;

import app.dukhaan.network.model.OrdersListResponse;
import app.dukhaan.ui.orders_list.OrdersListViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$OrdersListViewModel$hkXWgh13nkf1HTPtVc0VghSq7-4
implements Consumer {
    public final /* synthetic */ OrdersListViewModel f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ -$$Lambda$OrdersListViewModel$hkXWgh13nkf1HTPtVc0VghSq7-4(OrdersListViewModel ordersListViewModel, int n, boolean bl, String string2) {
        this.f$0 = ordersListViewModel;
        this.f$1 = n;
        this.f$2 = bl;
        this.f$3 = string2;
    }

    public final void accept(Object object) {
        this.f$0.lambda$fetchOrders$2$OrdersListViewModel(this.f$1, this.f$2, this.f$3, (OrdersListResponse)object);
    }
}

