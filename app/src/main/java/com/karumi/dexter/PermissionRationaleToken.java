/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.karumi.dexter;

import com.karumi.dexter.DexterInstance;
import com.karumi.dexter.PermissionToken;

final class PermissionRationaleToken
implements PermissionToken {
    private final DexterInstance dexterInstance;
    private boolean isTokenResolved = false;

    PermissionRationaleToken(DexterInstance dexterInstance) {
        this.dexterInstance = dexterInstance;
    }

    @Override
    public void cancelPermissionRequest() {
        if (!this.isTokenResolved) {
            this.dexterInstance.onCancelPermissionRequest();
            this.isTokenResolved = true;
        }
    }

    @Override
    public void continuePermissionRequest() {
        if (!this.isTokenResolved) {
            this.dexterInstance.onContinuePermissionRequest();
            this.isTokenResolved = true;
        }
    }
}

