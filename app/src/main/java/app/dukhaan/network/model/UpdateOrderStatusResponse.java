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

public class UpdateOrderStatusResponse {
    public Data data;
    @SerializedName(value="status_code")
    public int statusCode;

    public class Data {
        @SerializedName(value="data")
        public OrderStatus orderStatus;
    }

    public class OrderStatus {
        @SerializedName(value="order_status")
        public String status;
    }

}

