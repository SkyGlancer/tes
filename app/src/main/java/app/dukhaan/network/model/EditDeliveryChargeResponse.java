/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.data.model.Business
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.network.model;

import app.dukhaan.data.model.Business;
import com.google.gson.annotations.SerializedName;

public class EditDeliveryChargeResponse {
    @SerializedName(value="data")
    public Business business;
    public String status;
    @SerializedName(value="status_code")
    public int statusCode;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EditDeliveryChargeResponse{statusCode=");
        stringBuilder.append(this.statusCode);
        stringBuilder.append(", status='");
        stringBuilder.append(this.status);
        stringBuilder.append('\'');
        stringBuilder.append(", business=");
        stringBuilder.append((Object)this.business);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

