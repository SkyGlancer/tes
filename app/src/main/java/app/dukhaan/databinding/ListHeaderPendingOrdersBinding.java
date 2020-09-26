/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ListHeaderPendingOrdersBinding
extends ViewDataBinding {
    public final ConstraintLayout container;
    public final LinearLayout viewAll;

    protected ListHeaderPendingOrdersBinding(Object object, View view, int n, ConstraintLayout constraintLayout, LinearLayout linearLayout) {
        super(object, view, n);
        this.container = constraintLayout;
        this.viewAll = linearLayout;
    }

    public static ListHeaderPendingOrdersBinding bind(View view) {
        return ListHeaderPendingOrdersBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ListHeaderPendingOrdersBinding bind(View view, Object object) {
        return (ListHeaderPendingOrdersBinding)ListHeaderPendingOrdersBinding.bind((Object)object, (View)view, (int)2131558546);
    }

    public static ListHeaderPendingOrdersBinding inflate(LayoutInflater layoutInflater) {
        return ListHeaderPendingOrdersBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ListHeaderPendingOrdersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ListHeaderPendingOrdersBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ListHeaderPendingOrdersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ListHeaderPendingOrdersBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558546, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ListHeaderPendingOrdersBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ListHeaderPendingOrdersBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558546, null, (boolean)false, (Object)object);
    }
}

