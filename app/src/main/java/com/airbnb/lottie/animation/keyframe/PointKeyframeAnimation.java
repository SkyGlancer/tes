/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  java.lang.Float
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.KeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PointKeyframeAnimation
extends KeyframeAnimation<PointF> {
    private final PointF point = new PointF();

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
    }

    @Override
    public PointF getValue(Keyframe<PointF> keyframe, float f) {
        if (keyframe.startValue != null && keyframe.endValue != null) {
            PointF pointF;
            PointF pointF2 = (PointF)keyframe.startValue;
            PointF pointF3 = (PointF)keyframe.endValue;
            if (this.valueCallback != null && (pointF = this.valueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), pointF2, pointF3, f, this.getLinearCurrentKeyframeProgress(), this.getProgress())) != null) {
                return pointF;
            }
            this.point.set(pointF2.x + f * (pointF3.x - pointF2.x), pointF2.y + f * (pointF3.y - pointF2.y));
            return this.point;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}

