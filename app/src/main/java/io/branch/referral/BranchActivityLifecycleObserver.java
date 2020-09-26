/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Bundle
 *  io.branch.referral.Branch
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.HashSet
 *  java.util.Set
 */
package app.dukhaan.src.java.io.branch.referral;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import io.branch.referral.Branch;
import io.branch.referral.BranchViewHandler;
import io.branch.referral.DeviceInfo;
import io.branch.referral.PrefHelper;
import io.branch.referral.ShareLinkManager;
import io.branch.referral.SystemObserver;
import io.branch.referral.TrackingController;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

class BranchActivityLifecycleObserver
implements Application.ActivityLifecycleCallbacks {
    private Set<String> activitiesOnStack_ = new HashSet();
    private int activityCnt_ = 0;

    BranchActivityLifecycleObserver() {
    }

    private void maybeRefreshAdvertisingID(Context context) {
        Branch branch = Branch.getInstance();
        if (branch == null) {
            return;
        }
        boolean bl = branch.getTrackingController() != null && branch.getDeviceInfo() != null && branch.getDeviceInfo().getSystemObserver() != null && branch.getPrefHelper() != null && branch.getPrefHelper().getSessionID() != null;
        if (!bl) {
            return;
        }
        String string2 = branch.getDeviceInfo().getSystemObserver().getAIDInitializationSessionID();
        if (!(branch.getPrefHelper().getSessionID().equals((Object)string2) || branch.isGAParamsFetchInProgress() || branch.getTrackingController().isTrackingDisabled())) {
            branch.setGAParamsFetchInProgress(branch.getDeviceInfo().getSystemObserver().prefetchAdsParams(context, branch));
        }
    }

    boolean isCurrentActivityLaunchedFromStack() {
        Branch branch = Branch.getInstance();
        if (branch != null && branch.getCurrentActivity() != null) {
            return this.activitiesOnStack_.contains((Object)branch.getCurrentActivity().toString());
        }
        return false;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityCreated, activity = ");
        stringBuilder.append((Object)activity);
        PrefHelper.Debug(stringBuilder.toString());
        Branch branch = Branch.getInstance();
        if (branch == null) {
            return;
        }
        branch.setIntentState(Branch.INTENT_STATE.PENDING);
        if (BranchViewHandler.getInstance().isInstallOrOpenBranchViewPending(activity.getApplicationContext())) {
            BranchViewHandler.getInstance().showPendingBranchView((Context)activity);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityDestroyed, activity = ");
        stringBuilder.append((Object)activity);
        PrefHelper.Debug(stringBuilder.toString());
        Branch branch = Branch.getInstance();
        if (branch == null) {
            return;
        }
        if (branch.getCurrentActivity() == activity) {
            branch.currentActivityReference_.clear();
        }
        BranchViewHandler.getInstance().onCurrentActivityDestroyed(activity);
        this.activitiesOnStack_.remove((Object)activity.toString());
    }

    public void onActivityPaused(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityPaused, activity = ");
        stringBuilder.append((Object)activity);
        PrefHelper.Debug(stringBuilder.toString());
        Branch branch = Branch.getInstance();
        if (branch == null) {
            return;
        }
        if (branch.getShareLinkManager() != null) {
            branch.getShareLinkManager().cancelShareLinkDialog(true);
        }
    }

    public void onActivityResumed(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityResumed, activity = ");
        stringBuilder.append((Object)activity);
        PrefHelper.Debug(stringBuilder.toString());
        Branch branch = Branch.getInstance();
        if (branch == null) {
            return;
        }
        if (!Branch.bypassCurrentActivityIntentState()) {
            branch.onIntentReady(activity);
        }
        if (branch.getInitState() == Branch.SESSION_STATE.UNINITIALISED && !Branch.disableAutoSessionInitialization) {
            if (Branch.getPluginName() == null) {
                PrefHelper.Debug("initializing session on user's behalf (onActivityResumed called but SESSION_STATE = UNINITIALISED)");
                Branch.sessionBuilder((Activity)activity).init();
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("onActivityResumed called and SESSION_STATE = UNINITIALISED, however this is a ");
                stringBuilder2.append(Branch.getPluginName());
                stringBuilder2.append(" plugin, so we are NOT initializing session on user's behalf");
                PrefHelper.Debug(stringBuilder2.toString());
            }
        }
        this.activitiesOnStack_.add((Object)activity.toString());
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityStarted, activity = ");
        stringBuilder.append((Object)activity);
        PrefHelper.Debug(stringBuilder.toString());
        Branch branch = Branch.getInstance();
        if (branch == null) {
            return;
        }
        branch.currentActivityReference_ = new WeakReference((Object)activity);
        branch.setIntentState(Branch.INTENT_STATE.PENDING);
        this.activityCnt_ = 1 + this.activityCnt_;
        this.maybeRefreshAdvertisingID((Context)activity);
    }

    public void onActivityStopped(Activity activity) {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityStopped, activity = ");
        stringBuilder.append((Object)activity);
        PrefHelper.Debug(stringBuilder.toString());
        Branch branch = Branch.getInstance();
        if (branch == null) {
            return;
        }
        this.activityCnt_ = n = this.activityCnt_ - 1;
        if (n < 1) {
            branch.setInstantDeepLinkPossible(false);
            branch.closeSessionInternal();
        }
    }
}

