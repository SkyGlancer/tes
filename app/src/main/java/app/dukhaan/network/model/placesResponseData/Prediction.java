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
import app.dukhaan.network.model.placesResponseData.MatchedSubstring;
import app.dukhaan.network.model.placesResponseData.StructuredFormatting;
import app.dukhaan.network.model.placesResponseData.Term;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Prediction
implements Parcelable {
    public static final Creator<Prediction> CREATOR = new Creator<Prediction>(){

        public Prediction createFromParcel(Parcel parcel) {
            return new Prediction(parcel);
        }

        public Prediction[] newArray(int n) {
            return new Prediction[n];
        }
    };
    @Expose
    @SerializedName(value="description")
    private String description;
    @Expose
    @SerializedName(value="id")
    private String id;
    @Expose
    @SerializedName(value="matched_substrings")
    private List<MatchedSubstring> matchedSubstrings = new ArrayList();
    @Expose
    @SerializedName(value="place_id")
    private String placeId;
    @Expose
    @SerializedName(value="reference")
    private String reference;
    private String searchKey;
    @Expose
    @SerializedName(value="structured_formatting")
    private StructuredFormatting structuredFormatting;
    @Expose
    @SerializedName(value="terms")
    private List<Term> terms = new ArrayList();
    @Expose
    @SerializedName(value="types")
    private List<String> types = new ArrayList();

    public Prediction() {
    }

    protected Prediction(Parcel parcel) {
        this.description = (String)parcel.readValue(String.class.getClassLoader());
        this.id = (String)parcel.readValue(String.class.getClassLoader());
        parcel.readList(this.matchedSubstrings, MatchedSubstring.class.getClassLoader());
        this.placeId = (String)parcel.readValue(String.class.getClassLoader());
        this.reference = (String)parcel.readValue(String.class.getClassLoader());
        this.structuredFormatting = (StructuredFormatting)parcel.readValue(StructuredFormatting.class.getClassLoader());
        parcel.readList(this.terms, Term.class.getClassLoader());
        parcel.readList(this.types, String.class.getClassLoader());
        this.searchKey = (String)parcel.readValue(String.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getId() {
        return this.id;
    }

    public List<MatchedSubstring> getMatchedSubstrings() {
        return this.matchedSubstrings;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    public String getReference() {
        return this.reference;
    }

    public String getSearchKey() {
        return this.searchKey;
    }

    public StructuredFormatting getStructuredFormatting() {
        return this.structuredFormatting;
    }

    public List<Term> getTerms() {
        return this.terms;
    }

    public List<String> getTypes() {
        return this.types;
    }

    public void setDescription(String string2) {
        this.description = string2;
    }

    public void setId(String string2) {
        this.id = string2;
    }

    public void setMatchedSubstrings(List<MatchedSubstring> list) {
        this.matchedSubstrings = list;
    }

    public void setPlaceId(String string2) {
        this.placeId = string2;
    }

    public void setReference(String string2) {
        this.reference = string2;
    }

    public void setSearchKey(String string2) {
        this.searchKey = string2;
    }

    public void setStructuredFormatting(StructuredFormatting structuredFormatting) {
        this.structuredFormatting = structuredFormatting;
    }

    public void setTerms(List<Term> list) {
        this.terms = list;
    }

    public void setTypes(List<String> list) {
        this.types = list;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeValue((Object)this.description);
        parcel.writeValue((Object)this.id);
        parcel.writeList(this.matchedSubstrings);
        parcel.writeValue((Object)this.placeId);
        parcel.writeValue((Object)this.reference);
        parcel.writeValue((Object)this.structuredFormatting);
        parcel.writeList(this.terms);
        parcel.writeList(this.types);
        parcel.writeValue((Object)this.searchKey);
    }

}

