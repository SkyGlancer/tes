/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.data.model.BusinessStats
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.network.model;

import app.dukhaan.data.model.BusinessStats;
import com.google.gson.annotations.SerializedName;

public class BusinessStatsResponse {
    @SerializedName(value="data")
    public BusinessStats stats;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BusinessStatsResponse{stats=");
        stringBuilder.append((Object)this.stats);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

