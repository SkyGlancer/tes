/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.JsonUtils;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class DocumentDataParser
implements ValueParser<DocumentData> {
    public static final DocumentDataParser INSTANCE = new DocumentDataParser();
    private static final JsonReader.Options NAMES = JsonReader.Options.of("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private DocumentDataParser() {
    }

    @Override
    public DocumentData parse(JsonReader jsonReader, float f) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.beginObject();
        DocumentData.Justification justification2 = justification;
        String string2 = null;
        String string3 = null;
        float f2 = 0.0f;
        int n = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int n2 = 0;
        int n3 = 0;
        float f5 = 0.0f;
        boolean bl = true;
        block13 : while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                default: {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue block13;
                }
                case 10: {
                    bl = jsonReader.nextBoolean();
                    continue block13;
                }
                case 9: {
                    f5 = (float)jsonReader.nextDouble();
                    continue block13;
                }
                case 8: {
                    n3 = JsonUtils.jsonToColor(jsonReader);
                    continue block13;
                }
                case 7: {
                    n2 = JsonUtils.jsonToColor(jsonReader);
                    continue block13;
                }
                case 6: {
                    f4 = (float)jsonReader.nextDouble();
                    continue block13;
                }
                case 5: {
                    f3 = (float)jsonReader.nextDouble();
                    continue block13;
                }
                case 4: {
                    n = jsonReader.nextInt();
                    continue block13;
                }
                case 3: {
                    int n4 = jsonReader.nextInt();
                    if (n4 <= DocumentData.Justification.CENTER.ordinal() && n4 >= 0) {
                        justification2 = DocumentData.Justification.values()[n4];
                        continue block13;
                    }
                    justification2 = DocumentData.Justification.CENTER;
                    continue block13;
                }
                case 2: {
                    f2 = (float)jsonReader.nextDouble();
                    continue block13;
                }
                case 1: {
                    string3 = jsonReader.nextString();
                    continue block13;
                }
                case 0: 
            }
            string2 = jsonReader.nextString();
        }
        jsonReader.endObject();
        DocumentData documentData = new DocumentData(string2, string3, f2, justification2, n, f3, f4, n2, n3, f5, bl);
        return documentData;
    }
}

