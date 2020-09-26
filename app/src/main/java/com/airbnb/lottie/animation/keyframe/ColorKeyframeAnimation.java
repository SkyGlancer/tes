/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.animation.keyframe.KeyframeAnimation;
import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class ColorKeyframeAnimation
extends KeyframeAnimation<Integer> {
    public ColorKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    public int getIntValue() {
        return this.getIntValue(this.getCurrentKeyframe(), this.getInterpolatedCurrentKeyframeProgress());
    }

    public int getIntValue(Keyframe<Integer> keyframe, float f) {
        if (keyframe.startValue != null && keyframe.endValue != null) {
            Integer n;
            int n2 = (Integer)keyframe.startValue;
            int n3 = (Integer)keyframe.endValue;
            if (this.valueCallback != null && (n = this.valueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), n2, n3, f, this.getLinearCurrentKeyframeProgress(), this.getProgress())) != null) {
                return n;
            }
            return GammaEvaluator.evaluate(MiscUtils.clamp(f, 0.0f, 1.0f), n2, n3);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override
    Integer getValue(Keyframe<Integer> keyframe, float f) {
        return this.getIntValue(keyframe, f);
    }
}

