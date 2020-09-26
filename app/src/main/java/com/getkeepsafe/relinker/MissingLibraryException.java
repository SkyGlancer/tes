/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package app.dukhaan.src.java.com.getkeepsafe.relinker;

import java.util.Arrays;

public class MissingLibraryException
extends RuntimeException {
    public MissingLibraryException(String string2, String[] arrstring, String[] arrstring2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not find '");
        stringBuilder.append(string2);
        stringBuilder.append("'. Looked for: ");
        stringBuilder.append(Arrays.toString((Object[])arrstring));
        stringBuilder.append(", but only found: ");
        stringBuilder.append(Arrays.toString((Object[])arrstring2));
        stringBuilder.append(".");
        super(stringBuilder.toString());
    }
}

