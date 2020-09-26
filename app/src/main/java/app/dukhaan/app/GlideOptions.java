/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.drawable.Drawable
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.DecodeFormat
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Option
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
 *  com.bumptech.glide.request.BaseRequestOptions
 *  com.bumptech.glide.request.RequestOptions
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.SafeVarargs
 */
package app.dukhaan.app;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

public final class GlideOptions
extends RequestOptions
implements Cloneable {
    private static GlideOptions centerCropTransform2;
    private static GlideOptions centerInsideTransform1;
    private static GlideOptions circleCropTransform3;
    private static GlideOptions fitCenterTransform0;
    private static GlideOptions noAnimation5;
    private static GlideOptions noTransformation4;

    public static GlideOptions bitmapTransform(Transformation<Bitmap> transformation) {
        return new GlideOptions().transform(transformation);
    }

    public static GlideOptions centerCropTransform() {
        if (centerCropTransform2 == null) {
            centerCropTransform2 = new GlideOptions().centerCrop().autoClone();
        }
        return centerCropTransform2;
    }

    public static GlideOptions centerInsideTransform() {
        if (centerInsideTransform1 == null) {
            centerInsideTransform1 = new GlideOptions().centerInside().autoClone();
        }
        return centerInsideTransform1;
    }

    public static GlideOptions circleCropTransform() {
        if (circleCropTransform3 == null) {
            circleCropTransform3 = new GlideOptions().circleCrop().autoClone();
        }
        return circleCropTransform3;
    }

    public static GlideOptions decodeTypeOf(Class<?> class_) {
        return new GlideOptions().decode(class_);
    }

    public static GlideOptions diskCacheStrategyOf(DiskCacheStrategy diskCacheStrategy) {
        return new GlideOptions().diskCacheStrategy(diskCacheStrategy);
    }

    public static GlideOptions downsampleOf(DownsampleStrategy downsampleStrategy) {
        return new GlideOptions().downsample(downsampleStrategy);
    }

    public static GlideOptions encodeFormatOf(Bitmap.CompressFormat compressFormat) {
        return new GlideOptions().encodeFormat(compressFormat);
    }

    public static GlideOptions encodeQualityOf(int n) {
        return new GlideOptions().encodeQuality(n);
    }

    public static GlideOptions errorOf(int n) {
        return new GlideOptions().error(n);
    }

    public static GlideOptions errorOf(Drawable drawable) {
        return new GlideOptions().error(drawable);
    }

    public static GlideOptions fitCenterTransform() {
        if (fitCenterTransform0 == null) {
            fitCenterTransform0 = new GlideOptions().fitCenter().autoClone();
        }
        return fitCenterTransform0;
    }

    public static GlideOptions formatOf(DecodeFormat decodeFormat) {
        return new GlideOptions().format(decodeFormat);
    }

    public static GlideOptions frameOf(long l) {
        return new GlideOptions().frame(l);
    }

    public static GlideOptions noAnimation() {
        if (noAnimation5 == null) {
            noAnimation5 = new GlideOptions().dontAnimate().autoClone();
        }
        return noAnimation5;
    }

    public static GlideOptions noTransformation() {
        if (noTransformation4 == null) {
            noTransformation4 = new GlideOptions().dontTransform().autoClone();
        }
        return noTransformation4;
    }

    public static <T> GlideOptions option(Option<T> option, T t) {
        return new GlideOptions().set((Option<Y>)option, (Y)t);
    }

    public static GlideOptions overrideOf(int n) {
        return new GlideOptions().override(n);
    }

    public static GlideOptions overrideOf(int n, int n2) {
        return new GlideOptions().override(n, n2);
    }

    public static GlideOptions placeholderOf(int n) {
        return new GlideOptions().placeholder(n);
    }

    public static GlideOptions placeholderOf(Drawable drawable) {
        return new GlideOptions().placeholder(drawable);
    }

    public static GlideOptions priorityOf(Priority priority) {
        return new GlideOptions().priority(priority);
    }

    public static GlideOptions signatureOf(Key key) {
        return new GlideOptions().signature(key);
    }

    public static GlideOptions sizeMultiplierOf(float f) {
        return new GlideOptions().sizeMultiplier(f);
    }

    public static GlideOptions skipMemoryCacheOf(boolean bl) {
        return new GlideOptions().skipMemoryCache(bl);
    }

    public static GlideOptions timeoutOf(int n) {
        return new GlideOptions().timeout(n);
    }

    public GlideOptions apply(BaseRequestOptions<?> baseRequestOptions) {
        return (GlideOptions)super.apply(baseRequestOptions);
    }

    public GlideOptions autoClone() {
        return (GlideOptions)super.autoClone();
    }

    public GlideOptions centerCrop() {
        return (GlideOptions)super.centerCrop();
    }

    public GlideOptions centerInside() {
        return (GlideOptions)super.centerInside();
    }

    public GlideOptions circleCrop() {
        return (GlideOptions)super.circleCrop();
    }

    public GlideOptions clone() {
        return (GlideOptions)super.clone();
    }

    public GlideOptions decode(Class<?> class_) {
        return (GlideOptions)super.decode(class_);
    }

    public GlideOptions disallowHardwareConfig() {
        return (GlideOptions)super.disallowHardwareConfig();
    }

    public GlideOptions diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        return (GlideOptions)super.diskCacheStrategy(diskCacheStrategy);
    }

    public GlideOptions dontAnimate() {
        return (GlideOptions)super.dontAnimate();
    }

    public GlideOptions dontTransform() {
        return (GlideOptions)super.dontTransform();
    }

    public GlideOptions downsample(DownsampleStrategy downsampleStrategy) {
        return (GlideOptions)super.downsample(downsampleStrategy);
    }

    public GlideOptions encodeFormat(Bitmap.CompressFormat compressFormat) {
        return (GlideOptions)super.encodeFormat(compressFormat);
    }

    public GlideOptions encodeQuality(int n) {
        return (GlideOptions)super.encodeQuality(n);
    }

    public GlideOptions error(int n) {
        return (GlideOptions)super.error(n);
    }

    public GlideOptions error(Drawable drawable) {
        return (GlideOptions)super.error(drawable);
    }

    public GlideOptions fallback(int n) {
        return (GlideOptions)super.fallback(n);
    }

    public GlideOptions fallback(Drawable drawable) {
        return (GlideOptions)super.fallback(drawable);
    }

    public GlideOptions fitCenter() {
        return (GlideOptions)super.fitCenter();
    }

    public GlideOptions format(DecodeFormat decodeFormat) {
        return (GlideOptions)super.format(decodeFormat);
    }

    public GlideOptions frame(long l) {
        return (GlideOptions)super.frame(l);
    }

    public GlideOptions lock() {
        return (GlideOptions)super.lock();
    }

    public GlideOptions onlyRetrieveFromCache(boolean bl) {
        return (GlideOptions)super.onlyRetrieveFromCache(bl);
    }

    public GlideOptions optionalCenterCrop() {
        return (GlideOptions)super.optionalCenterCrop();
    }

    public GlideOptions optionalCenterInside() {
        return (GlideOptions)super.optionalCenterInside();
    }

    public GlideOptions optionalCircleCrop() {
        return (GlideOptions)super.optionalCircleCrop();
    }

    public GlideOptions optionalFitCenter() {
        return (GlideOptions)super.optionalFitCenter();
    }

    public GlideOptions optionalTransform(Transformation<Bitmap> transformation) {
        return (GlideOptions)super.optionalTransform(transformation);
    }

    public <Y> GlideOptions optionalTransform(Class<Y> class_, Transformation<Y> transformation) {
        return (GlideOptions)super.optionalTransform(class_, transformation);
    }

    public GlideOptions override(int n) {
        return (GlideOptions)super.override(n);
    }

    public GlideOptions override(int n, int n2) {
        return (GlideOptions)super.override(n, n2);
    }

    public GlideOptions placeholder(int n) {
        return (GlideOptions)super.placeholder(n);
    }

    public GlideOptions placeholder(Drawable drawable) {
        return (GlideOptions)super.placeholder(drawable);
    }

    public GlideOptions priority(Priority priority) {
        return (GlideOptions)super.priority(priority);
    }

    public <Y> GlideOptions set(Option<Y> option, Y y) {
        return (GlideOptions)super.set(option, y);
    }

    public GlideOptions signature(Key key) {
        return (GlideOptions)super.signature(key);
    }

    public GlideOptions sizeMultiplier(float f) {
        return (GlideOptions)super.sizeMultiplier(f);
    }

    public GlideOptions skipMemoryCache(boolean bl) {
        return (GlideOptions)super.skipMemoryCache(bl);
    }

    public GlideOptions theme(Resources.Theme theme) {
        return (GlideOptions)super.theme(theme);
    }

    public GlideOptions timeout(int n) {
        return (GlideOptions)super.timeout(n);
    }

    public GlideOptions transform(Transformation<Bitmap> transformation) {
        return (GlideOptions)super.transform(transformation);
    }

    public <Y> GlideOptions transform(Class<Y> class_, Transformation<Y> transformation) {
        return (GlideOptions)super.transform(class_, transformation);
    }

    @SafeVarargs
    public final /* varargs */ GlideOptions transform(Transformation<Bitmap> ... arrtransformation) {
        return (GlideOptions)super.transform(arrtransformation);
    }

    @Deprecated
    @SafeVarargs
    public final /* varargs */ GlideOptions transforms(Transformation<Bitmap> ... arrtransformation) {
        return (GlideOptions)super.transforms(arrtransformation);
    }

    public GlideOptions useAnimationPool(boolean bl) {
        return (GlideOptions)super.useAnimationPool(bl);
    }

    public GlideOptions useUnlimitedSourceGeneratorsPool(boolean bl) {
        return (GlideOptions)super.useUnlimitedSourceGeneratorsPool(bl);
    }
}

