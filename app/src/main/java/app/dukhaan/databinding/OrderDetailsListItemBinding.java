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
import app.dukhaan.ui.views.orders.OrderDetailsListItemCard;

public final class OrderDetailsListItemBinding
implements ViewBinding {
    public final OrderDetailsListItemCard card;
    private final OrderDetailsListItemCard rootView;

    private OrderDetailsListItemBinding(OrderDetailsListItemCard orderDetailsListItemCard, OrderDetailsListItemCard orderDetailsListItemCard2) {
        this.rootView = orderDetailsListItemCard;
        this.card = orderDetailsListItemCard2;
    }

    public static OrderDetailsListItemBinding bind(View view) {
        if (view != null) {
            OrderDetailsListItemCard orderDetailsListItemCard = (OrderDetailsListItemCard)view;
            return new OrderDetailsListItemBinding(orderDetailsListItemCard, orderDetailsListItemCard);
        }
        throw new NullPointerException("rootView");
    }

    public static OrderDetailsListItemBinding inflate(LayoutInflater layoutInflater) {
        return OrderDetailsListItemBinding.inflate(layoutInflater, null, false);
    }

    public static OrderDetailsListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558598, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return OrderDetailsListItemBinding.bind(view);
    }

    public OrderDetailsListItemCard getRoot() {
        return this.rootView;
    }
}

