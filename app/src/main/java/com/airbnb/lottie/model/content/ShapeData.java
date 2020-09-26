/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ShapeData {
    private boolean closed;
    private final List<CubicCurveData> curves;
    private PointF initialPoint;

    public ShapeData() {
        this.curves = new ArrayList();
    }

    public ShapeData(PointF pointF, boolean bl, List<CubicCurveData> list) {
        this.initialPoint = pointF;
        this.closed = bl;
        this.curves = new ArrayList(list);
    }

    private void setInitialPoint(float f, float f2) {
        if (this.initialPoint == null) {
            this.initialPoint = new PointF();
        }
        this.initialPoint.set(f, f2);
    }

    public List<CubicCurveData> getCurves() {
        return this.curves;
    }

    public PointF getInitialPoint() {
        return this.initialPoint;
    }

    public void interpolateBetween(ShapeData shapeData, ShapeData shapeData2, float f) {
        if (this.initialPoint == null) {
            this.initialPoint = new PointF();
        }
        boolean bl = shapeData.isClosed() || shapeData2.isClosed();
        this.closed = bl;
        if (shapeData.getCurves().size() != shapeData2.getCurves().size()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Curves must have the same number of control points. Shape 1: ");
            stringBuilder.append(shapeData.getCurves().size());
            stringBuilder.append("\tShape 2: ");
            stringBuilder.append(shapeData2.getCurves().size());
            Logger.warning(stringBuilder.toString());
        }
        int n = Math.min((int)shapeData.getCurves().size(), (int)shapeData2.getCurves().size());
        if (this.curves.size() < n) {
            for (int i = this.curves.size(); i < n; ++i) {
                this.curves.add((Object)new CubicCurveData());
            }
        } else if (this.curves.size() > n) {
            for (int i = this.curves.size() - 1; i >= n; --i) {
                List<CubicCurveData> list = this.curves;
                list.remove(list.size() - 1);
            }
        }
        PointF pointF = shapeData.getInitialPoint();
        PointF pointF2 = shapeData2.getInitialPoint();
        this.setInitialPoint(MiscUtils.lerp(pointF.x, pointF2.x, f), MiscUtils.lerp(pointF.y, pointF2.y, f));
        for (int i = this.curves.size() - 1; i >= 0; --i) {
            CubicCurveData cubicCurveData = (CubicCurveData)shapeData.getCurves().get(i);
            CubicCurveData cubicCurveData2 = (CubicCurveData)shapeData2.getCurves().get(i);
            PointF pointF3 = cubicCurveData.getControlPoint1();
            PointF pointF4 = cubicCurveData.getControlPoint2();
            PointF pointF5 = cubicCurveData.getVertex();
            PointF pointF6 = cubicCurveData2.getControlPoint1();
            PointF pointF7 = cubicCurveData2.getControlPoint2();
            PointF pointF8 = cubicCurveData2.getVertex();
            ((CubicCurveData)this.curves.get(i)).setControlPoint1(MiscUtils.lerp(pointF3.x, pointF6.x, f), MiscUtils.lerp(pointF3.y, pointF6.y, f));
            ((CubicCurveData)this.curves.get(i)).setControlPoint2(MiscUtils.lerp(pointF4.x, pointF7.x, f), MiscUtils.lerp(pointF4.y, pointF7.y, f));
            ((CubicCurveData)this.curves.get(i)).setVertex(MiscUtils.lerp(pointF5.x, pointF8.x, f), MiscUtils.lerp(pointF5.y, pointF8.y, f));
        }
    }

    public boolean isClosed() {
        return this.closed;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShapeData{numCurves=");
        stringBuilder.append(this.curves.size());
        stringBuilder.append("closed=");
        stringBuilder.append(this.closed);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

