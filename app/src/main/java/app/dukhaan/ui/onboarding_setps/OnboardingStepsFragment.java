/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.TextView
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.FragmentActivity
 *  app.dukhaan.base.BaseFragment
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.ui.onboarding_setps.-$
 *  app.dukhaan.ui.onboarding_setps.-$$Lambda
 *  app.dukhaan.ui.onboarding_setps.-$$Lambda$OnboardingStepsFragment
 *  app.dukhaan.ui.onboarding_setps.-$$Lambda$OnboardingStepsFragment$7rnl8tZmEru7T1Pt59Vp-KOWPwE
 *  app.dukhaan.ui.onboarding_setps.-$$Lambda$OnboardingStepsFragment$YKR_GwSCp6J5s6nKvy5xaiYs7Vk
 *  app.dukhaan.ui.onboarding_setps.-$$Lambda$OnboardingStepsFragment$o__etdVBCTDlDU34T5W6caEMJLg
 *  app.dukhaan.ui.onboarding_setps.OnboardingStepsNavigator
 *  app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.greenrobot.eventbus.EventBus
 */
package app.dukhaan.ui.onboarding_setps;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.FragmentOnboardingStepsBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.editproduct.EditProductActivity;
import app.dukhaan.ui.onboarding_setps.-$;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsNavigator;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel;
import app.dukhaan.ui.views.steps.StepInstructionCard;
import app.dukhaan.ui.views.steps.StepNumber;
import app.dukhaan.util.AppUtils;
import org.greenrobot.eventbus.EventBus;

public class OnboardingStepsFragment
extends BaseFragment<FragmentOnboardingStepsBinding, OnboardingStepsViewModel>
implements OnboardingStepsNavigator {
    private FragmentOnboardingStepsBinding binding;
    private OnboardingStepsViewModel mViewModel;

    public static OnboardingStepsFragment newInstance() {
        OnboardingStepsFragment onboardingStepsFragment = new OnboardingStepsFragment();
        onboardingStepsFragment.setArguments(new Bundle());
        return onboardingStepsFragment;
    }

    private void renderData() {
        boolean bl = AppPref.getInstance().isProductsAdded();
        this.binding.step1.setData(1, true, false);
        Object[] arrobject = new Object[]{80};
        String string2 = this.getString(2131951954, arrobject);
        if (bl) {
            Object[] arrobject2 = new Object[]{90};
            string2 = this.getString(2131951954, arrobject2);
        }
        this.binding.lblCompletion.setText((CharSequence)string2);
        this.binding.step2.setData(2, bl, false);
        this.binding.step3.setData(3, false, bl ^ true);
        this.binding.instruction1.setData(1, this.getString(2131951949), this.getString(2131951948), this.getString(2131952022), false, false);
        StepInstructionCard stepInstructionCard = this.binding.instruction2;
        String string3 = this.getString(2131951951);
        String string4 = this.getString(2131951950);
        String string5 = !bl ? this.getString(2131951654) : this.getString(2131952021);
        stepInstructionCard.setData(2, string3, string4, string5, bl ^ true, false);
        this.binding.instruction3.setData(3, this.getString(2131951953), this.getString(2131951952), this.getString(2131951931), true, true, bl ^ true);
        View view = this.binding.line2;
        int n = !bl ? this.getResources().getColor(2131099821) : this.getResources().getColor(2131099728);
        view.setBackgroundColor(n);
        this.binding.instruction1.setListener((StepInstructionCard.StepInstructionCardListener)new -$.Lambda.OnboardingStepsFragment.YKR_GwSCp6J5s6nKvy5xaiYs7Vk(this));
        this.binding.instruction2.setListener((StepInstructionCard.StepInstructionCardListener)new -$.Lambda.OnboardingStepsFragment.7rnl8tZmEru7T1Pt59Vp-KOWPwE(this, bl));
        this.binding.instruction3.setListener((StepInstructionCard.StepInstructionCardListener)new -$.Lambda.OnboardingStepsFragment.o__etdVBCTDlDU34T5W6caEMJLg(this));
    }

    public int getLayoutId() {
        return 2131558499;
    }

    protected Class<OnboardingStepsViewModel> getViewModel() {
        return OnboardingStepsViewModel.class;
    }

    public /* synthetic */ void lambda$renderData$0$OnboardingStepsFragment() {
        Business business = this.mViewModel.getDataManager().getBusiness();
        if (business != null) {
            Context context = this.getContext();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://mydukaan.io/");
            stringBuilder.append(business.realmGet$link());
            AppUtils.openBrowser(context, stringBuilder.toString());
        }
    }

    public /* synthetic */ void lambda$renderData$1$OnboardingStepsFragment(boolean bl) {
        if (!bl) {
            this.startActivityForResult(new Intent((Context)this.getActivity(), EditProductActivity.class), 111);
            return;
        }
        AppEvent appEvent = new AppEvent(AppEvent.NAVIGATE_TO_PRODUCTS, null);
        EventBus.getDefault().post((Object)appEvent);
    }

    public /* synthetic */ void lambda$renderData$2$OnboardingStepsFragment() {
        Business business = this.mViewModel.getDataManager().getBusiness();
        if (business != null) {
            AppUtils.shareOnWhatsApp(this.getContext(), business.realmGet$id(), business.realmGet$name(), AppUtils.getStoreLink(business.realmGet$link()), AppPref.getInstance().getMobile());
            AppPref.getInstance().setSharedOnWhatsapp(true);
        }
    }

    public void onApiError(ErrorResponse errorResponse) {
    }

    protected void onCreateView(Bundle bundle, OnboardingStepsViewModel onboardingStepsViewModel, FragmentOnboardingStepsBinding fragmentOnboardingStepsBinding, Context context) {
        this.binding = fragmentOnboardingStepsBinding;
        this.mViewModel = onboardingStepsViewModel;
        onboardingStepsViewModel.setNavigator((Object)this);
        this.renderData();
    }
}

