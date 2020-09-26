/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.yalantis.ucrop.util;

public final class CubicEasing {
    public static float easeIn(float f, float f2, float f3, float f4) {
        float f5 = f / f4;
        return f2 + f5 * (f5 * (f3 * f5));
    }

    public static float easeInOut(float f, float f2, float f3, float f4) {
        float f5;
        float f6 = f / (f4 / 2.0f);
        float f7 = f6 FCMPG 1.0f;
        float f8 = f3 / 2.0f;
        if (f7 < 0) {
            f5 = f6 * (f6 * (f8 * f6));
        } else {
            float f9 = f6 - 2.0f;
            f5 = f8 * (2.0f + f9 * (f9 * f9));
        }
        return f5 + f2;
    }

    public static float easeOut(float f, float f2, float f3, float f4) {
        float f5 = f / f4 - 1.0f;
        return f2 + f3 * (1.0f + f5 * (f5 * f5));
    }
}

