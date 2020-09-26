package app.dukhaan.ui.ui.wastories;

import android.os.Bundle;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.databinding.ActivityWaStoriesBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.wastories.WAStoriesListAdapter;
import app.dukhaan.ui.wastories.WAStoriesNavigator;
import app.dukhaan.ui.wastories.WAStoriesViewModel;
import app.dukhaan.util.ModalDialogs;

public class WAStoriesActivity extends BaseActivity<ActivityWaStoriesBinding, WAStoriesViewModel> implements WAStoriesNavigator {
   ActivityWaStoriesBinding binding;
   WAStoriesViewModel mViewModel;

   public WAStoriesActivity() {
   }

   public int getLayoutId() {
      return activity_verify_otp;
   }

   public Class<WAStoriesViewModel> getViewModel() {
      return WAStoriesViewModel.class;
   }

   public void onApiError(ErrorResponse var1) {
      ModalDialogs.showUnknownError(this);
   }

   protected void onCreate(Bundle var1, WAStoriesViewModel var2, ActivityWaStoriesBinding var3) {
      this.mViewModel = var2;
      this.binding = var3;
      this.setSupportActionBar(var3.toolbar);
      this.enableToolbarUpNavigation();
      var3.toolbar.setNavigationOnClickListener(new _$$Lambda$WAStoriesActivity$a7diIVawRW1DIVDw_gRvQ2ZqCUs(this));
      WAStoriesListAdapter var4 = new WAStoriesListAdapter(this);
      var3.viewPager.setAdapter(var4);
   }
}
