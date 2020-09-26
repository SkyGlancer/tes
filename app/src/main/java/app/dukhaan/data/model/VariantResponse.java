/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.data.model.Variant
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.data.model;

import app.dukhaan.data.model.Variant;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class VariantResponse {
    @SerializedName(value="count")
    private int count;
    @SerializedName(value="next")
    private String next;
    @SerializedName(value="previous")
    private String previous;
    @SerializedName(value="results")
    private List<Variant> variants;

    public int getCount() {
        return this.count;
    }

    public String getNext() {
        return this.next;
    }

    public String getPrevious() {
        return this.previous;
    }

    public List<Variant> getVariants() {
        return this.variants;
    }

    public void setCount(int n) {
        this.count = n;
    }

    public void setNext(String string2) {
        this.next = string2;
    }

    public void setPrevious(String string2) {
        this.previous = string2;
    }

    public void setVariants(List<Variant> list) {
        this.variants = list;
    }
}

