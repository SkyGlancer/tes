/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  android.graphics.RectF
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 *  java.util.ListIterator
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.content.GreedyContent;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class RepeaterContent
implements DrawingContent,
PathContent,
GreedyContent,
BaseKeyframeAnimation.AnimationListener,
KeyPathElementContent {
    private ContentGroup contentGroup;
    private final BaseKeyframeAnimation<Float, Float> copies;
    private final boolean hidden;
    private final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix = new Matrix();
    private final String name;
    private final BaseKeyframeAnimation<Float, Float> offset;
    private final Path path = new Path();
    private final TransformKeyframeAnimation transform;

    public RepeaterContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Repeater repeater) {
        TransformKeyframeAnimation transformKeyframeAnimation;
        this.lottieDrawable = lottieDrawable;
        this.layer = baseLayer;
        this.name = repeater.getName();
        this.hidden = repeater.isHidden();
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = repeater.getCopies().createAnimation();
        this.copies = baseKeyframeAnimation;
        baseLayer.addAnimation(baseKeyframeAnimation);
        this.copies.addUpdateListener(this);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = repeater.getOffset().createAnimation();
        this.offset = baseKeyframeAnimation2;
        baseLayer.addAnimation(baseKeyframeAnimation2);
        this.offset.addUpdateListener(this);
        this.transform = transformKeyframeAnimation = repeater.getTransform().createAnimation();
        transformKeyframeAnimation.addAnimationsToLayer(baseLayer);
        this.transform.addListener(this);
    }

    @Override
    public void absorbContent(ListIterator<Content> listIterator) {
        ContentGroup contentGroup;
        if (this.contentGroup != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse((List)arrayList);
        this.contentGroup = contentGroup = new ContentGroup(this.lottieDrawable, this.layer, "Repeater", this.hidden, (List<Content>)arrayList, null);
    }

    @Override
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (this.transform.applyValueCallback(t, lottieValueCallback)) {
            return;
        }
        if (t == LottieProperty.REPEATER_COPIES) {
            this.copies.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.REPEATER_OFFSET) {
            this.offset.setValueCallback(lottieValueCallback);
        }
    }

    @Override
    public void draw(Canvas canvas, Matrix matrix, int n) {
        float f = this.copies.getValue().floatValue();
        float f2 = this.offset.getValue().floatValue();
        float f3 = this.transform.getStartOpacity().getValue().floatValue() / 100.0f;
        float f4 = this.transform.getEndOpacity().getValue().floatValue() / 100.0f;
        for (int i = -1 + (int)f; i >= 0; --i) {
            this.matrix.set(matrix);
            Matrix matrix2 = this.matrix;
            TransformKeyframeAnimation transformKeyframeAnimation = this.transform;
            float f5 = i;
            matrix2.preConcat(transformKeyframeAnimation.getMatrixForRepeater(f5 + f2));
            float f6 = (float)n * MiscUtils.lerp(f3, f4, f5 / f);
            this.contentGroup.draw(canvas, this.matrix, (int)f6);
        }
    }

    @Override
    public void getBounds(RectF rectF, Matrix matrix, boolean bl) {
        this.contentGroup.getBounds(rectF, matrix, bl);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Path getPath() {
        Path path = this.contentGroup.getPath();
        this.path.reset();
        float f = this.copies.getValue().floatValue();
        float f2 = this.offset.getValue().floatValue();
        for (int i = -1 + (int)f; i >= 0; --i) {
            this.matrix.set(this.transform.getMatrixForRepeater(f2 + (float)i));
            this.path.addPath(path, this.matrix);
        }
        return this.path;
    }

    @Override
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override
    public void resolveKeyPath(KeyPath keyPath, int n, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, n, list, keyPath2, this);
    }

    @Override
    public void setContents(List<Content> list, List<Content> list2) {
        this.contentGroup.setContents(list, list2);
    }
}

