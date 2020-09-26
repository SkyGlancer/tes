/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.graphics.PointF
 *  android.graphics.RectF
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.provider.Settings
 *  android.provider.Settings$Global
 *  android.provider.Settings$System
 *  android.util.DisplayMetrics
 *  com.airbnb.lottie.animation.content.TrimPathContent
 *  com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation
 *  java.io.Closeable
 *  java.io.InterruptedIOException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.ProtocolException
 *  java.net.SocketException
 *  java.net.UnknownHostException
 *  java.net.UnknownServiceException
 *  java.nio.channels.ClosedChannelException
 *  javax.net.ssl.SSLException
 */
package app.dukhaan.src.java.com.airbnb.lottie.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import com.airbnb.lottie.L;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

public final class Utils {
    private static final float INV_SQRT_2 = 0.0f;
    public static final int SECOND_IN_NANOS = 1000000000;
    private static float dpScale;
    private static final PathMeasure pathMeasure;
    private static final float[] points;
    private static final Path tempPath;
    private static final Path tempPath2;

    static {
        pathMeasure = new PathMeasure();
        tempPath = new Path();
        tempPath2 = new Path();
        points = new float[4];
        INV_SQRT_2 = (float)(Math.sqrt((double)2.0) / 2.0);
        dpScale = -1.0f;
    }

    private Utils() {
    }

