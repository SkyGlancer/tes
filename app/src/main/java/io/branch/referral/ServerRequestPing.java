/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.branch.referral.Branch
 *  java.lang.String
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerResponse;

public class ServerRequestPing
extends ServerRequest {
    public ServerRequestPing(Context context) {
        super(context, null);
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

    @Override
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
    }
}

