/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.model.animatable.BaseAnimatableValue;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableColorValue
extends BaseAnimatableValue<Integer, Integer> {
    public AnimatableColorValue(List<Keyframe<Integer>> list) {
        super(list);
    }

    @Override
    public BaseKeyframeAnimation<Integer, Integer> createAnimation() {
        return new ColorKeyframeAnimation((List<Keyframe<Integer>>)this.keyframes);
    }
}

