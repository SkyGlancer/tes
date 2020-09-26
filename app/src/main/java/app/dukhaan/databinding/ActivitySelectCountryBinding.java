/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.EditText
 *  android.widget.TextView
 *  androidx.appcompat.widget.Toolbar
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  androidx.recyclerview.widget.RecyclerView
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ActivitySelectCountryBinding
extends ViewDataBinding {
    public final RecyclerView countriesRecyclerView;
    public final EditText countryCodePickerSearch;
    public final TextView idDesc;
    public final TextView idSelectedCountry;
    public final TextView idTitle;
    public final Toolbar toolbar;

    protected ActivitySelectCountryBinding(Object object, View view, int n, RecyclerView recyclerView, EditText editText, TextView textView, TextView textView2, TextView textView3, Toolbar toolbar) {
        super(object, view, n);
        this.countriesRecyclerView = recyclerView;
        this.countryCodePickerSearch = editText;
        this.idDesc = textView;
        this.idSelectedCountry = textView2;
        this.idTitle = textView3;
        this.toolbar = toolbar;
    }

    public static ActivitySelectCountryBinding bind(View view) {
        return ActivitySelectCountryBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySelectCountryBinding bind(View view, Object object) {
        return (ActivitySelectCountryBinding)ActivitySelectCountryBinding.bind((Object)object, (View)view, (int)2131558447);
    }

    public static ActivitySelectCountryBinding inflate(LayoutInflater layoutInflater) {
        return ActivitySelectCountryBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivitySelectCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivitySelectCountryBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySelectCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivitySelectCountryBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558447, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivitySelectCountryBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivitySelectCountryBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558447, null, (boolean)false, (Object)object);
    }
}

