/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.viewbinding.ViewBinding
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import app.dukhaan.ui.views.orders.OrderListItemCard;

public final class OrderListItemBinding
implements ViewBinding {
    public final OrderListItemCard card;
    private final OrderListItemCard rootView;

    private OrderListItemBinding(OrderListItemCard orderListItemCard, OrderListItemCard orderListItemCard2) {
        this.rootView = orderListItemCard;
        this.card = orderListItemCard2;
    }

    public static OrderListItemBinding bind(View view) {
        if (view != null) {
            OrderListItemCard orderListItemCard = (OrderListItemCard)view;
            return new OrderListItemBinding(orderListItemCard, orderListItemCard);
        }
        throw new NullPointerException("rootView");
    }

    public static OrderListItemBinding inflate(LayoutInflater layoutInflater) {
        return OrderListItemBinding.inflate(layoutInflater, null, false);
    }

    public static OrderListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558599, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return OrderListItemBinding.bind(view);
    }

    public OrderListItemCard getRoot() {
        return this.rootView;
    }
}

