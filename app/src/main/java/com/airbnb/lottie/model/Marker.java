/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.model;

public class Marker {
    private static String CARRIAGE_RETURN = "\r";
    public final float durationFrames;
    private final String name;
    public final float startFrame;

    public Marker(String string2, float f, float f2) {
        this.name = string2;
        this.durationFrames = f2;
        this.startFrame = f;
    }

    public boolean matchesName(String string2) {
        String string3;
        if (this.name.equalsIgnoreCase(string2)) {
            return true;
        }
        return this.name.endsWith(CARRIAGE_RETURN) && (string3 = this.name).substring(0, string3.length() - 1).equalsIgnoreCase(string2);
    }
}

