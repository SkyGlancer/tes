/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package app.dukhaan.src.java.org.reactivestreams;

import org.reactivestreams.Subscriber;

public interface Publisher<T> {
    public void subscribe(Subscriber<? super T> var1);
}

