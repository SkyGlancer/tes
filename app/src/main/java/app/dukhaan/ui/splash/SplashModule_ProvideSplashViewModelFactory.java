/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.splash;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.splash.SplashModule;
import app.dukhaan.ui.splash.SplashViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SplashModule_ProvideSplashViewModelFactory
implements Factory<SplashViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final SplashModule module;

    public SplashModule_ProvideSplashViewModelFactory(SplashModule splashModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = splashModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static SplashModule_ProvideSplashViewModelFactory create(SplashModule splashModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new SplashModule_ProvideSplashViewModelFactory(splashModule, provider, provider2);
    }

    public static SplashViewModel provideSplashViewModel(SplashModule splashModule, DataRepository dataRepository, ApiService apiService) {
        return (SplashViewModel)((Object)Preconditions.checkNotNull((Object)((Object)splashModule.provideSplashViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public SplashViewModel get() {
        return SplashModule_ProvideSplashViewModelFactory.provideSplashViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

