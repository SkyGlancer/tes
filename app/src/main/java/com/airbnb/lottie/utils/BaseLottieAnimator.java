/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.Set
 *  java.util.concurrent.CopyOnWriteArraySet
 */
package app.dukhaan.src.java.com.airbnb.lottie.utils;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class BaseLottieAnimator
extends ValueAnimator {
    private final Set<AnimatorListener> listeners = new CopyOnWriteArraySet();
    private final Set<AnimatorUpdateListener> updateListeners = new CopyOnWriteArraySet();

    public void addListener(AnimatorListener animatorListener) {
        this.listeners.add((Object)animatorListener);
    }

    public void addUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        this.updateListeners.add((Object)animatorUpdateListener);
    }

    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    void notifyCancel() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((AnimatorListener)iterator.next()).onAnimationCancel((Animator)this);
        }
    }

    void notifyEnd(boolean bl) {
        for (AnimatorListener animatorListener : this.listeners) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd((Animator)this, bl);
                continue;
            }
            animatorListener.onAnimationEnd((Animator)this);
        }
    }

    void notifyRepeat() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((AnimatorListener)iterator.next()).onAnimationRepeat((Animator)this);
        }
    }

    void notifyStart(boolean bl) {
        for (AnimatorListener animatorListener : this.listeners) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart((Animator)this, bl);
                continue;
            }
            animatorListener.onAnimationStart((Animator)this);
        }
    }

    void notifyUpdate() {
        Iterator iterator = this.updateListeners.iterator();
        while (iterator.hasNext()) {
            ((AnimatorUpdateListener)iterator.next()).onAnimationUpdate((ValueAnimator)this);
        }
    }

    public void removeAllListeners() {
        this.listeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.updateListeners.clear();
    }

    public void removeListener(AnimatorListener animatorListener) {
        this.listeners.remove((Object)animatorListener);
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        this.updateListeners.remove((Object)animatorUpdateListener);
    }

    public ValueAnimator setDuration(long l) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    public void setStartDelay(long l) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }
}

