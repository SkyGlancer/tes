package app.dukhaan.ui.ui.onboarding_setps;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.databinding.FragmentOnboardingStepsBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsNavigator;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel;
import app.dukhaan.ui.views.steps.StepInstructionCard;

public class OnboardingStepsFragment extends BaseFragment<FragmentOnboardingStepsBinding, OnboardingStepsViewModel> implements OnboardingStepsNavigator {
   private FragmentOnboardingStepsBinding binding;
   private OnboardingStepsViewModel mViewModel;

   public OnboardingStepsFragment() {
   }

   public static OnboardingStepsFragment newInstance() {
      OnboardingStepsFragment var0 = new OnboardingStepsFragment();
      var0.setArguments(new Bundle());
      return var0;
   }

   private void renderData() {
      boolean var1 = AppPref.getInstance().isProductsAdded();
      this.binding.step1.setData(1, true, false);
      String var2 = this.getString(R.string.store_completed_percentage, new Object[]{80});
      if (var1) {
         var2 = this.getString(R.string.store_completed_percentage, new Object[]{90});
      }

      this.binding.lblCompletion.setText(var2);
      this.binding.step2.setData(2, var1, false);
      this.binding.step3.setData(3, false, var1 ^ true);
      this.binding.instruction1.setData(1, this.getString(R.string.step_1_title), this.getString(R.string.step_1_inst), this.getString(R.string.visit_store), false, false);
      StepInstructionCard var3 = this.binding.instruction2;
      String var4 = this.getString(R.string.step_2_title);
      String var5 = this.getString(R.string.step_2_inst);
      if (!var1) {
         var2 = this.getString(R.string.add_product_link);
      } else {
         var2 = this.getString(R.string.view_product);
      }

      var3.setData(2, var4, var5, var2, var1 ^ true, false);
      this.binding.instruction3.setData(3, this.getString(R.string.step_3_title), this.getString(R.string.step_3_inst), this.getString(R.string.share), true, true, var1 ^ true);
      View var7 = this.binding.line2;
      int var6;
      if (!var1) {
         var6 = this.getResources().getColor(R.color.grey);
      } else {
         var6 = this.getResources().getColor(R.color.colorPrimary);
      }

      var7.setBackgroundColor(var6);
      this.binding.instruction1.setListener(new _$$Lambda$OnboardingStepsFragment$YKR_GwSCp6J5s6nKvy5xaiYs7Vk(this));
      this.binding.instruction2.setListener(new _$$Lambda$OnboardingStepsFragment$7rnl8tZmEru7T1Pt59Vp_KOWPwE(this, var1));
      this.binding.instruction3.setListener(new _$$Lambda$OnboardingStepsFragment$o__etdVBCTDlDU34T5W6caEMJLg(this));
   }

   public int getLayoutId() {
      return fragment_onboarding_steps;
   }

   protected Class<OnboardingStepsViewModel> getViewModel() {
      return OnboardingStepsViewModel.class;
   }

   public void onApiError(ErrorResponse var1) {
   }

   protected void onCreateView(Bundle var1, OnboardingStepsViewModel var2, FragmentOnboardingStepsBinding var3, Context var4) {
      this.binding = var3;
      this.mViewModel = var2;
      var2.setNavigator(this);
      this.renderData();
   }
}
