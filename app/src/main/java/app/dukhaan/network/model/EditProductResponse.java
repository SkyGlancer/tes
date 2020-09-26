/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.network.model;

import com.google.gson.annotations.SerializedName;

public class EditProductResponse {
    @SerializedName(value="status")
    private String status;
    @SerializedName(value="status_code")
    private int statusCode;

    public String getStatus() {
        return this.status;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatus(String string2) {
        this.status = string2;
    }

    public void setStatusCode(int n) {
        this.statusCode = n;
    }
}

