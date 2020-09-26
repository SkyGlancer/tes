/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.animation.keyframe.PathKeyframe
 *  com.airbnb.lottie.parser.PathParser
 *  java.io.IOException
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.KeyframeParser;
import com.airbnb.lottie.parser.PathParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;

class PathKeyframeParser {
    private PathKeyframeParser() {
    }

    static PathKeyframe parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean bl = jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT;
        return new PathKeyframe(lottieComposition, KeyframeParser.parse(jsonReader, lottieComposition, Utils.dpScale(), PathParser.INSTANCE, bl));
    }
}

