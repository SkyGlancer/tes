/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.branch.referral.Branch
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral.network;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerResponse;
import io.branch.referral.network.BranchRemoteInterfaceUrlConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BranchRemoteInterface {
    public static final String RETRY_NUMBER = "retryNumber";

    /*
     * Exception decompiling
     */
    private boolean addCommonParams(JSONObject var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl24.1 : ICONST_0 : trying to set 1 previously set to 0
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String convertJSONtoString(JSONObject jSONObject) {
        JSONArray jSONArray;
        StringBuilder stringBuilder = new StringBuilder();
        if (jSONObject != null && (jSONArray = jSONObject.names()) != null) {
            int n = jSONArray.length();
            boolean bl = true;
            for (int i = 0; i < n; ++i) {
                try {
                    String string2 = jSONArray.getString(i);
                    if (bl) {
                        stringBuilder.append("?");
                        bl = false;
                    } else {
                        stringBuilder.append("&");
                    }
                    String string3 = jSONObject.getString(string2);
                    stringBuilder.append(string2);
                    stringBuilder.append("=");
                    stringBuilder.append(string3);
                    continue;
                }
                catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                    return null;
                }
            }
        }
        return stringBuilder.toString();
    }

    public static final BranchRemoteInterface getDefaultBranchRemoteInterface(Context context) {
        return new BranchRemoteInterfaceUrlConnection(context);
    }

    private ServerResponse processEntityForJSON(String string2, int n, String string3) {
        ServerResponse serverResponse = new ServerResponse(string3, n);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("returned ");
        stringBuilder.append(string2);
        PrefHelper.Debug(stringBuilder.toString());
        if (string2 != null) {
            try {
                serverResponse.setPost((Object)new JSONObject(string2));
                return serverResponse;
            }
            catch (JSONException jSONException) {
                try {
                    serverResponse.setPost((Object)new JSONArray(string2));
                    return serverResponse;
                }
                catch (JSONException jSONException2) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("JSON exception: ");
                    stringBuilder2.append(jSONException2.getMessage());
                    PrefHelper.Debug(stringBuilder2.toString());
                }
            }
        }
        return serverResponse;
    }

    public abstract BranchResponse doRestfulGet(String var1) throws BranchRemoteException;

    public abstract BranchResponse doRestfulPost(String var1, JSONObject var2) throws BranchRemoteException;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final ServerResponse make_restful_get(String var1_1, JSONObject var2_2, String var3_3, String var4_4) {
        if (var2_2 == null) {
            var2_2 = new JSONObject();
        }
        if (this.addCommonParams(var2_2, var4_4) == false) return new ServerResponse(var3_3, -114);
        var5_5 = new StringBuilder();
        var5_5.append(var1_1);
        var5_5.append(this.convertJSONtoString(var2_2));
        var8_6 = var5_5.toString();
        var9_7 = System.currentTimeMillis();
        var11_8 = new StringBuilder();
        var11_8.append("getting ");
        var11_8.append(var8_6);
        PrefHelper.Debug(var11_8.toString());
        var36_9 = this.doRestfulGet(var8_6);
        var37_10 = this.processEntityForJSON(BranchResponse.access$000(var36_9), BranchResponse.access$100(var36_9), var3_3);
        if (Branch.getInstance() == null) return var37_10;
        var38_11 = (int)(System.currentTimeMillis() - var9_7);
        var39_12 = Branch.getInstance();
        var40_13 = new StringBuilder();
        var40_13.append(var3_3);
        var40_13.append("-");
        var40_13.append(Defines.Jsonkey.Branch_Round_Trip_Time.getKey());
        var39_12.addExtraInstrumentationData(var40_13.toString(), String.valueOf((int)var38_11));
        return var37_10;
        {
            catch (Throwable var29_14) {
            }
            catch (BranchRemoteException var14_15) {}
            {
                if (BranchRemoteException.access$200(var14_15) != -111) ** GOTO lbl-1000
                var15_16 = new ServerResponse(var3_3, -111);
            }
            if (Branch.getInstance() == null) return var15_16;
            var16_17 = (int)(System.currentTimeMillis() - var9_7);
            var17_18 = Branch.getInstance();
            var18_19 = new StringBuilder();
            var18_19.append(var3_3);
            var18_19.append("-");
            var18_19.append(Defines.Jsonkey.Branch_Round_Trip_Time.getKey());
            var17_18.addExtraInstrumentationData(var18_19.toString(), String.valueOf((int)var16_17));
            return var15_16;
lbl-1000: // 1 sources:
            {
                var22_20 = new ServerResponse(var3_3, -113);
            }
            if (Branch.getInstance() == null) return var22_20;
            var23_21 = (int)(System.currentTimeMillis() - var9_7);
            var24_22 = Branch.getInstance();
            var25_23 = new StringBuilder();
            var25_23.append(var3_3);
            var25_23.append("-");
            var25_23.append(Defines.Jsonkey.Branch_Round_Trip_Time.getKey());
            var24_22.addExtraInstrumentationData(var25_23.toString(), String.valueOf((int)var23_21));
            return var22_20;
        }
        if (Branch.getInstance() == null) throw var29_14;
        var30_24 = (int)(System.currentTimeMillis() - var9_7);
        var31_25 = Branch.getInstance();
        var32_26 = new StringBuilder();
        var32_26.append(var3_3);
        var32_26.append("-");
        var32_26.append(Defines.Jsonkey.Branch_Round_Trip_Time.getKey());
        var31_25.addExtraInstrumentationData(var32_26.toString(), String.valueOf((int)var30_24));
        throw var29_14;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final ServerResponse make_restful_post(JSONObject var1_1, String var2_2, String var3_3, String var4_4) {
        var5_5 = System.currentTimeMillis();
        if (var1_1 == null) {
            var1_1 = new JSONObject();
        }
        if (!this.addCommonParams(var1_1, var4_4)) {
            return new ServerResponse(var3_3, -114);
        }
        var7_6 = new StringBuilder();
        var7_6.append("posting to ");
        var7_6.append(var2_2);
        PrefHelper.Debug(var7_6.toString());
        var10_7 = new StringBuilder();
        var10_7.append("Post value = ");
        var10_7.append(var1_1.toString());
        PrefHelper.Debug(var10_7.toString());
        var35_8 = this.doRestfulPost(var2_2, var1_1);
        var36_9 = this.processEntityForJSON(BranchResponse.access$000(var35_8), BranchResponse.access$100(var35_8), var3_3);
        if (Branch.getInstance() == null) return var36_9;
        var37_10 = (int)(System.currentTimeMillis() - var5_5);
        var38_11 = Branch.getInstance();
        var39_12 = new StringBuilder();
        var39_12.append(var3_3);
        var39_12.append("-");
        var39_12.append(Defines.Jsonkey.Branch_Round_Trip_Time.getKey());
        var38_11.addExtraInstrumentationData(var39_12.toString(), String.valueOf((int)var37_10));
        return var36_9;
        {
            catch (Throwable var28_13) {
            }
            catch (BranchRemoteException var13_14) {}
            {
                if (BranchRemoteException.access$200(var13_14) != -111) ** GOTO lbl-1000
                var14_15 = new ServerResponse(var3_3, -111);
            }
            if (Branch.getInstance() == null) return var14_15;
            var15_16 = (int)(System.currentTimeMillis() - var5_5);
            var16_17 = Branch.getInstance();
            var17_18 = new StringBuilder();
            var17_18.append(var3_3);
            var17_18.append("-");
            var17_18.append(Defines.Jsonkey.Branch_Round_Trip_Time.getKey());
            var16_17.addExtraInstrumentationData(var17_18.toString(), String.valueOf((int)var15_16));
            return var14_15;
lbl-1000: // 1 sources:
            {
                var21_19 = new ServerResponse(var3_3, -113);
            }
            if (Branch.getInstance() == null) return var21_19;
            var22_20 = (int)(System.currentTimeMillis() - var5_5);
            var23_21 = Branch.getInstance();
            var24_22 = new StringBuilder();
            var24_22.append(var3_3);
            var24_22.append("-");
            var24_22.append(Defines.Jsonkey.Branch_Round_Trip_Time.getKey());
            var23_21.addExtraInstrumentationData(var24_22.toString(), String.valueOf((int)var22_20));
            return var21_19;
        }
        if (Branch.getInstance() == null) throw var28_13;
        var29_23 = (int)(System.currentTimeMillis() - var5_5);
        var30_24 = Branch.getInstance();
        var31_25 = new StringBuilder();
        var31_25.append(var3_3);
        var31_25.append("-");
        var31_25.append(Defines.Jsonkey.Branch_Round_Trip_Time.getKey());
        var30_24.addExtraInstrumentationData(var31_25.toString(), String.valueOf((int)var29_23));
        throw var28_13;
    }

    public static class BranchRemoteException
    extends Exception {
        private int branchErrorCode = -113;

        public BranchRemoteException(int n) {
            this.branchErrorCode = n;
        }

        static /* synthetic */ int access$200(BranchRemoteException branchRemoteException) {
            return branchRemoteException.branchErrorCode;
        }
    }

    public static class BranchResponse {
        private final int responseCode;
        private final String responseData;

        public BranchResponse(String string2, int n) {
            this.responseData = string2;
            this.responseCode = n;
        }

        static /* synthetic */ String access$000(BranchResponse branchResponse) {
            return branchResponse.responseData;
        }

        static /* synthetic */ int access$100(BranchResponse branchResponse) {
            return branchResponse.responseCode;
        }
    }

}

