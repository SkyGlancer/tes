/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Method
 *  java.util.List
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import io.branch.referral.BranchUtil;
import io.branch.referral.Defines;
import io.branch.referral.DeviceInfo;
import io.branch.referral.PrefHelper;
import io.branch.referral.SystemObserver;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

class BranchStrongMatchHelper {
    private static final int STRONG_MATCH_CHECK_TIME_OUT = 500;
    private static final int STRONG_MATCH_URL_HIT_DELAY = 750;
    private static int StrongMatchUrlHitDelay = 750;
    private static final long THIRTY_DAYS_EPOCH_MILLI_SEC = 2592000000L;
    private static BranchStrongMatchHelper branchStrongMatchHelper_;
    private Class<?> CustomTabsCallbackClass;
    private Class<?> CustomTabsClientClass;
    private Class<?> CustomTabsSessionClass;
    private Class<?> ICustomTabsServiceClass;
    private boolean isCustomTabsAvailable_;
    private boolean isStrongMatchUrlLaunched;
    private Object mClient_;
    private final Handler timeOutHandler_;

    /*
     * Exception decompiling
     */
    private BranchStrongMatchHelper() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl32 : ALOAD_0 : trying to set 1 previously set to 0
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

    static /* synthetic */ boolean access$002(BranchStrongMatchHelper branchStrongMatchHelper, boolean bl) {
        branchStrongMatchHelper.isStrongMatchUrlLaunched = bl;
        return bl;
    }

    static /* synthetic */ Object access$200(BranchStrongMatchHelper branchStrongMatchHelper) {
        return branchStrongMatchHelper.mClient_;
    }

