/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.RectF
 *  android.graphics.Xfermode
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.PerformanceTracker;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.model.layer.ImageLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.NullLayer;
import com.airbnb.lottie.model.layer.ShapeLayer;
import com.airbnb.lottie.model.layer.SolidLayer;
import com.airbnb.lottie.model.layer.TextLayer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class BaseLayer
implements DrawingContent,
BaseKeyframeAnimation.AnimationListener,
KeyPathElement {
    private static final int CLIP_SAVE_FLAG = 2;
    private static final int CLIP_TO_LAYER_SAVE_FLAG = 16;
    private static final int MATRIX_SAVE_FLAG = 1;
    private static final int SAVE_FLAGS = 19;
    private final List<BaseKeyframeAnimation<?, ?>> animations = new ArrayList();
    final Matrix boundsMatrix = new Matrix();
    private final Paint clearPaint = new LPaint(PorterDuff.Mode.CLEAR);
    private final Paint contentPaint = new LPaint(1);
    private final String drawTraceName;
    private final Paint dstInPaint = new LPaint(1, PorterDuff.Mode.DST_IN);
    private final Paint dstOutPaint = new LPaint(1, PorterDuff.Mode.DST_OUT);
    private FloatKeyframeAnimation inOutAnimation;
    final Layer layerModel;
    final LottieDrawable lottieDrawable;
    private MaskKeyframeAnimation mask;
    private final RectF maskBoundsRect = new RectF();
    private final Matrix matrix = new Matrix();
    private final RectF matteBoundsRect = new RectF();
    private BaseLayer matteLayer;
    private final Paint mattePaint = new LPaint(1);
    private BaseLayer parentLayer;
    private List<BaseLayer> parentLayers;
    private final Path path = new Path();
    private final RectF rect = new RectF();
    private final RectF tempMaskBoundsRect = new RectF();
    final TransformKeyframeAnimation transform;
    private boolean visible = true;

    BaseLayer(LottieDrawable lottieDrawable, Layer layer) {
        TransformKeyframeAnimation transformKeyframeAnimation;
        this.lottieDrawable = lottieDrawable;
        this.layerModel = layer;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(layer.getName());
        stringBuilder.append("#draw");
        this.drawTraceName = stringBuilder.toString();
        if (layer.getMatteType() == Layer.MatteType.INVERT) {
            this.mattePaint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.mattePaint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.transform = transformKeyframeAnimation = layer.getTransform().createAnimation();
        transformKeyframeAnimation.addListener(this);
        if (layer.getMasks() != null && !layer.getMasks().isEmpty()) {
            MaskKeyframeAnimation maskKeyframeAnimation;
            this.mask = maskKeyframeAnimation = new MaskKeyframeAnimation(layer.getMasks());
            Iterator iterator = maskKeyframeAnimation.getMaskAnimations().iterator();
            while (iterator.hasNext()) {
                ((BaseKeyframeAnimation)iterator.next()).addUpdateListener(this);
            }
            for (BaseKeyframeAnimation baseKeyframeAnimation : this.mask.getOpacityAnimations()) {
                this.addAnimation(baseKeyframeAnimation);
                baseKeyframeAnimation.addUpdateListener(this);
            }
        }
        this.setupInOutAnimations();
    }

    private void applyAddMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Path path = baseKeyframeAnimation.getValue();
        this.path.set(path);
        this.path.transform(matrix);
        this.contentPaint.setAlpha((int)(2.55f * (float)baseKeyframeAnimation2.getValue().intValue()));
        canvas.drawPath(this.path, this.contentPaint);
    }

    private void applyIntersectMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.rect, this.dstInPaint);
        Path path = baseKeyframeAnimation.getValue();
        this.path.set(path);
        this.path.transform(matrix);
        this.contentPaint.setAlpha((int)(2.55f * (float)baseKeyframeAnimation2.getValue().intValue()));
        canvas.drawPath(this.path, this.contentPaint);
        canvas.restore();
    }

    private void applyInvertedAddMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.rect, this.contentPaint);
        canvas.drawRect(this.rect, this.contentPaint);
        Path path = baseKeyframeAnimation.getValue();
        this.path.set(path);
        this.path.transform(matrix);
        this.contentPaint.setAlpha((int)(2.55f * (float)baseKeyframeAnimation2.getValue().intValue()));
        canvas.drawPath(this.path, this.dstOutPaint);
        canvas.restore();
    }

    private void applyInvertedIntersectMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.rect, this.dstInPaint);
        canvas.drawRect(this.rect, this.contentPaint);
        this.dstOutPaint.setAlpha((int)(2.55f * (float)baseKeyframeAnimation2.getValue().intValue()));
        Path path = baseKeyframeAnimation.getValue();
        this.path.set(path);
        this.path.transform(matrix);
        canvas.drawPath(this.path, this.dstOutPaint);
        canvas.restore();
    }

    private void applyInvertedSubtractMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.rect, this.dstOutPaint);
        canvas.drawRect(this.rect, this.contentPaint);
        this.dstOutPaint.setAlpha((int)(2.55f * (float)baseKeyframeAnimation2.getValue().intValue()));
        Path path = baseKeyframeAnimation.getValue();
        this.path.set(path);
        this.path.transform(matrix);
        canvas.drawPath(this.path, this.dstOutPaint);
        canvas.restore();
    }

    private void applyMasks(Canvas canvas, Matrix matrix) {
        L.beginSection("Layer#saveLayer");
        Utils.saveLayerCompat(canvas, this.rect, this.dstInPaint, 19);
        if (Build.VERSION.SDK_INT < 28) {
            this.clearCanvas(canvas);
        }
        L.endSection("Layer#saveLayer");
        for (int i = 0; i < this.mask.getMasks().size(); ++i) {
            Mask mask = (Mask)this.mask.getMasks().get(i);
            BaseKeyframeAnimation baseKeyframeAnimation = (BaseKeyframeAnimation)this.mask.getMaskAnimations().get(i);
            BaseKeyframeAnimation baseKeyframeAnimation2 = (BaseKeyframeAnimation)this.mask.getOpacityAnimations().get(i);
            int n = 2.$SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[mask.getMaskMode().ordinal()];
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n != 4) continue;
                        if (mask.isInverted()) {
                            this.applyInvertedAddMask(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                            continue;
                        }
                        this.applyAddMask(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                        continue;
                    }
                    if (mask.isInverted()) {
                        this.applyInvertedIntersectMask(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                        continue;
                    }
                    this.applyIntersectMask(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    continue;
                }
                if (i == 0) {
                    this.contentPaint.setColor(-16777216);
                    this.contentPaint.setAlpha(255);
                    canvas.drawRect(this.rect, this.contentPaint);
                }
                if (mask.isInverted()) {
                    this.applyInvertedSubtractMask(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    continue;
                }
                this.applySubtractMask(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                continue;
            }
            if (!this.areAllMasksNone()) continue;
            this.contentPaint.setAlpha(255);
            canvas.drawRect(this.rect, this.contentPaint);
        }
        L.beginSection("Layer#restoreLayer");
        canvas.restore();
        L.endSection("Layer#restoreLayer");
    }

    private void applySubtractMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Path path = baseKeyframeAnimation.getValue();
        this.path.set(path);
        this.path.transform(matrix);
        canvas.drawPath(this.path, this.dstOutPaint);
    }

    private boolean areAllMasksNone() {
        if (this.mask.getMaskAnimations().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.mask.getMasks().size(); ++i) {
            if (((Mask)this.mask.getMasks().get(i)).getMaskMode() == Mask.MaskMode.MASK_MODE_NONE) continue;
            return false;
        }
        return true;
    }

    private void buildParentLayerListIfNeeded() {
        if (this.parentLayers != null) {
            return;
        }
        if (this.parentLayer == null) {
            this.parentLayers = Collections.emptyList();
            return;
        }
        this.parentLayers = new ArrayList();
        BaseLayer baseLayer = this.parentLayer;
        while (baseLayer != null) {
            this.parentLayers.add((Object)baseLayer);
            baseLayer = baseLayer.parentLayer;
        }
    }

    private void clearCanvas(Canvas canvas) {
        L.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, 1.0f + this.rect.right, 1.0f + this.rect.bottom, this.clearPaint);
        L.endSection("Layer#clearLayer");
    }

    static BaseLayer forModel(Layer layer, LottieDrawable lottieDrawable, LottieComposition lottieComposition) {
        switch (2.$SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[layer.getLayerType().ordinal()]) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown layer type ");
                stringBuilder.append((Object)layer.getLayerType());
                Logger.warning(stringBuilder.toString());
                return null;
            }
            case 6: {
                return new TextLayer(lottieDrawable, layer);
            }
            case 5: {
                return new NullLayer(lottieDrawable, layer);
            }
            case 4: {
                return new ImageLayer(lottieDrawable, layer);
            }
            case 3: {
                return new SolidLayer(lottieDrawable, layer);
            }
            case 2: {
                return new CompositionLayer(lottieDrawable, layer, lottieComposition.getPrecomps(layer.getRefId()), lottieComposition);
            }
            case 1: 
        }
        return new ShapeLayer(lottieDrawable, layer);
    }

    private void intersectBoundsWithMask(RectF rectF, Matrix matrix) {
        this.maskBoundsRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (!this.hasMasksOnThisLayer()) {
            return;
        }
        int n = this.mask.getMasks().size();
        for (int i = 0; i < n; ++i) {
            Mask mask = (Mask)this.mask.getMasks().get(i);
            Path path = (Path)((BaseKeyframeAnimation)this.mask.getMaskAnimations().get(i)).getValue();
            this.path.set(path);
            this.path.transform(matrix);
            int n2 = 2.$SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[mask.getMaskMode().ordinal()];
            if (n2 != 1 && n2 != 2) {
                if ((n2 == 3 || n2 == 4) && mask.isInverted()) {
                    return;
                }
                this.path.computeBounds(this.tempMaskBoundsRect, false);
                if (i == 0) {
                    this.maskBoundsRect.set(this.tempMaskBoundsRect);
                    continue;
                }
                RectF rectF2 = this.maskBoundsRect;
                rectF2.set(Math.min((float)rectF2.left, (float)this.tempMaskBoundsRect.left), Math.min((float)this.maskBoundsRect.top, (float)this.tempMaskBoundsRect.top), Math.max((float)this.maskBoundsRect.right, (float)this.tempMaskBoundsRect.right), Math.max((float)this.maskBoundsRect.bottom, (float)this.tempMaskBoundsRect.bottom));
                continue;
            }
            return;
        }
        if (!rectF.intersect(this.maskBoundsRect)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void intersectBoundsWithMatte(RectF rectF, Matrix matrix) {
        if (!this.hasMatteOnThisLayer()) {
            return;
        }
        if (this.layerModel.getMatteType() == Layer.MatteType.INVERT) {
            return;
        }
        this.matteBoundsRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.matteLayer.getBounds(this.matteBoundsRect, matrix, true);
        if (!rectF.intersect(this.matteBoundsRect)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void invalidateSelf() {
        this.lottieDrawable.invalidateSelf();
    }

    private void recordRenderTime(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().recordRenderTime(this.layerModel.getName(), f);
    }

    private void setVisible(boolean bl) {
        if (bl != this.visible) {
            this.visible = bl;
            this.invalidateSelf();
        }
    }

    private void setupInOutAnimations() {
        boolean bl = this.layerModel.getInOutKeyframes().isEmpty();
        boolean bl2 = true;
        if (!bl) {
            FloatKeyframeAnimation floatKeyframeAnimation;
            this.inOutAnimation = floatKeyframeAnimation = new FloatKeyframeAnimation(this.layerModel.getInOutKeyframes());
            floatKeyframeAnimation.setIsDiscrete();
            this.inOutAnimation.addUpdateListener(new BaseKeyframeAnimation.AnimationListener(){

                @Override
                public void onValueChanged() {
                    BaseLayer baseLayer = BaseLayer.this;
                    boolean bl = baseLayer.inOutAnimation.getFloatValue() == 1.0f;
                    baseLayer.setVisible(bl);
                }
            });
            if (((Float)this.inOutAnimation.getValue()).floatValue() != 1.0f) {
                bl2 = false;
            }
            this.setVisible(bl2);
            this.addAnimation(this.inOutAnimation);
            return;
        }
        this.setVisible(bl2);
    }

    public void addAnimation(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        if (baseKeyframeAnimation == null) {
            return;
        }
        this.animations.add(baseKeyframeAnimation);
    }

    @Override
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        this.transform.applyValueCallback(t, lottieValueCallback);
    }

    @Override
    public void draw(Canvas canvas, Matrix matrix, int n) {
        L.beginSection(this.drawTraceName);
        if (this.visible && !this.layerModel.isHidden()) {
            this.buildParentLayerListIfNeeded();
            L.beginSection("Layer#parentMatrix");
            this.matrix.reset();
            this.matrix.set(matrix);
            for (int i = -1 + this.parentLayers.size(); i >= 0; --i) {
                this.matrix.preConcat(((BaseLayer)this.parentLayers.get((int)i)).transform.getMatrix());
            }
            L.endSection("Layer#parentMatrix");
            int n2 = this.transform.getOpacity() == null ? 100 : this.transform.getOpacity().getValue();
            int n3 = (int)(255.0f * ((float)n / 255.0f * (float)n2 / 100.0f));
            if (!this.hasMatteOnThisLayer() && !this.hasMasksOnThisLayer()) {
                this.matrix.preConcat(this.transform.getMatrix());
                L.beginSection("Layer#drawLayer");
                this.drawLayer(canvas, this.matrix, n3);
                L.endSection("Layer#drawLayer");
                this.recordRenderTime(L.endSection(this.drawTraceName));
                return;
            }
            L.beginSection("Layer#computeBounds");
            this.getBounds(this.rect, this.matrix, false);
            this.intersectBoundsWithMatte(this.rect, matrix);
            this.matrix.preConcat(this.transform.getMatrix());
            this.intersectBoundsWithMask(this.rect, this.matrix);
            if (!this.rect.intersect(0.0f, 0.0f, (float)canvas.getWidth(), (float)canvas.getHeight())) {
                this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            L.endSection("Layer#computeBounds");
            if (!this.rect.isEmpty()) {
                L.beginSection("Layer#saveLayer");
                this.contentPaint.setAlpha(255);
                Utils.saveLayerCompat(canvas, this.rect, this.contentPaint);
                L.endSection("Layer#saveLayer");
                this.clearCanvas(canvas);
                L.beginSection("Layer#drawLayer");
                this.drawLayer(canvas, this.matrix, n3);
                L.endSection("Layer#drawLayer");
                if (this.hasMasksOnThisLayer()) {
                    this.applyMasks(canvas, this.matrix);
                }
                if (this.hasMatteOnThisLayer()) {
                    L.beginSection("Layer#drawMatte");
                    L.beginSection("Layer#saveLayer");
                    Utils.saveLayerCompat(canvas, this.rect, this.mattePaint, 19);
                    L.endSection("Layer#saveLayer");
                    this.clearCanvas(canvas);
                    this.matteLayer.draw(canvas, matrix, n3);
                    L.beginSection("Layer#restoreLayer");
                    canvas.restore();
                    L.endSection("Layer#restoreLayer");
                    L.endSection("Layer#drawMatte");
                }
                L.beginSection("Layer#restoreLayer");
                canvas.restore();
                L.endSection("Layer#restoreLayer");
            }
            this.recordRenderTime(L.endSection(this.drawTraceName));
            return;
        }
        L.endSection(this.drawTraceName);
    }

    abstract void drawLayer(Canvas var1, Matrix var2, int var3);

    @Override
    public void getBounds(RectF rectF, Matrix matrix, boolean bl) {
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.buildParentLayerListIfNeeded();
        this.boundsMatrix.set(matrix);
        if (bl) {
            List<BaseLayer> list = this.parentLayers;
            if (list != null) {
                for (int i = -1 + list.size(); i >= 0; --i) {
                    this.boundsMatrix.preConcat(((BaseLayer)this.parentLayers.get((int)i)).transform.getMatrix());
                }
            } else {
                BaseLayer baseLayer = this.parentLayer;
                if (baseLayer != null) {
                    this.boundsMatrix.preConcat(baseLayer.transform.getMatrix());
                }
            }
        }
        this.boundsMatrix.preConcat(this.transform.getMatrix());
    }

    Layer getLayerModel() {
        return this.layerModel;
    }

    @Override
    public String getName() {
        return this.layerModel.getName();
    }

    boolean hasMasksOnThisLayer() {
        MaskKeyframeAnimation maskKeyframeAnimation = this.mask;
        return maskKeyframeAnimation != null && !maskKeyframeAnimation.getMaskAnimations().isEmpty();
    }

    boolean hasMatteOnThisLayer() {
        return this.matteLayer != null;
    }

    @Override
    public void onValueChanged() {
        this.invalidateSelf();
    }

    public void removeAnimation(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.animations.remove(baseKeyframeAnimation);
    }

    void resolveChildKeyPath(KeyPath keyPath, int n, List<KeyPath> list, KeyPath keyPath2) {
    }

    @Override
    public void resolveKeyPath(KeyPath keyPath, int n, List<KeyPath> list, KeyPath keyPath2) {
        if (!keyPath.matches(this.getName(), n)) {
            return;
        }
        if (!"__container".equals((Object)this.getName())) {
            keyPath2 = keyPath2.addKey(this.getName());
            if (keyPath.fullyResolvesTo(this.getName(), n)) {
                list.add((Object)keyPath2.resolve(this));
            }
        }
        if (keyPath.propagateToChildren(this.getName(), n)) {
            this.resolveChildKeyPath(keyPath, n + keyPath.incrementDepthBy(this.getName(), n), list, keyPath2);
        }
    }

    @Override
    public void setContents(List<Content> list, List<Content> list2) {
    }

    void setMatteLayer(BaseLayer baseLayer) {
        this.matteLayer = baseLayer;
    }

    void setParentLayer(BaseLayer baseLayer) {
        this.parentLayer = baseLayer;
    }

    void setProgress(float f) {
        FloatKeyframeAnimation floatKeyframeAnimation;
        this.transform.setProgress(f);
        if (this.mask != null) {
            for (int i = 0; i < this.mask.getMaskAnimations().size(); ++i) {
                ((BaseKeyframeAnimation)this.mask.getMaskAnimations().get(i)).setProgress(f);
            }
        }
        if (this.layerModel.getTimeStretch() != 0.0f) {
            f /= this.layerModel.getTimeStretch();
        }
        if ((floatKeyframeAnimation = this.inOutAnimation) != null) {
            floatKeyframeAnimation.setProgress(f / this.layerModel.getTimeStretch());
        }
        BaseLayer baseLayer = this.matteLayer;
        int n = 0;
        if (baseLayer != null) {
            float f2 = baseLayer.layerModel.getTimeStretch();
            this.matteLayer.setProgress(f2 * f);
        }
        while (n < this.animations.size()) {
            ((BaseKeyframeAnimation)this.animations.get(n)).setProgress(f);
            ++n;
        }
    }

}

