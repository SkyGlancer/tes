/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.Runnable
 */
package app.dukhaan.src.java.com.karumi.dexter;

import android.os.Handler;
import android.os.Looper;
import com.karumi.dexter.Thread;

final class MainThread
implements java.lang.Thread {
    MainThread() {
    }

    private static boolean runningMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    @Override
    public void execute(Runnable runnable) {
        if (MainThread.runningMainThread()) {
            runnable.run();
            return;
        }
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    @Override
    public void loop() {
    }
}

