/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie;

public final class RenderMode
extends Enum<RenderMode> {
    private static final /* synthetic */ RenderMode[] $VALUES;
    public static final /* enum */ RenderMode AUTOMATIC;
    public static final /* enum */ RenderMode HARDWARE;
    public static final /* enum */ RenderMode SOFTWARE;

    static {
        RenderMode renderMode;
        AUTOMATIC = new RenderMode();
        HARDWARE = new RenderMode();
        SOFTWARE = renderMode = new RenderMode();
        RenderMode[] arrrenderMode = new RenderMode[]{AUTOMATIC, HARDWARE, renderMode};
        $VALUES = arrrenderMode;
    }

    public static RenderMode valueOf(String string2) {
        return (RenderMode)Enum.valueOf(RenderMode.class, (String)string2);
    }

    public static RenderMode[] values() {
        return (RenderMode[])$VALUES.clone();
    }
}

