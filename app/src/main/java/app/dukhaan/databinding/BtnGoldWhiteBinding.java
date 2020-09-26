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

public abstract class BtnGoldWhiteBinding
extends ViewDataBinding {
    public final TextView label;

    protected BtnGoldWhiteBinding(Object object, View view, int n, TextView textView) {
        super(object, view, n);
        this.label = textView;
    }

    public static BtnGoldWhiteBinding bind(View view) {
        return BtnGoldWhiteBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BtnGoldWhiteBinding bind(View view, Object object) {
        return (BtnGoldWhiteBinding)BtnGoldWhiteBinding.bind((Object)object, (View)view, (int)2131558458);
    }

    public static BtnGoldWhiteBinding inflate(LayoutInflater layoutInflater) {
        return BtnGoldWhiteBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static BtnGoldWhiteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return BtnGoldWhiteBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BtnGoldWhiteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (BtnGoldWhiteBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558458, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static BtnGoldWhiteBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (BtnGoldWhiteBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558458, null, (boolean)false, (Object)object);
    }
}

