/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Pair
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.src.java.com.airbnb.lottie.model;

import androidx.core.util.Pair;

public class MutablePair<T> {
    T first;
    T second;

    private static boolean objectsEqual(Object object, Object object2) {
        return object == object2 || object != null && object.equals(object2);
        {
        }
    }

    public boolean equals(Object object) {
        if (!(object instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair)object;
        boolean bl = MutablePair.objectsEqual(pair.first, this.first);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = MutablePair.objectsEqual(pair.second, this.second);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        T t = this.first;
        int n = t == null ? 0 : t.hashCode();
        T t2 = this.second;
        int n2 = t2 == null ? 0 : t2.hashCode();
        return n ^ n2;
    }

    public void set(T t, T t2) {
        this.first = t;
        this.second = t2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pair{");
        stringBuilder.append(String.valueOf(this.first));
        stringBuilder.append(" ");
        stringBuilder.append(String.valueOf(this.second));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

