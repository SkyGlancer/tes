/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.concurrent.Executor
 */
package app.dukhaan.src.java.io.branch.referral;

import android.os.AsyncTask;
import android.os.Build;
import java.util.concurrent.Executor;

public abstract class BranchAsyncTask<Params, Progress, Result>
extends AsyncTask<Params, Progress, Result> {
    public /* varargs */ AsyncTask<Params, Progress, Result> executeTask(Params ... arrParams) {
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                AsyncTask asyncTask = this.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])arrParams);
                return asyncTask;
            }
            catch (Throwable throwable) {
                return this.execute((Object[])arrParams);
            }
        }
        return this.execute((Object[])arrParams);
    }
}

