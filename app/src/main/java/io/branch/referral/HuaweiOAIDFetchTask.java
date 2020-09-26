/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.lang.reflect.Method
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.TimeUnit
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.Context;
import android.text.TextUtils;
import io.branch.referral.BranchAsyncTask;
import io.branch.referral.DeviceInfo;
import io.branch.referral.PrefHelper;
import io.branch.referral.SystemObserver;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class HuaweiOAIDFetchTask
extends BranchAsyncTask<Void, Void, Void> {
    private static final int OAID_FETCH_TIME_OUT = 1500;
    private final SystemObserver.AdsParamsFetchEvents callback_;
    private WeakReference<Context> contextRef_;

    HuaweiOAIDFetchTask(Context context, SystemObserver.AdsParamsFetchEvents adsParamsFetchEvents) {
        this.contextRef_ = new WeakReference((Object)context);
        this.callback_ = adsParamsFetchEvents;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void setOAID(Context context) {
        int n;
        Boolean bl;
        SystemObserver systemObserver;
        String string2;
        block5 : {
            block4 : {
                try {
                    Class class_ = Class.forName((String)"com.huawei.hms.ads.identifier.AdvertisingIdClient");
                    n = 1;
                    Class[] arrclass = new Class[n];
                    arrclass[0] = Context.class;
                    Method method = class_.getDeclaredMethod("getAdvertisingIdInfo", arrclass);
                    Object[] arrobject = new Object[n];
                    arrobject[0] = context;
                    Object object = method.invoke(null, arrobject);
                    string2 = object.getClass().getDeclaredMethod("getId", new Class[0]).invoke(object, new Object[0]).toString();
                    bl = (Boolean)object.getClass().getDeclaredMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(object, new Object[0]);
                    DeviceInfo deviceInfo = DeviceInfo.getInstance();
                    if (deviceInfo == null) {
                        deviceInfo = DeviceInfo.initialize(context);
                    }
                    systemObserver = deviceInfo.getSystemObserver();
                    systemObserver.setGAID(string2);
                    if (!bl.booleanValue()) break block4;
                    break block5;
                }
                catch (Throwable throwable) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("failed to retrieve OAID, error = ");
                    stringBuilder.append((Object)throwable);
                    PrefHelper.Debug(stringBuilder.toString());
                    return;
                }
            }
            n = 0;
        }
        systemObserver.setLAT(n);
        if (!TextUtils.isEmpty((CharSequence)string2) && !string2.equals((Object)"00000000-0000-0000-0000-000000000000") && !bl.booleanValue()) return;
        {
            systemObserver.setGAID(null);
            return;
        }
    }

    protected /* varargs */ Void doInBackground(Void ... arrvoid) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable(){

            public void run() {
                Context context = (Context)HuaweiOAIDFetchTask.this.contextRef_.get();
                if (context != null) {
                    HuaweiOAIDFetchTask.this.setOAID(context);
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

