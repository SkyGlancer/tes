/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.model.animatable.AnimatableColorValue
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  com.airbnb.lottie.model.animatable.AnimatableGradientColorValue
 *  com.airbnb.lottie.model.animatable.AnimatableIntegerValue
 *  com.airbnb.lottie.model.animatable.AnimatablePointValue
 *  com.airbnb.lottie.model.animatable.AnimatableScaleValue
 *  com.airbnb.lottie.model.animatable.AnimatableShapeValue
 *  com.airbnb.lottie.model.animatable.AnimatableTextFrame
 *  com.airbnb.lottie.parser.ColorParser
 *  com.airbnb.lottie.parser.DocumentDataParser
 *  com.airbnb.lottie.parser.FloatParser
 *  com.airbnb.lottie.parser.GradientColorParser
 *  com.airbnb.lottie.parser.IntegerParser
 *  com.airbnb.lottie.parser.PointFParser
 *  com.airbnb.lottie.parser.ScaleXYParser
 *  com.airbnb.lottie.parser.ShapeDataParser
 *  java.io.IOException
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.parser.ColorParser;
import com.airbnb.lottie.parser.DocumentDataParser;
import com.airbnb.lottie.parser.FloatParser;
import com.airbnb.lottie.parser.GradientColorParser;
import com.airbnb.lottie.parser.IntegerParser;
import com.airbnb.lottie.parser.KeyframesParser;
import com.airbnb.lottie.parser.PointFParser;
import com.airbnb.lottie.parser.ScaleXYParser;
import com.airbnb.lottie.parser.ShapeDataParser;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.List;

public class AnimatableValueParser {
    private AnimatableValueParser() {
    }

    private static <T> List<Keyframe<T>> parse(JsonReader jsonReader, float f, LottieComposition lottieComposition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.parse(jsonReader, lottieComposition, f, valueParser);
    }

    private static <T> List<Keyframe<T>> parse(JsonReader jsonReader, LottieComposition lottieComposition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.parse(jsonReader, lottieComposition, 1.0f, valueParser);
    }

    static AnimatableColorValue parseColor(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableColorValue(AnimatableValueParser.parse(jsonReader, lottieComposition, ColorParser.INSTANCE));
    }

    static AnimatableTextFrame parseDocumentData(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableTextFrame(AnimatableValueParser.parse(jsonReader, lottieComposition, DocumentDataParser.INSTANCE));
    }

    public static AnimatableFloatValue parseFloat(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return AnimatableValueParser.parseFloat(jsonReader, lottieComposition, true);
    }

    public static AnimatableFloatValue parseFloat(JsonReader jsonReader, LottieComposition lottieComposition, boolean bl) throws IOException {
        float f = bl ? Utils.dpScale() : 1.0f;
        return new AnimatableFloatValue(AnimatableValueParser.parse(jsonReader, f, lottieComposition, FloatParser.INSTANCE));
    }

    static AnimatableGradientColorValue parseGradientColor(JsonReader jsonReader, LottieComposition lottieComposition, int n) throws IOException {
        return new AnimatableGradientColorValue(AnimatableValueParser.parse(jsonReader, lottieComposition, new GradientColorParser(n)));
    }

    static AnimatableIntegerValue parseInteger(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableIntegerValue(AnimatableValueParser.parse(jsonReader, lottieComposition, IntegerParser.INSTANCE));
    }

    static AnimatablePointValue parsePoint(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatablePointValue(AnimatableValueParser.parse(jsonReader, Utils.dpScale(), lottieComposition, PointFParser.INSTANCE));
    }

    static AnimatableScaleValue parseScale(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableScaleValue(AnimatableValueParser.parse(jsonReader, lottieComposition, ScaleXYParser.INSTANCE));
    }

    static AnimatableShapeValue parseShapeData(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableShapeValue(AnimatableValueParser.parse(jsonReader, Utils.dpScale(), lottieComposition, ShapeDataParser.INSTANCE));
    }
}

