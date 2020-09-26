package app.dukhaan.ui.ui.products;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import app.dukhaan.databinding.ItemProductCategoryListItemBinding;
import app.dukhaan.network.model.Category;
import java.util.List;

public class AddProductCategoryListAdapter extends Adapter<app.dukhaan.ui.products.AddProductCategoryListAdapter.ViewHolder> {
   private List<Category> categoryList;
   private app.dukhaan.ui.products.AddProductCategoryListAdapter.categoryItemClick iCategoryItemClick;

   public AddProductCategoryListAdapter(List<Category> var1) {
      this.categoryList = var1;
   }

   public int getItemCount() {
      List var1 = this.categoryList;
      int var2;
      if (var1 == null) {
         var2 = 0;
      } else {
         var2 = var1.size();
      }

      return var2;
   }

   public void onBindViewHolder(app.dukhaan.ui.products.AddProductCategoryListAdapter.ViewHolder var1, int var2) {
      var1.bind(var2);
      var1.itemView.setOnClickListener(new _$$Lambda$AddProductCategoryListAdapter$O4k1_1JWrD_eK2m3tQwA5kQUjQ8(this, var1));
   }

   public app.dukhaan.ui.products.AddProductCategoryListAdapter.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new app.dukhaan.ui.products.AddProductCategoryListAdapter.ViewHolder(this, (ItemProductCategoryListItemBinding)DataBindingUtil.inflate(LayoutInflater.from(var1.getContext()), item_product_category_list_item, var1, false));
   }

   public void setCategoryItemClick(app.dukhaan.ui.products.AddProductCategoryListAdapter.categoryItemClick var1) {
      this.iCategoryItemClick = var1;
   }

   public void updateData(List<Category> var1) {
      var1.add(new Category());
      this.categoryList.clear();
      this.categoryList.addAll(var1);
      this.notifyDataSetChanged();
   }
}
