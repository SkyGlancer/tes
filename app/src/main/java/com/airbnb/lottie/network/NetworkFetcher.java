/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.core.util.Pair
 *  java.io.BufferedReader
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 *  java.util.zip.ZipInputStream
 */
package app.dukhaan.src.java.com.airbnb.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.network.FileExtension;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.utils.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipInputStream;

public class NetworkFetcher {
    private final Context appContext;
    private final NetworkCache networkCache;
    private final String url;

    private NetworkFetcher(Context context, String string2, String string3) {
        Context context2;
        this.appContext = context2 = context.getApplicationContext();
        this.url = string2;
        if (string3 == null) {
            this.networkCache = null;
            return;
        }
        this.networkCache = new NetworkCache(context2);
    }

    private LottieComposition fetchFromCache() {
        NetworkCache networkCache = this.networkCache;
        if (networkCache == null) {
            return null;
        }
        Pair<FileExtension, InputStream> pair = networkCache.fetch(this.url);
        if (pair == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension)((Object)pair.first);
        InputStream inputStream = (InputStream)pair.second;
        LottieResult<LottieComposition> lottieResult = fileExtension == FileExtension.ZIP ? LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), this.url) : LottieCompositionFactory.fromJsonInputStreamSync(inputStream, this.url);
        if (lottieResult.getValue() != null) {
            return lottieResult.getValue();
        }
        return null;
    }

    private LottieResult<LottieComposition> fetchFromNetwork() {
        try {
            LottieResult<LottieComposition> lottieResult = this.fetchFromNetworkInternal();
            return lottieResult;
        }
        catch (IOException iOException) {
            return new LottieResult<LottieComposition>(iOException);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private LottieResult<LottieComposition> fetchFromNetworkInternal() throws IOException {
        Throwable throwable2222;
        HttpURLConnection httpURLConnection;
        block6 : {
            block5 : {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Fetching ");
                stringBuilder.append(this.url);
                Logger.debug(stringBuilder.toString());
                httpURLConnection = (HttpURLConnection)new URL(this.url).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                if (httpURLConnection.getErrorStream() != null || httpURLConnection.getResponseCode() != 200) break block5;
                LottieResult<LottieComposition> lottieResult = this.getResultFromConnection(httpURLConnection);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Completed fetch from network. Success: ");
                boolean bl = lottieResult.getValue() != null;
                stringBuilder2.append(bl);
                Logger.debug(stringBuilder2.toString());
                httpURLConnection.disconnect();
                return lottieResult;
            }
            String string2 = this.getErrorFromConnection(httpURLConnection);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to fetch ");
            stringBuilder.append(this.url);
            stringBuilder.append(". Failed with ");
            stringBuilder.append(httpURLConnection.getResponseCode());
            stringBuilder.append("\n");
            stringBuilder.append(string2);
            LottieResult<LottieComposition> lottieResult = new LottieResult<LottieComposition>(new IllegalArgumentException(stringBuilder.toString()));
            httpURLConnection.disconnect();
            return lottieResult;
            {
                LottieResult<LottieComposition> lottieResult2;
                catch (Throwable throwable2222) {
                    break block6;
                }
                catch (Exception exception) {}
                {
                    lottieResult2 = new LottieResult<LottieComposition>(exception);
                }
                httpURLConnection.disconnect();
                return lottieResult2;
            }
        }
        httpURLConnection.disconnect();
        throw throwable2222;
    }

    public static LottieResult<LottieComposition> fetchSync(Context context, String string2, String string3) {
        return new NetworkFetcher(context, string2, string3).fetchSync();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private String getErrorFromConnection(HttpURLConnection httpURLConnection) throws IOException {
        Throwable throwable2222;
        String string2;
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder stringBuilder = new StringBuilder();
        while ((string2 = bufferedReader.readLine()) != null) {
            stringBuilder.append(string2);
            stringBuilder.append('\n');
        }
        try {
            bufferedReader.close();
            return stringBuilder.toString();
        }
        catch (Exception exception) {}
        return stringBuilder.toString();
        {
            catch (Throwable throwable2222) {
            }
            catch (Exception exception) {}
            {
                throw exception;
            }
        }
        try {
            bufferedReader.close();
            throw throwable2222;
        }
        catch (Exception exception) {
            throw throwable2222;
        }
    }

    private LottieResult<LottieComposition> getResultFromConnection(HttpURLConnection httpURLConnection) throws IOException {
        FileExtension fileExtension;
        LottieResult<LottieComposition> lottieResult;
        String string2 = httpURLConnection.getContentType();
        if (string2 == null) {
            string2 = "application/json";
        }
        if (string2.contains((CharSequence)"application/zip")) {
            Logger.debug("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            NetworkCache networkCache = this.networkCache;
            lottieResult = networkCache == null ? LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(httpURLConnection.getInputStream()), null) : LottieCompositionFactory.fromZipStreamSync(new ZipInputStream((InputStream)new FileInputStream(networkCache.writeTempCacheFile(this.url, httpURLConnection.getInputStream(), fileExtension))), this.url);
        } else {
            Logger.debug("Received json response.");
            fileExtension = FileExtension.JSON;
            NetworkCache networkCache = this.networkCache;
            lottieResult = networkCache == null ? LottieCompositionFactory.fromJsonInputStreamSync(httpURLConnection.getInputStream(), null) : LottieCompositionFactory.fromJsonInputStreamSync((InputStream)new FileInputStream(new File(networkCache.writeTempCacheFile(this.url, httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.url);
        }
        if (this.networkCache != null && lottieResult.getValue() != null) {
            this.networkCache.renameTempFile(this.url, fileExtension);
        }
        return lottieResult;
    }

    public LottieResult<LottieComposition> fetchSync() {
        LottieComposition lottieComposition = this.fetchFromCache();
        if (lottieComposition != null) {
            return new LottieResult<LottieComposition>(lottieComposition);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Animation for ");
        stringBuilder.append(this.url);
        stringBuilder.append(" not found in cache. Fetching from network.");
        Logger.debug(stringBuilder.toString());
        return this.fetchFromNetwork();
    }
}

