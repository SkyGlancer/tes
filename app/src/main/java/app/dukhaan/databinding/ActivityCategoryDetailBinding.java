/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  com.google.android.material.appbar.MaterialToolbar
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.MaterialToolbar;

public abstract class ActivityCategoryDetailBinding
extends ViewDataBinding {
    public final FrameLayout productContainer;
    public final TextView toolTitle;
    public final MaterialToolbar toolbar;

    protected ActivityCategoryDetailBinding(Object object, View view, int n, FrameLayout frameLayout, TextView textView, MaterialToolbar materialToolbar) {
        super(object, view, n);
        this.productContainer = frameLayout;
        this.toolTitle = textView;
        this.toolbar = materialToolbar;
    }

    public static ActivityCategoryDetailBinding bind(View view) {
        return ActivityCategoryDetailBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCategoryDetailBinding bind(View view, Object object) {
        return (ActivityCategoryDetailBinding)ActivityCategoryDetailBinding.bind((Object)object, (View)view, (int)2131558433);
    }

    public static ActivityCategoryDetailBinding inflate(LayoutInflater layoutInflater) {
        return ActivityCategoryDetailBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityCategoryDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityCategoryDetailBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCategoryDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityCategoryDetailBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558433, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityCategoryDetailBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityCategoryDetailBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558433, null, (boolean)false, (Object)object);
    }
}

