/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.model.content.ShapeGroup
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.ContentModelParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FontCharacterParser {
    private static final JsonReader.Options DATA_NAMES;
    private static final JsonReader.Options NAMES;

    static {
        NAMES = JsonReader.Options.of("ch", "size", "w", "style", "fFamily", "data");
        DATA_NAMES = JsonReader.Options.of("shapes");
    }

    private FontCharacterParser() {
    }

    static FontCharacter parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        double d;
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        String string2 = null;
        String string3 = null;
        double d2 = d = 0.0;
        char c = '\u0000';
        while (jsonReader.hasNext()) {
            int n = jsonReader.selectName(NAMES);
            if (n != 0) {
                if (n != 1) {
                    if (n != 2) {
                        if (n != 3) {
                            if (n != 4) {
                                if (n != 5) {
                                    jsonReader.skipName();
                                    jsonReader.skipValue();
                                    continue;
                                }
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    if (jsonReader.selectName(DATA_NAMES) != 0) {
                                        jsonReader.skipName();
                                        jsonReader.skipValue();
                                        continue;
                                    }
                                    jsonReader.beginArray();
                                    while (jsonReader.hasNext()) {
                                        arrayList.add((Object)((ShapeGroup)ContentModelParser.parse(jsonReader, lottieComposition)));
                                    }
                                    jsonReader.endArray();
                                }
                                jsonReader.endObject();
                                continue;
                            }
                            string3 = jsonReader.nextString();
                            continue;
                        }
                        string2 = jsonReader.nextString();
                        continue;
                    }
                    d2 = jsonReader.nextDouble();
                    continue;
                }
                d = jsonReader.nextDouble();
                continue;
            }
            c = jsonReader.nextString().charAt(0);
        }
        jsonReader.endObject();
        FontCharacter fontCharacter = new FontCharacter((List<ShapeGroup>)arrayList, c, d, d2, string2, string3);
        return fontCharacter;
    }
}

