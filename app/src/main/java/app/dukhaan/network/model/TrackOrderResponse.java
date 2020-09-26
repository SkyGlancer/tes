/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.network.model.Order
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.network.model;

import app.dukhaan.network.model.Order;
import com.google.gson.annotations.SerializedName;

public class TrackOrderResponse {
    @SerializedName(value="data")
    private Data data;

    public Order getOrder() {
        Data data = this.data;
        if (data == null) {
            return null;
        }
        return data.order;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackOrderResponse{data=");
        stringBuilder.append((Object)this.data);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    class Data {
        @SerializedName(value="data")
        Order order;

        Data() {
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Data{order=");
            stringBuilder.append((Object)this.order);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

}

