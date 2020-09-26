/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.constraintlayout.widget.Guideline
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
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.ui.views.PrimaryButton;
import com.google.android.material.appbar.MaterialToolbar;

public abstract class ActivityDeliveryChargesBinding
extends ViewDataBinding {
    public final TextView deliveryCharge;
    public final TextView freeDelivery;
    public final Guideline guideline;
    public final AppCompatEditText priceDeliveryCharge;
    public final AppCompatEditText priceFreeDelivery;
    public final PrimaryButton saveChanges;
    public final MaterialToolbar toolbar;

    protected ActivityDeliveryChargesBinding(Object object, View view, int n, TextView textView, TextView textView2, Guideline guideline, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, PrimaryButton primaryButton, MaterialToolbar materialToolbar) {
        super(object, view, n);
        this.deliveryCharge = textView;
        this.freeDelivery = textView2;
        this.guideline = guideline;
        this.priceDeliveryCharge = appCompatEditText;
        this.priceFreeDelivery = appCompatEditText2;
        this.saveChanges = primaryButton;
        this.toolbar = materialToolbar;
    }

    public static ActivityDeliveryChargesBinding bind(View view) {
        return ActivityDeliveryChargesBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDeliveryChargesBinding bind(View view, Object object) {
        return (ActivityDeliveryChargesBinding)ActivityDeliveryChargesBinding.bind((Object)object, (View)view, (int)2131558436);
    }

    public static ActivityDeliveryChargesBinding inflate(LayoutInflater layoutInflater) {
        return ActivityDeliveryChargesBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityDeliveryChargesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityDeliveryChargesBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDeliveryChargesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityDeliveryChargesBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558436, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityDeliveryChargesBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityDeliveryChargesBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558436, null, (boolean)false, (Object)object);
    }
}

