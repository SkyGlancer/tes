/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ProgressBar
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.Guideline
 *  androidx.core.widget.NestedScrollView
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
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;

public abstract class ActivityOrderDetailsBinding
extends ViewDataBinding {
    public final TextView btnAccept;
    public final TextView btnCancelOrder;
    public final TextView btnDecline;
    public final TextView btnDeliverd;
    public final TextView btnNotDelivered;
    public final TextView btnShipOrder;
    public final View divider;
    public final View dividerGrand;
    public final View dividerList;
    public final Guideline guideline;
    public final Guideline guideline1;
    public final ConstraintLayout idFooterView;
    public final NestedScrollView nestedRecycler;
    public final ProgressBar progressBar;
    public final RecyclerView recyclerview;
    public final NestedScrollView scrollView;
    public final View statusDot;
    public final MaterialToolbar toolbar;
    public final TextView tvAddress;
    public final TextView tvAddressValue;
    public final TextView tvCall;
    public final TextView tvContactNumber;
    public final TextView tvContactNumberValue;
    public final TextView tvCustemersDetails;
    public final TextView tvDate;
    public final TextView tvDelivery;
    public final TextView tvDeliveryValue;
    public final TextView tvGrandTotal;
    public final TextView tvGrandTotalValue;
    public final TextView tvItemTotal;
    public final TextView tvItemTotalValue;
    public final TextView tvName;
    public final TextView tvNameValue;
    public final TextView tvNoOfItems;
    public final TextView tvOrderid;
    public final TextView tvPayment;
    public final TextView tvPaymentType;
    public final TextView tvPincode;
    public final TextView tvPincodeValue;
    public final TextView tvState;
    public final TextView tvStateValue;
    public final TextView tvStatus;

    protected ActivityOrderDetailsBinding(Object object, View view, int n, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view2, View view3, View view4, Guideline guideline, Guideline guideline2, ConstraintLayout constraintLayout, NestedScrollView nestedScrollView, ProgressBar progressBar, RecyclerView recyclerView, NestedScrollView nestedScrollView2, View view5, MaterialToolbar materialToolbar, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26, TextView textView27, TextView textView28, TextView textView29, TextView textView30) {
        super(object, view, n);
        this.btnAccept = textView;
        this.btnCancelOrder = textView2;
        this.btnDecline = textView3;
        this.btnDeliverd = textView4;
        this.btnNotDelivered = textView5;
        this.btnShipOrder = textView6;
        this.divider = view2;
        this.dividerGrand = view3;
        this.dividerList = view4;
        this.guideline = guideline;
        this.guideline1 = guideline2;
        this.idFooterView = constraintLayout;
        this.nestedRecycler = nestedScrollView;
        this.progressBar = progressBar;
        this.recyclerview = recyclerView;
        this.scrollView = nestedScrollView2;
        this.statusDot = view5;
        this.toolbar = materialToolbar;
        this.tvAddress = textView7;
        this.tvAddressValue = textView8;
        this.tvCall = textView9;
        this.tvContactNumber = textView10;
        this.tvContactNumberValue = textView11;
        this.tvCustemersDetails = textView12;
        this.tvDate = textView13;
        this.tvDelivery = textView14;
        this.tvDeliveryValue = textView15;
        this.tvGrandTotal = textView16;
        this.tvGrandTotalValue = textView17;
        this.tvItemTotal = textView18;
        this.tvItemTotalValue = textView19;
        this.tvName = textView20;
        this.tvNameValue = textView21;
        this.tvNoOfItems = textView22;
        this.tvOrderid = textView23;
        this.tvPayment = textView24;
        this.tvPaymentType = textView25;
        this.tvPincode = textView26;
        this.tvPincodeValue = textView27;
        this.tvState = textView28;
        this.tvStateValue = textView29;
        this.tvStatus = textView30;
    }

    public static ActivityOrderDetailsBinding bind(View view) {
        return ActivityOrderDetailsBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityOrderDetailsBinding bind(View view, Object object) {
        return (ActivityOrderDetailsBinding)ActivityOrderDetailsBinding.bind((Object)object, (View)view, (int)2131558444);
    }

    public static ActivityOrderDetailsBinding inflate(LayoutInflater layoutInflater) {
        return ActivityOrderDetailsBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityOrderDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityOrderDetailsBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityOrderDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityOrderDetailsBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558444, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityOrderDetailsBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityOrderDetailsBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558444, null, (boolean)false, (Object)object);
    }
}

