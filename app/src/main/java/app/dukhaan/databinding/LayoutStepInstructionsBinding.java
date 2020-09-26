/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
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
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class LayoutStepInstructionsBinding
extends ViewDataBinding {
    public final TextView button;
    public final ConstraintLayout container;
    public final TextView instruction;
    public final TextView link;
    public final TextView title;

    protected LayoutStepInstructionsBinding(Object object, View view, int n, TextView textView, ConstraintLayout constraintLayout, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, n);
        this.button = textView;
        this.container = constraintLayout;
        this.instruction = textView2;
        this.link = textView3;
        this.title = textView4;
    }

    public static LayoutStepInstructionsBinding bind(View view) {
        return LayoutStepInstructionsBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutStepInstructionsBinding bind(View view, Object object) {
        return (LayoutStepInstructionsBinding)LayoutStepInstructionsBinding.bind((Object)object, (View)view, (int)2131558541);
    }

    public static LayoutStepInstructionsBinding inflate(LayoutInflater layoutInflater) {
        return LayoutStepInstructionsBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static LayoutStepInstructionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return LayoutStepInstructionsBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutStepInstructionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (LayoutStepInstructionsBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558541, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static LayoutStepInstructionsBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (LayoutStepInstructionsBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558541, null, (boolean)false, (Object)object);
    }
}

