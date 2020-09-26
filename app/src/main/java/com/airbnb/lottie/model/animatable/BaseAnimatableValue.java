/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class BaseAnimatableValue<V, O>
implements AnimatableValue<V, O> {
    final List<Keyframe<V>> keyframes;

    BaseAnimatableValue(V v) {
        this(Collections.singletonList(new Keyframe<V>(v)));
    }

    BaseAnimatableValue(List<Keyframe<V>> list) {
        this.keyframes = list;
    }

    @Override
    public List<Keyframe<V>> getKeyframes() {
        return this.keyframes;
    }

    @Override
    public boolean isStatic() {
        boolean bl;
        block3 : {
            block2 : {
                if (this.keyframes.isEmpty()) break block2;
                int n = this.keyframes.size();
                bl = false;
                if (n != 1) break block3;
                boolean bl2 = ((Keyframe)this.keyframes.get(0)).isStatic();
                bl = false;
                if (!bl2) break block3;
            }
            bl = true;
        }
        return bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!this.keyframes.isEmpty()) {
            stringBuilder.append("values=");
            stringBuilder.append(Arrays.toString((Object[])this.keyframes.toArray()));
        }
        return stringBuilder.toString();
    }
}

