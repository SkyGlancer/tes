/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 *  okhttp3.OkHttpClient
 *  okhttp3.logging.HttpLoggingInterceptor
 */
package app.dukhaan.di.module;

import android.content.Context;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.di.module.AppModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public final class AppModule_ProvidesOkHttpClientFactory
implements Factory<OkHttpClient> {
    private final Provider<AppPref> appPrefProvider;
    private final Provider<Context> contextProvider;
    private final Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider;
    private final AppModule module;

    public AppModule_ProvidesOkHttpClientFactory(AppModule appModule, Provider<HttpLoggingInterceptor> provider, Provider<Context> provider2, Provider<AppPref> provider3) {
        this.module = appModule;
        this.httpLoggingInterceptorProvider = provider;
        this.contextProvider = provider2;
        this.appPrefProvider = provider3;
    }

    public static AppModule_ProvidesOkHttpClientFactory create(AppModule appModule, Provider<HttpLoggingInterceptor> provider, Provider<Context> provider2, Provider<AppPref> provider3) {
        return new AppModule_ProvidesOkHttpClientFactory(appModule, provider, provider2, provider3);
    }

    public static OkHttpClient providesOkHttpClient(AppModule appModule, HttpLoggingInterceptor httpLoggingInterceptor, Context context, AppPref appPref) {
        return (OkHttpClient)Preconditions.checkNotNull((Object)appModule.providesOkHttpClient(httpLoggingInterceptor, context, appPref), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public OkHttpClient get() {
        return AppModule_ProvidesOkHttpClientFactory.providesOkHttpClient(this.module, (HttpLoggingInterceptor)this.httpLoggingInterceptorProvider.get(), (Context)this.contextProvider.get(), (AppPref)this.appPrefProvider.get());
    }
}

