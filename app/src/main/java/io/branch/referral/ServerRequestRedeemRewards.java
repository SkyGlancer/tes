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

class ServerRequestRedeemRewards
extends ServerRequest {
    int actualNumOfCreditsToRedeem_ = 0;
    Branch.BranchReferralStateChangedListener callback_;

    public ServerRequestRedeemRewards(Context context, String string2, int n, Branch.BranchReferralStateChangedListener branchReferralStateChangedListener) {
        super(context, Defines.RequestPath.RedeemRewards.getPath());
        this.callback_ = branchReferralStateChangedListener;
        int n2 = this.prefHelper_.getCreditCount(string2);
        this.actualNumOfCreditsToRedeem_ = n;
        if (n > n2) {
            this.actualNumOfCreditsToRedeem_ = n2;
            PrefHelper.Debug("Warning: You're trying to redeem more credits than are available. Have you updated loaded rewards");
        }
        if (this.actualNumOfCreditsToRedeem_ > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Defines.Jsonkey.IdentityID.getKey(), (Object)this.prefHelper_.getIdentityID());
                jSONObject.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), (Object)this.prefHelper_.getDeviceFingerPrintID());
                jSONObject.put(Defines.Jsonkey.SessionID.getKey(), (Object)this.prefHelper_.getSessionID());
                if (!this.prefHelper_.getLinkClickID().equals((Object)"bnc_no_value")) {
                    jSONObject.put(Defines.Jsonkey.LinkClickID.getKey(), (Object)this.prefHelper_.getLinkClickID());
                }
                jSONObject.put(Defines.Jsonkey.Bucket.getKey(), (Object)string2);
                jSONObject.put(Defines.Jsonkey.Amount.getKey(), this.actualNumOfCreditsToRedeem_);
                this.setPost(jSONObject);
                return;
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
                this.constructError_ = true;
            }
        }
    }

    public ServerRequestRedeemRewards(String string2, JSONObject jSONObject, Context context) {
        super(string2, jSONObject, context);
    }

    @Override
    public void clearCallbacks() {
        this.callback_ = null;
    }

    @Override
    public boolean handleErrors(Context context) {
        if (!super.doesAppHasInternetPermission(context)) {
            Branch.BranchReferralStateChangedListener branchReferralStateChangedListener = this.callback_;
            if (branchReferralStateChangedListener != null) {
                branchReferralStateChangedListener.onStateChanged(false, new BranchError("Trouble redeeming rewards.", -102));
            }
            return true;
        }
        if (this.actualNumOfCreditsToRedeem_ <= 0) {
            Branch.BranchReferralStateChangedListener branchReferralStateChangedListener = this.callback_;
            if (branchReferralStateChangedListener != null) {
                branchReferralStateChangedListener.onStateChanged(false, new BranchError("Trouble redeeming rewards.", -107));
            }
            return true;
        }
        return false;
    }

    @Override
    public void handleFailure(int n, String string2) {
        Branch.BranchReferralStateChangedListener branchReferralStateChangedListener = this.callback_;
        if (branchReferralStateChangedListener != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Trouble redeeming rewards. ");
            stringBuilder.append(string2);
            branchReferralStateChangedListener.onStateChanged(false, new BranchError(stringBuilder.toString(), n));
        }
    }

    @Override
    public boolean isGetRequest() {
        return false;
    }

    @Override
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        JSONObject jSONObject = this.getPost();
        boolean bl = false;
        if (jSONObject != null) {
            boolean bl2 = jSONObject.has(Defines.Jsonkey.Bucket.getKey());
            bl = false;
            if (bl2) {
                boolean bl3 = jSONObject.has(Defines.Jsonkey.Amount.getKey());
                bl = false;
                if (bl3) {
                    String string2;
                    int n;
                    block7 : {
                        n = jSONObject.getInt(Defines.Jsonkey.Amount.getKey());
                        string2 = jSONObject.getString(Defines.Jsonkey.Bucket.getKey());
                        bl = false;
                        if (n <= 0) break block7;
                        bl = true;
                    }
                    try {
                        int n2 = this.prefHelper_.getCreditCount(string2) - n;
                        this.prefHelper_.setCreditCount(string2, n2);
                    }
                    catch (JSONException jSONException) {
                        jSONException.printStackTrace();
                    }
                }
            }
        }
        if (this.callback_ != null) {
            BranchError branchError = bl ? null : new BranchError("Trouble redeeming rewards.", -107);
            this.callback_.onStateChanged(bl, branchError);
        }
    }
}

