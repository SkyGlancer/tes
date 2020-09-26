/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.RectF
 *  androidx.collection.LongSparseArray
 *  com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
 *  com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener
 *  com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation
 *  com.airbnb.lottie.model.KeyPath
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  com.airbnb.lottie.model.layer.BaseLayer
 *  com.airbnb.lottie.model.layer.CompositionLayer$1
 *  com.airbnb.lottie.model.layer.Layer
 *  com.airbnb.lottie.model.layer.Layer$MatteType
 *  com.airbnb.lottie.utils.Utils
 *  com.airbnb.lottie.value.LottieValueCallback
 *  java.lang.Boolean
 *  java.lang.Float
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.ShapeLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class CompositionLayer
extends BaseLayer {
    private Boolean hasMasks;
    private Boolean hasMatte;
    private Paint layerPaint = new Paint();
    private final List<BaseLayer> layers = new ArrayList();
    private final RectF newClipRect = new RectF();
    private final RectF rect = new RectF();
    private BaseKeyframeAnimation<Float, Float> timeRemapping;

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        AnimatableFloatValue animatableFloatValue = layer.getTimeRemapping();
        if (animatableFloatValue != null) {
            BaseKeyframeAnimation baseKeyframeAnimation;
            this.timeRemapping = baseKeyframeAnimation = animatableFloatValue.createAnimation();
            this.addAnimation(baseKeyframeAnimation);
            this.timeRemapping.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
        } else {
            this.timeRemapping = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.getLayers().size());
        int n = list.size() - 1;
        BaseLayer baseLayer = null;
        do {
            if (n < 0) break;
            Layer layer2 = (Layer)list.get(n);
            BaseLayer baseLayer2 = BaseLayer.forModel((Layer)layer2, (LottieDrawable)lottieDrawable, (LottieComposition)lottieComposition);
            if (baseLayer2 != null) {
                longSparseArray.put(baseLayer2.getLayerModel().getId(), (Object)baseLayer2);
                if (baseLayer != null) {
                    baseLayer.setMatteLayer(baseLayer2);
                    baseLayer = null;
                } else {
                    this.layers.add(0, (Object)baseLayer2);
                    int n2 = 1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[layer2.getMatteType().ordinal()];
                    if (n2 == 1 || n2 == 2) {
                        baseLayer = baseLayer2;
                    }
                }
            }
            --n;
        } while (true);
        for (int i = 0; i < longSparseArray.size(); ++i) {
            BaseLayer baseLayer3;
            BaseLayer baseLayer4 = (BaseLayer)longSparseArray.get(longSparseArray.keyAt(i));
            if (baseLayer4 == null || (baseLayer3 = (BaseLayer)longSparseArray.get(baseLayer4.getLayerModel().getParentId())) == null) continue;
            baseLayer4.setParentLayer(baseLayer3);
        }
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.TIME_REMAP) {
            if (lottieValueCallback == null) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.timeRemapping;
                if (baseKeyframeAnimation != null) {
                    baseKeyframeAnimation.setValueCallback(null);
                    return;
                }
            } else {
                ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation;
                this.timeRemapping = valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                valueCallbackKeyframeAnimation.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
                this.addAnimation(this.timeRemapping);
            }
        }
    }

    void drawLayer(Canvas canvas, Matrix matrix, int n) {
        L.beginSection("CompositionLayer#draw");
        this.newClipRect.set(0.0f, 0.0f, (float)this.layerModel.getPreCompWidth(), (float)this.layerModel.getPreCompHeight());
        matrix.mapRect(this.newClipRect);
        boolean bl = this.lottieDrawable.isApplyingOpacityToLayersEnabled() && this.layers.size() > 1 && n != 255;
        if (bl) {
            this.layerPaint.setAlpha(n);
            Utils.saveLayerCompat((Canvas)canvas, (RectF)this.newClipRect, (Paint)this.layerPaint);
        } else {
            canvas.save();
        }
        if (bl) {
            n = 255;
        }
        for (int i = this.layers.size() - 1; i >= 0; --i) {
            boolean bl2 = !this.newClipRect.isEmpty() ? canvas.clipRect(this.newClipRect) : true;
            if (!bl2) continue;
            ((BaseLayer)this.layers.get(i)).draw(canvas, matrix, n);
        }
        canvas.restore();
        L.endSection("CompositionLayer#draw");
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean bl) {
        super.getBounds(rectF, matrix, bl);
        for (int i = this.layers.size() - 1; i >= 0; --i) {
            this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
            ((BaseLayer)this.layers.get(i)).getBounds(this.rect, this.boundsMatrix, true);
            rectF.union(this.rect);
        }
    }

    public boolean hasMasks() {
        if (this.hasMasks == null) {
            for (int i = this.layers.size() - 1; i >= 0; --i) {
                BaseLayer baseLayer = (BaseLayer)this.layers.get(i);
                if (baseLayer instanceof ShapeLayer) {
                    if (!baseLayer.hasMasksOnThisLayer()) continue;
                    this.hasMasks = true;
                    return true;
                }
                if (!(baseLayer instanceof CompositionLayer) || !((CompositionLayer)baseLayer).hasMasks()) continue;
                this.hasMasks = true;
                return true;
            }
            this.hasMasks = false;
        }
        return this.hasMasks;
    }

    public boolean hasMatte() {
        if (this.hasMatte == null) {
            if (this.hasMatteOnThisLayer()) {
                this.hasMatte = true;
                return true;
            }
            for (int i = this.layers.size() - 1; i >= 0; --i) {
                if (!((BaseLayer)this.layers.get(i)).hasMatteOnThisLayer()) continue;
                this.hasMatte = true;
                return true;
            }
            this.hasMatte = false;
        }
        return this.hasMatte;
    }

    protected void resolveChildKeyPath(KeyPath keyPath, int n, List<KeyPath> list, KeyPath keyPath2) {
        for (int i = 0; i < this.layers.size(); ++i) {
            ((BaseLayer)this.layers.get(i)).resolveKeyPath(keyPath, n, list, keyPath2);
        }
    }

    public void setProgress(float f) {
        super.setProgress(f);
        if (this.timeRemapping != null) {
            float f2 = 0.01f + this.lottieDrawable.getComposition().getDurationFrames();
            float f3 = this.layerModel.getComposition().getStartFrame();
            f = (((Float)this.timeRemapping.getValue()).floatValue() * this.layerModel.getComposition().getFrameRate() - f3) / f2;
        }
        if (this.timeRemapping == null) {
            f -= this.layerModel.getStartProgress();
        }
        if (this.layerModel.getTimeStretch() != 0.0f) {
            f /= this.layerModel.getTimeStretch();
        }
        for (int i = -1 + this.layers.size(); i >= 0; --i) {
            ((BaseLayer)this.layers.get(i)).setProgress(f);
        }
    }
}

