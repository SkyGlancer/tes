/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;

abstract class LottieInterpolatedValue<T>
extends LottieValueCallback<T> {
    private final T endValue;
    private final Interpolator interpolator;
    private final T startValue;

    LottieInterpolatedValue(T t, T t2) {
        this(t, t2, (Interpolator)new LinearInterpolator());
    }

    LottieInterpolatedValue(T t, T t2, Interpolator interpolator2) {
        this.startValue = t;
        this.endValue = t2;
        this.interpolator = interpolator2;
    }

    @Override
    public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
        float f = this.interpolator.getInterpolation(lottieFrameInfo.getOverallProgress());
        return this.interpolateValue(this.startValue, this.endValue, f);
    }

    abstract T interpolateValue(T var1, T var2, float var3);
}

