/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  android.graphics.Rect
 *  android.view.animation.Interpolator
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  com.airbnb.lottie.model.animatable.AnimatableTextFrame
 *  com.airbnb.lottie.model.animatable.AnimatableTransform
 *  java.io.IOException
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.AnimatableTextPropertiesParser;
import com.airbnb.lottie.parser.AnimatableTransformParser;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.ContentModelParser;
import com.airbnb.lottie.parser.MaskParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LayerParser {
    private static final JsonReader.Options EFFECTS_NAMES;
    private static final JsonReader.Options NAMES;
    private static final JsonReader.Options TEXT_NAMES;

    static {
        NAMES = JsonReader.Options.of("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");
        TEXT_NAMES = JsonReader.Options.of("d", "a");
        EFFECTS_NAMES = JsonReader.Options.of("nm");
    }

    private LayerParser() {
    }

    public static Layer parse(LottieComposition lottieComposition) {
        Rect rect = lottieComposition.getBounds();
        Layer layer = new Layer((List<ContentModel>)Collections.emptyList(), lottieComposition, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, (List<Mask>)Collections.emptyList(), new AnimatableTransform(), 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), null, null, (List<Keyframe<Float>>)Collections.emptyList(), Layer.MatteType.NONE, null, false);
        return layer;
    }

    public static Layer parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.beginObject();
        Float f = Float.valueOf((float)1.0f);
        Float f2 = Float.valueOf((float)0.0f);
        Layer.MatteType matteType2 = matteType;
        Layer.LayerType layerType = null;
        String string2 = null;
        AnimatableTransform animatableTransform = null;
        AnimatableTextFrame animatableTextFrame = null;
        AnimatableTextProperties animatableTextProperties = null;
        AnimatableFloatValue animatableFloatValue = null;
        long l = -1L;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        float f5 = 1.0f;
        float f6 = 0.0f;
        int n4 = 0;
        int n5 = 0;
        boolean bl = false;
        long l2 = 0L;
        String string3 = null;
        String string4 = "UNSET";
        block25 : while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                default: {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue block25;
                }
                case 22: {
                    bl = jsonReader.nextBoolean();
                    continue block25;
                }
                case 21: {
                    string3 = jsonReader.nextString();
                    continue block25;
                }
                case 20: {
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    continue block25;
                }
                case 19: {
                    f4 = (float)jsonReader.nextDouble();
                    continue block25;
                }
                case 18: {
                    f3 = (float)jsonReader.nextDouble();
                    continue block25;
                }
                case 17: {
                    n5 = (int)((float)jsonReader.nextInt() * Utils.dpScale());
                    continue block25;
                }
                case 16: {
                    n4 = (int)((float)jsonReader.nextInt() * Utils.dpScale());
                    continue block25;
                }
                case 15: {
                    f6 = (float)jsonReader.nextDouble();
                    continue block25;
                }
                case 14: {
                    f5 = (float)jsonReader.nextDouble();
                    continue block25;
                }
                case 13: {
                    jsonReader.beginArray();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            if (jsonReader.selectName(EFFECTS_NAMES) != 0) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                                continue;
                            }
                            arrayList5.add((Object)jsonReader.nextString());
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ");
                    stringBuilder.append((Object)arrayList5);
                    lottieComposition.addWarning(stringBuilder.toString());
                    continue block25;
                }
                case 12: {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        int n6 = jsonReader.selectName(TEXT_NAMES);
                        if (n6 != 0) {
                            if (n6 != 1) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                                continue;
                            }
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                animatableTextProperties = AnimatableTextPropertiesParser.parse(jsonReader, lottieComposition);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                            continue;
                        }
                        animatableTextFrame = AnimatableValueParser.parseDocumentData(jsonReader, lottieComposition);
                    }
                    jsonReader.endObject();
                    continue block25;
                }
                case 11: {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        ContentModel contentModel = ContentModelParser.parse(jsonReader, lottieComposition);
                        if (contentModel == null) continue;
                        arrayList4.add((Object)contentModel);
                    }
                    jsonReader.endArray();
                    continue block25;
                }
                case 10: {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList3.add((Object)MaskParser.parse(jsonReader, lottieComposition));
                    }
                    lottieComposition.incrementMatteOrMaskCount(arrayList3.size());
                    jsonReader.endArray();
                    continue block25;
                }
                case 9: {
                    matteType2 = Layer.MatteType.values()[jsonReader.nextInt()];
                    lottieComposition.incrementMatteOrMaskCount(1);
                    continue block25;
                }
                case 8: {
                    animatableTransform = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                    continue block25;
                }
                case 7: {
                    n3 = Color.parseColor((String)jsonReader.nextString());
                    continue block25;
                }
                case 6: {
                    n2 = (int)((float)jsonReader.nextInt() * Utils.dpScale());
                    continue block25;
                }
                case 5: {
                    n = (int)((float)jsonReader.nextInt() * Utils.dpScale());
                    continue block25;
                }
                case 4: {
                    l = jsonReader.nextInt();
                    continue block25;
                }
                case 3: {
                    int n7 = jsonReader.nextInt();
                    if (n7 < Layer.LayerType.UNKNOWN.ordinal()) {
                        layerType = Layer.LayerType.values()[n7];
                        continue block25;
                    }
                    layerType = Layer.LayerType.UNKNOWN;
                    continue block25;
                }
                case 2: {
                    string2 = jsonReader.nextString();
                    continue block25;
                }
                case 1: {
                    l2 = jsonReader.nextInt();
                    continue block25;
                }
                case 0: 
            }
            string4 = jsonReader.nextString();
        }
        jsonReader.endObject();
        float f7 = f3 / f5;
        float f8 = f4 / f5;
        ArrayList arrayList6 = new ArrayList();
        if (f7 > 0.0f) {
            Float f9 = Float.valueOf((float)f7);
            arrayList2 = arrayList3;
            arrayList = arrayList6;
            Keyframe<Float> keyframe = new Keyframe<Float>(lottieComposition, f2, f2, null, 0.0f, f9);
            arrayList.add(keyframe);
        } else {
            arrayList2 = arrayList3;
            arrayList = arrayList6;
        }
        if (!(f8 > 0.0f)) {
            f8 = lottieComposition.getEndFrame();
        }
        Keyframe<Float> keyframe = new Keyframe<Float>(lottieComposition, f, f, null, f7, Float.valueOf((float)f8));
        arrayList.add(keyframe);
        Float f10 = Float.valueOf((float)Float.MAX_VALUE);
        Keyframe<Float> keyframe2 = new Keyframe<Float>(lottieComposition, f2, f2, null, f8, f10);
        arrayList.add(keyframe2);
        if (string4.endsWith(".ai") || "ai".equals((Object)string3)) {
            lottieComposition.addWarning("Convert your Illustrator layers to shape layers.");
        }
        String string5 = string4;
        long l3 = l2;
        Layer.LayerType layerType2 = layerType;
        long l4 = l;
        String string6 = string2;
        ArrayList arrayList7 = arrayList;
        Layer layer = new Layer((List<ContentModel>)arrayList4, lottieComposition, string5, l3, layerType2, l4, string6, (List<Mask>)arrayList2, animatableTransform, n, n2, n3, f5, f6, n4, n5, animatableTextFrame, animatableTextProperties, (List<Keyframe<Float>>)arrayList7, matteType2, animatableFloatValue, bl);
        return layer;
    }
}

