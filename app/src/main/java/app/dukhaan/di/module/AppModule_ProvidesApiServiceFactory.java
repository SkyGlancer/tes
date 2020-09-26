/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 *  retrofit2.Retrofit
 */
package app.dukhaan.di.module;

import app.dukhaan.di.module.AppModule;
import app.dukhaan.network.ApiService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class AppModule_ProvidesApiServiceFactory
implements Factory<ApiService> {
    private final AppModule module;
    private final Provider<Retrofit> retrofitProvider;

    public AppModule_ProvidesApiServiceFactory(AppModule appModule, Provider<Retrofit> provider) {
        this.module = appModule;
        this.retrofitProvider = provider;
    }

    public static AppModule_ProvidesApiServiceFactory create(AppModule appModule, Provider<Retrofit> provider) {
        return new AppModule_ProvidesApiServiceFactory(appModule, provider);
    }

    public static ApiService providesApiService(AppModule appModule, Retrofit retrofit) {
        return (ApiService)Preconditions.checkNotNull((Object)appModule.providesApiService(retrofit), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ApiService get() {
        return AppModule_ProvidesApiServiceFactory.providesApiService(this.module, (Retrofit)this.retrofitProvider.get());
    }
}

