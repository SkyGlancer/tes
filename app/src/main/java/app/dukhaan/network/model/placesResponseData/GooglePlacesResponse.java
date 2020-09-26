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
 *  java.util.ArrayList
 *  java.util.List
 */
package app.dukhaan.network.model.placesResponseData;

import android.os.Parcel;
import android.os.Parcelable;
import app.dukhaan.network.model.placesResponseData.Prediction;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class GooglePlacesResponse
implements Parcelable {
    public static final Creator<GooglePlacesResponse> CREATOR = new Creator<GooglePlacesResponse>(){

        public GooglePlacesResponse createFromParcel(Parcel parcel) {
            return new GooglePlacesResponse(parcel);
        }

        public GooglePlacesResponse[] newArray(int n) {
            return new GooglePlacesResponse[n];
        }
    };
    @Expose
    @SerializedName(value="predictions")
    private List<Prediction> predictions;
    @Expose
    @SerializedName(value="status")
    private String status;

    public GooglePlacesResponse() {
        this.predictions = new ArrayList();
    }

    protected GooglePlacesResponse(Parcel parcel) {
        ArrayList arrayList;
        this.predictions = arrayList = new ArrayList();
        parcel.readList((List)arrayList, Prediction.class.getClassLoader());
        this.status = (String)parcel.readValue(String.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public List<Prediction> getPredictions() {
        return this.predictions;
    }

    public String getStatus() {
        return this.status;
    }

    public void setPredictions(List<Prediction> list) {
        this.predictions = list;
    }

    public void setStatus(String string2) {
        this.status = string2;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeList(this.predictions);
        parcel.writeValue((Object)this.status);
    }

}

