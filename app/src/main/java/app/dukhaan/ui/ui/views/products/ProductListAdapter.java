package app.dukhaan.ui.ui.views.products;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import app.dukhaan.data.model.Product;
import app.dukhaan.databinding.ProductListItemBinding;
import app.dukhaan.ui.views.products.ProductListAdapter.1;
import java.util.List;

public class ProductListAdapter extends Adapter<app.dukhaan.ui.views.products.ProductListAdapter.ProductViewHolder> {
   static app.dukhaan.ui.views.products.ProductListAdapter.ProductMenuItemClickListener listener;
   app.dukhaan.ui.views.products.ProductListAdapter.ProductItemClick productItemClick;
   private List<Product> productsList;

   public ProductListAdapter(app.dukhaan.ui.views.products.ProductListAdapter.ProductMenuItemClickListener var1, List<Product> var2, app.dukhaan.ui.views.products.ProductListAdapter.ProductItemClick var3) {
      listener = var1;
      this.productsList = var2;
      this.productItemClick = var3;
   }

   public int getItemCount() {
      List var1 = this.productsList;
      int var2;
      if (var1 == null) {
         var2 = 0;
      } else {
         var2 = var1.size();
      }

      return var2;
   }

   public List<Product> getProductList() {
      return this.productsList;
   }

   public void onBindViewHolder(app.dukhaan.ui.views.products.ProductListAdapter.ProductViewHolder var1, int var2) {
      var1.bind(var2);
      var1.itemView.setOnClickListener(new 1(this, var1));
   }

   public app.dukhaan.ui.views.products.ProductListAdapter.ProductViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new app.dukhaan.ui.views.products.ProductListAdapter.ProductViewHolder(this, (ProductListItemBinding)DataBindingUtil.inflate(LayoutInflater.from(var1.getContext()), product_list_item, var1, false));
   }

   public void setData(List<Product> var1) {
      this.productsList = var1;
      this.notifyDataSetChanged();
   }
}
