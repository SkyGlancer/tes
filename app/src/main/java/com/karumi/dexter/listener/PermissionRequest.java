/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.src.java.com.karumi.dexter.listener;

public final class PermissionRequest {
    private final String name;

    public PermissionRequest(String string2) {
        this.name = string2;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Permission name: ");
        stringBuilder.append(this.name);
        return stringBuilder.toString();
    }
}

