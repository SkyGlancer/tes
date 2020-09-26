/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  com.airbnb.lottie.animation.LPaint
 *  com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
 *  com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation
 *  com.airbnb.lottie.model.layer.BaseLayer
 *  com.airbnb.lottie.model.layer.Layer
 *  com.airbnb.lottie.utils.Utils
 *  com.airbnb.lottie.value.LottieValueCallback
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;

public class ImageLayer
extends BaseLayer {
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final Rect dst = new Rect();
    private final Paint paint = new LPaint(3);
    private final Rect src = new Rect();

    ImageLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
    }

    private Bitmap getBitmap() {
        String string2 = this.layerModel.getRefId();
        return this.lottieDrawable.getImageAsset(string2);
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
        Bitmap bitmap = this.getBitmap();
        if (bitmap != null) {
            if (bitmap.isRecycled()) {
                return;
            }
            float f = Utils.dpScale();
            this.paint.setAlpha(n);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
            if (baseKeyframeAnimation != null) {
                this.paint.setColorFilter((ColorFilter)baseKeyframeAnimation.getValue());
            }
            canvas.save();
            canvas.concat(matrix);
            this.src.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.dst.set(0, 0, (int)(f * (float)bitmap.getWidth()), (int)(f * (float)bitmap.getHeight()));
            canvas.drawBitmap(bitmap, this.src, this.dst, this.paint);
            canvas.restore();
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean bl) {
        super.getBounds(rectF, matrix, bl);
        Bitmap bitmap = this.getBitmap();
        if (bitmap != null) {
            rectF.set(0.0f, 0.0f, (float)bitmap.getWidth() * Utils.dpScale(), (float)bitmap.getHeight() * Utils.dpScale());
            this.boundsMatrix.mapRect(rectF);
        }
    }
}

