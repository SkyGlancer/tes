package app.dukhaan.ui.ui.privacy;

import android.os.Bundle;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.databinding.ActivityPrivacyPolicyBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.privacy.PrivacyPolicyActivity.1;
import app.dukhaan.ui.privacy.PrivacyPolicyNavigator;
import app.dukhaan.ui.privacy.PrivacyPolicyViewModel;
import app.dukhaan.util.ModalDialogs;

public class PrivacyPolicyActivity extends BaseActivity<ActivityPrivacyPolicyBinding, PrivacyPolicyViewModel> implements PrivacyPolicyNavigator {
   private ActivityPrivacyPolicyBinding binding;
   private PrivacyPolicyViewModel viewModel;

   public PrivacyPolicyActivity() {
   }

   public int getLayoutId() {
      return activity_privacy_policy;
   }

   public Class<PrivacyPolicyViewModel> getViewModel() {
      return PrivacyPolicyViewModel.class;
   }

   public void onApiError(ErrorResponse var1) {
      ModalDialogs.showUnknownError(this);
   }

   protected void onCreate(Bundle var1, PrivacyPolicyViewModel var2, ActivityPrivacyPolicyBinding var3) {
      this.viewModel = var2;
      this.binding = var3;
      this.setSupportActionBar(var3.toolbar);
      if (this.getSupportActionBar() != null) {
         this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      }

      this.showFullscreenLoader();
      var3.toolbar.setNavigationOnClickListener(new _$$Lambda$PrivacyPolicyActivity$_DWk_Ki9wSLpRRtx5Rml8mqPwME(this));
      var3.webview.clearHistory();
      var3.webview.getSettings().setJavaScriptEnabled(true);
      var3.webview.getSettings().setDomStorageEnabled(true);
      var3.webview.setHorizontalScrollBarEnabled(false);
      var3.webview.setWebChromeClient(new app.dukhaan.ui.privacy.PrivacyPolicyActivity.MyWebChromeClient(this, this));
      var3.webview.loadUrl("https://mydukaan.io/privacy");
      var3.webview.setWebViewClient(new 1(this, var3));
   }
}
