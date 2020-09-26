/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package app.dukhaan.src.java.com.airbnb.lottie;

public interface LottieLogger {
    public void debug(String var1);

    public void debug(String var1, Throwable var2);

    public void error(String var1, Throwable var2);

    public void warning(String var1);

    public void warning(String var1, Throwable var2);
}

