/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.view.animation.Interpolator
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  com.airbnb.lottie.model.animatable.AnimatableIntegerValue
 *  com.airbnb.lottie.model.animatable.AnimatablePathValue
 *  com.airbnb.lottie.model.animatable.AnimatableScaleValue
 *  com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue
 *  com.airbnb.lottie.model.animatable.AnimatableTransform
 *  java.io.IOException
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.AnimatablePathValueParser;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;
import java.util.List;

public class AnimatableTransformParser {
    private static JsonReader.Options ANIMATABLE_NAMES;
    private static JsonReader.Options NAMES;

    static {
        NAMES = JsonReader.Options.of("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");
        ANIMATABLE_NAMES = JsonReader.Options.of("k");
    }

    private AnimatableTransformParser() {
    }

    private static boolean isAnchorPointIdentity(AnimatablePathValue animatablePathValue) {
        boolean bl;
        block3 : {
            block2 : {
                if (animatablePathValue == null) break block2;
                boolean bl2 = animatablePathValue.isStatic();
                bl = false;
                if (!bl2) break block3;
                boolean bl3 = ((PointF)((Keyframe)animatablePathValue.getKeyframes().get((int)0)).startValue).equals(0.0f, 0.0f);
                bl = false;
                if (!bl3) break block3;
            }
            bl = true;
        }
        return bl;
    }

    private static boolean isPositionIdentity(AnimatableValue<PointF, PointF> animatableValue) {
        boolean bl;
        block3 : {
            block2 : {
                if (animatableValue == null) break block2;
                boolean bl2 = animatableValue instanceof AnimatableSplitDimensionPathValue;
                bl = false;
                if (bl2) break block3;
                boolean bl3 = animatableValue.isStatic();
                bl = false;
                if (!bl3) break block3;
                boolean bl4 = ((PointF)((Keyframe)animatableValue.getKeyframes().get((int)0)).startValue).equals(0.0f, 0.0f);
                bl = false;
                if (!bl4) break block3;
            }
            bl = true;
        }
        return bl;
    }

    private static boolean isRotationIdentity(AnimatableFloatValue animatableFloatValue) {
        boolean bl;
        block3 : {
            block2 : {
                if (animatableFloatValue == null) break block2;
                boolean bl2 = animatableFloatValue.isStatic();
                bl = false;
                if (!bl2) break block3;
                float f = ((Float)((Keyframe)animatableFloatValue.getKeyframes().get((int)0)).startValue).floatValue() FCMPL 0.0f;
                bl = false;
                if (f != false) break block3;
            }
            bl = true;
        }
        return bl;
    }

    private static boolean isScaleIdentity(AnimatableScaleValue animatableScaleValue) {
        boolean bl;
        block3 : {
            block2 : {
                if (animatableScaleValue == null) break block2;
                boolean bl2 = animatableScaleValue.isStatic();
                bl = false;
                if (!bl2) break block3;
                boolean bl3 = ((ScaleXY)((Keyframe)animatableScaleValue.getKeyframes().get((int)0)).startValue).equals(1.0f, 1.0f);
                bl = false;
                if (!bl3) break block3;
            }
            bl = true;
        }
        return bl;
    }

    private static boolean isSkewAngleIdentity(AnimatableFloatValue animatableFloatValue) {
        boolean bl;
        block3 : {
            block2 : {
                if (animatableFloatValue == null) break block2;
                boolean bl2 = animatableFloatValue.isStatic();
                bl = false;
                if (!bl2) break block3;
                float f = ((Float)((Keyframe)animatableFloatValue.getKeyframes().get((int)0)).startValue).floatValue() FCMPL 0.0f;
                bl = false;
                if (f != false) break block3;
            }
            bl = true;
        }
        return bl;
    }

