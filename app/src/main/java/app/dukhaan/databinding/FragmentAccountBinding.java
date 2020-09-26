/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.imageview.ShapeableImageView;

public abstract class FragmentAccountBinding
extends ViewDataBinding {
    public final TextView customerSupportNumber;
    public final LinearLayout customerSupportNumberContainer;
    public final TextView customerSupportNumberLabel;
    public final ImageView icToggleChat;
    public final TextView icToggleChatLabel;
    public final TextView idAccountName;
    public final TextView idBtnChangeLanguage;
    public final TextView idBtnDelivery;
    public final TextView idBtnLogout;
    public final TextView idBtnPrivacy;
    public final TextView idBtnRateUs;
    public final TextView idBtnRefer;
    public final TextView idBtnShareApp;
    public final ConstraintLayout idHeaderContainer;
    public final TextView idLinkEditBusinessDetails;
    public final ShapeableImageView idProfilePic;
    public final View idView;
    public final LinearLayout shareWhatsappContainer;

    protected FragmentAccountBinding(Object object, View view, int n, TextView textView, LinearLayout linearLayout, TextView textView2, ImageView imageView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, ConstraintLayout constraintLayout, TextView textView12, ShapeableImageView shapeableImageView, View view2, LinearLayout linearLayout2) {
        super(object, view, n);
        this.customerSupportNumber = textView;
        this.customerSupportNumberContainer = linearLayout;
        this.customerSupportNumberLabel = textView2;
        this.icToggleChat = imageView;
        this.icToggleChatLabel = textView3;
        this.idAccountName = textView4;
        this.idBtnChangeLanguage = textView5;
        this.idBtnDelivery = textView6;
        this.idBtnLogout = textView7;
        this.idBtnPrivacy = textView8;
        this.idBtnRateUs = textView9;
        this.idBtnRefer = textView10;
        this.idBtnShareApp = textView11;
        this.idHeaderContainer = constraintLayout;
        this.idLinkEditBusinessDetails = textView12;
        this.idProfilePic = shapeableImageView;
        this.idView = view2;
        this.shareWhatsappContainer = linearLayout2;
    }

    public static FragmentAccountBinding bind(View view) {
        return FragmentAccountBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAccountBinding bind(View view, Object object) {
        return (FragmentAccountBinding)FragmentAccountBinding.bind((Object)object, (View)view, (int)2131558496);
    }

    public static FragmentAccountBinding inflate(LayoutInflater layoutInflater) {
        return FragmentAccountBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static FragmentAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return FragmentAccountBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (FragmentAccountBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558496, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static FragmentAccountBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (FragmentAccountBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558496, null, (boolean)false, (Object)object);
    }
}

