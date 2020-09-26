/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.text.TextUtils
 *  io.branch.referral.Branch
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.DeviceInfo;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerResponse;
import io.branch.referral.validators.DeepLinkRoutingValidator;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

abstract class ServerRequestInitSession
extends ServerRequest {
    static final String ACTION_INSTALL = "install";
    static final String ACTION_OPEN = "open";
    private static final int STATE_FRESH_INSTALL = 0;
    private static final int STATE_NO_CHANGE = 1;
    private static final int STATE_TUNE_MIGRATION = 5;
    private static final int STATE_UPDATE = 2;
    private final Context context_;

    ServerRequestInitSession(Context context, String string2) {
        super(context, string2);
        this.context_ = context;
    }

    ServerRequestInitSession(String string2, JSONObject jSONObject, Context context) {
        super(string2, jSONObject, context);
        this.context_ = context;
    }

    static boolean isInitSessionAction(String string2) {
        boolean bl;
        block2 : {
            block3 : {
                bl = false;
                if (string2 == null) break block2;
                if (string2.equalsIgnoreCase(ACTION_OPEN)) break block3;
                boolean bl2 = string2.equalsIgnoreCase(ACTION_INSTALL);
                bl = false;
                if (!bl2) break block2;
            }
            bl = true;
        }
        return bl;
    }

    private boolean isTuneMigration() {
        return true ^ TextUtils.isEmpty((CharSequence)this.context_.getApplicationContext().getSharedPreferences("com.mobileapptracking", 0).getString("mat_id", null));
    }

    private void updateInstallStateAndTimestamps(JSONObject jSONObject) throws JSONException {
        String string2 = DeviceInfo.getInstance().getAppVersion();
        long l = DeviceInfo.getInstance().getFirstInstallTime();
        long l2 = DeviceInfo.getInstance().getLastUpdateTime();
        boolean bl = "bnc_no_value".equals((Object)this.prefHelper_.getAppVersion());
        int n = 2;
        if (bl) {
            if (l2 - l < 86400000L) {
                n = 0;
            }
            if (this.isTuneMigration()) {
                n = 5;
            }
        } else if (this.prefHelper_.getAppVersion().equals((Object)string2)) {
            n = 1;
        }
        jSONObject.put(Defines.Jsonkey.Update.getKey(), n);
        jSONObject.put(Defines.Jsonkey.FirstInstallTime.getKey(), l);
        jSONObject.put(Defines.Jsonkey.LastUpdateTime.getKey(), l2);
        long l3 = this.prefHelper_.getLong("bnc_original_install_time");
        if (l3 == 0L) {
            this.prefHelper_.setLong("bnc_original_install_time", l);
        } else {
            l = l3;
        }
        jSONObject.put(Defines.Jsonkey.OriginalInstallTime.getKey(), l);
        long l4 = this.prefHelper_.getLong("bnc_last_known_update_time");
        if (l4 < l2) {
            this.prefHelper_.setLong("bnc_previous_update_time", l4);
            this.prefHelper_.setLong("bnc_last_known_update_time", l2);
        }
        jSONObject.put(Defines.Jsonkey.PreviousUpdateTime.getKey(), this.prefHelper_.getLong("bnc_previous_update_time"));
    }

    public abstract String getRequestActionName();

    /*
     * Exception decompiling
     */
    boolean handleBranchViewIfAvailable(ServerResponse var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl61.1 : ICONST_0 : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    void onInitSessionCompleted(ServerResponse serverResponse, Branch branch) {
        DeepLinkRoutingValidator.validate((WeakReference<Activity>)branch.currentActivityReference_);
        branch.updateSkipURLFormats();
    }

    /*
     * Exception decompiling
     */
    @Override
    public void onPreExecute() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        Branch.getInstance().unlockSDKInitWaitLock();
        this.prefHelper_.setLinkClickIdentifier("bnc_no_value");
        this.prefHelper_.setGoogleSearchInstallIdentifier("bnc_no_value");
        this.prefHelper_.setGooglePlayReferrer("bnc_no_value");
        this.prefHelper_.setExternalIntentUri("bnc_no_value");
        this.prefHelper_.setExternalIntentExtra("bnc_no_value");
        this.prefHelper_.setAppLink("bnc_no_value");
        this.prefHelper_.setPushIdentifier("bnc_no_value");
        this.prefHelper_.setIsAppLinkTriggeredInit(false);
        this.prefHelper_.setInstallReferrerParams("bnc_no_value");
        this.prefHelper_.setIsFullAppConversion(false);
        if (this.prefHelper_.getLong("bnc_previous_update_time") == 0L) {
            this.prefHelper_.setLong("bnc_previous_update_time", this.prefHelper_.getLong("bnc_last_known_update_time"));
        }
    }

    @Override
    protected boolean prepareExecuteWithoutTracking() {
        JSONObject jSONObject = this.getPost();
        if (!(jSONObject.has(Defines.Jsonkey.AndroidAppLinkURL.getKey()) || jSONObject.has(Defines.Jsonkey.AndroidPushIdentifier.getKey()) || jSONObject.has(Defines.Jsonkey.LinkIdentifier.getKey()))) {
            return super.prepareExecuteWithoutTracking();
        }
        jSONObject.remove(Defines.Jsonkey.DeviceFingerprintID.getKey());
        jSONObject.remove(Defines.Jsonkey.IdentityID.getKey());
        jSONObject.remove(Defines.Jsonkey.FaceBookAppLinkChecked.getKey());
        jSONObject.remove(Defines.Jsonkey.External_Intent_Extra.getKey());
        jSONObject.remove(Defines.Jsonkey.External_Intent_URI.getKey());
        jSONObject.remove(Defines.Jsonkey.FirstInstallTime.getKey());
        jSONObject.remove(Defines.Jsonkey.LastUpdateTime.getKey());
        jSONObject.remove(Defines.Jsonkey.OriginalInstallTime.getKey());
        jSONObject.remove(Defines.Jsonkey.PreviousUpdateTime.getKey());
        jSONObject.remove(Defines.Jsonkey.InstallBeginTimeStamp.getKey());
        jSONObject.remove(Defines.Jsonkey.ClickedReferrerTimeStamp.getKey());
        jSONObject.remove(Defines.Jsonkey.HardwareID.getKey());
        jSONObject.remove(Defines.Jsonkey.IsHardwareIDReal.getKey());
        jSONObject.remove(Defines.Jsonkey.LocalIP.getKey());
        try {
            jSONObject.put(Defines.Jsonkey.TrackingDisabled.getKey(), true);
        }
        catch (JSONException jSONException) {}
        return true;
    }

    @Override
    protected void setPost(JSONObject jSONObject) throws JSONException {
        super.setPost(jSONObject);
        String string2 = DeviceInfo.getInstance().getAppVersion();
        if (!DeviceInfo.isNullOrEmptyOrBlank(string2)) {
            jSONObject.put(Defines.Jsonkey.AppVersion.getKey(), (Object)string2);
        }
        jSONObject.put(Defines.Jsonkey.FaceBookAppLinkChecked.getKey(), this.prefHelper_.getIsAppLinkTriggeredInit());
        jSONObject.put(Defines.Jsonkey.IsReferrable.getKey(), this.prefHelper_.getIsReferrable());
        jSONObject.put(Defines.Jsonkey.Debug.getKey(), Branch.isDeviceIDFetchDisabled());
        this.updateInstallStateAndTimestamps(jSONObject);
        this.updateEnvironment(this.context_, jSONObject);
    }

    @Override
    protected boolean shouldUpdateLimitFacebookTracking() {
        return true;
    }

    /*
     * Exception decompiling
     */
    void updateLinkReferrerParams() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }
}

