/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.List
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral.validators;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import io.branch.referral.BranchAsyncTask;
import io.branch.referral.BranchUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

class BranchIntegrationModel {
    boolean appSettingsAvailable;
    final List<String> applinkScheme;
    private final String branchKeyLive;
    private final String branchKeyTest;
    JSONObject deeplinkUriScheme;
    final String packageName;

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public BranchIntegrationModel(Context context) {
        String string2;
        String string3;
        block7 : {
            String string5;
            String string4;
            block5 : {
                void var3_7;
                block6 : {
                    block4 : {
                        this.appSettingsAvailable = false;
                        this.applinkScheme = new ArrayList();
                        this.packageName = context.getPackageName();
                        string4 = null;
                        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                        if (applicationInfo.metaData == null) break block4;
                        string5 = applicationInfo.metaData.getString("io.branch.sdk.BranchKey");
                        try {
                            string4 = applicationInfo.metaData.getString("io.branch.sdk.BranchKey.test");
                            break block5;
                        }
                        catch (PackageManager.NameNotFoundException nameNotFoundException) {
                            break block6;
                        }
                    }
                    string2 = null;
                    string3 = null;
                    break block7;
                    catch (PackageManager.NameNotFoundException nameNotFoundException) {
                        string5 = null;
                    }
                }
                var3_7.printStackTrace();
            }
            string3 = string4;
            string2 = string5;
        }
        this.branchKeyLive = string2;
        this.branchKeyTest = string3;
        this.updateDeepLinkSchemes(context);
    }

    /*
     * Exception decompiling
     */
    private void updateDeepLinkSchemes(Context var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl30 : ALOAD : trying to set 1 previously set to 0
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

    private class getDeepLinkSchemeTasks
    extends BranchAsyncTask<Context, Void, JSONObject> {
        private getDeepLinkSchemeTasks() {
        }

        protected /* varargs */ JSONObject doInBackground(Context ... arrcontext) {
            return BranchUtil.getDeepLinkSchemes(arrcontext[0]);
        }
    }

}

