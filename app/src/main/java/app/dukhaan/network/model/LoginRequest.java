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

public class LoginRequest {
    @SerializedName(value="firebase_id_token")
    public String firebaseIdToken;
    public String phone;
    @SerializedName(value="referred_by")
    public String referredBy;
}

