/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.network;

import com.google.gson.annotations.SerializedName;

public class ErrorResponse {
    @SerializedName(value="detail")
    public Details detail;
    public String message;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ErrorResponse{message='");
        stringBuilder.append(this.message);
        stringBuilder.append('\'');
        stringBuilder.append(", detail=");
        stringBuilder.append((Object)this.detail);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public class Details {
        @SerializedName(value="error_code")
        public int errorCode;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Details{errorCode=");
            stringBuilder.append(this.errorCode);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

}

