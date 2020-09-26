/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.LinearGradient
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  android.graphics.PointF
 *  android.graphics.RadialGradient
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  androidx.collection.LongSparseArray
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class GradientFillContent
implements DrawingContent,
BaseKeyframeAnimation.AnimationListener,
KeyPathElementContent {
    private static final int CACHE_STEPS_MS = 32;
    private final RectF boundsRect = new RectF();
    private final int cacheSteps;
    private final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
    private ValueCallbackKeyframeAnimation colorCallbackAnimation;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
    private final boolean hidden;
    private final BaseLayer layer;
    private final LongSparseArray<LinearGradient> linearGradientCache = new LongSparseArray();
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
    private final Paint paint = new LPaint(1);
    private final Path path = new Path();
    private final List<PathContent> paths = new ArrayList();
    private final LongSparseArray<RadialGradient> radialGradientCache = new LongSparseArray();
    private final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
    private final GradientType type;

    public GradientFillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientFill gradientFill) {
        this.layer = baseLayer;
        this.name = gradientFill.getName();
        this.hidden = gradientFill.isHidden();
        this.lottieDrawable = lottieDrawable;
        this.type = gradientFill.getGradientType();
        this.path.setFillType(gradientFill.getFillType());
        this.cacheSteps = (int)(lottieDrawable.getComposition().getDuration() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> baseKeyframeAnimation = gradientFill.getGradientColor().createAnimation();
        this.colorAnimation = baseKeyframeAnimation;
        baseKeyframeAnimation.addUpdateListener(this);
        baseLayer.addAnimation(this.colorAnimation);
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = gradientFill.getOpacity().createAnimation();
        this.opacityAnimation = baseKeyframeAnimation2;
        baseKeyframeAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(this.opacityAnimation);
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation3 = gradientFill.getStartPoint().createAnimation();
        this.startPointAnimation = baseKeyframeAnimation3;
        baseKeyframeAnimation3.addUpdateListener(this);
        baseLayer.addAnimation(this.startPointAnimation);
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = gradientFill.getEndPoint().createAnimation();
        this.endPointAnimation = baseKeyframeAnimation4;
        baseKeyframeAnimation4.addUpdateListener(this);
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
        PointF pointF = this.startPointAnimation.getValue();
        PointF pointF2 = this.endPointAnimation.getValue();
        GradientColor gradientColor = this.colorAnimation.getValue();
        int[] arrn = this.applyDynamicColorsIfNeeded(gradientColor.getColors());
        float[] arrf = gradientColor.getPositions();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, arrn, arrf, Shader.TileMode.CLAMP);
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
        PointF pointF = this.startPointAnimation.getValue();
        PointF pointF2 = this.endPointAnimation.getValue();
        GradientColor gradientColor = this.colorAnimation.getValue();
        int[] arrn = this.applyDynamicColorsIfNeeded(gradientColor.getColors());
        float[] arrf = gradientColor.getPositions();
        float f = pointF2.x;
        float f2 = pointF.x;
        float f3 = pointF2.y;
        float f4 = pointF.y;
        float f5 = (float)Math.hypot((double)(f - f2), (double)(f3 - f4));
        float f6 = f5 <= 0.0f ? 0.001f : f5;
        RadialGradient radialGradient2 = new RadialGradient(f2, f4, f6, arrn, arrf, Shader.TileMode.CLAMP);
        this.radialGradientCache.put(l, (Object)radialGradient2);
        return radialGradient2;
    }

    @Override
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
            if (baseKeyframeAnimation != null) {
                this.layer.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation<ColorFilter, T> valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation<ColorFilter, T>(lottieValueCallback);
            this.colorFilterAnimation = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.layer.addAnimation(this.colorFilterAnimation);
            return;
        }
        if (t == LottieProperty.GRADIENT_COLOR) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation;
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = this.colorCallbackAnimation;
            if (valueCallbackKeyframeAnimation2 != null) {
                this.layer.removeAnimation(valueCallbackKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.colorCallbackAnimation = null;
                return;
            }
            this.colorCallbackAnimation = valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.layer.addAnimation(this.colorCallbackAnimation);
        }
    }

    @Override
    public void draw(Canvas canvas, Matrix matrix, int n) {
        if (this.hidden) {
            return;
        }
        L.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i = 0; i < this.paths.size(); ++i) {
            this.path.addPath(((PathContent)this.paths.get(i)).getPath(), matrix);
        }
        this.path.computeBounds(this.boundsRect, false);
        Object object = this.type == GradientType.LINEAR ? this.getLinearGradient() : this.getRadialGradient();
        object.setLocalMatrix(matrix);
        this.paint.setShader((Shader)object);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        int n2 = (int)(255.0f * ((float)n / 255.0f * (float)this.opacityAnimation.getValue().intValue() / 100.0f));
        this.paint.setAlpha(MiscUtils.clamp(n2, 0, 255));
        canvas.drawPath(this.path, this.paint);
        L.endSection("GradientFillContent#draw");
    }

    @Override
    public void getBounds(RectF rectF, Matrix matrix, boolean bl) {
        this.path.reset();
        for (int i = 0; i < this.paths.size(); ++i) {
            this.path.addPath(((PathContent)this.paths.get(i)).getPath(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, 1.0f + rectF.right, 1.0f + rectF.bottom);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override
    public void resolveKeyPath(KeyPath keyPath, int n, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, n, list, keyPath2, this);
    }

    @Override
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list2.size(); ++i) {
            Content content = (Content)list2.get(i);
            if (!(content instanceof PathContent)) continue;
            this.paths.add((Object)((PathContent)content));
        }
    }
}

