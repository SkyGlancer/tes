/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.branch.referral.Branch
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONArray
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ServerRequestGetRewardHistory
extends ServerRequest {
    Branch.BranchListResponseListener callback_;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ServerRequestGetRewardHistory(Context context, String string2, String string3, int n, Branch.CreditHistoryOrder creditHistoryOrder, Branch.BranchListResponseListener branchListResponseListener) {
        super(context, Defines.RequestPath.GetCreditHistory.getPath());
        this.callback_ = branchListResponseListener;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Defines.Jsonkey.IdentityID.getKey(), (Object)this.prefHelper_.getIdentityID());
            jSONObject.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), (Object)this.prefHelper_.getDeviceFingerPrintID());
            jSONObject.put(Defines.Jsonkey.SessionID.getKey(), (Object)this.prefHelper_.getSessionID());
            if (!this.prefHelper_.getLinkClickID().equals((Object)"bnc_no_value")) {
                jSONObject.put(Defines.Jsonkey.LinkClickID.getKey(), (Object)this.prefHelper_.getLinkClickID());
            }
            jSONObject.put(Defines.Jsonkey.Length.getKey(), n);
            jSONObject.put(Defines.Jsonkey.Direction.getKey(), creditHistoryOrder.ordinal());
            if (string2 != null) {
                jSONObject.put(Defines.Jsonkey.Bucket.getKey(), (Object)string2);
            }
            if (string3 != null) {
                jSONObject.put(Defines.Jsonkey.BeginAfterID.getKey(), (Object)string3);
            }
            this.setPost(jSONObject);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            this.constructError_ = true;
            return;
        }
    }

    public ServerRequestGetRewardHistory(String string2, JSONObject jSONObject, Context context) {
        super(string2, jSONObject, context);
    }

    @Override
    public void clearCallbacks() {
        this.callback_ = null;
    }

    @Override
    public boolean handleErrors(Context context) {
        if (!super.doesAppHasInternetPermission(context)) {
            Branch.BranchListResponseListener branchListResponseListener = this.callback_;
            if (branchListResponseListener != null) {
                branchListResponseListener.onReceivingResponse(null, new BranchError("Trouble retrieving user credit history.", -102));
            }
            return true;
        }
        return false;
    }

    @Override
    public void handleFailure(int n, String string2) {
        Branch.BranchListResponseListener branchListResponseListener = this.callback_;
        if (branchListResponseListener != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Trouble retrieving user credit history. ");
            stringBuilder.append(string2);
            branchListResponseListener.onReceivingResponse(null, new BranchError(stringBuilder.toString(), n));
        }
    }

    @Override
    public boolean isGetRequest() {
        return false;
    }

    @Override
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        Branch.BranchListResponseListener branchListResponseListener = this.callback_;
        if (branchListResponseListener != null) {
            branchListResponseListener.onReceivingResponse(serverResponse.getArray(), null);
        }
    }
}

