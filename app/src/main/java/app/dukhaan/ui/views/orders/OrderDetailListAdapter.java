/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.ui.views.orders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.data.model.Product;
import app.dukhaan.ui.views.orders.OrderDetailsListItemCard;
import java.util.List;

public class OrderDetailListAdapter
extends RecyclerView.Adapter<OrderDetailViewHolder> {
    private List<Product> orders;

    public int getItemCount() {
        List<Product> list = this.orders;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void onBindViewHolder(OrderDetailViewHolder orderDetailViewHolder, int n) {
        Product product = (Product)((Object)this.orders.get(n));
        orderDetailViewHolder.card.setData(product);
    }

    public OrderDetailViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new OrderDetailViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131558598, viewGroup, false));
    }

    public void setData(List<Product> list) {
        this.orders = list;
        this.notifyDataSetChanged();
    }

    public class OrderDetailViewHolder
    extends RecyclerView.ViewHolder {
        OrderDetailsListItemCard card;

        OrderDetailViewHolder(View view) {
            super(view);
            this.card = (OrderDetailsListItemCard)view.findViewById(2131361928);
        }
    }

}

