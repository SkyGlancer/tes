/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 */
package app.dukhaan.src.java.com.karumi.dexter;

import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;
import java.util.Collection;

public interface DexterBuilder {
    public void check();

    public DexterBuilder onSameThread();

    public DexterBuilder withErrorListener(PermissionRequestErrorListener var1);

    public static interface MultiPermissionListener {
        public DexterBuilder withListener(MultiplePermissionsListener var1);
    }

    public static interface Permission {
        public SinglePermissionListener withPermission(String var1);

        public MultiPermissionListener withPermissions(Collection<String> var1);

        public /* varargs */ MultiPermissionListener withPermissions(String... var1);
    }

    public static interface SinglePermissionListener {
        public DexterBuilder withListener(PermissionListener var1);
    }

}

