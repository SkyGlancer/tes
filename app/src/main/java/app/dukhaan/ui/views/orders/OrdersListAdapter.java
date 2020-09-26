/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
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
import app.dukhaan.network.model.Order;
import app.dukhaan.ui.views.orders.-$$Lambda$OrdersListAdapter$7T1igpDPmNOBzbgWVe5NTDFOzYk;
import app.dukhaan.ui.views.orders.-$$Lambda$OrdersListAdapter$DXnTJ0dO_6DYhwk6m87zh1AC1S0;
import app.dukhaan.ui.views.orders.OrderListItemCard;
import java.util.List;

public class OrdersListAdapter
extends RecyclerView.Adapter<ViewHolder> {
    private OrdersListAdapterListener listener;
    private List<Order> orders;
    private boolean showFullDetails;

    public OrdersListAdapter(OrdersListAdapterListener ordersListAdapterListener) {
        this.listener = ordersListAdapterListener;
    }

    public int getItemCount() {
        List<Order> list = this.orders;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$OrdersListAdapter(Order order) {
        this.listener.onOrderDetailsClicked(order);
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$OrdersListAdapter(Order order, View view) {
        this.listener.onOrderDetailsClicked(order);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int n) {
        Order order = (Order)((Object)this.orders.get(n));
        viewHolder.card.setOrder(order);
        viewHolder.card.enableMinVersion(true ^ this.showFullDetails);
        viewHolder.card.setListener(new -$$Lambda$OrdersListAdapter$7T1igpDPmNOBzbgWVe5NTDFOzYk(this));
        viewHolder.card.setOnClickListener((View.OnClickListener)new -$$Lambda$OrdersListAdapter$DXnTJ0dO_6DYhwk6m87zh1AC1S0(this, order));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new ViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131558599, viewGroup, false));
    }

    public void setData(List<Order> list) {
        this.orders = list;
        this.notifyDataSetChanged();
    }

    public void setShowFullDetails(boolean bl) {
        this.showFullDetails = bl;
    }

    class ViewHolder
    extends RecyclerView.ViewHolder {
        OrderListItemCard card;

        ViewHolder(View view) {
            super(view);
            this.card = (OrderListItemCard)view.findViewById(2131361928);
        }
    }

}

