/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Map$Entry
 *  java.util.Set
 */
package app.dukhaan.src.java.io.branch.referral.util;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LinkProperties
implements Parcelable {
    public static final Creator CREATOR = new Creator(){

        public LinkProperties createFromParcel(Parcel parcel) {
            return new LinkProperties(parcel);
        }

        public LinkProperties[] newArray(int n) {
            return new LinkProperties[n];
        }
    };
    private String alias_ = "";
    private String campaign_ = "";
    private String channel_ = "";
    private final HashMap<String, String> controlParams_ = new HashMap();
    private String feature_ = "Share";
    private int matchDuration_ = 0;
    private String stage_ = "";
    private final ArrayList<String> tags_ = new ArrayList();

    public LinkProperties() {
    }

    private LinkProperties(Parcel parcel) {
        this();
        this.feature_ = parcel.readString();
        this.alias_ = parcel.readString();
        this.stage_ = parcel.readString();
        this.channel_ = parcel.readString();
        this.campaign_ = parcel.readString();
        this.matchDuration_ = parcel.readInt();
        ArrayList arrayList = (ArrayList)parcel.readSerializable();
        this.tags_.addAll((Collection)arrayList);
        int n = parcel.readInt();
        for (int i = 0; i < n; ++i) {
            this.controlParams_.put((Object)parcel.readString(), (Object)parcel.readString());
        }
    }

    /*
     * Exception decompiling
     */
    public static LinkProperties getReferredLinkProperties() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl129.1 : ALOAD : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    public LinkProperties addControlParameter(String string2, String string3) {
        this.controlParams_.put((Object)string2, (Object)string3);
        return this;
    }

    public LinkProperties addTag(String string2) {
        this.tags_.add((Object)string2);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public String getAlias() {
        return this.alias_;
    }

    public String getCampaign() {
        return this.campaign_;
    }

    public String getChannel() {
        return this.channel_;
    }

    public HashMap<String, String> getControlParams() {
        return this.controlParams_;
    }

    public String getFeature() {
        return this.feature_;
    }

    public int getMatchDuration() {
        return this.matchDuration_;
    }

    public String getStage() {
        return this.stage_;
    }

    public ArrayList<String> getTags() {
        return this.tags_;
    }

    public LinkProperties setAlias(String string2) {
        this.alias_ = string2;
        return this;
    }

    public LinkProperties setCampaign(String string2) {
        this.campaign_ = string2;
        return this;
    }

    public LinkProperties setChannel(String string2) {
        this.channel_ = string2;
        return this;
    }

    public LinkProperties setDuration(int n) {
        this.matchDuration_ = n;
        return this;
    }

    public LinkProperties setFeature(String string2) {
        this.feature_ = string2;
        return this;
    }

    public LinkProperties setStage(String string2) {
        this.stage_ = string2;
        return this;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.feature_);
        parcel.writeString(this.alias_);
        parcel.writeString(this.stage_);
        parcel.writeString(this.channel_);
        parcel.writeString(this.campaign_);
        parcel.writeInt(this.matchDuration_);
        parcel.writeSerializable(this.tags_);
        parcel.writeInt(this.controlParams_.size());
        for (Map.Entry entry : this.controlParams_.entrySet()) {
            parcel.writeString((String)entry.getKey());
            parcel.writeString((String)entry.getValue());
        }
    }

}

