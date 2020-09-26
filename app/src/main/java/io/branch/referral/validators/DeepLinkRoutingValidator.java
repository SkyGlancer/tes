/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.text.TextUtils
 *  io.branch.referral.Branch
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral.validators;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class DeepLinkRoutingValidator {
    private static final String BRANCH_VALIDATE_TEST_KEY = "_branch_validate";
    private static final int BRANCH_VALIDATE_TEST_VALUE = 60514;
    private static final int LAUNCH_TEST_TEMPLATE_DELAY = 500;
    private static final String URI_REDIRECT_KEY = "$uri_redirect_mode";
    private static final String URI_REDIRECT_MODE = "2";
    private static final String VALIDATE_LINK_PARAM_KEY = "validate";
    private static final String VALIDATE_SDK_LINK_PARAM_KEY = "bnc_validate";
    private static WeakReference<Activity> current_activity_reference;

    private static void displayErrorMessage() {
        if (current_activity_reference.get() != null) {
            AlertDialog.Builder builder = Build.VERSION.SDK_INT >= 21 ? new AlertDialog.Builder((Context)current_activity_reference.get(), 16974374) : new AlertDialog.Builder((Context)current_activity_reference.get());
            builder.setTitle((CharSequence)"Branch Deeplink Routing Support").setMessage((CharSequence)"Bummer. It seems like +clicked_branch_link is false - we didn't deep link.  Double check that the link you're clicking has the same branch_key that is being used in your Manifest file. Return to Chrome when you're ready to test again.").setNeutralButton((CharSequence)"Got it", new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n) {
                }
            }).setCancelable(false).setIcon(17301651).show();
        }
    }

    private static String getLatestReferringLink() {
        if (Branch.getInstance() != null && Branch.getInstance().getLatestReferringParams() != null) {
            JSONObject jSONObject = Branch.getInstance().getLatestReferringParams();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("~");
            stringBuilder.append(Defines.Jsonkey.ReferringLink.getKey());
            return jSONObject.optString(stringBuilder.toString());
        }
        return "";
    }

    /*
     * Exception decompiling
     */
    private static String getUpdatedLinkWithTestStat(JSONObject var0, String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl30 : NEW : trying to set 1 previously set to 0
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

    /*
     * Exception decompiling
     */
    private static void launchTestTemplate(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl47 : RETURN : trying to set 0 previously set to 1
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

    public static void validate(WeakReference<Activity> weakReference) {
        current_activity_reference = weakReference;
        if (!TextUtils.isEmpty((CharSequence)DeepLinkRoutingValidator.getLatestReferringLink()) && weakReference != null) {
            final JSONObject jSONObject = Branch.getInstance().getLatestReferringParams();
            if (jSONObject.optInt(BRANCH_VALIDATE_TEST_KEY) == 60514) {
                if (jSONObject.optBoolean(Defines.Jsonkey.Clicked_Branch_Link.getKey())) {
                    DeepLinkRoutingValidator.validateDeeplinkRouting(jSONObject);
                    return;
                }
                DeepLinkRoutingValidator.displayErrorMessage();
                return;
            }
            if (jSONObject.optBoolean(VALIDATE_SDK_LINK_PARAM_KEY)) {
                new Handler().postDelayed(new Runnable(){

                    public void run() {
                        DeepLinkRoutingValidator.launchTestTemplate(DeepLinkRoutingValidator.getUpdatedLinkWithTestStat(jSONObject, ""));
                    }
                }, 500L);
            }
        }
    }

    private static void validateDeeplinkRouting(final JSONObject jSONObject) {
        if (current_activity_reference.get() != null) {
            AlertDialog.Builder builder = Build.VERSION.SDK_INT >= 21 ? new AlertDialog.Builder((Context)current_activity_reference.get(), 16974374) : new AlertDialog.Builder((Context)current_activity_reference.get());
            builder.setTitle((CharSequence)"Branch Deeplinking Routing").setMessage((CharSequence)"Good news - we got link data. Now a question for you, astute developer: did the app deep link to the specific piece of content you expected to see?").setPositiveButton((CharSequence)"Yes", new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n) {
                    DeepLinkRoutingValidator.launchTestTemplate(DeepLinkRoutingValidator.getUpdatedLinkWithTestStat(jSONObject, "g"));
                }
            }).setNegativeButton((CharSequence)"No", new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n) {
                    DeepLinkRoutingValidator.launchTestTemplate(DeepLinkRoutingValidator.getUpdatedLinkWithTestStat(jSONObject, "r"));
                }
            }).setNeutralButton(17039360, new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n) {
                }
            }).setCancelable(false).setIcon(17301651).show();
        }
    }

}

