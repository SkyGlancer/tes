/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  io.branch.referral.Branch
 *  java.io.BufferedReader
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.FileReader
 *  java.io.IOException
 *  java.io.Reader
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.reflect.Method
 *  java.util.HashMap
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.Context;
import android.text.TextUtils;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.PrefHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class BranchPreinstall {
    private static final String BRANCH_PREINSTALL_PROP_KEY = "io.branch.preinstall.apps.path";
    private static final String SYSTEM_PROPERTIES_CLASS_KEY = "android.os.SystemProperties";

    BranchPreinstall() {
    }

    private static String checkForBranchPreinstallInSystem() {
        try {
            String string2 = (String)Class.forName((String)SYSTEM_PROPERTIES_CLASS_KEY).getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{BRANCH_PREINSTALL_PROP_KEY});
            return string2;
        }
        catch (Exception exception) {
            return null;
        }
    }

    /*
     * Exception decompiling
     */
    public static void getBranchFileContent(JSONObject var0, Branch var1, Context var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl4 : ALOAD_3 : trying to set 1 previously set to 0
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

    public static void getPreinstallSystemData(Branch branch, Context context) {
        String string2;
        if (branch != null && !TextUtils.isEmpty((CharSequence)(string2 = BranchPreinstall.checkForBranchPreinstallInSystem()))) {
            BranchPreinstall.readBranchFile(string2, branch, context);
        }
    }

    private static void readBranchFile(final String string2, final Branch branch, final Context context) {
        new Thread(new Runnable(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                try {
                    String string22;
                    StringBuilder stringBuilder = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader((Reader)new FileReader(new File(string2)));
                    while ((string22 = bufferedReader.readLine()) != null) {
                        stringBuilder.append(string22);
                    }
                    bufferedReader.close();
                    JSONObject jSONObject = new JSONObject(stringBuilder.toString().trim());
                    if (!TextUtils.isEmpty((CharSequence)jSONObject.toString())) {
                        BranchPreinstall.getBranchFileContent(jSONObject, branch, context);
                        return;
                    }
                    throw new FileNotFoundException();
                }
                catch (FileNotFoundException | IOException | JSONException throwable) {
                    return;
                }
            }
        }).start();
    }

    public static void setBranchPreInstallGoogleReferrer(Context context, HashMap<String, String> hashMap) {
        Branch branch = Branch.getInstance();
        PrefHelper prefHelper = PrefHelper.getInstance(context);
        if (TextUtils.isEmpty((CharSequence)prefHelper.getInstallMetaData(Defines.PreinstallKey.partner.getKey())) && TextUtils.isEmpty((CharSequence)prefHelper.getInstallMetaData(Defines.PreinstallKey.campaign.getKey()))) {
            if (!TextUtils.isEmpty((CharSequence)((CharSequence)hashMap.get((Object)Defines.Jsonkey.UTMCampaign.getKey())))) {
                branch.setPreinstallCampaign((String)hashMap.get((Object)Defines.Jsonkey.UTMCampaign.getKey()));
            }
            if (!TextUtils.isEmpty((CharSequence)((CharSequence)hashMap.get((Object)Defines.Jsonkey.UTMMedium.getKey())))) {
                branch.setPreinstallPartner((String)hashMap.get((Object)Defines.Jsonkey.UTMMedium.getKey()));
            }
        }
    }

}