    public static void applyTrimPathIfNeeded(Path path, float f, float f2, float f3) {
        L.beginSection("applyTrimPathIfNeeded");
        pathMeasure.setPath(path, false);
        float f4 = pathMeasure.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            L.endSection("applyTrimPathIfNeeded");
            return;
        }
        if (!(f4 < 1.0f) && !((double)Math.abs((float)(f2 - f - 1.0f)) < 0.01)) {
            float f5 = f * f4;
            float f6 = f2 * f4;
            float f7 = Math.min((float)f5, (float)f6);
            float f8 = Math.max((float)f5, (float)f6);
            float f9 = f3 * f4;
            float f10 = f7 + f9;
            float f11 = f8 + f9;
            if (f10 >= f4 && f11 >= f4) {
                f10 = MiscUtils.floorMod(f10, f4);
                f11 = MiscUtils.floorMod(f11, f4);
            }
            if (f10 < 0.0f) {
                f10 = MiscUtils.floorMod(f10, f4);
            }
            if (f11 < 0.0f) {
                f11 = MiscUtils.floorMod(f11, f4);
            }
            if (f10 == f11) {
                path.reset();
                L.endSection("applyTrimPathIfNeeded");
                return;
            }
            if (f10 >= f11) {
                f10 -= f4;
            }
            tempPath.reset();
            pathMeasure.getSegment(f10, f11, tempPath, true);
            if (f11 > f4) {
                tempPath2.reset();
                pathMeasure.getSegment(0.0f, f11 % f4, tempPath2, true);
                tempPath.addPath(tempPath2);
            } else if (f10 < 0.0f) {
                tempPath2.reset();
                pathMeasure.getSegment(f10 + f4, f4, tempPath2, true);
                tempPath.addPath(tempPath2);
            }
            path.set(tempPath);
            L.endSection("applyTrimPathIfNeeded");
            return;
        }
        L.endSection("applyTrimPathIfNeeded");
    }

    public static void applyTrimPathIfNeeded(Path path, TrimPathContent trimPathContent) {
        if (trimPathContent != null) {
            if (trimPathContent.isHidden()) {
                return;
            }
            float f = ((FloatKeyframeAnimation)trimPathContent.getStart()).getFloatValue();
            float f2 = ((FloatKeyframeAnimation)trimPathContent.getEnd()).getFloatValue();
            float f3 = ((FloatKeyframeAnimation)trimPathContent.getOffset()).getFloatValue();
            Utils.applyTrimPathIfNeeded(path, f / 100.0f, f2 / 100.0f, f3 / 360.0f);
        }
    }

    /*
     * Exception decompiling
     */
    public static void closeQuietly(Closeable var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl9.1 : RETURN : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
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

    public static Path createPath(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            path.cubicTo(pointF.x + pointF3.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
            return path;
        }
        path.lineTo(pointF2.x, pointF2.y);
        return path;
    }

    public static float dpScale() {
        if (dpScale == -1.0f) {
            dpScale = Resources.getSystem().getDisplayMetrics().density;
        }
        return dpScale;
    }

    public static float getAnimationScale(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getFloat((ContentResolver)context.getContentResolver(), (String)"animator_duration_scale", (float)1.0f);
        }
        return Settings.System.getFloat((ContentResolver)context.getContentResolver(), (String)"animator_duration_scale", (float)1.0f);
    }

    public static float getScale(Matrix matrix) {
        float f;
        float[] arrf = points;
        arrf[0] = 0.0f;
        arrf[1] = 0.0f;
        arrf[2] = f = INV_SQRT_2;
        arrf[3] = f;
        matrix.mapPoints(arrf);
        float[] arrf2 = points;
        float f2 = arrf2[2] - arrf2[0];
        float f3 = arrf2[3] - arrf2[1];
        return (float)Math.hypot((double)f2, (double)f3);
    }

    public static boolean hasZeroScaleAxis(Matrix matrix) {
        float[] arrf = points;
        arrf[0] = 0.0f;
        arrf[1] = 0.0f;
        arrf[2] = 37394.73f;
        arrf[3] = 39575.234f;
        matrix.mapPoints(arrf);
        float[] arrf2 = points;
        if (arrf2[0] != arrf2[2]) {
            return arrf2[1] == arrf2[3];
        }
        return true;
    }

    public static int hashFor(float f, float f2, float f3, float f4) {
        int n = f != 0.0f ? (int)(f * (float)527) : 17;
        if (f2 != 0.0f) {
            n = (int)(f2 * (float)(n * 31));
        }
        if (f3 != 0.0f) {
            n = (int)(f3 * (float)(n * 31));
        }
        if (f4 != 0.0f) {
            n = (int)(f4 * (float)(n * 31));
        }
        return n;
    }

    public static boolean isAtLeastVersion(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n < n4) {
            return false;
        }
        if (n > n4) {
            return true;
        }
        if (n2 < n5) {
            return false;
        }
        if (n2 > n5) {
            return true;
        }
        boolean bl = false;
        if (n3 >= n6) {
            bl = true;
        }
        return bl;
    }

    public static boolean isNetworkException(Throwable throwable) {
        return throwable instanceof SocketException || throwable instanceof ClosedChannelException || throwable instanceof InterruptedIOException || throwable instanceof ProtocolException || throwable instanceof SSLException || throwable instanceof UnknownHostException || throwable instanceof UnknownServiceException;
        {
        }
    }

    public static Bitmap renderPath(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, false);
        Bitmap bitmap = Bitmap.createBitmap((int)((int)rectF.right), (int)((int)rectF.bottom), (Bitmap.Config)Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        LPaint lPaint = new LPaint();
        lPaint.setAntiAlias(true);
        lPaint.setColor(-16776961);
        canvas.drawPath(path, (Paint)lPaint);
        return bitmap;
    }

    public static Bitmap resizeBitmapIfNeeded(Bitmap bitmap, int n, int n2) {
        if (bitmap.getWidth() == n && bitmap.getHeight() == n2) {
            return bitmap;
        }
        Bitmap bitmap2 = Bitmap.createScaledBitmap((Bitmap)bitmap, (int)n, (int)n2, (boolean)true);
        bitmap.recycle();
        return bitmap2;
    }

    public static void saveLayerCompat(Canvas canvas, RectF rectF, Paint paint) {
        Utils.saveLayerCompat(canvas, rectF, paint, 31);
    }

    public static void saveLayerCompat(Canvas canvas, RectF rectF, Paint paint, int n) {
        L.beginSection("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, n);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        L.endSection("Utils#saveLayer");
    }
}

