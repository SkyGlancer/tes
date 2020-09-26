/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.model.animatable.AnimatableIntegerValue
 *  com.airbnb.lottie.model.animatable.AnimatableShapeValue
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;

public class Mask {
    private final boolean inverted;
    private final MaskMode maskMode;
    private final AnimatableShapeValue maskPath;
    private final AnimatableIntegerValue opacity;

    public Mask(MaskMode maskMode, AnimatableShapeValue animatableShapeValue, AnimatableIntegerValue animatableIntegerValue, boolean bl) {
        this.maskMode = maskMode;
        this.maskPath = animatableShapeValue;
        this.opacity = animatableIntegerValue;
        this.inverted = bl;
    }

    public MaskMode getMaskMode() {
        return this.maskMode;
    }

    public AnimatableShapeValue getMaskPath() {
        return this.maskPath;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    public boolean isInverted() {
        return this.inverted;
    }

    public static final class MaskMode
    extends Enum<MaskMode> {
        private static final /* synthetic */ MaskMode[] $VALUES;
        public static final /* enum */ MaskMode MASK_MODE_ADD;
        public static final /* enum */ MaskMode MASK_MODE_INTERSECT;
        public static final /* enum */ MaskMode MASK_MODE_NONE;
        public static final /* enum */ MaskMode MASK_MODE_SUBTRACT;

        static {
            MaskMode maskMode;
            MASK_MODE_ADD = new MaskMode();
            MASK_MODE_SUBTRACT = new MaskMode();
            MASK_MODE_INTERSECT = new MaskMode();
            MASK_MODE_NONE = maskMode = new MaskMode();
            MaskMode[] arrmaskMode = new MaskMode[]{MASK_MODE_ADD, MASK_MODE_SUBTRACT, MASK_MODE_INTERSECT, maskMode};
            $VALUES = arrmaskMode;
        }

        public static MaskMode valueOf(String string2) {
            return (MaskMode)Enum.valueOf(MaskMode.class, (String)string2);
        }

        public static MaskMode[] values() {
            return (MaskMode[])$VALUES.clone();
        }
    }

}

