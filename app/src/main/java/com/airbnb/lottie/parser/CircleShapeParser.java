/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  com.airbnb.lottie.model.animatable.AnimatablePointValue
 *  com.airbnb.lottie.model.content.CircleShape
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.parser.AnimatablePathValueParser;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class CircleShapeParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("nm", "p", "s", "hd", "d");

    private CircleShapeParser() {
    }

    static CircleShape parse(JsonReader jsonReader, LottieComposition lottieComposition, int n) throws IOException {
        boolean bl = n == 3;
        boolean bl2 = bl;
        String string2 = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        boolean bl3 = false;
        while (jsonReader.hasNext()) {
            int n2 = jsonReader.selectName(NAMES);
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            if (n2 != 4) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                                continue;
                            }
                            if (jsonReader.nextInt() == 3) {
                                bl2 = true;
                                continue;
                            }
                            bl2 = false;
                            continue;
                        }
                        bl3 = jsonReader.nextBoolean();
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
        CircleShape circleShape = new CircleShape(string2, animatableValue, animatablePointValue, bl2, bl3);
        return circleShape;
    }
}

