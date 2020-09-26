/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.LottieAnimationView
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package app.dukhaan.src.java.com.airbnb.lottie;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import java.util.HashMap;
import java.util.Map;

public class TextDelegate {
    private final LottieAnimationView animationView;
    private boolean cacheText = true;
    private final LottieDrawable drawable;
    private final Map<String, String> stringMap = new HashMap();

    TextDelegate() {
        this.animationView = null;
        this.drawable = null;
    }

    public TextDelegate(LottieAnimationView lottieAnimationView) {
        this.animationView = lottieAnimationView;
        this.drawable = null;
    }

    public TextDelegate(LottieDrawable lottieDrawable) {
        this.drawable = lottieDrawable;
        this.animationView = null;
    }

    private String getText(String string2) {
        return string2;
    }

    private void invalidate() {
        LottieDrawable lottieDrawable;
        LottieAnimationView lottieAnimationView = this.animationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        if ((lottieDrawable = this.drawable) != null) {
            lottieDrawable.invalidateSelf();
        }
    }

    public final String getTextInternal(String string2) {
        if (this.cacheText && this.stringMap.containsKey((Object)string2)) {
            return (String)this.stringMap.get((Object)string2);
        }
        String string3 = this.getText(string2);
        if (this.cacheText) {
            this.stringMap.put((Object)string2, (Object)string3);
        }
        return string3;
    }

    public void invalidateAllText() {
        this.stringMap.clear();
        this.invalidate();
    }

    public void invalidateText(String string2) {
        this.stringMap.remove((Object)string2);
        this.invalidate();
    }

    public void setCacheText(boolean bl) {
        this.cacheText = bl;
    }

    public void setText(String string2, String string3) {
        this.stringMap.put((Object)string2, (Object)string3);
        this.invalidate();
    }
}

