/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package app.dukhaan.ui.views.orders;

import app.dukhaan.network.model.Order;
import app.dukhaan.ui.views.orders.OrderListItemCard;
import app.dukhaan.ui.views.orders.PendingOrdersListAdapter;

public final class -$$Lambda$PendingOrdersListAdapter$tKGNJh2dAj5WIpn98k427MtZuYc
implements OrderListItemCard.OrderListItemCardListener {
    public final /* synthetic */ PendingOrdersListAdapter f$0;

    public /* synthetic */ -$$Lambda$PendingOrdersListAdapter$tKGNJh2dAj5WIpn98k427MtZuYc(PendingOrdersListAdapter pendingOrdersListAdapter) {
        this.f$0 = pendingOrdersListAdapter;
    }

    @Override
    public final void onDetailsClicked(Order order) {
        this.f$0.lambda$onBindViewHolder$0$PendingOrdersListAdapter(order);
    }
}

