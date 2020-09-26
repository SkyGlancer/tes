/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  com.airbnb.lottie.animation.content.ContentGroup
 *  com.airbnb.lottie.model.KeyPath
 *  com.airbnb.lottie.model.content.ShapeGroup
 *  com.airbnb.lottie.model.layer.BaseLayer
 *  com.airbnb.lottie.model.layer.Layer
 *  java.lang.String
 *  java.util.Collections
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import java.util.Collections;
import java.util.List;

public class ShapeLayer
extends BaseLayer {
    private final ContentGroup contentGroup;

    ShapeLayer(LottieDrawable lottieDrawable, Layer layer) {
        ContentGroup contentGroup;
        super(lottieDrawable, layer);
        this.contentGroup = contentGroup = new ContentGroup(lottieDrawable, (BaseLayer)this, new ShapeGroup("__container", layer.getShapes(), false));
        contentGroup.setContents(Collections.emptyList(), Collections.emptyList());
    }

    void drawLayer(Canvas canvas, Matrix matrix, int n) {
        this.contentGroup.draw(canvas, matrix, n);
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean bl) {
        super.getBounds(rectF, matrix, bl);
        this.contentGroup.getBounds(rectF, this.boundsMatrix, bl);
    }

    protected void resolveChildKeyPath(KeyPath keyPath, int n, List<KeyPath> list, KeyPath keyPath2) {
        this.contentGroup.resolveKeyPath(keyPath, n, list, keyPath2);
    }
}

