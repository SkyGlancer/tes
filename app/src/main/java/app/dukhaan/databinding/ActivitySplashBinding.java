/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivitySplashBinding
extends ViewDataBinding {
    public final ImageView logo;
    public final LinearLayout splashFooterContainer;
    public final LinearLayout splashTextContainer;

    protected ActivitySplashBinding(Object object, View view, int n, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(object, view, n);
        this.logo = imageView;
        this.splashFooterContainer = linearLayout;
        this.splashTextContainer = linearLayout2;
    }

    public static ActivitySplashBinding bind(View view) {
        return ActivitySplashBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySplashBinding bind(View view, Object object) {
        return (ActivitySplashBinding)ActivitySplashBinding.bind((Object)object, (View)view, (int)2131558448);
    }

    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater) {
        return ActivitySplashBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivitySplashBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivitySplashBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558448, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivitySplashBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558448, null, (boolean)false, (Object)object);
    }
}

