/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 *  org.reactivestreams.Subscription
 */
package app.dukhaan.src.java.org.reactivestreams;

import org.reactivestreams.Subscription;

public interface Subscriber<T> {
    public void onComplete();

    public void onError(Throwable var1);

    public void onNext(T var1);

    public void onSubscribe(Subscription var1);
}

