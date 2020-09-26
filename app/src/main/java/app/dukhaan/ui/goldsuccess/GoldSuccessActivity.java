/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationUtils
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.databinding.ViewDataBinding
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.databinding.ActivityGoldSuccessBinding
 *  app.dukhaan.ui.goldsuccess.GoldSuccessNavigator
 *  app.dukhaan.ui.goldsuccess.GoldSuccessViewModel
 *  com.airbnb.lottie.LottieAnimationView
 *  java.lang.Class
 *  java.lang.Object
 */
package app.dukhaan.ui.goldsuccess;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.databinding.ActivityGoldSuccessBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.goldsuccess.-$$Lambda$GoldSuccessActivity$b2X_L0h0aSPty__n9__5rAshLEA;
import app.dukhaan.ui.goldsuccess.-$$Lambda$GoldSuccessActivity$uXFvc5nXZV58wRpdVEwD4wrgV0E;
import app.dukhaan.ui.goldsuccess.GoldSuccessActivity;
import app.dukhaan.ui.goldsuccess.GoldSuccessNavigator;
import app.dukhaan.ui.goldsuccess.GoldSuccessViewModel;
import app.dukhaan.ui.main.MainActivity;
import app.dukhaan.ui.views.GoldButtonWhite;
import com.airbnb.lottie.LottieAnimationView;

public class GoldSuccessActivity
extends BaseActivity<ActivityGoldSuccessBinding, GoldSuccessViewModel>
implements GoldSuccessNavigator {
    private ActivityGoldSuccessBinding binding;
    private GoldSuccessViewModel mViewModel;

    static /* synthetic */ void access$000(GoldSuccessActivity goldSuccessActivity) {
        goldSuccessActivity.showContent();
    }

    static /* synthetic */ ActivityGoldSuccessBinding access$100(GoldSuccessActivity goldSuccessActivity) {
        return goldSuccessActivity.binding;
    }

    private void animateLoader() {
        this.binding.loader.setMinAndMaxFrame(60, 130);
        this.binding.loader.playAnimation();
        this.binding.loader.addAnimatorListener(new Animator.AnimatorListener(this){
            final /* synthetic */ GoldSuccessActivity this$0;
            {
                this.this$0 = goldSuccessActivity;
            }

            public void onAnimationCancel(Animator animator2) {
            }

            public void onAnimationEnd(Animator animator2) {
                GoldSuccessActivity.access$000(this.this$0);
            }

            public void onAnimationRepeat(Animator animator2) {
            }

            public void onAnimationStart(Animator animator2) {
            }
        });
    }

    private void launchHome() {
        Intent intent = new Intent((Context)this, MainActivity.class);
        intent.setFlags(268468224);
        this.startActivity(intent);
    }

    private void showContent() {
        Animation animation = AnimationUtils.loadAnimation((Context)this, (int)2130771997);
        this.binding.title.startAnimation(animation);
        this.binding.icClose.startAnimation(animation);
        this.binding.description.startAnimation(animation);
        this.binding.btnContinue.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener(this){
            final /* synthetic */ GoldSuccessActivity this$0;
            {
                this.this$0 = goldSuccessActivity;
            }

            public void onAnimationEnd(Animation animation) {
                GoldSuccessActivity.access$100((GoldSuccessActivity)this.this$0).title.setVisibility(0);
                GoldSuccessActivity.access$100((GoldSuccessActivity)this.this$0).description.setVisibility(0);
                GoldSuccessActivity.access$100((GoldSuccessActivity)this.this$0).icClose.setVisibility(0);
                GoldSuccessActivity.access$100((GoldSuccessActivity)this.this$0).btnContinue.setVisibility(0);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
    }

    @Override
    public int getLayoutId() {
        return 2131558438;
    }

    @Override
    public Class<GoldSuccessViewModel> getViewModel() {
        return GoldSuccessViewModel.class;
    }

    public /* synthetic */ void lambda$onCreate$0$GoldSuccessActivity(View view) {
        this.launchHome();
    }

    public /* synthetic */ void lambda$onCreate$1$GoldSuccessActivity(View view) {
        this.launchHome();
    }

    public void onApiError(ErrorResponse errorResponse) {
    }

    @Override
    protected void onCreate(Bundle bundle, GoldSuccessViewModel goldSuccessViewModel, ActivityGoldSuccessBinding activityGoldSuccessBinding) {
        this.binding = activityGoldSuccessBinding;
        this.mViewModel = goldSuccessViewModel;
        goldSuccessViewModel.setNavigator((Object)this);
        this.animateLoader();
        activityGoldSuccessBinding.btnContinue.setOnClickListener(new -$$Lambda$GoldSuccessActivity$b2X_L0h0aSPty__n9__5rAshLEA(this));
        activityGoldSuccessBinding.icClose.setOnClickListener((View.OnClickListener)new -$$Lambda$GoldSuccessActivity$uXFvc5nXZV58wRpdVEwD4wrgV0E(this));
    }
}

