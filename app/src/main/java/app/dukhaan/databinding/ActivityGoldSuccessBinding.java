/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
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
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.ui.views.GoldButtonWhite;
import com.airbnb.lottie.LottieAnimationView;

public abstract class ActivityGoldSuccessBinding
extends ViewDataBinding {
    public final GoldButtonWhite btnContinue;
    public final TextView description;
    public final ImageView icClose;
    public final LottieAnimationView loader;
    public final TextView title;

    protected ActivityGoldSuccessBinding(Object object, View view, int n, GoldButtonWhite goldButtonWhite, TextView textView, ImageView imageView, LottieAnimationView lottieAnimationView, TextView textView2) {
        super(object, view, n);
        this.btnContinue = goldButtonWhite;
        this.description = textView;
        this.icClose = imageView;
        this.loader = lottieAnimationView;
        this.title = textView2;
    }

    public static ActivityGoldSuccessBinding bind(View view) {
        return ActivityGoldSuccessBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityGoldSuccessBinding bind(View view, Object object) {
        return (ActivityGoldSuccessBinding)ActivityGoldSuccessBinding.bind((Object)object, (View)view, (int)2131558438);
    }

    public static ActivityGoldSuccessBinding inflate(LayoutInflater layoutInflater) {
        return ActivityGoldSuccessBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityGoldSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityGoldSuccessBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityGoldSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityGoldSuccessBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558438, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityGoldSuccessBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityGoldSuccessBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558438, null, (boolean)false, (Object)object);
    }
}

