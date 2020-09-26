/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.Response
 */
package app.dukhaan.di.module;

import app.dukhaan.data.local.AppPref;
import app.dukhaan.di.module.AppModule;
import okhttp3.Interceptor;
import okhttp3.Response;

public final class -$$Lambda$AppModule$knjnQI967zK0SHBIsOrTNp71zxI
implements Interceptor {
    public final /* synthetic */ AppPref f$0;

    public /* synthetic */ -$$Lambda$AppModule$knjnQI967zK0SHBIsOrTNp71zxI(AppPref appPref) {
        this.f$0 = appPref;
    }

    public final Response intercept(Interceptor.Chain chain) {
        return AppModule.lambda$providesOkHttpClient$1(this.f$0, chain);
    }
}

