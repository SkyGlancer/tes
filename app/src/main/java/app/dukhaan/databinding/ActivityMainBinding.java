/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.android.material.bottomnavigation.BottomNavigationView
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public abstract class ActivityMainBinding
extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final ConstraintLayout container;
    public final BottomNavigationView navView;
    public final TextView toolTitle;
    public final MaterialToolbar toolbar;
    public final ImageView toolbarVideoIcon;

    protected ActivityMainBinding(Object object, View view, int n, AppBarLayout appBarLayout, ConstraintLayout constraintLayout, BottomNavigationView bottomNavigationView, TextView textView, MaterialToolbar materialToolbar, ImageView imageView) {
        super(object, view, n);
        this.appBar = appBarLayout;
        this.container = constraintLayout;
        this.navView = bottomNavigationView;
        this.toolTitle = textView;
        this.toolbar = materialToolbar;
        this.toolbarVideoIcon = imageView;
    }

    public static ActivityMainBinding bind(View view) {
        return ActivityMainBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding bind(View view, Object object) {
        return (ActivityMainBinding)ActivityMainBinding.bind((Object)object, (View)view, (int)2131558441);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return ActivityMainBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityMainBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityMainBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558441, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityMainBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558441, null, (boolean)false, (Object)object);
    }
}

