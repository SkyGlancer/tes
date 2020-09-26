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
import io.branch.referral.BranchUrlBuilder;

public class BranchReferralUrlBuilder
extends BranchUrlBuilder<BranchReferralUrlBuilder> {
    public BranchReferralUrlBuilder(Context context, String string2) {
        super(context);
        this.channel_ = string2;
        this.type_ = 0;
        this.feature_ = "referral";
    }

    public void generateReferralUrl(Branch.BranchLinkCreateListener branchLinkCreateListener) {
        super.generateUrl(branchLinkCreateListener);
    }

    public String getReferralUrl() {
        return super.getUrl();
    }
}

