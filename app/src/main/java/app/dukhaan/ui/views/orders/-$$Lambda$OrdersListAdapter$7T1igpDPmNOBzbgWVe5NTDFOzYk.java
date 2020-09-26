/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package app.dukhaan.ui.views.orders;

import app.dukhaan.network.model.Order;
import app.dukhaan.ui.views.orders.OrderListItemCard;
import app.dukhaan.ui.views.orders.OrdersListAdapter;

public final class -$$Lambda$OrdersListAdapter$7T1igpDPmNOBzbgWVe5NTDFOzYk
implements OrderListItemCard.OrderListItemCardListener {
    public final /* synthetic */ OrdersListAdapter f$0;

    public /* synthetic */ -$$Lambda$OrdersListAdapter$7T1igpDPmNOBzbgWVe5NTDFOzYk(OrdersListAdapter ordersListAdapter) {
        this.f$0 = ordersListAdapter;
    }

    @Override
    public final void onDetailsClicked(Order order) {
        this.f$0.lambda$onBindViewHolder$0$OrdersListAdapter(order);
    }
}

