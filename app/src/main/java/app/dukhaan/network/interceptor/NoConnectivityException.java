/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.IOException
 *  java.lang.String
 */
package app.dukhaan.network.interceptor;

import android.content.Context;
import java.io.IOException;

public class NoConnectivityException
extends IOException {
    private Context context;

    public NoConnectivityException(Context context) {
        this.context = context;
    }

    public String getMessage() {
        return this.context.getString(2131951775);
    }
}

