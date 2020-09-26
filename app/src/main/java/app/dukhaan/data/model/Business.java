/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  io.realm.RealmObject
 *  io.realm.annotations.PrimaryKey
 *  io.realm.app_dukhaan_data_model_BusinessRealmProxyInterface
 *  io.realm.internal.RealmObjectProxy
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.data.model;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.app_dukhaan_data_model_BusinessRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;

public class Business
extends RealmObject
implements app_dukhaan_data_model_BusinessRealmProxyInterface {
    @SerializedName(value="account")
    public int accountId;
    public String address;
    public String country;
    @SerializedName(value="created_at")
    public String createdAt;
    @SerializedName(value="delivery_cost")
    public double deliveryCost;
    @SerializedName(value="delivery_cost_limit")
    public double deliveryCostLimit;
    @PrimaryKey
    public int id;
    @SerializedName(value="whatsapp_chat_support")
    public boolean isWhatsAppChatEnabled;
    public double latitude;
    public String link;
    public double longitude;
    public String mobile;
    public String name;
    @SerializedName(value="product_views")
    public int productViews;
    @SerializedName(value="referred_by")
    public String referredBy;
    @SerializedName(value="store_views")
    public int storeViews;
    @SerializedName(value="image")
    public String thumbnail;
    @SerializedName(value="total_orders")
    public int totalOrders;
    @SerializedName(value="total_revenue")
    public double totalRevenue;

    public Business() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy)this).realm$injectObjectContext();
        }
        this.realmSet$isWhatsAppChatEnabled(true);
    }

    public int realmGet$accountId() {
        return this.accountId;
    }

    public String realmGet$address() {
        return this.address;
    }

    public String realmGet$country() {
        return this.country;
    }

    public String realmGet$createdAt() {
        return this.createdAt;
    }

    public double realmGet$deliveryCost() {
        return this.deliveryCost;
    }

    public double realmGet$deliveryCostLimit() {
        return this.deliveryCostLimit;
    }

    public int realmGet$id() {
        return this.id;
    }

    public boolean realmGet$isWhatsAppChatEnabled() {
        return this.isWhatsAppChatEnabled;
    }

    public double realmGet$latitude() {
        return this.latitude;
    }

    public String realmGet$link() {
        return this.link;
    }

    public double realmGet$longitude() {
        return this.longitude;
    }

    public String realmGet$mobile() {
        return this.mobile;
    }

    public String realmGet$name() {
        return this.name;
    }

    public int realmGet$productViews() {
        return this.productViews;
    }

    public String realmGet$referredBy() {
        return this.referredBy;
    }

    public int realmGet$storeViews() {
        return this.storeViews;
    }

    public String realmGet$thumbnail() {
        return this.thumbnail;
    }

    public int realmGet$totalOrders() {
        return this.totalOrders;
    }

    public double realmGet$totalRevenue() {
        return this.totalRevenue;
    }

    public void realmSet$accountId(int n) {
        this.accountId = n;
    }

    public void realmSet$address(String string) {
        this.address = string;
    }

    public void realmSet$country(String string) {
        this.country = string;
    }

    public void realmSet$createdAt(String string) {
        this.createdAt = string;
    }

    public void realmSet$deliveryCost(double d) {
        this.deliveryCost = d;
    }

    public void realmSet$deliveryCostLimit(double d) {
        this.deliveryCostLimit = d;
    }

    public void realmSet$id(int n) {
        this.id = n;
    }

    public void realmSet$isWhatsAppChatEnabled(boolean bl) {
        this.isWhatsAppChatEnabled = bl;
    }

    public void realmSet$latitude(double d) {
        this.latitude = d;
    }

    public void realmSet$link(String string) {
        this.link = string;
    }

    public void realmSet$longitude(double d) {
        this.longitude = d;
    }

    public void realmSet$mobile(String string) {
        this.mobile = string;
    }

    public void realmSet$name(String string) {
        this.name = string;
    }

    public void realmSet$productViews(int n) {
        this.productViews = n;
    }

    public void realmSet$referredBy(String string) {
        this.referredBy = string;
    }

    public void realmSet$storeViews(int n) {
        this.storeViews = n;
    }

    public void realmSet$thumbnail(String string) {
        this.thumbnail = string;
    }

    public void realmSet$totalOrders(int n) {
        this.totalOrders = n;
    }

    public void realmSet$totalRevenue(double d) {
        this.totalRevenue = d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Business{id=");
        stringBuilder.append(this.realmGet$id());
        stringBuilder.append(", link='");
        stringBuilder.append(this.realmGet$link());
        stringBuilder.append('\'');
        stringBuilder.append(", createdAt='");
        stringBuilder.append(this.realmGet$createdAt());
        stringBuilder.append('\'');
        stringBuilder.append(", name='");
        stringBuilder.append(this.realmGet$name());
        stringBuilder.append('\'');
        stringBuilder.append(", country='");
        stringBuilder.append(this.realmGet$country());
        stringBuilder.append('\'');
        stringBuilder.append(", address='");
        stringBuilder.append(this.realmGet$address());
        stringBuilder.append('\'');
        stringBuilder.append(", thumbnail='");
        stringBuilder.append(this.realmGet$thumbnail());
        stringBuilder.append('\'');
        stringBuilder.append(", accountId=");
        stringBuilder.append(this.realmGet$accountId());
        stringBuilder.append(", storeViews=");
        stringBuilder.append(this.realmGet$storeViews());
        stringBuilder.append(", productViews=");
        stringBuilder.append(this.realmGet$productViews());
        stringBuilder.append(", totalOrders=");
        stringBuilder.append(this.realmGet$totalOrders());
        stringBuilder.append(", totalRevenue=");
        stringBuilder.append(this.realmGet$totalRevenue());
        stringBuilder.append(", deliveryCost=");
        stringBuilder.append(this.realmGet$deliveryCost());
        stringBuilder.append(", deliveryCostLimit=");
        stringBuilder.append(this.realmGet$deliveryCostLimit());
        stringBuilder.append(", mobile='");
        stringBuilder.append(this.realmGet$mobile());
        stringBuilder.append('\'');
        stringBuilder.append(", latitude=");
        stringBuilder.append(this.realmGet$latitude());
        stringBuilder.append(", longitude=");
        stringBuilder.append(this.realmGet$longitude());
        stringBuilder.append(", referredBy=");
        stringBuilder.append(this.realmGet$referredBy());
        stringBuilder.append(", isWhatsAppChatEnabled=");
        stringBuilder.append(this.realmGet$isWhatsAppChatEnabled());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

