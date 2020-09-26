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
 *  java.util.List
 */
package app.dukhaan.ui.views.units;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.databinding.ItemProductUnitListItemBinding;
import app.dukhaan.ui.views.units.-$$Lambda$ProductUnitAdapter$2CvekFy7ARqr2q9LvwFbFx9lf0w;
import java.util.List;

public class ProductUnitAdapter
extends RecyclerView.Adapter<ViewHolder> {
    private UnitItemClickListener listener;
    private List<String> units;

    public ProductUnitAdapter(List<String> list, UnitItemClickListener unitItemClickListener) {
        this.units = list;
        this.listener = unitItemClickListener;
    }

    public int getItemCount() {
        return this.units.size();
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$ProductUnitAdapter(int n, View view) {
        this.listener.onItemClick(n);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int n) {
        viewHolder.bind(n);
        viewHolder.itemView.setOnClickListener((View.OnClickListener)new -$$Lambda$ProductUnitAdapter$2CvekFy7ARqr2q9LvwFbFx9lf0w(this, n));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new ViewHolder((ItemProductUnitListItemBinding)DataBindingUtil.inflate((LayoutInflater)LayoutInflater.from((Context)viewGroup.getContext()), (int)2131558527, (ViewGroup)viewGroup, (boolean)false));
    }

    class ViewHolder
    extends RecyclerView.ViewHolder {
        private ItemProductUnitListItemBinding binding;

        ViewHolder(ItemProductUnitListItemBinding itemProductUnitListItemBinding) {
            super(itemProductUnitListItemBinding.getRoot());
            this.binding = itemProductUnitListItemBinding;
        }

        void bind(int n) {
            this.binding.label.setText((CharSequence)ProductUnitAdapter.this.units.get(n));
        }
    }

}

