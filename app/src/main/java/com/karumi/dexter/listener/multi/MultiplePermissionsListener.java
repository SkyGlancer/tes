/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.src.java.com.karumi.dexter.listener.multi;

import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import java.util.List;

public interface MultiplePermissionsListener {
    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> var1, PermissionToken var2);

    public void onPermissionsChecked(MultiplePermissionsReport var1);
}

