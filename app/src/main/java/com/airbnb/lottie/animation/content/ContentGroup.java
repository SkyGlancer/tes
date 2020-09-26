/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.RectF
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.ListIterator
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.content.GreedyContent;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class ContentGroup
implements DrawingContent,
PathContent,
BaseKeyframeAnimation.AnimationListener,
KeyPathElement {
    private final List<Content> contents;
    private final boolean hidden;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix = new Matrix();
    private final String name;
    private Paint offScreenPaint = new LPaint();
    private RectF offScreenRectF = new RectF();
    private final Path path = new Path();
    private List<PathContent> pathContents;
    private final RectF rect = new RectF();
    private TransformKeyframeAnimation transformAnimation;

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeGroup shapeGroup) {
        this(lottieDrawable, baseLayer, shapeGroup.getName(), shapeGroup.isHidden(), ContentGroup.contentsFromModels(lottieDrawable, baseLayer, shapeGroup.getItems()), ContentGroup.findTransform(shapeGroup.getItems()));
    }

    ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, String string2, boolean bl, List<Content> list, AnimatableTransform animatableTransform) {
        this.name = string2;
        this.lottieDrawable = lottieDrawable;
        this.hidden = bl;
        this.contents = list;
        if (animatableTransform != null) {
            TransformKeyframeAnimation transformKeyframeAnimation;
            this.transformAnimation = transformKeyframeAnimation = animatableTransform.createAnimation();
            transformKeyframeAnimation.addAnimationsToLayer(baseLayer);
            this.transformAnimation.addListener(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = -1 + list.size(); i >= 0; --i) {
            Content content = (Content)list.get(i);
            if (!(content instanceof GreedyContent)) continue;
            arrayList.add((Object)((GreedyContent)((Object)content)));
        }
        for (int i = -1 + arrayList.size(); i >= 0; --i) {
            ((GreedyContent)arrayList.get(i)).absorbContent((ListIterator<Content>)list.listIterator(list.size()));
        }
    }

    private static List<Content> contentsFromModels(LottieDrawable lottieDrawable, BaseLayer baseLayer, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); ++i) {
            Content content = ((ContentModel)list.get(i)).toContent(lottieDrawable, baseLayer);
            if (content == null) continue;
            arrayList.add((Object)content);
        }
        return arrayList;
    }

    static AnimatableTransform findTransform(List<ContentModel> list) {
        for (int i = 0; i < list.size(); ++i) {
            ContentModel contentModel = (ContentModel)list.get(i);
            if (!(contentModel instanceof AnimatableTransform)) continue;
            return (AnimatableTransform)contentModel;
        }
        return null;
    }

    private boolean hasTwoOrMoreDrawableContent() {
        int n = 0;
        for (int i = 0; i < this.contents.size(); ++i) {
            if (!(this.contents.get(i) instanceof DrawingContent) || ++n < 2) continue;
            return true;
        }
        return false;
    }

    @Override
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.applyValueCallback(t, lottieValueCallback);
        }
    }

    @Override
    public void draw(Canvas canvas, Matrix matrix, int n) {
        boolean bl;
        if (this.hidden) {
            return;
        }
        this.matrix.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            this.matrix.preConcat(transformKeyframeAnimation.getMatrix());
            int n2 = this.transformAnimation.getOpacity() == null ? 100 : this.transformAnimation.getOpacity().getValue();
            n = (int)(255.0f * ((float)n2 / 100.0f * (float)n / 255.0f));
        }
        if (bl = this.lottieDrawable.isApplyingOpacityToLayersEnabled() && this.hasTwoOrMoreDrawableContent() && n != 255) {
            this.offScreenRectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.getBounds(this.offScreenRectF, this.matrix, true);
            this.offScreenPaint.setAlpha(n);
            Utils.saveLayerCompat(canvas, this.offScreenRectF, this.offScreenPaint);
        }
        if (bl) {
            n = 255;
        }
        for (int i = this.contents.size() - 1; i >= 0; --i) {
            Object object = this.contents.get(i);
            if (!(object instanceof DrawingContent)) continue;
            ((DrawingContent)object).draw(canvas, this.matrix, n);
        }
        if (bl) {
            canvas.restore();
        }
    }

    @Override
    public void getBounds(RectF rectF, Matrix matrix, boolean bl) {
        this.matrix.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            this.matrix.preConcat(transformKeyframeAnimation.getMatrix());
        }
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int i = -1 + this.contents.size(); i >= 0; --i) {
            Content content = (Content)this.contents.get(i);
            if (!(content instanceof DrawingContent)) continue;
            ((DrawingContent)content).getBounds(this.rect, this.matrix, bl);
            rectF.union(this.rect);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Path getPath() {
        this.matrix.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            this.matrix.set(transformKeyframeAnimation.getMatrix());
        }
        this.path.reset();
        if (this.hidden) {
            return this.path;
        }
        for (int i = -1 + this.contents.size(); i >= 0; --i) {
            Content content = (Content)this.contents.get(i);
            if (!(content instanceof PathContent)) continue;
            this.path.addPath(((PathContent)content).getPath(), this.matrix);
        }
        return this.path;
    }

    List<PathContent> getPathList() {
        if (this.pathContents == null) {
            this.pathContents = new ArrayList();
            for (int i = 0; i < this.contents.size(); ++i) {
                Content content = (Content)this.contents.get(i);
                if (!(content instanceof PathContent)) continue;
                this.pathContents.add((Object)((PathContent)content));
            }
        }
        return this.pathContents;
    }

    Matrix getTransformationMatrix() {
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            return transformKeyframeAnimation.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    @Override
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
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
            int n2 = n + keyPath.incrementDepthBy(this.getName(), n);
            for (int i = 0; i < this.contents.size(); ++i) {
                Content content = (Content)this.contents.get(i);
                if (!(content instanceof KeyPathElement)) continue;
                ((KeyPathElement)((Object)content)).resolveKeyPath(keyPath, n2, list, keyPath2);
            }
        }
    }

    @Override
    public void setContents(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.contents.size());
        arrayList.addAll(list);
        for (int i = -1 + this.contents.size(); i >= 0; --i) {
            Content content = (Content)this.contents.get(i);
            content.setContents((List<Content>)arrayList, (List<Content>)this.contents.subList(0, i));
            arrayList.add((Object)content);
        }
    }
}

