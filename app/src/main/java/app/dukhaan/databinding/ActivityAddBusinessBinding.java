/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatEditText
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
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.ui.views.SpinnerImage;

public abstract class ActivityAddBusinessBinding
extends ViewDataBinding {
    public final ConstraintLayout container;
    public final PrimaryButton idBtnFinish;
    public final TextView idInputAddress;
    public final AppCompatEditText idInputBusinessName;
    public final TextView idInputCountryName;
    public final AppCompatEditText idInputWhatsappNumber;
    public final SpinnerImage idSpinnerImage;
    public final TextView idTitle;
    public final Toolbar toolbar;

    protected ActivityAddBusinessBinding(Object object, View view, int n, ConstraintLayout constraintLayout, PrimaryButton primaryButton, TextView textView, AppCompatEditText appCompatEditText, TextView textView2, AppCompatEditText appCompatEditText2, SpinnerImage spinnerImage, TextView textView3, Toolbar toolbar) {
        super(object, view, n);
        this.container = constraintLayout;
        this.idBtnFinish = primaryButton;
        this.idInputAddress = textView;
        this.idInputBusinessName = appCompatEditText;
        this.idInputCountryName = textView2;
        this.idInputWhatsappNumber = appCompatEditText2;
        this.idSpinnerImage = spinnerImage;
        this.idTitle = textView3;
        this.toolbar = toolbar;
    }

    public static ActivityAddBusinessBinding bind(View view) {
        return ActivityAddBusinessBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAddBusinessBinding bind(View view, Object object) {
        return (ActivityAddBusinessBinding)ActivityAddBusinessBinding.bind((Object)object, (View)view, (int)2131558428);
    }

    public static ActivityAddBusinessBinding inflate(LayoutInflater layoutInflater) {
        return ActivityAddBusinessBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityAddBusinessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityAddBusinessBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAddBusinessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityAddBusinessBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558428, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityAddBusinessBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityAddBusinessBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558428, null, (boolean)false, (Object)object);
    }
}

