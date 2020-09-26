/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 */
package app.dukhaan.data.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Locale;

public class Country
implements Parcelable {
    public static final Creator<Country> CREATOR = new Creator<Country>(){

        public Country createFromParcel(Parcel parcel) {
            return new Country(parcel);
        }

        public Country[] newArray(int n) {
            return new Country[n];
        }
    };
    private String code;
    private String currency;
    private String dialCode;
    private int flag;
    private String name;

    Country() {
    }

    protected Country(Parcel parcel) {
        this.code = parcel.readString();
        this.name = parcel.readString();
        this.dialCode = parcel.readString();
        this.flag = parcel.readInt();
        this.currency = parcel.readString();
    }

    public Country(String string2, String string3, String string4, int n, String string5) {
        this.code = string2;
        this.name = string3;
        this.dialCode = string4;
        this.flag = n;
        this.currency = string5;
    }

    public int describeContents() {
        return 0;
    }

    public String getCode() {
        return this.code;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDialCode() {
        return this.dialCode;
    }

    public int getFlag() {
        return this.flag;
    }

    public String getName() {
        return this.name;
    }

    public void loadFlagByCode(Context context) {
        if (this.flag != -1) {
            return;
        }
        try {
            Resources resources = context.getResources();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("flag_");
            stringBuilder.append(this.code.toLowerCase(Locale.ENGLISH));
            this.flag = resources.getIdentifier(stringBuilder.toString(), "drawable", context.getPackageName());
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            this.flag = -1;
            return;
        }
    }

    public void setCode(String string2) {
        this.code = string2;
        if (TextUtils.isEmpty((CharSequence)this.name)) {
            this.name = new Locale("", string2).getDisplayName();
        }
    }

    public void setCurrency(String string2) {
        this.currency = string2;
    }

    public void setDialCode(String string2) {
        this.dialCode = string2;
    }

    public void setFlag(int n) {
        this.flag = n;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Country{code='");
        stringBuilder.append(this.code);
        stringBuilder.append('\'');
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", dialCode='");
        stringBuilder.append(this.dialCode);
        stringBuilder.append('\'');
        stringBuilder.append(", flag=");
        stringBuilder.append(this.flag);
        stringBuilder.append(", currency='");
        stringBuilder.append(this.currency);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.code);
        parcel.writeString(this.name);
        parcel.writeString(this.dialCode);
        parcel.writeInt(this.flag);
        parcel.writeString(this.currency);
    }

}

