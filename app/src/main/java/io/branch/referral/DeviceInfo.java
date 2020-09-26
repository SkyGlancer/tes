/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.UiModeManager
 *  android.content.Context
 *  android.text.TextUtils
 *  io.branch.referral.Branch
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import android.app.UiModeManager;
import android.content.Context;
import android.text.TextUtils;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerRequest;
import io.branch.referral.SystemObserver;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceInfo {
    private static DeviceInfo thisInstance_;
    private final Context context_;
    private final SystemObserver systemObserver_;

    private DeviceInfo(Context context) {
        this.context_ = context;
        this.systemObserver_ = new SystemObserverInstance();
    }

    /*
     * Exception decompiling
     */
    private String getDefaultBrowserAgent(Context var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl9.1 : LDC : trying to set 0 previously set to 1
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

    static DeviceInfo getInstance() {
        return thisInstance_;
    }

    static DeviceInfo initialize(Context context) {
        if (thisInstance_ == null) {
            thisInstance_ = new DeviceInfo(context);
        }
        return thisInstance_;
    }

    public static boolean isNullOrEmptyOrBlank(String string2) {
        return TextUtils.isEmpty((CharSequence)string2) || string2.equals((Object)"bnc_no_value");
        {
        }
    }

    private void maybeAddTuneFields(ServerRequest serverRequest, JSONObject jSONObject) throws JSONException {
        if (serverRequest.isInitializationOrEventRequest()) {
            jSONObject.put(Defines.Jsonkey.CPUType.getKey(), (Object)SystemObserver.getCPUType());
            jSONObject.put(Defines.Jsonkey.DeviceBuildId.getKey(), (Object)SystemObserver.getDeviceBuildId());
            jSONObject.put(Defines.Jsonkey.Locale.getKey(), (Object)SystemObserver.getLocale());
            jSONObject.put(Defines.Jsonkey.ConnectionType.getKey(), (Object)SystemObserver.getConnectionType(this.context_));
            jSONObject.put(Defines.Jsonkey.DeviceCarrier.getKey(), (Object)SystemObserver.getCarrier(this.context_));
            jSONObject.put(Defines.Jsonkey.OSVersionAndroid.getKey(), (Object)SystemObserver.getOSVersion());
        }
    }

    static void shutDown() {
        thisInstance_ = null;
    }

    public String getAppVersion() {
        return SystemObserver.getAppVersion(this.context_);
    }

    public long getFirstInstallTime() {
        return SystemObserver.getFirstInstallTime(this.context_);
    }

    public SystemObserver.UniqueId getHardwareID() {
        this.getSystemObserver();
        return SystemObserver.getUniqueID(this.context_, Branch.isDeviceIDFetchDisabled());
    }

    public long getLastUpdateTime() {
        return SystemObserver.getLastUpdateTime(this.context_);
    }

    public String getOsName() {
        return SystemObserver.getOS(this.context_);
    }

    public String getPackageName() {
        return SystemObserver.getPackageName(this.context_);
    }

    SystemObserver getSystemObserver() {
        return this.systemObserver_;
    }

    public boolean isPackageInstalled() {
        return SystemObserver.isPackageInstalled(this.context_);
    }

    boolean isTV() {
        UiModeManager uiModeManager = (UiModeManager)this.context_.getSystemService("uimode");
        if (uiModeManager == null) {
            PrefHelper.Debug("uiModeManager is null, mark this as a non-TV device by default.");
            return false;
        }
        int n = uiModeManager.getCurrentModeType();
        boolean bl = false;
        if (n == 4) {
            bl = true;
        }
        return bl;
    }

    /*
     * Exception decompiling
     */
    void updateRequestWithV1Params(ServerRequest var1, JSONObject var2) {
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
    void updateRequestWithV2Params(ServerRequest var1, Context var2, PrefHelper var3, JSONObject var4) {
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

    private class SystemObserverInstance
    extends SystemObserver {
    }

}

