/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PointF
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.CompoundTrimPathContent;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class EllipseContent
implements PathContent,
BaseKeyframeAnimation.AnimationListener,
KeyPathElementContent {
    private static final float ELLIPSE_CONTROL_POINT_PERCENTAGE = 0.55228f;
    private final CircleShape circleShape;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path = new Path();
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    private CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    public EllipseContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, CircleShape circleShape) {
        this.name = circleShape.getName();
        this.lottieDrawable = lottieDrawable;
        this.sizeAnimation = circleShape.getSize().createAnimation();
        this.positionAnimation = circleShape.getPosition().createAnimation();
        this.circleShape = circleShape;
        baseLayer.addAnimation(this.sizeAnimation);
        baseLayer.addAnimation(this.positionAnimation);
        this.sizeAnimation.addUpdateListener(this);
        this.positionAnimation.addUpdateListener(this);
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.ELLIPSE_SIZE) {
            this.sizeAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.circleShape.isHidden()) {
            this.isPathValid = true;
            return this.path;
        }
        PointF pointF = this.sizeAnimation.getValue();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.path.reset();
        if (this.circleShape.isReversed()) {
            Path path = this.path;
            float f5 = -f2;
            path.moveTo(0.0f, f5);
            Path path2 = this.path;
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            path2.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            Path path3 = this.path;
            float f9 = f4 + 0.0f;
            path3.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            Path path4 = this.path;
            float f10 = f3 + 0.0f;
            path4.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.path.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            Path path = this.path;
            float f11 = -f2;
            path.moveTo(0.0f, f11);
            Path path5 = this.path;
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            path5.cubicTo(f12, f11, f, f13, f, 0.0f);
            Path path6 = this.path;
            float f14 = f4 + 0.0f;
            path6.cubicTo(f, f14, f12, f2, 0.0f, f2);
            Path path7 = this.path;
            float f15 = 0.0f - f3;
            float f16 = -f;
            path7.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.path.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointF2 = this.positionAnimation.getValue();
        this.path.offset(pointF2.x, pointF2.y);
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

