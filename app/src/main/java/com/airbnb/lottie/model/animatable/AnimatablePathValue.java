/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;
import java.util.List;

public class AnimatablePathValue
implements AnimatableValue<PointF, PointF> {
    private final List<Keyframe<PointF>> keyframes;

    public AnimatablePathValue() {
        this.keyframes = Collections.singletonList(new Keyframe<PointF>(new PointF(0.0f, 0.0f)));
    }

    public AnimatablePathValue(List<Keyframe<PointF>> list) {
        this.keyframes = list;
    }

    @Override
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        if (((Keyframe)this.keyframes.get(0)).isStatic()) {
            return new PointKeyframeAnimation(this.keyframes);
        }
        return new PathKeyframeAnimation(this.keyframes);
    }

    @Override
    public List<Keyframe<PointF>> getKeyframes() {
        return this.keyframes;
    }

    @Override
    public boolean isStatic() {
        int n = this.keyframes.size();
        boolean bl = false;
        if (n == 1) {
            boolean bl2 = ((Keyframe)this.keyframes.get(0)).isStatic();
            bl = false;
            if (bl2) {
                bl = true;
            }
        }
        return bl;
    }
}

