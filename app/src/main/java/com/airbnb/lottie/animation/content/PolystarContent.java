/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PointF
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Math
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
import com.airbnb.lottie.animation.content.PolystarContent;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PolystarContent
implements PathContent,
BaseKeyframeAnimation.AnimationListener,
KeyPathElementContent {
    private static final float POLYGON_MAGIC_NUMBER = 0.25f;
    private static final float POLYSTAR_MAGIC_NUMBER = 0.47829f;
    private final boolean hidden;
    private final BaseKeyframeAnimation<?, Float> innerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> innerRoundednessAnimation;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, Float> outerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> outerRoundednessAnimation;
    private final Path path = new Path();
    private final BaseKeyframeAnimation<?, Float> pointsAnimation;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, Float> rotationAnimation;
    private CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();
    private final PolystarShape.Type type;

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.lottieDrawable = lottieDrawable;
        this.name = polystarShape.getName();
        this.type = polystarShape.getType();
        this.hidden = polystarShape.isHidden();
        this.pointsAnimation = polystarShape.getPoints().createAnimation();
        this.positionAnimation = polystarShape.getPosition().createAnimation();
        this.rotationAnimation = polystarShape.getRotation().createAnimation();
        this.outerRadiusAnimation = polystarShape.getOuterRadius().createAnimation();
        this.outerRoundednessAnimation = polystarShape.getOuterRoundedness().createAnimation();
        if (this.type == PolystarShape.Type.STAR) {
            this.innerRadiusAnimation = polystarShape.getInnerRadius().createAnimation();
            this.innerRoundednessAnimation = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        baseLayer.addAnimation(this.pointsAnimation);
        baseLayer.addAnimation(this.positionAnimation);
        baseLayer.addAnimation(this.rotationAnimation);
        baseLayer.addAnimation(this.outerRadiusAnimation);
        baseLayer.addAnimation(this.outerRoundednessAnimation);
        if (this.type == PolystarShape.Type.STAR) {
            baseLayer.addAnimation(this.innerRadiusAnimation);
            baseLayer.addAnimation(this.innerRoundednessAnimation);
        }
        this.pointsAnimation.addUpdateListener(this);
        this.positionAnimation.addUpdateListener(this);
        this.rotationAnimation.addUpdateListener(this);
        this.outerRadiusAnimation.addUpdateListener(this);
        this.outerRoundednessAnimation.addUpdateListener(this);
        if (this.type == PolystarShape.Type.STAR) {
            this.innerRadiusAnimation.addUpdateListener(this);
            this.innerRoundednessAnimation.addUpdateListener(this);
        }
    }

    private void createPolygonPath() {
        int n = (int)Math.floor((double)this.pointsAnimation.getValue().floatValue());
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.rotationAnimation;
        double d = baseKeyframeAnimation == null ? 0.0 : (double)baseKeyframeAnimation.getValue().floatValue();
        double d2 = Math.toRadians((double)(d - 90.0));
        double d3 = n;
        Double.isNaN((double)d3);
        float f = (float)(6.283185307179586 / d3);
        float f2 = this.outerRoundednessAnimation.getValue().floatValue() / 100.0f;
        float f3 = this.outerRadiusAnimation.getValue().floatValue();
        double d4 = f3;
        double d5 = Math.cos((double)d2);
        Double.isNaN((double)d4);
        float f4 = (float)(d5 * d4);
        double d6 = Math.sin((double)d2);
        Double.isNaN((double)d4);
        float f5 = (float)(d6 * d4);
        this.path.moveTo(f4, f5);
        double d7 = f;
        Double.isNaN((double)d7);
        double d8 = d2 + d7;
        double d9 = Math.ceil((double)d3);
        int n2 = 0;
        while ((double)n2 < d9) {
            double d10;
            double d11;
            int n3;
            double d12;
            double d13 = Math.cos((double)d8);
            Double.isNaN((double)d4);
            float f6 = (float)(d13 * d4);
            double d14 = Math.sin((double)d8);
            Double.isNaN((double)d4);
            double d15 = d9;
            float f7 = (float)(d4 * d14);
            if (f2 != 0.0f) {
                d12 = d4;
                double d16 = f5;
                n3 = n2;
                d10 = d8;
                double d17 = (float)(Math.atan2((double)d16, (double)f4) - 1.5707963267948966);
                float f8 = (float)Math.cos((double)d17);
                float f9 = (float)Math.sin((double)d17);
                double d18 = f7;
                d11 = d7;
                double d19 = (float)(Math.atan2((double)d18, (double)f6) - 1.5707963267948966);
                float f10 = (float)Math.cos((double)d19);
                float f11 = (float)Math.sin((double)d19);
                float f12 = 0.25f * (f3 * f2);
                float f13 = f8 * f12;
                float f14 = f9 * f12;
                float f15 = f10 * f12;
                float f16 = f12 * f11;
                this.path.cubicTo(f4 - f13, f5 - f14, f6 + f15, f7 + f16, f6, f7);
            } else {
                d10 = d8;
                d12 = d4;
                d11 = d7;
                n3 = n2;
                this.path.lineTo(f6, f7);
            }
            Double.isNaN((double)d11);
            d8 = d10 + d11;
            n2 = n3 + 1;
            f5 = f7;
            f4 = f6;
            d9 = d15;
            d4 = d12;
            d7 = d11;
        }
        PointF pointF = this.positionAnimation.getValue();
        this.path.offset(pointF.x, pointF.y);
        this.path.close();
    }

    private void createStarPath() {
        float f;
        double d;
        double d2;
        float f2;
        float f3;
        float f4;
        float f5;
        double d3;
        float f6 = this.pointsAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.rotationAnimation;
        double d4 = baseKeyframeAnimation == null ? 0.0 : (double)baseKeyframeAnimation.getValue().floatValue();
        double d5 = Math.toRadians((double)(d4 - 90.0));
        double d6 = f6;
        Double.isNaN((double)d6);
        float f7 = (float)(6.283185307179586 / d6);
        float f8 = f7 / 2.0f;
        float f9 = f6 - (float)((int)f6);
        if (f9 != 0.0f) {
            double d7 = f8 * (1.0f - f9);
            Double.isNaN((double)d7);
            d5 += d7;
        }
        float f10 = this.outerRadiusAnimation.getValue().floatValue();
        float f11 = this.innerRadiusAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.innerRoundednessAnimation;
        float f12 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.getValue().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.outerRoundednessAnimation;
        float f13 = baseKeyframeAnimation3 != null ? baseKeyframeAnimation3.getValue().floatValue() / 100.0f : 0.0f;
        if (f9 != 0.0f) {
            float f14 = f11 + f9 * (f10 - f11);
            double d8 = f14;
            double d9 = Math.cos((double)d5);
            Double.isNaN((double)d8);
            d3 = d6;
            float f15 = (float)(d8 * d9);
            double d10 = Math.sin((double)d5);
            Double.isNaN((double)d8);
            float f16 = (float)(d8 * d10);
            this.path.moveTo(f15, f16);
            double d11 = f7 * f9 / 2.0f;
            Double.isNaN((double)d11);
            d2 = d5 + d11;
            f = f15;
            f2 = f14;
            f4 = f10;
            f5 = f16;
            f3 = f8;
        } else {
            d3 = d6;
            f4 = f10;
            double d12 = f4;
            double d13 = Math.cos((double)d5);
            Double.isNaN((double)d12);
            f3 = f8;
            f = (float)(d12 * d13);
            double d14 = Math.sin((double)d5);
            Double.isNaN((double)d12);
            f5 = (float)(d12 * d14);
            this.path.moveTo(f, f5);
            double d15 = f3;
            Double.isNaN((double)d15);
            d2 = d5 + d15;
            f2 = 0.0f;
        }
        double d16 = 2.0 * Math.ceil((double)d3);
        int n = 0;
        float f17 = f13;
        boolean bl = false;
        while ((d = (double)n) < d16) {
            float f18;
            float f19;
            float f20;
            float f21;
            float f22;
            double d17;
            float f23;
            float f24;
            float f25 = bl ? f4 : f11;
            float f26 = f2 != 0.0f && d == d16 - 2.0 ? f7 * f9 / 2.0f : f3;
            if (f2 != 0.0f && d == d16 - 1.0) {
                f18 = f7;
                f24 = f4;
                f21 = f2;
            } else {
                f18 = f7;
                f21 = f25;
                f24 = f4;
            }
            double d18 = f21;
            double d19 = Math.cos((double)d2);
            Double.isNaN((double)d18);
            float f27 = (float)(d18 * d19);
            double d20 = Math.sin((double)d2);
            Double.isNaN((double)d18);
            float f28 = (float)(d18 * d20);
            if (f12 == 0.0f && f17 == 0.0f) {
                this.path.lineTo(f27, f28);
                d17 = d2;
                f19 = f11;
                f22 = f12;
                f20 = f3;
                f23 = f26;
            } else {
                float f29 = f3;
                double d21 = f5;
                f19 = f11;
                f22 = f12;
                double d22 = (float)(Math.atan2((double)d21, (double)f) - 1.5707963267948966);
                float f30 = (float)Math.cos((double)d22);
                float f31 = (float)Math.sin((double)d22);
                d17 = d2;
                double d23 = f28;
                f20 = f29;
                f23 = f26;
                double d24 = (float)(Math.atan2((double)d23, (double)f27) - 1.5707963267948966);
                float f32 = (float)Math.cos((double)d24);
                float f33 = (float)Math.sin((double)d24);
                float f34 = bl ? f22 : f17;
                float f35 = bl ? f17 : f22;
                float f36 = bl ? f19 : f24;
                float f37 = bl ? f24 : f19;
                float f38 = 0.47829f * (f36 * f34);
                float f39 = f30 * f38;
                float f40 = f38 * f31;
                float f41 = 0.47829f * (f37 * f35);
                float f42 = f32 * f41;
                float f43 = f41 * f33;
                if (f9 != 0.0f) {
                    if (n == 0) {
                        f39 *= f9;
                        f40 *= f9;
                    } else if (d == d16 - 1.0) {
                        f42 *= f9;
                        f43 *= f9;
                    }
                }
                this.path.cubicTo(f - f39, f5 - f40, f27 + f42, f28 + f43, f27, f28);
            }
            double d25 = f23;
            Double.isNaN((double)d25);
            double d26 = d17 + d25;
            bl ^= true;
            ++n;
            f5 = f28;
            d2 = d26;
            f3 = f20;
            f = f27;
            f4 = f24;
            f7 = f18;
            f11 = f19;
            f12 = f22;
        }
        PointF pointF = this.positionAnimation.getValue();
        this.path.offset(pointF.x, pointF.y);
        this.path.close();
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.POLYSTAR_POINTS) {
            this.pointsAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_ROTATION) {
            this.rotationAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation = this.innerRadiusAnimation) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.outerRadiusAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation2 = this.innerRoundednessAnimation) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.outerRoundednessAnimation.setValueCallback(lottieValueCallback);
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
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        int n = 1.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[this.type.ordinal()];
        if (n != 1) {
            if (n == 2) {
                this.createPolygonPath();
            }
        } else {
            this.createStarPath();
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

