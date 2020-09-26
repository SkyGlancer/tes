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
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.network.model.placesResponseData;

import android.os.Parcel;
import android.os.Parcelable;
import app.dukhaan.network.model.placesResponseData.MainTextMatchedSubstring;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class StructuredFormatting
implements Parcelable {
    public static final Creator<StructuredFormatting> CREATOR = new Creator<StructuredFormatting>(){

        public StructuredFormatting createFromParcel(Parcel parcel) {
            return new StructuredFormatting(parcel);
        }

        public StructuredFormatting[] newArray(int n) {
            return new StructuredFormatting[n];
        }
    };
    @Expose
    @SerializedName(value="main_text")
    private String mainText;
    @Expose
    @SerializedName(value="main_text_matched_substrings")
    private List<MainTextMatchedSubstring> mainTextMatchedSubstrings = null;
    @Expose
    @SerializedName(value="secondary_text")
    private String secondaryText;

    public StructuredFormatting() {
    }

    protected StructuredFormatting(Parcel parcel) {
        this.mainText = (String)parcel.readValue(String.class.getClassLoader());
        parcel.readList(this.mainTextMatchedSubstrings, MainTextMatchedSubstring.class.getClassLoader());
        this.secondaryText = (String)parcel.readValue(String.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public String getMainText() {
        return this.mainText;
    }

    public List<MainTextMatchedSubstring> getMainTextMatchedSubstrings() {
        return this.mainTextMatchedSubstrings;
    }

    public String getSecondaryText() {
        return this.secondaryText;
    }

    public void setMainText(String string2) {
        this.mainText = string2;
    }

    public void setMainTextMatchedSubstrings(List<MainTextMatchedSubstring> list) {
        this.mainTextMatchedSubstrings = list;
    }

    public void setSecondaryText(String string2) {
        this.secondaryText = string2;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeValue((Object)this.mainText);
        parcel.writeList(this.mainTextMatchedSubstrings);
        parcel.writeValue((Object)this.secondaryText);
    }

}

