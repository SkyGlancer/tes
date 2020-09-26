/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.RectF
 *  com.airbnb.lottie.animation.LPaint
 *  com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
 *  com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation
 *  com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation
 *  com.airbnb.lottie.model.layer.BaseLayer
 *  com.airbnb.lottie.model.layer.Layer
 *  com.airbnb.lottie.value.LottieValueCallback
 *  java.lang.Integer
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.value.LottieValueCallback;

public class SolidLayer
extends BaseLayer {
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final Layer layerModel;
    private final Paint paint = new LPaint();
    private final Path path = new Path();
    private final float[] points = new float[8];
    private final RectF rect = new RectF();

    SolidLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.layerModel = layer;
        this.paint.setAlpha(0);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(layer.getSolidColor());
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.COLOR_FILTER) {
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
                return;
            }
            this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
        }
    }

    public void drawLayer(Canvas canvas, Matrix matrix, int n) {
        int n2 = Color.alpha((int)this.layerModel.getSolidColor());
        if (n2 == 0) {
            return;
        }
        int n3 = this.transform.getOpacity() == null ? 100 : (Integer)this.transform.getOpacity().getValue();
        int n4 = (int)(255.0f * ((float)n / 255.0f * ((float)n2 / 255.0f * (float)n3 / 100.0f)));
        this.paint.setAlpha(n4);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter((ColorFilter)baseKeyframeAnimation.getValue());
        }
        if (n4 > 0) {
            float[] arrf = this.points;
            arrf[0] = 0.0f;
            arrf[1] = 0.0f;
            arrf[2] = this.layerModel.getSolidWidth();
            float[] arrf2 = this.points;
            arrf2[3] = 0.0f;
            arrf2[4] = this.layerModel.getSolidWidth();
            this.points[5] = this.layerModel.getSolidHeight();
            float[] arrf3 = this.points;
            arrf3[6] = 0.0f;
            arrf3[7] = this.layerModel.getSolidHeight();
            matrix.mapPoints(this.points);
            this.path.reset();
            Path path = this.path;
            float[] arrf4 = this.points;
            path.moveTo(arrf4[0], arrf4[1]);
            Path path2 = this.path;
            float[] arrf5 = this.points;
            path2.lineTo(arrf5[2], arrf5[3]);
            Path path3 = this.path;
            float[] arrf6 = this.points;
            path3.lineTo(arrf6[4], arrf6[5]);
            Path path4 = this.path;
            float[] arrf7 = this.points;
            path4.lineTo(arrf7[6], arrf7[7]);
            Path path5 = this.path;
            float[] arrf8 = this.points;
            path5.lineTo(arrf8[0], arrf8[1]);
            this.path.close();
            canvas.drawPath(this.path, this.paint);
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean bl) {
        super.getBounds(rectF, matrix, bl);
        this.rect.set(0.0f, 0.0f, (float)this.layerModel.getSolidWidth(), (float)this.layerModel.getSolidHeight());
        this.boundsMatrix.mapRect(this.rect);
        rectF.set(this.rect);
    }
}

