/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.animation.keyframe.PathKeyframe
 *  java.io.IOException
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.KeyframeParser;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class KeyframesParser {
    static JsonReader.Options NAMES = JsonReader.Options.of("k");

    private KeyframesParser() {
    }

    static <T> List<Keyframe<T>> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser<T> valueParser) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonReader.Token.STRING) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(NAMES) != 0) {
                jsonReader.skipValue();
                continue;
            }
            if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonReader.Token.NUMBER) {
                    arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f, valueParser, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f, valueParser, true));
                    }
                }
                jsonReader.endArray();
                continue;
            }
            arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f, valueParser, false));
        }
        jsonReader.endObject();
        KeyframesParser.setEndFrames(arrayList);
        return arrayList;
    }

    public static <T> void setEndFrames(List<? extends Keyframe<T>> list) {
        int n;
        int n2 = list.size();
        int n3 = 0;
        while (n3 < (n = n2 - 1)) {
            Keyframe keyframe = (Keyframe)list.get(n3);
            Keyframe keyframe2 = (Keyframe)list.get(++n3);
            keyframe.endFrame = Float.valueOf((float)keyframe2.startFrame);
            if (keyframe.endValue != null || keyframe2.startValue == null) continue;
            keyframe.endValue = keyframe2.startValue;
            if (!(keyframe instanceof PathKeyframe)) continue;
            ((PathKeyframe)keyframe).createPath();
        }
        Keyframe keyframe = (Keyframe)list.get(n);
        if ((keyframe.startValue == null || keyframe.endValue == null) && list.size() > 1) {
            list.remove((Object)keyframe);
        }
    }
}

