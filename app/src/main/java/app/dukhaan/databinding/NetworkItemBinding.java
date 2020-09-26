/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ProgressBar
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
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class NetworkItemBinding
extends ViewDataBinding {
    public final TextView errorMsg;
    public final ProgressBar progressBar;

    protected NetworkItemBinding(Object object, View view, int n, TextView textView, ProgressBar progressBar) {
        super(object, view, n);
        this.errorMsg = textView;
        this.progressBar = progressBar;
    }

    public static NetworkItemBinding bind(View view) {
        return NetworkItemBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NetworkItemBinding bind(View view, Object object) {
        return (NetworkItemBinding)NetworkItemBinding.bind((Object)object, (View)view, (int)2131558525);
    }

    public static NetworkItemBinding inflate(LayoutInflater layoutInflater) {
        return NetworkItemBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static NetworkItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return NetworkItemBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NetworkItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (NetworkItemBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558525, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static NetworkItemBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (NetworkItemBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558525, null, (boolean)false, (Object)object);
    }
}

