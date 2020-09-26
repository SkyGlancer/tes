/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ProgressBar
 *  androidx.core.widget.NestedScrollView
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
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dukhaan.databinding.ListHeaderOverviewBinding;
import app.dukhaan.databinding.ListHeaderPendingOrdersBinding;
import app.dukhaan.databinding.StoreInfoCardContainerBinding;
import app.dukhaan.ui.views.EmptyDataCard;
import app.dukhaan.ui.views.orders.OrderFilterChipGroup;

public abstract class FragmentHomeBinding
extends ViewDataBinding {
    public final EmptyDataCard emptyData;
    public final FrameLayout frame;
    public final NestedScrollView nestedScrollView;
    public final OrderFilterChipGroup orderFilters;
    public final ListHeaderPendingOrdersBinding pendingOrdersHeader;
    public final ProgressBar progressBar;
    public final RecyclerView recyclerviewPendingOrders;
    public final RecyclerView recyclerviewStats;
    public final StoreInfoCardContainerBinding storeInfoCardContainer;
    public final SwipeRefreshLayout swipeRefresh;
    public final ListHeaderOverviewBinding weekHeader;

    protected FragmentHomeBinding(Object object, View view, int n, EmptyDataCard emptyDataCard, FrameLayout frameLayout, NestedScrollView nestedScrollView, OrderFilterChipGroup orderFilterChipGroup, ListHeaderPendingOrdersBinding listHeaderPendingOrdersBinding, ProgressBar progressBar, RecyclerView recyclerView, RecyclerView recyclerView2, StoreInfoCardContainerBinding storeInfoCardContainerBinding, SwipeRefreshLayout swipeRefreshLayout, ListHeaderOverviewBinding listHeaderOverviewBinding) {
        super(object, view, n);
        this.emptyData = emptyDataCard;
        this.frame = frameLayout;
        this.nestedScrollView = nestedScrollView;
        this.orderFilters = orderFilterChipGroup;
        this.pendingOrdersHeader = listHeaderPendingOrdersBinding;
        this.setContainedBinding((ViewDataBinding)listHeaderPendingOrdersBinding);
        this.progressBar = progressBar;
        this.recyclerviewPendingOrders = recyclerView;
        this.recyclerviewStats = recyclerView2;
        this.storeInfoCardContainer = storeInfoCardContainerBinding;
        this.setContainedBinding((ViewDataBinding)storeInfoCardContainerBinding);
        this.swipeRefresh = swipeRefreshLayout;
        this.weekHeader = listHeaderOverviewBinding;
        this.setContainedBinding((ViewDataBinding)listHeaderOverviewBinding);
    }

    public static FragmentHomeBinding bind(View view) {
        return FragmentHomeBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeBinding bind(View view, Object object) {
        return (FragmentHomeBinding)FragmentHomeBinding.bind((Object)object, (View)view, (int)2131558498);
    }

    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater) {
        return FragmentHomeBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return FragmentHomeBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (FragmentHomeBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558498, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (FragmentHomeBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558498, null, (boolean)false, (Object)object);
    }
}

