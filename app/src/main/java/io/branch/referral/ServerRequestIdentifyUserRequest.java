/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.branch.referral.Branch
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.Defines;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerResponse;
import org.json.JSONException;
import org.json.JSONObject;

class ServerRequestIdentifyUserRequest
extends ServerRequest {
    Branch.BranchReferralInitListener callback_;
    String userId_ = null;

    public ServerRequestIdentifyUserRequest(Context context, Branch.BranchReferralInitListener branchReferralInitListener, String string2) {
        super(context, Defines.RequestPath.IdentifyUser.getPath());
        this.callback_ = branchReferralInitListener;
        this.userId_ = string2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Defines.Jsonkey.IdentityID.getKey(), (Object)this.prefHelper_.getIdentityID());
            jSONObject.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), (Object)this.prefHelper_.getDeviceFingerPrintID());
            jSONObject.put(Defines.Jsonkey.SessionID.getKey(), (Object)this.prefHelper_.getSessionID());
            if (!this.prefHelper_.getLinkClickID().equals((Object)"bnc_no_value")) {
                jSONObject.put(Defines.Jsonkey.LinkClickID.getKey(), (Object)this.prefHelper_.getLinkClickID());
            }
            jSONObject.put(Defines.Jsonkey.Identity.getKey(), (Object)string2);
            this.setPost(jSONObject);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            this.constructError_ = true;
            return;
        }
    }

    public ServerRequestIdentifyUserRequest(String string2, JSONObject jSONObject, Context context) {
        super(string2, jSONObject, context);
    }

    @Override
    public void clearCallbacks() {
        this.callback_ = null;
    }

    /*
     * Exception decompiling
     */
    @Override
    public boolean handleErrors(Context var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl43.1 : ICONST_1 : trying to set 1 previously set to 0
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
    public void handleFailure(int n, String string2) {
        if (this.callback_ != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_message", (Object)"Trouble reaching server. Please try again in a few minutes");
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
            Branch.BranchReferralInitListener branchReferralInitListener = this.callback_;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Trouble setting the user alias. ");
            stringBuilder.append(string2);
            branchReferralInitListener.onInitFinished(jSONObject, new BranchError(stringBuilder.toString(), n));
        }
    }

    public void handleUserExist(Branch branch) {
        Branch.BranchReferralInitListener branchReferralInitListener = this.callback_;
        if (branchReferralInitListener != null) {
            branchReferralInitListener.onInitFinished(branch.getFirstReferringParams(), null);
        }
    }

    public boolean isExistingID() {
        boolean bl;
        block3 : {
            String string2;
            try {
                string2 = this.getPost().getString(Defines.Jsonkey.Identity.getKey());
                bl = false;
                if (string2 == null) break block3;
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
                return false;
            }
            boolean bl2 = string2.equals((Object)this.prefHelper_.getIdentity());
            bl = false;
            if (!bl2) break block3;
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean isGetRequest() {
        return false;
    }

    @Override
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        try {
            if (this.getPost() != null && this.getPost().has(Defines.Jsonkey.Identity.getKey())) {
                this.prefHelper_.setIdentity(this.getPost().getString(Defines.Jsonkey.Identity.getKey()));
            }
            this.prefHelper_.setIdentityID(serverResponse.getObject().getString(Defines.Jsonkey.IdentityID.getKey()));
            this.prefHelper_.setUserURL(serverResponse.getObject().getString(Defines.Jsonkey.Link.getKey()));
            if (serverResponse.getObject().has(Defines.Jsonkey.ReferringData.getKey())) {
                String string2 = serverResponse.getObject().getString(Defines.Jsonkey.ReferringData.getKey());
                this.prefHelper_.setInstallParams(string2);
            }
            if (this.callback_ != null) {
                this.callback_.onInitFinished(branch.getFirstReferringParams(), null);
                return;
            }
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
    }

    @Override
    public boolean shouldRetryOnFail() {
        return true;
    }
}

