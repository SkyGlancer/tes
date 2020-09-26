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
import app.dukhaan.ui.views.PrimaryButtonWhite;
import com.airbnb.lottie.LottieAnimationView;

public abstract class ActivitySyncContactsBinding
extends ViewDataBinding {
    public final PrimaryButtonWhite btnContinue;
    public final TextView description;
    public final ImageView icClose;
    public final LottieAnimationView loader;
    public final TextView title;

    protected ActivitySyncContactsBinding(Object object, View view, int n, PrimaryButtonWhite primaryButtonWhite, TextView textView, ImageView imageView, LottieAnimationView lottieAnimationView, TextView textView2) {
        super(object, view, n);
        this.btnContinue = primaryButtonWhite;
        this.description = textView;
        this.icClose = imageView;
        this.loader = lottieAnimationView;
        this.title = textView2;
    }

    public static ActivitySyncContactsBinding bind(View view) {
        return ActivitySyncContactsBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySyncContactsBinding bind(View view, Object object) {
        return (ActivitySyncContactsBinding)ActivitySyncContactsBinding.bind((Object)object, (View)view, (int)2131558449);
    }

    public static ActivitySyncContactsBinding inflate(LayoutInflater layoutInflater) {
        return ActivitySyncContactsBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivitySyncContactsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivitySyncContactsBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySyncContactsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivitySyncContactsBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558449, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivitySyncContactsBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivitySyncContactsBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558449, null, (boolean)false, (Object)object);
    }
}

