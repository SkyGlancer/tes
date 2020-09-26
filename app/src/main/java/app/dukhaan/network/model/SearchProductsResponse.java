/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.data.model.Product
 *  app.dukhaan.network.model.Category
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.network.model;

import app.dukhaan.data.model.Product;
import app.dukhaan.network.model.Category;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SearchProductsResponse {
    @SerializedName(value="data")
    Data productData;
    @SerializedName(value="status")
    private String status;

    public Data getProductData() {
        return this.productData;
    }

    public String getStatus() {
        return this.status;
    }

    public void setProductData(Data data) {
        this.productData = data;
    }

    public void setStatus(String string2) {
        this.status = string2;
    }

    public class Data {
        @SerializedName(value="categories")
        public List<Category> categories;
        @SerializedName(value="products")
        public List<Product> products;

        public List<Category> getCategories() {
            return this.categories;
        }

        public List<Product> getProducts() {
            return this.products;
        }

        public void setCategories(List<Category> list) {
            this.categories = list;
        }

        public void setProducts(List<Product> list) {
            this.products = list;
        }
    }

}

