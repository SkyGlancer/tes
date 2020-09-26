/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.ui.views.FullButtonShadowed;

public abstract class FragmentMarketingBinding
extends ViewDataBinding {
    public final TextView goldDescription;
    public final LinearLayout marketingRow1;
    public final LinearLayout marketingRow2;
    public final LinearLayout marketingTile1;
    public final LinearLayout marketingTile2;
    public final LinearLayout marketingTile3;
    public final LinearLayout marketingTile4;
    public final FullButtonShadowed payBtn;

    protected FragmentMarketingBinding(Object object, View view, int n, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, FullButtonShadowed fullButtonShadowed) {
        super(object, view, n);
        this.goldDescription = textView;
        this.marketingRow1 = linearLayout;
        this.marketingRow2 = linearLayout2;
        this.marketingTile1 = linearLayout3;
        this.marketingTile2 = linearLayout4;
        this.marketingTile3 = linearLayout5;
        this.marketingTile4 = linearLayout6;
        this.payBtn = fullButtonShadowed;
    }

    public static FragmentMarketingBinding bind(View view) {
        return FragmentMarketingBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMarketingBinding bind(View view, Object object) {
        return (FragmentMarketingBinding)FragmentMarketingBinding.bind((Object)object, (View)view, (int)2131558486);
    }

    public static FragmentMarketingBinding inflate(LayoutInflater layoutInflater) {
        return FragmentMarketingBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static FragmentMarketingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return FragmentMarketingBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMarketingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (FragmentMarketingBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558486, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static FragmentMarketingBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (FragmentMarketingBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558486, null, (boolean)false, (Object)object);
    }
}

