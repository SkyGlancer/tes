/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.gson.annotations.SerializedName
 *  io.realm.RealmObject
 *  io.realm.annotations.PrimaryKey
 *  io.realm.app_dukhaan_network_model_CategoryRealmProxyInterface
 *  io.realm.internal.RealmObjectProxy
 *  java.lang.String
 */
package app.dukhaan.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import app.dukhaan.network.model.Category;
import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.app_dukhaan_network_model_CategoryRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;

public class Category
extends RealmObject
implements Parcelable,
app_dukhaan_network_model_CategoryRealmProxyInterface {
    public static final Creator<Category> CREATOR = new Creator<Category>(){

        public Category createFromParcel(Parcel parcel) {
            return new Category(parcel);
        }

        public Category[] newArray(int n) {
            return new Category[n];
        }
    };
    public int business;
    @SerializedName(value="created_at")
    public String createdAt;
    @PrimaryKey
    public int id;
    public String image;
    @SerializedName(value="modified_at")
    public String modifiedAt;
    public String name;
    @SerializedName(value="product_count")
    public int productCount;

    public Category() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy)this).realm$injectObjectContext();
        }
    }

    protected Category(Parcel parcel) {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy)this).realm$injectObjectContext();
        }
        this.realmSet$id(parcel.readInt());
        this.realmSet$createdAt(parcel.readString());
        this.realmSet$modifiedAt(parcel.readString());
        this.realmSet$name(parcel.readString());
        this.realmSet$image(parcel.readString());
        this.realmSet$productCount(parcel.readInt());
        this.realmSet$business(parcel.readInt());
    }

    public int describeContents() {
        return 0;
    }

    public int realmGet$business() {
        return this.business;
    }

    public String realmGet$createdAt() {
        return this.createdAt;
    }

    public int realmGet$id() {
        return this.id;
    }

    public String realmGet$image() {
        return this.image;
    }

    public String realmGet$modifiedAt() {
        return this.modifiedAt;
    }

    public String realmGet$name() {
        return this.name;
    }

    public int realmGet$productCount() {
        return this.productCount;
    }

    public void realmSet$business(int n) {
        this.business = n;
    }

    public void realmSet$createdAt(String string) {
        this.createdAt = string;
    }

    public void realmSet$id(int n) {
        this.id = n;
    }

    public void realmSet$image(String string) {
        this.image = string;
    }

    public void realmSet$modifiedAt(String string) {
        this.modifiedAt = string;
    }

    public void realmSet$name(String string) {
        this.name = string;
    }

    public void realmSet$productCount(int n) {
        this.productCount = n;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.realmGet$id());
        parcel.writeString(this.realmGet$createdAt());
        parcel.writeString(this.realmGet$modifiedAt());
        parcel.writeString(this.realmGet$name());
        parcel.writeString(this.realmGet$image());
        parcel.writeInt(this.realmGet$productCount());
        parcel.writeInt(this.realmGet$business());
    }
}

