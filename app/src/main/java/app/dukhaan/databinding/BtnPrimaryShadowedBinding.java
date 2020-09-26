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

public abstract class BtnPrimaryShadowedBinding
extends ViewDataBinding {
    public final TextView label;

    protected BtnPrimaryShadowedBinding(Object object, View view, int n, TextView textView) {
        super(object, view, n);
        this.label = textView;
    }

    public static BtnPrimaryShadowedBinding bind(View view) {
        return BtnPrimaryShadowedBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BtnPrimaryShadowedBinding bind(View view, Object object) {
        return (BtnPrimaryShadowedBinding)BtnPrimaryShadowedBinding.bind((Object)object, (View)view, (int)2131558461);
    }

    public static BtnPrimaryShadowedBinding inflate(LayoutInflater layoutInflater) {
        return BtnPrimaryShadowedBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static BtnPrimaryShadowedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return BtnPrimaryShadowedBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BtnPrimaryShadowedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (BtnPrimaryShadowedBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558461, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static BtnPrimaryShadowedBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (BtnPrimaryShadowedBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558461, null, (boolean)false, (Object)object);
    }
}

