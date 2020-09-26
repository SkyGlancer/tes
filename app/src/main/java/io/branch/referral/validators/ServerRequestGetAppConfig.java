/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.branch.referral.Branch
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral.validators;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerResponse;
import org.json.JSONObject;

class ServerRequestGetAppConfig
extends ServerRequest {
    private final IGetAppConfigEvents callback;

    public ServerRequestGetAppConfig(Context context, IGetAppConfigEvents iGetAppConfigEvents) {
        super(context, "");
        this.callback = iGetAppConfigEvents;
    }

    @Override
    public void clearCallbacks() {
    }

    @Override
    public String getRequestUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.prefHelper_.getAPIBaseUrl());
        stringBuilder.append(Defines.RequestPath.GetApp.getPath());
        stringBuilder.append("/");
        stringBuilder.append(this.prefHelper_.getBranchKey());
        return stringBuilder.toString();
    }

    @Override
    public boolean handleErrors(Context context) {
        return false;
    }

    @Override
    public void handleFailure(int n, String string2) {
        IGetAppConfigEvents iGetAppConfigEvents = this.callback;
        if (iGetAppConfigEvents != null) {
            iGetAppConfigEvents.onAppConfigAvailable(null);
        }
    }

    @Override
    public boolean isGetRequest() {
        return true;
    }

    @Override
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        IGetAppConfigEvents iGetAppConfigEvents = this.callback;
        if (iGetAppConfigEvents != null) {
            iGetAppConfigEvents.onAppConfigAvailable(serverResponse.getObject());
        }
    }

    public static interface IGetAppConfigEvents {
        public void onAppConfigAvailable(JSONObject var1);
    }

}

