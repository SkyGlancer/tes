/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 */
package app.dukhaan.src.java.com.airbnb.lottie;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

public class SimpleColorFilter
extends PorterDuffColorFilter {
    public SimpleColorFilter(int n) {
        super(n, PorterDuff.Mode.SRC_ATOP);
    }
}

