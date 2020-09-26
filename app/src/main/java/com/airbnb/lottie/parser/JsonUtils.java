/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  android.graphics.PointF
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class JsonUtils {
    private static final JsonReader.Options POINT_NAMES = JsonReader.Options.of("x", "y");

    private JsonUtils() {
    }

    private static PointF jsonArrayToPoint(JsonReader jsonReader, float f) throws IOException {
        jsonReader.beginArray();
        float f2 = (float)jsonReader.nextDouble();
        float f3 = (float)jsonReader.nextDouble();
        while (jsonReader.peek() != JsonReader.Token.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(f2 * f, f3 * f);
    }

    private static PointF jsonNumbersToPoint(JsonReader jsonReader, float f) throws IOException {
        float f2 = (float)jsonReader.nextDouble();
        float f3 = (float)jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(f2 * f, f3 * f);
    }

    private static PointF jsonObjectToPoint(JsonReader jsonReader, float f) throws IOException {
        jsonReader.beginObject();
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (jsonReader.hasNext()) {
            int n = jsonReader.selectName(POINT_NAMES);
            if (n != 0) {
                if (n != 1) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue;
                }
                f3 = JsonUtils.valueFromObject(jsonReader);
                continue;
            }
            f2 = JsonUtils.valueFromObject(jsonReader);
        }
        jsonReader.endObject();
        return new PointF(f2 * f, f3 * f);
    }

    static int jsonToColor(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        int n = (int)(255.0 * jsonReader.nextDouble());
        int n2 = (int)(255.0 * jsonReader.nextDouble());
        int n3 = (int)(255.0 * jsonReader.nextDouble());
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb((int)255, (int)n, (int)n2, (int)n3);
    }

    static PointF jsonToPoint(JsonReader jsonReader, float f) throws IOException {
        int n = 1.$SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[jsonReader.peek().ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n == 3) {
                    return JsonUtils.jsonObjectToPoint(jsonReader, f);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown point starts with ");
                stringBuilder.append((Object)jsonReader.peek());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            return JsonUtils.jsonArrayToPoint(jsonReader, f);
        }
        return JsonUtils.jsonNumbersToPoint(jsonReader, f);
    }

    static List<PointF> jsonToPoints(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add((Object)JsonUtils.jsonToPoint(jsonReader, f));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    static float valueFromObject(JsonReader jsonReader) throws IOException {
        JsonReader.Token token = jsonReader.peek();
        int n = 1.$SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[token.ordinal()];
        if (n != 1) {
            if (n == 2) {
                jsonReader.beginArray();
                float f = (float)jsonReader.nextDouble();
                while (jsonReader.hasNext()) {
                    jsonReader.skipValue();
                }
                jsonReader.endArray();
                return f;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown value for token of type ");
            stringBuilder.append((Object)token);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return (float)jsonReader.nextDouble();
    }

}

