/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.parser.JsonUtils;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeDataParser
implements ValueParser<ShapeData> {
    public static final ShapeDataParser INSTANCE = new ShapeDataParser();
    private static final JsonReader.Options NAMES = JsonReader.Options.of("c", "v", "i", "o");

    private ShapeDataParser() {
    }

    @Override
    public ShapeData parse(JsonReader jsonReader, float f) throws IOException {
        IllegalArgumentException illegalArgumentException;
        if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean bl = false;
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
                        list3 = JsonUtils.jsonToPoints(jsonReader, f);
                        continue;
                    }
                    list2 = JsonUtils.jsonToPoints(jsonReader, f);
                    continue;
                }
                list = JsonUtils.jsonToPoints(jsonReader, f);
                continue;
            }
            bl = jsonReader.nextBoolean();
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonReader.Token.END_ARRAY) {
            jsonReader.endArray();
        }
        if (list != null && list2 != null && list3 != null) {
            if (list.isEmpty()) {
                return new ShapeData(new PointF(), false, (List<CubicCurveData>)Collections.emptyList());
            }
            int n = list.size();
            PointF pointF = (PointF)list.get(0);
            ArrayList arrayList = new ArrayList(n);
            for (int i = 1; i < n; ++i) {
                PointF pointF2 = (PointF)list.get(i);
                int n2 = i - 1;
                PointF pointF3 = (PointF)list.get(n2);
                PointF pointF4 = (PointF)list3.get(n2);
                PointF pointF5 = (PointF)list2.get(i);
                arrayList.add((Object)new CubicCurveData(MiscUtils.addPoints(pointF3, pointF4), MiscUtils.addPoints(pointF2, pointF5), pointF2));
            }
            if (bl) {
                PointF pointF6 = (PointF)list.get(0);
                int n3 = n - 1;
                PointF pointF7 = (PointF)list.get(n3);
                PointF pointF8 = (PointF)list3.get(n3);
                PointF pointF9 = (PointF)list2.get(0);
                arrayList.add((Object)new CubicCurveData(MiscUtils.addPoints(pointF7, pointF8), MiscUtils.addPoints(pointF6, pointF9), pointF6));
            }
            return new ShapeData(pointF, bl, (List<CubicCurveData>)arrayList);
        }
        illegalArgumentException = new IllegalArgumentException("Shape data was missing information.");
        throw illegalArgumentException;
    }
}

