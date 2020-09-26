/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.gson.annotations.Expose
 *  com.google.gson.annotations.SerializedName
 *  java.lang.ClassLoader
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.network.model.placesResponseData;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Term
implements Parcelable {
    public static final Creator<Term> CREATOR = new Creator<Term>(){

        public Term createFromParcel(Parcel parcel) {
            return new Term(parcel);
        }

        public Term[] newArray(int n) {
            return new Term[n];
        }
    };
    @Expose
    @SerializedName(value="offset")
    private Integer offset;
    @Expose
    @SerializedName(value="value")
    private String value;

    public Term() {
    }

    protected Term(Parcel parcel) {
        this.offset = (Integer)parcel.readValue(Integer.class.getClassLoader());
        this.value = (String)parcel.readValue(String.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public String getValue() {
        return this.value;
    }

    public void setOffset(Integer n) {
        this.offset = n;
    }

    public void setValue(String string2) {
        this.value = string2;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeValue((Object)this.offset);
        parcel.writeValue((Object)this.value);
    }

}

