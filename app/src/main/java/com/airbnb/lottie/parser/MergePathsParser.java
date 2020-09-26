/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.model.content.MergePaths
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class MergePathsParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "mm", "hd");

    private MergePathsParser() {
    }

    static MergePaths parse(JsonReader jsonReader) throws IOException {
        String string2 = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        boolean bl = false;
        while (jsonReader.hasNext()) {
            int n = jsonReader.selectName(NAMES);
            if (n != 0) {
                if (n != 1) {
                    if (n != 2) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        continue;
                    }
                    bl = jsonReader.nextBoolean();
                    continue;
                }
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.nextInt());
                continue;
            }
            string2 = jsonReader.nextString();
        }
        return new MergePaths(string2, mergePathsMode, bl);
    }
}

