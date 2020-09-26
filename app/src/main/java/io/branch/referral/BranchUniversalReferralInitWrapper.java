/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.branch.referral.Branch
 *  java.lang.Object
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.util.LinkProperties;
import org.json.JSONObject;

class BranchUniversalReferralInitWrapper
implements Branch.BranchReferralInitListener {
    private final Branch.BranchUniversalReferralInitListener universalReferralInitListener_;

    public BranchUniversalReferralInitWrapper(Branch.BranchUniversalReferralInitListener branchUniversalReferralInitListener) {
        this.universalReferralInitListener_ = branchUniversalReferralInitListener;
    }

    @Override
    public void onInitFinished(JSONObject jSONObject, BranchError branchError) {
        Branch.BranchUniversalReferralInitListener branchUniversalReferralInitListener = this.universalReferralInitListener_;
        if (branchUniversalReferralInitListener != null) {
            if (branchError != null) {
                branchUniversalReferralInitListener.onInitFinished(null, null, branchError);
                return;
            }
            BranchUniversalObject branchUniversalObject = BranchUniversalObject.getReferredBranchUniversalObject();
            LinkProperties linkProperties = LinkProperties.getReferredLinkProperties();
            this.universalReferralInitListener_.onInitFinished(branchUniversalObject, linkProperties, branchError);
        }
    }
}

