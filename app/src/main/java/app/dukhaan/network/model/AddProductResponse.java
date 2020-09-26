/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.network.model;

import app.dukhaan.network.model.AddProductData;
import com.google.gson.annotations.SerializedName;

public class AddProductResponse {
    @SerializedName(value="data")
    private AddProductData data;
    @SerializedName(value="status")
    private String status;

    public AddProductData getData() {
        return this.data;
    }

    public String getStatus() {
        return this.status;
    }

    public void setData(AddProductData addProductData) {
        this.data = addProductData;
    }

    public void setStatus(String string2) {
        this.status = string2;
    }
}

