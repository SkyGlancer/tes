/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  java.lang.Object
 */
package app.dukhaan.otpview;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class OtpUtils {
    static int getPixels(Context context, float f) {
        return (int)TypedValue.applyDimension((int)1, (float)f, (DisplayMetrics)context.getResources().getDisplayMetrics());
    }

    static int getPixels(Context context, int n) {
        Resources resources = context.getResources();
        return (int)TypedValue.applyDimension((int)1, (float)n, (DisplayMetrics)resources.getDisplayMetrics());
    }

    static int getPixelsSp(Context context, float f) {
        return (int)TypedValue.applyDimension((int)2, (float)f, (DisplayMetrics)context.getResources().getDisplayMetrics());
    }

    static int getPixelsSp(Context context, int n) {
        Resources resources = context.getResources();
        return (int)TypedValue.applyDimension((int)2, (float)n, (DisplayMetrics)resources.getDisplayMetrics());
    }
}

