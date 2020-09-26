/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.databinding.DataBindingUtil
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.List
 */
package app.dukhaan.ui.products;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.databinding.ItemProductCategoryListItemBinding;
import app.dukhaan.network.model.Category;
import app.dukhaan.ui.products.-$$Lambda$AddProductCategoryListAdapter$O4k1_1JWrD_eK2m3tQwA5kQUjQ8;
import java.util.Collection;
import java.util.List;

public class AddProductCategoryListAdapter
extends RecyclerView.Adapter<ViewHolder> {
    private List<Category> categoryList;
    private categoryItemClick iCategoryItemClick;

    public AddProductCategoryListAdapter(List<Category> list) {
        this.categoryList = list;
    }

    public int getItemCount() {
        List<Category> list = this.categoryList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$AddProductCategoryListAdapter(ViewHolder viewHolder, View view) {
        this.iCategoryItemClick.selectCategoryItem((Category)((Object)this.categoryList.get(viewHolder.getAdapterPosition())));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int n) {
        viewHolder.bind(n);
        viewHolder.itemView.setOnClickListener((View.OnClickListener)new -$$Lambda$AddProductCategoryListAdapter$O4k1_1JWrD_eK2m3tQwA5kQUjQ8(this, viewHolder));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new ViewHolder((ItemProductCategoryListItemBinding)DataBindingUtil.inflate((LayoutInflater)LayoutInflater.from((Context)viewGroup.getContext()), (int)2131558526, (ViewGroup)viewGroup, (boolean)false));
    }

    public void setCategoryItemClick(categoryItemClick categoryItemClick2) {
        this.iCategoryItemClick = categoryItemClick2;
    }

    public void updateData(List<Category> list) {
        list.add((Object)new Category());
        this.categoryList.clear();
        this.categoryList.addAll(list);
        this.notifyDataSetChanged();
    }

    class ViewHolder
    extends RecyclerView.ViewHolder {
        private ItemProductCategoryListItemBinding binding;
        private int position;

        ViewHolder(ItemProductCategoryListItemBinding itemProductCategoryListItemBinding) {
            super(itemProductCategoryListItemBinding.getRoot());
            this.binding = itemProductCategoryListItemBinding;
        }

        void bind(int n) {
            this.position = n;
            Category category = (Category)((Object)AddProductCategoryListAdapter.this.categoryList.get(n));
            this.binding.idCategoryName.setText((CharSequence)category.realmGet$name());
        }
    }

}

