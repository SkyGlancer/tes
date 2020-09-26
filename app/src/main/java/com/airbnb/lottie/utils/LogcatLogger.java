/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashSet
 *  java.util.Set
 */
package app.dukhaan.src.java.com.airbnb.lottie.utils;

import android.util.Log;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieLogger;
import java.util.HashSet;
import java.util.Set;

public class LogcatLogger
implements LottieLogger {
    private static final Set<String> loggedMessages = new HashSet();

    @Override
    public void debug(String string2) {
        this.debug(string2, null);
    }

    @Override
    public void debug(String string2, Throwable throwable) {
        if (L.DBG) {
            Log.d((String)"LOTTIE", (String)string2, (Throwable)throwable);
        }
    }

    @Override
    public void error(String string2, Throwable throwable) {
        if (L.DBG) {
            Log.d((String)"LOTTIE", (String)string2, (Throwable)throwable);
        }
    }

    @Override
    public void warning(String string2) {
        this.warning(string2, null);
    }

    @Override
    public void warning(String string2, Throwable throwable) {
        if (loggedMessages.contains((Object)string2)) {
            return;
        }
        Log.w((String)"LOTTIE", (String)string2, (Throwable)throwable);
        loggedMessages.add((Object)string2);
    }
}

