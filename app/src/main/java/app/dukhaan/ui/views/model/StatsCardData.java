/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.ui.views.model;

public class StatsCardData {
    public String label;
    public String value;

    public StatsCardData(String string2, String string3) {
        this.label = string2;
        this.value = string3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StatsCardData{label='");
        stringBuilder.append(this.label);
        stringBuilder.append('\'');
        stringBuilder.append(", value='");
        stringBuilder.append(this.value);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

