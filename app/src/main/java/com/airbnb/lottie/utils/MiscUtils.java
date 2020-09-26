/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PointF
 *  com.airbnb.lottie.animation.content.KeyPathElementContent
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;

public class MiscUtils {
    private static PointF pathFromDataCurrentPoint = new PointF();

    public static PointF addPoints(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float clamp(float f, float f2, float f3) {
        return Math.max((float)f2, (float)Math.min((float)f3, (float)f));
    }

    public static int clamp(int n, int n2, int n3) {
        return Math.max((int)n2, (int)Math.min((int)n3, (int)n));
    }

    public static boolean contains(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    private static int floorDiv(int n, int n2) {
        int n3 = n / n2;
        boolean bl = (n ^ n2) >= 0;
        int n4 = n % n2;
        if (!bl && n4 != 0) {
            --n3;
        }
        return n3;
    }

    static int floorMod(float f, float f2) {
        return MiscUtils.floorMod((int)f, (int)f2);
    }

    private static int floorMod(int n, int n2) {
        return n - n2 * MiscUtils.floorDiv(n, n2);
    }

    public static void getPathFromData(ShapeData shapeData, Path path) {
        path.reset();
        PointF pointF = shapeData.getInitialPoint();
        path.moveTo(pointF.x, pointF.y);
        pathFromDataCurrentPoint.set(pointF.x, pointF.y);
        for (int i = 0; i < shapeData.getCurves().size(); ++i) {
            CubicCurveData cubicCurveData = (CubicCurveData)shapeData.getCurves().get(i);
            PointF pointF2 = cubicCurveData.getControlPoint1();
            PointF pointF3 = cubicCurveData.getControlPoint2();
            PointF pointF4 = cubicCurveData.getVertex();
            if (pointF2.equals((Object)pathFromDataCurrentPoint) && pointF3.equals((Object)pointF4)) {
                path.lineTo(pointF4.x, pointF4.y);
            } else {
                path.cubicTo(pointF2.x, pointF2.y, pointF3.x, pointF3.y, pointF4.x, pointF4.y);
            }
            pathFromDataCurrentPoint.set(pointF4.x, pointF4.y);
        }
        if (shapeData.isClosed()) {
            path.close();
        }
    }

    public static double lerp(double d, double d2, double d3) {
        return d + d3 * (d2 - d);
    }

    public static float lerp(float f, float f2, float f3) {
        return f + f3 * (f2 - f);
    }

    public static int lerp(int n, int n2, float f) {
        return (int)((float)n + f * (float)(n2 - n));
    }

    public static void resolveKeyPath(KeyPath keyPath, int n, List<KeyPath> list, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        if (keyPath.fullyResolvesTo(keyPathElementContent.getName(), n)) {
            list.add((Object)keyPath2.addKey(keyPathElementContent.getName()).resolve((KeyPathElement)keyPathElementContent));
        }
    }
}

