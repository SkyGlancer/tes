/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  io.branch.referral.Branch
 */
package app.dukhaan.src.java.io.branch.referral;

import android.app.Application;
import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.BranchUtil;

public class BranchApp
extends Application {
    public void onCreate() {
        super.onCreate();
        if (!BranchUtil.checkTestMode((Context)this)) {
            Branch.getAutoInstance((Context)this);
            return;
        }
        Branch.getTestInstance((Context)this);
    }
}

