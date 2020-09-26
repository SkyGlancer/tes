/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.airbnb.lottie.utils;

public class GammaEvaluator {
    private static float EOCF_sRGB(float f) {
        if (f <= 0.04045f) {
            return f / 12.92f;
        }
        return (float)Math.pow((double)((f + 0.055f) / 1.055f), (double)2.4000000953674316);
    }

    private static float OECF_sRGB(float f) {
        if (f <= 0.0031308f) {
            return f * 12.92f;
        }
        return (float)(1.0549999475479126 * Math.pow((double)f, (double)0.4166666567325592) - 0.054999999701976776);
    }

    public static int evaluate(float f, int n, int n2) {
        if (n == n2) {
            return n;
        }
        float f2 = (float)(255 & n >> 24) / 255.0f;
        float f3 = (float)(255 & n >> 16) / 255.0f;
        float f4 = (float)(255 & n >> 8) / 255.0f;
        float f5 = (float)(n & 255) / 255.0f;
        float f6 = (float)(255 & n2 >> 24) / 255.0f;
        float f7 = (float)(255 & n2 >> 16) / 255.0f;
        float f8 = (float)(255 & n2 >> 8) / 255.0f;
        float f9 = (float)(n2 & 255) / 255.0f;
        float f10 = GammaEvaluator.EOCF_sRGB(f3);
        float f11 = GammaEvaluator.EOCF_sRGB(f4);
        float f12 = GammaEvaluator.EOCF_sRGB(f5);
        float f13 = GammaEvaluator.EOCF_sRGB(f7);
        float f14 = GammaEvaluator.EOCF_sRGB(f8);
        float f15 = GammaEvaluator.EOCF_sRGB(f9);
        float f16 = f2 + f * (f6 - f2);
        float f17 = f10 + f * (f13 - f10);
        float f18 = f11 + f * (f14 - f11);
        float f19 = f12 + f * (f15 - f12);
        float f20 = f16 * 255.0f;
        float f21 = 255.0f * GammaEvaluator.OECF_sRGB(f17);
        float f22 = 255.0f * GammaEvaluator.OECF_sRGB(f18);
        float f23 = 255.0f * GammaEvaluator.OECF_sRGB(f19);
        return Math.round((float)f20) << 24 | Math.round((float)f21) << 16 | Math.round((float)f22) << 8 | Math.round((float)f23);
    }
}

