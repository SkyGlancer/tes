/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.PointF
 *  com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation
 *  com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  com.airbnb.lottie.model.animatable.AnimatableIntegerValue
 *  com.airbnb.lottie.model.animatable.AnimatablePathValue
 *  com.airbnb.lottie.model.animatable.AnimatableScaleValue
 *  com.airbnb.lottie.model.animatable.AnimatableTransform
 *  com.airbnb.lottie.model.layer.BaseLayer
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;
import java.util.List;

public class TransformKeyframeAnimation {
    private BaseKeyframeAnimation<PointF, PointF> anchorPoint;
    private BaseKeyframeAnimation<?, Float> endOpacity;
    private final Matrix matrix = new Matrix();
    private BaseKeyframeAnimation<Integer, Integer> opacity;
    private BaseKeyframeAnimation<?, PointF> position;
    private BaseKeyframeAnimation<Float, Float> rotation;
    private BaseKeyframeAnimation<ScaleXY, ScaleXY> scale;
    private FloatKeyframeAnimation skew;
    private FloatKeyframeAnimation skewAngle;
    private final Matrix skewMatrix1;
    private final Matrix skewMatrix2;
    private final Matrix skewMatrix3;
    private final float[] skewValues;
    private BaseKeyframeAnimation<?, Float> startOpacity;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        BaseKeyframeAnimation baseKeyframeAnimation = animatableTransform.getAnchorPoint() == null ? null : animatableTransform.getAnchorPoint().createAnimation();
        this.anchorPoint = baseKeyframeAnimation;
        BaseKeyframeAnimation baseKeyframeAnimation2 = animatableTransform.getPosition() == null ? null : animatableTransform.getPosition().createAnimation();
        this.position = baseKeyframeAnimation2;
        BaseKeyframeAnimation baseKeyframeAnimation3 = animatableTransform.getScale() == null ? null : animatableTransform.getScale().createAnimation();
        this.scale = baseKeyframeAnimation3;
        BaseKeyframeAnimation baseKeyframeAnimation4 = animatableTransform.getRotation() == null ? null : animatableTransform.getRotation().createAnimation();
        this.rotation = baseKeyframeAnimation4;
        FloatKeyframeAnimation floatKeyframeAnimation = animatableTransform.getSkew() == null ? null : (FloatKeyframeAnimation)animatableTransform.getSkew().createAnimation();
        this.skew = floatKeyframeAnimation;
        if (floatKeyframeAnimation != null) {
            this.skewMatrix1 = new Matrix();
            this.skewMatrix2 = new Matrix();
            this.skewMatrix3 = new Matrix();
            this.skewValues = new float[9];
        } else {
            this.skewMatrix1 = null;
            this.skewMatrix2 = null;
            this.skewMatrix3 = null;
            this.skewValues = null;
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = animatableTransform.getSkewAngle() == null ? null : (FloatKeyframeAnimation)animatableTransform.getSkewAngle().createAnimation();
        this.skewAngle = floatKeyframeAnimation2;
        if (animatableTransform.getOpacity() != null) {
            this.opacity = animatableTransform.getOpacity().createAnimation();
        }
        this.startOpacity = animatableTransform.getStartOpacity() != null ? animatableTransform.getStartOpacity().createAnimation() : null;
        if (animatableTransform.getEndOpacity() != null) {
            this.endOpacity = animatableTransform.getEndOpacity().createAnimation();
            return;
        }
        this.endOpacity = null;
    }

    private void clearSkewValues() {
        for (int i = 0; i < 9; ++i) {
            this.skewValues[i] = 0.0f;
        }
    }

    public void addAnimationsToLayer(BaseLayer baseLayer) {
        baseLayer.addAnimation(this.opacity);
        baseLayer.addAnimation(this.startOpacity);
        baseLayer.addAnimation(this.endOpacity);
        baseLayer.addAnimation(this.anchorPoint);
        baseLayer.addAnimation(this.position);
        baseLayer.addAnimation(this.scale);
        baseLayer.addAnimation(this.rotation);
        baseLayer.addAnimation((BaseKeyframeAnimation)this.skew);
        baseLayer.addAnimation((BaseKeyframeAnimation)this.skewAngle);
    }

