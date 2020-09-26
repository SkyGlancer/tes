/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.karumi.dexter.listener.single;

import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;

public interface PermissionListener {
    public void onPermissionDenied(PermissionDeniedResponse var1);

    public void onPermissionGranted(PermissionGrantedResponse var1);

    public void onPermissionRationaleShouldBeShown(PermissionRequest var1, PermissionToken var2);
}

