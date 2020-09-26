/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.model;

import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public interface KeyPathElement {
    public <T> void addValueCallback(T var1, LottieValueCallback<T> var2);

    public void resolveKeyPath(KeyPath var1, int var2, List<KeyPath> var3, KeyPath var4);
}

