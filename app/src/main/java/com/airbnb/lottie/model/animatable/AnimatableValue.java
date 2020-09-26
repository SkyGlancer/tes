/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public interface AnimatableValue<K, A> {
    public BaseKeyframeAnimation<K, A> createAnimation();

    public List<Keyframe<K>> getKeyframes();

    public boolean isStatic();
}

