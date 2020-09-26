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
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerRequestGetLATD
extends ServerRequest {
    protected static final int defaultAttributionWindow = -1;
    private int attributionWindow;
    private BranchLastAttributedTouchDataListener callback;

    ServerRequestGetLATD(Context context, String string2, BranchLastAttributedTouchDataListener branchLastAttributedTouchDataListener) {
        this(context, string2, branchLastAttributedTouchDataListener, PrefHelper.getInstance(context).getLATDAttributionWindow());
    }

    ServerRequestGetLATD(Context context, String string2, BranchLastAttributedTouchDataListener branchLastAttributedTouchDataListener, int n) {
        super(context, string2);
        this.callback = branchLastAttributedTouchDataListener;
        this.attributionWindow = n;
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

    protected int getAttributionWindow() {
        return this.attributionWindow;
    }

    @Override
    public ServerRequest.BRANCH_API_VERSION getBranchRemoteAPIVersion() {
        return ServerRequest.BRANCH_API_VERSION.V1_LATD;
    }

    @Override
    public boolean handleErrors(Context context) {
        return false;
    }

    @Override
    public void handleFailure(int n, String string2) {
        BranchLastAttributedTouchDataListener branchLastAttributedTouchDataListener = this.callback;
        if (branchLastAttributedTouchDataListener != null) {
            branchLastAttributedTouchDataListener.onDataFetched(null, new BranchError("Failed to get last attributed touch data", -116));
        }
    }

    @Override
    public boolean isGetRequest() {
        return false;
    }

    @Override
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        BranchLastAttributedTouchDataListener branchLastAttributedTouchDataListener = this.callback;
        if (branchLastAttributedTouchDataListener == null) {
            return;
        }
        if (serverResponse != null) {
            branchLastAttributedTouchDataListener.onDataFetched(serverResponse.getObject(), null);
            return;
        }
        this.handleFailure(-116, "Failed to get last attributed touch data");
    }

    @Override
    public boolean shouldRetryOnFail() {
        return true;
    }

    @Override
    protected boolean shouldUpdateLimitFacebookTracking() {
        return true;
    }

    public static interface BranchLastAttributedTouchDataListener {
        public void onDataFetched(JSONObject var1, BranchError var2);
    }

}

