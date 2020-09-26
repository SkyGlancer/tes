/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.animation.keyframe.KeyframeAnimation;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class FloatKeyframeAnimation
extends KeyframeAnimation<Float> {
    public FloatKeyframeAnimation(List<Keyframe<Float>> list) {
        super(list);
    }

    public float getFloatValue() {
        return this.getFloatValue(this.getCurrentKeyframe(), this.getInterpolatedCurrentKeyframeProgress());
    }

    float getFloatValue(Keyframe<Float> keyframe, float f) {
        if (keyframe.startValue != null && keyframe.endValue != null) {
            Float f2;
            if (this.valueCallback != null && (f2 = (Float)this.valueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), keyframe.startValue, keyframe.endValue, f, this.getLinearCurrentKeyframeProgress(), this.getProgress())) != null) {
                return f2.floatValue();
            }
            return MiscUtils.lerp(keyframe.getStartValueFloat(), keyframe.getEndValueFloat(), f);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override
    Float getValue(Keyframe<Float> keyframe, float f) {
        return Float.valueOf((float)this.getFloatValue(keyframe, f));
    }
}

