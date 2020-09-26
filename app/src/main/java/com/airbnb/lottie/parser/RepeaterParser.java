/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  com.airbnb.lottie.model.animatable.AnimatableTransform
 *  com.airbnb.lottie.model.content.Repeater
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.parser.AnimatableTransformParser;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class RepeaterParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("nm", "c", "o", "tr", "hd");

    private RepeaterParser() {
    }

    static Repeater parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String string2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableTransform animatableTransform = null;
        boolean bl = false;
        while (jsonReader.hasNext()) {
            int n = jsonReader.selectName(NAMES);
            if (n != 0) {
                if (n != 1) {
                    if (n != 2) {
                        if (n != 3) {
                            if (n != 4) {
                                jsonReader.skipValue();
                                continue;
                            }
                            bl = jsonReader.nextBoolean();
                            continue;
                        }
                        animatableTransform = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                        continue;
                    }
                    animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    continue;
                }
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                continue;
            }
            string2 = jsonReader.nextString();
        }
        Repeater repeater = new Repeater(string2, animatableFloatValue, animatableFloatValue2, animatableTransform, bl);
        return repeater;
    }
}

