/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.branch.referral.Branch
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerRequestInitSession;

class TrackingController {
    private boolean trackingDisabled = true;

    TrackingController(Context context) {
        this.updateTrackingState(context);
    }

    private void onTrackingDisabled(Context context) {
        Branch.getInstance().clearPendingRequests();
        PrefHelper prefHelper = PrefHelper.getInstance(context);
        prefHelper.setSessionID("bnc_no_value");
        prefHelper.setLinkClickID("bnc_no_value");
        prefHelper.setLinkClickIdentifier("bnc_no_value");
        prefHelper.setAppLink("bnc_no_value");
        prefHelper.setInstallReferrerParams("bnc_no_value");
        prefHelper.setGooglePlayReferrer("bnc_no_value");
        prefHelper.setGoogleSearchInstallIdentifier("bnc_no_value");
        prefHelper.setExternalIntentUri("bnc_no_value");
        prefHelper.setExternalIntentExtra("bnc_no_value");
        prefHelper.setSessionParams("bnc_no_value");
        prefHelper.saveLastStrongMatchTime(0L);
    }

    private void onTrackingEnabled() {
        Branch branch = Branch.getInstance();
        if (branch != null) {
            branch.registerAppInit(branch.getInstallOrOpenRequest(null), true);
        }
    }

    void disableTracking(Context context, boolean bl) {
        if (this.trackingDisabled != bl) {
            this.trackingDisabled = bl;
            if (bl) {
                this.onTrackingDisabled(context);
            } else {
                this.onTrackingEnabled();
            }
            PrefHelper.getInstance(context).setBool("bnc_tracking_state", bl);
        }
    }

    boolean isTrackingDisabled() {
        return this.trackingDisabled;
    }

    void updateTrackingState(Context context) {
        this.trackingDisabled = PrefHelper.getInstance(context).getBool("bnc_tracking_state");
    }
}