    public void addListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation;
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3;
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation4;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation6;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation7 = this.opacity;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.addUpdateListener(animationListener);
        }
        if ((baseKeyframeAnimation6 = this.startOpacity) != null) {
            baseKeyframeAnimation6.addUpdateListener(animationListener);
        }
        if ((baseKeyframeAnimation3 = this.endOpacity) != null) {
            baseKeyframeAnimation3.addUpdateListener(animationListener);
        }
        if ((baseKeyframeAnimation = this.anchorPoint) != null) {
            baseKeyframeAnimation.addUpdateListener(animationListener);
        }
        if ((baseKeyframeAnimation2 = this.position) != null) {
            baseKeyframeAnimation2.addUpdateListener(animationListener);
        }
        if ((baseKeyframeAnimation4 = this.scale) != null) {
            baseKeyframeAnimation4.addUpdateListener(animationListener);
        }
        if ((baseKeyframeAnimation5 = this.rotation) != null) {
            baseKeyframeAnimation5.addUpdateListener(animationListener);
        }
        if ((floatKeyframeAnimation2 = this.skew) != null) {
            floatKeyframeAnimation2.addUpdateListener(animationListener);
        }
        if ((floatKeyframeAnimation = this.skewAngle) != null) {
            floatKeyframeAnimation.addUpdateListener(animationListener);
        }
    }

    public <T> boolean applyValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        block28 : {
            block20 : {
                FloatKeyframeAnimation floatKeyframeAnimation;
                block27 : {
                    FloatKeyframeAnimation floatKeyframeAnimation2;
                    block26 : {
                        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
                        block25 : {
                            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
                            block24 : {
                                block23 : {
                                    block22 : {
                                        block21 : {
                                            block19 : {
                                                if (t != LottieProperty.TRANSFORM_ANCHOR_POINT) break block19;
                                                BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation3 = this.anchorPoint;
                                                if (baseKeyframeAnimation3 == null) {
                                                    this.anchorPoint = new ValueCallbackKeyframeAnimation(lottieValueCallback, (Object)new PointF());
                                                } else {
                                                    baseKeyframeAnimation3.setValueCallback(lottieValueCallback);
                                                }
                                                break block20;
                                            }
                                            if (t != LottieProperty.TRANSFORM_POSITION) break block21;
                                            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.position;
                                            if (baseKeyframeAnimation4 == null) {
                                                this.position = new ValueCallbackKeyframeAnimation(lottieValueCallback, (Object)new PointF());
                                            } else {
                                                baseKeyframeAnimation4.setValueCallback(lottieValueCallback);
                                            }
                                            break block20;
                                        }
                                        if (t != LottieProperty.TRANSFORM_SCALE) break block22;
                                        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation5 = this.scale;
                                        if (baseKeyframeAnimation5 == null) {
                                            this.scale = new ValueCallbackKeyframeAnimation(lottieValueCallback, (Object)new ScaleXY());
                                        } else {
                                            baseKeyframeAnimation5.setValueCallback(lottieValueCallback);
                                        }
                                        break block20;
                                    }
                                    if (t != LottieProperty.TRANSFORM_ROTATION) break block23;
                                    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.rotation;
                                    if (baseKeyframeAnimation6 == null) {
                                        this.rotation = new ValueCallbackKeyframeAnimation(lottieValueCallback, (Object)Float.valueOf((float)0.0f));
                                    } else {
                                        baseKeyframeAnimation6.setValueCallback(lottieValueCallback);
                                    }
                                    break block20;
                                }
                                if (t != LottieProperty.TRANSFORM_OPACITY) break block24;
                                BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation7 = this.opacity;
                                if (baseKeyframeAnimation7 == null) {
                                    this.opacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, (Object)100);
                                } else {
                                    baseKeyframeAnimation7.setValueCallback(lottieValueCallback);
                                }
                                break block20;
                            }
                            if (t != LottieProperty.TRANSFORM_START_OPACITY || (baseKeyframeAnimation2 = this.startOpacity) == null) break block25;
                            if (baseKeyframeAnimation2 == null) {
                                this.startOpacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, (Object)100);
                            } else {
                                baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
                            }
                            break block20;
                        }
                        if (t != LottieProperty.TRANSFORM_END_OPACITY || (baseKeyframeAnimation = this.endOpacity) == null) break block26;
                        if (baseKeyframeAnimation == null) {
                            this.endOpacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, (Object)100);
                        } else {
                            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
                        }
                        break block20;
                    }
                    if (t != LottieProperty.TRANSFORM_SKEW || (floatKeyframeAnimation2 = this.skew) == null) break block27;
                    if (floatKeyframeAnimation2 == null) {
                        this.skew = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe<Float>(Float.valueOf((float)0.0f))));
                    }
                    this.skew.setValueCallback(lottieValueCallback);
                    break block20;
                }
                if (t != LottieProperty.TRANSFORM_SKEW_ANGLE || (floatKeyframeAnimation = this.skewAngle) == null) break block28;
                if (floatKeyframeAnimation == null) {
                    this.skewAngle = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe<Float>(Float.valueOf((float)0.0f))));
                }
                this.skewAngle.setValueCallback(lottieValueCallback);
            }
            return true;
        }
        return false;
    }

    public BaseKeyframeAnimation<?, Float> getEndOpacity() {
        return this.endOpacity;
    }

    public Matrix getMatrix() {
        ScaleXY scaleXY;
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation2;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3;
        float f;
        this.matrix.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.position;
        if (baseKeyframeAnimation4 != null) {
            PointF pointF = baseKeyframeAnimation4.getValue();
            if (pointF.x != 0.0f || pointF.y != 0.0f) {
                this.matrix.preTranslate(pointF.x, pointF.y);
            }
        }
        if ((baseKeyframeAnimation3 = this.rotation) != null && (f = baseKeyframeAnimation3 instanceof ValueCallbackKeyframeAnimation ? baseKeyframeAnimation3.getValue().floatValue() : ((FloatKeyframeAnimation)baseKeyframeAnimation3).getFloatValue()) != 0.0f) {
            this.matrix.preRotate(f);
        }
        if (this.skew != null) {
            float f2;
            FloatKeyframeAnimation floatKeyframeAnimation = this.skewAngle;
            float f3 = floatKeyframeAnimation == null ? 0.0f : (float)Math.cos((double)Math.toRadians((double)(90.0f + -floatKeyframeAnimation.getFloatValue())));
            FloatKeyframeAnimation floatKeyframeAnimation2 = this.skewAngle;
            float f4 = floatKeyframeAnimation2 == null ? 1.0f : (float)Math.sin((double)Math.toRadians((double)(90.0f + -floatKeyframeAnimation2.getFloatValue())));
            float f5 = (float)Math.tan((double)Math.toRadians((double)this.skew.getFloatValue()));
            this.clearSkewValues();
            float[] arrf = this.skewValues;
            arrf[0] = f3;
            arrf[1] = f4;
            arrf[3] = f2 = -f4;
            arrf[4] = f3;
            arrf[8] = 1.0f;
            this.skewMatrix1.setValues(arrf);
            this.clearSkewValues();
            float[] arrf2 = this.skewValues;
            arrf2[0] = 1.0f;
            arrf2[3] = f5;
            arrf2[4] = 1.0f;
            arrf2[8] = 1.0f;
            this.skewMatrix2.setValues(arrf2);
            this.clearSkewValues();
            float[] arrf3 = this.skewValues;
            arrf3[0] = f3;
            arrf3[1] = f2;
            arrf3[3] = f4;
            arrf3[4] = f3;
            arrf3[8] = 1.0f;
            this.skewMatrix3.setValues(arrf3);
            this.skewMatrix2.preConcat(this.skewMatrix1);
            this.skewMatrix3.preConcat(this.skewMatrix2);
            this.matrix.preConcat(this.skewMatrix3);
        }
        if ((baseKeyframeAnimation = this.scale) != null && ((scaleXY = baseKeyframeAnimation.getValue()).getScaleX() != 1.0f || scaleXY.getScaleY() != 1.0f)) {
            this.matrix.preScale(scaleXY.getScaleX(), scaleXY.getScaleY());
        }
        if ((baseKeyframeAnimation2 = this.anchorPoint) != null) {
            PointF pointF = baseKeyframeAnimation2.getValue();
            if (pointF.x != 0.0f || pointF.y != 0.0f) {
                this.matrix.preTranslate(-pointF.x, -pointF.y);
            }
        }
        return this.matrix;
    }

    public Matrix getMatrixForRepeater(float f) {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2 = this.position;
        PointF pointF = baseKeyframeAnimation2 == null ? null : baseKeyframeAnimation2.getValue();
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation3 = this.scale;
        ScaleXY scaleXY = baseKeyframeAnimation3 == null ? null : baseKeyframeAnimation3.getValue();
        this.matrix.reset();
        if (pointF != null) {
            this.matrix.preTranslate(f * pointF.x, f * pointF.y);
        }
        if (scaleXY != null) {
            Matrix matrix = this.matrix;
            double d = scaleXY.getScaleX();
            double d2 = f;
            matrix.preScale((float)Math.pow((double)d, (double)d2), (float)Math.pow((double)scaleXY.getScaleY(), (double)d2));
        }
        if ((baseKeyframeAnimation = this.rotation) != null) {
            float f2 = baseKeyframeAnimation.getValue().floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
            PointF pointF2 = baseKeyframeAnimation4 == null ? null : baseKeyframeAnimation4.getValue();
            Matrix matrix = this.matrix;
            float f3 = f2 * f;
            float f4 = pointF2 == null ? 0.0f : pointF2.x;
            float f5 = pointF2 == null ? 0.0f : pointF2.y;
            matrix.preRotate(f3, f4, f5);
        }
        return this.matrix;
    }

    public BaseKeyframeAnimation<?, Integer> getOpacity() {
        return this.opacity;
    }

    public BaseKeyframeAnimation<?, Float> getStartOpacity() {
        return this.startOpacity;
    }

    public void setProgress(float f) {
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation;
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3;
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation4;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation6;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation7 = this.opacity;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.setProgress(f);
        }
        if ((baseKeyframeAnimation6 = this.startOpacity) != null) {
            baseKeyframeAnimation6.setProgress(f);
        }
        if ((baseKeyframeAnimation3 = this.endOpacity) != null) {
            baseKeyframeAnimation3.setProgress(f);
        }
        if ((baseKeyframeAnimation = this.anchorPoint) != null) {
            baseKeyframeAnimation.setProgress(f);
        }
        if ((baseKeyframeAnimation2 = this.position) != null) {
            baseKeyframeAnimation2.setProgress(f);
        }
        if ((baseKeyframeAnimation4 = this.scale) != null) {
            baseKeyframeAnimation4.setProgress(f);
        }
        if ((baseKeyframeAnimation5 = this.rotation) != null) {
            baseKeyframeAnimation5.setProgress(f);
        }
        if ((floatKeyframeAnimation2 = this.skew) != null) {
            floatKeyframeAnimation2.setProgress(f);
        }
        if ((floatKeyframeAnimation = this.skewAngle) != null) {
            floatKeyframeAnimation.setProgress(f);
        }
    }
}

