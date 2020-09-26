/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  com.airbnb.lottie.model.animatable.AnimatableGradientColorValue
 *  com.airbnb.lottie.model.animatable.AnimatableIntegerValue
 *  com.airbnb.lottie.model.animatable.AnimatablePointValue
 *  com.airbnb.lottie.model.content.GradientStroke
 *  com.airbnb.lottie.model.content.ShapeStroke
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class GradientStrokeParser {
    private static final JsonReader.Options DASH_PATTERN_NAMES;
    private static final JsonReader.Options GRADIENT_NAMES;
    private static JsonReader.Options NAMES;

    static {
        NAMES = JsonReader.Options.of("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");
        GRADIENT_NAMES = JsonReader.Options.of("p", "k");
        DASH_PATTERN_NAMES = JsonReader.Options.of("n", "v");
    }

    private GradientStrokeParser() {
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static GradientStroke parse(JsonReader var0, LottieComposition var1_1) throws IOException {
        block27 : {
            var2_2 = new ArrayList();
            var3_3 = null;
            var4_4 = null;
            var5_5 = null;
            var6_6 = null;
            var7_7 = null;
            var8_8 = null;
            var9_9 = null;
            var10_10 = null;
            var11_11 = null;
            var12_12 = 0.0f;
            var13_13 = null;
            var14_14 = false;
            block14 : do {
                if (!var0.hasNext()) {
                    return new GradientStroke(var3_3, var4_4, var5_5, var6_6, var7_7, var8_8, var9_9, var10_10, var11_11, var12_12, (List)var2_2, var13_13, var14_14);
                }
                switch (var0.selectName(GradientStrokeParser.NAMES)) {
                    default: {
                        var0.skipName();
                        var0.skipValue();
                        continue block14;
                    }
                    case 11: {
                        var0.beginArray();
lbl24: // 3 sources:
                        do {
                            if (var0.hasNext()) {
                                var0.beginObject();
                                var23_20 = null;
                                var24_21 = null;
                                break block14;
                            }
                            var21_19 = var13_13;
                            var0.endArray();
                            if (var2_2.size() == 1) {
                                var2_2.add(var2_2.get(0));
                            }
                            var13_13 = var21_19;
                            continue block14;
                            break;
                        } while (true);
                    }
                    case 10: {
                        var14_14 = var0.nextBoolean();
                        continue block14;
                    }
                    case 9: {
                        var12_12 = (float)var0.nextDouble();
                        continue block14;
                    }
                    case 8: {
                        var11_11 = ShapeStroke.LineJoinType.values()[var0.nextInt() - 1];
                        continue block14;
                    }
                    case 7: {
                        var10_10 = ShapeStroke.LineCapType.values()[var0.nextInt() - 1];
                        continue block14;
                    }
                    case 6: {
                        var9_9 = AnimatableValueParser.parseFloat(var0, var1_1);
                        continue block14;
                    }
                    case 5: {
                        var8_8 = AnimatableValueParser.parsePoint(var0, var1_1);
                        continue block14;
                    }
                    case 4: {
                        var7_7 = AnimatableValueParser.parsePoint(var0, var1_1);
                        continue block14;
                    }
                    case 3: {
                        var20_18 = var0.nextInt() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                        var4_4 = var20_18;
                        continue block14;
                    }
                    case 2: {
                        var6_6 = AnimatableValueParser.parseInteger(var0, var1_1);
                        continue block14;
                    }
                    case 1: {
                        var16_15 = -1;
                        var0.beginObject();
                        while (var0.hasNext()) {
                            var18_16 = var0.selectName(GradientStrokeParser.GRADIENT_NAMES);
                            if (var18_16 == 0) ** GOTO lbl77
                            var19_17 = var5_5;
                            if (var18_16 != 1) {
                                var0.skipName();
                                var0.skipValue();
                            } else {
                                var5_5 = AnimatableValueParser.parseGradientColor(var0, var1_1, var16_15);
                                continue;
lbl77: // 1 sources:
                                var19_17 = var5_5;
                                var16_15 = var0.nextInt();
                            }
                            var5_5 = var19_17;
                        }
                        var0.endObject();
                        continue block14;
                    }
                    case 0: {
                        var3_3 = var0.nextString();
                        continue block14;
                    }
                }
                break;
            } while (true);
            while (var0.hasNext()) {
                var27_23 = var0.selectName(GradientStrokeParser.DASH_PATTERN_NAMES);
                if (var27_23 != 0) {
                    var29_24 = var13_13;
                    if (var27_23 != 1) {
                        var0.skipName();
                        var0.skipValue();
                    } else {
                        var24_21 = AnimatableValueParser.parseFloat(var0, var1_1);
                    }
                    var13_13 = var29_24;
                    continue;
                }
                var23_20 = var0.nextString();
            }
            var25_22 = var13_13;
            var0.endObject();
            if (!var23_20.equals((Object)"o")) break block27;
            var13_13 = var24_21;
            ** GOTO lbl24
        }
        if (var23_20.equals((Object)"d") || var23_20.equals((Object)"g")) {
            var1_1.setHasDashPattern(true);
            var2_2.add((Object)var24_21);
        }
        var13_13 = var25_22;
        ** while (true)
    }
}

