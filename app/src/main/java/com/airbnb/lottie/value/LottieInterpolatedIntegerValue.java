/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 *  java.lang.Integer
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieInterpolatedValue;

public class LottieInterpolatedIntegerValue
extends LottieInterpolatedValue<Integer> {
    public LottieInterpolatedIntegerValue(Integer n, Integer n2) {
        super(n, n2);
    }

    public LottieInterpolatedIntegerValue(Integer n, Integer n2, Interpolator interpolator2) {
        super(n, n2, interpolator2);
    }

    @Override
    Integer interpolateValue(Integer n, Integer n2, float f) {
        return MiscUtils.lerp(n, n2, f);
    }
}

