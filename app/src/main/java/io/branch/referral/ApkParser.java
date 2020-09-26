/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import io.branch.referral.Defines;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ApkParser {
    private static final int endDocTag = 1048833;
    private static final int endTag = 1048835;
    private static final int startTag = 1048834;

    ApkParser() {
    }

    private int LEW(byte[] arrby, int n) {
        return -16777216 & arrby[n + 3] << 24 | 16711680 & arrby[n + 2] << 16 | 65280 & arrby[n + 1] << 8 | 255 & arrby[n];
    }

    private String compXmlString(byte[] arrby, int n, int n2, int n3) {
        if (n3 < 0) {
            return null;
        }
        return this.compXmlStringAt(arrby, n2 + this.LEW(arrby, n + n3 * 4));
    }

    private String compXmlStringAt(byte[] arrby, int n) {
        int n2 = 65280 & arrby[n + 1] << 8 | 255 & arrby[n];
        byte[] arrby2 = new byte[n2];
        for (int i = 0; i < n2; ++i) {
            arrby2[i] = arrby[n + 2 + i * 2];
        }
        return new String(arrby2);
    }

    private boolean validURI(String string2) {
        return string2 != null && !"http".equals((Object)string2) && !string2.equals((Object)"https") && !string2.equals((Object)"geo") && !string2.equals((Object)"*") && !string2.equals((Object)"package") && !string2.equals((Object)"sms") && !string2.equals((Object)"smsto") && !string2.equals((Object)"mms") && !string2.equals((Object)"mmsto") && !string2.equals((Object)"tel") && !string2.equals((Object)"voicemail") && !string2.equals((Object)"file") && !string2.equals((Object)"content") && !string2.equals((Object)"mailto");
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public JSONObject decompressXMLForValidator(byte[] var1_1) {
        var2_2 = new JSONObject();
        var3_3 = new JSONArray();
        var4_4 = new JSONObject();
        var5_5 = 4 * this.LEW(var1_1, 16);
        var6_6 = 36;
        var7_7 = var5_5 + var6_6;
        var9_9 = var8_8 = this.LEW(var1_1, 12);
        do {
            var10_10 = -4 + var1_1.length;
            var11_11 = 1048834;
            if (var9_9 >= var10_10) break;
            if (this.LEW(var1_1, var9_9) == var11_11) {
                var8_8 = var9_9;
                break;
            }
            var9_9 += 4;
        } while (true);
        var12_12 = "";
        do {
            block37 : {
                block28 : {
                    block35 : {
                        block31 : {
                            block30 : {
                                block29 : {
                                    var14_13 = var1_1.length;
                                    if (var8_8 >= var14_13) break;
                                    var20_15 = this.LEW(var1_1, var8_8);
                                    if (var20_15 != var11_11) break block28;
                                    var21_16 = this.LEW(var1_1, var8_8 + 28);
                                    var8_8 += 36;
                                    var22_17 = 0;
lbl29: // 2 sources:
                                    while (var22_17 < var21_16) {
                                        block34 : {
                                            block33 : {
                                                block32 : {
                                                    var23_18 = this.LEW(var1_1, var8_8 + 4);
                                                    var24_19 = this.LEW(var1_1, var8_8 + 8);
                                                    var25_20 = this.LEW(var1_1, var8_8 + 16);
                                                    var26_21 = var8_8 + 20;
                                                    var27_22 = this.compXmlString(var1_1, var6_6, var7_7, var23_18);
                                                    var28_23 = "scheme".equals((Object)var27_22);
                                                    var29_24 = var21_16;
                                                    var15_14 = var4_4;
                                                    if (!var28_23) ** GOTO lbl61
                                                    if (var24_19 == -1) ** GOTO lbl45
                                                    var48_32 = this.compXmlString(var1_1, 36, var7_7, var24_19);
                                                    break block32;
lbl45: // 1 sources:
                                                    var45_31 = new StringBuilder();
                                                    var45_31.append("resourceID 0x");
                                                    var45_31.append(Integer.toHexString((int)var25_20));
                                                    var48_32 = var45_31.toString();
                                                }
                                                if (this.validURI(var48_32)) {
                                                    if (!var2_2.has(var48_32)) {
                                                        var2_2.put(var48_32, (Object)new JSONArray());
                                                    } else if (var2_2.has("0")) {
                                                        var2_2.put(var48_32, (Object)((JSONArray)var2_2.get("0")));
                                                        var2_2.remove("0");
                                                    }
                                                    break block29;
                                                }
lbl58: // 3 sources:
                                                while ("http".equals((Object)var48_32) || "https".equals((Object)var48_32)) {
                                                    break block30;
                                                }
                                                break block31;
lbl61: // 1 sources:
                                                if (!"host".equals((Object)var27_22)) ** GOTO lbl85
                                                if (var24_19 == -1) ** GOTO lbl66
                                                var30_25 = this.compXmlString(var1_1, 36, var7_7, var24_19);
                                                break block33;
lbl66: // 1 sources:
                                                var38_28 = new StringBuilder();
                                                var38_28.append("resourceID 0x");
                                                var38_28.append(Integer.toHexString((int)var25_20));
                                                var30_25 = var38_28.toString();
                                            }
                                            if (!var2_2.has(var12_12) || var12_12 == null) ** GOTO lbl-1000
                                            if (!"https".equals((Object)var12_12) && !"http".equals((Object)var12_12)) {
                                                var35_27 = var2_2.getJSONArray(var12_12);
                                                var35_27.put((Object)var30_25);
                                                var2_2.put(var12_12, (Object)var35_27);
                                            } else if (!"https".equals((Object)var12_12) && !"http".equals((Object)var12_12)) {
                                                var32_26 = new JSONArray();
                                                var32_26.put((Object)var30_25);
                                                var2_2.put("0", (Object)var32_26);
                                            } else {
                                                var3_3.put((Object)var30_25);
                                            }
                                            break block31;
lbl85: // 1 sources:
                                            if (!"name".equals((Object)var27_22)) break block31;
                                            if (var24_19 == -1) ** GOTO lbl90
                                            var41_29 = this.compXmlString(var1_1, 36, var7_7, var24_19);
                                            break block34;
lbl90: // 1 sources:
                                            var42_30 = new StringBuilder();
                                            var42_30.append("resourceID 0x");
                                            var42_30.append(Integer.toHexString((int)var25_20));
                                            var41_29 = var42_30.toString();
                                        }
                                        if ("android.intent.action.VIEW".equals((Object)var41_29)) {
                                            var12_12 = null;
                                        }
                                        break block31;
                                    }
                                    break block35;
lbl99: // 2 sources:
                                    do {
                                        block36 : {
                                            var2_2.remove("0");
                                            var17_33 = Defines.Jsonkey.URIScheme.getKey();
                                            var4_4 = var15_14;
                                            var4_4.put(var17_33, (Object)var2_2);
                                            var4_4.put(Defines.Jsonkey.AppLinks.getKey(), (Object)var3_3);
                                            return var4_4;
                                            catch (JSONException var13_34) {
                                                var4_4 = var15_14;
                                            }
                                            break block36;
                                            catch (JSONException var13_35) {
                                                // empty catch block
                                            }
                                        }
                                        var13_36.printStackTrace();
                                        return var4_4;
                                        break;
                                    } while (true);
                                }
                                var12_12 = var48_32;
                                ** GOTO lbl58
                            }
                            var12_12 = var48_32;
                        }
                        ++var22_17;
                        var8_8 = var26_21;
                        var21_16 = var29_24;
                        var4_4 = var15_14;
                        var6_6 = 36;
                        ** GOTO lbl29
                    }
                    var15_14 = var4_4;
                    break block37;
                }
                var15_14 = var4_4;
                if (var20_15 != 1048835) ** GOTO lbl99
                var8_8 += 24;
            }
            var4_4 = var15_14;
            var6_6 = 36;
            var11_11 = 1048834;
        } while (true);
        var15_14 = var4_4;
        ** while (true)
    }
}

