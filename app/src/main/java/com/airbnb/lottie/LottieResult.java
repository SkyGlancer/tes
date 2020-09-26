/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Arrays
 */
package app.dukhaan.src.java.com.airbnb.lottie;

import java.util.Arrays;

public final class LottieResult<V> {
    private final Throwable exception;
    private final V value;

    public LottieResult(V v) {
        this.value = v;
        this.exception = null;
    }

    public LottieResult(Throwable throwable) {
        this.exception = throwable;
        this.value = null;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LottieResult)) {
            return false;
        }
        LottieResult lottieResult = (LottieResult)object;
        if (this.getValue() != null && this.getValue().equals(lottieResult.getValue())) {
            return true;
        }
        if (this.getException() != null && lottieResult.getException() != null) {
            return this.getException().toString().equals((Object)this.getException().toString());
        }
        return false;
    }

    public Throwable getException() {
        return this.exception;
    }

    public V getValue() {
        return this.value;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.getValue(), this.getException()};
        return Arrays.hashCode((Object[])arrobject);
    }
}

