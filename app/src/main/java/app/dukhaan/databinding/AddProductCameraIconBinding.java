/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class AddProductCameraIconBinding
extends ViewDataBinding {
    public final ConstraintLayout addImage;
    public final ImageView icon;

    protected AddProductCameraIconBinding(Object object, View view, int n, ConstraintLayout constraintLayout, ImageView imageView) {
        super(object, view, n);
        this.addImage = constraintLayout;
        this.icon = imageView;
    }

    public static AddProductCameraIconBinding bind(View view) {
        return AddProductCameraIconBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddProductCameraIconBinding bind(View view, Object object) {
        return (AddProductCameraIconBinding)AddProductCameraIconBinding.bind((Object)object, (View)view, (int)2131558454);
    }

    public static AddProductCameraIconBinding inflate(LayoutInflater layoutInflater) {
        return AddProductCameraIconBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static AddProductCameraIconBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return AddProductCameraIconBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddProductCameraIconBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (AddProductCameraIconBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558454, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static AddProductCameraIconBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (AddProductCameraIconBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558454, null, (boolean)false, (Object)object);
    }
}

