/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.JsonUtils;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class PointFParser
implements ValueParser<PointF> {
    public static final PointFParser INSTANCE = new PointFParser();

    private PointFParser() {
    }

    @Override
    public PointF parse(JsonReader jsonReader, float f) throws IOException {
        IllegalArgumentException illegalArgumentException;
        JsonReader.Token token = jsonReader.peek();
        if (token == JsonReader.Token.BEGIN_ARRAY) {
            return JsonUtils.jsonToPoint(jsonReader, f);
        }
        if (token == JsonReader.Token.BEGIN_OBJECT) {
            return JsonUtils.jsonToPoint(jsonReader, f);
        }
        if (token == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(f * (float)jsonReader.nextDouble(), f * (float)jsonReader.nextDouble());
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot convert json to point. Next token is ");
        stringBuilder.append((Object)token);
        illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }
}

