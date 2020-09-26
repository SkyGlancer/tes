/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  com.airbnb.lottie.model.layer.BaseLayer
 *  com.airbnb.lottie.model.layer.Layer
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;

public class NullLayer
extends BaseLayer {
    NullLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
    }

    void drawLayer(Canvas canvas, Matrix matrix, int n) {
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean bl) {
        super.getBounds(rectF, matrix, bl);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}

