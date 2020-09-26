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

public abstract class LayoutEmptyDataCardBinding
extends ViewDataBinding {
    public final TextView label;

    protected LayoutEmptyDataCardBinding(Object object, View view, int n, TextView textView) {
        super(object, view, n);
        this.label = textView;
    }

    public static LayoutEmptyDataCardBinding bind(View view) {
        return LayoutEmptyDataCardBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutEmptyDataCardBinding bind(View view, Object object) {
        return (LayoutEmptyDataCardBinding)LayoutEmptyDataCardBinding.bind((Object)object, (View)view, (int)2131558533);
    }

    public static LayoutEmptyDataCardBinding inflate(LayoutInflater layoutInflater) {
        return LayoutEmptyDataCardBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static LayoutEmptyDataCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return LayoutEmptyDataCardBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutEmptyDataCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (LayoutEmptyDataCardBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558533, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static LayoutEmptyDataCardBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (LayoutEmptyDataCardBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558533, null, (boolean)false, (Object)object);
    }
}

