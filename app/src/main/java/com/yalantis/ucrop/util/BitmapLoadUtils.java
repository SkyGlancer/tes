/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Point
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.util.Log
 *  android.view.Display
 *  android.view.WindowManager
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.Void
 */
package app.dukhaan.src.java.com.yalantis.ucrop.util;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.task.BitmapLoadTask;
import com.yalantis.ucrop.util.EglUtils;
import com.yalantis.ucrop.util.ImageHeaderParser;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class BitmapLoadUtils {
    private static final String TAG = "BitmapLoadUtils";

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int calculateInSampleSize(BitmapFactory.Options options, int n, int n2) {
        int n3 = options.outHeight;
        int n4 = options.outWidth;
        int n5 = 1;
        if (n3 <= n2 && n4 <= n) return n5;
        while (n3 / n5 > n2 || n4 / n5 > n) {
            n5 *= 2;
        }
        return n5;
    }

    public static int calculateMaxBitmapSize(Context context) {
        int n;
        WindowManager windowManager = (WindowManager)context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int n2 = point.x;
        int n3 = point.y;
        int n4 = (int)Math.sqrt((double)(Math.pow((double)n2, (double)2.0) + Math.pow((double)n3, (double)2.0)));
        Canvas canvas = new Canvas();
        int n5 = Math.min((int)canvas.getMaximumBitmapWidth(), (int)canvas.getMaximumBitmapHeight());
        if (n5 > 0) {
            n4 = Math.min((int)n4, (int)n5);
        }
        if ((n = EglUtils.getMaxTextureSize()) > 0) {
            n4 = Math.min((int)n4, (int)n);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("maxBitmapSize: ");
        stringBuilder.append(n4);
        Log.d((String)TAG, (String)stringBuilder.toString());
        return n4;
    }

    /*
     * Exception decompiling
     */
    public static void close(Closeable var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    public static void decodeBitmapInBackground(Context context, Uri uri, Uri uri2, int n, int n2, BitmapLoadCallback bitmapLoadCallback) {
        BitmapLoadTask bitmapLoadTask = new BitmapLoadTask(context, uri, uri2, n, n2, bitmapLoadCallback);
        bitmapLoadTask.execute((Object[])new Void[0]);
    }

    public static int exifToDegrees(int n) {
        switch (n) {
            default: {
                return 0;
            }
            case 7: 
            case 8: {
                return 270;
            }
            case 5: 
            case 6: {
                return 90;
            }
            case 3: 
            case 4: 
        }
        return 180;
    }

    public static int exifToTranslation(int n) {
        if (n != 2 && n != 7 && n != 4 && n != 5) {
            return 1;
        }
        return -1;
    }

    public static int getExifOrientation(Context context, Uri uri) {
        int n;
        InputStream inputStream;
        block3 : {
            n = 0;
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
                if (inputStream != null) break block3;
                return 0;
            }
            catch (IOException iOException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getExifOrientation: ");
                stringBuilder.append(uri.toString());
                Log.e((String)TAG, (String)stringBuilder.toString(), (Throwable)iOException);
                return n;
            }
        }
        n = new ImageHeaderParser(inputStream).getOrientation();
        BitmapLoadUtils.close((Closeable)inputStream);
        return n;
    }

    public static Bitmap transformBitmap(Bitmap bitmap, Matrix matrix) {
        try {
            Bitmap bitmap2 = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)bitmap.getWidth(), (int)bitmap.getHeight(), (Matrix)matrix, (boolean)true);
            boolean bl = bitmap.sameAs(bitmap2);
            if (!bl) {
                return bitmap2;
            }
        }
        catch (OutOfMemoryError outOfMemoryError) {
            Log.e((String)TAG, (String)"transformBitmap: ", (Throwable)outOfMemoryError);
        }
        return bitmap;
    }
}

