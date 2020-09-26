/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.model.animatable.AnimatableIntegerValue
 *  com.airbnb.lottie.model.animatable.AnimatableShapeValue
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;

class MaskParser {
    private MaskParser() {
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static Mask parse(JsonReader var0, LottieComposition var1_1) throws IOException {
        var0.beginObject();
        var2_2 = null;
        var3_3 = null;
        var4_4 = null;
        var5_5 = false;
        do {
            block25 : {
                block22 : {
                    block23 : {
                        block24 : {
                            if (!var0.hasNext()) {
                                var0.endObject();
                                return new Mask(var2_2, var3_3, var4_4, var5_5);
                            }
                            var6_6 = var0.nextName();
                            var7_7 = var6_6.hashCode();
                            var8_8 = -1;
                            if (var7_7 == 111) break block22;
                            if (var7_7 == 3588) break block23;
                            if (var7_7 == 104433) break block24;
                            if (var7_7 != 3357091 || !var6_6.equals((Object)"mode")) ** GOTO lbl-1000
                            var9_9 = 0;
                            break block25;
                        }
                        if (!var6_6.equals((Object)"inv")) ** GOTO lbl-1000
                        var9_9 = 3;
                        break block25;
                    }
                    if (!var6_6.equals((Object)"pt")) ** GOTO lbl-1000
                    var9_9 = 1;
                    break block25;
                }
                if (var6_6.equals((Object)"o")) {
                    var9_9 = 2;
                } else lbl-1000: // 4 sources:
                {
                    var9_9 = -1;
                }
            }
            if (var9_9 != 0) {
                if (var9_9 != 1) {
                    if (var9_9 != 2) {
                        if (var9_9 != 3) {
                            var0.skipValue();
                            continue;
                        }
                        var5_5 = var0.nextBoolean();
                        continue;
                    }
                    var4_4 = AnimatableValueParser.parseInteger(var0, var1_1);
                    continue;
                }
                var3_3 = AnimatableValueParser.parseShapeData(var0, var1_1);
                continue;
            }
            var10_10 = var0.nextString();
            var11_11 = var10_10.hashCode();
            if (var11_11 != 97) {
                if (var11_11 != 105) {
                    if (var11_11 != 110) {
                        if (var11_11 == 115 && var10_10.equals((Object)"s")) {
                            var8_8 = 1;
                        }
                    } else if (var10_10.equals((Object)"n")) {
                        var8_8 = 2;
                    }
                } else if (var10_10.equals((Object)"i")) {
                    var8_8 = 3;
                }
            } else if (var10_10.equals((Object)"a")) {
                var8_8 = 0;
            }
            if (var8_8 != 0) {
                if (var8_8 != 1) {
                    if (var8_8 != 2) {
                        if (var8_8 != 3) {
                            var12_12 = new StringBuilder();
                            var12_12.append("Unknown mask mode ");
                            var12_12.append(var6_6);
                            var12_12.append(". Defaulting to Add.");
                            Logger.warning(var12_12.toString());
                            var2_2 = Mask.MaskMode.MASK_MODE_ADD;
                            continue;
                        }
                        var1_1.addWarning("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                        var2_2 = Mask.MaskMode.MASK_MODE_INTERSECT;
                        continue;
                    }
                    var2_2 = Mask.MaskMode.MASK_MODE_NONE;
                    continue;
                }
                var2_2 = Mask.MaskMode.MASK_MODE_SUBTRACT;
                continue;
            }
            var2_2 = Mask.MaskMode.MASK_MODE_ADD;
        } while (true);
    }
}

