/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ProgressBar
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
import android.widget.ProgressBar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.MaterialToolbar;

public abstract class ActivityReportIssueBinding
extends ViewDataBinding {
    public final ProgressBar progressBar;
    public final MaterialToolbar toolbar;

    protected ActivityReportIssueBinding(Object object, View view, int n, ProgressBar progressBar, MaterialToolbar materialToolbar) {
        super(object, view, n);
        this.progressBar = progressBar;
        this.toolbar = materialToolbar;
    }

    public static ActivityReportIssueBinding bind(View view) {
        return ActivityReportIssueBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityReportIssueBinding bind(View view, Object object) {
        return (ActivityReportIssueBinding)ActivityReportIssueBinding.bind((Object)object, (View)view, (int)2131558446);
    }

    public static ActivityReportIssueBinding inflate(LayoutInflater layoutInflater) {
        return ActivityReportIssueBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityReportIssueBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityReportIssueBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityReportIssueBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityReportIssueBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558446, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityReportIssueBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityReportIssueBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558446, null, (boolean)false, (Object)object);
    }
}

