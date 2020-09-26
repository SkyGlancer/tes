/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  com.airbnb.lottie.model.animatable.AnimatableGradientColorValue
 *  com.airbnb.lottie.model.animatable.AnimatableIntegerValue
 *  com.airbnb.lottie.model.animatable.AnimatablePointValue
 *  com.airbnb.lottie.model.content.GradientFill
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class GradientFillParser {
    private static final JsonReader.Options GRADIENT_NAMES;
    private static final JsonReader.Options NAMES;

    static {
        NAMES = JsonReader.Options.of("nm", "g", "o", "t", "s", "e", "r", "hd");
        GRADIENT_NAMES = JsonReader.Options.of("p", "k");
    }

    private GradientFillParser() {
    }

    static GradientFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        Path.FillType fillType = Path.FillType.WINDING;
        String string2 = null;
        GradientType gradientType = null;
        AnimatableGradientColorValue animatableGradientColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        boolean bl = false;
        block10 : while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                default: {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue block10;
                }
                case 7: {
                    bl = jsonReader.nextBoolean();
                    continue block10;
                }
                case 6: {
                    Path.FillType fillType2 = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    fillType = fillType2;
                    continue block10;
                }
                case 5: {
                    animatablePointValue2 = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    continue block10;
                }
                case 4: {
                    animatablePointValue = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    continue block10;
                }
                case 3: {
                    GradientType gradientType2 = jsonReader.nextInt() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    gradientType = gradientType2;
                    continue block10;
                }
                case 2: {
                    animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    continue block10;
                }
                case 1: {
                    int n = -1;
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        int n2 = jsonReader.selectName(GRADIENT_NAMES);
                        if (n2 != 0) {
                            if (n2 != 1) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                                continue;
                            }
                            animatableGradientColorValue = AnimatableValueParser.parseGradientColor(jsonReader, lottieComposition, n);
                            continue;
                        }
                        n = jsonReader.nextInt();
                    }
                    jsonReader.endObject();
                    continue block10;
                }
                case 0: 
            }
            string2 = jsonReader.nextString();
        }
        GradientFill gradientFill = new GradientFill(string2, gradientType, fillType, animatableGradientColorValue, animatableIntegerValue, animatablePointValue, animatablePointValue2, null, null, bl);
        return gradientFill;
    }
}

