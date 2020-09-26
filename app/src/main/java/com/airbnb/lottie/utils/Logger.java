/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.utils.LogcatLogger
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package app.dukhaan.src.java.com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;
import com.airbnb.lottie.utils.LogcatLogger;

public class Logger {
    private static LottieLogger INSTANCE = new LogcatLogger();

    public static void debug(String string2) {
        INSTANCE.debug(string2);
    }

    public static void debug(String string2, Throwable throwable) {
        INSTANCE.debug(string2, throwable);
    }

    public static void error(String string2, Throwable throwable) {
        INSTANCE.error(string2, throwable);
    }

    public static void setInstance(LottieLogger lottieLogger) {
        INSTANCE = lottieLogger;
    }

    public static void warning(String string2) {
        INSTANCE.warning(string2);
    }

    public static void warning(String string2, Throwable throwable) {
        INSTANCE.warning(string2, throwable);
    }
}

