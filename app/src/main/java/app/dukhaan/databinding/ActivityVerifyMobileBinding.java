/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.appcompat.widget.Toolbar
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
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.ui.views.PrimaryButton;

public abstract class ActivityVerifyMobileBinding
extends ViewDataBinding {
    public final LinearLayout flagContainer;
    public final PrimaryButton idBtnNext;
    public final ImageView idDropDown;
    public final ImageView idImgCountryFlag;
    public final AppCompatEditText idInputMobile;
    public final TextView idLblCountryCode;
    public final TextView idTitle;
    public final Toolbar toolbar;
    public final View viewMobile;

    protected ActivityVerifyMobileBinding(Object object, View view, int n, LinearLayout linearLayout, PrimaryButton primaryButton, ImageView imageView, ImageView imageView2, AppCompatEditText appCompatEditText, TextView textView, TextView textView2, Toolbar toolbar, View view2) {
        super(object, view, n);
        this.flagContainer = linearLayout;
        this.idBtnNext = primaryButton;
        this.idDropDown = imageView;
        this.idImgCountryFlag = imageView2;
        this.idInputMobile = appCompatEditText;
        this.idLblCountryCode = textView;
        this.idTitle = textView2;
        this.toolbar = toolbar;
        this.viewMobile = view2;
    }

    public static ActivityVerifyMobileBinding bind(View view) {
        return ActivityVerifyMobileBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityVerifyMobileBinding bind(View view, Object object) {
        return (ActivityVerifyMobileBinding)ActivityVerifyMobileBinding.bind((Object)object, (View)view, (int)2131558450);
    }

    public static ActivityVerifyMobileBinding inflate(LayoutInflater layoutInflater) {
        return ActivityVerifyMobileBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityVerifyMobileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityVerifyMobileBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityVerifyMobileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityVerifyMobileBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558450, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityVerifyMobileBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityVerifyMobileBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558450, null, (boolean)false, (Object)object);
    }
}

