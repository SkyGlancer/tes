/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser.moshi;

final class JsonScope {
    static final int CLOSED = 8;
    static final int DANGLING_NAME = 4;
    static final int EMPTY_ARRAY = 1;
    static final int EMPTY_DOCUMENT = 6;
    static final int EMPTY_OBJECT = 3;
    static final int NONEMPTY_ARRAY = 2;
    static final int NONEMPTY_DOCUMENT = 7;
    static final int NONEMPTY_OBJECT = 5;

    private JsonScope() {
    }

    static String getPath(int n, int[] arrn, String[] arrstring, int[] arrn2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('$');
        for (int i = 0; i < n; ++i) {
            int n2 = arrn[i];
            if (n2 != 1 && n2 != 2) {
                if (n2 != 3 && n2 != 4 && n2 != 5) continue;
                stringBuilder.append('.');
                if (arrstring[i] == null) continue;
                stringBuilder.append(arrstring[i]);
                continue;
            }
            stringBuilder.append('[');
            stringBuilder.append(arrn2[i]);
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }
}

