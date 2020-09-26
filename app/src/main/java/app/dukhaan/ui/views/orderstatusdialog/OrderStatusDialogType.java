/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.views.orderstatusdialog;

public final class OrderStatusDialogType
extends Enum<OrderStatusDialogType> {
    private static final /* synthetic */ OrderStatusDialogType[] $VALUES;
    public static final /* enum */ OrderStatusDialogType ACCEPT;
    public static final /* enum */ OrderStatusDialogType CANCEL_ORDER;
    public static final /* enum */ OrderStatusDialogType DECLINE;
    public static final /* enum */ OrderStatusDialogType DELIVERED;
    public static final /* enum */ OrderStatusDialogType SHIP;

    static {
        OrderStatusDialogType orderStatusDialogType;
        ACCEPT = new OrderStatusDialogType();
        SHIP = new OrderStatusDialogType();
        DECLINE = new OrderStatusDialogType();
        DELIVERED = new OrderStatusDialogType();
        CANCEL_ORDER = orderStatusDialogType = new OrderStatusDialogType();
        OrderStatusDialogType[] arrorderStatusDialogType = new OrderStatusDialogType[]{ACCEPT, SHIP, DECLINE, DELIVERED, orderStatusDialogType};
        $VALUES = arrorderStatusDialogType;
    }

    public static OrderStatusDialogType valueOf(String string2) {
        return (OrderStatusDialogType)Enum.valueOf(OrderStatusDialogType.class, (String)string2);
    }

    public static OrderStatusDialogType[] values() {
        return (OrderStatusDialogType[])$VALUES.clone();
    }
}

