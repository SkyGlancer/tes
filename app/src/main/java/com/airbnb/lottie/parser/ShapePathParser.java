/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.model.animatable.AnimatableShapeValue
 *  com.airbnb.lottie.model.content.ShapePath
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class ShapePathParser {
    static JsonReader.Options NAMES = JsonReader.Options.of("nm", "ind", "ks", "hd");

    private ShapePathParser() {
    }

    static ShapePath parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        int n = 0;
        String string2 = null;
        AnimatableShapeValue animatableShapeValue = null;
        boolean bl = false;
        while (jsonReader.hasNext()) {
            int n2 = jsonReader.selectName(NAMES);
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            jsonReader.skipValue();
                            continue;
                        }
                        bl = jsonReader.nextBoolean();
                        continue;
                    }
                    animatableShapeValue = AnimatableValueParser.parseShapeData(jsonReader, lottieComposition);
                    continue;
                }
                n = jsonReader.nextInt();
                continue;
            }
            string2 = jsonReader.nextString();
        }
        return new ShapePath(string2, n, animatableShapeValue, bl);
    }
}

