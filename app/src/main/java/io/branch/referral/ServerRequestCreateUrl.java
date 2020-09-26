/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.branch.referral.Branch
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.BranchLinkData;
import io.branch.referral.Defines;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerResponse;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

class ServerRequestCreateUrl
extends ServerRequest {
    private static final String DEF_BASE_URL = "https://bnc.lt/a/";
    private Branch.BranchLinkCreateListener callback_;
    private boolean defaultToLongUrl_ = true;
    private boolean isAsync_ = true;
    private boolean isReqStartedFromBranchShareSheet_;
    private BranchLinkData linkPost_;

    public ServerRequestCreateUrl(Context context, String string2, int n, int n2, Collection<String> collection, String string3, String string4, String string5, String string6, JSONObject jSONObject, Branch.BranchLinkCreateListener branchLinkCreateListener, boolean bl, boolean bl2) {
        BranchLinkData branchLinkData;
        super(context, Defines.RequestPath.GetURL.getPath());
        this.callback_ = branchLinkCreateListener;
        this.isAsync_ = bl;
        this.defaultToLongUrl_ = bl2;
        this.linkPost_ = branchLinkData = new BranchLinkData();
        try {
            branchLinkData.put(Defines.Jsonkey.IdentityID.getKey(), (Object)this.prefHelper_.getIdentityID());
            this.linkPost_.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), (Object)this.prefHelper_.getDeviceFingerPrintID());
            this.linkPost_.put(Defines.Jsonkey.SessionID.getKey(), (Object)this.prefHelper_.getSessionID());
            if (!this.prefHelper_.getLinkClickID().equals((Object)"bnc_no_value")) {
                this.linkPost_.put(Defines.Jsonkey.LinkClickID.getKey(), (Object)this.prefHelper_.getLinkClickID());
            }
            this.linkPost_.putType(n);
            this.linkPost_.putDuration(n2);
            this.linkPost_.putTags(collection);
            this.linkPost_.putAlias(string2);
            this.linkPost_.putChannel(string3);
            this.linkPost_.putFeature(string4);
            this.linkPost_.putStage(string5);
            this.linkPost_.putCampaign(string6);
            this.linkPost_.putParams(jSONObject);
            this.setPost(this.linkPost_);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            this.constructError_ = true;
            return;
        }
    }

    public ServerRequestCreateUrl(String string2, JSONObject jSONObject, Context context) {
        super(string2, jSONObject, context);
    }

    /*
     * Exception decompiling
     */
    private String generateLongUrlWithParams(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl415 : ALOAD_1 : trying to set 1 previously set to 0
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

    @Override
    public void clearCallbacks() {
        this.callback_ = null;
    }

    public BranchLinkData getLinkPost() {
        return this.linkPost_;
    }

    public String getLongUrl() {
        if (!this.prefHelper_.getUserURL().equals((Object)"bnc_no_value")) {
            return this.generateLongUrlWithParams(this.prefHelper_.getUserURL());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DEF_BASE_URL);
        stringBuilder.append(this.prefHelper_.getBranchKey());
        return this.generateLongUrlWithParams(stringBuilder.toString());
    }

    public void handleDuplicateURLError() {
        Branch.BranchLinkCreateListener branchLinkCreateListener = this.callback_;
        if (branchLinkCreateListener != null) {
            branchLinkCreateListener.onLinkCreate(null, new BranchError("Trouble creating a URL.", -105));
        }
    }

    @Override
    public boolean handleErrors(Context context) {
        if (!super.doesAppHasInternetPermission(context)) {
            Branch.BranchLinkCreateListener branchLinkCreateListener = this.callback_;
            if (branchLinkCreateListener != null) {
                branchLinkCreateListener.onLinkCreate(null, new BranchError("Trouble creating a URL.", -102));
            }
            return true;
        }
        return false;
    }

    @Override
    public void handleFailure(int n, String string2) {
        if (this.callback_ != null) {
            boolean bl = this.defaultToLongUrl_;
            String string3 = null;
            if (bl) {
                string3 = this.getLongUrl();
            }
            Branch.BranchLinkCreateListener branchLinkCreateListener = this.callback_;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Trouble creating a URL. ");
            stringBuilder.append(string2);
            branchLinkCreateListener.onLinkCreate(string3, new BranchError(stringBuilder.toString(), n));
        }
    }

    public boolean isAsync() {
        return this.isAsync_;
    }

    boolean isDefaultToLongUrl() {
        return this.defaultToLongUrl_;
    }

    @Override
    public boolean isGetRequest() {
        return false;
    }

    @Override
    boolean isPersistable() {
        return false;
    }

    boolean isReqStartedFromBranchShareSheet() {
        return this.isReqStartedFromBranchShareSheet_;
    }

    @Override
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        try {
            String string2 = serverResponse.getObject().getString("url");
            if (this.callback_ != null) {
                this.callback_.onLinkCreate(string2, null);
                return;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void onUrlAvailable(String string2) {
        Branch.BranchLinkCreateListener branchLinkCreateListener = this.callback_;
        if (branchLinkCreateListener != null) {
            branchLinkCreateListener.onLinkCreate(string2, null);
        }
    }

    @Override
    protected boolean prepareExecuteWithoutTracking() {
        return true;
    }

    void setIsReqStartedFromBranchShareSheet(boolean bl) {
        this.isReqStartedFromBranchShareSheet_ = bl;
    }
}

