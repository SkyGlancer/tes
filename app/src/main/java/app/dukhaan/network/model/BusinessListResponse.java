/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.data.model.Business
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.network.model;

import app.dukhaan.data.model.Business;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BusinessListResponse {
    @SerializedName(value="results")
    public List<Business> businesses;
    public int count;
    @SerializedName(value="token")
    public String token;
}

