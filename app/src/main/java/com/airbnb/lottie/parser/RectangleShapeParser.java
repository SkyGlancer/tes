/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  com.airbnb.lottie.model.animatable.AnimatablePointValue
 *  com.airbnb.lottie.model.content.RectangleShape
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.parser.AnimatablePathValueParser;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class RectangleShapeParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("nm", "p", "s", "r", "hd");

    private RectangleShapeParser() {
    }

    static RectangleShape parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String string2 = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatableFloatValue animatableFloatValue = null;
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
                        animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                        continue;
                    }
                    animatablePointValue = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    continue;
                }
                animatableValue = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
                continue;
            }
            string2 = jsonReader.nextString();
        }
        RectangleShape rectangleShape = new RectangleShape(string2, animatableValue, animatablePointValue, animatableFloatValue, bl);
        return rectangleShape;
    }
}

