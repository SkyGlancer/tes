/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.model;

public class Font {
    private final float ascent;
    private final String family;
    private final String name;
    private final String style;

    public Font(String string2, String string3, String string4, float f) {
        this.family = string2;
        this.name = string3;
        this.style = string4;
        this.ascent = f;
    }

    float getAscent() {
        return this.ascent;
    }

    public String getFamily() {
        return this.family;
    }

    public String getName() {
        return this.name;
    }

    public String getStyle() {
        return this.style;
    }
}

