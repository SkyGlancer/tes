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
import app.dukhaan.ui.views.PrimaryButton;

public abstract class ActivityOnboardingBinding
extends ViewDataBinding {
    public final ImageView idBanner;
    public final PrimaryButton idBtnStart;
    public final TextView idDesc;
    public final TextView idTitle;

    protected ActivityOnboardingBinding(Object object, View view, int n, ImageView imageView, PrimaryButton primaryButton, TextView textView, TextView textView2) {
        super(object, view, n);
        this.idBanner = imageView;
        this.idBtnStart = primaryButton;
        this.idDesc = textView;
        this.idTitle = textView2;
    }

    public static ActivityOnboardingBinding bind(View view) {
        return ActivityOnboardingBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityOnboardingBinding bind(View view, Object object) {
        return (ActivityOnboardingBinding)ActivityOnboardingBinding.bind((Object)object, (View)view, (int)2131558443);
    }

    public static ActivityOnboardingBinding inflate(LayoutInflater layoutInflater) {
        return ActivityOnboardingBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityOnboardingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityOnboardingBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityOnboardingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityOnboardingBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558443, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityOnboardingBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityOnboardingBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558443, null, (boolean)false, (Object)object);
    }
}

