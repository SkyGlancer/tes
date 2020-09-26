/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  androidx.appcompat.app.ActionBar
 *  androidx.appcompat.widget.Toolbar
 *  androidx.databinding.ViewDataBinding
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.databinding.ActivityPrivacyPolicyBinding
 *  app.dukhaan.ui.privacy.PrivacyPolicyNavigator
 *  app.dukhaan.ui.privacy.PrivacyPolicyViewModel
 *  com.google.android.material.appbar.MaterialToolbar
 *  java.lang.Class
 *  java.lang.String
 */
package app.dukhaan.ui.privacy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.databinding.ActivityPrivacyPolicyBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.privacy.-$$Lambda$PrivacyPolicyActivity$_DWk-Ki9wSLpRRtx5Rml8mqPwME;
import app.dukhaan.ui.privacy.PrivacyPolicyActivity;
import app.dukhaan.ui.privacy.PrivacyPolicyNavigator;
import app.dukhaan.ui.privacy.PrivacyPolicyViewModel;
import app.dukhaan.util.ModalDialogs;
import com.google.android.material.appbar.MaterialToolbar;

public class PrivacyPolicyActivity
extends BaseActivity<ActivityPrivacyPolicyBinding, PrivacyPolicyViewModel>
implements PrivacyPolicyNavigator {
    private ActivityPrivacyPolicyBinding binding;
    private PrivacyPolicyViewModel viewModel;

    @Override
    public int getLayoutId() {
        return 2131558445;
    }

    @Override
    public Class<PrivacyPolicyViewModel> getViewModel() {
        return PrivacyPolicyViewModel.class;
    }

    public /* synthetic */ void lambda$onCreate$0$PrivacyPolicyActivity(View view) {
        this.onBackPressed();
    }

    public void onApiError(ErrorResponse errorResponse) {
        ModalDialogs.showUnknownError((Activity)this);
    }

    @Override
    protected void onCreate(Bundle bundle, PrivacyPolicyViewModel privacyPolicyViewModel, ActivityPrivacyPolicyBinding activityPrivacyPolicyBinding) {
        this.viewModel = privacyPolicyViewModel;
        this.binding = activityPrivacyPolicyBinding;
        this.setSupportActionBar((Toolbar)activityPrivacyPolicyBinding.toolbar);
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        this.showFullscreenLoader();
        activityPrivacyPolicyBinding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$PrivacyPolicyActivity$_DWk-Ki9wSLpRRtx5Rml8mqPwME(this));
        activityPrivacyPolicyBinding.webview.clearHistory();
        activityPrivacyPolicyBinding.webview.getSettings().setJavaScriptEnabled(true);
        activityPrivacyPolicyBinding.webview.getSettings().setDomStorageEnabled(true);
        activityPrivacyPolicyBinding.webview.setHorizontalScrollBarEnabled(false);
        activityPrivacyPolicyBinding.webview.setWebChromeClient(new WebChromeClient((Context)this){
            Context context;
            {
                this.context = context;
            }
        });
        activityPrivacyPolicyBinding.webview.loadUrl("https://mydukaan.io/privacy");
        activityPrivacyPolicyBinding.webview.setWebViewClient(new WebViewClient(this, activityPrivacyPolicyBinding){
            final /* synthetic */ PrivacyPolicyActivity this$0;
            final /* synthetic */ ActivityPrivacyPolicyBinding val$binding;
            {
                this.this$0 = privacyPolicyActivity;
                this.val$binding = activityPrivacyPolicyBinding;
            }

            public void onPageFinished(WebView webView, String string2) {
                super.onPageFinished(webView, string2);
                this.this$0.hideFullscreenLoader();
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
                this.val$binding.webview.loadUrl(string2);
                return true;
            }
        });
    }

}

