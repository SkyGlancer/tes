/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.content;

public final class GradientType
extends Enum<GradientType> {
    private static final /* synthetic */ GradientType[] $VALUES;
    public static final /* enum */ GradientType LINEAR;
    public static final /* enum */ GradientType RADIAL;

    static {
        GradientType gradientType;
        LINEAR = new GradientType();
        RADIAL = gradientType = new GradientType();
        GradientType[] arrgradientType = new GradientType[]{LINEAR, gradientType};
        $VALUES = arrgradientType;
    }

    public static GradientType valueOf(String string2) {
        return (GradientType)Enum.valueOf(GradientType.class, (String)string2);
    }

    public static GradientType[] values() {
        return (GradientType[])$VALUES.clone();
    }
}

