/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package app.dukhaan.src.java.io.branch.referral;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import io.branch.referral.PrefHelper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class InstantAppUtil {
    private static Boolean isInstantApp;
    private static Context lastApplicationContext;
    private static PackageManagerWrapper packageManagerWrapper;

    InstantAppUtil() {
    }

    static boolean doShowInstallPrompt(Activity activity, int n, String string2) {
        if (activity == null) {
            PrefHelper.Debug("Unable to show install prompt. Activity is null");
            return false;
        }
        if (!InstantAppUtil.isInstantApp((Context)activity)) {
            PrefHelper.Debug("Unable to show install prompt. Application is not an instant app");
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW").setPackage("com.android.vending").addCategory("android.intent.category.DEFAULT").putExtra("callerId", activity.getPackageName()).putExtra("overlay", true);
        Uri.Builder builder = new Uri.Builder().scheme("market").authority("details").appendQueryParameter("id", activity.getPackageName());
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            builder.appendQueryParameter("referrer", string2);
        }
        intent.setData(builder.build());
        activity.startActivityForResult(intent, n);
        return true;
    }

    private static boolean isAtLeastO() {
        return Build.VERSION.SDK_INT > 25 || InstantAppUtil.isPreReleaseOBuild();
        {
        }
    }

    /*
     * Exception decompiling
     */
    static boolean isInstantApp(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl57 : GETSTATIC : trying to set 1 previously set to 0
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

    private static boolean isPreReleaseOBuild() {
        return !"REL".equals((Object)Build.VERSION.CODENAME) && ("O".equals((Object)Build.VERSION.CODENAME) || Build.VERSION.CODENAME.startsWith("OMR"));
    }

    private static class PackageManagerWrapper {
        private static Method isInstantAppMethod;
        private final PackageManager packageManager;

        PackageManagerWrapper(PackageManager packageManager) {
            this.packageManager = packageManager;
        }

        Boolean isInstantApp() {
            if (!InstantAppUtil.isAtLeastO()) {
                return null;
            }
            if (isInstantAppMethod == null) {
                try {
                    isInstantAppMethod = PackageManager.class.getDeclaredMethod("isInstantApp", new Class[0]);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    return null;
                }
            }
            try {
                Boolean bl = (Boolean)isInstantAppMethod.invoke((Object)this.packageManager, new Object[0]);
                return bl;
            }
            catch (IllegalAccessException | InvocationTargetException throwable) {
                return null;
            }
        }
    }

}

