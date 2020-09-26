/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;

public class LottieRelativeIntegerValueCallback
extends LottieValueCallback<Integer> {
    public Integer getOffset(LottieFrameInfo<Integer> lottieFrameInfo) {
        if (this.value != null) {
            return (Integer)this.value;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    @Override
    public Integer getValue(LottieFrameInfo<Integer> lottieFrameInfo) {
        return MiscUtils.lerp(lottieFrameInfo.getStartValue(), lottieFrameInfo.getEndValue(), lottieFrameInfo.getInterpolatedKeyframeProgress()) + this.getOffset(lottieFrameInfo);
    }
}

