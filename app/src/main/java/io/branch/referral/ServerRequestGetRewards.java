/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.branch.referral.Branch
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
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
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class ServerRequestGetRewards
extends ServerRequest {
    Branch.BranchReferralStateChangedListener callback_;

    public ServerRequestGetRewards(Context context, Branch.BranchReferralStateChangedListener branchReferralStateChangedListener) {
        super(context, Defines.RequestPath.GetCredits.getPath());
        this.callback_ = branchReferralStateChangedListener;
    }

    public ServerRequestGetRewards(String string2, JSONObject jSONObject, Context context) {
        super(string2, jSONObject, context);
    }

    @Override
    public void clearCallbacks() {
        this.callback_ = null;
    }

    @Override
    public String getRequestUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getRequestUrl());
        stringBuilder.append(this.prefHelper_.getIdentityID());
        return stringBuilder.toString();
    }

    @Override
    public boolean handleErrors(Context context) {
        if (!super.doesAppHasInternetPermission(context)) {
            Branch.BranchReferralStateChangedListener branchReferralStateChangedListener = this.callback_;
            if (branchReferralStateChangedListener != null) {
                branchReferralStateChangedListener.onStateChanged(false, new BranchError("Trouble retrieving user credits.", -102));
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
            stringBuilder.append("Trouble retrieving user credits. ");
            stringBuilder.append(string2);
            branchReferralStateChangedListener.onStateChanged(false, new BranchError(stringBuilder.toString(), n));
        }
    }

    @Override
    public boolean isGetRequest() {
        return true;
    }

    @Override
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        Iterator iterator = serverResponse.getObject().keys();
        boolean bl = false;
        while (iterator.hasNext()) {
            int n;
            String string2;
            block5 : {
                string2 = (String)iterator.next();
                n = serverResponse.getObject().getInt(string2);
                if (n == this.prefHelper_.getCreditCount(string2)) break block5;
                bl = true;
            }
            try {
                this.prefHelper_.setCreditCount(string2, n);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
        }
        Branch.BranchReferralStateChangedListener branchReferralStateChangedListener = this.callback_;
        if (branchReferralStateChangedListener != null) {
            branchReferralStateChangedListener.onStateChanged(bl, null);
        }
    }
}

