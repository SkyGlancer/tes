/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.branch.referral.Branch
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
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

class ServerRequestLogout
extends ServerRequest {
    private Branch.LogoutStatusListener callback_;

    public ServerRequestLogout(Context context, Branch.LogoutStatusListener logoutStatusListener) {
        super(context, Defines.RequestPath.Logout.getPath());
        this.callback_ = logoutStatusListener;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Defines.Jsonkey.IdentityID.getKey(), (Object)this.prefHelper_.getIdentityID());
            jSONObject.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), (Object)this.prefHelper_.getDeviceFingerPrintID());
            jSONObject.put(Defines.Jsonkey.SessionID.getKey(), (Object)this.prefHelper_.getSessionID());
            if (!this.prefHelper_.getLinkClickID().equals((Object)"bnc_no_value")) {
                jSONObject.put(Defines.Jsonkey.LinkClickID.getKey(), (Object)this.prefHelper_.getLinkClickID());
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

    public ServerRequestLogout(String string2, JSONObject jSONObject, Context context) {
        super(string2, jSONObject, context);
    }

    @Override
    public void clearCallbacks() {
        this.callback_ = null;
    }

    @Override
    public boolean handleErrors(Context context) {
        if (!super.doesAppHasInternetPermission(context)) {
            Branch.LogoutStatusListener logoutStatusListener = this.callback_;
            if (logoutStatusListener != null) {
                logoutStatusListener.onLogoutFinished(false, new BranchError("Logout failed", -102));
            }
            return true;
        }
        return false;
    }

    @Override
    public void handleFailure(int n, String string2) {
        Branch.LogoutStatusListener logoutStatusListener = this.callback_;
        if (logoutStatusListener != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Logout error. ");
            stringBuilder.append(string2);
            logoutStatusListener.onLogoutFinished(false, new BranchError(stringBuilder.toString(), n));
        }
    }

    @Override
    public boolean isGetRequest() {
        return false;
    }

    @Override
    boolean isPersistable() {
        return false;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        Throwable throwable2222;
        block4 : {
            this.prefHelper_.setSessionID(serverResponse.getObject().getString(Defines.Jsonkey.SessionID.getKey()));
            this.prefHelper_.setIdentityID(serverResponse.getObject().getString(Defines.Jsonkey.IdentityID.getKey()));
            this.prefHelper_.setUserURL(serverResponse.getObject().getString(Defines.Jsonkey.Link.getKey()));
            this.prefHelper_.setInstallParams("bnc_no_value");
            this.prefHelper_.setSessionParams("bnc_no_value");
            this.prefHelper_.setIdentity("bnc_no_value");
            this.prefHelper_.clearUserValues();
            Branch.LogoutStatusListener logoutStatusListener = this.callback_;
            if (logoutStatusListener == null) return;
            {
                catch (Throwable throwable2222) {
                    break block4;
                }
                catch (JSONException jSONException) {}
                {
                    jSONException.printStackTrace();
                    logoutStatusListener = this.callback_;
                    if (logoutStatusListener == null) return;
                }
            }
            logoutStatusListener.onLogoutFinished(true, null);
            return;
        }
        Branch.LogoutStatusListener logoutStatusListener = this.callback_;
        if (logoutStatusListener == null) throw throwable2222;
        logoutStatusListener.onLogoutFinished(true, null);
        throw throwable2222;
    }
}

