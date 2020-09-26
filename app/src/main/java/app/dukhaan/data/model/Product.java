/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.gson.annotations.SerializedName
 *  io.realm.RealmList
 *  io.realm.RealmObject
 *  io.realm.app_dukhaan_data_model_ProductRealmProxyInterface
 *  io.realm.internal.RealmObjectProxy
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package app.dukhaan.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import app.dukhaan.data.model.Product;
import com.google.gson.annotations.SerializedName;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.app_dukhaan_data_model_ProductRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Product
extends RealmObject
implements Parcelable,
app_dukhaan_data_model_ProductRealmProxyInterface {
    public static final Creator<Product> CREATOR = new Creator<Product>(){

        public Product createFromParcel(Parcel parcel) {
            return new Product(parcel);
        }

        public Product[] newArray(int n) {
            return new Product[n];
        }
    };
    @SerializedName(value="base_cost")
    private Double baseCost;
    @SerializedName(value="base_qty")
    private String baseQty;
    @SerializedName(value="category")
    private int categoryId;
    @SerializedName(value="category_name")
    private String categoryName;
    @SerializedName(value="created_at")
    private String createdAt;
    @SerializedName(value="description")
    private String description;
    private int id;
    @SerializedName(value="image")
    private String image;
    @SerializedName(value="is_hidden")
    private boolean isHidden;
    @SerializedName(value="modified_at")
    private String modifiedAt;
    @SerializedName(value="name")
    private String name;
    private String orderId;
    @SerializedName(value="ordered_qty")
    public int orderedQty;
    @SerializedName(value="original_cost")
    public Double originalCost;
    public RealmList<String> variants;

    public Product() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy)this).realm$injectObjectContext();
        }
    }

    protected Product(Parcel parcel) {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy)this).realm$injectObjectContext();
        }
        this.realmSet$id(parcel.readInt());
        this.realmSet$categoryName(parcel.readString());
        this.realmSet$createdAt(parcel.readString());
        this.realmSet$modifiedAt(parcel.readString());
        this.realmSet$name(parcel.readString());
        this.realmSet$image(parcel.readString());
        this.realmSet$baseQty(parcel.readString());
        if (parcel.readByte() == 0) {
            this.realmSet$baseCost(null);
        } else {
            this.realmSet$baseCost(parcel.readDouble());
        }
        this.realmSet$description(parcel.readString());
        boolean bl = parcel.readByte() != 0;
        this.realmSet$isHidden(bl);
        this.realmSet$categoryId(parcel.readInt());
        this.realmSet$orderId(parcel.readString());
        this.realmSet$orderedQty(parcel.readInt());
        if (parcel.readByte() == 0) {
            this.realmSet$originalCost(null);
        } else {
            this.realmSet$originalCost(parcel.readDouble());
        }
        this.realmSet$variants(new RealmList());
        this.realmGet$variants().addAll((Collection)parcel.createStringArrayList());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return ((Product)((Object)object)).realmGet$id() == this.realmGet$id();
    }

    public Double getBaseCost() {
        return this.realmGet$baseCost();
    }

    public String getBaseQty() {
        return this.realmGet$baseQty();
    }

    public int getCategoryId() {
        return this.realmGet$categoryId();
    }

    public String getCategoryName() {
        return this.realmGet$categoryName();
    }

    public String getCreatedAt() {
        return this.realmGet$createdAt();
    }

    public String getDescription() {
        return this.realmGet$description();
    }

    public int getId() {
        return this.realmGet$id();
    }

    public String getImage() {
        return this.realmGet$image();
    }

    public String getModifiedAt() {
        return this.realmGet$modifiedAt();
    }

    public String getName() {
        return this.realmGet$name();
    }

    public String getOrderId() {
        return this.realmGet$orderId();
    }

    public Double getOriginalCost() {
        return this.realmGet$originalCost();
    }

    public boolean isHidden() {
        return this.realmGet$isHidden();
    }

    public Double realmGet$baseCost() {
        return this.baseCost;
    }

    public String realmGet$baseQty() {
        return this.baseQty;
    }

    public int realmGet$categoryId() {
        return this.categoryId;
    }

    public String realmGet$categoryName() {
        return this.categoryName;
    }

    public String realmGet$createdAt() {
        return this.createdAt;
    }

    public String realmGet$description() {
        return this.description;
    }

    public int realmGet$id() {
        return this.id;
    }

    public String realmGet$image() {
        return this.image;
    }

    public boolean realmGet$isHidden() {
        return this.isHidden;
    }

    public String realmGet$modifiedAt() {
        return this.modifiedAt;
    }

    public String realmGet$name() {
        return this.name;
    }

    public String realmGet$orderId() {
        return this.orderId;
    }

    public int realmGet$orderedQty() {
        return this.orderedQty;
    }

    public Double realmGet$originalCost() {
        return this.originalCost;
    }

    public RealmList realmGet$variants() {
        return this.variants;
    }

    public void realmSet$baseCost(Double d) {
        this.baseCost = d;
    }

    public void realmSet$baseQty(String string) {
        this.baseQty = string;
    }

    public void realmSet$categoryId(int n) {
        this.categoryId = n;
    }

    public void realmSet$categoryName(String string) {
        this.categoryName = string;
    }

    public void realmSet$createdAt(String string) {
        this.createdAt = string;
    }

    public void realmSet$description(String string) {
        this.description = string;
    }

    public void realmSet$id(int n) {
        this.id = n;
    }

    public void realmSet$image(String string) {
        this.image = string;
    }

    public void realmSet$isHidden(boolean bl) {
        this.isHidden = bl;
    }

    public void realmSet$modifiedAt(String string) {
        this.modifiedAt = string;
    }

    public void realmSet$name(String string) {
        this.name = string;
    }

    public void realmSet$orderId(String string) {
        this.orderId = string;
    }

    public void realmSet$orderedQty(int n) {
        this.orderedQty = n;
    }

    public void realmSet$originalCost(Double d) {
        this.originalCost = d;
    }

    public void realmSet$variants(RealmList realmList) {
        this.variants = realmList;
    }

    public void setBaseCost(Double d) {
        this.realmSet$baseCost(d);
    }

    public void setBaseQty(String string) {
        this.realmSet$baseQty(string);
    }

    public void setCategoryId(int n) {
        this.realmSet$categoryId(n);
    }

    public void setCategoryName(String string) {
        this.realmSet$categoryName(string);
    }

    public void setCreatedAt(String string) {
        this.realmSet$createdAt(string);
    }

    public void setDescription(String string) {
        this.realmSet$description(string);
    }

    public void setHidden(boolean bl) {
        this.realmSet$isHidden(bl);
    }

    public void setId(int n) {
        this.realmSet$id(n);
    }

    public void setImage(String string) {
        this.realmSet$image(string);
    }

    public void setModifiedAt(String string) {
        this.realmSet$modifiedAt(string);
    }

    public void setName(String string) {
        this.realmSet$name(string);
    }

    public void setOrderId(String string) {
        this.realmSet$orderId(string);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Product{id=");
        stringBuilder.append(this.realmGet$id());
        stringBuilder.append(", categoryName='");
        stringBuilder.append(this.realmGet$categoryName());
        stringBuilder.append('\'');
        stringBuilder.append(", createdAt=");
        stringBuilder.append(this.realmGet$createdAt());
        stringBuilder.append(", modifiedAt='");
        stringBuilder.append(this.realmGet$modifiedAt());
        stringBuilder.append('\'');
        stringBuilder.append(", name='");
        stringBuilder.append(this.realmGet$name());
        stringBuilder.append('\'');
        stringBuilder.append(", image='");
        stringBuilder.append(this.realmGet$image());
        stringBuilder.append('\'');
        stringBuilder.append(", baseQty='");
        stringBuilder.append(this.realmGet$baseQty());
        stringBuilder.append('\'');
        stringBuilder.append(", baseCost='");
        stringBuilder.append((Object)this.realmGet$baseCost());
        stringBuilder.append('\'');
        stringBuilder.append(", description='");
        stringBuilder.append(this.realmGet$description());
        stringBuilder.append('\'');
        stringBuilder.append(", isHidden='");
        stringBuilder.append(this.realmGet$isHidden());
        stringBuilder.append('\'');
        stringBuilder.append(", category=");
        stringBuilder.append(this.realmGet$categoryId());
        stringBuilder.append(", orderId=");
        stringBuilder.append(this.realmGet$orderId());
        stringBuilder.append(", originalCost=");
        stringBuilder.append((Object)this.realmGet$originalCost());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.realmGet$id());
        parcel.writeString(this.realmGet$categoryName());
        parcel.writeString(this.realmGet$createdAt());
        parcel.writeString(this.realmGet$modifiedAt());
        parcel.writeString(this.realmGet$name());
        parcel.writeString(this.realmGet$image());
        parcel.writeString(this.realmGet$baseQty());
        if (this.realmGet$baseCost() == null) {
            parcel.writeByte((byte)0);
        } else {
            parcel.writeByte((byte)1);
            parcel.writeDouble(this.realmGet$baseCost().doubleValue());
        }
        parcel.writeString(this.realmGet$description());
        parcel.writeByte((byte)(this.realmGet$isHidden() ? 1 : 0));
        parcel.writeInt(this.realmGet$categoryId());
        parcel.writeString(this.realmGet$orderId());
        parcel.writeInt(this.realmGet$orderedQty());
        if (this.realmGet$originalCost() == null) {
            parcel.writeByte((byte)0);
        } else {
            parcel.writeByte((byte)1);
            parcel.writeDouble(this.realmGet$originalCost().doubleValue());
        }
        parcel.writeStringList((List)this.realmGet$variants());
    }
}

