/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  com.airbnb.lottie.LottieCompositionFactory$10
 *  com.airbnb.lottie.LottieCompositionFactory$11
 *  com.airbnb.lottie.model.LottieCompositionCache
 *  com.airbnb.lottie.network.NetworkCache
 *  com.airbnb.lottie.network.NetworkFetcher
 *  com.airbnb.lottie.parser.LottieCompositionMoshiParser
 *  com.airbnb.lottie.parser.moshi.JsonReader
 *  com.airbnb.lottie.utils.Utils
 *  java.io.ByteArrayInputStream
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.Callable
 *  java.util.zip.ZipEntry
 *  java.util.zip.ZipInputStream
 *  okio.BufferedSource
 *  okio.Okio
 *  okio.Source
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.com.airbnb.lottie;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.LottieTask;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import org.json.JSONObject;

public class LottieCompositionFactory {
    private static final Map<String, LottieTask<LottieComposition>> taskCache = new HashMap();

    private LottieCompositionFactory() {
    }

    static /* synthetic */ Map access$000() {
        return taskCache;
    }

    private static LottieTask<LottieComposition> cache(String string2, Callable<LottieResult<LottieComposition>> callable) {
        LottieComposition lottieComposition = string2 == null ? null : LottieCompositionCache.getInstance().get(string2);
        if (lottieComposition != null) {
            return new LottieTask<LottieComposition>(new Callable<LottieResult<LottieComposition>>(){

                public LottieResult<LottieComposition> call() {
                    return new LottieResult<LottieComposition>(LottieComposition.this);
                }
            });
        }
        if (string2 != null && taskCache.containsKey((Object)string2)) {
            return (LottieTask)taskCache.get((Object)string2);
        }
        LottieTask<LottieComposition> lottieTask = new LottieTask<LottieComposition>(callable);
        if (string2 != null) {
            lottieTask.addListener((LottieListener<LottieComposition>)new 10(string2));
            lottieTask.addFailureListener((LottieListener<Throwable>)new 11(string2));
            taskCache.put((Object)string2, lottieTask);
        }
        return lottieTask;
    }

    public static void clearCache(Context context) {
        taskCache.clear();
        LottieCompositionCache.getInstance().clear();
        new NetworkCache(context).clear();
    }

