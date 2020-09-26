/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class ColorParser
implements ValueParser<Integer> {
    public static final ColorParser INSTANCE = new ColorParser();

    private ColorParser() {
    }

    @Override
    public Integer parse(JsonReader jsonReader, float f) throws IOException {
        boolean bl = jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY;
        if (bl) {
            jsonReader.beginArray();
        }
        double d = jsonReader.nextDouble();
        double d2 = jsonReader.nextDouble();
        double d3 = jsonReader.nextDouble();
        double d4 = jsonReader.nextDouble();
        if (bl) {
            jsonReader.endArray();
        }
        if (d <= 1.0 && d2 <= 1.0 && d3 <= 1.0) {
            d *= 255.0;
            d2 *= 255.0;
            d3 *= 255.0;
            if (d4 <= 1.0) {
                d4 *= 255.0;
            }
        }
        return Color.argb((int)((int)d4), (int)((int)d), (int)((int)d2), (int)((int)d3));
    }
}

