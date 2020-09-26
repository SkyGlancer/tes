/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.branch.referral.Branch
 *  java.lang.String
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.BranchUrlBuilder;
import org.json.JSONObject;

public class BranchShortLinkBuilder
extends BranchUrlBuilder<BranchShortLinkBuilder> {
    public BranchShortLinkBuilder(Context context) {
        super(context);
    }

    public void generateShortUrl(Branch.BranchLinkCreateListener branchLinkCreateListener) {
        super.generateUrl(branchLinkCreateListener);
    }

    void generateShortUrlInternal(Branch.BranchLinkCreateListener branchLinkCreateListener, boolean bl) {
        super.generateUrlInternal(branchLinkCreateListener, bl);
    }

    public String getShortUrl() {
        return super.getUrl();
    }

    public BranchShortLinkBuilder setAlias(String string2) {
        this.alias_ = string2;
        return this;
    }

    public BranchShortLinkBuilder setCampaign(String string2) {
        this.campaign_ = string2;
        return this;
    }

    public BranchShortLinkBuilder setChannel(String string2) {
        this.channel_ = string2;
        return this;
    }

    public BranchShortLinkBuilder setDuration(int n) {
        this.duration_ = n;
        return this;
    }

    public BranchShortLinkBuilder setFeature(String string2) {
        this.feature_ = string2;
        return this;
    }

    public BranchShortLinkBuilder setParameters(JSONObject jSONObject) {
        this.params_ = jSONObject;
        return this;
    }

    public BranchShortLinkBuilder setStage(String string2) {
        this.stage_ = string2;
        return this;
    }

    public BranchShortLinkBuilder setType(int n) {
        this.type_ = n;
        return this;
    }
}

