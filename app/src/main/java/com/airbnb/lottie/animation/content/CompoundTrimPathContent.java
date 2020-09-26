/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  com.airbnb.lottie.animation.content.TrimPathContent
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CompoundTrimPathContent {
    private List<TrimPathContent> contents = new ArrayList();

    void addTrimPath(TrimPathContent trimPathContent) {
        this.contents.add((Object)trimPathContent);
    }

    public void apply(Path path) {
        for (int i = -1 + this.contents.size(); i >= 0; --i) {
            Utils.applyTrimPathIfNeeded(path, (TrimPathContent)this.contents.get(i));
        }
    }
}

