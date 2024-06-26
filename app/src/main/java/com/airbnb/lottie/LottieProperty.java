/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.ColorFilter
 *  android.graphics.PointF
 *  com.airbnb.lottie.value.ScaleXY
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.airbnb.lottie;

import android.graphics.ColorFilter;
import android.graphics.PointF;
import com.airbnb.lottie.value.ScaleXY;

public interface LottieProperty {
    public static final Integer COLOR;
    public static final ColorFilter COLOR_FILTER;
    public static final Float CORNER_RADIUS;
    public static final PointF ELLIPSE_SIZE;
    public static final Integer[] GRADIENT_COLOR;
    public static final Integer OPACITY;
    public static final Float POLYSTAR_INNER_RADIUS;
    public static final Float POLYSTAR_INNER_ROUNDEDNESS;
    public static final Float POLYSTAR_OUTER_RADIUS;
    public static final Float POLYSTAR_OUTER_ROUNDEDNESS;
    public static final Float POLYSTAR_POINTS;
    public static final Float POLYSTAR_ROTATION;
    public static final PointF POSITION;
    public static final PointF RECTANGLE_SIZE;
    public static final Float REPEATER_COPIES;
    public static final Float REPEATER_OFFSET;
    public static final Integer STROKE_COLOR;
    public static final Float STROKE_WIDTH;
    public static final Float TEXT_SIZE;
    public static final Float TEXT_TRACKING;
    public static final Float TIME_REMAP;
    public static final PointF TRANSFORM_ANCHOR_POINT;
    public static final Float TRANSFORM_END_OPACITY;
    public static final Integer TRANSFORM_OPACITY;
    public static final PointF TRANSFORM_POSITION;
    public static final Float TRANSFORM_ROTATION;
    public static final ScaleXY TRANSFORM_SCALE;
    public static final Float TRANSFORM_SKEW;
    public static final Float TRANSFORM_SKEW_ANGLE;
    public static final Float TRANSFORM_START_OPACITY;

    static {
        Float f;
        COLOR = 1;
        STROKE_COLOR = 2;
        TRANSFORM_OPACITY = 3;
        OPACITY = 4;
        TRANSFORM_ANCHOR_POINT = new PointF();
        TRANSFORM_POSITION = new PointF();
        ELLIPSE_SIZE = new PointF();
        RECTANGLE_SIZE = new PointF();
        CORNER_RADIUS = f = Float.valueOf((float)0.0f);
        POSITION = new PointF();
        TRANSFORM_SCALE = new ScaleXY();
        TRANSFORM_ROTATION = Float.valueOf((float)1.0f);
        TRANSFORM_SKEW = f;
        TRANSFORM_SKEW_ANGLE = f;
        STROKE_WIDTH = Float.valueOf((float)2.0f);
        TEXT_TRACKING = Float.valueOf((float)3.0f);
        REPEATER_COPIES = Float.valueOf((float)4.0f);
        REPEATER_OFFSET = Float.valueOf((float)5.0f);
        POLYSTAR_POINTS = Float.valueOf((float)6.0f);
        POLYSTAR_ROTATION = Float.valueOf((float)7.0f);
        POLYSTAR_INNER_RADIUS = Float.valueOf((float)8.0f);
        POLYSTAR_OUTER_RADIUS = Float.valueOf((float)9.0f);
        POLYSTAR_INNER_ROUNDEDNESS = Float.valueOf((float)10.0f);
        POLYSTAR_OUTER_ROUNDEDNESS = Float.valueOf((float)11.0f);
        TRANSFORM_START_OPACITY = Float.valueOf((float)12.0f);
        TRANSFORM_END_OPACITY = Float.valueOf((float)12.1f);
        TIME_REMAP = Float.valueOf((float)13.0f);
        TEXT_SIZE = Float.valueOf((float)14.0f);
        COLOR_FILTER = new ColorFilter();
        GRADIENT_COLOR = new Integer[0];
    }
}