    private Uri buildStrongMatchUrl(String string2, DeviceInfo deviceInfo, PrefHelper prefHelper, Context context) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://");
            stringBuilder.append(string2);
            stringBuilder.append("/_strong_match?os=");
            stringBuilder.append(deviceInfo.getOsName());
            String string3 = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string3);
            stringBuilder2.append("&");
            stringBuilder2.append(Defines.Jsonkey.HardwareID.getKey());
            stringBuilder2.append("=");
            stringBuilder2.append((Object)deviceInfo.getHardwareID());
            String string4 = stringBuilder2.toString();
            Defines.Jsonkey jsonkey = deviceInfo.getHardwareID().isReal() ? Defines.Jsonkey.HardwareIDTypeVendor : Defines.Jsonkey.HardwareIDTypeRandom;
            String string5 = jsonkey.getKey();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string4);
            stringBuilder3.append("&");
            stringBuilder3.append(Defines.Jsonkey.HardwareIDType.getKey());
            stringBuilder3.append("=");
            stringBuilder3.append(string5);
            String string6 = stringBuilder3.toString();
            String string7 = deviceInfo.getSystemObserver().getAID();
            if (string7 != null && !BranchUtil.checkTestMode(context)) {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(string6);
                stringBuilder4.append("&");
                stringBuilder4.append(Defines.Jsonkey.GoogleAdvertisingID.getKey());
                stringBuilder4.append("=");
                stringBuilder4.append(string7);
                string6 = stringBuilder4.toString();
            }
            if (!prefHelper.getDeviceFingerPrintID().equals((Object)"bnc_no_value")) {
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append(string6);
                stringBuilder5.append("&");
                stringBuilder5.append(Defines.Jsonkey.DeviceFingerprintID.getKey());
                stringBuilder5.append("=");
                stringBuilder5.append(prefHelper.getDeviceFingerPrintID());
                string6 = stringBuilder5.toString();
            }
            if (!deviceInfo.getAppVersion().equals((Object)"bnc_no_value")) {
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append(string6);
                stringBuilder6.append("&");
                stringBuilder6.append(Defines.Jsonkey.AppVersion.getKey());
                stringBuilder6.append("=");
                stringBuilder6.append(deviceInfo.getAppVersion());
                string6 = stringBuilder6.toString();
            }
            if (prefHelper.hasValidBranchKey()) {
                StringBuilder stringBuilder7 = new StringBuilder();
                stringBuilder7.append(string6);
                stringBuilder7.append("&");
                stringBuilder7.append(Defines.Jsonkey.BranchKey.getKey());
                stringBuilder7.append("=");
                stringBuilder7.append(prefHelper.getBranchKey());
                string6 = stringBuilder7.toString();
            }
            StringBuilder stringBuilder8 = new StringBuilder();
            stringBuilder8.append(string6);
            stringBuilder8.append("&sdk=android5.0.2");
            return Uri.parse((String)stringBuilder8.toString());
        }
        return null;
    }

    public static BranchStrongMatchHelper getInstance() {
        if (branchStrongMatchHelper_ == null) {
            branchStrongMatchHelper_ = new BranchStrongMatchHelper();
        }
        return branchStrongMatchHelper_;
    }

    private void updateStrongMatchCheckFinished(final StrongMatchCheckEvents strongMatchCheckEvents, boolean bl) {
        if (strongMatchCheckEvents != null) {
            if (bl) {
                new Handler().postDelayed(new Runnable(){

                    public void run() {
                        strongMatchCheckEvents.onStrongMatchCheckFinished();
                    }
                }, (long)StrongMatchUrlHitDelay);
                return;
            }
            strongMatchCheckEvents.onStrongMatchCheckFinished();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void checkForStrongMatch(Context context, String string2, DeviceInfo deviceInfo, final PrefHelper prefHelper, final StrongMatchCheckEvents strongMatchCheckEvents) {
        this.isStrongMatchUrlLaunched = false;
        if (System.currentTimeMillis() - prefHelper.getLastStrongMatchTime() < 2592000000L) {
            this.updateStrongMatchCheckFinished(strongMatchCheckEvents, this.isStrongMatchUrlLaunched);
            return;
        }
        if (!this.isCustomTabsAvailable_) {
            this.updateStrongMatchCheckFinished(strongMatchCheckEvents, this.isStrongMatchUrlLaunched);
            return;
        }
        try {
            if (deviceInfo.getHardwareID() == null) {
                this.updateStrongMatchCheckFinished(strongMatchCheckEvents, this.isStrongMatchUrlLaunched);
                PrefHelper.Debug("Cannot use cookie-based matching since device id is not available");
                return;
            }
            final Uri uri = this.buildStrongMatchUrl(string2, deviceInfo, prefHelper, context);
            if (uri != null) {
                this.timeOutHandler_.postDelayed(new Runnable(){

                    public void run() {
                        BranchStrongMatchHelper branchStrongMatchHelper = BranchStrongMatchHelper.this;
                        branchStrongMatchHelper.updateStrongMatchCheckFinished(strongMatchCheckEvents, branchStrongMatchHelper.isStrongMatchUrlLaunched);
                    }
                }, 500L);
                Class<?> class_ = this.CustomTabsClientClass;
                Class[] arrclass = new Class[]{Long.TYPE};
                final Method method = class_.getMethod("warmup", arrclass);
                Class<?> class_2 = this.CustomTabsClientClass;
                Class[] arrclass2 = new Class[]{this.CustomTabsCallbackClass};
                final Method method2 = class_2.getMethod("newSession", arrclass2);
                final Method method3 = this.CustomTabsSessionClass.getMethod("mayLaunchUrl", new Class[]{Uri.class, Bundle.class, List.class});
                Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
                intent.setPackage("com.android.chrome");
                MockCustomTabServiceConnection mockCustomTabServiceConnection = new MockCustomTabServiceConnection(){

                    /*
                     * Exception decompiling
                     */
                    @Override
                    public void onCustomTabsServiceConnected(ComponentName var1, Object var2) {
                        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl114 : RETURN : trying to set 1 previously set to 0
                        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                        // org.benf.cfr.reader.entities.g.p(Method.java:396)
                        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                        // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                        // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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

                    public void onServiceDisconnected(ComponentName componentName) {
                        BranchStrongMatchHelper.this.mClient_ = null;
                        BranchStrongMatchHelper branchStrongMatchHelper = BranchStrongMatchHelper.this;
                        branchStrongMatchHelper.updateStrongMatchCheckFinished(strongMatchCheckEvents, branchStrongMatchHelper.isStrongMatchUrlLaunched);
                    }
                };
                context.bindService(intent, (ServiceConnection)mockCustomTabServiceConnection, 33);
                return;
            }
            this.updateStrongMatchCheckFinished(strongMatchCheckEvents, this.isStrongMatchUrlLaunched);
            return;
        }
        catch (Throwable throwable) {
            this.updateStrongMatchCheckFinished(strongMatchCheckEvents, this.isStrongMatchUrlLaunched);
            return;
        }
    }

    void setStrongMatchUrlHitDelay(int n) {
        StrongMatchUrlHitDelay = n;
    }

    private abstract class MockCustomTabServiceConnection
    implements ServiceConnection {
        MockCustomTabServiceConnection() {
        }

        public abstract void onCustomTabsServiceConnected(ComponentName var1, Object var2);

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Class class_ = BranchStrongMatchHelper.this.CustomTabsClientClass;
                Class[] arrclass = new Class[]{BranchStrongMatchHelper.this.ICustomTabsServiceClass, ComponentName.class};
                Constructor constructor = class_.getDeclaredConstructor(arrclass);
                constructor.setAccessible(true);
                Method method = Class.forName((String)"android.support.customtabs.ICustomTabsService$Stub").getMethod("asInterface", new Class[]{IBinder.class});
                Object[] arrobject = new Object[]{method.invoke(null, new Object[]{iBinder}), componentName};
                this.onCustomTabsServiceConnected(componentName, constructor.newInstance(arrobject));
                return;
            }
            catch (Throwable throwable) {
                this.onCustomTabsServiceConnected(null, null);
                return;
            }
        }
    }

    static interface StrongMatchCheckEvents {
        public void onStrongMatchCheckFinished();
    }

}

