/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.RequestBuilder
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.load.resource.gif.GifDrawable
 *  com.bumptech.glide.manager.Lifecycle
 *  com.bumptech.glide.manager.RequestManagerTreeNode
 *  com.bumptech.glide.request.BaseRequestOptions
 *  com.bumptech.glide.request.RequestListener
 *  com.bumptech.glide.request.RequestOptions
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URL
 */
package app.dukhaan.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import app.dukhaan.app.GlideOptions;
import app.dukhaan.app.GlideRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;

public class GlideRequests
extends RequestManager {
    public GlideRequests(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        super(glide, lifecycle, requestManagerTreeNode, context);
    }

    public GlideRequests addDefaultRequestListener(RequestListener<Object> requestListener) {
        return (GlideRequests)super.addDefaultRequestListener(requestListener);
    }

    public GlideRequests applyDefaultRequestOptions(RequestOptions requestOptions) {
        GlideRequests glideRequests = this;
        synchronized (glideRequests) {
            GlideRequests glideRequests2 = (GlideRequests)super.applyDefaultRequestOptions(requestOptions);
            return glideRequests2;
        }
    }

    public <ResourceType> GlideRequest<ResourceType> as(Class<ResourceType> class_) {
        return new GlideRequest<ResourceType>(this.glide, this, class_, this.context);
    }

    public GlideRequest<Bitmap> asBitmap() {
        return (GlideRequest)super.asBitmap();
    }

    public GlideRequest<Drawable> asDrawable() {
        return (GlideRequest)super.asDrawable();
    }

    public GlideRequest<File> asFile() {
        return (GlideRequest)super.asFile();
    }

    public GlideRequest<GifDrawable> asGif() {
        return (GlideRequest)super.asGif();
    }

    public GlideRequest<File> download(Object object) {
        return (GlideRequest)super.download(object);
    }

    public GlideRequest<File> downloadOnly() {
        return (GlideRequest)super.downloadOnly();
    }

    public GlideRequest<Drawable> load(Bitmap bitmap) {
        return (GlideRequest)super.load(bitmap);
    }

    public GlideRequest<Drawable> load(Drawable drawable) {
        return (GlideRequest)super.load(drawable);
    }

    public GlideRequest<Drawable> load(Uri uri) {
        return (GlideRequest)super.load(uri);
    }

    public GlideRequest<Drawable> load(File file) {
        return (GlideRequest)super.load(file);
    }

    public GlideRequest<Drawable> load(Integer n) {
        return (GlideRequest)super.load(n);
    }

    public GlideRequest<Drawable> load(Object object) {
        return (GlideRequest)super.load(object);
    }

    public GlideRequest<Drawable> load(String string) {
        return (GlideRequest)super.load(string);
    }

    @Deprecated
    public GlideRequest<Drawable> load(URL uRL) {
        return (GlideRequest)super.load(uRL);
    }

    public GlideRequest<Drawable> load(byte[] arrby) {
        return (GlideRequest)super.load(arrby);
    }

    public GlideRequests setDefaultRequestOptions(RequestOptions requestOptions) {
        GlideRequests glideRequests = this;
        synchronized (glideRequests) {
            GlideRequests glideRequests2 = (GlideRequests)super.setDefaultRequestOptions(requestOptions);
            return glideRequests2;
        }
    }

    protected void setRequestOptions(RequestOptions requestOptions) {
        if (requestOptions instanceof GlideOptions) {
            super.setRequestOptions(requestOptions);
            return;
        }
        super.setRequestOptions((RequestOptions)new GlideOptions().apply((BaseRequestOptions<?>)requestOptions));
    }
}

