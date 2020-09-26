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
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.Defines;
import io.branch.referral.DeviceInfo;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerRequestInitSession;
import io.branch.referral.ServerResponse;
import org.json.JSONException;
import org.json.JSONObject;

class ServerRequestRegisterInstall
extends ServerRequestInitSession {
    Branch.BranchReferralInitListener callback_;

    ServerRequestRegisterInstall(Context context, Branch.BranchReferralInitListener branchReferralInitListener) {
        super(context, Defines.RequestPath.RegisterInstall.getPath());
        this.callback_ = branchReferralInitListener;
        try {
            this.setPost(new JSONObject());
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            this.constructError_ = true;
            return;
        }
    }

    ServerRequestRegisterInstall(String string2, JSONObject jSONObject, Context context) {
        super(string2, jSONObject, context);
    }

    @Override
    public void clearCallbacks() {
        this.callback_ = null;
    }

    @Override
    public String getRequestActionName() {
        return "install";
    }

    @Override
    public boolean handleErrors(Context context) {
        if (!super.doesAppHasInternetPermission(context)) {
            Branch.BranchReferralInitListener branchReferralInitListener = this.callback_;
            if (branchReferralInitListener != null) {
                branchReferralInitListener.onInitFinished(null, new BranchError("Trouble initializing Branch.", -102));
            }
            return true;
        }
        return false;
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
            stringBuilder.append("Trouble initializing Branch. ");
            stringBuilder.append(string2);
            branchReferralInitListener.onInitFinished(jSONObject, new BranchError(stringBuilder.toString(), n));
        }
    }

    @Override
    public boolean isGetRequest() {
        return false;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void onPreExecute() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        super.onRequestSucceeded(serverResponse, branch);
        try {
            JSONObject jSONObject;
            this.prefHelper_.setUserURL(serverResponse.getObject().getString(Defines.Jsonkey.Link.getKey()));
            boolean bl = serverResponse.getObject().has(Defines.Jsonkey.Data.getKey());
            if (bl && (jSONObject = new JSONObject(serverResponse.getObject().getString(Defines.Jsonkey.Data.getKey()))).has(Defines.Jsonkey.Clicked_Branch_Link.getKey()) && jSONObject.getBoolean(Defines.Jsonkey.Clicked_Branch_Link.getKey()) && this.prefHelper_.getInstallParams().equals((Object)"bnc_no_value") && this.prefHelper_.getIsReferrable() == 1) {
                String string2 = serverResponse.getObject().getString(Defines.Jsonkey.Data.getKey());
                this.prefHelper_.setInstallParams(string2);
            }
            if (serverResponse.getObject().has(Defines.Jsonkey.LinkClickID.getKey())) {
                this.prefHelper_.setLinkClickID(serverResponse.getObject().getString(Defines.Jsonkey.LinkClickID.getKey()));
            } else {
                this.prefHelper_.setLinkClickID("bnc_no_value");
            }
            if (serverResponse.getObject().has(Defines.Jsonkey.Data.getKey())) {
                String string3 = serverResponse.getObject().getString(Defines.Jsonkey.Data.getKey());
                this.prefHelper_.setSessionParams(string3);
            } else {
                this.prefHelper_.setSessionParams("bnc_no_value");
            }
            if (this.callback_ != null) {
                this.callback_.onInitFinished(branch.getLatestReferringParams(), null);
            }
            this.prefHelper_.setAppVersion(DeviceInfo.getInstance().getAppVersion());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.onInitSessionCompleted(serverResponse, branch);
    }

    void setInitFinishedCallback(Branch.BranchReferralInitListener branchReferralInitListener) {
        if (branchReferralInitListener != null) {
            this.callback_ = branchReferralInitListener;
        }
    }
}

