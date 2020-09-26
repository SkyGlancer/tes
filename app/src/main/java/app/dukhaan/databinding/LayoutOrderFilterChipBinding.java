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

public abstract class LayoutOrderFilterChipBinding
extends ViewDataBinding {
    public final TextView label;

    protected LayoutOrderFilterChipBinding(Object object, View view, int n, TextView textView) {
        super(object, view, n);
        this.label = textView;
    }

    public static LayoutOrderFilterChipBinding bind(View view) {
        return LayoutOrderFilterChipBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutOrderFilterChipBinding bind(View view, Object object) {
        return (LayoutOrderFilterChipBinding)LayoutOrderFilterChipBinding.bind((Object)object, (View)view, (int)2131558535);
    }

    public static LayoutOrderFilterChipBinding inflate(LayoutInflater layoutInflater) {
        return LayoutOrderFilterChipBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static LayoutOrderFilterChipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return LayoutOrderFilterChipBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutOrderFilterChipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (LayoutOrderFilterChipBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558535, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static LayoutOrderFilterChipBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (LayoutOrderFilterChipBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558535, null, (boolean)false, (Object)object);
    }
}

