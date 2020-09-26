/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
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
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BtnPrimaryWhiteBinding
extends ViewDataBinding {
    public final TextView label;

    protected BtnPrimaryWhiteBinding(Object object, View view, int n, TextView textView) {
        super(object, view, n);
        this.label = textView;
    }

    public static BtnPrimaryWhiteBinding bind(View view) {
        return BtnPrimaryWhiteBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BtnPrimaryWhiteBinding bind(View view, Object object) {
        return (BtnPrimaryWhiteBinding)BtnPrimaryWhiteBinding.bind((Object)object, (View)view, (int)2131558462);
    }

    public static BtnPrimaryWhiteBinding inflate(LayoutInflater layoutInflater) {
        return BtnPrimaryWhiteBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static BtnPrimaryWhiteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return BtnPrimaryWhiteBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BtnPrimaryWhiteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (BtnPrimaryWhiteBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558462, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static BtnPrimaryWhiteBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (BtnPrimaryWhiteBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558462, null, (boolean)false, (Object)object);
    }
}

