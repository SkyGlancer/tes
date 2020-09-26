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

public class AddBusinessRequest {
    public String address;
    public String country;
    @SerializedName(value="image")
    public String imageUrl;
    public double latitude;
    public double longitude;
    public String name;
}

