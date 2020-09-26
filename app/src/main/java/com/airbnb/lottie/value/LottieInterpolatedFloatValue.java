/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 *  java.lang.Float
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieInterpolatedValue;

public class LottieInterpolatedFloatValue
extends LottieInterpolatedValue<Float> {
    public LottieInterpolatedFloatValue(Float f, Float f2) {
        super(f, f2);
    }

    public LottieInterpolatedFloatValue(Float f, Float f2, Interpolator interpolator2) {
        super(f, f2, interpolator2);
    }

    @Override
    Float interpolateValue(Float f, Float f2, float f3) {
        return Float.valueOf((float)MiscUtils.lerp(f.floatValue(), f2.floatValue(), f3));
    }
}

