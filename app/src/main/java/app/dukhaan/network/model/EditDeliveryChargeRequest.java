/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 */
package app.dukhaan.network.model;

import com.google.gson.annotations.SerializedName;

public class EditDeliveryChargeRequest {
    @SerializedName(value="delivery_cost")
    public double deliveryCost;
    @SerializedName(value="delivery_cost_limit")
    public double deliveryCostLimit;

    public double getDeliveryCost() {
        return this.deliveryCost;
    }

    public double getDeliveryCostLimit() {
        return this.deliveryCostLimit;
    }

    public void setDeliveryCost(double d) {
        this.deliveryCost = d;
    }

    public void setDeliveryCostLimit(double d) {
        this.deliveryCostLimit = d;
    }
}

