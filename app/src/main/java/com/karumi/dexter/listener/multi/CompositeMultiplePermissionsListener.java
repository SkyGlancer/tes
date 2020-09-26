/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package app.dukhaan.src.java.com.karumi.dexter.listener.multi;

import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CompositeMultiplePermissionsListener
implements MultiplePermissionsListener {
    private final Collection<MultiplePermissionsListener> listeners;

    public CompositeMultiplePermissionsListener(Collection<MultiplePermissionsListener> collection) {
        this.listeners = collection;
    }

    public /* varargs */ CompositeMultiplePermissionsListener(MultiplePermissionsListener ... arrmultiplePermissionsListener) {
        this((Collection<MultiplePermissionsListener>)Arrays.asList((Object[])arrmultiplePermissionsListener));
    }

    @Override
    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((MultiplePermissionsListener)iterator.next()).onPermissionRationaleShouldBeShown(list, permissionToken);
        }
    }

    @Override
    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((MultiplePermissionsListener)iterator.next()).onPermissionsChecked(multiplePermissionsReport);
        }
    }
}

