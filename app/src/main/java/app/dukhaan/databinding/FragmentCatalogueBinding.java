/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  com.google.android.material.tabs.TabLayout
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.tabs.TabLayout;

public abstract class FragmentCatalogueBinding
extends ViewDataBinding {
    public final FrameLayout frameLayout;
    public final TabLayout tabLayout;

    protected FragmentCatalogueBinding(Object object, View view, int n, FrameLayout frameLayout, TabLayout tabLayout) {
        super(object, view, n);
        this.frameLayout = frameLayout;
        this.tabLayout = tabLayout;
    }

    public static FragmentCatalogueBinding bind(View view) {
        return FragmentCatalogueBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCatalogueBinding bind(View view, Object object) {
        return (FragmentCatalogueBinding)FragmentCatalogueBinding.bind((Object)object, (View)view, (int)2131558482);
    }

    public static FragmentCatalogueBinding inflate(LayoutInflater layoutInflater) {
        return FragmentCatalogueBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static FragmentCatalogueBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return FragmentCatalogueBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCatalogueBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (FragmentCatalogueBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558482, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static FragmentCatalogueBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (FragmentCatalogueBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558482, null, (boolean)false, (Object)object);
    }
}

