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

public class MapTokenResponse {
    @SerializedName(value="access_token")
    public String access_token;
    @SerializedName(value="status_code")
    public int statusCode;
    @SerializedName(value="token_type")
    public String token_type;
}

