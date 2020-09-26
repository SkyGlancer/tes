/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.data.model.Business
 *  com.google.gson.annotations.SerializedName
 *  java.lang.String
 */
package app.dukhaan.network.model;

import app.dukhaan.data.model.Business;
import app.dukhaan.network.model.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class AddBusinessResponse
extends BaseResponse {
    @SerializedName(value="data")
    public Business business;
    @SerializedName(value="detail")
    public String token;
}

