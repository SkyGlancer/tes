/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.collection.LruCache
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.airbnb.lottie.model;

import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

public class LottieCompositionCache {
    private static final LottieCompositionCache INSTANCE = new LottieCompositionCache();
    private final LruCache<String, LottieComposition> cache = new LruCache(20);

    LottieCompositionCache() {
    }

    public static LottieCompositionCache getInstance() {
        return INSTANCE;
    }

    public void clear() {
        this.cache.evictAll();
    }

    public LottieComposition get(String string2) {
        if (string2 == null) {
            return null;
        }
        return (LottieComposition)this.cache.get((Object)string2);
    }

    public void put(String string2, LottieComposition lottieComposition) {
        if (string2 == null) {
            return;
        }
        this.cache.put((Object)string2, (Object)lottieComposition);
    }

    public void resize(int n) {
        this.cache.resize(n);
    }
}

