/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class FontParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("fFamily", "fName", "fStyle", "ascent");

    private FontParser() {
    }

    static Font parse(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String string2 = null;
        String string3 = null;
        String string4 = null;
        float f = 0.0f;
        while (jsonReader.hasNext()) {
            int n = jsonReader.selectName(NAMES);
            if (n != 0) {
                if (n != 1) {
                    if (n != 2) {
                        if (n != 3) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                            continue;
                        }
                        f = (float)jsonReader.nextDouble();
                        continue;
                    }
                    string4 = jsonReader.nextString();
                    continue;
                }
                string3 = jsonReader.nextString();
                continue;
            }
            string2 = jsonReader.nextString();
        }
        jsonReader.endObject();
        return new Font(string2, string3, string4, f);
    }
}

