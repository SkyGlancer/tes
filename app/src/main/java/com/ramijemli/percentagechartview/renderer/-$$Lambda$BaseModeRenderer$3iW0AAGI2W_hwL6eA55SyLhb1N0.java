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

public final class -$$Lambda$BaseModeRenderer$3iW0AAGI2W_hwL6eA55SyLhb1N0
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BaseModeRenderer f$0;

    public /* synthetic */ -$$Lambda$BaseModeRenderer$3iW0AAGI2W_hwL6eA55SyLhb1N0(BaseModeRenderer baseModeRenderer) {
        this.f$0 = baseModeRenderer;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.lambda$setup$1$BaseModeRenderer(valueAnimator);
    }
}

