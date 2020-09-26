/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.network.model.Category
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.network.model;

import app.dukhaan.network.model.Category;
import com.google.gson.annotations.SerializedName;

public class CreateCategoryResonse {
    @SerializedName(value="data")
    private Category category;
    private String detail;
    private String status;
    private int status_code;

    public Category getCategory() {
        return this.category;
    }

    public String getDetail() {
        return this.detail;
    }

    public String getStatus() {
        return this.status;
    }

    public int getStatus_code() {
        return this.status_code;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDetail(String string2) {
        this.detail = string2;
    }

    public void setStatus(String string2) {
        this.status = string2;
    }

    public void setStatus_code(int n) {
        this.status_code = n;
    }
}

