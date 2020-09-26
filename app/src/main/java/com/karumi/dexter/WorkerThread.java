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

final class WorkerThread
implements java.lang.Thread {
    private final Handler handler;
    private boolean wasLooperNull = false;

    WorkerThread() {
        if (Looper.myLooper() == null) {
            this.wasLooperNull = true;
            Looper.prepare();
        }
        this.handler = new Handler();
    }

    @Override
    public void execute(Runnable runnable) {
        this.handler.post(runnable);
    }

    @Override
    public void loop() {
        if (this.wasLooperNull) {
            Looper.loop();
        }
    }
}

