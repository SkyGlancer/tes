/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.LinearGradient
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  android.graphics.PointF
 *  android.graphics.RadialGradient
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  androidx.collection.LongSparseArray
 *  com.airbnb.lottie.animation.content.BaseStrokeContent
 *  com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
 *  com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener
 *  com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  com.airbnb.lottie.model.animatable.AnimatableGradientColorValue
 *  com.airbnb.lottie.model.animatable.AnimatableIntegerValue
 *  com.airbnb.lottie.model.animatable.AnimatablePointValue
 *  com.airbnb.lottie.model.content.GradientColor
 *  com.airbnb.lottie.model.content.GradientStroke
 *  com.airbnb.lottie.model.content.GradientType
 *  com.airbnb.lottie.model.content.ShapeStroke
 *  com.airbnb.lottie.model.content.ShapeStroke$LineCapType
 *  com.airbnb.lottie.model.content.ShapeStroke$LineJoinType
 *  com.airbnb.lottie.model.layer.BaseLayer
 *  com.airbnb.lottie.value.LottieValueCallback
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.BaseStrokeContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class GradientStrokeContent
extends BaseStrokeContent {
    private static final int CACHE_STEPS_MS = 32;
    private final RectF boundsRect = new RectF();
    private final int cacheSteps;
    private final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
    private ValueCallbackKeyframeAnimation colorCallbackAnimation;
    private final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
    private final boolean hidden;
    private final LongSparseArray<LinearGradient> linearGradientCache = new LongSparseArray();
    private final String name;
    private final LongSparseArray<RadialGradient> radialGradientCache = new LongSparseArray();
    private final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
    private final GradientType type;

    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientStroke gradientStroke) {
        BaseKeyframeAnimation baseKeyframeAnimation;
        BaseKeyframeAnimation baseKeyframeAnimation2;
        BaseKeyframeAnimation baseKeyframeAnimation3;
        super(lottieDrawable, baseLayer, gradientStroke.getCapType().toPaintCap(), gradientStroke.getJoinType().toPaintJoin(), gradientStroke.getMiterLimit(), gradientStroke.getOpacity(), gradientStroke.getWidth(), gradientStroke.getLineDashPattern(), gradientStroke.getDashOffset());
        this.name = gradientStroke.getName();
        this.type = gradientStroke.getGradientType();
        this.hidden = gradientStroke.isHidden();
        this.cacheSteps = (int)(lottieDrawable.getComposition().getDuration() / 32.0f);
        this.colorAnimation = baseKeyframeAnimation2 = gradientStroke.getGradientColor().createAnimation();
        baseKeyframeAnimation2.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
        baseLayer.addAnimation(this.colorAnimation);
        this.startPointAnimation = baseKeyframeAnimation = gradientStroke.getStartPoint().createAnimation();
        baseKeyframeAnimation.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
        baseLayer.addAnimation(this.startPointAnimation);
        this.endPointAnimation = baseKeyframeAnimation3 = gradientStroke.getEndPoint().createAnimation();
        baseKeyframeAnimation3.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
        baseLayer.addAnimation(this.endPointAnimation);
    }

    private int[] applyDynamicColorsIfNeeded(int[] arrn) {
        block4 : {
            int n;
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.colorCallbackAnimation;
            if (valueCallbackKeyframeAnimation == null) break block4;
            Integer[] arrinteger = (Integer[])valueCallbackKeyframeAnimation.getValue();
            int n2 = arrn.length;
            int n3 = arrinteger.length;
            if (n2 == n3) {
                for (n = 0; n < arrn.length; ++n) {
                    arrn[n] = arrinteger[n];
                }
            } else {
                arrn = new int[arrinteger.length];
                while (n < arrinteger.length) {
                    arrn[n] = arrinteger[n];
                    ++n;
                }
            }
        }
        return arrn;
    }

    private int getGradientHash() {
        int n = Math.round((float)(this.startPointAnimation.getProgress() * (float)this.cacheSteps));
        int n2 = Math.round((float)(this.endPointAnimation.getProgress() * (float)this.cacheSteps));
        int n3 = Math.round((float)(this.colorAnimation.getProgress() * (float)this.cacheSteps));
        int n4 = n != 0 ? 527 * n : 17;
        if (n2 != 0) {
            n4 = n2 * (n4 * 31);
        }
        if (n3 != 0) {
            n4 = n3 * (n4 * 31);
        }
        return n4;
    }

    private LinearGradient getLinearGradient() {
        LongSparseArray<LinearGradient> longSparseArray = this.linearGradientCache;
        int n = this.getGradientHash();
        long l = n;
        LinearGradient linearGradient = (LinearGradient)longSparseArray.get(l);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF)this.startPointAnimation.getValue();
        PointF pointF2 = (PointF)this.endPointAnimation.getValue();
        GradientColor gradientColor = (GradientColor)this.colorAnimation.getValue();
        int[] arrn = this.applyDynamicColorsIfNeeded(gradientColor.getColors());
        float[] arrf = gradientColor.getPositions();
        float f = pointF.x;
        float f2 = pointF.y;
        float f3 = pointF2.x;
        float f4 = pointF2.y;
        LinearGradient linearGradient2 = new LinearGradient(f, f2, f3, f4, arrn, arrf, Shader.TileMode.CLAMP);
        this.linearGradientCache.put(l, (Object)linearGradient2);
        return linearGradient2;
    }

    private RadialGradient getRadialGradient() {
        LongSparseArray<RadialGradient> longSparseArray = this.radialGradientCache;
        int n = this.getGradientHash();
        long l = n;
        RadialGradient radialGradient = (RadialGradient)longSparseArray.get(l);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF)this.startPointAnimation.getValue();
        PointF pointF2 = (PointF)this.endPointAnimation.getValue();
        GradientColor gradientColor = (GradientColor)this.colorAnimation.getValue();
        int[] arrn = this.applyDynamicColorsIfNeeded(gradientColor.getColors());
        float[] arrf = gradientColor.getPositions();
        float f = pointF.x;
        float f2 = pointF.y;
        float f3 = pointF2.x;
        float f4 = pointF2.y;
        float f5 = (float)Math.hypot((double)(f3 - f), (double)(f4 - f2));
        RadialGradient radialGradient2 = new RadialGradient(f, f2, f5, arrn, arrf, Shader.TileMode.CLAMP);
        this.radialGradientCache.put(l, (Object)radialGradient2);
        return radialGradient2;
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.GRADIENT_COLOR) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation;
            if (this.colorCallbackAnimation != null) {
                this.layer.removeAnimation((BaseKeyframeAnimation)this.colorCallbackAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorCallbackAnimation = null;
                return;
            }
            this.colorCallbackAnimation = valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            valueCallbackKeyframeAnimation.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
            this.layer.addAnimation((BaseKeyframeAnimation)this.colorCallbackAnimation);
        }
    }

    public void draw(Canvas canvas, Matrix matrix, int n) {
        if (this.hidden) {
            return;
        }
        this.getBounds(this.boundsRect, matrix, false);
        Object object = this.type == GradientType.LINEAR ? this.getLinearGradient() : this.getRadialGradient();
        object.setLocalMatrix(matrix);
        this.paint.setShader((Shader)object);
        super.draw(canvas, matrix, n);
    }

    public String getName() {
        return this.name;
    }
}

