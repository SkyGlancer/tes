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
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.ui.views.PrimaryButtonShadowed;

public abstract class FragmentCategoriesBinding
extends ViewDataBinding {
    public final PrimaryButton btnCreate;
    public final PrimaryButtonShadowed btnCreateFixed;
    public final ConstraintLayout container;
    public final EmptyDataCard emptyData;
    public final ProgressBar progressBar;
    public final RecyclerView recyclerview;
    public final SwipeRefreshLayout swipeRefresh;

    protected FragmentCategoriesBinding(Object object, View view, int n, PrimaryButton primaryButton, PrimaryButtonShadowed primaryButtonShadowed, ConstraintLayout constraintLayout, EmptyDataCard emptyDataCard, ProgressBar progressBar, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout) {
        super(object, view, n);
        this.btnCreate = primaryButton;
        this.btnCreateFixed = primaryButtonShadowed;
        this.container = constraintLayout;
        this.emptyData = emptyDataCard;
        this.progressBar = progressBar;
        this.recyclerview = recyclerView;
        this.swipeRefresh = swipeRefreshLayout;
    }

    public static FragmentCategoriesBinding bind(View view) {
        return FragmentCategoriesBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCategoriesBinding bind(View view, Object object) {
        return (FragmentCategoriesBinding)FragmentCategoriesBinding.bind((Object)object, (View)view, (int)2131558497);
    }

    public static FragmentCategoriesBinding inflate(LayoutInflater layoutInflater) {
        return FragmentCategoriesBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static FragmentCategoriesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return FragmentCategoriesBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCategoriesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (FragmentCategoriesBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558497, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static FragmentCategoriesBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (FragmentCategoriesBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558497, null, (boolean)false, (Object)object);
    }
}

