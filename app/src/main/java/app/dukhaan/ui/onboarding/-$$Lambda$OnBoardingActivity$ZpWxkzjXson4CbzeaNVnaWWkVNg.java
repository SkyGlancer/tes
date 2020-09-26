/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnFailureListener
 *  java.lang.Exception
 *  java.lang.Object
 */
package app.dukhaan.ui.onboarding;

import app.dukhaan.ui.onboarding.OnBoardingActivity;
import com.google.android.gms.tasks.OnFailureListener;

public final class -$$Lambda$OnBoardingActivity$ZpWxkzjXson4CbzeaNVnaWWkVNg
implements OnFailureListener {
    public final /* synthetic */ OnBoardingActivity f$0;

    public /* synthetic */ -$$Lambda$OnBoardingActivity$ZpWxkzjXson4CbzeaNVnaWWkVNg(OnBoardingActivity onBoardingActivity) {
        this.f$0 = onBoardingActivity;
    }

    public final void onFailure(Exception exception) {
        this.f$0.lambda$checkForRemoteConfig$2$OnBoardingActivity(exception);
    }
}

