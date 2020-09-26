/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.Typeface
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  androidx.collection.SparseArrayCompat
 *  com.airbnb.lottie.LottieDrawable$10
 *  com.airbnb.lottie.LottieDrawable$11
 *  com.airbnb.lottie.LottieDrawable$12
 *  com.airbnb.lottie.LottieDrawable$13
 *  com.airbnb.lottie.LottieDrawable$14
 *  com.airbnb.lottie.LottieDrawable$15
 *  com.airbnb.lottie.LottieDrawable$16
 *  com.airbnb.lottie.LottieDrawable$17
 *  com.airbnb.lottie.LottieDrawable$2
 *  com.airbnb.lottie.LottieDrawable$3
 *  com.airbnb.lottie.LottieDrawable$4
 *  com.airbnb.lottie.LottieDrawable$5
 *  com.airbnb.lottie.LottieDrawable$6
 *  com.airbnb.lottie.LottieDrawable$7
 *  com.airbnb.lottie.LottieDrawable$8
 *  com.airbnb.lottie.LottieDrawable$9
 *  com.airbnb.lottie.TextDelegate
 *  com.airbnb.lottie.manager.FontAssetManager
 *  com.airbnb.lottie.manager.ImageAssetManager
 *  com.airbnb.lottie.model.FontCharacter
 *  com.airbnb.lottie.model.KeyPath
 *  com.airbnb.lottie.model.KeyPathElement
 *  com.airbnb.lottie.model.Marker
 *  com.airbnb.lottie.model.layer.CompositionLayer
 *  com.airbnb.lottie.model.layer.Layer
 *  com.airbnb.lottie.parser.LayerParser
 *  com.airbnb.lottie.utils.Logger
 *  com.airbnb.lottie.utils.LottieValueAnimator
 *  com.airbnb.lottie.utils.MiscUtils
 *  com.airbnb.lottie.value.LottieValueCallback
 *  com.airbnb.lottie.value.SimpleLottieValueCallback
 *  java.lang.Boolean
 *  java.lang.Deprecated
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.annotation.Annotation
 *  java.lang.annotation.Retention
 *  java.lang.annotation.RetentionPolicy
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package app.dukhaan.src.java.com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.PerformanceTracker;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottieDrawable
extends Drawable
implements Drawable.Callback,
Animatable {
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private static final String TAG = LottieDrawable.class.getSimpleName();
    private int alpha;
    private final LottieValueAnimator animator = new LottieValueAnimator();
    private final Set<ColorFilterData> colorFilterData = new HashSet();
    private LottieComposition composition;
    private CompositionLayer compositionLayer;
    private boolean enableMergePaths;
    FontAssetDelegate fontAssetDelegate;
    private FontAssetManager fontAssetManager;
    private ImageAssetDelegate imageAssetDelegate;
    private ImageAssetManager imageAssetManager;
    private String imageAssetsFolder;
    private boolean isApplyingOpacityToLayersEnabled;
    private boolean isDirty;
    private boolean isExtraScaleEnabled;
    private final ArrayList<LazyCompositionTask> lazyCompositionTasks = new ArrayList();
    private final Matrix matrix = new Matrix();
    private boolean performanceTrackingEnabled;
    private final ValueAnimator.AnimatorUpdateListener progressUpdateListener;
    private boolean safeMode = false;
    private float scale = 1.0f;
    private ImageView.ScaleType scaleType;
    private boolean systemAnimationsEnabled = true;
    TextDelegate textDelegate;

    public LottieDrawable() {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
        this.progressUpdateListener = animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(){

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (LottieDrawable.this.compositionLayer != null) {
                    LottieDrawable.this.compositionLayer.setProgress(LottieDrawable.this.animator.getAnimatedValueAbsolute());
                }
            }
        };
        this.alpha = 255;
        this.isExtraScaleEnabled = true;
        this.isDirty = false;
        this.animator.addUpdateListener(animatorUpdateListener);
    }

    private void buildCompositionLayer() {
        this.compositionLayer = new CompositionLayer(this, LayerParser.parse((LottieComposition)this.composition), this.composition.getLayers(), this.composition);
    }

    private void drawInternal(Canvas canvas) {
        if (ImageView.ScaleType.FIT_XY == this.scaleType) {
            this.drawWithNewAspectRatio(canvas);
            return;
        }
        this.drawWithOriginalAspectRatio(canvas);
    }

    private void drawWithNewAspectRatio(Canvas canvas) {
        if (this.compositionLayer == null) {
            return;
        }
        int n = -1;
        Rect rect = this.getBounds();
        float f = (float)rect.width() / (float)this.composition.getBounds().width();
        float f2 = (float)rect.height() / (float)this.composition.getBounds().height();
        if (this.isExtraScaleEnabled) {
            float f3;
            float f4 = Math.min((float)f, (float)f2);
            if (f4 < 1.0f) {
                f3 = 1.0f / f4;
                f /= f3;
                f2 /= f3;
            } else {
                f3 = 1.0f;
            }
            if (f3 > 1.0f) {
                n = canvas.save();
                float f5 = (float)rect.width() / 2.0f;
                float f6 = (float)rect.height() / 2.0f;
                float f7 = f5 * f4;
                float f8 = f4 * f6;
                canvas.translate(f5 - f7, f6 - f8);
                canvas.scale(f3, f3, f7, f8);
            }
        }
        this.matrix.reset();
        this.matrix.preScale(f, f2);
        this.compositionLayer.draw(canvas, this.matrix, this.alpha);
        if (n > 0) {
            canvas.restoreToCount(n);
        }
    }

    private void drawWithOriginalAspectRatio(Canvas canvas) {
        float f;
        if (this.compositionLayer == null) {
            return;
        }
        float f2 = this.scale;
        float f3 = this.getMaxScale(canvas);
        if (f2 > f3) {
            f = this.scale / f3;
        } else {
            f3 = f2;
            f = 1.0f;
        }
        int n = -1;
        if (f > 1.0f) {
            n = canvas.save();
            float f4 = (float)this.composition.getBounds().width() / 2.0f;
            float f5 = (float)this.composition.getBounds().height() / 2.0f;
            float f6 = f4 * f3;
            float f7 = f5 * f3;
            canvas.translate(f4 * this.getScale() - f6, f5 * this.getScale() - f7);
            canvas.scale(f, f, f6, f7);
        }
        this.matrix.reset();
        this.matrix.preScale(f3, f3);
        this.compositionLayer.draw(canvas, this.matrix, this.alpha);
        if (n > 0) {
            canvas.restoreToCount(n);
        }
    }

    private Context getContext() {
        Callback callback = this.getCallback();
        if (callback == null) {
            return null;
        }
        if (callback instanceof View) {
            return ((View)callback).getContext();
        }
        return null;
    }

    private FontAssetManager getFontAssetManager() {
        if (this.getCallback() == null) {
            return null;
        }
        if (this.fontAssetManager == null) {
            this.fontAssetManager = new FontAssetManager(this.getCallback(), this.fontAssetDelegate);
        }
        return this.fontAssetManager;
    }

    private ImageAssetManager getImageAssetManager() {
        if (this.getCallback() == null) {
            return null;
        }
        ImageAssetManager imageAssetManager = this.imageAssetManager;
        if (imageAssetManager != null && !imageAssetManager.hasSameContext(this.getContext())) {
            this.imageAssetManager = null;
        }
        if (this.imageAssetManager == null) {
            this.imageAssetManager = new ImageAssetManager(this.getCallback(), this.imageAssetsFolder, this.imageAssetDelegate, this.composition.getImages());
        }
        return this.imageAssetManager;
    }

    private float getMaxScale(Canvas canvas) {
        return Math.min((float)((float)canvas.getWidth() / (float)this.composition.getBounds().width()), (float)((float)canvas.getHeight() / (float)this.composition.getBounds().height()));
    }

    private void updateBounds() {
        if (this.composition == null) {
            return;
        }
        float f = this.getScale();
        this.setBounds(0, 0, (int)(f * (float)this.composition.getBounds().width()), (int)(f * (float)this.composition.getBounds().height()));
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.animator.addListener(animatorListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.animator.addUpdateListener(animatorUpdateListener);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, LottieValueCallback<T> lottieValueCallback) {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add((Object)new 16(this, keyPath, t, lottieValueCallback));
            return;
        }
        KeyPath keyPath2 = KeyPath.COMPOSITION;
        boolean bl = true;
        if (keyPath == keyPath2) {
            this.compositionLayer.addValueCallback(t, lottieValueCallback);
        } else if (keyPath.getResolvedElement() != null) {
            keyPath.getResolvedElement().addValueCallback(t, lottieValueCallback);
        } else {
            List<KeyPath> list = this.resolveKeyPath(keyPath);
            for (int i = 0; i < list.size(); ++i) {
                ((KeyPath)list.get(i)).getResolvedElement().addValueCallback(t, lottieValueCallback);
            }
            bl ^= list.isEmpty();
        }
        if (bl) {
            this.invalidateSelf();
            if (t == LottieProperty.TIME_REMAP) {
                this.setProgress(this.getProgress());
            }
        }
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        this.addValueCallback(keyPath, t, (LottieValueCallback<T>)new 17(this, simpleLottieValueCallback));
    }

    public void cancelAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.cancel();
    }

    public void clearComposition() {
        if (this.animator.isRunning()) {
            this.animator.cancel();
        }
        this.composition = null;
        this.compositionLayer = null;
        this.imageAssetManager = null;
        this.animator.clearComposition();
        this.invalidateSelf();
    }

    public void disableExtraScaleModeInFitXY() {
        this.isExtraScaleEnabled = false;
    }

    public void draw(Canvas canvas) {
        this.isDirty = false;
        L.beginSection("Drawable#draw");
        if (this.safeMode) {
            try {
                this.drawInternal(canvas);
            }
            catch (Throwable throwable) {
                Logger.error((String)"Lottie crashed in draw!", (Throwable)throwable);
            }
        } else {
            this.drawInternal(canvas);
        }
        L.endSection("Drawable#draw");
    }

    public void enableMergePathsForKitKatAndAbove(boolean bl) {
        if (this.enableMergePaths == bl) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            Logger.warning((String)"Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.enableMergePaths = bl;
        if (this.composition != null) {
            this.buildCompositionLayer();
        }
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public void endAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.endAnimation();
    }

    public int getAlpha() {
        return this.alpha;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public int getFrame() {
        return (int)this.animator.getFrame();
    }

    public Bitmap getImageAsset(String string2) {
        ImageAssetManager imageAssetManager = this.getImageAssetManager();
        if (imageAssetManager != null) {
            return imageAssetManager.bitmapForId(string2);
        }
        return null;
    }

    public String getImageAssetsFolder() {
        return this.imageAssetsFolder;
    }

    public int getIntrinsicHeight() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return -1;
        }
        return (int)((float)lottieComposition.getBounds().height() * this.getScale());
    }

    public int getIntrinsicWidth() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return -1;
        }
        return (int)((float)lottieComposition.getBounds().width() * this.getScale());
    }

    public float getMaxFrame() {
        return this.animator.getMaxFrame();
    }

    public float getMinFrame() {
        return this.animator.getMinFrame();
    }

    public int getOpacity() {
        return -3;
    }

    public PerformanceTracker getPerformanceTracker() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            return lottieComposition.getPerformanceTracker();
        }
        return null;
    }

    public float getProgress() {
        return this.animator.getAnimatedValueAbsolute();
    }

    public int getRepeatCount() {
        return this.animator.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.animator.getRepeatMode();
    }

    public float getScale() {
        return this.scale;
    }

    public float getSpeed() {
        return this.animator.getSpeed();
    }

    public TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public Typeface getTypeface(String string2, String string3) {
        FontAssetManager fontAssetManager = this.getFontAssetManager();
        if (fontAssetManager != null) {
            return fontAssetManager.getTypeface(string2, string3);
        }
        return null;
    }

    public boolean hasMasks() {
        CompositionLayer compositionLayer = this.compositionLayer;
        return compositionLayer != null && compositionLayer.hasMasks();
    }

    public boolean hasMatte() {
        CompositionLayer compositionLayer = this.compositionLayer;
        return compositionLayer != null && compositionLayer.hasMatte();
    }

    public void invalidateDrawable(Drawable drawable2) {
        Callback callback = this.getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable((Drawable)this);
    }

    public void invalidateSelf() {
        if (this.isDirty) {
            return;
        }
        this.isDirty = true;
        Callback callback = this.getCallback();
        if (callback != null) {
            callback.invalidateDrawable((Drawable)this);
        }
    }

    public boolean isAnimating() {
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.isRunning();
    }

    public boolean isApplyingOpacityToLayersEnabled() {
        return this.isApplyingOpacityToLayersEnabled;
    }

    public boolean isLooping() {
        return this.animator.getRepeatCount() == -1;
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public boolean isRunning() {
        return this.isAnimating();
    }

    @Deprecated
    public void loop(boolean bl) {
        LottieValueAnimator lottieValueAnimator = this.animator;
        int n = bl ? -1 : 0;
        lottieValueAnimator.setRepeatCount(n);
    }

    public void pauseAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.pauseAnimation();
    }

    public void playAnimation() {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add((Object)new 2(this));
            return;
        }
        if (this.systemAnimationsEnabled || this.getRepeatCount() == 0) {
            this.animator.playAnimation();
        }
        if (!this.systemAnimationsEnabled) {
            float f = this.getSpeed() < 0.0f ? this.getMinFrame() : this.getMaxFrame();
            this.setFrame((int)f);
            this.animator.endAnimation();
        }
    }

    public void removeAllAnimatorListeners() {
        this.animator.removeAllListeners();
    }

    public void removeAllUpdateListeners() {
        this.animator.removeAllUpdateListeners();
        this.animator.addUpdateListener(this.progressUpdateListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.animator.removeListener(animatorListener);
    }

    public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.animator.removeUpdateListener(animatorUpdateListener);
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        if (this.compositionLayer == null) {
            Logger.warning((String)"Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.compositionLayer.resolveKeyPath(keyPath, 0, (List)arrayList, new KeyPath(new String[0]));
        return arrayList;
    }

    public void resumeAnimation() {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add((Object)new 3(this));
            return;
        }
        if (this.systemAnimationsEnabled || this.getRepeatCount() == 0) {
            this.animator.resumeAnimation();
        }
        if (!this.systemAnimationsEnabled) {
            float f = this.getSpeed() < 0.0f ? this.getMinFrame() : this.getMaxFrame();
            this.setFrame((int)f);
            this.animator.endAnimation();
        }
    }

    public void reverseAnimationSpeed() {
        this.animator.reverseAnimationSpeed();
    }

    public void scheduleDrawable(Drawable drawable2, Runnable runnable, long l) {
        Callback callback = this.getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable((Drawable)this, runnable, l);
    }

    public void setAlpha(int n) {
        this.alpha = n;
        this.invalidateSelf();
    }

    public void setApplyingOpacityToLayersEnabled(boolean bl) {
        this.isApplyingOpacityToLayersEnabled = bl;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Logger.warning((String)"Use addColorFilter instead.");
    }

    public boolean setComposition(LottieComposition lottieComposition) {
        if (this.composition == lottieComposition) {
            return false;
        }
        this.isDirty = false;
        this.clearComposition();
        this.composition = lottieComposition;
        this.buildCompositionLayer();
        this.animator.setComposition(lottieComposition);
        this.setProgress(this.animator.getAnimatedFraction());
        this.setScale(this.scale);
        this.updateBounds();
        Iterator iterator = new ArrayList(this.lazyCompositionTasks).iterator();
        while (iterator.hasNext()) {
            ((LazyCompositionTask)iterator.next()).run(lottieComposition);
            iterator.remove();
        }
        this.lazyCompositionTasks.clear();
        lottieComposition.setPerformanceTrackingEnabled(this.performanceTrackingEnabled);
        Callback callback = this.getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView)callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable((Drawable)this);
        }
        return true;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.fontAssetDelegate = fontAssetDelegate;
        FontAssetManager fontAssetManager = this.fontAssetManager;
        if (fontAssetManager != null) {
            fontAssetManager.setDelegate(fontAssetDelegate);
        }
    }

    public void setFrame(int n) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add((Object)new 14(this, n));
            return;
        }
        this.animator.setFrame((float)n);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.imageAssetDelegate = imageAssetDelegate;
        ImageAssetManager imageAssetManager = this.imageAssetManager;
        if (imageAssetManager != null) {
            imageAssetManager.setDelegate(imageAssetDelegate);
        }
    }

    public void setImagesAssetsFolder(String string2) {
        this.imageAssetsFolder = string2;
    }

    public void setMaxFrame(int n) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add((Object)new 6(this, n));
            return;
        }
        this.animator.setMaxFrame(0.99f + (float)n);
    }

    public void setMaxFrame(String string2) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add((Object)new 9(this, string2));
            return;
        }
        Marker marker = lottieComposition.getMarker(string2);
        if (marker != null) {
            this.setMaxFrame((int)(marker.startFrame + marker.durationFrames));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find marker with name ");
        stringBuilder.append(string2);
        stringBuilder.append(".");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setMaxProgress(float f) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add((Object)new 7(this, f));
            return;
        }
        this.setMaxFrame((int)MiscUtils.lerp((float)lottieComposition.getStartFrame(), (float)this.composition.getEndFrame(), (float)f));
    }

    public void setMinAndMaxFrame(int n, int n2) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add((Object)new 12(this, n, n2));
            return;
        }
        this.animator.setMinAndMaxFrames((float)n, 0.99f + (float)n2);
    }

    public void setMinAndMaxFrame(String string2) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add((Object)new 10(this, string2));
            return;
        }
        Marker marker = lottieComposition.getMarker(string2);
        if (marker != null) {
            int n = (int)marker.startFrame;
            this.setMinAndMaxFrame(n, n + (int)marker.durationFrames);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find marker with name ");
        stringBuilder.append(string2);
        stringBuilder.append(".");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setMinAndMaxFrame(String string2, String string3, boolean bl) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add((Object)new 11(this, string2, string3, bl));
            return;
        }
        Marker marker = lottieComposition.getMarker(string2);
        if (marker != null) {
            int n = (int)marker.startFrame;
            Marker marker2 = this.composition.getMarker(string3);
            if (string3 != null) {
                float f = marker2.startFrame;
                float f2 = bl ? 1.0f : 0.0f;
                this.setMinAndMaxFrame(n, (int)(f + f2));
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot find marker with name ");
            stringBuilder.append(string3);
            stringBuilder.append(".");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find marker with name ");
        stringBuilder.append(string2);
        stringBuilder.append(".");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setMinAndMaxProgress(float f, float f2) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add((Object)new 13(this, f, f2));
            return;
        }
        this.setMinAndMaxFrame((int)MiscUtils.lerp((float)lottieComposition.getStartFrame(), (float)this.composition.getEndFrame(), (float)f), (int)MiscUtils.lerp((float)this.composition.getStartFrame(), (float)this.composition.getEndFrame(), (float)f2));
    }

    public void setMinFrame(int n) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add((Object)new 4(this, n));
            return;
        }
        this.animator.setMinFrame(n);
    }

    public void setMinFrame(String string2) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add((Object)new 8(this, string2));
            return;
        }
        Marker marker = lottieComposition.getMarker(string2);
        if (marker != null) {
            this.setMinFrame((int)marker.startFrame);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find marker with name ");
        stringBuilder.append(string2);
        stringBuilder.append(".");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setMinProgress(float f) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add((Object)new 5(this, f));
            return;
        }
        this.setMinFrame((int)MiscUtils.lerp((float)lottieComposition.getStartFrame(), (float)this.composition.getEndFrame(), (float)f));
    }

    public void setPerformanceTrackingEnabled(boolean bl) {
        this.performanceTrackingEnabled = bl;
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            lottieComposition.setPerformanceTrackingEnabled(bl);
        }
    }

    public void setProgress(float f) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add((Object)new 15(this, f));
            return;
        }
        L.beginSection("Drawable#setProgress");
        this.animator.setFrame(MiscUtils.lerp((float)this.composition.getStartFrame(), (float)this.composition.getEndFrame(), (float)f));
        L.endSection("Drawable#setProgress");
    }

    public void setRepeatCount(int n) {
        this.animator.setRepeatCount(n);
    }

    public void setRepeatMode(int n) {
        this.animator.setRepeatMode(n);
    }

    public void setSafeMode(boolean bl) {
        this.safeMode = bl;
    }

    public void setScale(float f) {
        this.scale = f;
        this.updateBounds();
    }

    void setScaleType(ImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
    }

    public void setSpeed(float f) {
        this.animator.setSpeed(f);
    }

    void setSystemAnimationsAreEnabled(Boolean bl) {
        this.systemAnimationsEnabled = bl;
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.textDelegate = textDelegate;
    }

    public void start() {
        this.playAnimation();
    }

    public void stop() {
        this.endAnimation();
    }

    public void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
        Callback callback = this.getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable((Drawable)this, runnable);
    }

    public Bitmap updateBitmap(String string2, Bitmap bitmap) {
        ImageAssetManager imageAssetManager = this.getImageAssetManager();
        if (imageAssetManager == null) {
            Logger.warning((String)"Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmap2 = imageAssetManager.updateBitmap(string2, bitmap);
        this.invalidateSelf();
        return bitmap2;
    }

    public boolean useTextGlyphs() {
        return this.textDelegate == null && this.composition.getCharacters().size() > 0;
    }

    private static class ColorFilterData {
        final ColorFilter colorFilter;
        final String contentName;
        final String layerName;

        ColorFilterData(String string2, String string3, ColorFilter colorFilter) {
            this.layerName = string2;
            this.contentName = string3;
            this.colorFilter = colorFilter;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof ColorFilterData)) {
                return false;
            }
            ColorFilterData colorFilterData = (ColorFilterData)object;
            return this.hashCode() == colorFilterData.hashCode() && this.colorFilter == colorFilterData.colorFilter;
        }

        public int hashCode() {
            String string2 = this.layerName;
            int n = string2 != null ? 527 * string2.hashCode() : 17;
            String string3 = this.contentName;
            if (string3 != null) {
                n = n * 31 * string3.hashCode();
            }
            return n;
        }
    }

    private static interface LazyCompositionTask {
        public void run(LottieComposition var1);
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface RepeatMode {
    }

}

