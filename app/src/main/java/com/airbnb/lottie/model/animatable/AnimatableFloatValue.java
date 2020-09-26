/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.animatable.BaseAnimatableValue;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableFloatValue
extends BaseAnimatableValue<Float, Float> {
    AnimatableFloatValue() {
        super(Float.valueOf((float)0.0f));
    }

    public AnimatableFloatValue(List<Keyframe<Float>> list) {
        super(list);
    }

    @Override
    public BaseKeyframeAnimation<Float, Float> createAnimation() {
        return new FloatKeyframeAnimation((List<Keyframe<Float>>)this.keyframes);
    }
}

