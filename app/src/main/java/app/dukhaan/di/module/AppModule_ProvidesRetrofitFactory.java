/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 *  okhttp3.OkHttpClient
 *  retrofit2.Retrofit
 */
package app.dukhaan.di.module;

import app.dukhaan.di.module.AppModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class AppModule_ProvidesRetrofitFactory
implements Factory<Retrofit> {
    private final AppModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public AppModule_ProvidesRetrofitFactory(AppModule appModule, Provider<OkHttpClient> provider) {
        this.module = appModule;
        this.okHttpClientProvider = provider;
    }

    public static AppModule_ProvidesRetrofitFactory create(AppModule appModule, Provider<OkHttpClient> provider) {
        return new AppModule_ProvidesRetrofitFactory(appModule, provider);
    }

    public static Retrofit providesRetrofit(AppModule appModule, OkHttpClient okHttpClient) {
        return (Retrofit)Preconditions.checkNotNull((Object)appModule.providesRetrofit(okHttpClient), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public Retrofit get() {
        return AppModule_ProvidesRetrofitFactory.providesRetrofit(this.module, (OkHttpClient)this.okHttpClientProvider.get());
    }
}

