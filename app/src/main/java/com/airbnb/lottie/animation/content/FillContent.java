/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  android.graphics.RectF
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class FillContent
implements DrawingContent,
BaseKeyframeAnimation.AnimationListener,
KeyPathElementContent {
    private final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final boolean hidden;
    private final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
    private final Paint paint = new LPaint(1);
    private final Path path = new Path();
    private final List<PathContent> paths = new ArrayList();

    public FillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeFill shapeFill) {
        this.layer = baseLayer;
        this.name = shapeFill.getName();
        this.hidden = shapeFill.isHidden();
        this.lottieDrawable = lottieDrawable;
        if (shapeFill.getColor() != null && shapeFill.getOpacity() != null) {
            this.path.setFillType(shapeFill.getFillType());
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = shapeFill.getColor().createAnimation();
            this.colorAnimation = baseKeyframeAnimation;
            baseKeyframeAnimation.addUpdateListener(this);
            baseLayer.addAnimation(this.colorAnimation);
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = shapeFill.getOpacity().createAnimation();
            this.opacityAnimation = baseKeyframeAnimation2;
            baseKeyframeAnimation2.addUpdateListener(this);
            baseLayer.addAnimation(this.opacityAnimation);
            return;
        }
        this.colorAnimation = null;
        this.opacityAnimation = null;
    }

    @Override
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.COLOR) {
            this.colorAnimation.setValueCallback(lottieValueCallback);
            return;
        }
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
        }
    }

    @Override
    public void draw(Canvas canvas, Matrix matrix, int n) {
        if (this.hidden) {
            return;
        }
        L.beginSection("FillContent#draw");
        this.paint.setColor(((ColorKeyframeAnimation)this.colorAnimation).getIntValue());
        int n2 = (int)(255.0f * ((float)n / 255.0f * (float)this.opacityAnimation.getValue().intValue() / 100.0f));
        Paint paint = this.paint;
        int n3 = 0;
        paint.setAlpha(MiscUtils.clamp(n2, 0, 255));
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        this.path.reset();
        while (n3 < this.paths.size()) {
            this.path.addPath(((PathContent)this.paths.get(n3)).getPath(), matrix);
            ++n3;
        }
        canvas.drawPath(this.path, this.paint);
        L.endSection("FillContent#draw");
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

