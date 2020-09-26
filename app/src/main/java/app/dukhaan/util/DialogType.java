/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.util;

public final class DialogType
extends Enum<DialogType> {
    private static final /* synthetic */ DialogType[] $VALUES;
    public static final /* enum */ DialogType DECLINE;
    public static final /* enum */ DialogType DELETE;
    public static final /* enum */ DialogType DELETE_CATEGORY;
    public static final /* enum */ DialogType MARKED;

    static {
        DialogType dialogType;
        MARKED = new DialogType();
        DELETE = new DialogType();
        DECLINE = new DialogType();
        DELETE_CATEGORY = dialogType = new DialogType();
        DialogType[] arrdialogType = new DialogType[]{MARKED, DELETE, DECLINE, dialogType};
        $VALUES = arrdialogType;
    }

    public static DialogType valueOf(String string2) {
        return (DialogType)Enum.valueOf(DialogType.class, (String)string2);
    }

    public static DialogType[] values() {
        return (DialogType[])$VALUES.clone();
    }
}

