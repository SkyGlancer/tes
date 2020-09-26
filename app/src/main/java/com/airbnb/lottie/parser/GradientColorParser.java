/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  java.io.IOException
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GradientColorParser
implements ValueParser<GradientColor> {
    private int colorPoints;

    public GradientColorParser(int n) {
        this.colorPoints = n;
    }

    private void addOpacityStopsToGradientIfNeeded(GradientColor gradientColor, List<Float> list) {
        int n = 4 * this.colorPoints;
        if (list.size() <= n) {
            return;
        }
        int n2 = (list.size() - n) / 2;
        double[] arrd = new double[n2];
        double[] arrd2 = new double[n2];
        int n3 = 0;
        do {
            int n4 = list.size();
            if (n >= n4) break;
            if (n % 2 == 0) {
                arrd[n3] = ((Float)list.get(n)).floatValue();
            } else {
                arrd2[n3] = ((Float)list.get(n)).floatValue();
                ++n3;
            }
            ++n;
        } while (true);
        for (int i = 0; i < gradientColor.getSize(); ++i) {
            int n5;
            int n6 = gradientColor.getColors()[i];
            gradientColor.getColors()[i] = n5 = Color.argb((int)this.getOpacityAtPosition(gradientColor.getPositions()[i], arrd, arrd2), (int)Color.red((int)n6), (int)Color.green((int)n6), (int)Color.blue((int)n6));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int getOpacityAtPosition(double d, double[] arrd, double[] arrd2) {
        double d2;
        for (int i = 1; i < arrd.length; ++i) {
            int n = i - 1;
            double d3 = arrd[n];
            double d4 = arrd[i];
            if (!(arrd[i] >= d)) continue;
            double d5 = (d - d3) / (d4 - d3);
            d2 = MiscUtils.lerp(arrd2[n], arrd2[i], d5);
            do {
                return (int)(d2 * 255.0);
                break;
            } while (true);
        }
        d2 = arrd2[arrd2.length - 1];
        return (int)(d2 * 255.0);
    }

    @Override
    public GradientColor parse(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        JsonReader.Token token = jsonReader.peek();
        JsonReader.Token token2 = JsonReader.Token.BEGIN_ARRAY;
        int n = 0;
        boolean bl = token == token2;
        if (bl) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add((Object)Float.valueOf((float)((float)jsonReader.nextDouble())));
        }
        if (bl) {
            jsonReader.endArray();
        }
        if (this.colorPoints == -1) {
            this.colorPoints = arrayList.size() / 4;
        }
        int n2 = this.colorPoints;
        float[] arrf = new float[n2];
        int[] arrn = new int[n2];
        int n3 = 0;
        int n4 = 0;
        while (n < 4 * this.colorPoints) {
            int n5 = n / 4;
            double d = ((Float)arrayList.get(n)).floatValue();
            int n6 = n % 4;
            if (n6 != 0) {
                if (n6 != 1) {
                    if (n6 != 2) {
                        if (n6 == 3) {
                            Double.isNaN((double)d);
                            arrn[n5] = Color.argb((int)255, (int)n3, (int)n4, (int)((int)(d * 255.0)));
                        }
                    } else {
                        Double.isNaN((double)d);
                        n4 = (int)(d * 255.0);
                    }
                } else {
                    Double.isNaN((double)d);
                    n3 = (int)(d * 255.0);
                }
            } else {
                arrf[n5] = (float)d;
            }
            ++n;
        }
        GradientColor gradientColor = new GradientColor(arrf, arrn);
        this.addOpacityStopsToGradientIfNeeded(gradientColor, (List<Float>)arrayList);
        return gradientColor;
    }
}

