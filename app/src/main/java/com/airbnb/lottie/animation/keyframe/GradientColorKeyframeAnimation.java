/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.animation.keyframe.KeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class GradientColorKeyframeAnimation
extends KeyframeAnimation<GradientColor> {
    private final GradientColor gradientColor;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        GradientColor gradientColor = (GradientColor)((Keyframe)list.get((int)0)).startValue;
        int n = gradientColor == null ? 0 : gradientColor.getSize();
        this.gradientColor = new GradientColor(new float[n], new int[n]);
    }

    @Override
    GradientColor getValue(Keyframe<GradientColor> keyframe, float f) {
        this.gradientColor.lerp((GradientColor)keyframe.startValue, (GradientColor)keyframe.endValue, f);
        return this.gradientColor;
    }
}

