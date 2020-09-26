package app.dukhaan.ui.ui.views.orders;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import app.dukhaan.data.model.Product;
import java.util.List;

public class OrderDetailListAdapter extends Adapter<app.dukhaan.ui.views.orders.OrderDetailListAdapter.OrderDetailViewHolder> {
   private List<Product> orders;

   public OrderDetailListAdapter() {
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

   public void onBindViewHolder(app.dukhaan.ui.views.orders.OrderDetailListAdapter.OrderDetailViewHolder var1, int var2) {
      Product var3 = (Product)this.orders.get(var2);
      var1.card.setData(var3);
   }

   public app.dukhaan.ui.views.orders.OrderDetailListAdapter.OrderDetailViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new app.dukhaan.ui.views.orders.OrderDetailListAdapter.OrderDetailViewHolder(this, LayoutInflater.from(var1.getContext()).inflate(order_details_list_item, var1, false));
   }

   public void setData(List<Product> var1) {
      this.orders = var1;
      this.notifyDataSetChanged();
   }
}
