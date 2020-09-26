/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.ui.views.orders.OrderFilterChip;

public abstract class LayoutOrderFilterChipGroupBinding
extends ViewDataBinding {
    public final OrderFilterChip filterAccepted;
    public final OrderFilterChip filterAll;
    public final OrderFilterChip filterPending;

    protected LayoutOrderFilterChipGroupBinding(Object object, View view, int n, OrderFilterChip orderFilterChip, OrderFilterChip orderFilterChip2, OrderFilterChip orderFilterChip3) {
        super(object, view, n);
        this.filterAccepted = orderFilterChip;
        this.filterAll = orderFilterChip2;
        this.filterPending = orderFilterChip3;
    }

    public static LayoutOrderFilterChipGroupBinding bind(View view) {
        return LayoutOrderFilterChipGroupBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutOrderFilterChipGroupBinding bind(View view, Object object) {
        return (LayoutOrderFilterChipGroupBinding)LayoutOrderFilterChipGroupBinding.bind((Object)object, (View)view, (int)2131558536);
    }

    public static LayoutOrderFilterChipGroupBinding inflate(LayoutInflater layoutInflater) {
        return LayoutOrderFilterChipGroupBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static LayoutOrderFilterChipGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return LayoutOrderFilterChipGroupBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutOrderFilterChipGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (LayoutOrderFilterChipGroupBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558536, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static LayoutOrderFilterChipGroupBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (LayoutOrderFilterChipGroupBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558536, null, (boolean)false, (Object)object);
    }
}

