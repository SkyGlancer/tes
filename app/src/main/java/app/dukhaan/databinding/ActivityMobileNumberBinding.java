/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityMobileNumberBinding
extends ViewDataBinding {
    protected ActivityMobileNumberBinding(Object object, View view, int n) {
        super(object, view, n);
    }

    public static ActivityMobileNumberBinding bind(View view) {
        return ActivityMobileNumberBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMobileNumberBinding bind(View view, Object object) {
        return (ActivityMobileNumberBinding)ActivityMobileNumberBinding.bind((Object)object, (View)view, (int)2131558442);
    }

    public static ActivityMobileNumberBinding inflate(LayoutInflater layoutInflater) {
        return ActivityMobileNumberBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityMobileNumberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityMobileNumberBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMobileNumberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityMobileNumberBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558442, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityMobileNumberBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityMobileNumberBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558442, null, (boolean)false, (Object)object);
    }
}

