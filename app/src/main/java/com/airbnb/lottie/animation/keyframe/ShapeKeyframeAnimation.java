/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class ShapeKeyframeAnimation
extends BaseKeyframeAnimation<ShapeData, Path> {
    private final Path tempPath = new Path();
    private final ShapeData tempShapeData = new ShapeData();

    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> list) {
        super(list);
    }

    @Override
    public Path getValue(Keyframe<ShapeData> keyframe, float f) {
        ShapeData shapeData = (ShapeData)keyframe.startValue;
        ShapeData shapeData2 = (ShapeData)keyframe.endValue;
        this.tempShapeData.interpolateBetween(shapeData, shapeData2, f);
        MiscUtils.getPathFromData(this.tempShapeData, this.tempPath);
        return this.tempPath;
    }
}

