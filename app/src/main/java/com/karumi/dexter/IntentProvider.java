/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.Class
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.karumi.dexter;

import android.content.Context;
import android.content.Intent;

class IntentProvider {
    IntentProvider() {
    }

    public Intent get(Context context, Class<?> class_) {
        return new Intent(context, class_);
    }
}

