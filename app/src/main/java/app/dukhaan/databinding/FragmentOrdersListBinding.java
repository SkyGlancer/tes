/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ProgressBar
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.swiperefreshlayout.widget.SwipeRefreshLayout
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dukhaan.ui.views.EmptyDataCard;

public abstract class FragmentOrdersListBinding
extends ViewDataBinding {
    public final ConstraintLayout container;
    public final EmptyDataCard emptyData;
    public final ProgressBar progressBar;
    public final RecyclerView recyclerview;
    public final SwipeRefreshLayout swipeRefresh1;

    protected FragmentOrdersListBinding(Object object, View view, int n, ConstraintLayout constraintLayout, EmptyDataCard emptyDataCard, ProgressBar progressBar, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout) {
        super(object, view, n);
        this.container = constraintLayout;
        this.emptyData = emptyDataCard;
        this.progressBar = progressBar;
        this.recyclerview = recyclerView;
        this.swipeRefresh1 = swipeRefreshLayout;
    }

    public static FragmentOrdersListBinding bind(View view) {
        return FragmentOrdersListBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOrdersListBinding bind(View view, Object object) {
        return (FragmentOrdersListBinding)FragmentOrdersListBinding.bind((Object)object, (View)view, (int)2131558501);
    }

    public static FragmentOrdersListBinding inflate(LayoutInflater layoutInflater) {
        return FragmentOrdersListBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static FragmentOrdersListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return FragmentOrdersListBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOrdersListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (FragmentOrdersListBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558501, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static FragmentOrdersListBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (FragmentOrdersListBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558501, null, (boolean)false, (Object)object);
    }
}

