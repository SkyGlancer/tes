/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.constraintlayout.widget.Guideline
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
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.ui.views.PrimaryButton;

public abstract class ActivityAddressSelectBinding
extends ViewDataBinding {
    public final TextView btnChange;
    public final Guideline guideline;
    public final TextView idAddress;
    public final TextView idAddressArea;
    public final ImageView idBtnBack;
    public final PrimaryButton idBtnSaveAddress;
    public final ImageView idImgCurrentAddress;
    public final AppCompatEditText idInputBlockNumber;
    public final ProgressBar progressBar;

    protected ActivityAddressSelectBinding(Object object, View view, int n, TextView textView, Guideline guideline, TextView textView2, TextView textView3, ImageView imageView, PrimaryButton primaryButton, ImageView imageView2, AppCompatEditText appCompatEditText, ProgressBar progressBar) {
        super(object, view, n);
        this.btnChange = textView;
        this.guideline = guideline;
        this.idAddress = textView2;
        this.idAddressArea = textView3;
        this.idBtnBack = imageView;
        this.idBtnSaveAddress = primaryButton;
        this.idImgCurrentAddress = imageView2;
        this.idInputBlockNumber = appCompatEditText;
        this.progressBar = progressBar;
    }

    public static ActivityAddressSelectBinding bind(View view) {
        return ActivityAddressSelectBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAddressSelectBinding bind(View view, Object object) {
        return (ActivityAddressSelectBinding)ActivityAddressSelectBinding.bind((Object)object, (View)view, (int)2131558430);
    }

    public static ActivityAddressSelectBinding inflate(LayoutInflater layoutInflater) {
        return ActivityAddressSelectBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityAddressSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityAddressSelectBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAddressSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityAddressSelectBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558430, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityAddressSelectBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityAddressSelectBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558430, null, (boolean)false, (Object)object);
    }
}

