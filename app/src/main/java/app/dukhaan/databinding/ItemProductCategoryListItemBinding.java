/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemProductCategoryListItemBinding
extends ViewDataBinding {
    public final TextView idCategoryName;

    protected ItemProductCategoryListItemBinding(Object object, View view, int n, TextView textView) {
        super(object, view, n);
        this.idCategoryName = textView;
    }

    public static ItemProductCategoryListItemBinding bind(View view) {
        return ItemProductCategoryListItemBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductCategoryListItemBinding bind(View view, Object object) {
        return (ItemProductCategoryListItemBinding)ItemProductCategoryListItemBinding.bind((Object)object, (View)view, (int)2131558526);
    }

    public static ItemProductCategoryListItemBinding inflate(LayoutInflater layoutInflater) {
        return ItemProductCategoryListItemBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ItemProductCategoryListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ItemProductCategoryListItemBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductCategoryListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ItemProductCategoryListItemBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558526, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ItemProductCategoryListItemBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ItemProductCategoryListItemBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558526, null, (boolean)false, (Object)object);
    }
}

