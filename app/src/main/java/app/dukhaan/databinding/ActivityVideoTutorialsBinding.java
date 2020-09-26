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
import com.google.android.material.appbar.MaterialToolbar;

public abstract class ActivityVideoTutorialsBinding
extends ViewDataBinding {
    public final RecyclerView recyclerview;
    public final MaterialToolbar toolbar;

    protected ActivityVideoTutorialsBinding(Object object, View view, int n, RecyclerView recyclerView, MaterialToolbar materialToolbar) {
        super(object, view, n);
        this.recyclerview = recyclerView;
        this.toolbar = materialToolbar;
    }

    public static ActivityVideoTutorialsBinding bind(View view) {
        return ActivityVideoTutorialsBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityVideoTutorialsBinding bind(View view, Object object) {
        return (ActivityVideoTutorialsBinding)ActivityVideoTutorialsBinding.bind((Object)object, (View)view, (int)2131558452);
    }

    public static ActivityVideoTutorialsBinding inflate(LayoutInflater layoutInflater) {
        return ActivityVideoTutorialsBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityVideoTutorialsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityVideoTutorialsBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityVideoTutorialsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityVideoTutorialsBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558452, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityVideoTutorialsBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityVideoTutorialsBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558452, null, (boolean)false, (Object)object);
    }
}

