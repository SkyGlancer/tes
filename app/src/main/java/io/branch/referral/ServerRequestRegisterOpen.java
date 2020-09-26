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

class ServerRequestRegisterOpen
extends ServerRequestInitSession {
    Branch.BranchReferralInitListener callback_;

    ServerRequestRegisterOpen(Context context, Branch.BranchReferralInitListener branchReferralInitListener) {
        super(context, Defines.RequestPath.RegisterOpen.getPath());
        this.callback_ = branchReferralInitListener;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), (Object)this.prefHelper_.getDeviceFingerPrintID());
            jSONObject.put(Defines.Jsonkey.IdentityID.getKey(), (Object)this.prefHelper_.getIdentityID());
            this.setPost(jSONObject);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            this.constructError_ = true;
            return;
        }
    }

    ServerRequestRegisterOpen(String string2, JSONObject jSONObject, Context context) {
        super(string2, jSONObject, context);
    }

    @Override
    public void clearCallbacks() {
        this.callback_ = null;
    }

    @Override
    public String getRequestActionName() {
        return "open";
    }

    @Override
    public boolean handleErrors(Context context) {
        if (!super.doesAppHasInternetPermission(context)) {
            if (this.callback_ != null && !Branch.getInstance().isIDLSession()) {
                this.callback_.onInitFinished(null, new BranchError("Trouble initializing Branch.", -102));
            }
            return true;
        }
        return false;
    }

    @Override
    public void handleFailure(int n, String string2) {
        if (this.callback_ != null && !Branch.getInstance().isIDLSession()) {
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

    @Override
    public void onPreExecute() {
        super.onPreExecute();
        if (Branch.getInstance().isInstantDeepLinkPossible()) {
            Branch.BranchReferralInitListener branchReferralInitListener = this.callback_;
            if (branchReferralInitListener != null) {
                branchReferralInitListener.onInitFinished(Branch.getInstance().getLatestReferringParams(), null);
            }
            Branch.getInstance().addExtraInstrumentationData(Defines.Jsonkey.InstantDeepLinkSession.getKey(), "true");
            Branch.getInstance().setInstantDeepLinkPossible(false);
        }
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
            boolean bl = serverResponse.getObject().has(Defines.Jsonkey.LinkClickID.getKey());
            if (bl) {
                this.prefHelper_.setLinkClickID(serverResponse.getObject().getString(Defines.Jsonkey.LinkClickID.getKey()));
            } else {
                this.prefHelper_.setLinkClickID("bnc_no_value");
            }
            if (serverResponse.getObject().has(Defines.Jsonkey.Data.getKey()) && (jSONObject = new JSONObject(serverResponse.getObject().getString(Defines.Jsonkey.Data.getKey()))).has(Defines.Jsonkey.Clicked_Branch_Link.getKey()) && jSONObject.getBoolean(Defines.Jsonkey.Clicked_Branch_Link.getKey()) && this.prefHelper_.getInstallParams().equals((Object)"bnc_no_value") && this.prefHelper_.getIsReferrable() == 1) {
                String string2 = serverResponse.getObject().getString(Defines.Jsonkey.Data.getKey());
                this.prefHelper_.setInstallParams(string2);
            }
            if (serverResponse.getObject().has(Defines.Jsonkey.Data.getKey())) {
                String string3 = serverResponse.getObject().getString(Defines.Jsonkey.Data.getKey());
                this.prefHelper_.setSessionParams(string3);
            } else {
                this.prefHelper_.setSessionParams("bnc_no_value");
            }
            if (this.callback_ != null && !Branch.getInstance().isIDLSession()) {
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

