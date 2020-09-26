/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 */
package app.dukhaan.src.java.com.karumi.dexter;

import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class MultiplePermissionsReport {
    private final List<PermissionDeniedResponse> deniedPermissionResponses = new LinkedList();
    private final List<PermissionGrantedResponse> grantedPermissionResponses = new LinkedList();

    MultiplePermissionsReport() {
    }

    boolean addDeniedPermissionResponse(PermissionDeniedResponse permissionDeniedResponse) {
        return this.deniedPermissionResponses.add((Object)permissionDeniedResponse);
    }

    boolean addGrantedPermissionResponse(PermissionGrantedResponse permissionGrantedResponse) {
        return this.grantedPermissionResponses.add((Object)permissionGrantedResponse);
    }

    public boolean areAllPermissionsGranted() {
        return this.deniedPermissionResponses.isEmpty();
    }

    void clear() {
        this.grantedPermissionResponses.clear();
        this.deniedPermissionResponses.clear();
    }

    public List<PermissionDeniedResponse> getDeniedPermissionResponses() {
        return this.deniedPermissionResponses;
    }

    public List<PermissionGrantedResponse> getGrantedPermissionResponses() {
        return this.grantedPermissionResponses;
    }

    public boolean isAnyPermissionPermanentlyDenied() {
        Iterator iterator = this.deniedPermissionResponses.iterator();
        while (iterator.hasNext()) {
            if (!((PermissionDeniedResponse)iterator.next()).isPermanentlyDenied()) continue;
            return true;
        }
        return false;
    }
}

