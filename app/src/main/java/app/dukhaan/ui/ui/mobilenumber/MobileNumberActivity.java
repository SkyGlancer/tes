package app.dukhaan.ui.ui.mobilenumber;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.databinding.ActivityMobileNumberBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.mobilenumber.MobileNumberNavigator;
import app.dukhaan.ui.mobilenumber.MobileNumberViewModel;

import javax.inject.Inject;

public class MobileNumberActivity extends BaseActivity<ActivityMobileNumberBinding, MobileNumberViewModel> implements MobileNumberNavigator {
   MobileNumberViewModel mViewModel;
   @Inject
   Factory mViewModelFactory;

   public MobileNumberActivity() {
   }

   public int getLayoutId() {
      return activity_mobile_number;
   }

   public Class<MobileNumberViewModel> getViewModel() {
      return MobileNumberViewModel.class;
   }

   public void onApiError(ErrorResponse var1) {
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(activity_mobile_number);
      this.mViewModel.setNavigator(this);
   }

   protected void onCreate(Bundle var1, MobileNumberViewModel var2, ActivityMobileNumberBinding var3) {
   }
}
