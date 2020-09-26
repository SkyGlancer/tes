/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  okhttp3.logging.HttpLoggingInterceptor
 */
package app.dukhaan.di.module;

import app.dukhaan.di.module.AppModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.logging.HttpLoggingInterceptor;

public final class AppModule_ProvidesHttpLoggingInterceptorFactory
implements Factory<HttpLoggingInterceptor> {
    private final AppModule module;

    public AppModule_ProvidesHttpLoggingInterceptorFactory(AppModule appModule) {
        this.module = appModule;
    }

    public static AppModule_ProvidesHttpLoggingInterceptorFactory create(AppModule appModule) {
        return new AppModule_ProvidesHttpLoggingInterceptorFactory(appModule);
    }

    public static HttpLoggingInterceptor providesHttpLoggingInterceptor(AppModule appModule) {
        return (HttpLoggingInterceptor)Preconditions.checkNotNull((Object)appModule.providesHttpLoggingInterceptor(), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public HttpLoggingInterceptor get() {
        return AppModule_ProvidesHttpLoggingInterceptorFactory.providesHttpLoggingInterceptor(this.module);
    }
}

