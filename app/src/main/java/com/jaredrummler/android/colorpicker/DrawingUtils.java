/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  java.lang.Double
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

final class DrawingUtils {
    DrawingUtils() {
    }

    static int dpToPx(Context context, float f) {
        float f2 = TypedValue.applyDimension((int)1, (float)f, (DisplayMetrics)context.getResources().getDisplayMetrics());
        double d = f2;
        Double.isNaN((double)d);
        int n = (int)(d + 0.5);
        if (n == 0 && f2 > 0.0f) {
            return 1;
        }
        return n;
    }
}

