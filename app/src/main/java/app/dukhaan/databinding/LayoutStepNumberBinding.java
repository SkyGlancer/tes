/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
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
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class LayoutStepNumberBinding
extends ViewDataBinding {
    public final ImageView check;
    public final ConstraintLayout container;
    public final TextView number;

    protected LayoutStepNumberBinding(Object object, View view, int n, ImageView imageView, ConstraintLayout constraintLayout, TextView textView) {
        super(object, view, n);
        this.check = imageView;
        this.container = constraintLayout;
        this.number = textView;
    }

    public static LayoutStepNumberBinding bind(View view) {
        return LayoutStepNumberBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutStepNumberBinding bind(View view, Object object) {
        return (LayoutStepNumberBinding)LayoutStepNumberBinding.bind((Object)object, (View)view, (int)2131558542);
    }

    public static LayoutStepNumberBinding inflate(LayoutInflater layoutInflater) {
        return LayoutStepNumberBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static LayoutStepNumberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return LayoutStepNumberBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutStepNumberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (LayoutStepNumberBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558542, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static LayoutStepNumberBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (LayoutStepNumberBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558542, null, (boolean)false, (Object)object);
    }
}

