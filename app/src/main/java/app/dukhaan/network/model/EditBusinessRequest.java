/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.network.model;

import com.google.gson.annotations.SerializedName;

public class EditBusinessRequest {
    public String address;
    public String country;
    @SerializedName(value="image")
    public String imageUrl;
    @SerializedName(value="whatsapp_chat_support")
    public boolean isWhatsAppChatSupportEnabled;
    public double latitude;
    public String link;
    public double longitude;
    public String name;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EditBusinessRequest{name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", country='");
        stringBuilder.append(this.country);
        stringBuilder.append('\'');
        stringBuilder.append(", address='");
        stringBuilder.append(this.address);
        stringBuilder.append('\'');
        stringBuilder.append(", imageUrl='");
        stringBuilder.append(this.imageUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", latitude=");
        stringBuilder.append(this.latitude);
        stringBuilder.append(", longitude=");
        stringBuilder.append(this.longitude);
        stringBuilder.append(", link=");
        stringBuilder.append(this.link);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

