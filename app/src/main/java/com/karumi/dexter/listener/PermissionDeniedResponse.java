/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.karumi.dexter.listener;

import com.karumi.dexter.listener.PermissionRequest;

public final class PermissionDeniedResponse {
    private final boolean permanentlyDenied;
    private final PermissionRequest requestedPermission;

    public PermissionDeniedResponse(PermissionRequest permissionRequest, boolean bl) {
        this.requestedPermission = permissionRequest;
        this.permanentlyDenied = bl;
    }

    public static PermissionDeniedResponse from(String string2, boolean bl) {
        return new PermissionDeniedResponse(new PermissionRequest(string2), bl);
    }

    public String getPermissionName() {
        return this.requestedPermission.getName();
    }

    public PermissionRequest getRequestedPermission() {
        return this.requestedPermission;
    }

    public boolean isPermanentlyDenied() {
        return this.permanentlyDenied;
    }
}

