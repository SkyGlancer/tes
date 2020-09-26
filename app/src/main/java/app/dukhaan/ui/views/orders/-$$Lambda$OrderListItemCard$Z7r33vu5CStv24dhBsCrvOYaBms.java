/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package app.dukhaan.ui.views.orders;

import app.dukhaan.ui.views.orders.OrderListItemCard;
import app.dukhaan.ui.views.orderstatusdialog.IOrderStatusItemClickListener;
import app.dukhaan.ui.views.orderstatusdialog.OrderStatusDialogType;

public final class -$$Lambda$OrderListItemCard$Z7r33vu5CStv24dhBsCrvOYaBms
implements IOrderStatusItemClickListener {
    public final /* synthetic */ OrderListItemCard f$0;

    public /* synthetic */ -$$Lambda$OrderListItemCard$Z7r33vu5CStv24dhBsCrvOYaBms(OrderListItemCard orderListItemCard) {
        this.f$0 = orderListItemCard;
    }

    @Override
    public final void positiveStatus(OrderStatusDialogType orderStatusDialogType) {
        this.f$0.lambda$null$5$OrderListItemCard(orderStatusDialogType);
    }
}

