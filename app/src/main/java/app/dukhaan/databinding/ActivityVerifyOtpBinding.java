/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.appcompat.widget.Toolbar
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.otpview.OtpTextView;
import app.dukhaan.ui.views.PrimaryButton;

public abstract class ActivityVerifyOtpBinding
extends ViewDataBinding {
    public final ConstraintLayout container;
    public final PrimaryButton idBtnNext;
    public final TextView idTitle;
    public final OtpTextView otpTextView;
    public final Toolbar toolbar;
    public final TextView tvResend;

    protected ActivityVerifyOtpBinding(Object object, View view, int n, ConstraintLayout constraintLayout, PrimaryButton primaryButton, TextView textView, OtpTextView otpTextView, Toolbar toolbar, TextView textView2) {
        super(object, view, n);
        this.container = constraintLayout;
        this.idBtnNext = primaryButton;
        this.idTitle = textView;
        this.otpTextView = otpTextView;
        this.toolbar = toolbar;
        this.tvResend = textView2;
    }

    public static ActivityVerifyOtpBinding bind(View view) {
        return ActivityVerifyOtpBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityVerifyOtpBinding bind(View view, Object object) {
        return (ActivityVerifyOtpBinding)ActivityVerifyOtpBinding.bind((Object)object, (View)view, (int)2131558451);
    }

    public static ActivityVerifyOtpBinding inflate(LayoutInflater layoutInflater) {
        return ActivityVerifyOtpBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityVerifyOtpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityVerifyOtpBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityVerifyOtpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityVerifyOtpBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558451, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityVerifyOtpBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityVerifyOtpBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558451, null, (boolean)false, (Object)object);
    }
}

