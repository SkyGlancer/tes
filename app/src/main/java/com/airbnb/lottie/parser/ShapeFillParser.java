/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  com.airbnb.lottie.model.animatable.AnimatableColorValue
 *  com.airbnb.lottie.model.animatable.AnimatableIntegerValue
 *  com.airbnb.lottie.model.content.ShapeFill
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class ShapeFillParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "c", "o", "fillEnabled", "r", "hd");

    private ShapeFillParser() {
    }

    static ShapeFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String string2 = null;
        AnimatableColorValue animatableColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        int n = 1;
        boolean bl = false;
        boolean bl2 = false;
        while (jsonReader.hasNext()) {
            int n2 = jsonReader.selectName(NAMES);
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            if (n2 != 4) {
                                if (n2 != 5) {
                                    jsonReader.skipName();
                                    jsonReader.skipValue();
                                    continue;
                                }
                                bl2 = jsonReader.nextBoolean();
                                continue;
                            }
                            n = jsonReader.nextInt();
                            continue;
                        }
                        bl = jsonReader.nextBoolean();
                        continue;
                    }
                    animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    continue;
                }
                animatableColorValue = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
                continue;
            }
            string2 = jsonReader.nextString();
        }
        Path.FillType fillType = n == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
        Path.FillType fillType2 = fillType;
        ShapeFill shapeFill = new ShapeFill(string2, bl, fillType2, animatableColorValue, animatableIntegerValue, bl2);
        return shapeFill;
    }
}

