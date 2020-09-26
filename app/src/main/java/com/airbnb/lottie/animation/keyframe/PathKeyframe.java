/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.view.animation.Interpolator
 *  java.lang.Float
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

public class PathKeyframe
extends Keyframe<PointF> {
    private Path path;
    private final Keyframe<PointF> pointKeyFrame;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.startValue, keyframe.endValue, keyframe.interpolator, keyframe.startFrame, keyframe.endFrame);
        this.pointKeyFrame = keyframe;
        this.createPath();
    }

    public void createPath() {
        boolean bl = this.endValue != null && this.startValue != null && ((PointF)this.startValue).equals(((PointF)this.endValue).x, ((PointF)this.endValue).y);
        if (this.endValue != null && !bl) {
            this.path = Utils.createPath((PointF)this.startValue, (PointF)this.endValue, this.pointKeyFrame.pathCp1, this.pointKeyFrame.pathCp2);
        }
    }

    Path getPath() {
        return this.path;
    }
}

