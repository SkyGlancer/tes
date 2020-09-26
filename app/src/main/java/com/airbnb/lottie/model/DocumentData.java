/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.model;

public class DocumentData {
    public final float baselineShift;
    public final int color;
    public final String fontName;
    public final Justification justification;
    public final float lineHeight;
    public final float size;
    public final int strokeColor;
    public final boolean strokeOverFill;
    public final float strokeWidth;
    public final String text;
    public final int tracking;

    public DocumentData(String string2, String string3, float f, Justification justification, int n, float f2, float f3, int n2, int n3, float f4, boolean bl) {
        this.text = string2;
        this.fontName = string3;
        this.size = f;
        this.justification = justification;
        this.tracking = n;
        this.lineHeight = f2;
        this.baselineShift = f3;
        this.color = n2;
        this.strokeColor = n3;
        this.strokeWidth = f4;
        this.strokeOverFill = bl;
    }

    public int hashCode() {
        int n = 31 * (31 * (int)((float)(31 * (31 * this.text.hashCode() + this.fontName.hashCode())) + this.size) + this.justification.ordinal()) + this.tracking;
        long l = Float.floatToRawIntBits((float)this.lineHeight);
        return 31 * (n * 31 + (int)(l ^ l >>> 32)) + this.color;
    }

    public static final class Justification
    extends Enum<Justification> {
        private static final /* synthetic */ Justification[] $VALUES;
        public static final /* enum */ Justification CENTER;
        public static final /* enum */ Justification LEFT_ALIGN;
        public static final /* enum */ Justification RIGHT_ALIGN;

        static {
            Justification justification;
            LEFT_ALIGN = new Justification();
            RIGHT_ALIGN = new Justification();
            CENTER = justification = new Justification();
            Justification[] arrjustification = new Justification[]{LEFT_ALIGN, RIGHT_ALIGN, justification};
            $VALUES = arrjustification;
        }

        public static Justification valueOf(String string2) {
            return (Justification)Enum.valueOf(Justification.class, (String)string2);
        }

        public static Justification[] values() {
            return (Justification[])$VALUES.clone();
        }
    }

}

