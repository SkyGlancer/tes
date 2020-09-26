/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.branch.referral.Branch
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.BranchViewHandler;
import io.branch.referral.Defines;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerResponse;
import io.branch.referral.util.BRANCH_STANDARD_EVENT;
import io.branch.referral.util.CommerceEvent;
import org.json.JSONException;
import org.json.JSONObject;

class ServerRequestActionCompleted
extends ServerRequest {
    private final BranchViewHandler.IBranchViewEvents callback_;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ServerRequestActionCompleted(Context context, String string2, CommerceEvent commerceEvent, JSONObject jSONObject, BranchViewHandler.IBranchViewEvents iBranchViewEvents) {
        super(context, Defines.RequestPath.CompletedAction.getPath());
        this.callback_ = iBranchViewEvents;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(Defines.Jsonkey.IdentityID.getKey(), (Object)this.prefHelper_.getIdentityID());
            jSONObject2.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), (Object)this.prefHelper_.getDeviceFingerPrintID());
            jSONObject2.put(Defines.Jsonkey.SessionID.getKey(), (Object)this.prefHelper_.getSessionID());
            if (!this.prefHelper_.getLinkClickID().equals((Object)"bnc_no_value")) {
                jSONObject2.put(Defines.Jsonkey.LinkClickID.getKey(), (Object)this.prefHelper_.getLinkClickID());
            }
            jSONObject2.put(Defines.Jsonkey.Event.getKey(), (Object)string2);
            if (jSONObject != null) {
                jSONObject2.put(Defines.Jsonkey.Metadata.getKey(), (Object)jSONObject);
            }
            if (commerceEvent != null) {
                jSONObject2.put(Defines.Jsonkey.CommerceData.getKey(), (Object)commerceEvent.getCommerceJSONObject());
            }
            this.updateEnvironment(context, jSONObject2);
            this.setPost(jSONObject2);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            this.constructError_ = true;
        }
        if (string2 != null && string2.equalsIgnoreCase(BRANCH_STANDARD_EVENT.PURCHASE.getName()) && commerceEvent == null) {
            PrefHelper.Debug("Warning: You are sending a purchase event with our non-dedicated purchase function. Please see function sendCommerceEvent");
        }
    }

    public ServerRequestActionCompleted(String string2, JSONObject jSONObject, Context context) {
        super(string2, jSONObject, context);
        this.callback_ = null;
    }

    @Override
    public void clearCallbacks() {
    }

    @Override
    public boolean handleErrors(Context context) {
        return !super.doesAppHasInternetPermission(context);
    }

    @Override
    public void handleFailure(int n, String string2) {
    }

    @Override
    public boolean isGetRequest() {
        return false;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void onRequestSucceeded(ServerResponse var1, Branch var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl58 : RETURN : trying to set 0 previously set to 1
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
    public boolean shouldRetryOnFail() {
        return true;
    }
}

