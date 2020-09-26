/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.Request
 *  okhttp3.Response
 *  org.greenrobot.eventbus.EventBus
 */
package app.dukhaan.network.interceptor;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import app.dukhaan.network.interceptor.NoConnectivityEvent;
import app.dukhaan.network.interceptor.NoConnectivityException;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.greenrobot.eventbus.EventBus;

public class ConnectivityInterceptor
implements Interceptor {
    private Context context;

    public ConnectivityInterceptor(Context context) {
        this.context = context;
    }

    private boolean isNetworkAvailable() {
        NetworkInfo networkInfo = ((ConnectivityManager)this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    public Response intercept(Chain chain) throws IOException {
        if (this.isNetworkAvailable()) {
            return chain.proceed(chain.request());
        }
        EventBus.getDefault().post((Object)NoConnectivityEvent.instance());
        throw new NoConnectivityException(this.context);
    }
}

