/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package app.dukhaan.src.java.com.getkeepsafe.relinker;

import android.os.Build;
import com.getkeepsafe.relinker.ReLinker;
import com.getkeepsafe.relinker.TextUtils;

final class SystemLibraryLoader
implements ReLinker.LibraryLoader {
    SystemLibraryLoader() {
    }

    @Override
    public void loadLibrary(String string2) {
        System.loadLibrary((String)string2);
    }

    @Override
    public void loadPath(String string2) {
        System.load((String)string2);
    }

    @Override
    public String mapLibraryName(String string2) {
        if (string2.startsWith("lib") && string2.endsWith(".so")) {
            return string2;
        }
        return System.mapLibraryName((String)string2);
    }

    @Override
    public String[] supportedAbis() {
        if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
            return Build.SUPPORTED_ABIS;
        }
        if (!TextUtils.isEmpty(Build.CPU_ABI2)) {
            String[] arrstring = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            return arrstring;
        }
        String[] arrstring = new String[]{Build.CPU_ABI};
        return arrstring;
    }

    @Override
    public String unmapLibraryName(String string2) {
        return string2.substring(3, string2.length() - 3);
    }
}

