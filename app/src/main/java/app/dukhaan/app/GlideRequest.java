/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.RequestBuilder
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.TransitionOptions
 *  com.bumptech.glide.load.DecodeFormat
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Option
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
 *  com.bumptech.glide.request.BaseRequestOptions
 *  com.bumptech.glide.request.RequestListener
 *  com.bumptech.glide.request.RequestOptions
 *  java.io.File
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Deprecated
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.SafeVarargs
 *  java.lang.String
 *  java.net.URL
 */
package app.dukhaan.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;

public class GlideRequest<TranscodeType>
extends RequestBuilder<TranscodeType>
implements Cloneable {
    GlideRequest(Glide glide, RequestManager requestManager, Class<TranscodeType> class_, Context context) {
        super(glide, requestManager, class_, context);
    }

    GlideRequest(Class<TranscodeType> class_, RequestBuilder<?> requestBuilder) {
        super(class_, requestBuilder);
    }

    public GlideRequest<TranscodeType> addListener(RequestListener<TranscodeType> requestListener) {
        return (GlideRequest)super.addListener(requestListener);
    }

    public GlideRequest<TranscodeType> apply(BaseRequestOptions<?> baseRequestOptions) {
        return (GlideRequest)super.apply(baseRequestOptions);
    }

    public GlideRequest<TranscodeType> centerCrop() {
        return (GlideRequest)super.centerCrop();
    }

    public GlideRequest<TranscodeType> centerInside() {
        return (GlideRequest)super.centerInside();
    }

    public GlideRequest<TranscodeType> circleCrop() {
        return (GlideRequest)super.circleCrop();
    }

    public GlideRequest<TranscodeType> clone() {
        return (GlideRequest)super.clone();
    }

    public GlideRequest<TranscodeType> decode(Class<?> class_) {
        return (GlideRequest)super.decode(class_);
    }

    public GlideRequest<TranscodeType> disallowHardwareConfig() {
        return (GlideRequest)super.disallowHardwareConfig();
    }

    public GlideRequest<TranscodeType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        return (GlideRequest)super.diskCacheStrategy(diskCacheStrategy);
    }

    public GlideRequest<TranscodeType> dontAnimate() {
        return (GlideRequest)super.dontAnimate();
    }

    public GlideRequest<TranscodeType> dontTransform() {
        return (GlideRequest)super.dontTransform();
    }

    public GlideRequest<TranscodeType> downsample(DownsampleStrategy downsampleStrategy) {
        return (GlideRequest)super.downsample(downsampleStrategy);
    }

    public GlideRequest<TranscodeType> encodeFormat(Bitmap.CompressFormat compressFormat) {
        return (GlideRequest)super.encodeFormat(compressFormat);
    }

    public GlideRequest<TranscodeType> encodeQuality(int n) {
        return (GlideRequest)super.encodeQuality(n);
    }

    public GlideRequest<TranscodeType> error(int n) {
        return (GlideRequest)super.error(n);
    }

    public GlideRequest<TranscodeType> error(Drawable drawable) {
        return (GlideRequest)super.error(drawable);
    }

    public GlideRequest<TranscodeType> error(RequestBuilder<TranscodeType> requestBuilder) {
        return (GlideRequest)super.error(requestBuilder);
    }

    public GlideRequest<TranscodeType> fallback(int n) {
        return (GlideRequest)super.fallback(n);
    }

    public GlideRequest<TranscodeType> fallback(Drawable drawable) {
        return (GlideRequest)super.fallback(drawable);
    }

    public GlideRequest<TranscodeType> fitCenter() {
        return (GlideRequest)super.fitCenter();
    }

    public GlideRequest<TranscodeType> format(DecodeFormat decodeFormat) {
        return (GlideRequest)super.format(decodeFormat);
    }

    public GlideRequest<TranscodeType> frame(long l) {
        return (GlideRequest)super.frame(l);
    }

    protected GlideRequest<File> getDownloadOnlyRequest() {
        return new GlideRequest<File>(File.class, this).apply((BaseRequestOptions)DOWNLOAD_ONLY_OPTIONS);
    }

    public GlideRequest<TranscodeType> listener(RequestListener<TranscodeType> requestListener) {
        return (GlideRequest)super.listener(requestListener);
    }

    public GlideRequest<TranscodeType> load(Bitmap bitmap) {
        return (GlideRequest)super.load(bitmap);
    }

    public GlideRequest<TranscodeType> load(Drawable drawable) {
        return (GlideRequest)super.load(drawable);
    }

    public GlideRequest<TranscodeType> load(Uri uri) {
        return (GlideRequest)super.load(uri);
    }

    public GlideRequest<TranscodeType> load(File file) {
        return (GlideRequest)super.load(file);
    }

    public GlideRequest<TranscodeType> load(Integer n) {
        return (GlideRequest)super.load(n);
    }

    public GlideRequest<TranscodeType> load(Object object) {
        return (GlideRequest)super.load(object);
    }

    public GlideRequest<TranscodeType> load(String string) {
        return (GlideRequest)super.load(string);
    }

    @Deprecated
    public GlideRequest<TranscodeType> load(URL uRL) {
        return (GlideRequest)super.load(uRL);
    }

    public GlideRequest<TranscodeType> load(byte[] arrby) {
        return (GlideRequest)super.load(arrby);
    }

    public GlideRequest<TranscodeType> onlyRetrieveFromCache(boolean bl) {
        return (GlideRequest)super.onlyRetrieveFromCache(bl);
    }

    public GlideRequest<TranscodeType> optionalCenterCrop() {
        return (GlideRequest)super.optionalCenterCrop();
    }

    public GlideRequest<TranscodeType> optionalCenterInside() {
        return (GlideRequest)super.optionalCenterInside();
    }

    public GlideRequest<TranscodeType> optionalCircleCrop() {
        return (GlideRequest)super.optionalCircleCrop();
    }

    public GlideRequest<TranscodeType> optionalFitCenter() {
        return (GlideRequest)super.optionalFitCenter();
    }

    public GlideRequest<TranscodeType> optionalTransform(Transformation<Bitmap> transformation) {
        return (GlideRequest)super.optionalTransform(transformation);
    }

    public <Y> GlideRequest<TranscodeType> optionalTransform(Class<Y> class_, Transformation<Y> transformation) {
        return (GlideRequest)super.optionalTransform(class_, transformation);
    }

    public GlideRequest<TranscodeType> override(int n) {
        return (GlideRequest)super.override(n);
    }

    public GlideRequest<TranscodeType> override(int n, int n2) {
        return (GlideRequest)super.override(n, n2);
    }

    public GlideRequest<TranscodeType> placeholder(int n) {
        return (GlideRequest)super.placeholder(n);
    }

    public GlideRequest<TranscodeType> placeholder(Drawable drawable) {
        return (GlideRequest)super.placeholder(drawable);
    }

    public GlideRequest<TranscodeType> priority(Priority priority) {
        return (GlideRequest)super.priority(priority);
    }

    public <Y> GlideRequest<TranscodeType> set(Option<Y> option, Y y) {
        return (GlideRequest)super.set(option, y);
    }

    public GlideRequest<TranscodeType> signature(Key key) {
        return (GlideRequest)super.signature(key);
    }

    public GlideRequest<TranscodeType> sizeMultiplier(float f) {
        return (GlideRequest)super.sizeMultiplier(f);
    }

    public GlideRequest<TranscodeType> skipMemoryCache(boolean bl) {
        return (GlideRequest)super.skipMemoryCache(bl);
    }

    public GlideRequest<TranscodeType> theme(Resources.Theme theme) {
        return (GlideRequest)super.theme(theme);
    }

    public GlideRequest<TranscodeType> thumbnail(float f) {
        return (GlideRequest)super.thumbnail(f);
    }

    public GlideRequest<TranscodeType> thumbnail(RequestBuilder<TranscodeType> requestBuilder) {
        return (GlideRequest)super.thumbnail(requestBuilder);
    }

    @SafeVarargs
    public final /* varargs */ GlideRequest<TranscodeType> thumbnail(RequestBuilder<TranscodeType> ... arrrequestBuilder) {
        return (GlideRequest)super.thumbnail(arrrequestBuilder);
    }

    public GlideRequest<TranscodeType> timeout(int n) {
        return (GlideRequest)super.timeout(n);
    }

    public GlideRequest<TranscodeType> transform(Transformation<Bitmap> transformation) {
        return (GlideRequest)super.transform(transformation);
    }

    public <Y> GlideRequest<TranscodeType> transform(Class<Y> class_, Transformation<Y> transformation) {
        return (GlideRequest)super.transform(class_, transformation);
    }

    public /* varargs */ GlideRequest<TranscodeType> transform(Transformation<Bitmap> ... arrtransformation) {
        return (GlideRequest)super.transform(arrtransformation);
    }

    @Deprecated
    public /* varargs */ GlideRequest<TranscodeType> transforms(Transformation<Bitmap> ... arrtransformation) {
        return (GlideRequest)super.transforms(arrtransformation);
    }

    public GlideRequest<TranscodeType> transition(TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        return (GlideRequest)super.transition(transitionOptions);
    }

    public GlideRequest<TranscodeType> useAnimationPool(boolean bl) {
        return (GlideRequest)super.useAnimationPool(bl);
    }

    public GlideRequest<TranscodeType> useUnlimitedSourceGeneratorsPool(boolean bl) {
        return (GlideRequest)super.useUnlimitedSourceGeneratorsPool(bl);
    }
}

