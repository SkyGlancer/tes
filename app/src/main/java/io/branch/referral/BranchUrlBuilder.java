/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.branch.referral.Branch
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.BranchUtil;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerRequestCreateUrl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

abstract class BranchUrlBuilder<T extends BranchUrlBuilder> {
    protected String alias_;
    protected Branch branchReferral_ = Branch.getInstance();
    protected String campaign_;
    protected String channel_;
    private final Context context_;
    private boolean defaultToLongUrl_;
    protected int duration_ = 0;
    protected String feature_;
    protected JSONObject params_;
    protected String stage_;
    protected ArrayList<String> tags_;
    protected int type_ = 0;

    protected BranchUrlBuilder(Context context) {
        this.context_ = context.getApplicationContext();
        this.defaultToLongUrl_ = true;
    }

    public T addParameters(String string2, Object object) {
        try {
            if (this.params_ == null) {
                this.params_ = new JSONObject();
            }
            this.params_.put(string2, object);
        }
        catch (JSONException jSONException) {}
        return (T)this;
    }

    public T addTag(String string2) {
        if (this.tags_ == null) {
            this.tags_ = new ArrayList();
        }
        this.tags_.add((Object)string2);
        return (T)this;
    }

    public T addTags(List<String> list) {
        if (this.tags_ == null) {
            this.tags_ = new ArrayList();
        }
        this.tags_.addAll(list);
        return (T)this;
    }

    protected void generateUrl(Branch.BranchLinkCreateListener branchLinkCreateListener) {
        this.generateUrlInternal(branchLinkCreateListener, false);
    }

    protected void generateUrlInternal(Branch.BranchLinkCreateListener branchLinkCreateListener, boolean bl) {
        if (this.branchReferral_ != null) {
            ServerRequestCreateUrl serverRequestCreateUrl = new ServerRequestCreateUrl(this.context_, this.alias_, this.type_, this.duration_, (Collection<String>)this.tags_, this.channel_, this.feature_, this.stage_, this.campaign_, BranchUtil.formatLinkParam(this.params_), branchLinkCreateListener, true, this.defaultToLongUrl_);
            serverRequestCreateUrl.setIsReqStartedFromBranchShareSheet(bl);
            this.branchReferral_.generateShortLinkInternal(serverRequestCreateUrl);
            return;
        }
        if (branchLinkCreateListener != null) {
            branchLinkCreateListener.onLinkCreate(null, new BranchError("session has not been initialized", -101));
        }
        PrefHelper.Debug("Warning: User session has not been initialized");
    }

    protected String getUrl() {
        if (this.branchReferral_ != null) {
            ServerRequestCreateUrl serverRequestCreateUrl = new ServerRequestCreateUrl(this.context_, this.alias_, this.type_, this.duration_, (Collection<String>)this.tags_, this.channel_, this.feature_, this.stage_, this.campaign_, BranchUtil.formatLinkParam(this.params_), null, false, this.defaultToLongUrl_);
            return this.branchReferral_.generateShortLinkInternal(serverRequestCreateUrl);
        }
        return null;
    }

    public T setDefaultToLongUrl(boolean bl) {
        this.defaultToLongUrl_ = bl;
        return (T)this;
    }
}

