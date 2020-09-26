/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.appcompat.widget.AppCompatEditText
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
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.ui.views.PrimaryButton;
import com.google.android.material.appbar.MaterialToolbar;

public abstract class ActivityEditCategoryBinding
extends ViewDataBinding {
    public final PrimaryButton btnUpdate;
    public final AppCompatEditText idEtCategoryName;
    public final MaterialToolbar toolbar;

    protected ActivityEditCategoryBinding(Object object, View view, int n, PrimaryButton primaryButton, AppCompatEditText appCompatEditText, MaterialToolbar materialToolbar) {
        super(object, view, n);
        this.btnUpdate = primaryButton;
        this.idEtCategoryName = appCompatEditText;
        this.toolbar = materialToolbar;
    }

    public static ActivityEditCategoryBinding bind(View view) {
        return ActivityEditCategoryBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityEditCategoryBinding bind(View view, Object object) {
        return (ActivityEditCategoryBinding)ActivityEditCategoryBinding.bind((Object)object, (View)view, (int)2131558437);
    }

    public static ActivityEditCategoryBinding inflate(LayoutInflater layoutInflater) {
        return ActivityEditCategoryBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityEditCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityEditCategoryBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityEditCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityEditCategoryBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558437, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityEditCategoryBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityEditCategoryBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558437, null, (boolean)false, (Object)object);
    }
}

