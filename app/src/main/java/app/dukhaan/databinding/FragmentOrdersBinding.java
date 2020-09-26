/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
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
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class FragmentOrdersBinding
extends ViewDataBinding {
    public final ConstraintLayout container;
    public final FrameLayout frame;

    protected FragmentOrdersBinding(Object object, View view, int n, ConstraintLayout constraintLayout, FrameLayout frameLayout) {
        super(object, view, n);
        this.container = constraintLayout;
        this.frame = frameLayout;
    }

    public static FragmentOrdersBinding bind(View view) {
        return FragmentOrdersBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOrdersBinding bind(View view, Object object) {
        return (FragmentOrdersBinding)FragmentOrdersBinding.bind((Object)object, (View)view, (int)2131558500);
    }

    public static FragmentOrdersBinding inflate(LayoutInflater layoutInflater) {
        return FragmentOrdersBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static FragmentOrdersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return FragmentOrdersBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOrdersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (FragmentOrdersBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558500, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static FragmentOrdersBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (FragmentOrdersBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558500, null, (boolean)false, (Object)object);
    }
}

