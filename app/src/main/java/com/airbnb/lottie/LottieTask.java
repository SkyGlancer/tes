/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.airbnb.lottie.utils.Logger
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.Set
 *  java.util.concurrent.Callable
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.Executor
 *  java.util.concurrent.Executors
 *  java.util.concurrent.FutureTask
 */
package app.dukhaan.src.java.com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class LottieTask<T> {
    public static Executor EXECUTOR = Executors.newCachedThreadPool();
    private final Set<LottieListener<Throwable>> failureListeners = new LinkedHashSet(1);
    private final Handler handler = new Handler(Looper.getMainLooper());
    private volatile LottieResult<T> result = null;
    private final Set<LottieListener<T>> successListeners = new LinkedHashSet(1);

    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    LottieTask(Callable<LottieResult<T>> callable, boolean bl) {
        if (bl) {
            try {
                this.setResult((LottieResult)callable.call());
                return;
            }
            catch (Throwable throwable) {
                this.setResult(new LottieResult(throwable));
                return;
            }
        }
        EXECUTOR.execute((Runnable)new LottieFutureTask(callable));
    }

    private void notifyFailureListeners(Throwable throwable) {
        LottieTask lottieTask = this;
        synchronized (lottieTask) {
            try {
                ArrayList arrayList = new ArrayList(this.failureListeners);
                if (arrayList.isEmpty()) {
                    Logger.warning((String)"Lottie encountered an error but no failure listener was added:", (Throwable)throwable);
                    return;
                }
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    ((LottieListener)iterator.next()).onResult(throwable);
                }
                return;
            }
            catch (Throwable throwable2) {
                throw throwable2;
            }
        }
    }

    private void notifyListeners() {
        this.handler.post(new Runnable(){

            public void run() {
                if (LottieTask.this.result == null) {
                    return;
                }
                LottieResult lottieResult = LottieTask.this.result;
                if (lottieResult.getValue() != null) {
                    LottieTask.this.notifySuccessListeners(lottieResult.getValue());
                    return;
                }
                LottieTask.this.notifyFailureListeners(lottieResult.getException());
            }
        });
    }

    private void notifySuccessListeners(T t) {
        LottieTask lottieTask = this;
        synchronized (lottieTask) {
            try {
                Iterator iterator = new ArrayList(this.successListeners).iterator();
                while (iterator.hasNext()) {
                    ((LottieListener)iterator.next()).onResult(t);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private void setResult(LottieResult<T> lottieResult) {
        if (this.result == null) {
            this.result = lottieResult;
            this.notifyListeners();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public LottieTask<T> addFailureListener(LottieListener<Throwable> lottieListener) {
        LottieTask lottieTask = this;
        synchronized (lottieTask) {
            if (this.result != null && this.result.getException() != null) {
                lottieListener.onResult(this.result.getException());
            }
            this.failureListeners.add(lottieListener);
            return this;
        }
    }

    public LottieTask<T> addListener(LottieListener<T> lottieListener) {
        LottieTask lottieTask = this;
        synchronized (lottieTask) {
            if (this.result != null && this.result.getValue() != null) {
                lottieListener.onResult(this.result.getValue());
            }
            this.successListeners.add(lottieListener);
            return this;
        }
    }

    public LottieTask<T> removeFailureListener(LottieListener<Throwable> lottieListener) {
        LottieTask lottieTask = this;
        synchronized (lottieTask) {
            this.failureListeners.remove(lottieListener);
            return this;
        }
    }

    public LottieTask<T> removeListener(LottieListener<T> lottieListener) {
        LottieTask lottieTask = this;
        synchronized (lottieTask) {
            this.successListeners.remove(lottieListener);
            return this;
        }
    }

    private class LottieFutureTask
    extends FutureTask<LottieResult<T>> {
        LottieFutureTask(Callable<LottieResult<T>> callable) {
            super(callable);
        }

        protected void done() {
            void var1_3;
            if (this.isCancelled()) {
                return;
            }
            try {
                LottieTask.this.setResult((LottieResult)this.get());
                return;
            }
            catch (ExecutionException executionException) {
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            LottieTask.this.setResult(new LottieResult((Throwable)var1_3));
        }
    }

}

