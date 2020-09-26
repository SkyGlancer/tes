/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.graphics.RectF
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.CompoundTrimPathContent;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class RectangleContent
implements BaseKeyframeAnimation.AnimationListener,
KeyPathElementContent,
PathContent {
    private final BaseKeyframeAnimation<?, Float> cornerRadiusAnimation;
    private final boolean hidden;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path = new Path();
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final RectF rect = new RectF();
    private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    private CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RectangleShape rectangleShape) {
        this.name = rectangleShape.getName();
        this.hidden = rectangleShape.isHidden();
        this.lottieDrawable = lottieDrawable;
        this.positionAnimation = rectangleShape.getPosition().createAnimation();
        this.sizeAnimation = rectangleShape.getSize().createAnimation();
        this.cornerRadiusAnimation = rectangleShape.getCornerRadius().createAnimation();
        baseLayer.addAnimation(this.positionAnimation);
        baseLayer.addAnimation(this.sizeAnimation);
        baseLayer.addAnimation(this.cornerRadiusAnimation);
        this.positionAnimation.addUpdateListener(this);
        this.sizeAnimation.addUpdateListener(this);
        this.cornerRadiusAnimation.addUpdateListener(this);
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.RECTANGLE_SIZE) {
            this.sizeAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.CORNER_RADIUS) {
            this.cornerRadiusAnimation.setValueCallback(lottieValueCallback);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Path getPath() {
        float f;
        float f2;
        float f3;
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        PointF pointF = this.sizeAnimation.getValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.cornerRadiusAnimation;
        float f4 = baseKeyframeAnimation == null ? 0.0f : ((FloatKeyframeAnimation)baseKeyframeAnimation).getFloatValue();
        if (f4 > (f = Math.min((float)(f3 = pointF.x / 2.0f), (float)(f2 = pointF.y / 2.0f)))) {
            f4 = f;
        }
        PointF pointF2 = this.positionAnimation.getValue();
        this.path.moveTo(f3 + pointF2.x, f4 + (pointF2.y - f2));
        this.path.lineTo(f3 + pointF2.x, f2 + pointF2.y - f4);
        if (f4 > 0.0f) {
            RectF rectF = this.rect;
            float f5 = f3 + pointF2.x;
            float f6 = f4 * 2.0f;
            rectF.set(f5 - f6, f2 + pointF2.y - f6, f3 + pointF2.x, f2 + pointF2.y);
            this.path.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.path.lineTo(f4 + (pointF2.x - f3), f2 + pointF2.y);
        if (f4 > 0.0f) {
            RectF rectF = this.rect;
            float f7 = pointF2.x - f3;
            float f8 = f2 + pointF2.y;
            float f9 = f4 * 2.0f;
            rectF.set(f7, f8 - f9, f9 + (pointF2.x - f3), f2 + pointF2.y);
            this.path.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.path.lineTo(pointF2.x - f3, f4 + (pointF2.y - f2));
        if (f4 > 0.0f) {
            RectF rectF = this.rect;
            float f10 = pointF2.x - f3;
            float f11 = pointF2.y - f2;
            float f12 = pointF2.x - f3;
            float f13 = f4 * 2.0f;
            rectF.set(f10, f11, f12 + f13, f13 + (pointF2.y - f2));
            this.path.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.path.lineTo(f3 + pointF2.x - f4, pointF2.y - f2);
        if (f4 > 0.0f) {
            RectF rectF = this.rect;
            float f14 = f3 + pointF2.x;
            float f15 = f4 * 2.0f;
            rectF.set(f14 - f15, pointF2.y - f2, f3 + pointF2.x, f15 + (pointF2.y - f2));
            this.path.arcTo(this.rect, 270.0f, 90.0f, false);
        }
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    @Override
    public void onValueChanged() {
        this.invalidate();
    }

    @Override
    public void resolveKeyPath(KeyPath keyPath, int n, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, n, list, keyPath2, this);
    }

    @Override
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); ++i) {
            TrimPathContent trimPathContent;
            Content content = (Content)list.get(i);
            if (!(content instanceof TrimPathContent) || (trimPathContent = (TrimPathContent)content).getType() != ShapeTrimPath.Type.SIMULTANEOUSLY) continue;
            this.trimPaths.addTrimPath(trimPathContent);
            trimPathContent.addListener(this);
        }
    }
}

