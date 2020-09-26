/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.JsonUtils;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class IntegerParser
implements ValueParser<Integer> {
    public static final IntegerParser INSTANCE = new IntegerParser();

    private IntegerParser() {
    }

    @Override
    public Integer parse(JsonReader jsonReader, float f) throws IOException {
        return Math.round((float)(f * JsonUtils.valueFromObject(jsonReader)));
    }
}

