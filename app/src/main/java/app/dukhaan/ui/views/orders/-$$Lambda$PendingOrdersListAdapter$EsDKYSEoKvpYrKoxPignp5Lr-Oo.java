/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  app.dukhaan.network.model.Order
 *  app.dukhaan.ui.views.orders.PendingOrdersListAdapter
 *  java.lang.Object
 */
package app.dukhaan.ui.views.orders;

import android.view.View;
import app.dukhaan.network.model.Order;
import app.dukhaan.ui.views.orders.PendingOrdersListAdapter;

public final class -$$Lambda$PendingOrdersListAdapter$EsDKYSEoKvpYrKoxPignp5Lr-Oo
implements View.OnClickListener {
    public final /* synthetic */ PendingOrdersListAdapter f$0;
    public final /* synthetic */ Order f$1;

    public /* synthetic */ -$$Lambda$PendingOrdersListAdapter$EsDKYSEoKvpYrKoxPignp5Lr-Oo(PendingOrdersListAdapter pendingOrdersListAdapter, Order order) {
        this.f$0 = pendingOrdersListAdapter;
        this.f$1 = order;
    }

    public final void onClick(View view) {
        this.f$0.lambda$onBindViewHolder$1$PendingOrdersListAdapter(this.f$1, view);
    }
}

