/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.content.Intent
 *  com.karumi.dexter.DexterActivity
 *  com.karumi.dexter.MultiplePermissionListenerThreadDecorator
 *  com.karumi.dexter.MultiplePermissionsListenerToPermissionListenerAdapter
 *  com.karumi.dexter.PermissionRationaleToken
 *  com.karumi.dexter.listener.multi.BaseMultiplePermissionsListener
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.TreeSet
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package app.dukhaan.src.java.com.karumi.dexter;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.karumi.dexter.AndroidPermissionService;
import com.karumi.dexter.DexterActivity;
import com.karumi.dexter.DexterException;
import com.karumi.dexter.IntentProvider;
import com.karumi.dexter.MultiplePermissionListenerThreadDecorator;
import com.karumi.dexter.MultiplePermissionsListenerToPermissionListenerAdapter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionRationaleToken;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.Thread;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.BaseMultiplePermissionsListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;

final class DexterInstance {
    private static final MultiplePermissionsListener EMPTY_LISTENER = new BaseMultiplePermissionsListener();
    private static final int PERMISSIONS_REQUEST_CODE = 42;
    private Activity activity;
    private final AndroidPermissionService androidPermissionService;
    private WeakReference<Context> context;
    private final IntentProvider intentProvider;
    private final AtomicBoolean isRequestingPermission;
    private final AtomicBoolean isShowingNativeDialog;
    private MultiplePermissionsListener listener = EMPTY_LISTENER;
    private final MultiplePermissionsReport multiplePermissionsReport;
    private final Collection<String> pendingPermissions;
    private final Object pendingPermissionsMutex = new Object();
    private final AtomicBoolean rationaleAccepted;

    DexterInstance(Context context, AndroidPermissionService androidPermissionService, IntentProvider intentProvider) {
        this.androidPermissionService = androidPermissionService;
        this.intentProvider = intentProvider;
        this.pendingPermissions = new TreeSet();
        this.multiplePermissionsReport = new MultiplePermissionsReport();
        this.isRequestingPermission = new AtomicBoolean();
        this.rationaleAccepted = new AtomicBoolean();
        this.isShowingNativeDialog = new AtomicBoolean();
        this.setContext(context);
    }

    private void checkMultiplePermissions(final MultiplePermissionsListener multiplePermissionsListener, final Collection<String> collection, java.lang.Thread thread) {
        this.checkNoDexterRequestOngoing();
        this.checkRequestSomePermission(collection);
        if (this.context.get() == null) {
            return;
        }
        Activity activity = this.activity;
        if (activity != null && activity.isFinishing()) {
            this.onActivityDestroyed();
        }
        this.pendingPermissions.clear();
        this.pendingPermissions.addAll(collection);
        this.multiplePermissionsReport.clear();
        this.listener = new MultiplePermissionListenerThreadDecorator(multiplePermissionsListener, thread);
        if (this.isEveryPermissionGranted(collection, (Context)this.context.get())) {
            thread.execute(new Runnable(){

                public void run() {
                    MultiplePermissionsReport multiplePermissionsReport = new MultiplePermissionsReport();
                    Iterator iterator = collection.iterator();
                    while (iterator.hasNext()) {
                        multiplePermissionsReport.addGrantedPermissionResponse(PermissionGrantedResponse.from((String)iterator.next()));
                    }
                    DexterInstance.this.isRequestingPermission.set(false);
                    multiplePermissionsListener.onPermissionsChecked(multiplePermissionsReport);
                    DexterInstance.this.listener = EMPTY_LISTENER;
                }
            });
        } else {
            this.startTransparentActivityIfNeeded();
        }
        thread.loop();
    }

    private void checkNoDexterRequestOngoing() {
        if (!this.isRequestingPermission.getAndSet(true)) {
            return;
        }
        throw new DexterException("Only one Dexter request at a time is allowed", DexterError.REQUEST_ONGOING);
    }

    private void checkRequestSomePermission(Collection<String> collection) {
        if (!collection.isEmpty()) {
            return;
        }
        throw new DexterException("Dexter has to be called with at least one permission", DexterError.NO_PERMISSIONS_REQUESTED);
    }

    private int checkSelfPermission(Activity activity, String string2) {
        try {
            int n = this.androidPermissionService.checkSelfPermission((Context)activity, string2);
            return n;
        }
        catch (RuntimeException runtimeException) {
            return -1;
        }
    }

    private void checkSinglePermission(PermissionListener permissionListener, String string2, java.lang.Thread thread) {
        this.checkMultiplePermissions((MultiplePermissionsListener)new MultiplePermissionsListenerToPermissionListenerAdapter(permissionListener), (Collection<String>)Collections.singleton((Object)string2), thread);
    }

    private PermissionStates getPermissionStates(Collection<String> collection) {
        PermissionStates permissionStates = new PermissionStates();
        for (String string2 : collection) {
            int n = this.checkSelfPermission(this.activity, string2);
            if (n != -2) {
                if (n != -1) {
                    permissionStates.addGrantedPermission(string2);
                    continue;
                }
                permissionStates.addDeniedPermission(string2);
                continue;
            }
            permissionStates.addImpossibleToGrantPermission(string2);
        }
        return permissionStates;
    }

