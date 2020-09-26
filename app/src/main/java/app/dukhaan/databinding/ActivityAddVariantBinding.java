/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  com.google.android.material.appbar.MaterialToolbar
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.ui.views.PrimaryButtonShadowed;
import com.google.android.material.appbar.MaterialToolbar;

public abstract class ActivityAddVariantBinding
extends ViewDataBinding {
    public final TextView btnAddColor;
    public final TextView btnAddSize;
    public final LinearLayout colorExpandedView;
    public final RelativeLayout colorHeader;
    public final ImageView colorIcon;
    public final LinearLayout colorInputContainer;
    public final LinearLayout container;
    public final PrimaryButtonShadowed idBtnFinish;
    public final TextView idColorTitle;
    public final TextView idTitle;
    public final LinearLayout sizeExpandedView;
    public final RelativeLayout sizeHeader;
    public final ImageView sizeIcon;
    public final LinearLayout sizeInputContainer;
    public final TextView toolTitle;
    public final MaterialToolbar toolbar;

    protected ActivityAddVariantBinding(Object object, View view, int n, TextView textView, TextView textView2, LinearLayout linearLayout, RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, PrimaryButtonShadowed primaryButtonShadowed, TextView textView3, TextView textView4, LinearLayout linearLayout4, RelativeLayout relativeLayout2, ImageView imageView2, LinearLayout linearLayout5, TextView textView5, MaterialToolbar materialToolbar) {
        super(object, view, n);
        this.btnAddColor = textView;
        this.btnAddSize = textView2;
        this.colorExpandedView = linearLayout;
        this.colorHeader = relativeLayout;
        this.colorIcon = imageView;
        this.colorInputContainer = linearLayout2;
        this.container = linearLayout3;
        this.idBtnFinish = primaryButtonShadowed;
        this.idColorTitle = textView3;
        this.idTitle = textView4;
        this.sizeExpandedView = linearLayout4;
        this.sizeHeader = relativeLayout2;
        this.sizeIcon = imageView2;
        this.sizeInputContainer = linearLayout5;
        this.toolTitle = textView5;
        this.toolbar = materialToolbar;
    }

    public static ActivityAddVariantBinding bind(View view) {
        return ActivityAddVariantBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAddVariantBinding bind(View view, Object object) {
        return (ActivityAddVariantBinding)ActivityAddVariantBinding.bind((Object)object, (View)view, (int)2131558429);
    }

    public static ActivityAddVariantBinding inflate(LayoutInflater layoutInflater) {
        return ActivityAddVariantBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityAddVariantBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityAddVariantBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAddVariantBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityAddVariantBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558429, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityAddVariantBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityAddVariantBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558429, null, (boolean)false, (Object)object);
    }
}

