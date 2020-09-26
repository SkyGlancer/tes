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
import com.airbnb.lottie.parser.FontCharacterParser;
import com.airbnb.lottie.parser.FontParser;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottieCompositionMoshiParser {
    static JsonReader.Options ASSETS_NAMES;
    private static final JsonReader.Options FONT_NAMES;
    private static final JsonReader.Options MARKER_NAMES;
    private static final JsonReader.Options NAMES;

    static {
        NAMES = JsonReader.Options.of("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");
        ASSETS_NAMES = JsonReader.Options.of("id", "layers", "w", "h", "p", "u");
        FONT_NAMES = JsonReader.Options.of("list");
        MARKER_NAMES = JsonReader.Options.of("cm", "tm", "dr");
    }

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
            block16 : {
                if (!var0.hasNext()) {
                    var16_19 = var7_7;
                    var10_10.init(new Rect(0, 0, (int)(var2_2 * (float)var11_11), (int)(var2_2 * (float)var15_15)), var12_12, var13_13, var14_14, (List<Layer>)var4_4, (LongSparseArray<Layer>)var3_3, (Map<String, List<Layer>>)var5_5, (Map<String, LottieImageAsset>)var6_6, (SparseArrayCompat<FontCharacter>)var9_9, (Map<String, Font>)var16_19, (List<Marker>)var8_8);
                    return var10_10;
                }
                switch (var1_1.selectName(LottieCompositionMoshiParser.NAMES)) {
                    default: {
                        var24_16 = var7_7;
                        var25_17 = var8_8;
                        var0.skipName();
                        var0.skipValue();
                        ** GOTO lbl60
                    }
                    case 10: {
                        LottieCompositionMoshiParser.parseMarkers(var1_1, var10_10, (List<Marker>)var8_8);
                        ** GOTO lbl48
                    }
                    case 9: {
                        LottieCompositionMoshiParser.parseChars(var1_1, var10_10, (SparseArrayCompat<FontCharacter>)var9_9);
                        ** GOTO lbl48
                    }
                    case 8: {
                        LottieCompositionMoshiParser.parseFonts(var1_1, (Map<String, Font>)var7_7);
                        ** GOTO lbl48
                    }
                    case 7: {
                        LottieCompositionMoshiParser.parseAssets(var1_1, var10_10, (Map<String, List<Layer>>)var5_5, (Map<String, LottieImageAsset>)var6_6);
                        ** GOTO lbl48
                    }
                    case 6: {
                        LottieCompositionMoshiParser.parseLayers(var1_1, var10_10, (List<Layer>)var4_4, (LongSparseArray<Layer>)var3_3);
                        ** GOTO lbl48
                    }
                    case 5: {
                        var26_18 = var0.nextString().split("\\.");
                        if (!Utils.isAtLeastVersion(Integer.parseInt((String)var26_18[0]), Integer.parseInt((String)var26_18[1]), Integer.parseInt((String)var26_18[2]), 4, 4, 0)) {
                            var10_10.addWarning("Lottie only supports bodymovin >= 4.4.0");
                        }
lbl48: // 8 sources:
                        var24_16 = var7_7;
                        var25_17 = var8_8;
                        ** GOTO lbl60
                    }
                    case 4: {
                        var24_16 = var7_7;
                        var25_17 = var8_8;
                        var14_14 = (float)var0.nextDouble();
                        ** GOTO lbl60
                    }
                    case 3: {
                        var24_16 = var7_7;
                        var25_17 = var8_8;
                        var13_13 = (float)var0.nextDouble() - 0.01f;
lbl60: // 4 sources:
                        var7_7 = var24_16;
                        var8_8 = var25_17;
                        break block16;
                    }
                    case 2: {
                        var12_12 = (float)var0.nextDouble();
                        break block16;
                    }
                    case 1: {
                        var15_15 = var0.nextInt();
                        break block16;
                    }
                    case 0: 
                }
                var11_11 = var0.nextInt();
            }
            var1_1 = var0;
        } while (true);
    }

    private static void parseAssets(JsonReader jsonReader, LottieComposition lottieComposition, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String string2 = null;
            String string3 = null;
            String string4 = null;
            int n = 0;
            int n2 = 0;
            while (jsonReader.hasNext()) {
                int n3 = jsonReader.selectName(ASSETS_NAMES);
                if (n3 != 0) {
                    if (n3 != 1) {
                        if (n3 != 2) {
                            if (n3 != 3) {
                                if (n3 != 4) {
                                    if (n3 != 5) {
                                        jsonReader.skipName();
                                        jsonReader.skipValue();
                                        continue;
                                    }
                                    string4 = jsonReader.nextString();
                                    continue;
                                }
                                string3 = jsonReader.nextString();
                                continue;
                            }
                            n2 = jsonReader.nextInt();
                            continue;
                        }
                        n = jsonReader.nextInt();
                        continue;
                    }
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        Layer layer = LayerParser.parse(jsonReader, lottieComposition);
                        longSparseArray.put(layer.getId(), (Object)layer);
                        arrayList.add((Object)layer);
                    }
                    jsonReader.endArray();
                    continue;
                }
                string2 = jsonReader.nextString();
            }
            jsonReader.endObject();
            if (string3 != null) {
                LottieImageAsset lottieImageAsset = new LottieImageAsset(n, n2, string2, string3, string4);
                map2.put((Object)lottieImageAsset.getId(), (Object)lottieImageAsset);
                continue;
            }
            map.put(string2, (Object)arrayList);
        }
        jsonReader.endArray();
    }

    private static void parseChars(JsonReader jsonReader, LottieComposition lottieComposition, SparseArrayCompat<FontCharacter> sparseArrayCompat) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            FontCharacter fontCharacter = FontCharacterParser.parse(jsonReader, lottieComposition);
            sparseArrayCompat.put(fontCharacter.hashCode(), (Object)fontCharacter);
        }
        jsonReader.endArray();
    }

    private static void parseFonts(JsonReader jsonReader, Map<String, Font> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(FONT_NAMES) != 0) {
                jsonReader.skipName();
                jsonReader.skipValue();
                continue;
            }
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                Font font = FontParser.parse(jsonReader);
                map.put((Object)font.getName(), (Object)font);
            }
            jsonReader.endArray();
        }
        jsonReader.endObject();
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

    private static void parseMarkers(JsonReader jsonReader, LottieComposition lottieComposition, List<Marker> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            String string2 = null;
            jsonReader.beginObject();
            float f = 0.0f;
            float f2 = 0.0f;
            while (jsonReader.hasNext()) {
                int n = jsonReader.selectName(MARKER_NAMES);
                if (n != 0) {
                    if (n != 1) {
                        if (n != 2) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                            continue;
                        }
                        f2 = (float)jsonReader.nextDouble();
                        continue;
                    }
                    f = (float)jsonReader.nextDouble();
                    continue;
                }
                string2 = jsonReader.nextString();
            }
            jsonReader.endObject();
            list.add((Object)new Marker(string2, f, f2));
        }
        jsonReader.endArray();
    }
}

