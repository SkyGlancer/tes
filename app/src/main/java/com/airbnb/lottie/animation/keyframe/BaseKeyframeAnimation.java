/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 *  com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$EmptyKeyframeWrapper
 *  com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapperImpl
 *  com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$SingleKeyframeWrapper
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.keyframe;

import android.view.animation.Interpolator;
import com.airbnb.lottie.L;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public abstract class BaseKeyframeAnimation<K, A> {
    private float cachedEndProgress;
    private A cachedGetValue;
    private float cachedStartDelayProgress;
    private boolean isDiscrete;
    private final KeyframesWrapper<K> keyframesWrapper;
    final List<AnimationListener> listeners;
    protected float progress;
    protected LottieValueCallback<A> valueCallback;

    BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        this.listeners = new ArrayList(1);
        this.isDiscrete = false;
        this.progress = 0.0f;
        this.cachedGetValue = null;
        this.cachedStartDelayProgress = -1.0f;
        this.cachedEndProgress = -1.0f;
        this.keyframesWrapper = BaseKeyframeAnimation.wrap(list);
    }

    private float getStartDelayProgress() {
        if (this.cachedStartDelayProgress == -1.0f) {
            this.cachedStartDelayProgress = this.keyframesWrapper.getStartDelayProgress();
        }
        return this.cachedStartDelayProgress;
    }

    private static <T> KeyframesWrapper<T> wrap(List<? extends Keyframe<T>> list) {
        if (list.isEmpty()) {
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        if (list.size() == 1) {
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public void addUpdateListener(AnimationListener animationListener) {
        this.listeners.add((Object)animationListener);
    }

    protected Keyframe<K> getCurrentKeyframe() {
        L.beginSection("BaseKeyframeAnimation#getCurrentKeyframe");
        Keyframe<K> keyframe = this.keyframesWrapper.getCurrentKeyframe();
        L.endSection("BaseKeyframeAnimation#getCurrentKeyframe");
        return keyframe;
    }

    float getEndProgress() {
        if (this.cachedEndProgress == -1.0f) {
            this.cachedEndProgress = this.keyframesWrapper.getEndProgress();
        }
        return this.cachedEndProgress;
    }

    protected float getInterpolatedCurrentKeyframeProgress() {
        Keyframe<K> keyframe = this.getCurrentKeyframe();
        if (keyframe.isStatic()) {
            return 0.0f;
        }
        return keyframe.interpolator.getInterpolation(this.getLinearCurrentKeyframeProgress());
    }

    float getLinearCurrentKeyframeProgress() {
        if (this.isDiscrete) {
            return 0.0f;
        }
        Keyframe<K> keyframe = this.getCurrentKeyframe();
        if (keyframe.isStatic()) {
            return 0.0f;
        }
        return (this.progress - keyframe.getStartProgress()) / (keyframe.getEndProgress() - keyframe.getStartProgress());
    }

    public float getProgress() {
        return this.progress;
    }

    public A getValue() {
        float f = this.getInterpolatedCurrentKeyframeProgress();
        if (this.valueCallback == null && this.keyframesWrapper.isCachedValueEnabled(f)) {
            return this.cachedGetValue;
        }
        A a = this.getValue(this.getCurrentKeyframe(), f);
        this.cachedGetValue = a;
        return a;
    }

    abstract A getValue(Keyframe<K> var1, float var2);

    public void notifyListeners() {
        for (int i = 0; i < this.listeners.size(); ++i) {
            ((AnimationListener)this.listeners.get(i)).onValueChanged();
        }
    }

    public void setIsDiscrete() {
        this.isDiscrete = true;
    }

    public void setProgress(float f) {
        if (this.keyframesWrapper.isEmpty()) {
            return;
        }
        if (f < this.getStartDelayProgress()) {
            f = this.getStartDelayProgress();
        } else if (f > this.getEndProgress()) {
            f = this.getEndProgress();
        }
        if (f == this.progress) {
            return;
        }
        this.progress = f;
        if (this.keyframesWrapper.isValueChanged(f)) {
            this.notifyListeners();
        }
    }

    public void setValueCallback(LottieValueCallback<A> lottieValueCallback) {
        LottieValueCallback<A> lottieValueCallback2 = this.valueCallback;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation(null);
        }
        this.valueCallback = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }

    public static interface AnimationListener {
        public void onValueChanged();
    }

    private static interface KeyframesWrapper<T> {
        public Keyframe<T> getCurrentKeyframe();

        public float getEndProgress();

        public float getStartDelayProgress();

        public boolean isCachedValueEnabled(float var1);

        public boolean isEmpty();

        public boolean isValueChanged(float var1);
    }

}

