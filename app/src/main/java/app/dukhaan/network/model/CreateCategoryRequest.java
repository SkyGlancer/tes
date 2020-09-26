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

public class CreateCategoryRequest {
    @SerializedName(value="business")
    private int businessId;
    private String name;

    public int getBusinessId() {
        return this.businessId;
    }

    public String getName() {
        return this.name;
    }

    public void setBusinessId(int n) {
        this.businessId = n;
    }

    public void setName(String string2) {
        this.name = string2;
    }
}

