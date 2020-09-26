/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  com.karumi.dexter.MainThread
 *  com.karumi.dexter.WorkerThread
 *  java.lang.Object
 *  java.lang.Thread
 */
package app.dukhaan.src.java.com.karumi.dexter;

import android.os.Looper;
import com.karumi.dexter.MainThread;
import com.karumi.dexter.Thread;
import com.karumi.dexter.WorkerThread;

final class ThreadFactory {
    ThreadFactory() {
    }

    public static java.lang.Thread makeMainThread() {
        return new MainThread();
    }

    public static java.lang.Thread makeSameThread() {
        if (ThreadFactory.runningMainThread()) {
            return new MainThread();
        }
        return new WorkerThread();
    }

    private static boolean runningMainThread() {
        return Looper.getMainLooper().getThread() == java.lang.Thread.currentThread();
    }
}

