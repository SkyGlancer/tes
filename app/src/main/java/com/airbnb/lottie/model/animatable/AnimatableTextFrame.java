/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.animatable.BaseAnimatableValue;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableTextFrame
extends BaseAnimatableValue<DocumentData, DocumentData> {
    public AnimatableTextFrame(List<Keyframe<DocumentData>> list) {
        super(list);
    }

    public TextKeyframeAnimation createAnimation() {
        return new TextKeyframeAnimation((List<Keyframe<DocumentData>>)this.keyframes);
    }
}

