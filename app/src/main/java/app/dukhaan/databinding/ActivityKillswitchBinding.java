/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.ImageView
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityKillswitchBinding
extends ViewDataBinding {
    public final ImageView idBannerKillswitch;
    public final Button idBtnKillswitch;
    public final TextView idDescKillswitch;
    public final TextView idTitleKillswitch;

    protected ActivityKillswitchBinding(Object object, View view, int n, ImageView imageView, Button button, TextView textView, TextView textView2) {
        super(object, view, n);
        this.idBannerKillswitch = imageView;
        this.idBtnKillswitch = button;
        this.idDescKillswitch = textView;
        this.idTitleKillswitch = textView2;
    }

    public static ActivityKillswitchBinding bind(View view) {
        return ActivityKillswitchBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityKillswitchBinding bind(View view, Object object) {
        return (ActivityKillswitchBinding)ActivityKillswitchBinding.bind((Object)object, (View)view, (int)2131558440);
    }

    public static ActivityKillswitchBinding inflate(LayoutInflater layoutInflater) {
        return ActivityKillswitchBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityKillswitchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityKillswitchBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityKillswitchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityKillswitchBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558440, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityKillswitchBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityKillswitchBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558440, null, (boolean)false, (Object)object);
    }
}

