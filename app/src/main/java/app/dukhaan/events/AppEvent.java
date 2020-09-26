/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.events;

public class AppEvent {
    public static int INTERNET_CONNECTION_CHECK = 5;
    public static int NAVIGATE_TO_ORDERS = 2;
    public static int NAVIGATE_TO_PRODUCTS = 6;
    public static int NEW_ORDER = 3;
    public static int PLAY_NEW_ORDER_SOUND = 4;
    public static int REFRESH_STATS = 1;
    public String data;
    public int type;

    public AppEvent(int n, String string2) {
        this.type = n;
        this.data = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AppEvent{type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", data='");
        stringBuilder.append(this.data);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

