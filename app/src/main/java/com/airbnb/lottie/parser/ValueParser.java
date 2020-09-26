/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

interface ValueParser<V> {
    public V parse(JsonReader var1, float var2) throws IOException;
}

