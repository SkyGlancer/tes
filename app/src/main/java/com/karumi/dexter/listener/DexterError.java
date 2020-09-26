/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.karumi.dexter.listener;

public final class DexterError
extends Enum<DexterError> {
    private static final /* synthetic */ DexterError[] $VALUES;
    public static final /* enum */ DexterError NO_PERMISSIONS_REQUESTED;
    public static final /* enum */ DexterError REQUEST_ONGOING;

    static {
        DexterError dexterError;
        REQUEST_ONGOING = new DexterError();
        NO_PERMISSIONS_REQUESTED = dexterError = new DexterError();
        DexterError[] arrdexterError = new DexterError[]{REQUEST_ONGOING, dexterError};
        $VALUES = arrdexterError;
    }

    public static DexterError valueOf(String string2) {
        return (DexterError)Enum.valueOf(DexterError.class, (String)string2);
    }

    public static DexterError[] values() {
        return (DexterError[])$VALUES.clone();
    }
}

