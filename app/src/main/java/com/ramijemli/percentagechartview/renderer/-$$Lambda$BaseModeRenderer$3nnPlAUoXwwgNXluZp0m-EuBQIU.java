/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.ramijemli.percentagechartview.renderer;

import android.animation.ValueAnimator;
import com.ramijemli.percentagechartview.renderer.BaseModeRenderer;

public final class -$$Lambda$BaseModeRenderer$3nnPlAUoXwwgNXluZp0m-EuBQIU
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BaseModeRenderer f$0;

    public /* synthetic */ -$$Lambda$BaseModeRenderer$3nnPlAUoXwwgNXluZp0m-EuBQIU(BaseModeRenderer baseModeRenderer) {
        this.f$0 = baseModeRenderer;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.lambda$setupColorAnimations$3$BaseModeRenderer(valueAnimator);
    }
}

