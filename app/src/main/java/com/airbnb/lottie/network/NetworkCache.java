/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.core.util.Pair
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package app.dukhaan.src.java.com.airbnb.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.airbnb.lottie.network.FileExtension;
import com.airbnb.lottie.utils.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class NetworkCache {
    private final Context appContext;

    public NetworkCache(Context context) {
        this.appContext = context.getApplicationContext();
    }

    private static String filenameForUrl(String string2, FileExtension fileExtension, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lottie_cache_");
        stringBuilder.append(string2.replaceAll("\\W+", ""));
        String string3 = bl ? fileExtension.tempExtension() : fileExtension.extension;
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    private File getCachedFile(String string2) throws FileNotFoundException {
        File file = new File(this.parentDir(), NetworkCache.filenameForUrl(string2, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(this.parentDir(), NetworkCache.filenameForUrl(string2, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File parentDir() {
        File file = new File(this.appContext.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public void clear() {
        File file = this.parentDir();
        if (file.exists()) {
            File[] arrfile = file.listFiles();
            if (arrfile != null && arrfile.length > 0) {
                File[] arrfile2 = file.listFiles();
                int n = arrfile2.length;
                for (int i = 0; i < n; ++i) {
                    arrfile2[i].delete();
                }
            }
            file.delete();
        }
    }

    Pair<FileExtension, InputStream> fetch(String string2) {
        File file;
        block3 : {
            try {
                file = this.getCachedFile(string2);
                if (file != null) break block3;
                return null;
            }
            catch (FileNotFoundException fileNotFoundException) {
                return null;
            }
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        FileExtension fileExtension = file.getAbsolutePath().endsWith(".zip") ? FileExtension.ZIP : FileExtension.JSON;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cache hit for ");
        stringBuilder.append(string2);
        stringBuilder.append(" at ");
        stringBuilder.append(file.getAbsolutePath());
        Logger.debug(stringBuilder.toString());
        return new Pair((Object)fileExtension, (Object)fileInputStream);
    }

    void renameTempFile(String string2, FileExtension fileExtension) {
        String string3 = NetworkCache.filenameForUrl(string2, fileExtension, true);
        File file = new File(this.parentDir(), string3);
        File file2 = new File(file.getAbsolutePath().replace((CharSequence)".temp", (CharSequence)""));
        boolean bl = file.renameTo(file2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Copying temp file to real file (");
        stringBuilder.append((Object)file2);
        stringBuilder.append(")");
        Logger.debug(stringBuilder.toString());
        if (!bl) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unable to rename cache file ");
            stringBuilder2.append(file.getAbsolutePath());
            stringBuilder2.append(" to ");
            stringBuilder2.append(file2.getAbsolutePath());
            stringBuilder2.append(".");
            Logger.warning(stringBuilder2.toString());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    File writeTempCacheFile(String string2, InputStream inputStream, FileExtension fileExtension) throws IOException {
        String string3 = NetworkCache.filenameForUrl(string2, fileExtension, true);
        File file = new File(this.parentDir(), string3);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            int n;
            byte[] arrby = new byte[1024];
            while ((n = inputStream.read(arrby)) != -1) {
                fileOutputStream.write(arrby, 0, n);
            }
            fileOutputStream.flush();
        }
        catch (Throwable throwable) {
            fileOutputStream.close();
            throw throwable;
        }
        try {
            fileOutputStream.close();
            return file;
        }
        finally {
            inputStream.close();
        }
    }
}

