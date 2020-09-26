/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  java.lang.Object
 */
package app.dukhaan.ui.onboarding;

import app.dukhaan.ui.onboarding.OnBoardingActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final class -$$Lambda$OnBoardingActivity$ZwgjWDoiFPV6MZoJUAX7pIujdkM
implements OnCompleteListener {
    public final /* synthetic */ OnBoardingActivity f$0;

    public /* synthetic */ -$$Lambda$OnBoardingActivity$ZwgjWDoiFPV6MZoJUAX7pIujdkM(OnBoardingActivity onBoardingActivity) {
        this.f$0 = onBoardingActivity;
    }

    public final void onComplete(Task task) {
        this.f$0.lambda$checkForRemoteConfig$1$OnBoardingActivity(task);
    }
}

