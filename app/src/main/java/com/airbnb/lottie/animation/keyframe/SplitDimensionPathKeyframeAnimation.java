/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  java.lang.Float
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;
import java.util.List;

public class SplitDimensionPathKeyframeAnimation
extends BaseKeyframeAnimation<PointF, PointF> {
    private final PointF point = new PointF();
    private final BaseKeyframeAnimation<Float, Float> xAnimation;
    private final BaseKeyframeAnimation<Float, Float> yAnimation;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.xAnimation = baseKeyframeAnimation;
        this.yAnimation = baseKeyframeAnimation2;
        this.setProgress(this.getProgress());
    }

    @Override
    public PointF getValue() {
        return this.getValue(null, 0.0f);
    }

    @Override
    PointF getValue(Keyframe<PointF> keyframe, float f) {
        return this.point;
    }

    @Override
    public void setProgress(float f) {
        this.xAnimation.setProgress(f);
        this.yAnimation.setProgress(f);
        this.point.set(this.xAnimation.getValue().floatValue(), this.yAnimation.getValue().floatValue());
        for (int i = 0; i < this.listeners.size(); ++i) {
            ((BaseKeyframeAnimation.AnimationListener)this.listeners.get(i)).onValueChanged();
        }
    }
}

