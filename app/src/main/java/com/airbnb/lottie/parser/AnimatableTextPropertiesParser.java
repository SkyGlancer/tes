/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.model.animatable.AnimatableColorValue
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  java.io.IOException
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class AnimatableTextPropertiesParser {
    private static JsonReader.Options ANIMATABLE_PROPERTIES_NAMES;
    private static JsonReader.Options PROPERTIES_NAMES;

    static {
        PROPERTIES_NAMES = JsonReader.Options.of("a");
        ANIMATABLE_PROPERTIES_NAMES = JsonReader.Options.of("fc", "sc", "sw", "t");
    }

    private AnimatableTextPropertiesParser() {
    }

    public static AnimatableTextProperties parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatableTextProperties animatableTextProperties = null;
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(PROPERTIES_NAMES) != 0) {
                jsonReader.skipName();
                jsonReader.skipValue();
                continue;
            }
            animatableTextProperties = AnimatableTextPropertiesParser.parseAnimatableTextProperties(jsonReader, lottieComposition);
        }
        jsonReader.endObject();
        if (animatableTextProperties == null) {
            return new AnimatableTextProperties(null, null, null, null);
        }
        return animatableTextProperties;
    }

    private static AnimatableTextProperties parseAnimatableTextProperties(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatableColorValue animatableColorValue = null;
        AnimatableColorValue animatableColorValue2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        while (jsonReader.hasNext()) {
            int n = jsonReader.selectName(ANIMATABLE_PROPERTIES_NAMES);
            if (n != 0) {
                if (n != 1) {
                    if (n != 2) {
                        if (n != 3) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                            continue;
                        }
                        animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                        continue;
                    }
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    continue;
                }
                animatableColorValue2 = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
                continue;
            }
            animatableColorValue = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
        }
        jsonReader.endObject();
        return new AnimatableTextProperties(animatableColorValue, animatableColorValue2, animatableFloatValue, animatableFloatValue2);
    }
}

