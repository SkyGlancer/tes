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

public abstract class BtnPrimaryBinding
extends ViewDataBinding {
    public final TextView label;

    protected BtnPrimaryBinding(Object object, View view, int n, TextView textView) {
        super(object, view, n);
        this.label = textView;
    }

    public static BtnPrimaryBinding bind(View view) {
        return BtnPrimaryBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BtnPrimaryBinding bind(View view, Object object) {
        return (BtnPrimaryBinding)BtnPrimaryBinding.bind((Object)object, (View)view, (int)2131558460);
    }

    public static BtnPrimaryBinding inflate(LayoutInflater layoutInflater) {
        return BtnPrimaryBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static BtnPrimaryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return BtnPrimaryBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BtnPrimaryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (BtnPrimaryBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558460, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static BtnPrimaryBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (BtnPrimaryBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558460, null, (boolean)false, (Object)object);
    }
}

