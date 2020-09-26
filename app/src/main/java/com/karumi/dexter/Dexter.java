/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 */
package app.dukhaan.src.java.com.karumi.dexter;

import android.app.Activity;
import android.content.Context;
import com.karumi.dexter.AndroidPermissionService;
import com.karumi.dexter.DexterBuilder;
import com.karumi.dexter.DexterException;
import com.karumi.dexter.DexterInstance;
import com.karumi.dexter.IntentProvider;
import com.karumi.dexter.MultiplePermissionsListenerToPermissionListenerAdapter;
import com.karumi.dexter.Thread;
import com.karumi.dexter.ThreadFactory;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.EmptyPermissionRequestErrorListener;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.BaseMultiplePermissionsListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Dexter
implements DexterBuilder,
DexterBuilder.Permission,
DexterBuilder.SinglePermissionListener,
DexterBuilder.MultiPermissionListener {
    private static DexterInstance instance;
    private PermissionRequestErrorListener errorListener = new EmptyPermissionRequestErrorListener();
    private MultiplePermissionsListener listener = new BaseMultiplePermissionsListener();
    private Collection<String> permissions;
    private boolean shouldExecuteOnSameThread = false;

    private Dexter(Context context) {
        Dexter.initialize(context);
    }

    private Thread getThread() {
        if (this.shouldExecuteOnSameThread) {
            return ThreadFactory.makeSameThread();
        }
        return ThreadFactory.makeMainThread();
    }

    private static void initialize(Context context) {
        DexterInstance dexterInstance = instance;
        if (dexterInstance == null) {
            instance = new DexterInstance(context, new AndroidPermissionService(), new IntentProvider());
            return;
        }
        dexterInstance.setContext(context);
    }

    static void onActivityDestroyed() {
        DexterInstance dexterInstance = instance;
        if (dexterInstance != null) {
            dexterInstance.onActivityDestroyed();
        }
    }

    static void onActivityReady(Activity activity) {
        DexterInstance dexterInstance = instance;
        if (dexterInstance != null) {
            dexterInstance.onActivityReady(activity);
        }
    }

    static void onPermissionsRequested(Collection<String> collection, Collection<String> collection2) {
        DexterInstance dexterInstance = instance;
        if (dexterInstance != null) {
            dexterInstance.onPermissionRequestGranted(collection);
            instance.onPermissionRequestDenied(collection2);
        }
    }

    @Deprecated
    public static DexterBuilder.Permission withActivity(Activity activity) {
        return new Dexter((Context)activity);
    }

    public static DexterBuilder.Permission withContext(Context context) {
        return new Dexter(context);
    }

    @Override
    public void check() {
        try {
            Thread thread = this.getThread();
            instance.checkPermissions(this.listener, this.permissions, thread);
            return;
        }
        catch (DexterException dexterException) {
            this.errorListener.onError(dexterException.error);
            return;
        }
    }

    @Override
    public DexterBuilder onSameThread() {
        this.shouldExecuteOnSameThread = true;
        return this;
    }

    @Override
    public DexterBuilder withErrorListener(PermissionRequestErrorListener permissionRequestErrorListener) {
        this.errorListener = permissionRequestErrorListener;
        return this;
    }

    @Override
    public DexterBuilder withListener(MultiplePermissionsListener multiplePermissionsListener) {
        this.listener = multiplePermissionsListener;
        return this;
    }

    @Override
    public DexterBuilder withListener(PermissionListener permissionListener) {
        this.listener = new MultiplePermissionsListenerToPermissionListenerAdapter(permissionListener);
        return this;
    }

    @Override
    public DexterBuilder.SinglePermissionListener withPermission(String string2) {
        this.permissions = Collections.singletonList((Object)string2);
        return this;
    }

    @Override
    public DexterBuilder.MultiPermissionListener withPermissions(Collection<String> collection) {
        this.permissions = new ArrayList(collection);
        return this;
    }

    @Override
    public /* varargs */ DexterBuilder.MultiPermissionListener withPermissions(String ... arrstring) {
        this.permissions = Arrays.asList((Object[])arrstring);
        return this;
    }
}

