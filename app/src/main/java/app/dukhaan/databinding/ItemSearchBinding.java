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
 *  androidx.databinding.Bindable
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
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.network.model.placesResponseData.Prediction;

public abstract class ItemSearchBinding
extends ViewDataBinding {
    public final ConstraintLayout constItemSearchPlaces;
    public final ImageView ivLocation;
    @Bindable
    protected Prediction mPrediction;
    public final TextView tvName;
    public final TextView tvOthersDesc;

    protected ItemSearchBinding(Object object, View view, int n, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        super(object, view, n);
        this.constItemSearchPlaces = constraintLayout;
        this.ivLocation = imageView;
        this.tvName = textView;
        this.tvOthersDesc = textView2;
    }

    public static ItemSearchBinding bind(View view) {
        return ItemSearchBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchBinding bind(View view, Object object) {
        return (ItemSearchBinding)ItemSearchBinding.bind((Object)object, (View)view, (int)2131558529);
    }

    public static ItemSearchBinding inflate(LayoutInflater layoutInflater) {
        return ItemSearchBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ItemSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ItemSearchBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ItemSearchBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558529, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ItemSearchBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ItemSearchBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558529, null, (boolean)false, (Object)object);
    }

    public Prediction getPrediction() {
        return this.mPrediction;
    }

    public abstract void setPrediction(Prediction var1);
}

