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
import io.branch.referral.BranchError;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerResponse;
import io.branch.referral.util.BranchCPID;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerRequestGetCPID
extends ServerRequest {
    private BranchCrossPlatformIdListener callback;

    ServerRequestGetCPID(Context context, String string2, BranchCrossPlatformIdListener branchCrossPlatformIdListener) {
        super(context, string2);
        this.callback = branchCrossPlatformIdListener;
        JSONObject jSONObject = new JSONObject();
        try {
            this.setPost(jSONObject);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        this.updateEnvironment(context, jSONObject);
    }

    @Override
    public void clearCallbacks() {
    }

    @Override
    public ServerRequest.BRANCH_API_VERSION getBranchRemoteAPIVersion() {
        return ServerRequest.BRANCH_API_VERSION.V1_CPID;
    }

    @Override
    public boolean handleErrors(Context context) {
        return false;
    }

    @Override
    public void handleFailure(int n, String string2) {
        BranchCrossPlatformIdListener branchCrossPlatformIdListener = this.callback;
        if (branchCrossPlatformIdListener == null) {
            return;
        }
        branchCrossPlatformIdListener.onDataFetched(null, new BranchError("Failed to get the Cross Platform IDs", -116));
    }

    @Override
    public boolean isGetRequest() {
        return false;
    }

    @Override
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        BranchCrossPlatformIdListener branchCrossPlatformIdListener = this.callback;
        if (branchCrossPlatformIdListener == null) {
            return;
        }
        if (serverResponse != null) {
            branchCrossPlatformIdListener.onDataFetched(new BranchCPID(serverResponse.getObject()), null);
            return;
        }
        branchCrossPlatformIdListener.onDataFetched(null, new BranchError("Failed to get the Cross Platform IDs", -116));
    }

    @Override
    public boolean shouldRetryOnFail() {
        return true;
    }

    @Override
    protected boolean shouldUpdateLimitFacebookTracking() {
        return true;
    }

    public static interface BranchCrossPlatformIdListener {
        public void onDataFetched(BranchCPID var1, BranchError var2);
    }

}

