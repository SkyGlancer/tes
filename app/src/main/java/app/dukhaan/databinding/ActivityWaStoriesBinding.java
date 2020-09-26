/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  androidx.viewpager.widget.ViewPager
 *  com.google.android.material.appbar.MaterialToolbar
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.MaterialToolbar;

public abstract class ActivityWaStoriesBinding
extends ViewDataBinding {
    public final LinearLayout SliderDots;
    public final RelativeLayout activityMain;
    public final MaterialToolbar toolbar;
    public final ViewPager viewPager;

    protected ActivityWaStoriesBinding(Object object, View view, int n, LinearLayout linearLayout, RelativeLayout relativeLayout, MaterialToolbar materialToolbar, ViewPager viewPager) {
        super(object, view, n);
        this.SliderDots = linearLayout;
        this.activityMain = relativeLayout;
        this.toolbar = materialToolbar;
        this.viewPager = viewPager;
    }

    public static ActivityWaStoriesBinding bind(View view) {
        return ActivityWaStoriesBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWaStoriesBinding bind(View view, Object object) {
        return (ActivityWaStoriesBinding)ActivityWaStoriesBinding.bind((Object)object, (View)view, (int)2131558451);
    }

    public static ActivityWaStoriesBinding inflate(LayoutInflater layoutInflater) {
        return ActivityWaStoriesBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityWaStoriesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityWaStoriesBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWaStoriesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityWaStoriesBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558451, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityWaStoriesBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityWaStoriesBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558451, null, (boolean)false, (Object)object);
    }
}

