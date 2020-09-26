package app.dukhaan.ui.ui.views.orders;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import app.dukhaan.network.model.Order;
import java.util.List;

public class OrdersListAdapter extends Adapter<app.dukhaan.ui.views.orders.OrdersListAdapter.ViewHolder> {
   private app.dukhaan.ui.views.orders.OrdersListAdapter.OrdersListAdapterListener listener;
   private List<Order> orders;
   private boolean showFullDetails;

   public OrdersListAdapter(app.dukhaan.ui.views.orders.OrdersListAdapter.OrdersListAdapterListener var1) {
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

   public void onBindViewHolder(app.dukhaan.ui.views.orders.OrdersListAdapter.ViewHolder var1, int var2) {
      Order var3 = (Order)this.orders.get(var2);
      var1.card.setOrder(var3);
      var1.card.enableMinVersion(this.showFullDetails ^ true);
      var1.card.setListener(new _$$Lambda$OrdersListAdapter$7T1igpDPmNOBzbgWVe5NTDFOzYk(this));
      var1.card.setOnClickListener(new _$$Lambda$OrdersListAdapter$DXnTJ0dO_6DYhwk6m87zh1AC1S0(this, var3));
   }

   public app.dukhaan.ui.views.orders.OrdersListAdapter.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new app.dukhaan.ui.views.orders.OrdersListAdapter.ViewHolder(this, LayoutInflater.from(var1.getContext()).inflate(order_list_item, var1, false));
   }

   public void setData(List<Order> var1) {
      this.orders = var1;
      this.notifyDataSetChanged();
   }

   public void setShowFullDetails(boolean var1) {
      this.showFullDetails = var1;
   }
}
