/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
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
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.ui.views.PrimaryButton;
import com.google.android.material.appbar.MaterialToolbar;

public abstract class ActivityChangeLanguageBinding
extends ViewDataBinding {
    public final PrimaryButton btnSave;
    public final RecyclerView recyclerview;
    public final MaterialToolbar toolbar;

    protected ActivityChangeLanguageBinding(Object object, View view, int n, PrimaryButton primaryButton, RecyclerView recyclerView, MaterialToolbar materialToolbar) {
        super(object, view, n);
        this.btnSave = primaryButton;
        this.recyclerview = recyclerView;
        this.toolbar = materialToolbar;
    }

    public static ActivityChangeLanguageBinding bind(View view) {
        return ActivityChangeLanguageBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityChangeLanguageBinding bind(View view, Object object) {
        return (ActivityChangeLanguageBinding)ActivityChangeLanguageBinding.bind((Object)object, (View)view, (int)2131558434);
    }

    public static ActivityChangeLanguageBinding inflate(LayoutInflater layoutInflater) {
        return ActivityChangeLanguageBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityChangeLanguageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityChangeLanguageBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityChangeLanguageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityChangeLanguageBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558434, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityChangeLanguageBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityChangeLanguageBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558434, null, (boolean)false, (Object)object);
    }
}

