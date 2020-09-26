/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;

public class ScaleXYParser
implements ValueParser<ScaleXY> {
    public static final ScaleXYParser INSTANCE = new ScaleXYParser();

    private ScaleXYParser() {
    }

    @Override
    public ScaleXY parse(JsonReader jsonReader, float f) throws IOException {
        boolean bl = jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY;
        if (bl) {
            jsonReader.beginArray();
        }
        float f2 = (float)jsonReader.nextDouble();
        float f3 = (float)jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (bl) {
            jsonReader.endArray();
        }
        return new ScaleXY(f * (f2 / 100.0f), f * (f3 / 100.0f));
    }
}

