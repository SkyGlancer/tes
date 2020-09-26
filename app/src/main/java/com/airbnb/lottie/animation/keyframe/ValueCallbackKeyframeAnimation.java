/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;
import java.util.List;

public class ValueCallbackKeyframeAnimation<K, A>
extends BaseKeyframeAnimation<K, A> {
    private final LottieFrameInfo<A> frameInfo = new LottieFrameInfo();
    private final A valueCallbackValue;

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback) {
        this(lottieValueCallback, null);
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback, A a) {
        super(Collections.emptyList());
        this.setValueCallback(lottieValueCallback);
        this.valueCallbackValue = a;
    }

    @Override
    float getEndProgress() {
        return 1.0f;
    }

    @Override
    public A getValue() {
        LottieValueCallback lottieValueCallback = this.valueCallback;
        A a = this.valueCallbackValue;
        return lottieValueCallback.getValueInternal(0.0f, 0.0f, a, a, this.getProgress(), this.getProgress(), this.getProgress());
    }

    @Override
    A getValue(Keyframe<K> keyframe, float f) {
        return this.getValue();
    }

    @Override
    public void notifyListeners() {
        if (this.valueCallback != null) {
            super.notifyListeners();
        }
    }

    @Override
    public void setProgress(float f) {
        this.progress = f;
    }
}

