/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.view.animation.Interpolator
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.src.java.com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;

public class Keyframe<T> {
    private static final float UNSET_FLOAT = -3987645.8f;
    private static final int UNSET_INT = 784923401;
    private final LottieComposition composition;
    public Float endFrame;
    private float endProgress = Float.MIN_VALUE;
    public T endValue;
    private float endValueFloat = -3987645.8f;
    private int endValueInt = 784923401;
    public final Interpolator interpolator;
    public PointF pathCp1 = null;
    public PointF pathCp2 = null;
    public final float startFrame;
    private float startProgress = Float.MIN_VALUE;
    public final T startValue;
    private float startValueFloat = -3987645.8f;
    private int startValueInt = 784923401;

    public Keyframe(LottieComposition lottieComposition, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.composition = lottieComposition;
        this.startValue = t;
        this.endValue = t2;
        this.interpolator = interpolator;
        this.startFrame = f;
        this.endFrame = f2;
    }

    public Keyframe(T t) {
        this.composition = null;
        this.startValue = t;
        this.endValue = t;
        this.interpolator = null;
        this.startFrame = Float.MIN_VALUE;
        this.endFrame = Float.valueOf((float)Float.MAX_VALUE);
    }

    public boolean containsProgress(float f) {
        return f >= this.getStartProgress() && f < this.getEndProgress();
    }

    public float getEndProgress() {
        if (this.composition == null) {
            return 1.0f;
        }
        if (this.endProgress == Float.MIN_VALUE) {
            this.endProgress = this.endFrame == null ? 1.0f : this.getStartProgress() + (this.endFrame.floatValue() - this.startFrame) / this.composition.getDurationFrames();
        }
        return this.endProgress;
    }

    public float getEndValueFloat() {
        if (this.endValueFloat == -3987645.8f) {
            this.endValueFloat = ((Float)this.endValue).floatValue();
        }
        return this.endValueFloat;
    }

    public int getEndValueInt() {
        if (this.endValueInt == 784923401) {
            this.endValueInt = (Integer)this.endValue;
        }
        return this.endValueInt;
    }

    public float getStartProgress() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        if (this.startProgress == Float.MIN_VALUE) {
            this.startProgress = (this.startFrame - lottieComposition.getStartFrame()) / this.composition.getDurationFrames();
        }
        return this.startProgress;
    }

    public float getStartValueFloat() {
        if (this.startValueFloat == -3987645.8f) {
            this.startValueFloat = ((Float)this.startValue).floatValue();
        }
        return this.startValueFloat;
    }

    public int getStartValueInt() {
        if (this.startValueInt == 784923401) {
            this.startValueInt = (Integer)this.startValue;
        }
        return this.startValueInt;
    }

    public boolean isStatic() {
        return this.interpolator == null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Keyframe{startValue=");
        stringBuilder.append(this.startValue);
        stringBuilder.append(", endValue=");
        stringBuilder.append(this.endValue);
        stringBuilder.append(", startFrame=");
        stringBuilder.append(this.startFrame);
        stringBuilder.append(", endFrame=");
        stringBuilder.append((Object)this.endFrame);
        stringBuilder.append(", interpolator=");
        stringBuilder.append((Object)this.interpolator);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

