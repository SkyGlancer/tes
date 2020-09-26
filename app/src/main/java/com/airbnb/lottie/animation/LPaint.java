/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Xfermode
 *  android.os.LocaleList
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.LocaleList;

public class LPaint
extends Paint {
    public LPaint() {
    }

    public LPaint(int n) {
        super(n);
    }

    public LPaint(int n, PorterDuff.Mode mode) {
        super(n);
        this.setXfermode((Xfermode)new PorterDuffXfermode(mode));
    }

    public LPaint(PorterDuff.Mode mode) {
        this.setXfermode((Xfermode)new PorterDuffXfermode(mode));
    }

    public void setTextLocales(LocaleList localeList) {
    }
}

