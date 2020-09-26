/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.network.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AwardStatsResponse {
    @SerializedName(value="data")
    public List<AwardData> awardData;
    @SerializedName(value="status_code")
    public int statusCode;

    public class AwardData {
        @SerializedName(value="code")
        public String code;
        @SerializedName(value="description")
        public String description;
        @SerializedName(value="icon")
        public String icon;
        @SerializedName(value="name")
        public String name;
        @SerializedName(value="position")
        public int position;
        @SerializedName(value="progress")
        public int progress;
        @SerializedName(value="referral_required")
        public int referralRequired;
        @SerializedName(value="unlocked")
        public Boolean unlocked;
    }

}

