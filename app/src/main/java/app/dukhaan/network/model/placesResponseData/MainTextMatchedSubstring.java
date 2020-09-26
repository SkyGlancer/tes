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
 */
package app.dukhaan.network.model.placesResponseData;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainTextMatchedSubstring
implements Parcelable {
    public static final Creator<MainTextMatchedSubstring> CREATOR = new Creator<MainTextMatchedSubstring>(){

        public MainTextMatchedSubstring createFromParcel(Parcel parcel) {
            return new MainTextMatchedSubstring(parcel);
        }

        public MainTextMatchedSubstring[] newArray(int n) {
            return new MainTextMatchedSubstring[n];
        }
    };
    @Expose
    @SerializedName(value="length")
    private Integer length;
    @Expose
    @SerializedName(value="offset")
    private Integer offset;

    public MainTextMatchedSubstring() {
    }

    protected MainTextMatchedSubstring(Parcel parcel) {
        this.length = (Integer)parcel.readValue(Integer.class.getClassLoader());
        this.offset = (Integer)parcel.readValue(Integer.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public Integer getLength() {
        return this.length;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setLength(Integer n) {
        this.length = n;
    }

    public void setOffset(Integer n) {
        this.offset = n;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeValue((Object)this.length);
        parcel.writeValue((Object)this.offset);
    }

}

