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

public class AddProductData {
    @SerializedName(value="base_cost")
    private double base_cost;
    @SerializedName(value="base_qty")
    private String base_qty;
    @SerializedName(value="category")
    private String category;
    @SerializedName(value="category_name")
    private String category_name;
    @SerializedName(value="created_at")
    private String created_at;
    @SerializedName(value="description")
    private String description;
    @SerializedName(value="image")
    private String image;
    @SerializedName(value="is_hidden")
    private boolean is_hidden;
    @SerializedName(value="modified_at")
    private String modified_at;
    @SerializedName(value="name")
    private String name;
}

