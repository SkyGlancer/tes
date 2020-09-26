/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.String
 */
package app.dukhaan.src.java.com.karumi.dexter;

import com.karumi.dexter.listener.DexterError;

final class DexterException
extends IllegalStateException {
    final DexterError error;

    DexterException(String string2, DexterError dexterError) {
        super(string2);
        this.error = dexterError;
    }
}

