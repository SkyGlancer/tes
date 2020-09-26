/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ListHeaderOverviewBinding
extends ViewDataBinding {
    public final ConstraintLayout container;
    public final TextView title;
    public final LinearLayout weekDropDown;

    protected ListHeaderOverviewBinding(Object object, View view, int n, ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout) {
        super(object, view, n);
        this.container = constraintLayout;
        this.title = textView;
        this.weekDropDown = linearLayout;
    }

    public static ListHeaderOverviewBinding bind(View view) {
        return ListHeaderOverviewBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ListHeaderOverviewBinding bind(View view, Object object) {
        return (ListHeaderOverviewBinding)ListHeaderOverviewBinding.bind((Object)object, (View)view, (int)2131558545);
    }

    public static ListHeaderOverviewBinding inflate(LayoutInflater layoutInflater) {
        return ListHeaderOverviewBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ListHeaderOverviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ListHeaderOverviewBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ListHeaderOverviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ListHeaderOverviewBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558545, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ListHeaderOverviewBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ListHeaderOverviewBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558545, null, (boolean)false, (Object)object);
    }
}

