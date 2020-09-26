/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import io.branch.referral.BranchAsyncTask;
import io.branch.referral.PrefHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class UniversalResourceAnalyser {
    private static final String SKIP_LIST_KEY = "uri_skip_list";
    private static final String SKIP_URL_FORMATS_KEY = "skip_url_format_key";
    private static final String UPDATE_URL_PATH = "%sdk/uriskiplist_v#.json";
    private static final String VERSION_KEY = "version";
    private static UniversalResourceAnalyser instance;
    private static JSONObject skipURLFormats;
    private final JSONObject DEFAULT_SKIP_URL_LIST;
    private final ArrayList<String> acceptURLFormats;

    private UniversalResourceAnalyser(Context context) {
        JSONObject jSONObject;
        this.DEFAULT_SKIP_URL_LIST = jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(VERSION_KEY, (Object)0);
            JSONArray jSONArray = new JSONArray();
            this.DEFAULT_SKIP_URL_LIST.putOpt(SKIP_LIST_KEY, (Object)jSONArray);
            jSONArray.put((Object)"^fb\\d+:");
            jSONArray.put((Object)"^li\\d+:");
            jSONArray.put((Object)"^pdk\\d+:");
            jSONArray.put((Object)"^twitterkit-.*:");
            jSONArray.put((Object)"^com\\.googleusercontent\\.apps\\.\\d+-.*:\\/oauth");
            jSONArray.put((Object)"^(?i)(?!(http|https):).*(:|:.*\\b)(password|o?auth|o?auth.?token|access|access.?token)\\b");
            jSONArray.put((Object)"^(?i)((http|https):\\/\\/).*[\\/|?|#].*\\b(password|o?auth|o?auth.?token|access|access.?token)\\b");
        }
        catch (JSONException jSONException) {}
        skipURLFormats = this.retrieveSkipURLFormats(context);
        this.acceptURLFormats = new ArrayList();
    }

    public static UniversalResourceAnalyser getInstance(Context context) {
        if (instance == null) {
            instance = new UniversalResourceAnalyser(context);
        }
        return instance;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private JSONObject retrieveSkipURLFormats(Context context) {
        PrefHelper prefHelper = PrefHelper.getInstance(context);
        JSONObject jSONObject = new JSONObject();
        String string2 = prefHelper.getString(SKIP_URL_FORMATS_KEY);
        if (TextUtils.isEmpty((CharSequence)string2)) return this.DEFAULT_SKIP_URL_LIST;
        if ("bnc_no_value".equals((Object)string2)) return this.DEFAULT_SKIP_URL_LIST;
        try {
            return new JSONObject(string2);
        }
        catch (JSONException jSONException) {}
        return jSONObject;
    }

    void addToAcceptURLFormats(String string2) {
        this.acceptURLFormats.add((Object)string2);
    }

    void addToAcceptURLFormats(List<String> list) {
        this.acceptURLFormats.addAll(list);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    void addToSkipURLFormats(String var1_1) {
        var2_2 = UniversalResourceAnalyser.skipURLFormats.optJSONArray("uri_skip_list");
        if (var2_2 != null) ** GOTO lbl6
        try {
            var2_2 = new JSONArray();
            UniversalResourceAnalyser.skipURLFormats.put("uri_skip_list", (Object)var2_2);
lbl6: // 2 sources:
            var2_2.put((Object)var1_1);
            return;
        }
        catch (Exception v0) {}
    }

    void checkAndUpdateSkipURLFormats(Context context) {
        try {
            new UrlSkipListUpdateTask(context).executeTask((Params[])new Void[0]);
        }
        catch (Throwable throwable) {}
    }

    /*
     * Exception decompiling
     */
    String getStrippedURL(String var1) {
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

    private static class UrlSkipListUpdateTask
    extends BranchAsyncTask<Void, Void, JSONObject> {
        private final int TIME_OUT = 1500;
        private final PrefHelper prefHelper;

        private UrlSkipListUpdateTask(Context context) {
            this.prefHelper = PrefHelper.getInstance(context);
        }

        /*
         * Exception decompiling
         */
        protected /* varargs */ JSONObject doInBackground(Void ... var1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl68 : ALOAD_2 : trying to set 1 previously set to 0
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

        protected void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute((Object)jSONObject);
            if (jSONObject.optInt(UniversalResourceAnalyser.VERSION_KEY) > skipURLFormats.optInt(UniversalResourceAnalyser.VERSION_KEY)) {
                skipURLFormats = jSONObject;
                this.prefHelper.setString(UniversalResourceAnalyser.SKIP_URL_FORMATS_KEY, skipURLFormats.toString());
            }
        }
    }

}

