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
 *  java.lang.String
 *  java.util.List
 *  java.util.ListIterator
 */
package app.dukhaan.ui.views.orders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.network.model.Order;
import app.dukhaan.ui.views.orders.-$$Lambda$PendingOrdersListAdapter$EsDKYSEoKvpYrKoxPignp5Lr-Oo;
import app.dukhaan.ui.views.orders.-$$Lambda$PendingOrdersListAdapter$hcVQVZ5zDzr5UU42lQiRlvZXKOs;
import app.dukhaan.ui.views.orders.-$$Lambda$PendingOrdersListAdapter$tKGNJh2dAj5WIpn98k427MtZuYc;
import app.dukhaan.ui.views.orders.OrderListItemCard;
import java.util.List;
import java.util.ListIterator;

public class PendingOrdersListAdapter
extends RecyclerView.Adapter<ViewHolder> {
    private PendingOrdersListAdapterListener listener;
    private List<Order> orders;
    private boolean showFullDetails;

    public PendingOrdersListAdapter(PendingOrdersListAdapterListener pendingOrdersListAdapterListener) {
        this.listener = pendingOrdersListAdapterListener;
    }

    public int getItemCount() {
        List<Order> list = this.orders;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$PendingOrdersListAdapter(Order order) {
        this.listener.onOrderDetailsClicked(order);
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$PendingOrdersListAdapter(Order order, View view) {
        this.listener.onOrderDetailsClicked(order);
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$PendingOrdersListAdapter(Order order, String string2) {
        this.listener.onUpdateOrderStatus(order, string2);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int n) {
        Order order = (Order)((Object)this.orders.get(n));
        viewHolder.card.setOrder(order);
        viewHolder.card.enableActionButtons(true);
        viewHolder.card.enableMinVersion(true ^ this.showFullDetails);
        viewHolder.card.setListener(new -$$Lambda$PendingOrdersListAdapter$tKGNJh2dAj5WIpn98k427MtZuYc(this));
        viewHolder.card.setOnClickListener((View.OnClickListener)new -$$Lambda$PendingOrdersListAdapter$EsDKYSEoKvpYrKoxPignp5Lr-Oo(this, order));
        viewHolder.card.setActionListener(new -$$Lambda$PendingOrdersListAdapter$hcVQVZ5zDzr5UU42lQiRlvZXKOs(this));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new ViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131558599, viewGroup, false));
    }

    public void removeItem(Order order) {
        ListIterator listIterator = this.orders.listIterator();
        int n = -1;
        while (listIterator.hasNext()) {
            if (!((Order)((Object)listIterator.next())).equals((Object)order)) continue;
            n = this.orders.indexOf((Object)order);
            listIterator.remove();
        }
        if (n >= 0) {
            this.notifyItemRemoved(n);
            return;
        }
        this.notifyDataSetChanged();
    }

    public void setData(List<Order> list) {
        this.orders = list;
        this.notifyDataSetChanged();
    }

    public void setShowFullDetails(boolean bl) {
        this.showFullDetails = bl;
    }

    public void updateItem(Order order) {
        ListIterator listIterator = this.orders.listIterator();
        int n = -1;
        while (listIterator.hasNext()) {
            if (!((Order)((Object)listIterator.next())).equals((Object)order)) continue;
            n = this.orders.indexOf((Object)order);
            listIterator.set((Object)order);
        }
        if (n >= 0) {
            this.notifyItemChanged(n);
            return;
        }
        this.notifyDataSetChanged();
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

