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
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.ui.views.products;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.data.model.Product;
import app.dukhaan.databinding.ProductListItemBinding;
import app.dukhaan.ui.views.products.ProductListAdapter;
import app.dukhaan.ui.views.products.ProductListItemCard;
import java.util.List;

public class ProductListAdapter
extends RecyclerView.Adapter<ProductViewHolder> {
    static ProductMenuItemClickListener listener;
    ProductItemClick productItemClick;
    private List<Product> productsList;

    public ProductListAdapter(ProductMenuItemClickListener productMenuItemClickListener, List<Product> list, ProductItemClick productItemClick) {
        listener = productMenuItemClickListener;
        this.productsList = list;
        this.productItemClick = productItemClick;
    }

    public int getItemCount() {
        List<Product> list = this.productsList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<Product> getProductList() {
        return this.productsList;
    }

    public void onBindViewHolder(ProductViewHolder productViewHolder, int n) {
        productViewHolder.bind(n);
        productViewHolder.itemView.setOnClickListener(new View.OnClickListener(this, productViewHolder){
            final /* synthetic */ ProductListAdapter this$0;
            final /* synthetic */ ProductViewHolder val$holder;
            {
                this.this$0 = productListAdapter;
                this.val$holder = productViewHolder;
            }

            public void onClick(View view) {
                this.this$0.productItemClick.onItemClickListener(this.val$holder.getAdapterPosition());
            }
        });
    }

    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new ProductViewHolder((ProductListItemBinding)DataBindingUtil.inflate((LayoutInflater)LayoutInflater.from((Context)viewGroup.getContext()), (int)2131558622, (ViewGroup)viewGroup, (boolean)false));
    }

    public void setData(List<Product> list) {
        this.productsList = list;
        this.notifyDataSetChanged();
    }

    class ProductViewHolder
    extends RecyclerView.ViewHolder
    implements ProductListItemCard.MenuItemClickedListener {
        ProductListItemBinding binding;
        private int position;

        ProductViewHolder(ProductListItemBinding productListItemBinding) {
            super(productListItemBinding.getRoot());
            this.binding = productListItemBinding;
        }

        void bind(int n) {
            this.position = n;
            Product product = (Product)((Object)ProductListAdapter.this.productsList.get(n));
            this.binding.product.setMenuClickListener(this);
            this.binding.product.setData(product);
        }

        @Override
        public void onDeleteCategoryClicked() {
            ProductListAdapter.listener.onDeleteProductClicked(this.position);
        }

        @Override
        public void onEditCategoryNameClicked() {
            ProductListAdapter.listener.onEditProductClicked(this.position);
        }

        @Override
        public void onShareCategoryClicked() {
            ProductListAdapter.listener.onShareProductClicked(this.position);
        }

        @Override
        public void switchIconClicked() {
            ProductListAdapter.listener.onSwitchIconClicked(this.position);
        }
    }

}

