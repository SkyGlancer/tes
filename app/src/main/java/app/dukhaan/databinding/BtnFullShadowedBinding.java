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

public abstract class BtnFullShadowedBinding
extends ViewDataBinding {
    public final TextView label;

    protected BtnFullShadowedBinding(Object object, View view, int n, TextView textView) {
        super(object, view, n);
        this.label = textView;
    }

    public static BtnFullShadowedBinding bind(View view) {
        return BtnFullShadowedBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BtnFullShadowedBinding bind(View view, Object object) {
        return (BtnFullShadowedBinding)BtnFullShadowedBinding.bind((Object)object, (View)view, (int)2131558457);
    }

    public static BtnFullShadowedBinding inflate(LayoutInflater layoutInflater) {
        return BtnFullShadowedBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static BtnFullShadowedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return BtnFullShadowedBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BtnFullShadowedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (BtnFullShadowedBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558457, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static BtnFullShadowedBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (BtnFullShadowedBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558457, null, (boolean)false, (Object)object);
    }
}

