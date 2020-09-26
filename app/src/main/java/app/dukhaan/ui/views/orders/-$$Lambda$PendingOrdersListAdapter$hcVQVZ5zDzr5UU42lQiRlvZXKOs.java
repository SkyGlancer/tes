/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.views.orders;

import app.dukhaan.network.model.Order;
import app.dukhaan.ui.views.orders.OrderListItemCard;
import app.dukhaan.ui.views.orders.PendingOrdersListAdapter;

public final class -$$Lambda$PendingOrdersListAdapter$hcVQVZ5zDzr5UU42lQiRlvZXKOs
implements OrderListItemCard.OrderListItemCardActionListener {
    public final /* synthetic */ PendingOrdersListAdapter f$0;

    public /* synthetic */ -$$Lambda$PendingOrdersListAdapter$hcVQVZ5zDzr5UU42lQiRlvZXKOs(PendingOrdersListAdapter pendingOrdersListAdapter) {
        this.f$0 = pendingOrdersListAdapter;
    }

    @Override
    public final void onUpdateOrderStatus(Order order, String string2) {
        this.f$0.lambda$onBindViewHolder$2$PendingOrdersListAdapter(order, string2);
    }
}

