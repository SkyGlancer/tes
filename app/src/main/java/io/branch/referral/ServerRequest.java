/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.branch.referral.Branch
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.DeviceInfo;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerRequestActionCompleted;
import io.branch.referral.ServerRequestCreateUrl;
import io.branch.referral.ServerRequestGetRewardHistory;
import io.branch.referral.ServerRequestGetRewards;
import io.branch.referral.ServerRequestIdentifyUserRequest;
import io.branch.referral.ServerRequestInitSession;
import io.branch.referral.ServerRequestLogout;
import io.branch.referral.ServerRequestRedeemRewards;
import io.branch.referral.ServerRequestRegisterClose;
import io.branch.referral.ServerRequestRegisterInstall;
import io.branch.referral.ServerRequestRegisterOpen;
import io.branch.referral.ServerResponse;
import io.branch.referral.SystemObserver;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ServerRequest {
    private static final String POST_KEY = "REQ_POST";
    private static final String POST_PATH_KEY = "REQ_POST_PATH";
    private static final String[] initializationAndEventRoutes;
    public boolean constructError_ = false;
    private final Context context_;
    private final Set<PROCESS_WAIT_LOCK> locks_;
    private JSONObject params_;
    protected final PrefHelper prefHelper_;
    private long queueWaitTime_ = 0L;
    private String requestPath_;
    boolean skipOnTimeOut = false;

    static {
        String[] arrstring = new String[]{Defines.RequestPath.RegisterInstall.getPath(), Defines.RequestPath.RegisterOpen.getPath(), Defines.RequestPath.CompletedAction.getPath(), Defines.RequestPath.ContentEvent.getPath(), Defines.RequestPath.TrackStandardEvent.getPath(), Defines.RequestPath.TrackCustomEvent.getPath()};
        initializationAndEventRoutes = arrstring;
    }

    public ServerRequest(Context context, String string2) {
        this.context_ = context;
        this.requestPath_ = string2;
        this.prefHelper_ = PrefHelper.getInstance(context);
        this.params_ = new JSONObject();
        this.locks_ = new HashSet();
    }

    protected ServerRequest(String string2, JSONObject jSONObject, Context context) {
        this.context_ = context;
        this.requestPath_ = string2;
        this.params_ = jSONObject;
        this.prefHelper_ = PrefHelper.getInstance(context);
        this.locks_ = new HashSet();
    }

    /*
     * Exception decompiling
     */
    public static ServerRequest fromJSON(JSONObject var0, Context var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl25.1 : ALOAD_2 : trying to set 1 previously set to 0
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

    private static ServerRequest getExtendedServerRequest(String string2, JSONObject jSONObject, Context context) {
        if (string2.equalsIgnoreCase(Defines.RequestPath.CompletedAction.getPath())) {
            return new ServerRequestActionCompleted(string2, jSONObject, context);
        }
        if (string2.equalsIgnoreCase(Defines.RequestPath.GetURL.getPath())) {
            return new ServerRequestCreateUrl(string2, jSONObject, context);
        }
        if (string2.equalsIgnoreCase(Defines.RequestPath.GetCreditHistory.getPath())) {
            return new ServerRequestGetRewardHistory(string2, jSONObject, context);
        }
        if (string2.equalsIgnoreCase(Defines.RequestPath.GetCredits.getPath())) {
            return new ServerRequestGetRewards(string2, jSONObject, context);
        }
        if (string2.equalsIgnoreCase(Defines.RequestPath.IdentifyUser.getPath())) {
            return new ServerRequestIdentifyUserRequest(string2, jSONObject, context);
        }
        if (string2.equalsIgnoreCase(Defines.RequestPath.Logout.getPath())) {
            return new ServerRequestLogout(string2, jSONObject, context);
        }
        if (string2.equalsIgnoreCase(Defines.RequestPath.RedeemRewards.getPath())) {
            return new ServerRequestRedeemRewards(string2, jSONObject, context);
        }
        if (string2.equalsIgnoreCase(Defines.RequestPath.RegisterClose.getPath())) {
            return new ServerRequestRegisterClose(string2, jSONObject, context);
        }
        if (string2.equalsIgnoreCase(Defines.RequestPath.RegisterInstall.getPath())) {
            return new ServerRequestRegisterInstall(string2, jSONObject, context);
        }
        if (string2.equalsIgnoreCase(Defines.RequestPath.RegisterOpen.getPath())) {
            return new ServerRequestRegisterOpen(string2, jSONObject, context);
        }
        return null;
    }

    private boolean payloadContainsDeviceIdentifiers(JSONObject jSONObject) {
        return jSONObject.has(Defines.Jsonkey.AndroidID.getKey()) || jSONObject.has(Defines.Jsonkey.DeviceFingerprintID.getKey()) || jSONObject.has(Defines.ModuleNameKeys.imei.getKey());
        {
        }
    }

    private void updateAdvertisingIdsObject(String string2) {
        try {
            String string3 = SystemObserver.isFireOSDevice() ? Defines.Jsonkey.FireAdId.getKey() : (SystemObserver.isHuaweiMobileServicesAvailable(Branch.getInstance().getApplicationContext()) ? Defines.Jsonkey.OpenAdvertisingID.getKey() : Defines.Jsonkey.AAID.getKey());
            JSONObject jSONObject = new JSONObject().put(string3, (Object)string2);
            this.params_.put(Defines.Jsonkey.AdvertisingIDs.getKey(), (Object)jSONObject);
        }
        catch (JSONException jSONException) {}
    }

    /*
     * Exception decompiling
     */
    private void updateDeviceInfo() {
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

    /*
     * Exception decompiling
     */
    private void updateDisableAdNetworkCallouts() {
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

    /*
     * Exception decompiling
     */
    private void updateGAdsParams() {
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

    /*
     * Exception decompiling
     */
    private void updateLimitFacebookTracking() {
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void updateRequestMetadata() {
        try {
            JSONObject jSONObject = new JSONObject();
            Iterator iterator = this.prefHelper_.getRequestMetadata().keys();
            while (iterator.hasNext()) {
                String string2 = (String)iterator.next();
                jSONObject.put(string2, this.prefHelper_.getRequestMetadata().get(string2));
            }
            JSONObject jSONObject2 = this.params_.optJSONObject(Defines.Jsonkey.Metadata.getKey());
            if (jSONObject2 != null) {
                Iterator iterator2 = jSONObject2.keys();
                while (iterator2.hasNext()) {
                    String string3 = (String)iterator2.next();
                    jSONObject.put(string3, jSONObject2.get(string3));
                }
            }
            if (this instanceof ServerRequestRegisterInstall && this.prefHelper_.getInstallMetadata().length() > 0) {
                Iterator iterator3 = this.prefHelper_.getInstallMetadata().keys();
                while (iterator3.hasNext()) {
                    String string4 = (String)iterator3.next();
                    this.params_.putOpt(string4, this.prefHelper_.getInstallMetadata().get(string4));
                }
            }
            this.params_.put(Defines.Jsonkey.Metadata.getKey(), (Object)jSONObject);
            return;
        }
        catch (JSONException jSONException) {
            PrefHelper.Debug("Could not merge metadata, ignoring user metadata.");
            return;
        }
    }

    protected void addGetParam(String string2, String string3) {
        try {
            this.params_.put(string2, (Object)string3);
        }
        catch (JSONException jSONException) {}
    }

    public void addProcessWaitLock(PROCESS_WAIT_LOCK pROCESS_WAIT_LOCK) {
        if (pROCESS_WAIT_LOCK != null) {
            this.locks_.add((Object)pROCESS_WAIT_LOCK);
        }
    }

    public abstract void clearCallbacks();

    void doFinalUpdateOnBackgroundThread() {
        if (this instanceof ServerRequestInitSession) {
            ((ServerRequestInitSession)this).updateLinkReferrerParams();
        }
        this.updateDeviceInfo();
        this.updateDisableAdNetworkCallouts();
        if (this.isGAdsParamsRequired()) {
            this.updateGAdsParams();
        }
    }

    void doFinalUpdateOnMainThread() {
        this.updateRequestMetadata();
        if (this.shouldUpdateLimitFacebookTracking()) {
            this.updateLimitFacebookTracking();
        }
    }

    protected boolean doesAppHasInternetPermission(Context context) {
        int n = context.checkCallingOrSelfPermission("android.permission.INTERNET");
        boolean bl = n == 0;
        if (!bl) {
            PrefHelper.Debug("Trouble executing your request. Please add 'android.permission.INTERNET' in your applications manifest file");
        }
        return n == 0;
    }

    public BRANCH_API_VERSION getBranchRemoteAPIVersion() {
        return BRANCH_API_VERSION.V1;
    }

    public JSONObject getGetParams() {
        return this.params_;
    }

    public JSONObject getPost() {
        return this.params_;
    }

    /*
     * Exception decompiling
     */
    public JSONObject getPostWithInstrumentationValues(ConcurrentHashMap<String, String> var1) {
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

    public long getQueueWaitTime() {
        long l = this.queueWaitTime_;
        long l2 = 0L;
        if (l > l2) {
            l2 = System.currentTimeMillis() - this.queueWaitTime_;
        }
        return l2;
    }

    public final String getRequestPath() {
        return this.requestPath_;
    }

    public String getRequestUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.prefHelper_.getAPIBaseUrl());
        stringBuilder.append(this.requestPath_);
        return stringBuilder.toString();
    }

    public abstract boolean handleErrors(Context var1);

    public abstract void handleFailure(int var1, String var2);

    public boolean isGAdsParamsRequired() {
        return true;
    }

    public abstract boolean isGetRequest();

    boolean isInitializationOrEventRequest() {
        String[] arrstring = initializationAndEventRoutes;
        int n = arrstring.length;
        for (int i = 0; i < n; ++i) {
            if (!arrstring[i].equals((Object)this.requestPath_)) continue;
            return true;
        }
        return false;
    }

    boolean isPersistable() {
        return true;
    }

    public boolean isWaitingOnProcessToFinish() {
        return this.locks_.size() > 0;
    }

    public void onPreExecute() {
    }

    public void onRequestQueued() {
        this.queueWaitTime_ = System.currentTimeMillis();
    }

    public abstract void onRequestSucceeded(ServerResponse var1, Branch var2);

    protected boolean prepareExecuteWithoutTracking() {
        return false;
    }

    public void removeProcessWaitLock(PROCESS_WAIT_LOCK pROCESS_WAIT_LOCK) {
        this.locks_.remove((Object)((Object)pROCESS_WAIT_LOCK));
    }

    public void reportTrackingDisabledError() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Requested operation cannot be completed since tracking is disabled [");
        stringBuilder.append(this.requestPath_);
        stringBuilder.append("]");
        PrefHelper.Debug(stringBuilder.toString());
        this.handleFailure(-117, "");
    }

    protected void setPost(JSONObject jSONObject) throws JSONException {
        this.params_ = jSONObject;
        if (this.getBranchRemoteAPIVersion() == BRANCH_API_VERSION.V1) {
            DeviceInfo.getInstance().updateRequestWithV1Params(this, this.params_);
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            this.params_.put(Defines.Jsonkey.UserData.getKey(), (Object)jSONObject2);
            DeviceInfo.getInstance().updateRequestWithV2Params(this, this.context_, this.prefHelper_, jSONObject2);
        }
        catch (JSONException jSONException) {}
    }

    public boolean shouldRetryOnFail() {
        return false;
    }

    protected boolean shouldUpdateLimitFacebookTracking() {
        return false;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("REQ_POST", (Object)this.params_);
            jSONObject.put("REQ_POST_PATH", (Object)this.requestPath_);
            return jSONObject;
        }
        catch (JSONException jSONException) {
            return null;
        }
    }

    /*
     * Exception decompiling
     */
    protected void updateEnvironment(Context var1, JSONObject var2) {
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

    public static final class BRANCH_API_VERSION
    extends Enum<BRANCH_API_VERSION> {
        private static final /* synthetic */ BRANCH_API_VERSION[] $VALUES;
        public static final /* enum */ BRANCH_API_VERSION V1;
        public static final /* enum */ BRANCH_API_VERSION V1_CPID;
        public static final /* enum */ BRANCH_API_VERSION V1_LATD;
        public static final /* enum */ BRANCH_API_VERSION V2;

        static {
            BRANCH_API_VERSION bRANCH_API_VERSION;
            V1 = new BRANCH_API_VERSION();
            V1_CPID = new BRANCH_API_VERSION();
            V1_LATD = new BRANCH_API_VERSION();
            V2 = bRANCH_API_VERSION = new BRANCH_API_VERSION();
            BRANCH_API_VERSION[] arrbRANCH_API_VERSION = new BRANCH_API_VERSION[]{V1, V1_CPID, V1_LATD, bRANCH_API_VERSION};
            $VALUES = arrbRANCH_API_VERSION;
        }

        public static BRANCH_API_VERSION valueOf(String string2) {
            return (BRANCH_API_VERSION)Enum.valueOf(BRANCH_API_VERSION.class, (String)string2);
        }

        public static BRANCH_API_VERSION[] values() {
            return (BRANCH_API_VERSION[])$VALUES.clone();
        }
    }

    static final class PROCESS_WAIT_LOCK
    extends Enum<PROCESS_WAIT_LOCK> {
        private static final /* synthetic */ PROCESS_WAIT_LOCK[] $VALUES;
        public static final /* enum */ PROCESS_WAIT_LOCK FB_APP_LINK_WAIT_LOCK;
        public static final /* enum */ PROCESS_WAIT_LOCK GAID_FETCH_WAIT_LOCK;
        public static final /* enum */ PROCESS_WAIT_LOCK INSTALL_REFERRER_FETCH_WAIT_LOCK;
        public static final /* enum */ PROCESS_WAIT_LOCK INTENT_PENDING_WAIT_LOCK;
        public static final /* enum */ PROCESS_WAIT_LOCK SDK_INIT_WAIT_LOCK;
        public static final /* enum */ PROCESS_WAIT_LOCK STRONG_MATCH_PENDING_WAIT_LOCK;
        public static final /* enum */ PROCESS_WAIT_LOCK USER_SET_WAIT_LOCK;

        static {
            PROCESS_WAIT_LOCK pROCESS_WAIT_LOCK;
            SDK_INIT_WAIT_LOCK = new PROCESS_WAIT_LOCK();
            FB_APP_LINK_WAIT_LOCK = new PROCESS_WAIT_LOCK();
            GAID_FETCH_WAIT_LOCK = new PROCESS_WAIT_LOCK();
            INTENT_PENDING_WAIT_LOCK = new PROCESS_WAIT_LOCK();
            STRONG_MATCH_PENDING_WAIT_LOCK = new PROCESS_WAIT_LOCK();
            INSTALL_REFERRER_FETCH_WAIT_LOCK = new PROCESS_WAIT_LOCK();
            USER_SET_WAIT_LOCK = pROCESS_WAIT_LOCK = new PROCESS_WAIT_LOCK();
            PROCESS_WAIT_LOCK[] arrpROCESS_WAIT_LOCK = new PROCESS_WAIT_LOCK[]{SDK_INIT_WAIT_LOCK, FB_APP_LINK_WAIT_LOCK, GAID_FETCH_WAIT_LOCK, INTENT_PENDING_WAIT_LOCK, STRONG_MATCH_PENDING_WAIT_LOCK, INSTALL_REFERRER_FETCH_WAIT_LOCK, pROCESS_WAIT_LOCK};
            $VALUES = arrpROCESS_WAIT_LOCK;
        }

        public static PROCESS_WAIT_LOCK valueOf(String string2) {
            return (PROCESS_WAIT_LOCK)Enum.valueOf(PROCESS_WAIT_LOCK.class, (String)string2);
        }

        public static PROCESS_WAIT_LOCK[] values() {
            return (PROCESS_WAIT_LOCK[])$VALUES.clone();
        }
    }

}

