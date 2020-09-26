/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Matrix
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.ParcelFileDescriptor
 *  android.text.TextUtils
 *  android.util.Log
 *  androidx.core.content.ContextCompat
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileDescriptor
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.Void
 *  okhttp3.Call
 *  okhttp3.Dispatcher
 *  okhttp3.OkHttpClient
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 *  okhttp3.ResponseBody
 *  okio.BufferedSource
 *  okio.Okio
 *  okio.Sink
 */
package app.dukhaan.src.java.com.yalantis.ucrop.task;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;

public class BitmapLoadTask
extends AsyncTask<Void, Void, BitmapWorkerResult> {
    private static final String TAG = "BitmapWorkerTask";
    private final BitmapLoadCallback mBitmapLoadCallback;
    private final Context mContext;
    private Uri mInputUri;
    private Uri mOutputUri;
    private final int mRequiredHeight;
    private final int mRequiredWidth;

    public BitmapLoadTask(Context context, Uri uri, Uri uri2, int n, int n2, BitmapLoadCallback bitmapLoadCallback) {
        this.mContext = context;
        this.mInputUri = uri;
        this.mOutputUri = uri2;
        this.mRequiredWidth = n;
        this.mRequiredHeight = n2;
        this.mBitmapLoadCallback = bitmapLoadCallback;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void copyFile(Uri uri, Uri uri2) throws NullPointerException, IOException {
        void var6_11;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        block10 : {
            block9 : {
                Log.d((String)TAG, (String)"copyFile");
                if (uri2 == null) {
                    NullPointerException nullPointerException = new NullPointerException("Output Uri is null - cannot copy image");
                    throw nullPointerException;
                }
                fileOutputStream = null;
                inputStream = this.mContext.getContentResolver().openInputStream(uri);
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(uri2.getPath()));
                if (inputStream == null) break block9;
                try {
                    int n;
                    byte[] arrby = new byte[1024];
                    while ((n = inputStream.read(arrby)) > 0) {
                        fileOutputStream2.write(arrby, 0, n);
                    }
                }
                catch (Throwable throwable) {
                    fileOutputStream = fileOutputStream2;
                    break block10;
                }
                BitmapLoadUtils.close((Closeable)fileOutputStream2);
                BitmapLoadUtils.close((Closeable)inputStream);
                this.mInputUri = this.mOutputUri;
                return;
            }
            throw new NullPointerException("InputStream for given input Uri is null");
            catch (Throwable throwable) {
                fileOutputStream = null;
            }
            break block10;
            catch (Throwable throwable) {
                inputStream = null;
            }
        }
        BitmapLoadUtils.close(fileOutputStream);
        BitmapLoadUtils.close((Closeable)inputStream);
        this.mInputUri = this.mOutputUri;
        throw var6_11;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void downloadFile(Uri uri, Uri uri2) throws NullPointerException, IOException {
        BufferedSource bufferedSource;
        void var6_11;
        BufferedSource bufferedSource2;
        Response response;
        OkHttpClient okHttpClient;
        block10 : {
            BufferedSource bufferedSource3;
            Response response2;
            block9 : {
                Log.d((String)TAG, (String)"downloadFile");
                if (uri2 == null) throw new NullPointerException("Output Uri is null - cannot download image");
                okHttpClient = new OkHttpClient();
                bufferedSource2 = null;
                response2 = okHttpClient.newCall(new Request.Builder().url(uri.toString()).build()).execute();
                try {
                    bufferedSource3 = response2.body().source();
                }
                catch (Throwable throwable) {
                    response = response2;
                    bufferedSource2 = null;
                    bufferedSource = null;
                    break block10;
                }
                OutputStream outputStream = this.mContext.getContentResolver().openOutputStream(uri2);
                bufferedSource2 = null;
                if (outputStream == null) break block9;
                bufferedSource2 = Okio.sink((OutputStream)outputStream);
                bufferedSource3.readAll((Sink)bufferedSource2);
                BitmapLoadUtils.close((Closeable)bufferedSource3);
                BitmapLoadUtils.close((Closeable)bufferedSource2);
                if (response2 != null) {
                    BitmapLoadUtils.close((Closeable)response2.body());
                }
                okHttpClient.dispatcher().cancelAll();
                this.mInputUri = this.mOutputUri;
                return;
            }
            try {
                throw new NullPointerException("OutputStream for given output Uri is null");
            }
            catch (Throwable throwable) {
                response = response2;
                bufferedSource = bufferedSource2;
                bufferedSource2 = bufferedSource3;
            }
            break block10;
            catch (Throwable throwable) {
                bufferedSource = null;
                response = null;
            }
        }
        BitmapLoadUtils.close(bufferedSource2);
        BitmapLoadUtils.close(bufferedSource);
        if (response != null) {
            BitmapLoadUtils.close((Closeable)response.body());
        }
        okHttpClient.dispatcher().cancelAll();
        this.mInputUri = this.mOutputUri;
        throw var6_11;
    }

    private String getFilePath() {
        if (ContextCompat.checkSelfPermission((Context)this.mContext, (String)"android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return FileUtils.getPath(this.mContext, this.mInputUri);
        }
        return null;
    }

    private void processInputUri() throws NullPointerException, IOException {
        void var6_11;
        String string2 = this.mInputUri.getScheme();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Uri scheme: ");
        stringBuilder.append(string2);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (!"http".equals((Object)string2) && !"https".equals((Object)string2)) {
            if ("content".equals((Object)string2)) {
                void var16_6;
                String string3 = this.getFilePath();
                if (!TextUtils.isEmpty((CharSequence)string3) && new File(string3).exists()) {
                    this.mInputUri = Uri.fromFile((File)new File(string3));
                    return;
                }
                try {
                    this.copyFile(this.mInputUri, this.mOutputUri);
                    return;
                }
                catch (IOException iOException) {
                }
                catch (NullPointerException nullPointerException) {
                    // empty catch block
                }
                Log.e((String)TAG, (String)"Copying failed", (Throwable)var16_6);
                throw var16_6;
            }
            if ("file".equals((Object)string2)) {
                return;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Invalid Uri scheme ");
            stringBuilder2.append(string2);
            Log.e((String)TAG, (String)stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Invalid Uri scheme");
            stringBuilder3.append(string2);
            throw new IllegalArgumentException(stringBuilder3.toString());
        }
        try {
            this.downloadFile(this.mInputUri, this.mOutputUri);
            return;
        }
        catch (IOException iOException) {
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        Log.e((String)TAG, (String)"Downloading failed", (Throwable)var6_11);
        throw var6_11;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected /* varargs */ BitmapWorkerResult doInBackground(Void ... arrvoid) {
        if (this.mInputUri == null) {
            return new BitmapWorkerResult((Exception)new NullPointerException("Input Uri cannot be null"));
        }
        this.processInputUri();
        parcelFileDescriptor = this.mContext.getContentResolver().openFileDescriptor(this.mInputUri, "r");
        if (parcelFileDescriptor == null) ** GOTO lbl25
        {
            catch (FileNotFoundException fileNotFoundException) {
                return new BitmapWorkerResult((Exception)fileNotFoundException);
            }
        }
        fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor((FileDescriptor)fileDescriptor, null, (BitmapFactory.Options)options);
        if (options.outWidth != -1 && options.outHeight != -1) {
            options.inSampleSize = BitmapLoadUtils.calculateInSampleSize(options, this.mRequiredWidth, this.mRequiredHeight);
            bl = false;
            options.inJustDecodeBounds = false;
            bitmap = null;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Bounds for bitmap could not be retrieved from the Uri: [");
            stringBuilder.append((Object)this.mInputUri);
            stringBuilder.append("]");
            return new BitmapWorkerResult((Exception)new IllegalArgumentException(stringBuilder.toString()));
lbl25: // 1 sources:
            stringBuilder = new StringBuilder();
            stringBuilder.append("ParcelFileDescriptor was null for given Uri: [");
            stringBuilder.append((Object)this.mInputUri);
            stringBuilder.append("]");
            return new BitmapWorkerResult((Exception)new NullPointerException(stringBuilder.toString()));
            catch (IOException iOException) {
                return new BitmapWorkerResult((Exception)var2_19);
            }
            catch (NullPointerException nullPointerException) {
                // empty catch block
            }
            return new BitmapWorkerResult((Exception)var2_19);
        }
        while (!bl) {
            try {
                bitmap = BitmapFactory.decodeFileDescriptor((FileDescriptor)fileDescriptor, null, (BitmapFactory.Options)options);
                bl = true;
            }
            catch (OutOfMemoryError outOfMemoryError) {
                Log.e((String)"BitmapWorkerTask", (String)"doInBackground: BitmapFactory.decodeFileDescriptor: ", (Throwable)outOfMemoryError);
                options.inSampleSize = 2 * options.inSampleSize;
            }
        }
        if (bitmap == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Bitmap could not be decoded from the Uri: [");
            stringBuilder.append((Object)this.mInputUri);
            stringBuilder.append("]");
            return new BitmapWorkerResult((Exception)new IllegalArgumentException(stringBuilder.toString()));
        }
        if (Build.VERSION.SDK_INT >= 16) {
            BitmapLoadUtils.close((Closeable)parcelFileDescriptor);
        }
        n = BitmapLoadUtils.getExifOrientation(this.mContext, this.mInputUri);
        n2 = BitmapLoadUtils.exifToDegrees(n);
        n3 = BitmapLoadUtils.exifToTranslation(n);
        exifInfo = new ExifInfo(n, n2, n3);
        matrix = new Matrix();
        if (n2 != 0) {
            matrix.preRotate((float)n2);
        }
        if (n3 != 1) {
            matrix.postScale((float)n3, 1.0f);
        }
        if (matrix.isIdentity() != false) return new BitmapWorkerResult(bitmap, exifInfo);
        return new BitmapWorkerResult(BitmapLoadUtils.transformBitmap(bitmap, matrix), exifInfo);
    }

    protected void onPostExecute(BitmapWorkerResult bitmapWorkerResult) {
        if (bitmapWorkerResult.mBitmapWorkerException == null) {
            BitmapLoadCallback bitmapLoadCallback = this.mBitmapLoadCallback;
            Bitmap bitmap = bitmapWorkerResult.mBitmapResult;
            ExifInfo exifInfo = bitmapWorkerResult.mExifInfo;
            String string2 = this.mInputUri.getPath();
            Uri uri = this.mOutputUri;
            String string3 = uri == null ? null : uri.getPath();
            bitmapLoadCallback.onBitmapLoaded(bitmap, exifInfo, string2, string3);
            return;
        }
        this.mBitmapLoadCallback.onFailure(bitmapWorkerResult.mBitmapWorkerException);
    }

    public static class BitmapWorkerResult {
        Bitmap mBitmapResult;
        Exception mBitmapWorkerException;
        ExifInfo mExifInfo;

        public BitmapWorkerResult(Bitmap bitmap, ExifInfo exifInfo) {
            this.mBitmapResult = bitmap;
            this.mExifInfo = exifInfo;
        }

        public BitmapWorkerResult(Exception exception) {
            this.mBitmapWorkerException = exception;
        }
    }

}

