/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package app.dukhaan.src.java.org.reactivestreams;

public interface Subscription {
    public void cancel();

    public void request(long var1);
}

