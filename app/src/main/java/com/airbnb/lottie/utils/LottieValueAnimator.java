/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.utils;

import android.view.Choreographer;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.BaseLottieAnimator;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieValueAnimator
extends BaseLottieAnimator
implements Choreographer.FrameCallback {
    private LottieComposition composition;
    private float frame = 0.0f;
    private long lastFrameTimeNs = 0L;
    private float maxFrame = 2.14748365E9f;
    private float minFrame = -2.14748365E9f;
    private int repeatCount = 0;
    protected boolean running = false;
    private float speed = 1.0f;
    private boolean speedReversedForRepeatMode = false;

    private float getFrameDurationNs() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        return 1.0E9f / lottieComposition.getFrameRate() / Math.abs((float)this.speed);
    }

    private boolean isReversed() {
        return this.getSpeed() < 0.0f;
    }

    private void verifyFrame() {
        if (this.composition == null) {
            return;
        }
        float f = this.frame;
        if (!(f < this.minFrame) && !(f > this.maxFrame)) {
            return;
        }
        Object[] arrobject = new Object[]{Float.valueOf((float)this.minFrame), Float.valueOf((float)this.maxFrame), Float.valueOf((float)this.frame)};
        throw new IllegalStateException(String.format((String)"Frame must be [%f,%f]. It is %f", (Object[])arrobject));
    }

    public void cancel() {
        this.notifyCancel();
        this.removeFrameCallback();
    }

    public void clearComposition() {
        this.composition = null;
        this.minFrame = -2.14748365E9f;
        this.maxFrame = 2.14748365E9f;
    }

    public void doFrame(long l) {
        this.postFrameCallback();
        if (this.composition != null) {
            float f;
            if (!this.isRunning()) {
                return;
            }
            L.beginSection("LottieValueAnimator#doFrame");
            long l2 = this.lastFrameTimeNs;
            long l3 = 0L;
            if (l2 != l3) {
                l3 = l - l2;
            }
            float f2 = this.getFrameDurationNs();
            float f3 = (float)l3 / f2;
            float f4 = this.frame;
            if (this.isReversed()) {
                f3 = -f3;
            }
            this.frame = f = f4 + f3;
            boolean bl = true ^ MiscUtils.contains(f, this.getMinFrame(), this.getMaxFrame());
            this.frame = MiscUtils.clamp(this.frame, this.getMinFrame(), this.getMaxFrame());
            this.lastFrameTimeNs = l;
            this.notifyUpdate();
            if (bl) {
                if (this.getRepeatCount() != -1 && this.repeatCount >= this.getRepeatCount()) {
                    float f5 = this.speed < 0.0f ? this.getMinFrame() : this.getMaxFrame();
                    this.frame = f5;
                    this.removeFrameCallback();
                    this.notifyEnd(this.isReversed());
                } else {
                    this.notifyRepeat();
                    this.repeatCount = 1 + this.repeatCount;
                    if (this.getRepeatMode() == 2) {
                        this.speedReversedForRepeatMode = true ^ this.speedReversedForRepeatMode;
                        this.reverseAnimationSpeed();
                    } else {
                        float f6 = this.isReversed() ? this.getMaxFrame() : this.getMinFrame();
                        this.frame = f6;
                    }
                    this.lastFrameTimeNs = l;
                }
            }
            this.verifyFrame();
            L.endSection("LottieValueAnimator#doFrame");
        }
    }

    public void endAnimation() {
        this.removeFrameCallback();
        this.notifyEnd(this.isReversed());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public float getAnimatedFraction() {
        float f;
        float f2;
        float f3;
        if (this.composition == null) {
            return 0.0f;
        }
        if (this.isReversed()) {
            f2 = this.getMaxFrame() - this.frame;
            f3 = this.getMaxFrame();
            f = this.getMinFrame();
            do {
                return f2 / (f3 - f);
                break;
            } while (true);
        }
        f2 = this.frame - this.getMinFrame();
        f3 = this.getMaxFrame();
        f = this.getMinFrame();
        return f2 / (f3 - f);
    }

    public Object getAnimatedValue() {
        return Float.valueOf((float)this.getAnimatedValueAbsolute());
    }

    public float getAnimatedValueAbsolute() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.frame - lottieComposition.getStartFrame()) / (this.composition.getEndFrame() - this.composition.getStartFrame());
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0L;
        }
        return (long)lottieComposition.getDuration();
    }

    public float getFrame() {
        return this.frame;
    }

    public float getMaxFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.maxFrame;
        if (f == 2.14748365E9f) {
            f = lottieComposition.getEndFrame();
        }
        return f;
    }

    public float getMinFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.minFrame;
        if (f == -2.14748365E9f) {
            f = lottieComposition.getStartFrame();
        }
        return f;
    }

    public float getSpeed() {
        return this.speed;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void pauseAnimation() {
        this.removeFrameCallback();
    }

    public void playAnimation() {
        this.running = true;
        this.notifyStart(this.isReversed());
        float f = this.isReversed() ? this.getMaxFrame() : this.getMinFrame();
        this.setFrame((int)f);
        this.lastFrameTimeNs = 0L;
        this.repeatCount = 0;
        this.postFrameCallback();
    }

    protected void postFrameCallback() {
        if (this.isRunning()) {
            this.removeFrameCallback(false);
            Choreographer.getInstance().postFrameCallback((Choreographer.FrameCallback)this);
        }
    }

    protected void removeFrameCallback() {
        this.removeFrameCallback(true);
    }

    protected void removeFrameCallback(boolean bl) {
        Choreographer.getInstance().removeFrameCallback((Choreographer.FrameCallback)this);
        if (bl) {
            this.running = false;
        }
    }

    public void resumeAnimation() {
        this.running = true;
        this.postFrameCallback();
        this.lastFrameTimeNs = 0L;
        if (this.isReversed() && this.getFrame() == this.getMinFrame()) {
            this.frame = this.getMaxFrame();
            return;
        }
        if (!this.isReversed() && this.getFrame() == this.getMaxFrame()) {
            this.frame = this.getMinFrame();
        }
    }

    public void reverseAnimationSpeed() {
        this.setSpeed(-this.getSpeed());
    }

    public void setComposition(LottieComposition lottieComposition) {
        boolean bl = this.composition == null;
        this.composition = lottieComposition;
        if (bl) {
            this.setMinAndMaxFrames((int)Math.max((float)this.minFrame, (float)lottieComposition.getStartFrame()), (int)Math.min((float)this.maxFrame, (float)lottieComposition.getEndFrame()));
        } else {
            this.setMinAndMaxFrames((int)lottieComposition.getStartFrame(), (int)lottieComposition.getEndFrame());
        }
        float f = this.frame;
        this.frame = 0.0f;
        this.setFrame((int)f);
        this.notifyUpdate();
    }

    public void setFrame(float f) {
        if (this.frame == f) {
            return;
        }
        this.frame = MiscUtils.clamp(f, this.getMinFrame(), this.getMaxFrame());
        this.lastFrameTimeNs = 0L;
        this.notifyUpdate();
    }

    public void setMaxFrame(float f) {
        this.setMinAndMaxFrames(this.minFrame, f);
    }

    public void setMinAndMaxFrames(float f, float f2) {
        if (!(f > f2)) {
            LottieComposition lottieComposition = this.composition;
            float f3 = lottieComposition == null ? -3.4028235E38f : lottieComposition.getStartFrame();
            LottieComposition lottieComposition2 = this.composition;
            float f4 = lottieComposition2 == null ? Float.MAX_VALUE : lottieComposition2.getEndFrame();
            this.minFrame = MiscUtils.clamp(f, f3, f4);
            this.maxFrame = MiscUtils.clamp(f2, f3, f4);
            this.setFrame((int)MiscUtils.clamp(this.frame, f, f2));
            return;
        }
        Object[] arrobject = new Object[]{Float.valueOf((float)f), Float.valueOf((float)f2)};
        throw new IllegalArgumentException(String.format((String)"minFrame (%s) must be <= maxFrame (%s)", (Object[])arrobject));
    }

    public void setMinFrame(int n) {
        this.setMinAndMaxFrames(n, (int)this.maxFrame);
    }

    public void setRepeatMode(int n) {
        super.setRepeatMode(n);
        if (n != 2 && this.speedReversedForRepeatMode) {
            this.speedReversedForRepeatMode = false;
            this.reverseAnimationSpeed();
        }
    }

    public void setSpeed(float f) {
        this.speed = f;
    }
}

