/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Void
 *  java.util.List
 *  java.util.Locale
 *  java.util.UUID
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import io.branch.referral.Defines;
import io.branch.referral.GAdsPrefetchTask;
import io.branch.referral.HuaweiOAIDFetchTask;
import io.branch.referral.PrefHelper;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

abstract class SystemObserver {
    static final String BLANK = "bnc_no_value";
    static final String UUID_EMPTY = "00000000-0000-0000-0000-000000000000";
    private String AIDInitializationSessionID_;
    private String GAIDString_ = null;
    private int LATVal_ = 0;

    SystemObserver() {
    }

    static int getAPILevel() {
        return Build.VERSION.SDK_INT;
    }

    static String getAppVersion(Context context) {
        String string2;
        block4 : {
            if (context != null) {
                try {
                    string2 = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionName;
                    break block4;
                }
                catch (Exception exception) {
                    PrefHelper.LogException("Error obtaining AppVersion", exception);
                }
            }
            string2 = "";
        }
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string2 = BLANK;
        }
        return string2;
    }

    static String getCPUType() {
        return System.getProperty((String)"os.arch");
    }

    static String getCarrier(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        String string2 = telephonyManager.getNetworkOperatorName();
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return null;
        }
        return string2;
    }

    static String getConnectionType(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager;
        if (context != null && context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && (connectivityManager = (ConnectivityManager)context.getSystemService("connectivity")) != null && (networkInfo = connectivityManager.getActiveNetworkInfo()) != null && networkInfo.isConnected()) {
            if (networkInfo.getType() == 1) {
                return "wifi";
            }
            return "mobile";
        }
        return null;
    }

    static String getDeviceBuildId() {
        return Build.DISPLAY;
    }

    static long getFirstInstallTime(Context context) {
        if (context != null) {
            try {
                long l = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).firstInstallTime;
                return l;
            }
            catch (Exception exception) {
                PrefHelper.LogException("Error obtaining FirstInstallTime", exception);
            }
        }
        return 0L;
    }

    static String getISO2CountryCode() {
        return Locale.getDefault().getCountry();
    }

    static String getISO2LanguageCode() {
        return Locale.getDefault().getLanguage();
    }

    static String getImei(Context context) {
        String string2 = PrefHelper.getInstance(context).getSecondaryRequestMetaData(Defines.ModuleNameKeys.imei.getKey());
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            return string2;
        }
        return null;
    }

    static long getLastUpdateTime(Context context) {
        if (context != null) {
            try {
                long l = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).lastUpdateTime;
                return l;
            }
            catch (Exception exception) {
                PrefHelper.LogException("Error obtaining LastUpdateTime", exception);
            }
        }
        return 0L;
    }

    /*
     * Exception decompiling
     */
    static String getLocalIPAddress() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl46.1 : ALOAD_0 : trying to set 1 previously set to 0
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

    static String getLocale() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Locale.getDefault().getLanguage());
        stringBuilder.append("_");
        stringBuilder.append(Locale.getDefault().getCountry());
        return stringBuilder.toString();
    }

    static String getOS(Context context) {
        if (SystemObserver.isFireOSDevice()) {
            if (context == null) {
                if (SystemObserver.getPhoneModel().contains((CharSequence)"AFT")) {
                    return "AMAZON_FIRE_TV";
                }
                return "AMAZON_FIRE";
            }
            if (context.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv")) {
                return "AMAZON_FIRE_TV";
            }
            return "AMAZON_FIRE";
        }
        return "Android";
    }

    static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    static String getPackageName(Context context) {
        if (context != null) {
            try {
                String string2 = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).packageName;
                return string2;
            }
            catch (Exception exception) {
                PrefHelper.LogException("Error obtaining PackageName", exception);
            }
        }
        return "";
    }

    static String getPhoneBrand() {
        return Build.MANUFACTURER;
    }

    static String getPhoneModel() {
        return Build.MODEL;
    }

    static DisplayMetrics getScreenDisplay(Context context) {
        WindowManager windowManager;
        Display display;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null && (windowManager = (WindowManager)context.getSystemService("window")) != null && (display = windowManager.getDefaultDisplay()) != null) {
            display.getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    /*
     * Exception decompiling
     */
    static String getUIMode(Context var0) {
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

    static UniqueId getUniqueID(Context context, boolean bl) {
        return new UniqueId(context, bl);
    }

    static boolean getWifiConnected(Context context) {
        return "wifi".equalsIgnoreCase(SystemObserver.getConnectionType(context));
    }

    static boolean isFireOSDevice() {
        return SystemObserver.getPhoneBrand().equalsIgnoreCase("amazon");
    }

    /*
     * Exception decompiling
     */
    static boolean isGooglePlayServicesAvailable(Context var0) {
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

    static boolean isHuaweiDevice() {
        return SystemObserver.getPhoneBrand().equalsIgnoreCase("huawei");
    }

    static boolean isHuaweiMobileServicesAvailable(Context context) {
        return SystemObserver.isHuaweiDevice() && !SystemObserver.isGooglePlayServicesAvailable(context);
    }

    static boolean isPackageInstalled(Context context) {
        if (context != null) {
            boolean bl;
            Intent intent;
            PackageManager packageManager;
            block4 : {
                packageManager = context.getPackageManager();
                intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                if (intent != null) break block4;
                return false;
            }
            try {
                bl = packageManager.queryIntentActivities(intent, 65536).isEmpty();
            }
            catch (Exception exception) {
                PrefHelper.LogException("Error obtaining PackageInfo", exception);
            }
            return bl ^ true;
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    private void setFireAdId(Context var1, AdsParamsFetchEvents var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl33.1 : ALOAD_2 : trying to set 1 previously set to 0
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

    String getAID() {
        return this.GAIDString_;
    }

    String getAIDInitializationSessionID() {
        return this.AIDInitializationSessionID_;
    }

    int getLATVal() {
        return this.LATVal_;
    }

    boolean prefetchAdsParams(Context context, AdsParamsFetchEvents adsParamsFetchEvents) {
        this.AIDInitializationSessionID_ = PrefHelper.getInstance(context).getSessionID();
        if (SystemObserver.isFireOSDevice()) {
            this.setFireAdId(context, adsParamsFetchEvents);
            return false;
        }
        if (SystemObserver.isHuaweiMobileServicesAvailable(context)) {
            new HuaweiOAIDFetchTask(context, adsParamsFetchEvents).executeTask((Params[])new Void[0]);
        } else {
            new GAdsPrefetchTask(context, adsParamsFetchEvents).executeTask((Params[])new Void[0]);
        }
        return true;
    }

    void setGAID(String string2) {
        this.GAIDString_ = string2;
    }

    void setLAT(int n) {
        this.LATVal_ = n;
    }

    static class UniqueId {
        private boolean isRealId;
        private String uniqueId;

        UniqueId(Context context, boolean bl) {
            this.isRealId = bl ^ true;
            this.uniqueId = SystemObserver.BLANK;
            String string2 = null;
            if (context != null) {
                string2 = null;
                if (!bl) {
                    string2 = Settings.Secure.getString((ContentResolver)context.getContentResolver(), (String)"android_id");
                }
            }
            if (string2 == null) {
                string2 = UUID.randomUUID().toString();
                this.isRealId = false;
            }
            this.uniqueId = string2;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (this.getClass() != object.getClass()) {
                return false;
            }
            UniqueId uniqueId = (UniqueId)object;
            return this.uniqueId.equals((Object)uniqueId.uniqueId) && this.isRealId == uniqueId.isRealId;
        }

        String getId() {
            return this.uniqueId;
        }

        public int hashCode() {
            int n = 31 * (1 + this.isRealId);
            String string2 = this.uniqueId;
            int n2 = string2 == null ? 0 : string2.hashCode();
            return n + n2;
        }

        boolean isReal() {
            return this.isRealId;
        }
    }

}

