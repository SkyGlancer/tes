/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  com.google.gson.annotations.SerializedName
 *  io.realm.RealmList
 *  io.realm.RealmObject
 *  io.realm.annotations.PrimaryKey
 *  io.realm.app_dukhaan_network_model_OrderRealmProxyInterface
 *  io.realm.internal.RealmObjectProxy
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package app.dukhaan.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import app.dukhaan.data.model.Product;
import app.dukhaan.network.model.Order;
import com.google.gson.annotations.SerializedName;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.app_dukhaan_network_model_OrderRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Order
extends RealmObject
implements Parcelable,
app_dukhaan_network_model_OrderRealmProxyInterface {
    public static final Creator<Order> CREATOR = new Creator<Order>(){

        public Order createFromParcel(Parcel parcel) {
            return new Order(parcel);
        }

        public Order[] newArray(int n) {
            return new Order[n];
        }
    };
    public int business;
    @SerializedName(value="created_at")
    public String createdAt;
    @SerializedName(value="customer_address")
    public String customerAddress;
    @SerializedName(value="customer_city")
    public String customerCity;
    @SerializedName(value="customer_mobile")
    public String customerMobile;
    @SerializedName(value="customer_name")
    public String customerName;
    @SerializedName(value="customer_pin")
    public String customerPin;
    @SerializedName(value="delivery_cost")
    public float deliveryCost;
    @PrimaryKey
    public int id;
    @SerializedName(value="modified_at")
    public String modifiedAt;
    public int numberOfItems;
    @SerializedName(value="order_id")
    public String orderId;
    @SerializedName(value="products")
    public RealmList<Product> products;
    @SerializedName(value="order_status")
    public String status;
    public String thumbnail;
    @SerializedName(value="total_cost")
    public float totalCost;

    public Order() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy)this).realm$injectObjectContext();
        }
    }

    protected Order(Parcel parcel) {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy)this).realm$injectObjectContext();
        }
        this.realmSet$id(parcel.readInt());
        this.realmSet$orderId(parcel.readString());
        this.realmSet$business(parcel.readInt());
        this.realmSet$totalCost(parcel.readFloat());
        this.realmSet$deliveryCost(parcel.readFloat());
        this.realmSet$createdAt(parcel.readString());
        this.realmSet$modifiedAt(parcel.readString());
        this.realmSet$customerName(parcel.readString());
        this.realmSet$customerMobile(parcel.readString());
        this.realmSet$customerAddress(parcel.readString());
        this.realmSet$customerCity(parcel.readString());
        this.realmSet$customerPin(parcel.readString());
        this.realmSet$status(parcel.readString());
        this.realmSet$numberOfItems(parcel.readInt());
        this.realmSet$thumbnail(parcel.readString());
        this.realmSet$products(new RealmList());
        this.realmGet$products().addAll((Collection)parcel.createTypedArrayList(Product.CREATOR));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            Order order = (Order)((Object)object);
            if (order.realmGet$orderId() != null && order.realmGet$orderId().equals((Object)this.realmGet$orderId())) {
                return true;
            }
        }
        return false;
    }

    public float getGrandTotal() {
        return this.realmGet$totalCost();
    }

    public float getProductTotal() {
        Iterator iterator = this.realmGet$products().iterator();
        float f = 0.0f;
        while (iterator.hasNext()) {
            Product product = (Product)((Object)iterator.next());
            double d = f;
            double d2 = product.getBaseCost();
            double d3 = product.realmGet$orderedQty();
            Double.isNaN((double)d3);
            double d4 = d2 * d3;
            Double.isNaN((double)d);
            f = (float)(d + d4);
        }
        return f;
    }

    public String getThumbnail() {
        RealmList realmList = this.realmGet$products();
        String string = "https://dukaan-api.1kg.me/static/images/category-def.jpg";
        if (realmList != null) {
            if (this.realmGet$products().size() == 0) {
                return string;
            }
            for (Product product : this.realmGet$products()) {
                if (TextUtils.isEmpty((CharSequence)product.getImage())) continue;
                string = product.getImage();
                break;
            }
        }
        return string;
    }

    public int realmGet$business() {
        return this.business;
    }

    public String realmGet$createdAt() {
        return this.createdAt;
    }

    public String realmGet$customerAddress() {
        return this.customerAddress;
    }

    public String realmGet$customerCity() {
        return this.customerCity;
    }

    public String realmGet$customerMobile() {
        return this.customerMobile;
    }

    public String realmGet$customerName() {
        return this.customerName;
    }

    public String realmGet$customerPin() {
        return this.customerPin;
    }

    public float realmGet$deliveryCost() {
        return this.deliveryCost;
    }

    public int realmGet$id() {
        return this.id;
    }

    public String realmGet$modifiedAt() {
        return this.modifiedAt;
    }

    public int realmGet$numberOfItems() {
        return this.numberOfItems;
    }

    public String realmGet$orderId() {
        return this.orderId;
    }

    public RealmList realmGet$products() {
        return this.products;
    }

    public String realmGet$status() {
        return this.status;
    }

    public String realmGet$thumbnail() {
        return this.thumbnail;
    }

    public float realmGet$totalCost() {
        return this.totalCost;
    }

    public void realmSet$business(int n) {
        this.business = n;
    }

    public void realmSet$createdAt(String string) {
        this.createdAt = string;
    }

    public void realmSet$customerAddress(String string) {
        this.customerAddress = string;
    }

    public void realmSet$customerCity(String string) {
        this.customerCity = string;
    }

    public void realmSet$customerMobile(String string) {
        this.customerMobile = string;
    }

    public void realmSet$customerName(String string) {
        this.customerName = string;
    }

    public void realmSet$customerPin(String string) {
        this.customerPin = string;
    }

    public void realmSet$deliveryCost(float f) {
        this.deliveryCost = f;
    }

    public void realmSet$id(int n) {
        this.id = n;
    }

    public void realmSet$modifiedAt(String string) {
        this.modifiedAt = string;
    }

    public void realmSet$numberOfItems(int n) {
        this.numberOfItems = n;
    }

    public void realmSet$orderId(String string) {
        this.orderId = string;
    }

    public void realmSet$products(RealmList realmList) {
        this.products = realmList;
    }

    public void realmSet$status(String string) {
        this.status = string;
    }

    public void realmSet$thumbnail(String string) {
        this.thumbnail = string;
    }

    public void realmSet$totalCost(float f) {
        this.totalCost = f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order{id=");
        stringBuilder.append(this.realmGet$id());
        stringBuilder.append(", orderId='");
        stringBuilder.append(this.realmGet$orderId());
        stringBuilder.append('\'');
        stringBuilder.append(", business=");
        stringBuilder.append(this.realmGet$business());
        stringBuilder.append(", totalCost=");
        stringBuilder.append(this.realmGet$totalCost());
        stringBuilder.append(", deliveryCost=");
        stringBuilder.append(this.realmGet$deliveryCost());
        stringBuilder.append(", createdAt='");
        stringBuilder.append(this.realmGet$createdAt());
        stringBuilder.append('\'');
        stringBuilder.append(", modifiedAt='");
        stringBuilder.append(this.realmGet$modifiedAt());
        stringBuilder.append('\'');
        stringBuilder.append(", products='");
        stringBuilder.append((Object)this.realmGet$products());
        stringBuilder.append('\'');
        stringBuilder.append(", customerName='");
        stringBuilder.append(this.realmGet$customerName());
        stringBuilder.append('\'');
        stringBuilder.append(", customerMobile='");
        stringBuilder.append(this.realmGet$customerMobile());
        stringBuilder.append('\'');
        stringBuilder.append(", customerAddress='");
        stringBuilder.append(this.realmGet$customerAddress());
        stringBuilder.append('\'');
        stringBuilder.append(", customerCity='");
        stringBuilder.append(this.realmGet$customerCity());
        stringBuilder.append('\'');
        stringBuilder.append(", customerPin='");
        stringBuilder.append(this.realmGet$customerPin());
        stringBuilder.append('\'');
        stringBuilder.append(", status='");
        stringBuilder.append(this.realmGet$status());
        stringBuilder.append('\'');
        stringBuilder.append(", numberOfItems=");
        stringBuilder.append(this.realmGet$numberOfItems());
        stringBuilder.append(", thumbnail='");
        stringBuilder.append(this.realmGet$thumbnail());
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.realmGet$id());
        parcel.writeString(this.realmGet$orderId());
        parcel.writeInt(this.realmGet$business());
        parcel.writeFloat(this.realmGet$totalCost());
        parcel.writeFloat(this.realmGet$deliveryCost());
        parcel.writeString(this.realmGet$createdAt());
        parcel.writeString(this.realmGet$modifiedAt());
        parcel.writeString(this.realmGet$customerName());
        parcel.writeString(this.realmGet$customerMobile());
        parcel.writeString(this.realmGet$customerAddress());
        parcel.writeString(this.realmGet$customerCity());
        parcel.writeString(this.realmGet$customerPin());
        parcel.writeString(this.realmGet$status());
        parcel.writeInt(this.realmGet$numberOfItems());
        parcel.writeString(this.realmGet$thumbnail());
        parcel.writeTypedList((List)this.realmGet$products());
    }
}

