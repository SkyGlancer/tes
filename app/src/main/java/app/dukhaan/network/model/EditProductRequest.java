/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Double
 *  java.lang.String
 */
package app.dukhaan.network.model;

import app.dukhaan.network.model.BaseCreateProduct;
import com.google.gson.annotations.SerializedName;

public class EditProductRequest
extends BaseCreateProduct {
    @SerializedName(value="base_cost")
    public double baseCost;
    @SerializedName(value="base_qty")
    public String baseQty;
    @SerializedName(value="category")
    public int category;
    @SerializedName(value="description")
    public String description;
    @SerializedName(value="is_hidden")
    public boolean isHidden;
    public String name;
    @SerializedName(value="original_cost")
    public double originalCost;

    public Double getBaseCost() {
        return this.baseCost;
    }

    public String getBaseQty() {
        return this.baseQty;
    }

    public int getCategory() {
        return this.category;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }

    public boolean isHidden() {
        return this.isHidden;
    }

    public void setBaseCost(double d) {
        this.baseCost = d;
    }

    public void setBaseCost(Double d) {
        this.baseCost = d;
    }

    public void setBaseQty(String string2) {
        this.baseQty = string2;
    }

    public void setCategory(int n) {
        this.category = n;
    }

    public void setDescription(String string2) {
        this.description = string2;
    }

    public void setHidden(boolean bl) {
        this.isHidden = bl;
    }

    public void setImage(String string2) {
        this.image = string2;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setOriginalCost(Double d) {
        this.originalCost = d;
    }
}

