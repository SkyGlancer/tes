/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.model.content.MergePaths
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.AnimatableTransformParser;
import com.airbnb.lottie.parser.CircleShapeParser;
import com.airbnb.lottie.parser.GradientFillParser;
import com.airbnb.lottie.parser.GradientStrokeParser;
import com.airbnb.lottie.parser.MergePathsParser;
import com.airbnb.lottie.parser.PolystarShapeParser;
import com.airbnb.lottie.parser.RectangleShapeParser;
import com.airbnb.lottie.parser.RepeaterParser;
import com.airbnb.lottie.parser.ShapeFillParser;
import com.airbnb.lottie.parser.ShapeGroupParser;
import com.airbnb.lottie.parser.ShapePathParser;
import com.airbnb.lottie.parser.ShapeStrokeParser;
import com.airbnb.lottie.parser.ShapeTrimPathParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;

class ContentModelParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("ty", "d");

    private ContentModelParser() {
    }

    static ContentModel parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        int n;
        MergePaths mergePaths;
        String string2;
        int n2;
        block36 : {
            block35 : {
                jsonReader.beginObject();
                n = 2;
                n2 = 2;
                while (jsonReader.hasNext()) {
                    int n3 = jsonReader.selectName(NAMES);
                    if (n3 != 0) {
                        if (n3 != 1) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                            continue;
                        }
                        n2 = jsonReader.nextInt();
                        continue;
                    }
                    string2 = jsonReader.nextString();
                    break block35;
                }
                string2 = null;
            }
            if (string2 == null) {
                return null;
            }
            switch (string2.hashCode()) {
                default: {
                    break;
                }
                case 3710: {
                    if (!string2.equals((Object)"tr")) break;
                    n = 5;
                    break block36;
                }
                case 3705: {
                    if (!string2.equals((Object)"tm")) break;
                    n = 9;
                    break block36;
                }
                case 3681: {
                    if (!string2.equals((Object)"st")) break;
                    n = 1;
                    break block36;
                }
                case 3679: {
                    if (!string2.equals((Object)"sr")) break;
                    n = 10;
                    break block36;
                }
                case 3669: {
                    if (!string2.equals((Object)"sh")) break;
                    n = 6;
                    break block36;
                }
                case 3646: {
                    if (!string2.equals((Object)"rp")) break;
                    n = 12;
                    break block36;
                }
                case 3633: {
                    if (!string2.equals((Object)"rc")) break;
                    n = 8;
                    break block36;
                }
                case 3488: {
                    if (!string2.equals((Object)"mm")) break;
                    n = 11;
                    break block36;
                }
                case 3308: {
                    if (!string2.equals((Object)"gs")) break;
                    break block36;
                }
                case 3307: {
                    if (!string2.equals((Object)"gr")) break;
                    n = 0;
                    break block36;
                }
                case 3295: {
                    if (!string2.equals((Object)"gf")) break;
                    n = 4;
                    break block36;
                }
                case 3270: {
                    if (!string2.equals((Object)"fl")) break;
                    n = 3;
                    break block36;
                }
                case 3239: {
                    if (!string2.equals((Object)"el")) break;
                    n = 7;
                    break block36;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown shape type ");
                stringBuilder.append(string2);
                Logger.warning(stringBuilder.toString());
                mergePaths = null;
                break;
            }
            case 12: {
                mergePaths = RepeaterParser.parse(jsonReader, lottieComposition);
                break;
            }
            case 11: {
                mergePaths = MergePathsParser.parse(jsonReader);
                lottieComposition.addWarning("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            }
            case 10: {
                mergePaths = PolystarShapeParser.parse(jsonReader, lottieComposition);
                break;
            }
            case 9: {
                mergePaths = ShapeTrimPathParser.parse(jsonReader, lottieComposition);
                break;
            }
            case 8: {
                mergePaths = RectangleShapeParser.parse(jsonReader, lottieComposition);
                break;
            }
            case 7: {
                mergePaths = CircleShapeParser.parse(jsonReader, lottieComposition, n2);
                break;
            }
            case 6: {
                mergePaths = ShapePathParser.parse(jsonReader, lottieComposition);
                break;
            }
            case 5: {
                mergePaths = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                break;
            }
            case 4: {
                mergePaths = GradientFillParser.parse(jsonReader, lottieComposition);
                break;
            }
            case 3: {
                mergePaths = ShapeFillParser.parse(jsonReader, lottieComposition);
                break;
            }
            case 2: {
                mergePaths = GradientStrokeParser.parse(jsonReader, lottieComposition);
                break;
            }
            case 1: {
                mergePaths = ShapeStrokeParser.parse(jsonReader, lottieComposition);
                break;
            }
            case 0: {
                mergePaths = ShapeGroupParser.parse(jsonReader, lottieComposition);
            }
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return mergePaths;
    }
}

