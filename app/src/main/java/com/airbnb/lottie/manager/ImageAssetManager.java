/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.view.View
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 */
package app.dukhaan.src.java.com.airbnb.lottie.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ImageAssetManager {
    private static final Object bitmapHashLock = new Object();
    private final Context context;
    private ImageAssetDelegate delegate;
    private final Map<String, LottieImageAsset> imageAssets;
    private String imagesFolder;

    public ImageAssetManager(Drawable.Callback callback, String string2, ImageAssetDelegate imageAssetDelegate, Map<String, LottieImageAsset> map) {
        String string3;
        this.imagesFolder = string2;
        if (!TextUtils.isEmpty((CharSequence)string2) && (string3 = this.imagesFolder).charAt(-1 + string3.length()) != '/') {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.imagesFolder);
            stringBuilder.append('/');
            this.imagesFolder = stringBuilder.toString();
        }
        if (!(callback instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.imageAssets = new HashMap();
            this.context = null;
            return;
        }
        this.context = ((View)callback).getContext();
        this.imageAssets = map;
        this.setDelegate(imageAssetDelegate);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Bitmap putBitmap(String string2, Bitmap bitmap) {
        Object object;
        Object object2 = object = bitmapHashLock;
        synchronized (object2) {
            ((LottieImageAsset)this.imageAssets.get((Object)string2)).setBitmap(bitmap);
            return bitmap;
        }
    }

    public Bitmap bitmapForId(String string2) {
        block10 : {
            InputStream inputStream;
            LottieImageAsset lottieImageAsset = (LottieImageAsset)this.imageAssets.get((Object)string2);
            if (lottieImageAsset == null) {
                return null;
            }
            Bitmap bitmap = lottieImageAsset.getBitmap();
            if (bitmap != null) {
                return bitmap;
            }
            ImageAssetDelegate imageAssetDelegate = this.delegate;
            if (imageAssetDelegate != null) {
                Bitmap bitmap2 = imageAssetDelegate.fetchBitmap(lottieImageAsset);
                if (bitmap2 != null) {
                    this.putBitmap(string2, bitmap2);
                }
                return bitmap2;
            }
            String string3 = lottieImageAsset.getFileName();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = true;
            options.inDensity = 160;
            if (string3.startsWith("data:") && string3.indexOf("base64,") > 0) {
                byte[] arrby;
                try {
                    arrby = Base64.decode((String)string3.substring(1 + string3.indexOf(44)), (int)0);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    Logger.warning("data URL did not have correct base64 format.", illegalArgumentException);
                    return null;
                }
                return this.putBitmap(string2, BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length, (BitmapFactory.Options)options));
            }
            try {
                if (TextUtils.isEmpty((CharSequence)this.imagesFolder)) break block10;
                AssetManager assetManager = this.context.getAssets();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.imagesFolder);
                stringBuilder.append(string3);
                inputStream = assetManager.open(stringBuilder.toString());
            }
            catch (IOException iOException) {
                Logger.warning("Unable to open asset.", iOException);
                return null;
            }
            return this.putBitmap(string2, Utils.resizeBitmapIfNeeded(BitmapFactory.decodeStream((InputStream)inputStream, null, (BitmapFactory.Options)options), lottieImageAsset.getWidth(), lottieImageAsset.getHeight()));
        }
        throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
    }

    public boolean hasSameContext(Context context) {
        return context == null && this.context == null || this.context.equals((Object)context);
    }

    public void setDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.delegate = imageAssetDelegate;
    }

    public Bitmap updateBitmap(String string2, Bitmap bitmap) {
        if (bitmap == null) {
            LottieImageAsset lottieImageAsset = (LottieImageAsset)this.imageAssets.get((Object)string2);
            Bitmap bitmap2 = lottieImageAsset.getBitmap();
            lottieImageAsset.setBitmap(null);
            return bitmap2;
        }
        Bitmap bitmap3 = ((LottieImageAsset)this.imageAssets.get((Object)string2)).getBitmap();
        this.putBitmap(string2, bitmap);
        return bitmap3;
    }
}

