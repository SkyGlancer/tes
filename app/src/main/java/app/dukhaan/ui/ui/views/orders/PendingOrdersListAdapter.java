package app.dukhaan.ui.ui.views.orders;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import app.dukhaan.network.model.Order;
import java.util.List;
import java.util.ListIterator;

public class PendingOrdersListAdapter extends Adapter<app.dukhaan.ui.views.orders.PendingOrdersListAdapter.ViewHolder> {
   private app.dukhaan.ui.views.orders.PendingOrdersListAdapter.PendingOrdersListAdapterListener listener;
   private List<Order> orders;
   private boolean showFullDetails;

   public PendingOrdersListAdapter(app.dukhaan.ui.views.orders.PendingOrdersListAdapter.PendingOrdersListAdapterListener var1) {
      this.listener = var1;
   }

   public int getItemCount() {
      List var1 = this.orders;
      int var2;
      if (var1 == null) {
         var2 = 0;
      } else {
         var2 = var1.size();
      }

      return var2;
   }

   public void onBindViewHolder(app.dukhaan.ui.views.orders.PendingOrdersListAdapter.ViewHolder var1, int var2) {
      Order var3 = (Order)this.orders.get(var2);
      var1.card.setOrder(var3);
      var1.card.enableActionButtons(true);
      var1.card.enableMinVersion(true ^ this.showFullDetails);
      var1.card.setListener(new _$$Lambda$PendingOrdersListAdapter$tKGNJh2dAj5WIpn98k427MtZuYc(this));
      var1.card.setOnClickListener(new _$$Lambda$PendingOrdersListAdapter$EsDKYSEoKvpYrKoxPignp5Lr_Oo(this, var3));
      var1.card.setActionListener(new _$$Lambda$PendingOrdersListAdapter$hcVQVZ5zDzr5UU42lQiRlvZXKOs(this));
   }

   public app.dukhaan.ui.views.orders.PendingOrdersListAdapter.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new app.dukhaan.ui.views.orders.PendingOrdersListAdapter.ViewHolder(this, LayoutInflater.from(var1.getContext()).inflate(order_list_item, var1, false));
   }

   public void removeItem(Order var1) {
      ListIterator var2 = this.orders.listIterator();
      int var3 = -1;

      while(var2.hasNext()) {
         if (((Order)var2.next()).equals(var1)) {
            var3 = this.orders.indexOf(var1);
            var2.remove();
         }
      }

      if (var3 >= 0) {
         this.notifyItemRemoved(var3);
      } else {
         this.notifyDataSetChanged();
      }

   }

   public void setData(List<Order> var1) {
      this.orders = var1;
      this.notifyDataSetChanged();
   }

   public void setShowFullDetails(boolean var1) {
      this.showFullDetails = var1;
   }

   public void updateItem(Order var1) {
      ListIterator var2 = this.orders.listIterator();
      int var3 = -1;

      while(var2.hasNext()) {
         if (((Order)var2.next()).equals(var1)) {
            var3 = this.orders.indexOf(var1);
            var2.set(var1);
         }
      }

      if (var3 >= 0) {
         this.notifyItemChanged(var3);
      } else {
         this.notifyDataSetChanged();
      }

   }
}
