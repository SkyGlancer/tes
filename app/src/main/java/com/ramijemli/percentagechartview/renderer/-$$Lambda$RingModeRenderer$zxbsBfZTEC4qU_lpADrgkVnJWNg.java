/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  com.ramijemli.percentagechartview.renderer.RingModeRenderer
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.ramijemli.percentagechartview.renderer;

import android.animation.ValueAnimator;
import com.ramijemli.percentagechartview.renderer.RingModeRenderer;

public final class -$$Lambda$RingModeRenderer$zxbsBfZTEC4qU_lpADrgkVnJWNg
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ RingModeRenderer f$0;

    public /* synthetic */ -$$Lambda$RingModeRenderer$zxbsBfZTEC4qU_lpADrgkVnJWNg(RingModeRenderer ringModeRenderer) {
        this.f$0 = ringModeRenderer;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.lambda$setupColorAnimations$0$RingModeRenderer(valueAnimator);
    }
}

