/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Process
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.lang.reflect.Method
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.TimeUnit
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.Context;
import android.os.Process;
import io.branch.referral.BranchAsyncTask;
import io.branch.referral.DeviceInfo;
import io.branch.referral.SystemObserver;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GAdsPrefetchTask
extends BranchAsyncTask<Void, Void, Void> {
    private static final int GAID_FETCH_TIME_OUT = 1500;
    private final SystemObserver.AdsParamsFetchEvents callback_;
    private WeakReference<Context> contextRef_;

    GAdsPrefetchTask(Context context, SystemObserver.AdsParamsFetchEvents adsParamsFetchEvents) {
        this.contextRef_ = new WeakReference((Object)context);
        this.callback_ = adsParamsFetchEvents;
    }

    /*
     * Exception decompiling
     */
    private Object getAdInfoObject(Context var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl26 : ACONST_NULL : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    private void setGAIDWithAdvertisingIdClient(SystemObserver systemObserver, Object object) {
        try {
            systemObserver.setGAID((String)object.getClass().getMethod("getId", new Class[0]).invoke(object, new Object[0]));
        }
        catch (Exception exception) {}
    }

    /*
     * Exception decompiling
     */
    private void setGoogleLATWithAdvertisingIdClient(SystemObserver var1, Object var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl31 : RETURN : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    protected /* varargs */ Void doInBackground(Void ... arrvoid) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable(){

            public void run() {
                Context context = (Context)GAdsPrefetchTask.this.contextRef_.get();
                if (context != null) {
                    SystemObserver systemObserver;
                    Process.setThreadPriority((int)-19);
                    Object object = GAdsPrefetchTask.this.getAdInfoObject(context);
                    DeviceInfo deviceInfo = DeviceInfo.getInstance();
                    if (deviceInfo == null) {
                        deviceInfo = DeviceInfo.initialize(context);
                    }
                    if ((systemObserver = deviceInfo.getSystemObserver()) != null) {
                        GAdsPrefetchTask.this.setGoogleLATWithAdvertisingIdClient(systemObserver, object);
                        if (systemObserver.getLATVal() == 1) {
                            systemObserver.setGAID(null);
                        } else {
                            GAdsPrefetchTask.this.setGAIDWithAdvertisingIdClient(systemObserver, object);
                        }
                    }
                }
                countDownLatch.countDown();
            }
        }).start();
        try {
            countDownLatch.await(1500L, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Void void_) {
        super.onPostExecute((Object)void_);
        SystemObserver.AdsParamsFetchEvents adsParamsFetchEvents = this.callback_;
        if (adsParamsFetchEvents != null) {
            adsParamsFetchEvents.onAdsParamsFetchFinished();
        }
    }

}

