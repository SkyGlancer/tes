/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package app.dukhaan.src.java.org.reactivestreams;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public interface Processor<T, R>
extends Subscriber<T>,
Publisher<R> {
}

