/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  app.dukhaan.network.model.Order
 *  app.dukhaan.ui.views.orders.OrdersListAdapter
 *  java.lang.Object
 */
package app.dukhaan.ui.views.orders;

import android.view.View;
import app.dukhaan.network.model.Order;
import app.dukhaan.ui.views.orders.OrdersListAdapter;

public final class -$$Lambda$OrdersListAdapter$DXnTJ0dO_6DYhwk6m87zh1AC1S0
implements View.OnClickListener {
    public final /* synthetic */ OrdersListAdapter f$0;
    public final /* synthetic */ Order f$1;

    public /* synthetic */ -$$Lambda$OrdersListAdapter$DXnTJ0dO_6DYhwk6m87zh1AC1S0(OrdersListAdapter ordersListAdapter, Order order) {
        this.f$0 = ordersListAdapter;
        this.f$1 = order;
    }

    public final void onClick(View view) {
        this.f$0.lambda$onBindViewHolder$1$OrdersListAdapter(this.f$1, view);
    }
}