    private void handleDeniedPermissions(Collection<String> collection) {
        if (collection.isEmpty()) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (String string2 : collection) {
            if (!this.androidPermissionService.shouldShowRequestPermissionRationale(this.activity, string2)) continue;
            linkedList.add((Object)new PermissionRequest(string2));
        }
        if (linkedList.isEmpty()) {
            this.requestPermissionsToSystem(collection);
            return;
        }
        if (!this.rationaleAccepted.get()) {
            PermissionRationaleToken permissionRationaleToken = new PermissionRationaleToken(this);
            this.listener.onPermissionRationaleShouldBeShown((List<PermissionRequest>)linkedList, (PermissionToken)permissionRationaleToken);
        }
    }

    private boolean isEveryPermissionGranted(Collection<String> collection, Context context) {
        for (String string2 : collection) {
            if (this.androidPermissionService.checkSelfPermission(context, string2) == 0) continue;
            return false;
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void onPermissionsChecked(Collection<String> collection) {
        Object object;
        if (this.pendingPermissions.isEmpty()) {
            return;
        }
        Object object2 = object = this.pendingPermissionsMutex;
        synchronized (object2) {
            this.pendingPermissions.removeAll(collection);
            if (this.pendingPermissions.isEmpty()) {
                if (this.activity != null) {
                    this.activity.finish();
                }
                this.isRequestingPermission.set(false);
                this.rationaleAccepted.set(false);
                this.isShowingNativeDialog.set(false);
                MultiplePermissionsListener multiplePermissionsListener = this.listener;
                this.listener = EMPTY_LISTENER;
                multiplePermissionsListener.onPermissionsChecked(this.multiplePermissionsReport);
            }
            return;
        }
    }

    private void requestPermissionsToSystem(Collection<String> collection) {
        if (!this.isShowingNativeDialog.get()) {
            this.androidPermissionService.requestPermissions(this.activity, (String[])collection.toArray((Object[])new String[0]), 42);
        }
        this.isShowingNativeDialog.set(true);
    }

    private void startTransparentActivityIfNeeded() {
        Context context = (Context)this.context.get();
        if (context == null) {
            return;
        }
        Intent intent = this.intentProvider.get(context, DexterActivity.class);
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private void updatePermissionsAsDenied(Collection<String> collection) {
        for (String string2 : collection) {
            PermissionDeniedResponse permissionDeniedResponse = PermissionDeniedResponse.from(string2, this.androidPermissionService.isPermissionPermanentlyDenied(this.activity, string2));
            this.multiplePermissionsReport.addDeniedPermissionResponse(permissionDeniedResponse);
        }
        this.onPermissionsChecked(collection);
    }

    private void updatePermissionsAsGranted(Collection<String> collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            PermissionGrantedResponse permissionGrantedResponse = PermissionGrantedResponse.from((String)iterator.next());
            this.multiplePermissionsReport.addGrantedPermissionResponse(permissionGrantedResponse);
        }
        this.onPermissionsChecked(collection);
    }

    void checkPermission(PermissionListener permissionListener, String string2, java.lang.Thread thread) {
        this.checkSinglePermission(permissionListener, string2, thread);
    }

    void checkPermissions(MultiplePermissionsListener multiplePermissionsListener, Collection<String> collection, java.lang.Thread thread) {
        this.checkMultiplePermissions(multiplePermissionsListener, collection, thread);
    }

    void onActivityDestroyed() {
        if (this.activity != null) {
            this.activity = null;
            this.isRequestingPermission.set(false);
            this.rationaleAccepted.set(false);
            this.isShowingNativeDialog.set(false);
            this.listener = EMPTY_LISTENER;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void onActivityReady(Activity activity) {
        Object object;
        PermissionStates permissionStates;
        this.activity = activity;
        Object object2 = object = this.pendingPermissionsMutex;
        synchronized (object2) {
            if (activity == null) return;
            permissionStates = this.getPermissionStates(this.pendingPermissions);
        }
        if (permissionStates == null) return;
        this.handleDeniedPermissions((Collection<String>)permissionStates.getDeniedPermissions());
        this.updatePermissionsAsDenied(permissionStates.getImpossibleToGrantPermissions());
        this.updatePermissionsAsGranted((Collection<String>)permissionStates.getGrantedPermissions());
    }

    void onCancelPermissionRequest() {
        this.rationaleAccepted.set(false);
        this.updatePermissionsAsDenied(this.pendingPermissions);
    }

    void onContinuePermissionRequest() {
        this.rationaleAccepted.set(true);
        this.requestPermissionsToSystem(this.pendingPermissions);
    }

    void onPermissionRequestDenied(Collection<String> collection) {
        this.updatePermissionsAsDenied(collection);
    }

    void onPermissionRequestGranted(Collection<String> collection) {
        this.updatePermissionsAsGranted(collection);
    }

    void setContext(Context context) {
        this.context = new WeakReference((Object)context);
    }

    private final class PermissionStates {
        private final Collection<String> deniedPermissions = new LinkedList();
        private final Collection<String> grantedPermissions = new LinkedList();
        private final Collection<String> impossibleToGrantPermissions = new LinkedList();

        private PermissionStates() {
        }

        private void addDeniedPermission(String string2) {
            this.deniedPermissions.add((Object)string2);
        }

        private void addGrantedPermission(String string2) {
            this.grantedPermissions.add((Object)string2);
        }

        private void addImpossibleToGrantPermission(String string2) {
            this.impossibleToGrantPermissions.add((Object)string2);
        }

        private Collection<String> getDeniedPermissions() {
            return this.deniedPermissions;
        }

        private Collection<String> getGrantedPermissions() {
            return this.grantedPermissions;
        }

        public Collection<String> getImpossibleToGrantPermissions() {
            return this.impossibleToGrantPermissions;
        }
    }

}

