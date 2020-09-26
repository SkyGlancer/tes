/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.branch.referral.BranchUtil;
import io.branch.referral.Defines;
import io.branch.referral.util.BranchContentSchema;
import io.branch.referral.util.CurrencyType;
import io.branch.referral.util.ProductCategory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ContentMetadata
implements Parcelable {
    public static final Creator CREATOR = new Creator(){

        public ContentMetadata createFromParcel(Parcel parcel) {
            return new ContentMetadata(parcel);
        }

        public ContentMetadata[] newArray(int n) {
            return new ContentMetadata[n];
        }
    };
    public String addressCity;
    public String addressCountry;
    public String addressPostalCode;
    public String addressRegion;
    public String addressStreet;
    public CONDITION condition;
    BranchContentSchema contentSchema;
    public CurrencyType currencyType;
    private final HashMap<String, String> customMetadata = new HashMap();
    private final ArrayList<String> imageCaptions = new ArrayList();
    public Double latitude;
    public Double longitude;
    public Double price;
    public String productBrand;
    public ProductCategory productCategory;
    public String productName;
    public String productVariant;
    public Double quantity;
    public Double rating;
    public Double ratingAverage;
    public Integer ratingCount;
    public Double ratingMax;
    public String sku;

    public ContentMetadata() {
    }

    private ContentMetadata(Parcel parcel) {
        this();
        this.contentSchema = BranchContentSchema.getValue(parcel.readString());
        this.quantity = (Double)parcel.readSerializable();
        this.price = (Double)parcel.readSerializable();
        this.currencyType = CurrencyType.getValue(parcel.readString());
        this.sku = parcel.readString();
        this.productName = parcel.readString();
        this.productBrand = parcel.readString();
        this.productCategory = ProductCategory.getValue(parcel.readString());
        this.condition = CONDITION.getValue(parcel.readString());
        this.productVariant = parcel.readString();
        this.rating = (Double)parcel.readSerializable();
        this.ratingAverage = (Double)parcel.readSerializable();
        this.ratingCount = (Integer)parcel.readSerializable();
        this.ratingMax = (Double)parcel.readSerializable();
        this.addressStreet = parcel.readString();
        this.addressCity = parcel.readString();
        this.addressRegion = parcel.readString();
        this.addressCountry = parcel.readString();
        this.addressPostalCode = parcel.readString();
        this.latitude = (Double)parcel.readSerializable();
        this.longitude = (Double)parcel.readSerializable();
        ArrayList arrayList = (ArrayList)parcel.readSerializable();
        this.imageCaptions.addAll((Collection)arrayList);
        HashMap hashMap = (HashMap)parcel.readSerializable();
        this.customMetadata.putAll((Map)hashMap);
    }

    public static ContentMetadata createFromJson(BranchUtil.JsonReader jsonReader) {
        ContentMetadata contentMetadata = new ContentMetadata();
        contentMetadata.contentSchema = BranchContentSchema.getValue(jsonReader.readOutString(Defines.Jsonkey.ContentSchema.getKey()));
        contentMetadata.quantity = jsonReader.readOutDouble(Defines.Jsonkey.Quantity.getKey(), null);
        contentMetadata.price = jsonReader.readOutDouble(Defines.Jsonkey.Price.getKey(), null);
        contentMetadata.currencyType = CurrencyType.getValue(jsonReader.readOutString(Defines.Jsonkey.PriceCurrency.getKey()));
        contentMetadata.sku = jsonReader.readOutString(Defines.Jsonkey.SKU.getKey());
        contentMetadata.productName = jsonReader.readOutString(Defines.Jsonkey.ProductName.getKey());
        contentMetadata.productBrand = jsonReader.readOutString(Defines.Jsonkey.ProductBrand.getKey());
        contentMetadata.productCategory = ProductCategory.getValue(jsonReader.readOutString(Defines.Jsonkey.ProductCategory.getKey()));
        contentMetadata.condition = CONDITION.getValue(jsonReader.readOutString(Defines.Jsonkey.Condition.getKey()));
        contentMetadata.productVariant = jsonReader.readOutString(Defines.Jsonkey.ProductVariant.getKey());
        contentMetadata.rating = jsonReader.readOutDouble(Defines.Jsonkey.Rating.getKey(), null);
        contentMetadata.ratingAverage = jsonReader.readOutDouble(Defines.Jsonkey.RatingAverage.getKey(), null);
        contentMetadata.ratingCount = jsonReader.readOutInt(Defines.Jsonkey.RatingCount.getKey(), null);
        contentMetadata.ratingMax = jsonReader.readOutDouble(Defines.Jsonkey.RatingMax.getKey(), null);
        contentMetadata.addressStreet = jsonReader.readOutString(Defines.Jsonkey.AddressStreet.getKey());
        contentMetadata.addressCity = jsonReader.readOutString(Defines.Jsonkey.AddressCity.getKey());
        contentMetadata.addressRegion = jsonReader.readOutString(Defines.Jsonkey.AddressRegion.getKey());
        contentMetadata.addressCountry = jsonReader.readOutString(Defines.Jsonkey.AddressCountry.getKey());
        contentMetadata.addressPostalCode = jsonReader.readOutString(Defines.Jsonkey.AddressPostalCode.getKey());
        contentMetadata.latitude = jsonReader.readOutDouble(Defines.Jsonkey.Latitude.getKey(), null);
        contentMetadata.longitude = jsonReader.readOutDouble(Defines.Jsonkey.Longitude.getKey(), null);
        JSONArray jSONArray = jsonReader.readOutJsonArray(Defines.Jsonkey.ImageCaptions.getKey());
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); ++i) {
                contentMetadata.imageCaptions.add((Object)jSONArray.optString(i));
            }
        }
        try {
            JSONObject jSONObject = jsonReader.getJsonObject();
            Iterator iterator = jSONObject.keys();
            while (iterator.hasNext()) {
                String string2 = (String)iterator.next();
                contentMetadata.customMetadata.put((Object)string2, (Object)jSONObject.optString(string2));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return contentMetadata;
    }

    public ContentMetadata addCustomMetadata(String string2, String string3) {
        this.customMetadata.put((Object)string2, (Object)string3);
        return this;
    }

    public /* varargs */ ContentMetadata addImageCaptions(String ... arrstring) {
        Collections.addAll(this.imageCaptions, (Object[])arrstring);
        return this;
    }

    public JSONObject convertToJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.contentSchema != null) {
                jSONObject.put(Defines.Jsonkey.ContentSchema.getKey(), (Object)this.contentSchema.name());
            }
            if (this.quantity != null) {
                jSONObject.put(Defines.Jsonkey.Quantity.getKey(), (Object)this.quantity);
            }
            if (this.price != null) {
                jSONObject.put(Defines.Jsonkey.Price.getKey(), (Object)this.price);
            }
            if (this.currencyType != null) {
                jSONObject.put(Defines.Jsonkey.PriceCurrency.getKey(), (Object)this.currencyType.toString());
            }
            if (!TextUtils.isEmpty((CharSequence)this.sku)) {
                jSONObject.put(Defines.Jsonkey.SKU.getKey(), (Object)this.sku);
            }
            if (!TextUtils.isEmpty((CharSequence)this.productName)) {
                jSONObject.put(Defines.Jsonkey.ProductName.getKey(), (Object)this.productName);
            }
            if (!TextUtils.isEmpty((CharSequence)this.productBrand)) {
                jSONObject.put(Defines.Jsonkey.ProductBrand.getKey(), (Object)this.productBrand);
            }
            if (this.productCategory != null) {
                jSONObject.put(Defines.Jsonkey.ProductCategory.getKey(), (Object)this.productCategory.getName());
            }
            if (this.condition != null) {
                jSONObject.put(Defines.Jsonkey.Condition.getKey(), (Object)this.condition.name());
            }
            if (!TextUtils.isEmpty((CharSequence)this.productVariant)) {
                jSONObject.put(Defines.Jsonkey.ProductVariant.getKey(), (Object)this.productVariant);
            }
            if (this.rating != null) {
                jSONObject.put(Defines.Jsonkey.Rating.getKey(), (Object)this.rating);
            }
            if (this.ratingAverage != null) {
                jSONObject.put(Defines.Jsonkey.RatingAverage.getKey(), (Object)this.ratingAverage);
            }
            if (this.ratingCount != null) {
                jSONObject.put(Defines.Jsonkey.RatingCount.getKey(), (Object)this.ratingCount);
            }
            if (this.ratingMax != null) {
                jSONObject.put(Defines.Jsonkey.RatingMax.getKey(), (Object)this.ratingMax);
            }
            if (!TextUtils.isEmpty((CharSequence)this.addressStreet)) {
                jSONObject.put(Defines.Jsonkey.AddressStreet.getKey(), (Object)this.addressStreet);
            }
            if (!TextUtils.isEmpty((CharSequence)this.addressCity)) {
                jSONObject.put(Defines.Jsonkey.AddressCity.getKey(), (Object)this.addressCity);
            }
            if (!TextUtils.isEmpty((CharSequence)this.addressRegion)) {
                jSONObject.put(Defines.Jsonkey.AddressRegion.getKey(), (Object)this.addressRegion);
            }
            if (!TextUtils.isEmpty((CharSequence)this.addressCountry)) {
                jSONObject.put(Defines.Jsonkey.AddressCountry.getKey(), (Object)this.addressCountry);
            }
            if (!TextUtils.isEmpty((CharSequence)this.addressPostalCode)) {
                jSONObject.put(Defines.Jsonkey.AddressPostalCode.getKey(), (Object)this.addressPostalCode);
            }
            if (this.latitude != null) {
                jSONObject.put(Defines.Jsonkey.Latitude.getKey(), (Object)this.latitude);
            }
            if (this.longitude != null) {
                jSONObject.put(Defines.Jsonkey.Longitude.getKey(), (Object)this.longitude);
            }
            if (this.imageCaptions.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                jSONObject.put(Defines.Jsonkey.ImageCaptions.getKey(), (Object)jSONArray);
                Iterator iterator = this.imageCaptions.iterator();
                while (iterator.hasNext()) {
                    jSONArray.put((Object)((String)iterator.next()));
                }
            }
            if (this.customMetadata.size() > 0) {
                for (String string2 : this.customMetadata.keySet()) {
                    jSONObject.put(string2, this.customMetadata.get((Object)string2));
                }
            }
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public HashMap<String, String> getCustomMetadata() {
        return this.customMetadata;
    }

    public ArrayList<String> getImageCaptions() {
        return this.imageCaptions;
    }

    public ContentMetadata setAddress(String string2, String string3, String string4, String string5, String string6) {
        this.addressStreet = string2;
        this.addressCity = string3;
        this.addressRegion = string4;
        this.addressCountry = string5;
        this.addressPostalCode = string6;
        return this;
    }

    public ContentMetadata setContentSchema(BranchContentSchema branchContentSchema) {
        this.contentSchema = branchContentSchema;
        return this;
    }

    public ContentMetadata setLocation(Double d, Double d2) {
        this.latitude = d;
        this.longitude = d2;
        return this;
    }

    public ContentMetadata setPrice(Double d, CurrencyType currencyType) {
        this.price = d;
        this.currencyType = currencyType;
        return this;
    }

    public ContentMetadata setProductBrand(String string2) {
        this.productBrand = string2;
        return this;
    }

    public ContentMetadata setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    public ContentMetadata setProductCondition(CONDITION cONDITION) {
        this.condition = cONDITION;
        return this;
    }

    public ContentMetadata setProductName(String string2) {
        this.productName = string2;
        return this;
    }

    public ContentMetadata setProductVariant(String string2) {
        this.productVariant = string2;
        return this;
    }

    public ContentMetadata setQuantity(Double d) {
        this.quantity = d;
        return this;
    }

    public ContentMetadata setRating(Double d, Double d2, Double d3, Integer n) {
        this.rating = d;
        this.ratingAverage = d2;
        this.ratingMax = d3;
        this.ratingCount = n;
        return this;
    }

    public ContentMetadata setRating(Double d, Double d2, Integer n) {
        this.ratingAverage = d;
        this.ratingMax = d2;
        this.ratingCount = n;
        return this;
    }

    public ContentMetadata setSku(String string2) {
        this.sku = string2;
        return this;
    }

    public void writeToParcel(Parcel parcel, int n) {
        BranchContentSchema branchContentSchema = this.contentSchema;
        String string2 = "";
        String string3 = branchContentSchema != null ? branchContentSchema.name() : string2;
        parcel.writeString(string3);
        parcel.writeSerializable((Serializable)this.quantity);
        parcel.writeSerializable((Serializable)this.price);
        CurrencyType currencyType = this.currencyType;
        String string4 = currencyType != null ? currencyType.name() : string2;
        parcel.writeString(string4);
        parcel.writeString(this.sku);
        parcel.writeString(this.productName);
        parcel.writeString(this.productBrand);
        ProductCategory productCategory = this.productCategory;
        String string5 = productCategory != null ? productCategory.getName() : string2;
        parcel.writeString(string5);
        CONDITION cONDITION = this.condition;
        if (cONDITION != null) {
            string2 = cONDITION.name();
        }
        parcel.writeString(string2);
        parcel.writeString(this.productVariant);
        parcel.writeSerializable((Serializable)this.rating);
        parcel.writeSerializable((Serializable)this.ratingAverage);
        parcel.writeSerializable((Serializable)this.ratingCount);
        parcel.writeSerializable((Serializable)this.ratingMax);
        parcel.writeString(this.addressStreet);
        parcel.writeString(this.addressCity);
        parcel.writeString(this.addressRegion);
        parcel.writeString(this.addressCountry);
        parcel.writeString(this.addressPostalCode);
        parcel.writeSerializable((Serializable)this.latitude);
        parcel.writeSerializable((Serializable)this.longitude);
        parcel.writeSerializable(this.imageCaptions);
        parcel.writeSerializable(this.customMetadata);
    }

    public static final class CONDITION
    extends Enum<CONDITION> {
        private static final /* synthetic */ CONDITION[] $VALUES;
        public static final /* enum */ CONDITION EXCELLENT;
        public static final /* enum */ CONDITION FAIR;
        public static final /* enum */ CONDITION GOOD;
        public static final /* enum */ CONDITION NEW;
        public static final /* enum */ CONDITION OTHER;
        public static final /* enum */ CONDITION POOR;
        public static final /* enum */ CONDITION REFURBISHED;
        public static final /* enum */ CONDITION USED;

        static {
            CONDITION cONDITION;
            OTHER = new CONDITION();
            NEW = new CONDITION();
            GOOD = new CONDITION();
            FAIR = new CONDITION();
            POOR = new CONDITION();
            USED = new CONDITION();
            REFURBISHED = new CONDITION();
            EXCELLENT = cONDITION = new CONDITION();
            CONDITION[] arrcONDITION = new CONDITION[]{OTHER, NEW, GOOD, FAIR, POOR, USED, REFURBISHED, cONDITION};
            $VALUES = arrcONDITION;
        }

        public static CONDITION getValue(String string2) {
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                for (CONDITION cONDITION : CONDITION.values()) {
                    if (!cONDITION.name().equalsIgnoreCase(string2)) continue;
                    return cONDITION;
                }
            }
            return null;
        }

        public static CONDITION valueOf(String string2) {
            return (CONDITION)Enum.valueOf(CONDITION.class, (String)string2);
        }

        public static CONDITION[] values() {
            return (CONDITION[])$VALUES.clone();
        }
    }

}

