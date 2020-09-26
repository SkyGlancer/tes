/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 */
package app.dukhaan.src.java.com.karumi.dexter.listener.single;

import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CompositePermissionListener
implements PermissionListener {
    private final Collection<PermissionListener> listeners;

    public CompositePermissionListener(Collection<PermissionListener> collection) {
        this.listeners = collection;
    }

    public /* varargs */ CompositePermissionListener(PermissionListener ... arrpermissionListener) {
        this((Collection<PermissionListener>)Arrays.asList((Object[])arrpermissionListener));
    }

    @Override
    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((PermissionListener)iterator.next()).onPermissionDenied(permissionDeniedResponse);
        }
    }

    @Override
    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((PermissionListener)iterator.next()).onPermissionGranted(permissionGrantedResponse);
        }
    }

    @Override
    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((PermissionListener)iterator.next()).onPermissionRationaleShouldBeShown(permissionRequest, permissionToken);
        }
    }
}

