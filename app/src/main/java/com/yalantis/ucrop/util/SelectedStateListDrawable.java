/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 */
package app.dukhaan.src.java.com.yalantis.ucrop.util;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

public class SelectedStateListDrawable
extends StateListDrawable {
    private int mSelectionColor;

    public SelectedStateListDrawable(Drawable drawable2, int n) {
        this.mSelectionColor = n;
        this.addState(new int[]{16842913}, drawable2);
        this.addState(new int[0], drawable2);
    }

    public boolean isStateful() {
        return true;
    }

    protected boolean onStateChange(int[] arrn) {
        int n = arrn.length;
        boolean bl = false;
        for (int i = 0; i < n; ++i) {
            if (arrn[i] != 16842913) continue;
            bl = true;
        }
        if (bl) {
            super.setColorFilter(this.mSelectionColor, PorterDuff.Mode.SRC_ATOP);
        } else {
            super.clearColorFilter();
        }
        return super.onStateChange(arrn);
    }
}

