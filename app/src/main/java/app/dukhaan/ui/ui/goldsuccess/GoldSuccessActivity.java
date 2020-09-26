package app.dukhaan.ui.ui.goldsuccess;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.databinding.ActivityGoldSuccessBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.goldsuccess.GoldSuccessActivity.1;
import app.dukhaan.ui.goldsuccess.GoldSuccessActivity.2;
import app.dukhaan.ui.goldsuccess.GoldSuccessNavigator;
import app.dukhaan.ui.goldsuccess.GoldSuccessViewModel;
import app.dukhaan.ui.main.MainActivity;

public class GoldSuccessActivity extends BaseActivity<ActivityGoldSuccessBinding, GoldSuccessViewModel> implements GoldSuccessNavigator {
   private ActivityGoldSuccessBinding binding;
   private GoldSuccessViewModel mViewModel;

   public GoldSuccessActivity() {
   }

   private void animateLoader() {
      this.binding.loader.setMinAndMaxFrame(60, 130);
      this.binding.loader.playAnimation();
      this.binding.loader.addAnimatorListener(new 1(this));
   }

   private void launchHome() {
      Intent var1 = new Intent(this, MainActivity.class);
      var1.setFlags(268468224);
      this.startActivity(var1);
   }

   private void showContent() {
      Animation var1 = AnimationUtils.loadAnimation(this, fade_in_store_created);
      this.binding.title.startAnimation(var1);
      this.binding.icClose.startAnimation(var1);
      this.binding.description.startAnimation(var1);
      this.binding.btnContinue.startAnimation(var1);
      var1.setAnimationListener(new 2(this));
   }

   public int getLayoutId() {
      return activity_edit_product;
   }

   public Class<GoldSuccessViewModel> getViewModel() {
      return GoldSuccessViewModel.class;
   }

   public void onApiError(ErrorResponse var1) {
   }

   protected void onCreate(Bundle var1, GoldSuccessViewModel var2, ActivityGoldSuccessBinding var3) {
      this.binding = var3;
      this.mViewModel = var2;
      var2.setNavigator(this);
      this.animateLoader();
      var3.btnContinue.setOnClickListener(new _$$Lambda$GoldSuccessActivity$b2X_L0h0aSPty__n9__5rAshLEA(this));
      var3.icClose.setOnClickListener(new _$$Lambda$GoldSuccessActivity$uXFvc5nXZV58wRpdVEwD4wrgV0E(this));
   }
}
