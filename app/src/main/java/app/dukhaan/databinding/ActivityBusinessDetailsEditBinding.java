/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.android.material.imageview.ShapeableImageView
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.ui.views.SpinnerImage;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.imageview.ShapeableImageView;

public abstract class ActivityBusinessDetailsEditBinding
extends ViewDataBinding {
    public final TextView btnRemoveProfilePic;
    public final PrimaryButton btnSave;
    public final AppCompatEditText businessLink;
    public final TextView errorBusinessName;
    public final TextView errorStoreTaken;
    public final AppCompatEditText idEtBusinessName;
    public final TextView idEtCountryName;
    public final TextView idEtInputAddress;
    public final TextView idEtInputMobile;
    public final ShapeableImageView idProfilePic;
    public final TextView lblUpdateImage;
    public final SpinnerImage spinnerImg;
    public final MaterialToolbar toolbar;

    protected ActivityBusinessDetailsEditBinding(Object object, View view, int n, TextView textView, PrimaryButton primaryButton, AppCompatEditText appCompatEditText, TextView textView2, TextView textView3, AppCompatEditText appCompatEditText2, TextView textView4, TextView textView5, TextView textView6, ShapeableImageView shapeableImageView, TextView textView7, SpinnerImage spinnerImage, MaterialToolbar materialToolbar) {
        super(object, view, n);
        this.btnRemoveProfilePic = textView;
        this.btnSave = primaryButton;
        this.businessLink = appCompatEditText;
        this.errorBusinessName = textView2;
        this.errorStoreTaken = textView3;
        this.idEtBusinessName = appCompatEditText2;
        this.idEtCountryName = textView4;
        this.idEtInputAddress = textView5;
        this.idEtInputMobile = textView6;
        this.idProfilePic = shapeableImageView;
        this.lblUpdateImage = textView7;
        this.spinnerImg = spinnerImage;
        this.toolbar = materialToolbar;
    }

    public static ActivityBusinessDetailsEditBinding bind(View view) {
        return ActivityBusinessDetailsEditBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBusinessDetailsEditBinding bind(View view, Object object) {
        return (ActivityBusinessDetailsEditBinding)ActivityBusinessDetailsEditBinding.bind((Object)object, (View)view, (int)2131558432);
    }

    public static ActivityBusinessDetailsEditBinding inflate(LayoutInflater layoutInflater) {
        return ActivityBusinessDetailsEditBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityBusinessDetailsEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityBusinessDetailsEditBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBusinessDetailsEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityBusinessDetailsEditBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558432, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityBusinessDetailsEditBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityBusinessDetailsEditBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558432, null, (boolean)false, (Object)object);
    }
}

