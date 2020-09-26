/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  androidx.collection.LongSparseArray
 *  androidx.collection.SparseArrayCompat
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottieCompositionParser {
    static JsonReader.Options NAMES = JsonReader.Options.of("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static LottieComposition parse(JsonReader var0) throws IOException {
        var1_1 = var0;
        var2_2 = Utils.dpScale();
        var3_3 = new LongSparseArray();
        var4_4 = new ArrayList();
        var5_5 = new HashMap();
        var6_6 = new HashMap();
        var7_7 = new HashMap();
        var8_8 = new ArrayList();
        var9_9 = new SparseArrayCompat();
        var10_10 = new LottieComposition();
        var0.beginObject();
        var11_11 = 0;
        var12_12 = 0.0f;
        var13_13 = 0.0f;
        var14_14 = 0.0f;
        var15_15 = 0;
        do {
            block13 : {
                block12 : {
                    if (!var0.hasNext()) {
                        var16_19 = var7_7;
                        var10_10.init(new Rect(0, 0, (int)(var2_2 * (float)var11_11), (int)(var2_2 * (float)var15_15)), var12_12, var13_13, var14_14, (List<Layer>)var4_4, (LongSparseArray<Layer>)var3_3, (Map<String, List<Layer>>)var5_5, (Map<String, LottieImageAsset>)var6_6, (SparseArrayCompat<FontCharacter>)var9_9, (Map<String, Font>)var16_19, (List<Marker>)var8_8);
                        return var10_10;
                    }
                    switch (var1_1.selectName(LottieCompositionParser.NAMES)) {
                        case 6: {
                            LottieCompositionParser.parseLayers(var1_1, var10_10, (List<Layer>)var4_4, (LongSparseArray<Layer>)var3_3);
                        }
                        default: {
                            var24_16 = var7_7;
                            var25_17 = var8_8;
                            ** break;
                        }
                        case 5: {
                            var26_18 = var0.nextString().split("\\.");
                            if (!Utils.isAtLeastVersion(Integer.parseInt((String)var26_18[0]), Integer.parseInt((String)var26_18[1]), Integer.parseInt((String)var26_18[2]), 4, 4, 0)) {
                                var10_10.addWarning("Lottie only supports bodymovin >= 4.4.0");
                            }
                            var24_16 = var7_7;
                            var25_17 = var8_8;
                            break block12;
                        }
                        case 4: {
                            var24_16 = var7_7;
                            var25_17 = var8_8;
                            var14_14 = (float)var0.nextDouble();
                            break block12;
                        }
                        case 3: {
                            var24_16 = var7_7;
                            var25_17 = var8_8;
                            var13_13 = (float)var0.nextDouble() - 0.01f;
                            break block12;
                        }
                        case 2: {
                            var12_12 = (float)var0.nextDouble();
                            break;
                        }
                        case 1: {
                            var15_15 = var0.nextInt();
                            break;
                        }
                        case 0: {
                            var11_11 = var0.nextInt();
                            break;
                        }
                    }
                    break block13;
lbl56: // 1 sources:
                    var0.skipValue();
                }
                var7_7 = var24_16;
                var8_8 = var25_17;
            }
            var1_1 = var0;
        } while (true);
    }

    private static void parseLayers(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int n = 0;
        while (jsonReader.hasNext()) {
            Layer layer = LayerParser.parse(jsonReader, lottieComposition);
            if (layer.getLayerType() == Layer.LayerType.IMAGE) {
                ++n;
            }
            list.add((Object)layer);
            longSparseArray.put(layer.getId(), (Object)layer);
            if (n <= 4) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("You have ");
            stringBuilder.append(n);
            stringBuilder.append(" images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            Logger.warning(stringBuilder.toString());
        }
        jsonReader.endArray();
    }
}

