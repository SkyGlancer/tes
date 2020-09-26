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

public abstract class ItemProductUnitListItemBinding
extends ViewDataBinding {
    public final TextView label;

    protected ItemProductUnitListItemBinding(Object object, View view, int n, TextView textView) {
        super(object, view, n);
        this.label = textView;
    }

    public static ItemProductUnitListItemBinding bind(View view) {
        return ItemProductUnitListItemBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductUnitListItemBinding bind(View view, Object object) {
        return (ItemProductUnitListItemBinding)ItemProductUnitListItemBinding.bind((Object)object, (View)view, (int)2131558527);
    }

    public static ItemProductUnitListItemBinding inflate(LayoutInflater layoutInflater) {
        return ItemProductUnitListItemBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ItemProductUnitListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ItemProductUnitListItemBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductUnitListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ItemProductUnitListItemBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558527, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ItemProductUnitListItemBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ItemProductUnitListItemBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558527, null, (boolean)false, (Object)object);
    }
}

