/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  java.io.Reader
 *  java.lang.Class
 *  java.lang.Object
 *  okhttp3.ResponseBody
 */
package app.dukhaan.network.interceptor;

import app.dukhaan.network.ErrorResponse;
import com.google.gson.Gson;
import java.io.Reader;
import okhttp3.ResponseBody;

public class UnauthorizedEvent {
    private ErrorResponse error;

    private UnauthorizedEvent(ResponseBody responseBody) {
        this.error = (ErrorResponse)new Gson().fromJson(responseBody.charStream(), ErrorResponse.class);
    }

    public static UnauthorizedEvent instance(ResponseBody responseBody) {
        return new UnauthorizedEvent(responseBody);
    }

    public ErrorResponse getError() {
        return this.error;
    }
}

