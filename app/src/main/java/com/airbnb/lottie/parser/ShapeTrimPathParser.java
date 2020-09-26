/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  com.airbnb.lottie.model.content.ShapeTrimPath
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class ShapeTrimPathParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("s", "e", "o", "nm", "m", "hd");

    private ShapeTrimPathParser() {
    }

    static ShapeTrimPath parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String string2 = null;
        ShapeTrimPath.Type type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        boolean bl = false;
        while (jsonReader.hasNext()) {
            int n = jsonReader.selectName(NAMES);
            if (n != 0) {
                if (n != 1) {
                    if (n != 2) {
                        if (n != 3) {
                            if (n != 4) {
                                if (n != 5) {
                                    jsonReader.skipValue();
                                    continue;
                                }
                                bl = jsonReader.nextBoolean();
                                continue;
                            }
                            type = ShapeTrimPath.Type.forId(jsonReader.nextInt());
                            continue;
                        }
                        string2 = jsonReader.nextString();
                        continue;
                    }
                    animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    continue;
                }
                animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                continue;
            }
            animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
        }
        ShapeTrimPath shapeTrimPath = new ShapeTrimPath(string2, type, animatableFloatValue, animatableFloatValue2, animatableFloatValue3, bl);
        return shapeTrimPath;
    }
}

