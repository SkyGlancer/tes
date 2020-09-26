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
import app.dukhaan.ui.views.StoreInfoCard;

public abstract class StoreInfoCardContainerBinding
extends ViewDataBinding {
    public final StoreInfoCard storeInfoCard;

    protected StoreInfoCardContainerBinding(Object object, View view, int n, StoreInfoCard storeInfoCard) {
        super(object, view, n);
        this.storeInfoCard = storeInfoCard;
    }

    public static StoreInfoCardContainerBinding bind(View view) {
        return StoreInfoCardContainerBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static StoreInfoCardContainerBinding bind(View view, Object object) {
        return (StoreInfoCardContainerBinding)StoreInfoCardContainerBinding.bind((Object)object, (View)view, (int)2131558627);
    }

    public static StoreInfoCardContainerBinding inflate(LayoutInflater layoutInflater) {
        return StoreInfoCardContainerBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static StoreInfoCardContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return StoreInfoCardContainerBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static StoreInfoCardContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (StoreInfoCardContainerBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558627, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static StoreInfoCardContainerBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (StoreInfoCardContainerBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558627, null, (boolean)false, (Object)object);
    }
}

