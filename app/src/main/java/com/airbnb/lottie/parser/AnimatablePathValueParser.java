/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  com.airbnb.lottie.model.animatable.AnimatablePathValue
 *  com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.JsonUtils;
import com.airbnb.lottie.parser.KeyframesParser;
import com.airbnb.lottie.parser.PathKeyframeParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimatablePathValueParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("k", "x", "y");

    private AnimatablePathValueParser() {
    }

    public static AnimatablePathValue parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add((Object)PathKeyframeParser.parse(jsonReader, lottieComposition));
            }
            jsonReader.endArray();
            KeyframesParser.setEndFrames(arrayList);
        } else {
            arrayList.add(new Keyframe<PointF>(JsonUtils.jsonToPoint(jsonReader, Utils.dpScale())));
        }
        return new AnimatablePathValue((List)arrayList);
    }

    static AnimatableValue<PointF, PointF> parseSplitPath(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatablePathValue animatablePathValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        boolean bl = false;
        while (jsonReader.peek() != JsonReader.Token.END_OBJECT) {
            block7 : {
                block11 : {
                    block10 : {
                        block8 : {
                            block9 : {
                                int n = jsonReader.selectName(NAMES);
                                if (n == 0) break block7;
                                if (n == 1) break block8;
                                if (n != 2) {
                                    jsonReader.skipName();
                                    jsonReader.skipValue();
                                    continue;
                                }
                                if (jsonReader.peek() != JsonReader.Token.STRING) break block9;
                                jsonReader.skipValue();
                                break block10;
                            }
                            animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                            continue;
                        }
                        if (jsonReader.peek() != JsonReader.Token.STRING) break block11;
                        jsonReader.skipValue();
                    }
                    bl = true;
                    continue;
                }
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                continue;
            }
            animatablePathValue = AnimatablePathValueParser.parse(jsonReader, lottieComposition);
        }
        jsonReader.endObject();
        if (bl) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
        }
        if (animatablePathValue != null) {
            return animatablePathValue;
        }
        return new AnimatableSplitDimensionPathValue(animatableFloatValue, animatableFloatValue2);
    }
}

