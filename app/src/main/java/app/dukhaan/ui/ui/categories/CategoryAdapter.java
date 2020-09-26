package app.dukhaan.ui.ui.categories;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import app.dukhaan.databinding.LayoutCategoryListItemBinding;
import app.dukhaan.network.model.Category;
import app.dukhaan.ui.categories.CategoryAdapter.1;
import java.util.List;

public class CategoryAdapter extends Adapter<app.dukhaan.ui.categories.CategoryAdapter.ViewHolder> {
   private List<Category> categoryList;
   app.dukhaan.ui.categories.CategoryAdapter.CategoryListItemClick categoryListItemClick;
   private app.dukhaan.ui.categories.CategoryAdapter.CategoryMenuItemClickListener listener;

   public CategoryAdapter(app.dukhaan.ui.categories.CategoryAdapter.CategoryMenuItemClickListener var1, List<Category> var2, app.dukhaan.ui.categories.CategoryAdapter.CategoryListItemClick var3) {
      this.categoryList = var2;
      this.listener = var1;
      this.categoryListItemClick = var3;
   }

   public int getItemCount() {
      return this.categoryList.size();
   }

   public void onBindViewHolder(app.dukhaan.ui.categories.CategoryAdapter.ViewHolder var1, int var2) {
      var1.bind(var2);
      app.dukhaan.ui.categories.CategoryAdapter.ViewHolder.access$000(var1).category.setOnClickListener(new 1(this, var2));
   }

   public app.dukhaan.ui.categories.CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new app.dukhaan.ui.categories.CategoryAdapter.ViewHolder(this, (LayoutCategoryListItemBinding)DataBindingUtil.inflate(LayoutInflater.from(var1.getContext()), layout_category_list_item, var1, false));
   }
}
