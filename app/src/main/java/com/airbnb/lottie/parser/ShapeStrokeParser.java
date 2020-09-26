/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.model.animatable.AnimatableColorValue
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  com.airbnb.lottie.model.animatable.AnimatableIntegerValue
 *  com.airbnb.lottie.model.content.ShapeStroke
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ShapeStrokeParser {
    private static final JsonReader.Options DASH_PATTERN_NAMES;
    private static JsonReader.Options NAMES;

    static {
        NAMES = JsonReader.Options.of("nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d");
        DASH_PATTERN_NAMES = JsonReader.Options.of("n", "v");
    }

    private ShapeStrokeParser() {
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static ShapeStroke parse(JsonReader var0, LottieComposition var1_1) throws IOException {
        block25 : {
            block23 : {
                block24 : {
                    var2_2 = new ArrayList();
                    var3_3 = null;
                    var4_4 = null;
                    var5_5 = null;
                    var6_6 = null;
                    var7_7 = null;
                    var8_8 = null;
                    var9_9 = null;
                    var10_10 = 0.0f;
                    var11_11 = false;
                    block11 : do {
                        if (!var0.hasNext()) {
                            return new ShapeStroke(var3_3, var4_4, (List)var2_2, var5_5, var6_6, var7_7, var8_8, var9_9, var10_10, var11_11);
                        }
                        var13_12 = var0.selectName(ShapeStrokeParser.NAMES);
                        var14_13 = 1;
                        switch (var13_12) {
                            default: {
                                var0.skipValue();
                                continue block11;
                            }
                            case 8: {
                                var0.beginArray();
lbl22: // 2 sources:
                                do {
                                    if (var0.hasNext()) {
                                        var0.beginObject();
                                        var16_14 = null;
                                        var17_15 = null;
                                        break block11;
                                    }
                                    var0.endArray();
                                    if (var2_2.size() != 1) continue block11;
                                    var2_2.add(var2_2.get(0));
                                    continue block11;
                                    break;
                                } while (true);
                            }
                            case 7: {
                                var11_11 = var0.nextBoolean();
                                continue block11;
                            }
                            case 6: {
                                var10_10 = (float)var0.nextDouble();
                                continue block11;
                            }
                            case 5: {
                                var9_9 = ShapeStroke.LineJoinType.values()[var0.nextInt() - 1];
                                continue block11;
                            }
                            case 4: {
                                var8_8 = ShapeStroke.LineCapType.values()[var0.nextInt() - var14_13];
                                continue block11;
                            }
                            case 3: {
                                var6_6 = AnimatableValueParser.parseInteger(var0, var1_1);
                                continue block11;
                            }
                            case 2: {
                                var7_7 = AnimatableValueParser.parseFloat(var0, var1_1);
                                continue block11;
                            }
                            case 1: {
                                var5_5 = AnimatableValueParser.parseColor(var0, var1_1);
                                continue block11;
                            }
                            case 0: {
                                var3_3 = var0.nextString();
                                continue block11;
                            }
                        }
                        break;
                    } while (true);
                    while (var0.hasNext()) {
                        var21_18 = var0.selectName(ShapeStrokeParser.DASH_PATTERN_NAMES);
                        if (var21_18 != 0) {
                            if (var21_18 != var14_13) {
                                var0.skipName();
                                var0.skipValue();
                                continue;
                            }
                            var17_15 = AnimatableValueParser.parseFloat(var0, var1_1);
                            continue;
                        }
                        var16_14 = var0.nextString();
                    }
                    var0.endObject();
                    var18_16 = var16_14.hashCode();
                    if (var18_16 == 100) break block23;
                    if (var18_16 == 103) break block24;
                    if (var18_16 != 111 || !var16_14.equals((Object)"o")) ** GOTO lbl-1000
                    var19_17 = 0;
                    break block25;
                }
                if (!var16_14.equals((Object)"g")) ** GOTO lbl-1000
                var19_17 = 2;
                break block25;
            }
            if (var16_14.equals((Object)"d")) {
                var19_17 = 1;
            } else lbl-1000: // 3 sources:
            {
                var19_17 = -1;
            }
        }
        if (var19_17 != 0) {
            if (var19_17 == 1 || var19_17 == 2) {
                var1_1.setHasDashPattern(true);
                var2_2.add((Object)var17_15);
            }
        } else {
            var4_4 = var17_15;
        }
        var14_13 = 1;
        ** while (true)
    }
}

