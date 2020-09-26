/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Float
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.JsonUtils;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class FloatParser
implements ValueParser<Float> {
    public static final FloatParser INSTANCE = new FloatParser();

    private FloatParser() {
    }

    @Override
    public Float parse(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf((float)(f * JsonUtils.valueFromObject(jsonReader)));
    }
}

