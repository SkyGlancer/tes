/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.DashPathEffect
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PathEffect
 *  android.graphics.PathMeasure
 *  android.graphics.RectF
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.BaseStrokeContent;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseStrokeContent
implements BaseKeyframeAnimation.AnimationListener,
KeyPathElementContent,
DrawingContent {
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final List<BaseKeyframeAnimation<?, Float>> dashPatternAnimations;
    private final BaseKeyframeAnimation<?, Float> dashPatternOffsetAnimation;
    private final float[] dashPatternValues;
    protected final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final BaseKeyframeAnimation<?, Integer> opacityAnimation;
    final Paint paint;
    private final Path path = new Path();
    private final List<PathGroup> pathGroups = new ArrayList();
    private final PathMeasure pm = new PathMeasure();
    private final RectF rect = new RectF();
    private final Path trimPathPath = new Path();
    private final BaseKeyframeAnimation<?, Float> widthAnimation;

    BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.paint = lPaint;
        this.lottieDrawable = lottieDrawable;
        this.layer = baseLayer;
        lPaint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.opacityAnimation = animatableIntegerValue.createAnimation();
        this.widthAnimation = animatableFloatValue.createAnimation();
        this.dashPatternOffsetAnimation = animatableFloatValue2 == null ? null : animatableFloatValue2.createAnimation();
        this.dashPatternAnimations = new ArrayList(list.size());
        this.dashPatternValues = new float[list.size()];
        int n = 0;
        for (int i = 0; i < list.size(); ++i) {
            this.dashPatternAnimations.add(((AnimatableFloatValue)list.get(i)).createAnimation());
        }
        baseLayer.addAnimation(this.opacityAnimation);
        baseLayer.addAnimation(this.widthAnimation);
        for (int i = 0; i < this.dashPatternAnimations.size(); ++i) {
            baseLayer.addAnimation((BaseKeyframeAnimation)this.dashPatternAnimations.get(i));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation != null) {
            baseLayer.addAnimation(baseKeyframeAnimation);
        }
        this.opacityAnimation.addUpdateListener(this);
        this.widthAnimation.addUpdateListener(this);
        while (n < list.size()) {
            ((BaseKeyframeAnimation)this.dashPatternAnimations.get(n)).addUpdateListener(this);
            ++n;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(this);
        }
    }

    private void applyDashPatternIfNeeded(Matrix matrix) {
        L.beginSection("StrokeContent#applyDashPattern");
        if (this.dashPatternAnimations.isEmpty()) {
            L.endSection("StrokeContent#applyDashPattern");
            return;
        }
        float f = Utils.getScale(matrix);
        for (int i = 0; i < this.dashPatternAnimations.size(); ++i) {
            this.dashPatternValues[i] = ((Float)((BaseKeyframeAnimation)this.dashPatternAnimations.get(i)).getValue()).floatValue();
            if (i % 2 == 0) {
                float[] arrf = this.dashPatternValues;
                if (arrf[i] < 1.0f) {
                    arrf[i] = 1.0f;
                }
            } else {
                float[] arrf = this.dashPatternValues;
                if (arrf[i] < 0.1f) {
                    arrf[i] = 0.1f;
                }
            }
            float[] arrf = this.dashPatternValues;
            arrf[i] = f * arrf[i];
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.dashPatternOffsetAnimation;
        float f2 = baseKeyframeAnimation == null ? 0.0f : f * baseKeyframeAnimation.getValue().floatValue();
        this.paint.setPathEffect((PathEffect)new DashPathEffect(this.dashPatternValues, f2));
        L.endSection("StrokeContent#applyDashPattern");
    }

    private void applyTrimPath(Canvas canvas, PathGroup pathGroup, Matrix matrix) {
        L.beginSection("StrokeContent#applyTrimPath");
        if (pathGroup.trimPath == null) {
            L.endSection("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int i = -1 + PathGroup.access$100(pathGroup).size(); i >= 0; --i) {
            this.path.addPath(((PathContent)pathGroup.paths.get(i)).getPath(), matrix);
        }
        this.pm.setPath(this.path, false);
        float f = this.pm.getLength();
        while (this.pm.nextContour()) {
            f += this.pm.getLength();
        }
        float f2 = f * pathGroup.trimPath.getOffset().getValue().floatValue() / 360.0f;
        float f3 = f2 + f * pathGroup.trimPath.getStart().getValue().floatValue() / 100.0f;
        float f4 = f2 + f * pathGroup.trimPath.getEnd().getValue().floatValue() / 100.0f;
        float f5 = 0.0f;
        for (int i = -1 + PathGroup.access$100(pathGroup).size(); i >= 0; --i) {
            float f6;
            this.trimPathPath.set(((PathContent)pathGroup.paths.get(i)).getPath());
            this.trimPathPath.transform(matrix);
            this.pm.setPath(this.trimPathPath, false);
            float f7 = this.pm.getLength();
            float f8 = 1.0f;
            if (f4 > f && (f6 = f4 - f) < f5 + f7 && f5 < f6) {
                float f9 = f3 > f ? (f3 - f) / f7 : 0.0f;
                float f10 = Math.min((float)(f6 / f7), (float)f8);
                Utils.applyTrimPathIfNeeded(this.trimPathPath, f9, f10, 0.0f);
                canvas.drawPath(this.trimPathPath, this.paint);
            } else {
                float f11 = f5 + f7;
                if (!(f11 < f3) && !(f5 > f4)) {
                    if (f11 <= f4 && f3 < f5) {
                        canvas.drawPath(this.trimPathPath, this.paint);
                    } else {
                        float f12 = f3 < f5 ? 0.0f : (f3 - f5) / f7;
                        if (!(f4 > f11)) {
                            f8 = (f4 - f5) / f7;
                        }
                        Utils.applyTrimPathIfNeeded(this.trimPathPath, f12, f8, 0.0f);
                        canvas.drawPath(this.trimPathPath, this.paint);
                    }
                }
            }
            f5 += f7;
        }
        L.endSection("StrokeContent#applyTrimPath");
    }

    @Override
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.STROKE_WIDTH) {
            this.widthAnimation.setValueCallback(lottieValueCallback);
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
        }
    }

    @Override
    public void draw(Canvas canvas, Matrix matrix, int n) {
        L.beginSection("StrokeContent#draw");
        if (Utils.hasZeroScaleAxis(matrix)) {
            L.endSection("StrokeContent#draw");
            return;
        }
        int n2 = (int)(255.0f * ((float)n / 255.0f * (float)((IntegerKeyframeAnimation)this.opacityAnimation).getIntValue() / 100.0f));
        this.paint.setAlpha(MiscUtils.clamp(n2, 0, 255));
        this.paint.setStrokeWidth(((FloatKeyframeAnimation)this.widthAnimation).getFloatValue() * Utils.getScale(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            L.endSection("StrokeContent#draw");
            return;
        }
        this.applyDashPatternIfNeeded(matrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        int n3 = 0;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        while (n3 < this.pathGroups.size()) {
            PathGroup pathGroup = this.pathGroups.get(n3);
            if (pathGroup.trimPath != null) {
                this.applyTrimPath(canvas, pathGroup, matrix);
            } else {
                L.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int i = -1 + PathGroup.access$100(pathGroup).size(); i >= 0; --i) {
                    this.path.addPath(((PathContent)pathGroup.paths.get(i)).getPath(), matrix);
                }
                L.endSection("StrokeContent#buildPath");
                L.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                L.endSection("StrokeContent#drawPath");
            }
            ++n3;
        }
        L.endSection("StrokeContent#draw");
    }

    @Override
    public void getBounds(RectF rectF, Matrix matrix, boolean bl) {
        L.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.pathGroups.size(); ++i) {
            PathGroup pathGroup = this.pathGroups.get(i);
            for (int j = 0; j < pathGroup.paths.size(); ++j) {
                this.path.addPath(((PathContent)pathGroup.paths.get(j)).getPath(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float f = ((FloatKeyframeAnimation)this.widthAnimation).getFloatValue();
        RectF rectF2 = this.rect;
        float f2 = rectF2.left;
        float f3 = f / 2.0f;
        rectF2.set(f2 - f3, this.rect.top - f3, f3 + this.rect.right, f3 + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, 1.0f + rectF.right, 1.0f + rectF.bottom);
        L.endSection("StrokeContent#getBounds");
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
        TrimPathContent trimPathContent = null;
        for (int i = -1 + list.size(); i >= 0; --i) {
            TrimPathContent trimPathContent2;
            Content content = (Content)list.get(i);
            if (!(content instanceof TrimPathContent) || (trimPathContent2 = (TrimPathContent)content).getType() != ShapeTrimPath.Type.INDIVIDUALLY) continue;
            trimPathContent = trimPathContent2;
        }
        if (trimPathContent != null) {
            trimPathContent.addListener(this);
        }
        Object object = null;
        for (int i = -1 + list2.size(); i >= 0; --i) {
            TrimPathContent trimPathContent3;
            Content content = (Content)list2.get(i);
            if (content instanceof TrimPathContent && (trimPathContent3 = (TrimPathContent)content).getType() == ShapeTrimPath.Type.INDIVIDUALLY) {
                if (object != null) {
                    this.pathGroups.add(object);
                }
                object = new Object(trimPathContent3){
                    private final List<PathContent> paths = new ArrayList();
                    private final TrimPathContent trimPath;
                    {
                        this.trimPath = trimPathContent;
                    }
                };
                trimPathContent3.addListener(this);
                continue;
            }
            if (!(content instanceof PathContent)) continue;
            if (object == null) {
                object = new /* invalid duplicate definition of identical inner class */;
            }
            object.paths.add((Object)((PathContent)content));
        }
        if (object != null) {
            this.pathGroups.add(object);
        }
    }

}

