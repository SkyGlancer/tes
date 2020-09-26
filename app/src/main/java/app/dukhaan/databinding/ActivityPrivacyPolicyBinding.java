/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
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
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.MaterialToolbar;

public abstract class ActivityPrivacyPolicyBinding
extends ViewDataBinding {
    public final ProgressBar progressBar;
    public final MaterialToolbar toolbar;
    public final WebView webview;

    protected ActivityPrivacyPolicyBinding(Object object, View view, int n, ProgressBar progressBar, MaterialToolbar materialToolbar, WebView webView) {
        super(object, view, n);
        this.progressBar = progressBar;
        this.toolbar = materialToolbar;
        this.webview = webView;
    }

    public static ActivityPrivacyPolicyBinding bind(View view) {
        return ActivityPrivacyPolicyBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPrivacyPolicyBinding bind(View view, Object object) {
        return (ActivityPrivacyPolicyBinding)ActivityPrivacyPolicyBinding.bind((Object)object, (View)view, (int)2131558445);
    }

    public static ActivityPrivacyPolicyBinding inflate(LayoutInflater layoutInflater) {
        return ActivityPrivacyPolicyBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static ActivityPrivacyPolicyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return ActivityPrivacyPolicyBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPrivacyPolicyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (ActivityPrivacyPolicyBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558445, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static ActivityPrivacyPolicyBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (ActivityPrivacyPolicyBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558445, null, (boolean)false, (Object)object);
    }
}

