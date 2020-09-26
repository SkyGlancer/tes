/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.core.os.TraceCompat
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package app.dukhaan.src.java.com.airbnb.lottie;

import androidx.core.os.TraceCompat;

public class L {
    public static boolean DBG = false;
    private static final int MAX_DEPTH = 20;
    public static final String TAG = "LOTTIE";
    private static int depthPastMaxDepth;
    private static String[] sections;
    private static long[] startTimeNs;
    private static int traceDepth;
    private static boolean traceEnabled;

    public static void beginSection(String string2) {
        if (!traceEnabled) {
            return;
        }
        int n = traceDepth;
        if (n == 20) {
            depthPastMaxDepth = 1 + depthPastMaxDepth;
            return;
        }
        L.sections[n] = string2;
        L.startTimeNs[n] = System.nanoTime();
        TraceCompat.beginSection((String)string2);
        traceDepth = 1 + traceDepth;
    }

    public static float endSection(String string2) {
        int n;
        int n2 = depthPastMaxDepth;
        if (n2 > 0) {
            depthPastMaxDepth = n2 - 1;
            return 0.0f;
        }
        if (!traceEnabled) {
            return 0.0f;
        }
        traceDepth = n = -1 + traceDepth;
        if (n != -1) {
            if (string2.equals((Object)sections[n])) {
                TraceCompat.endSection();
                return (float)(System.nanoTime() - startTimeNs[traceDepth]) / 1000000.0f;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unbalanced trace call ");
            stringBuilder.append(string2);
            stringBuilder.append(". Expected ");
            stringBuilder.append(sections[traceDepth]);
            stringBuilder.append(".");
            throw new IllegalStateException(stringBuilder.toString());
        }
        throw new IllegalStateException("Can't end trace section. There are none.");
    }

    public static void setTraceEnabled(boolean bl) {
        if (traceEnabled == bl) {
            return;
        }
        traceEnabled = bl;
        if (bl) {
            sections = new String[20];
            startTimeNs = new long[20];
        }
    }
}

