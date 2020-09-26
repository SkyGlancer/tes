/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  app.dukhaan.ui.views.products.ProductListItemCard
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.ui.views.products.ProductListItemCard;

public abstract class ProductListItemBinding
extends ViewDataBinding {
    public final ProductListItemCard product;

    protected ProductListItemBinding(Object object, View view, int n, ProductListItemCard productListItemCard) {
        super(object, view, n);
        this.product = productListItemCard;
    }

    public static ProductListItemBinding bind(View view) {
        return ProductListItemBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductListItemBinding bind(View view, Object object) {
        return (ProductListItemBinding)ProductListItemBinding.bind((Object)object, (View)view, (int)2131558622);
    }

    public static ProductListItemBinding inflate(LayoutInflater layoutInflater) {
        return ProductListItemBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ProductListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ProductListItemBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ProductListItemBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558622, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ProductListItemBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ProductListItemBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558622, null, (boolean)false, (Object)object);
    }
}

