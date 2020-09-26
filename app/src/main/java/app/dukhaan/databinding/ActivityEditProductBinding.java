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
 *  android.widget.Space
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.constraintlayout.widget.Guideline
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  androidx.recyclerview.widget.RecyclerView
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
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.ui.views.SpinnerImage;
import com.google.android.material.appbar.MaterialToolbar;

public abstract class ActivityEditProductBinding
extends ViewDataBinding {
    public final PrimaryButton addProduct;
    public final TextView btnAddVariant;
    public final TextView costDescription;
    public final Space deleteSpacer;
    public final TextView errorMessage;
    public final AppCompatEditText etCategory;
    public final AppCompatEditText etDesc;
    public final AppCompatEditText etMrp;
    public final AppCompatEditText etProductName;
    public final AppCompatEditText etQuantity;
    public final AppCompatEditText etSellingPrice;
    public final AppCompatEditText etUnit;
    public final Guideline guideline;
    public final ImageView ivDelete;
    public final TextView lblAddVariant;
    public final TextView lblImageCount;
    public final RelativeLayout llAmount;
    public final LinearLayout llDelete;
    public final RelativeLayout llOriginalPrice;
    public final RelativeLayout llQuantity;
    public final RelativeLayout llUnit;
    public final TextView priceError;
    public final RecyclerView recyclerview;
    public final SpinnerImage spinnerChooseCategory;
    public final SpinnerImage spinnerUnit;
    public final TextView toolTitle;
    public final MaterialToolbar toolbar;
    public final TextView unitDescription;
    public final View viewCategory;
    public final View viewUnit;

    protected ActivityEditProductBinding(Object object, View view, int n, PrimaryButton primaryButton, TextView textView, TextView textView2, Space space, TextView textView3, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, AppCompatEditText appCompatEditText3, AppCompatEditText appCompatEditText4, AppCompatEditText appCompatEditText5, AppCompatEditText appCompatEditText6, AppCompatEditText appCompatEditText7, Guideline guideline, ImageView imageView, TextView textView4, TextView textView5, RelativeLayout relativeLayout, LinearLayout linearLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TextView textView6, RecyclerView recyclerView, SpinnerImage spinnerImage, SpinnerImage spinnerImage2, TextView textView7, MaterialToolbar materialToolbar, TextView textView8, View view2, View view3) {
        super(object, view, n);
        this.addProduct = primaryButton;
        this.btnAddVariant = textView;
        this.costDescription = textView2;
        this.deleteSpacer = space;
        this.errorMessage = textView3;
        this.etCategory = appCompatEditText;
        this.etDesc = appCompatEditText2;
        this.etMrp = appCompatEditText3;
        this.etProductName = appCompatEditText4;
        this.etQuantity = appCompatEditText5;
        this.etSellingPrice = appCompatEditText6;
        this.etUnit = appCompatEditText7;
        this.guideline = guideline;
        this.ivDelete = imageView;
        this.lblAddVariant = textView4;
        this.lblImageCount = textView5;
        this.llAmount = relativeLayout;
        this.llDelete = linearLayout;
        this.llOriginalPrice = relativeLayout2;
        this.llQuantity = relativeLayout3;
        this.llUnit = relativeLayout4;
        this.priceError = textView6;
        this.recyclerview = recyclerView;
        this.spinnerChooseCategory = spinnerImage;
        this.spinnerUnit = spinnerImage2;
        this.toolTitle = textView7;
        this.toolbar = materialToolbar;
        this.unitDescription = textView8;
        this.viewCategory = view2;
        this.viewUnit = view3;
    }

    public static ActivityEditProductBinding bind(View view) {
        return ActivityEditProductBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityEditProductBinding bind(View view, Object object) {
        return (ActivityEditProductBinding)ActivityEditProductBinding.bind((Object)object, (View)view, (int)2131558438);
    }

    public static ActivityEditProductBinding inflate(LayoutInflater layoutInflater) {
        return ActivityEditProductBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityEditProductBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityEditProductBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityEditProductBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityEditProductBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558438, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityEditProductBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityEditProductBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558438, null, (boolean)false, (Object)object);
    }
}

