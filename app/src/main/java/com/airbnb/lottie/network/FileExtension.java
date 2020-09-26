/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.src.java.com.airbnb.lottie.network;

import com.airbnb.lottie.utils.Logger;

public final class FileExtension
extends Enum<FileExtension> {
    private static final /* synthetic */ FileExtension[] $VALUES;
    public static final /* enum */ FileExtension JSON;
    public static final /* enum */ FileExtension ZIP;
    public final String extension;

    static {
        FileExtension fileExtension;
        JSON = new FileExtension(".json");
        ZIP = fileExtension = new FileExtension(".zip");
        FileExtension[] arrfileExtension = new FileExtension[]{JSON, fileExtension};
        $VALUES = arrfileExtension;
    }

    private FileExtension(String string3) {
        this.extension = string3;
    }

    public static FileExtension forFile(String string2) {
        for (FileExtension fileExtension : FileExtension.values()) {
            if (!string2.endsWith(fileExtension.extension)) continue;
            return fileExtension;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to find correct extension for ");
        stringBuilder.append(string2);
        Logger.warning(stringBuilder.toString());
        return JSON;
    }

    public static FileExtension valueOf(String string2) {
        return (FileExtension)Enum.valueOf(FileExtension.class, (String)string2);
    }

    public static FileExtension[] values() {
        return (FileExtension[])$VALUES.clone();
    }

    public String tempExtension() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".temp");
        stringBuilder.append(this.extension);
        return stringBuilder.toString();
    }

    public String toString() {
        return this.extension;
    }
}

