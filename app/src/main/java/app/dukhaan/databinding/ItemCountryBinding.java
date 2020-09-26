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

public abstract class ItemCountryBinding
extends ViewDataBinding {
    public final ImageView countryFlag;
    public final TextView countryTitle;
    public final ConstraintLayout rootView;

    protected ItemCountryBinding(Object object, View view, int n, ImageView imageView, TextView textView, ConstraintLayout constraintLayout) {
        super(object, view, n);
        this.countryFlag = imageView;
        this.countryTitle = textView;
        this.rootView = constraintLayout;
    }

    public static ItemCountryBinding bind(View view) {
        return ItemCountryBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCountryBinding bind(View view, Object object) {
        return (ItemCountryBinding)ItemCountryBinding.bind((Object)object, (View)view, (int)2131558523);
    }

    public static ItemCountryBinding inflate(LayoutInflater layoutInflater) {
        return ItemCountryBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ItemCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ItemCountryBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ItemCountryBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558523, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ItemCountryBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ItemCountryBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558523, null, (boolean)false, (Object)object);
    }
}

