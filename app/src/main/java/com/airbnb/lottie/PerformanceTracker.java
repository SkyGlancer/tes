/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.collection.ArraySet
 *  androidx.core.util.Pair
 *  com.airbnb.lottie.utils.MeanCalculator
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package app.dukhaan.src.java.com.airbnb.lottie;

import android.util.Log;
import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.MeanCalculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PerformanceTracker {
    private boolean enabled = false;
    private final Comparator<Pair<String, Float>> floatComparator = new Comparator<Pair<String, Float>>(){

        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float f = ((Float)pair.second).floatValue();
            float f2 = ((Float)pair2.second).floatValue();
            if (f2 > f) {
                return 1;
            }
            if (f > f2) {
                return -1;
            }
            return 0;
        }
    };
    private final Set<FrameListener> frameListeners = new ArraySet();
    private final Map<String, MeanCalculator> layerRenderTimes = new HashMap();

    public void addFrameListener(FrameListener frameListener) {
        this.frameListeners.add((Object)frameListener);
    }

    public void clearRenderTimes() {
        this.layerRenderTimes.clear();
    }

    public List<Pair<String, Float>> getSortedRenderTimes() {
        if (!this.enabled) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.layerRenderTimes.size());
        for (Map.Entry entry : this.layerRenderTimes.entrySet()) {
            arrayList.add((Object)new Pair(entry.getKey(), (Object)Float.valueOf((float)((MeanCalculator)entry.getValue()).getMean())));
        }
        Collections.sort((List)arrayList, this.floatComparator);
        return arrayList;
    }

    public void logRenderTimes() {
        if (!this.enabled) {
            return;
        }
        List<Pair<String, Float>> list = this.getSortedRenderTimes();
        Log.d((String)"LOTTIE", (String)"Render times:");
        for (int i = 0; i < list.size(); ++i) {
            Pair pair = (Pair)list.get(i);
            Object[] arrobject = new Object[]{pair.first, pair.second};
            Log.d((String)"LOTTIE", (String)String.format((String)"\t\t%30s:%.2f", (Object[])arrobject));
        }
    }

    public void recordRenderTime(String string2, float f) {
        if (!this.enabled) {
            return;
        }
        MeanCalculator meanCalculator = (MeanCalculator)this.layerRenderTimes.get((Object)string2);
        if (meanCalculator == null) {
            meanCalculator = new MeanCalculator();
            this.layerRenderTimes.put((Object)string2, (Object)meanCalculator);
        }
        meanCalculator.add(f);
        if (string2.equals((Object)"__container")) {
            Iterator iterator = this.frameListeners.iterator();
            while (iterator.hasNext()) {
                ((FrameListener)iterator.next()).onFrameRendered(f);
            }
        }
    }

    public void removeFrameListener(FrameListener frameListener) {
        this.frameListeners.remove((Object)frameListener);
    }

    void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    public static interface FrameListener {
        public void onFrameRendered(float var1);
    }

}

