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

public abstract class ActivityCreateCategoryBinding
extends ViewDataBinding {
    public final PrimaryButton btnCreate;
    public final AppCompatEditText idEtCategoryName;
    public final MaterialToolbar toolbar;

    protected ActivityCreateCategoryBinding(Object object, View view, int n, PrimaryButton primaryButton, AppCompatEditText appCompatEditText, MaterialToolbar materialToolbar) {
        super(object, view, n);
        this.btnCreate = primaryButton;
        this.idEtCategoryName = appCompatEditText;
        this.toolbar = materialToolbar;
    }

    public static ActivityCreateCategoryBinding bind(View view) {
        return ActivityCreateCategoryBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCreateCategoryBinding bind(View view, Object object) {
        return (ActivityCreateCategoryBinding)ActivityCreateCategoryBinding.bind((Object)object, (View)view, (int)2131558435);
    }

    public static ActivityCreateCategoryBinding inflate(LayoutInflater layoutInflater) {
        return ActivityCreateCategoryBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityCreateCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityCreateCategoryBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCreateCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityCreateCategoryBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558435, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityCreateCategoryBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityCreateCategoryBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558435, null, (boolean)false, (Object)object);
    }
}

