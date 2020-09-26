/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral.util;

import io.branch.referral.util.ProductCategory;
import org.json.JSONException;
import org.json.JSONObject;

public class Product {
    private String brand;
    private ProductCategory category;
    private String name;
    private Double price;
    private Integer quantity;
    private String sku;
    private String variant;

    public Product() {
    }

    public Product(String string2, String string3, Double d, Integer n, String string4, String string5, ProductCategory productCategory) {
        this.sku = string2;
        this.name = string3;
        this.price = d;
        this.quantity = n;
        this.brand = string4;
        this.variant = string5;
        this.category = productCategory;
    }

    public String getBrand() {
        return this.brand;
    }

    public ProductCategory getCategory() {
        return this.category;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public JSONObject getProductJSONObject() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("sku", (Object)this.sku);
            jSONObject.put("name", (Object)this.name);
            jSONObject.put("price", (Object)this.price);
            jSONObject.put("quantity", (Object)this.quantity);
            jSONObject.put("brand", (Object)this.brand);
            jSONObject.put("variant", (Object)this.variant);
            jSONObject.put("category", (Object)this.category);
        }
        catch (JSONException jSONException) {}
        return jSONObject;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public String getSku() {
        return this.sku;
    }

    public String getVariant() {
        return this.variant;
    }

    public void setBrand(String string2) {
        this.brand = string2;
    }

    public void setCategory(ProductCategory productCategory) {
        this.category = productCategory;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setPrice(Double d) {
        this.price = d;
    }

    public void setQuantity(Integer n) {
        this.quantity = n;
    }

    public void setSku(String string2) {
        this.sku = string2;
    }

    public void setVariant(String string2) {
        this.variant = string2;
    }
}

