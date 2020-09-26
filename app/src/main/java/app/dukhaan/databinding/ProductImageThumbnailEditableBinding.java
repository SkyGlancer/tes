/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  com.google.android.material.imageview.ShapeableImageView
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.imageview.ShapeableImageView;

public abstract class ProductImageThumbnailEditableBinding
extends ViewDataBinding {
    public final ShapeableImageView image;
    public final ImageView remove;

    protected ProductImageThumbnailEditableBinding(Object object, View view, int n, ShapeableImageView shapeableImageView, ImageView imageView) {
        super(object, view, n);
        this.image = shapeableImageView;
        this.remove = imageView;
    }

    public static ProductImageThumbnailEditableBinding bind(View view) {
        return ProductImageThumbnailEditableBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductImageThumbnailEditableBinding bind(View view, Object object) {
        return (ProductImageThumbnailEditableBinding)ProductImageThumbnailEditableBinding.bind((Object)object, (View)view, (int)2131558621);
    }

    public static ProductImageThumbnailEditableBinding inflate(LayoutInflater layoutInflater) {
        return ProductImageThumbnailEditableBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ProductImageThumbnailEditableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ProductImageThumbnailEditableBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductImageThumbnailEditableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ProductImageThumbnailEditableBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558621, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ProductImageThumbnailEditableBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ProductImageThumbnailEditableBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558621, null, (boolean)false, (Object)object);
    }
}

