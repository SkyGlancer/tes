/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.network.model;

import app.dukhaan.network.model.BaseCreateProduct;
import com.google.gson.annotations.SerializedName;

public class AddProductRequest
extends BaseCreateProduct {
    @SerializedName(value="base_cost")
    public double baseCost;
    @SerializedName(value="base_qty")
    public String baseQty;
    @SerializedName(value="business_id")
    public int businessId;
    @SerializedName(value="category")
    public int category;
    @SerializedName(value="description")
    public String description;
    @SerializedName(value="is_hidden")
    public boolean isHidden;
    public String name;
    @SerializedName(value="original_cost")
    public double originalCost;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AddProductRequest{name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", baseQty='");
        stringBuilder.append(this.baseQty);
        stringBuilder.append('\'');
        stringBuilder.append(", baseCost=");
        stringBuilder.append(this.baseCost);
        stringBuilder.append(", imageUrl='");
        stringBuilder.append(this.image);
        stringBuilder.append('\'');
        stringBuilder.append(", businessId=");
        stringBuilder.append(this.businessId);
        stringBuilder.append(", description='");
        stringBuilder.append(this.description);
        stringBuilder.append('\'');
        stringBuilder.append(", isHidden=");
        stringBuilder.append(this.isHidden);
        stringBuilder.append(", category=");
        stringBuilder.append(this.category);
        stringBuilder.append(", originalCost=");
        stringBuilder.append(this.originalCost);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