    private static LottieImageAsset findImageAssetForFileName(LottieComposition lottieComposition, String string2) {
        for (LottieImageAsset lottieImageAsset : lottieComposition.getImages().values()) {
            if (!lottieImageAsset.getFileName().equals((Object)string2)) continue;
            return lottieImageAsset;
        }
        return null;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("asset_");
        stringBuilder.append(string2);
        return LottieCompositionFactory.fromAsset(context, string2, stringBuilder.toString());
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, final String string2, final String string3) {
        return LottieCompositionFactory.cache(string3, new Callable<LottieResult<LottieComposition>>(){

            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromAssetSync(Context.this, string2, string3);
            }
        });
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("asset_");
        stringBuilder.append(string2);
        return LottieCompositionFactory.fromAssetSync(context, string2, stringBuilder.toString());
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String string2, String string3) {
        try {
            if (string2.endsWith(".zip")) {
                return LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(context.getAssets().open(string2)), string3);
            }
            LottieResult<LottieComposition> lottieResult = LottieCompositionFactory.fromJsonInputStreamSync(context.getAssets().open(string2), string3);
            return lottieResult;
        }
        catch (IOException iOException) {
            return new LottieResult<LottieComposition>(iOException);
        }
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(JSONObject jSONObject, final String string2) {
        return LottieCompositionFactory.cache(string2, new Callable<LottieResult<LottieComposition>>(){

            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonSync(JSONObject.this, string2);
            }
        });
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(InputStream inputStream, final String string2) {
        return LottieCompositionFactory.cache(string2, new Callable<LottieResult<LottieComposition>>(){

            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonInputStreamSync(InputStream.this, string2);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String string2) {
        return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, string2, true);
    }

    private static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String string2, boolean bl) {
        try {
            LottieResult<LottieComposition> lottieResult = LottieCompositionFactory.fromJsonReaderSync(JsonReader.of((BufferedSource)Okio.buffer((Source)Okio.source((InputStream)inputStream))), string2);
            return lottieResult;
        }
        finally {
            if (bl) {
                Utils.closeQuietly((Closeable)inputStream);
            }
        }
    }

    public static LottieTask<LottieComposition> fromJsonReader(JsonReader jsonReader, final String string2) {
        return LottieCompositionFactory.cache(string2, new Callable<LottieResult<LottieComposition>>(){

            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonReaderSync(JsonReader.this, string2);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, String string2) {
        return LottieCompositionFactory.fromJsonReaderSyncInternal(jsonReader, string2, true);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader jsonReader, String string2, boolean bl) {
        Throwable throwable2222;
        LottieComposition lottieComposition = LottieCompositionMoshiParser.parse((JsonReader)jsonReader);
        if (string2 != null) {
            LottieCompositionCache.getInstance().put(string2, lottieComposition);
        }
        LottieResult<LottieComposition> lottieResult = new LottieResult<LottieComposition>(lottieComposition);
        if (!bl) return lottieResult;
        Utils.closeQuietly((Closeable)jsonReader);
        return lottieResult;
        {
            LottieResult<LottieComposition> lottieResult2;
            catch (Throwable throwable2222) {
            }
            catch (Exception exception) {}
            {
                lottieResult2 = new LottieResult<LottieComposition>(exception);
                if (!bl) return lottieResult2;
            }
            Utils.closeQuietly((Closeable)jsonReader);
            return lottieResult2;
        }
        if (!bl) throw throwable2222;
        Utils.closeQuietly((Closeable)jsonReader);
        throw throwable2222;
    }

    public static LottieTask<LottieComposition> fromJsonString(String string2, final String string3) {
        return LottieCompositionFactory.cache(string3, new Callable<LottieResult<LottieComposition>>(){

            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonStringSync(String.this, string3);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonStringSync(String string2, String string3) {
        return LottieCompositionFactory.fromJsonReaderSync(JsonReader.of((BufferedSource)Okio.buffer((Source)Okio.source((InputStream)new ByteArrayInputStream(string2.getBytes())))), string3);
    }

    @Deprecated
    public static LottieResult<LottieComposition> fromJsonSync(JSONObject jSONObject, String string2) {
        return LottieCompositionFactory.fromJsonStringSync(jSONObject.toString(), string2);
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, int n) {
        return LottieCompositionFactory.fromRawRes(context, n, LottieCompositionFactory.rawResCacheKey(context, n));
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, int n, String string2) {
        return LottieCompositionFactory.cache(string2, new Callable<LottieResult<LottieComposition>>(context.getApplicationContext(), n){
            final /* synthetic */ Context val$appContext;
            final /* synthetic */ int val$rawRes;
            {
                this.val$appContext = context;
                this.val$rawRes = n;
            }

            public LottieResult<LottieComposition> call() {
                Context context = (Context)WeakReference.this.get();
                if (context == null) {
                    context = this.val$appContext;
                }
                return LottieCompositionFactory.fromRawResSync(context, this.val$rawRes);
            }
        });
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context context, int n) {
        return LottieCompositionFactory.fromRawResSync(context, n, LottieCompositionFactory.rawResCacheKey(context, n));
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context context, int n, String string2) {
        try {
            LottieResult<LottieComposition> lottieResult = LottieCompositionFactory.fromJsonInputStreamSync(context.getResources().openRawResource(n), string2);
            return lottieResult;
        }
        catch (Resources.NotFoundException notFoundException) {
            return new LottieResult<LottieComposition>(notFoundException);
        }
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("url_");
        stringBuilder.append(string2);
        return LottieCompositionFactory.fromUrl(context, string2, stringBuilder.toString());
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, final String string2, final String string3) {
        return LottieCompositionFactory.cache(string3, new Callable<LottieResult<LottieComposition>>(){

            public LottieResult<LottieComposition> call() {
                return NetworkFetcher.fetchSync((Context)Context.this, (String)string2, (String)string3);
            }
        });
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context context, String string2) {
        return LottieCompositionFactory.fromUrlSync(context, string2, string2);
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context context, String string2, String string3) {
        return NetworkFetcher.fetchSync((Context)context, (String)string2, (String)string3);
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream zipInputStream, final String string2) {
        return LottieCompositionFactory.cache(string2, new Callable<LottieResult<LottieComposition>>(){

            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromZipStreamSync(ZipInputStream.this, string2);
            }
        });
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, String string2) {
        try {
            LottieResult<LottieComposition> lottieResult = LottieCompositionFactory.fromZipStreamSyncInternal(zipInputStream, string2);
            return lottieResult;
        }
        finally {
            Utils.closeQuietly((Closeable)zipInputStream);
        }
    }

    private static LottieResult<LottieComposition> fromZipStreamSyncInternal(ZipInputStream zipInputStream, String string2) {
        ZipEntry zipEntry;
        LottieComposition lottieComposition;
        HashMap hashMap = new HashMap();
        try {
            zipEntry = zipInputStream.getNextEntry();
            lottieComposition = null;
        }
        catch (IOException iOException) {
            return new LottieResult<LottieComposition>(iOException);
        }
        while (zipEntry != null) {
            String string3 = zipEntry.getName();
            if (string3.contains((CharSequence)"__MACOSX")) {
                zipInputStream.closeEntry();
            } else if (zipEntry.getName().contains((CharSequence)".json")) {
                lottieComposition = LottieCompositionFactory.fromJsonReaderSyncInternal(JsonReader.of((BufferedSource)Okio.buffer((Source)Okio.source((InputStream)zipInputStream))), null, false).getValue();
            } else if (!string3.contains((CharSequence)".png") && !string3.contains((CharSequence)".webp")) {
                zipInputStream.closeEntry();
            } else {
                String[] arrstring = string3.split("/");
                hashMap.put((Object)arrstring[-1 + arrstring.length], (Object)BitmapFactory.decodeStream((InputStream)zipInputStream));
            }
            zipEntry = zipInputStream.getNextEntry();
        }
        if (lottieComposition == null) {
            return new LottieResult<LottieComposition>((Throwable)new IllegalArgumentException("Unable to parse composition"));
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            LottieImageAsset lottieImageAsset = LottieCompositionFactory.findImageAssetForFileName(lottieComposition, (String)entry.getKey());
            if (lottieImageAsset == null) continue;
            lottieImageAsset.setBitmap(Utils.resizeBitmapIfNeeded((Bitmap)((Bitmap)entry.getValue()), (int)lottieImageAsset.getWidth(), (int)lottieImageAsset.getHeight()));
        }
        for (Map.Entry entry : lottieComposition.getImages().entrySet()) {
            if (((LottieImageAsset)entry.getValue()).getBitmap() != null) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("There is no image for ");
            stringBuilder.append(((LottieImageAsset)entry.getValue()).getFileName());
            return new LottieResult<LottieComposition>((Throwable)new IllegalStateException(stringBuilder.toString()));
        }
        if (string2 != null) {
            LottieCompositionCache.getInstance().put(string2, lottieComposition);
        }
        return new LottieResult<LottieComposition>(lottieComposition);
    }

    private static boolean isNightMode(Context context) {
        return (48 & context.getResources().getConfiguration().uiMode) == 32;
    }

    private static String rawResCacheKey(Context context, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("rawRes");
        String string2 = LottieCompositionFactory.isNightMode(context) ? "_night_" : "_day_";
        stringBuilder.append(string2);
        stringBuilder.append(n);
        return stringBuilder.toString();
    }

    public static void setMaxCacheSize(int n) {
        LottieCompositionCache.getInstance().resize(n);
    }

}

