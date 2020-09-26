/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageButton
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  androidx.appcompat.widget.AppCompatEditText
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
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dukhaan.ui.views.EmptyDataCard;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.ui.views.PrimaryButtonShadowed;

public abstract class FragmentProductsBinding
extends ViewDataBinding {
    public final ImageButton closeButton;
    public final ConstraintLayout content;
    public final EmptyDataCard emptyData;
    public final ProgressBar progressBar;
    public final RecyclerView recyclerview;
    public final AppCompatEditText search;
    public final PrimaryButton startListing;
    public final PrimaryButtonShadowed startListingFixed;
    public final RelativeLayout storeInfoCardContainer;
    public final SwipeRefreshLayout swipeRefresh;

    protected FragmentProductsBinding(Object object, View view, int n, ImageButton imageButton, ConstraintLayout constraintLayout, EmptyDataCard emptyDataCard, ProgressBar progressBar, RecyclerView recyclerView, AppCompatEditText appCompatEditText, PrimaryButton primaryButton, PrimaryButtonShadowed primaryButtonShadowed, RelativeLayout relativeLayout, SwipeRefreshLayout swipeRefreshLayout) {
        super(object, view, n);
        this.closeButton = imageButton;
        this.content = constraintLayout;
        this.emptyData = emptyDataCard;
        this.progressBar = progressBar;
        this.recyclerview = recyclerView;
        this.search = appCompatEditText;
        this.startListing = primaryButton;
        this.startListingFixed = primaryButtonShadowed;
        this.storeInfoCardContainer = relativeLayout;
        this.swipeRefresh = swipeRefreshLayout;
    }

    public static FragmentProductsBinding bind(View view) {
        return FragmentProductsBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProductsBinding bind(View view, Object object) {
        return (FragmentProductsBinding)FragmentProductsBinding.bind((Object)object, (View)view, (int)2131558502);
    }

    public static FragmentProductsBinding inflate(LayoutInflater layoutInflater) {
        return FragmentProductsBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static FragmentProductsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return FragmentProductsBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProductsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (FragmentProductsBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558502, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static FragmentProductsBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (FragmentProductsBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558502, null, (boolean)false, (Object)object);
    }
}