    private static boolean isSkewIdentity(AnimatableFloatValue animatableFloatValue) {
        boolean bl;
        block3 : {
            block2 : {
                if (animatableFloatValue == null) break block2;
                boolean bl2 = animatableFloatValue.isStatic();
                bl = false;
                if (!bl2) break block3;
                float f = ((Float)((Keyframe)animatableFloatValue.getKeyframes().get((int)0)).startValue).floatValue() FCMPL 0.0f;
                bl = false;
                if (f != false) break block3;
            }
            bl = true;
        }
        return bl;
    }

    public static AnimatableTransform parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean bl = jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT;
        if (bl) {
            jsonReader.beginObject();
        }
        AnimatableFloatValue animatableFloatValue = null;
        AnimatablePathValue animatablePathValue = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatableScaleValue animatableScaleValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatableFloatValue animatableFloatValue4 = null;
        AnimatableFloatValue animatableFloatValue5 = null;
        block12 : while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                default: {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue block12;
                }
                case 9: {
                    animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    continue block12;
                }
                case 8: {
                    animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    continue block12;
                }
                case 7: {
                    animatableFloatValue5 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    continue block12;
                }
                case 6: {
                    animatableFloatValue4 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    continue block12;
                }
                case 5: {
                    animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    continue block12;
                }
                case 3: {
                    lottieComposition.addWarning("Lottie doesn't support 3D layers.");
                }
                case 4: {
                    AnimatableFloatValue animatableFloatValue6 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    if (animatableFloatValue6.getKeyframes().isEmpty()) {
                        List list = animatableFloatValue6.getKeyframes();
                        Keyframe<Float> keyframe = new Keyframe<Float>(lottieComposition, Float.valueOf((float)0.0f), Float.valueOf((float)0.0f), null, 0.0f, Float.valueOf((float)lottieComposition.getEndFrame()));
                        list.add(keyframe);
                    } else if (((Keyframe)animatableFloatValue6.getKeyframes().get((int)0)).startValue == null) {
                        List list = animatableFloatValue6.getKeyframes();
                        Keyframe<Float> keyframe = new Keyframe<Float>(lottieComposition, Float.valueOf((float)0.0f), Float.valueOf((float)0.0f), null, 0.0f, Float.valueOf((float)lottieComposition.getEndFrame()));
                        list.set(0, keyframe);
                    }
                    animatableFloatValue = animatableFloatValue6;
                    continue block12;
                }
                case 2: {
                    animatableScaleValue = AnimatableValueParser.parseScale(jsonReader, lottieComposition);
                    continue block12;
                }
                case 1: {
                    animatableValue = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
                    continue block12;
                }
                case 0: 
            }
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.selectName(ANIMATABLE_NAMES) != 0) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue;
                }
                animatablePathValue = AnimatablePathValueParser.parse(jsonReader, lottieComposition);
            }
            jsonReader.endObject();
        }
        if (bl) {
            jsonReader.endObject();
        }
        AnimatablePathValue animatablePathValue2 = AnimatableTransformParser.isAnchorPointIdentity(animatablePathValue) ? null : animatablePathValue;
        AnimatableValue<PointF, PointF> animatableValue2 = AnimatableTransformParser.isPositionIdentity(animatableValue) ? null : animatableValue;
        AnimatableFloatValue animatableFloatValue7 = AnimatableTransformParser.isRotationIdentity(animatableFloatValue) ? null : animatableFloatValue;
        if (AnimatableTransformParser.isScaleIdentity(animatableScaleValue)) {
            animatableScaleValue = null;
        }
        AnimatableFloatValue animatableFloatValue8 = AnimatableTransformParser.isSkewIdentity(animatableFloatValue2) ? null : animatableFloatValue2;
        AnimatableFloatValue animatableFloatValue9 = AnimatableTransformParser.isSkewAngleIdentity(animatableFloatValue3) ? null : animatableFloatValue3;
        AnimatableTransform animatableTransform = new AnimatableTransform(animatablePathValue2, animatableValue2, animatableScaleValue, animatableFloatValue7, animatableIntegerValue, animatableFloatValue4, animatableFloatValue5, animatableFloatValue8, animatableFloatValue9);
        return animatableTransform;
    }
}

