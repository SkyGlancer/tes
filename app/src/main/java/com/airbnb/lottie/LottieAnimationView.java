/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.View
 *  android.view.View$BaseSavedState
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  androidx.appcompat.widget.AppCompatImageView
 *  androidx.core.view.ViewCompat
 *  java.io.ByteArrayInputStream
 *  java.io.InputStream
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 */
package app.dukhaan.src.java.com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.LottieTask;
import com.airbnb.lottie.PerformanceTracker;
import com.airbnb.lottie.R;
import com.airbnb.lottie.RenderMode;
import com.airbnb.lottie.SimpleColorFilter;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LottieAnimationView
extends AppCompatImageView {
    private static final LottieListener<Throwable> DEFAULT_FAILURE_LISTENER;
    private static final String TAG;
    private String animationName;
    private int animationResId;
    private boolean autoPlay = false;
    private int buildDrawingCacheDepth = 0;
    private boolean cacheComposition = true;
    private LottieComposition composition;
    private LottieTask<LottieComposition> compositionTask;
    private LottieListener<Throwable> failureListener;
    private int fallbackResource = 0;
    private boolean isInitialized;
    private final LottieListener<LottieComposition> loadedListener = new LottieListener<LottieComposition>(){

        @Override
        public void onResult(LottieComposition lottieComposition) {
            LottieAnimationView.this.setComposition(lottieComposition);
        }
    };
    private final LottieDrawable lottieDrawable = new LottieDrawable();
    private Set<LottieOnCompositionLoadedListener> lottieOnCompositionLoadedListeners = new HashSet();
    private boolean playAnimationWhenShown = false;
    private RenderMode renderMode = RenderMode.AUTOMATIC;
    private boolean wasAnimatingWhenDetached = false;
    private boolean wasAnimatingWhenNotShown = false;
    private final LottieListener<Throwable> wrappedFailureListener = new LottieListener<Throwable>(){

        @Override
        public void onResult(Throwable throwable) {
            if (LottieAnimationView.this.fallbackResource != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
            }
            LottieListener lottieListener = LottieAnimationView.this.failureListener == null ? DEFAULT_FAILURE_LISTENER : LottieAnimationView.this.failureListener;
            lottieListener.onResult(throwable);
        }
    };

    static {
        TAG = LottieAnimationView.class.getSimpleName();
        DEFAULT_FAILURE_LISTENER = new LottieListener<Throwable>(){

            @Override
            public void onResult(Throwable throwable) {
                if (Utils.isNetworkException(throwable)) {
                    Logger.warning("Unable to load composition.", throwable);
                    return;
                }
                throw new IllegalStateException("Unable to parse composition", throwable);
            }
        };
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.init(null, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(attributeSet, n);
    }

    private void cancelLoaderTask() {
        LottieTask<LottieComposition> lottieTask = this.compositionTask;
        if (lottieTask != null) {
            lottieTask.removeListener(this.loadedListener);
            this.compositionTask.removeFailureListener(this.wrappedFailureListener);
        }
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.clearComposition();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void enableOrDisableHardwareLayer() {
        LottieComposition lottieComposition;
        LottieComposition lottieComposition2;
        boolean bl;
        int n = 5.$SwitchMap$com$airbnb$lottie$RenderMode[this.renderMode.ordinal()];
        int n2 = 2;
        if (!(n == 1 || n != n2 && n == 3 && (bl = (lottieComposition2 = this.composition) != null && lottieComposition2.hasDashPattern() && Build.VERSION.SDK_INT < 28 ? false : ((lottieComposition = this.composition) != null && lottieComposition.getMaskAndMatteCount() > 4 ? false : Build.VERSION.SDK_INT >= 21)))) {
            n2 = 1;
        }
        if (n2 != this.getLayerType()) {
            this.setLayerType(n2, null);
        }
    }

    private void init(AttributeSet attributeSet, int n) {
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView, n, 0);
        if (!this.isInEditMode()) {
            String string2;
            this.cacheComposition = typedArray.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
            boolean bl = typedArray.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
            boolean bl2 = typedArray.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
            boolean bl3 = typedArray.hasValue(R.styleable.LottieAnimationView_lottie_url);
            if (bl && bl2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (bl) {
                int n2 = typedArray.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
                if (n2 != 0) {
                    this.setAnimation(n2);
                }
            } else if (bl2) {
                String string3 = typedArray.getString(R.styleable.LottieAnimationView_lottie_fileName);
                if (string3 != null) {
                    this.setAnimation(string3);
                }
            } else if (bl3 && (string2 = typedArray.getString(R.styleable.LottieAnimationView_lottie_url)) != null) {
                this.setAnimationFromUrl(string2);
            }
            this.setFallbackResource(typedArray.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        }
        if (typedArray.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.wasAnimatingWhenDetached = true;
            this.autoPlay = true;
        }
        if (typedArray.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.lottieDrawable.setRepeatCount(-1);
        }
        if (typedArray.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode)) {
            this.setRepeatMode(typedArray.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (typedArray.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount)) {
            this.setRepeatCount(typedArray.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (typedArray.hasValue(R.styleable.LottieAnimationView_lottie_speed)) {
            this.setSpeed(typedArray.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        this.setImageAssetsFolder(typedArray.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        this.setProgress(typedArray.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        this.enableMergePathsForKitKatAndAbove(typedArray.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (typedArray.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
            SimpleColorFilter simpleColorFilter = new SimpleColorFilter(typedArray.getColor(R.styleable.LottieAnimationView_lottie_colorFilter, 0));
            KeyPath keyPath = new KeyPath("**");
            LottieValueCallback<SimpleColorFilter> lottieValueCallback = new LottieValueCallback<SimpleColorFilter>(simpleColorFilter);
            this.addValueCallback(keyPath, (T)LottieProperty.COLOR_FILTER, lottieValueCallback);
        }
        if (typedArray.hasValue(R.styleable.LottieAnimationView_lottie_scale)) {
            this.lottieDrawable.setScale(typedArray.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0f));
        }
        if (typedArray.hasValue(R.styleable.LottieAnimationView_lottie_renderMode)) {
            int n3 = typedArray.getInt(R.styleable.LottieAnimationView_lottie_renderMode, RenderMode.AUTOMATIC.ordinal());
            if (n3 >= RenderMode.values().length) {
                n3 = RenderMode.AUTOMATIC.ordinal();
            }
            this.setRenderMode(RenderMode.values()[n3]);
        }
        if (this.getScaleType() != null) {
            this.lottieDrawable.setScaleType(this.getScaleType());
        }
        typedArray.recycle();
        LottieDrawable lottieDrawable = this.lottieDrawable;
        float f = Utils.getAnimationScale(this.getContext()) FCMPL 0.0f;
        boolean bl = false;
        if (f != false) {
            bl = true;
        }
        lottieDrawable.setSystemAnimationsAreEnabled(bl);
        this.enableOrDisableHardwareLayer();
        this.isInitialized = true;
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        this.clearComposition();
        this.cancelLoaderTask();
        this.compositionTask = lottieTask.addListener(this.loadedListener).addFailureListener(this.wrappedFailureListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.addAnimatorListener(animatorListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            lottieOnCompositionLoadedListener.onCompositionLoaded(lottieComposition);
        }
        return this.lottieOnCompositionLoadedListeners.add((Object)lottieOnCompositionLoadedListener);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, LottieValueCallback<T> lottieValueCallback) {
        this.lottieDrawable.addValueCallback(keyPath, t, lottieValueCallback);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, final SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        this.lottieDrawable.addValueCallback(keyPath, t, new LottieValueCallback<T>(){

            @Override
            public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
                return simpleLottieValueCallback.getValue(lottieFrameInfo);
            }
        });
    }

    public void buildDrawingCache(boolean bl) {
        L.beginSection("buildDrawingCache");
        this.buildDrawingCacheDepth = 1 + this.buildDrawingCacheDepth;
        super.buildDrawingCache(bl);
        if (this.buildDrawingCacheDepth == 1 && this.getWidth() > 0 && this.getHeight() > 0 && this.getLayerType() == 1 && this.getDrawingCache(bl) == null) {
            this.setRenderMode(RenderMode.HARDWARE);
        }
        --this.buildDrawingCacheDepth;
        L.endSection("buildDrawingCache");
    }

    public void cancelAnimation() {
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        this.lottieDrawable.cancelAnimation();
        this.enableOrDisableHardwareLayer();
    }

    public void disableExtraScaleModeInFitXY() {
        this.lottieDrawable.disableExtraScaleModeInFitXY();
    }

    public void enableMergePathsForKitKatAndAbove(boolean bl) {
        this.lottieDrawable.enableMergePathsForKitKatAndAbove(bl);
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            return (long)lottieComposition.getDuration();
        }
        return 0L;
    }

    public int getFrame() {
        return this.lottieDrawable.getFrame();
    }

    public String getImageAssetsFolder() {
        return this.lottieDrawable.getImageAssetsFolder();
    }

    public float getMaxFrame() {
        return this.lottieDrawable.getMaxFrame();
    }

    public float getMinFrame() {
        return this.lottieDrawable.getMinFrame();
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.lottieDrawable.getPerformanceTracker();
    }

    public float getProgress() {
        return this.lottieDrawable.getProgress();
    }

    public int getRepeatCount() {
        return this.lottieDrawable.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.getRepeatMode();
    }

    public float getScale() {
        return this.lottieDrawable.getScale();
    }

    public float getSpeed() {
        return this.lottieDrawable.getSpeed();
    }

    public boolean hasMasks() {
        return this.lottieDrawable.hasMasks();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.hasMatte();
    }

    public void invalidateDrawable(Drawable drawable2) {
        LottieDrawable lottieDrawable;
        Drawable drawable3 = this.getDrawable();
        if (drawable3 == (lottieDrawable = this.lottieDrawable)) {
            super.invalidateDrawable((Drawable)lottieDrawable);
            return;
        }
        super.invalidateDrawable(drawable2);
    }

    public boolean isAnimating() {
        return this.lottieDrawable.isAnimating();
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.isMergePathsEnabledForKitKatAndAbove();
    }

    @Deprecated
    public void loop(boolean bl) {
        LottieDrawable lottieDrawable = this.lottieDrawable;
        int n = bl ? -1 : 0;
        lottieDrawable.setRepeatCount(n);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay || this.wasAnimatingWhenDetached) {
            this.playAnimation();
            this.autoPlay = false;
            this.wasAnimatingWhenDetached = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            this.onVisibilityChanged((View)this, this.getVisibility());
        }
    }

    protected void onDetachedFromWindow() {
        if (this.isAnimating()) {
            this.cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        super.onDetachedFromWindow();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        String string2;
        int n;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.animationName = string2 = savedState.animationName;
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            this.setAnimation(this.animationName);
        }
        this.animationResId = n = savedState.animationResId;
        if (n != 0) {
            this.setAnimation(n);
        }
        this.setProgress(savedState.progress);
        if (savedState.isAnimating) {
            this.playAnimation();
        }
        this.lottieDrawable.setImagesAssetsFolder(savedState.imageAssetsFolder);
        this.setRepeatMode(savedState.repeatMode);
        this.setRepeatCount(savedState.repeatCount);
    }

    protected Parcelable onSaveInstanceState() {
        BaseSavedState baseSavedState = new BaseSavedState(super.onSaveInstanceState()){
            public static final Creator<SavedState> CREATOR = new Creator<SavedState>(){

                public SavedState createFromParcel(Parcel parcel) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public SavedState[] newArray(int n) {
                    return new SavedState[n];
                }
            };
            String animationName;
            int animationResId;
            String imageAssetsFolder;
            boolean isAnimating;
            float progress;
            int repeatCount;
            int repeatMode;
            {
                this.animationName = parcel.readString();
                this.progress = parcel.readFloat();
                int n = parcel.readInt();
                int n2 = 1;
                if (n != n2) {
                    n2 = 0;
                }
                this.isAnimating = n2;
                this.imageAssetsFolder = parcel.readString();
                this.repeatMode = parcel.readInt();
                this.repeatCount = parcel.readInt();
            }

            public void writeToParcel(Parcel parcel, int n) {
                super.writeToParcel(parcel, n);
                parcel.writeString(this.animationName);
                parcel.writeFloat(this.progress);
                parcel.writeInt((int)this.isAnimating);
                parcel.writeString(this.imageAssetsFolder);
                parcel.writeInt(this.repeatMode);
                parcel.writeInt(this.repeatCount);
            }

        };
        baseSavedState.animationName = this.animationName;
        baseSavedState.animationResId = this.animationResId;
        baseSavedState.progress = this.lottieDrawable.getProgress();
        boolean bl = this.lottieDrawable.isAnimating() || !ViewCompat.isAttachedToWindow((View)this) && this.wasAnimatingWhenDetached;
        baseSavedState.isAnimating = bl;
        baseSavedState.imageAssetsFolder = this.lottieDrawable.getImageAssetsFolder();
        baseSavedState.repeatMode = this.lottieDrawable.getRepeatMode();
        baseSavedState.repeatCount = this.lottieDrawable.getRepeatCount();
        return baseSavedState;
    }

    protected void onVisibilityChanged(View view, int n) {
        if (!this.isInitialized) {
            return;
        }
        if (this.isShown()) {
            if (this.wasAnimatingWhenNotShown) {
                this.resumeAnimation();
            } else if (this.playAnimationWhenShown) {
                this.playAnimation();
            }
            this.wasAnimatingWhenNotShown = false;
            this.playAnimationWhenShown = false;
            return;
        }
        if (this.isAnimating()) {
            this.pauseAnimation();
            this.wasAnimatingWhenNotShown = true;
        }
    }

    public void pauseAnimation() {
        this.autoPlay = false;
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        this.lottieDrawable.pauseAnimation();
        this.enableOrDisableHardwareLayer();
    }

    public void playAnimation() {
        if (this.isShown()) {
            this.lottieDrawable.playAnimation();
            this.enableOrDisableHardwareLayer();
            return;
        }
        this.playAnimationWhenShown = true;
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.removeAllAnimatorListeners();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.removeAllUpdateListeners();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.removeAnimatorListener(animatorListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.lottieOnCompositionLoadedListeners.remove((Object)lottieOnCompositionLoadedListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.removeAnimatorUpdateListener(animatorUpdateListener);
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        return this.lottieDrawable.resolveKeyPath(keyPath);
    }

    public void resumeAnimation() {
        if (this.isShown()) {
            this.lottieDrawable.resumeAnimation();
            this.enableOrDisableHardwareLayer();
            return;
        }
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = true;
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.reverseAnimationSpeed();
    }

    public void setAnimation(int n) {
        this.animationResId = n;
        this.animationName = null;
        LottieTask<LottieComposition> lottieTask = this.cacheComposition ? LottieCompositionFactory.fromRawRes(this.getContext(), n) : LottieCompositionFactory.fromRawRes(this.getContext(), n, null);
        this.setCompositionTask(lottieTask);
    }

    public void setAnimation(InputStream inputStream, String string2) {
        this.setCompositionTask(LottieCompositionFactory.fromJsonInputStream(inputStream, string2));
    }

    public void setAnimation(String string2) {
        this.animationName = string2;
        this.animationResId = 0;
        LottieTask<LottieComposition> lottieTask = this.cacheComposition ? LottieCompositionFactory.fromAsset(this.getContext(), string2) : LottieCompositionFactory.fromAsset(this.getContext(), string2, null);
        this.setCompositionTask(lottieTask);
    }

    @Deprecated
    public void setAnimationFromJson(String string2) {
        this.setAnimationFromJson(string2, null);
    }

    public void setAnimationFromJson(String string2, String string3) {
        this.setAnimation((InputStream)new ByteArrayInputStream(string2.getBytes()), string3);
    }

    public void setAnimationFromUrl(String string2) {
        LottieTask<LottieComposition> lottieTask = this.cacheComposition ? LottieCompositionFactory.fromUrl(this.getContext(), string2) : LottieCompositionFactory.fromUrl(this.getContext(), string2, null);
        this.setCompositionTask(lottieTask);
    }

    public void setAnimationFromUrl(String string2, String string3) {
        this.setCompositionTask(LottieCompositionFactory.fromUrl(this.getContext(), string2, string3));
    }

    public void setApplyingOpacityToLayersEnabled(boolean bl) {
        this.lottieDrawable.setApplyingOpacityToLayersEnabled(bl);
    }

    public void setCacheComposition(boolean bl) {
        this.cacheComposition = bl;
    }

    public void setComposition(LottieComposition lottieComposition) {
        if (L.DBG) {
            String string2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Set Composition \n");
            stringBuilder.append((Object)lottieComposition);
            Log.v((String)string2, (String)stringBuilder.toString());
        }
        this.lottieDrawable.setCallback((Drawable.Callback)this);
        this.composition = lottieComposition;
        boolean bl = this.lottieDrawable.setComposition(lottieComposition);
        this.enableOrDisableHardwareLayer();
        if (this.getDrawable() == this.lottieDrawable && !bl) {
            return;
        }
        this.onVisibilityChanged((View)this, this.getVisibility());
        this.requestLayout();
        Iterator iterator = this.lottieOnCompositionLoadedListeners.iterator();
        while (iterator.hasNext()) {
            ((LottieOnCompositionLoadedListener)iterator.next()).onCompositionLoaded(lottieComposition);
        }
    }

    public void setFailureListener(LottieListener<Throwable> lottieListener) {
        this.failureListener = lottieListener;
    }

    public void setFallbackResource(int n) {
        this.fallbackResource = n;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.lottieDrawable.setFontAssetDelegate(fontAssetDelegate);
    }

    public void setFrame(int n) {
        this.lottieDrawable.setFrame(n);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.lottieDrawable.setImageAssetDelegate(imageAssetDelegate);
    }

    public void setImageAssetsFolder(String string2) {
        this.lottieDrawable.setImagesAssetsFolder(string2);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable2) {
        this.cancelLoaderTask();
        super.setImageDrawable(drawable2);
    }

    public void setImageResource(int n) {
        this.cancelLoaderTask();
        super.setImageResource(n);
    }

    public void setMaxFrame(int n) {
        this.lottieDrawable.setMaxFrame(n);
    }

    public void setMaxFrame(String string2) {
        this.lottieDrawable.setMaxFrame(string2);
    }

    public void setMaxProgress(float f) {
        this.lottieDrawable.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(int n, int n2) {
        this.lottieDrawable.setMinAndMaxFrame(n, n2);
    }

    public void setMinAndMaxFrame(String string2) {
        this.lottieDrawable.setMinAndMaxFrame(string2);
    }

    public void setMinAndMaxFrame(String string2, String string3, boolean bl) {
        this.lottieDrawable.setMinAndMaxFrame(string2, string3, bl);
    }

    public void setMinAndMaxProgress(float f, float f2) {
        this.lottieDrawable.setMinAndMaxProgress(f, f2);
    }

    public void setMinFrame(int n) {
        this.lottieDrawable.setMinFrame(n);
    }

    public void setMinFrame(String string2) {
        this.lottieDrawable.setMinFrame(string2);
    }

    public void setMinProgress(float f) {
        this.lottieDrawable.setMinProgress(f);
    }

    public void setPerformanceTrackingEnabled(boolean bl) {
        this.lottieDrawable.setPerformanceTrackingEnabled(bl);
    }

    public void setProgress(float f) {
        this.lottieDrawable.setProgress(f);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.renderMode = renderMode;
        this.enableOrDisableHardwareLayer();
    }

    public void setRepeatCount(int n) {
        this.lottieDrawable.setRepeatCount(n);
    }

    public void setRepeatMode(int n) {
        this.lottieDrawable.setRepeatMode(n);
    }

    public void setSafeMode(boolean bl) {
        this.lottieDrawable.setSafeMode(bl);
    }

    public void setScale(float f) {
        this.lottieDrawable.setScale(f);
        if (this.getDrawable() == this.lottieDrawable) {
            this.setImageDrawable(null);
            this.setImageDrawable(this.lottieDrawable);
        }
    }

    public void setScaleType(ScaleType scaleType) {
        super.setScaleType(scaleType);
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (lottieDrawable != null) {
            lottieDrawable.setScaleType(scaleType);
        }
    }

    public void setSpeed(float f) {
        this.lottieDrawable.setSpeed(f);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.lottieDrawable.setTextDelegate(textDelegate);
    }

    public Bitmap updateBitmap(String string2, Bitmap bitmap) {
        return this.lottieDrawable.updateBitmap(string2, bitmap);
    }

}

