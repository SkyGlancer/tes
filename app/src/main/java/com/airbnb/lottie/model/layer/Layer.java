/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  com.airbnb.lottie.model.animatable.AnimatableTextFrame
 *  com.airbnb.lottie.model.animatable.AnimatableTransform
 *  java.lang.Enum
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  java.util.Locale
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.layer;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;
import java.util.Locale;

public class Layer {
    private final LottieComposition composition;
    private final boolean hidden;
    private final List<Keyframe<Float>> inOutKeyframes;
    private final long layerId;
    private final String layerName;
    private final LayerType layerType;
    private final List<Mask> masks;
    private final MatteType matteType;
    private final long parentId;
    private final int preCompHeight;
    private final int preCompWidth;
    private final String refId;
    private final List<ContentModel> shapes;
    private final int solidColor;
    private final int solidHeight;
    private final int solidWidth;
    private final float startFrame;
    private final AnimatableTextFrame text;
    private final AnimatableTextProperties textProperties;
    private final AnimatableFloatValue timeRemapping;
    private final float timeStretch;
    private final AnimatableTransform transform;

    public Layer(List<ContentModel> list, LottieComposition lottieComposition, String string2, long l, LayerType layerType, long l2, String string3, List<Mask> list2, AnimatableTransform animatableTransform, int n, int n2, int n3, float f, float f2, int n4, int n5, AnimatableTextFrame animatableTextFrame, AnimatableTextProperties animatableTextProperties, List<Keyframe<Float>> list3, MatteType matteType, AnimatableFloatValue animatableFloatValue, boolean bl) {
        this.shapes = list;
        this.composition = lottieComposition;
        this.layerName = string2;
        this.layerId = l;
        this.layerType = layerType;
        this.parentId = l2;
        this.refId = string3;
        this.masks = list2;
        this.transform = animatableTransform;
        this.solidWidth = n;
        this.solidHeight = n2;
        this.solidColor = n3;
        this.timeStretch = f;
        this.startFrame = f2;
        this.preCompWidth = n4;
        this.preCompHeight = n5;
        this.text = animatableTextFrame;
        this.textProperties = animatableTextProperties;
        this.inOutKeyframes = list3;
        this.matteType = matteType;
        this.timeRemapping = animatableFloatValue;
        this.hidden = bl;
    }

    LottieComposition getComposition() {
        return this.composition;
    }

    public long getId() {
        return this.layerId;
    }

    List<Keyframe<Float>> getInOutKeyframes() {
        return this.inOutKeyframes;
    }

    public LayerType getLayerType() {
        return this.layerType;
    }

    List<Mask> getMasks() {
        return this.masks;
    }

    MatteType getMatteType() {
        return this.matteType;
    }

    String getName() {
        return this.layerName;
    }

    long getParentId() {
        return this.parentId;
    }

    int getPreCompHeight() {
        return this.preCompHeight;
    }

    int getPreCompWidth() {
        return this.preCompWidth;
    }

    String getRefId() {
        return this.refId;
    }

    List<ContentModel> getShapes() {
        return this.shapes;
    }

    int getSolidColor() {
        return this.solidColor;
    }

    int getSolidHeight() {
        return this.solidHeight;
    }

    int getSolidWidth() {
        return this.solidWidth;
    }

    float getStartProgress() {
        return this.startFrame / this.composition.getDurationFrames();
    }

    AnimatableTextFrame getText() {
        return this.text;
    }

    AnimatableTextProperties getTextProperties() {
        return this.textProperties;
    }

    AnimatableFloatValue getTimeRemapping() {
        return this.timeRemapping;
    }

    float getTimeStretch() {
        return this.timeStretch;
    }

    AnimatableTransform getTransform() {
        return this.transform;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public String toString() {
        return this.toString("");
    }

    public String toString(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(this.getName());
        stringBuilder.append("\n");
        Layer layer = this.composition.layerModelForId(this.getParentId());
        if (layer != null) {
            stringBuilder.append("\t\tParents: ");
            stringBuilder.append(layer.getName());
            Layer layer2 = this.composition.layerModelForId(layer.getParentId());
            while (layer2 != null) {
                stringBuilder.append("->");
                stringBuilder.append(layer2.getName());
                layer2 = this.composition.layerModelForId(layer2.getParentId());
            }
            stringBuilder.append(string2);
            stringBuilder.append("\n");
        }
        if (!this.getMasks().isEmpty()) {
            stringBuilder.append(string2);
            stringBuilder.append("\tMasks: ");
            stringBuilder.append(this.getMasks().size());
            stringBuilder.append("\n");
        }
        if (this.getSolidWidth() != 0 && this.getSolidHeight() != 0) {
            stringBuilder.append(string2);
            stringBuilder.append("\tBackground: ");
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{this.getSolidWidth(), this.getSolidHeight(), this.getSolidColor()};
            stringBuilder.append(String.format((Locale)locale, (String)"%dx%d %X\n", (Object[])arrobject));
        }
        if (!this.shapes.isEmpty()) {
            stringBuilder.append(string2);
            stringBuilder.append("\tShapes:\n");
            for (Object object : this.shapes) {
                stringBuilder.append(string2);
                stringBuilder.append("\t\t");
                stringBuilder.append(object);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public static final class LayerType
    extends Enum<LayerType> {
        private static final /* synthetic */ LayerType[] $VALUES;
        public static final /* enum */ LayerType IMAGE;
        public static final /* enum */ LayerType NULL;
        public static final /* enum */ LayerType PRE_COMP;
        public static final /* enum */ LayerType SHAPE;
        public static final /* enum */ LayerType SOLID;
        public static final /* enum */ LayerType TEXT;
        public static final /* enum */ LayerType UNKNOWN;

        static {
            LayerType layerType;
            PRE_COMP = new LayerType();
            SOLID = new LayerType();
            IMAGE = new LayerType();
            NULL = new LayerType();
            SHAPE = new LayerType();
            TEXT = new LayerType();
            UNKNOWN = layerType = new LayerType();
            LayerType[] arrlayerType = new LayerType[]{PRE_COMP, SOLID, IMAGE, NULL, SHAPE, TEXT, layerType};
            $VALUES = arrlayerType;
        }

        public static LayerType valueOf(String string2) {
            return (LayerType)Enum.valueOf(LayerType.class, (String)string2);
        }

        public static LayerType[] values() {
            return (LayerType[])$VALUES.clone();
        }
    }

    public static final class MatteType
    extends Enum<MatteType> {
        private static final /* synthetic */ MatteType[] $VALUES;
        public static final /* enum */ MatteType ADD;
        public static final /* enum */ MatteType INVERT;
        public static final /* enum */ MatteType NONE;
        public static final /* enum */ MatteType UNKNOWN;

        static {
            MatteType matteType;
            NONE = new MatteType();
            ADD = new MatteType();
            INVERT = new MatteType();
            UNKNOWN = matteType = new MatteType();
            MatteType[] arrmatteType = new MatteType[]{NONE, ADD, INVERT, matteType};
            $VALUES = arrmatteType;
        }

        public static MatteType valueOf(String string2) {
            return (MatteType)Enum.valueOf(MatteType.class, (String)string2);
        }

        public static MatteType[] values() {
            return (MatteType[])$VALUES.clone();
        }
    }

}

