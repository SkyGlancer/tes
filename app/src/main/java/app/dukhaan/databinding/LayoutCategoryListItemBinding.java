/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.ui.views.categories.CategoryListItemCard;

public abstract class LayoutCategoryListItemBinding
extends ViewDataBinding {
    public final CategoryListItemCard category;

    protected LayoutCategoryListItemBinding(Object object, View view, int n, CategoryListItemCard categoryListItemCard) {
        super(object, view, n);
        this.category = categoryListItemCard;
    }

    public static LayoutCategoryListItemBinding bind(View view) {
        return LayoutCategoryListItemBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCategoryListItemBinding bind(View view, Object object) {
        return (LayoutCategoryListItemBinding)LayoutCategoryListItemBinding.bind((Object)object, (View)view, (int)2131558531);
    }

    public static LayoutCategoryListItemBinding inflate(LayoutInflater layoutInflater) {
        return LayoutCategoryListItemBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static LayoutCategoryListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return LayoutCategoryListItemBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCategoryListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (LayoutCategoryListItemBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558531, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static LayoutCategoryListItemBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (LayoutCategoryListItemBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558531, null, (boolean)false, (Object)object);
    }
}

