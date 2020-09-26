/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.airbnb.lottie.utils;

public class MeanCalculator {
    private int n;
    private float sum;

    public void add(float f) {
        float f2;
        int n;
        this.sum = f2 = f + this.sum;
        this.n = n = 1 + this.n;
        if (n == Integer.MAX_VALUE) {
            this.sum = f2 / 2.0f;
            this.n = n / 2;
        }
    }

    public float getMean() {
        int n = this.n;
        if (n == 0) {
            return 0.0f;
        }
        return this.sum / (float)n;
    }
}

