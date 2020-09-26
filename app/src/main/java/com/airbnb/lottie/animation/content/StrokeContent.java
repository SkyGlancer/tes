/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  com.airbnb.lottie.animation.content.BaseStrokeContent
 *  com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
 *  com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener
 *  com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation
 *  com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation
 *  com.airbnb.lottie.model.animatable.AnimatableColorValue
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  com.airbnb.lottie.model.animatable.AnimatableIntegerValue
 *  com.airbnb.lottie.model.content.ShapeStroke
 *  com.airbnb.lottie.model.content.ShapeStroke$LineCapType
 *  com.airbnb.lottie.model.content.ShapeStroke$LineJoinType
 *  com.airbnb.lottie.model.layer.BaseLayer
 *  com.airbnb.lottie.value.LottieValueCallback
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.BaseStrokeContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class StrokeContent
extends BaseStrokeContent {
    private final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final boolean hidden;
    private final BaseLayer layer;
    private final String name;

    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        BaseKeyframeAnimation baseKeyframeAnimation;
        super(lottieDrawable, baseLayer, shapeStroke.getCapType().toPaintCap(), shapeStroke.getJoinType().toPaintJoin(), shapeStroke.getMiterLimit(), shapeStroke.getOpacity(), shapeStroke.getWidth(), shapeStroke.getLineDashPattern(), shapeStroke.getDashOffset());
        this.layer = baseLayer;
        this.name = shapeStroke.getName();
        this.hidden = shapeStroke.isHidden();
        this.colorAnimation = baseKeyframeAnimation = shapeStroke.getColor().createAnimation();
        baseKeyframeAnimation.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
        baseLayer.addAnimation(this.colorAnimation);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.STROKE_COLOR) {
            this.colorAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.COLOR_FILTER) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation;
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
            if (baseKeyframeAnimation != null) {
                this.layer.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
                return;
            }
            this.colorFilterAnimation = valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            valueCallbackKeyframeAnimation.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
            this.layer.addAnimation(this.colorAnimation);
        }
    }

    public void draw(Canvas canvas, Matrix matrix, int n) {
        if (this.hidden) {
            return;
        }
        this.paint.setColor(((ColorKeyframeAnimation)this.colorAnimation).getIntValue());
        if (this.colorFilterAnimation != null) {
            this.paint.setColorFilter((ColorFilter)this.colorFilterAnimation.getValue());
        }
        super.draw(canvas, matrix, n);
    }

    public String getName() {
        return this.name;
    }
}

