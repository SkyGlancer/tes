/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  androidx.databinding.DataBindingUtil
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  app.dukhaan.network.model.Category
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.ui.categories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.databinding.LayoutCategoryListItemBinding;
import app.dukhaan.network.model.Category;
import app.dukhaan.ui.categories.CategoryAdapter;
import app.dukhaan.ui.views.categories.CategoryListItemCard;
import java.util.List;

public class CategoryAdapter
extends RecyclerView.Adapter<ViewHolder> {
    private List<Category> categoryList;
    CategoryListItemClick categoryListItemClick;
    private CategoryMenuItemClickListener listener;

    public CategoryAdapter(CategoryMenuItemClickListener categoryMenuItemClickListener, List<Category> list, CategoryListItemClick categoryListItemClick) {
        this.categoryList = list;
        this.listener = categoryMenuItemClickListener;
        this.categoryListItemClick = categoryListItemClick;
    }

    public int getItemCount() {
        return this.categoryList.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int n) {
        viewHolder.bind(n);
        ViewHolder.access$000((ViewHolder)viewHolder).category.setOnClickListener(new View.OnClickListener(this, n){
            final /* synthetic */ CategoryAdapter this$0;
            final /* synthetic */ int val$position;
            {
                this.this$0 = categoryAdapter;
                this.val$position = n;
            }

            public void onClick(View view) {
                this.this$0.categoryListItemClick.categoryListItem(this.val$position);
            }
        });
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new ViewHolder((LayoutCategoryListItemBinding)DataBindingUtil.inflate((LayoutInflater)LayoutInflater.from((Context)viewGroup.getContext()), (int)2131558531, (ViewGroup)viewGroup, (boolean)false));
    }

    class ViewHolder
    extends RecyclerView.ViewHolder
    implements CategoryListItemCard.MenuItemClickedListener {
        private LayoutCategoryListItemBinding binding;
        private int position;

        ViewHolder(LayoutCategoryListItemBinding layoutCategoryListItemBinding) {
            super(layoutCategoryListItemBinding.getRoot());
            this.binding = layoutCategoryListItemBinding;
        }

        static /* synthetic */ LayoutCategoryListItemBinding access$000(ViewHolder viewHolder) {
            return viewHolder.binding;
        }

        void bind(int n) {
            this.position = n;
            Category category = (Category)CategoryAdapter.this.categoryList.get(n);
            this.binding.category.setMenuClickListener(this);
            this.binding.category.setData(category);
        }

        @Override
        public void onDeleteCategoryClicked() {
            CategoryAdapter.this.listener.onDeleteCategoryClicked(this.position);
        }

        @Override
        public void onEditCategoryNameClicked() {
            CategoryAdapter.this.listener.onEditCategoryClicked(this.position);
        }

        @Override
        public void onShareCategoryClicked() {
            CategoryAdapter.this.listener.onShareCategoryClicked(this.position);
        }
    }

}

