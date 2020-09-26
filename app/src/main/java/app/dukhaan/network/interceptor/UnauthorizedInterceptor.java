/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.Request
 *  okhttp3.Response
 */
package app.dukhaan.network.interceptor;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class UnauthorizedInterceptor
implements Interceptor {
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        response.code();
        return response;
    }
}

