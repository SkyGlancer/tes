/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  androidx.collection.LongSparseArray
 *  androidx.collection.SparseArrayCompat
 *  com.airbnb.lottie.LottieComposition$Factory$ListenerAdapter
 *  com.airbnb.lottie.model.Font
 *  com.airbnb.lottie.model.FontCharacter
 *  com.airbnb.lottie.model.Marker
 *  com.airbnb.lottie.model.layer.Layer
 *  com.airbnb.lottie.parser.moshi.JsonReader
 *  com.airbnb.lottie.utils.Logger
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.Cancellable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.airbnb.lottie.PerformanceTracker;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class LottieComposition {
    private Rect bounds;
    private SparseArrayCompat<FontCharacter> characters;
    private float endFrame;
    private Map<String, Font> fonts;
    private float frameRate;
    private boolean hasDashPattern;
    private Map<String, LottieImageAsset> images;
    private LongSparseArray<Layer> layerMap;
    private List<Layer> layers;
    private List<Marker> markers;
    private int maskAndMatteCount = 0;
    private final PerformanceTracker performanceTracker = new PerformanceTracker();
    private Map<String, List<Layer>> precomps;
    private float startFrame;
    private final HashSet<String> warnings = new HashSet();

    public void addWarning(String string2) {
        Logger.warning((String)string2);
        this.warnings.add((Object)string2);
    }

    public Rect getBounds() {
        return this.bounds;
    }

    public SparseArrayCompat<FontCharacter> getCharacters() {
        return this.characters;
    }

    public float getDuration() {
        return (long)(1000.0f * (this.getDurationFrames() / this.frameRate));
    }

    public float getDurationFrames() {
        return this.endFrame - this.startFrame;
    }

    public float getEndFrame() {
        return this.endFrame;
    }

    public Map<String, Font> getFonts() {
        return this.fonts;
    }

    public float getFrameRate() {
        return this.frameRate;
    }

    public Map<String, LottieImageAsset> getImages() {
        return this.images;
    }

    public List<Layer> getLayers() {
        return this.layers;
    }

    public Marker getMarker(String string2) {
        this.markers.size();
        for (int i = 0; i < this.markers.size(); ++i) {
            Marker marker = (Marker)this.markers.get(i);
            if (!marker.matchesName(string2)) continue;
            return marker;
        }
        return null;
    }

    public List<Marker> getMarkers() {
        return this.markers;
    }

    public int getMaskAndMatteCount() {
        return this.maskAndMatteCount;
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.performanceTracker;
    }

    public List<Layer> getPrecomps(String string2) {
        return (List)this.precomps.get((Object)string2);
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public ArrayList<String> getWarnings() {
        HashSet<String> hashSet = this.warnings;
        return new ArrayList((Collection)Arrays.asList((Object[])hashSet.toArray((Object[])new String[hashSet.size()])));
    }

    public boolean hasDashPattern() {
        return this.hasDashPattern;
    }

    public boolean hasImages() {
        return true ^ this.images.isEmpty();
    }

    public void incrementMatteOrMaskCount(int n) {
        this.maskAndMatteCount = n + this.maskAndMatteCount;
    }

    public void init(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2, SparseArrayCompat<FontCharacter> sparseArrayCompat, Map<String, Font> map3, List<Marker> list2) {
        this.bounds = rect;
        this.startFrame = f;
        this.endFrame = f2;
        this.frameRate = f3;
        this.layers = list;
        this.layerMap = longSparseArray;
        this.precomps = map;
        this.images = map2;
        this.characters = sparseArrayCompat;
        this.fonts = map3;
        this.markers = list2;
    }

    public Layer layerModelForId(long l) {
        return (Layer)this.layerMap.get(l);
    }

    public void setHasDashPattern(boolean bl) {
        this.hasDashPattern = bl;
    }

    public void setPerformanceTrackingEnabled(boolean bl) {
        this.performanceTracker.setEnabled(bl);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LottieComposition:\n");
        Iterator iterator = this.layers.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(((Layer)iterator.next()).toString("\t"));
        }
        return stringBuilder.toString();
    }

    /*
     * Exception performing whole class analysis.
     */
    @Deprecated
    public static class Factory {
        private Factory() {
        }

        @Deprecated
        public static Cancellable fromAssetFileName(Context context, String string2, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new /* Unavailable Anonymous Inner Class!! */;
            LottieCompositionFactory.fromAsset(context, string2).addListener((LottieListener<LottieComposition>)listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static LottieComposition fromFileSync(Context context, String string2) {
            return LottieCompositionFactory.fromAssetSync(context, string2).getValue();
        }

        @Deprecated
        public static Cancellable fromInputStream(InputStream inputStream, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new /* Unavailable Anonymous Inner Class!! */;
            LottieCompositionFactory.fromJsonInputStream(inputStream, null).addListener((LottieListener<LottieComposition>)listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static LottieComposition fromInputStreamSync(InputStream inputStream) {
            return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromInputStreamSync(InputStream inputStream, boolean bl) {
            if (bl) {
                Logger.warning((String)"Lottie now auto-closes input stream!");
            }
            return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null).getValue();
        }

        @Deprecated
        public static Cancellable fromJsonReader(JsonReader jsonReader, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new /* Unavailable Anonymous Inner Class!! */;
            LottieCompositionFactory.fromJsonReader(jsonReader, null).addListener((LottieListener<LottieComposition>)listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static Cancellable fromJsonString(String string2, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new /* Unavailable Anonymous Inner Class!! */;
            LottieCompositionFactory.fromJsonString(string2, null).addListener((LottieListener<LottieComposition>)listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static LottieComposition fromJsonSync(Resources resources, JSONObject jSONObject) {
            return LottieCompositionFactory.fromJsonSync(jSONObject, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromJsonSync(JsonReader jsonReader) throws IOException {
            return LottieCompositionFactory.fromJsonReaderSync(jsonReader, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromJsonSync(String string2) {
            return LottieCompositionFactory.fromJsonStringSync(string2, null).getValue();
        }

        @Deprecated
        public static Cancellable fromRawFile(Context context, int n, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new /* Unavailable Anonymous Inner Class!! */;
            LottieCompositionFactory.fromRawRes(context, n).addListener((LottieListener<LottieComposition>)listenerAdapter);
            return listenerAdapter;
        }
    }

}

