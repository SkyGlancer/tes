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
package app.dukhaan.ui.home;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.home.HomeModule;
import app.dukhaan.ui.home.HomeViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class HomeModule_ProvideAboutViewModelFactory
implements Factory<HomeViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final HomeModule module;

    public HomeModule_ProvideAboutViewModelFactory(HomeModule homeModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = homeModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static HomeModule_ProvideAboutViewModelFactory create(HomeModule homeModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new HomeModule_ProvideAboutViewModelFactory(homeModule, provider, provider2);
    }

    public static HomeViewModel provideAboutViewModel(HomeModule homeModule, DataRepository dataRepository, ApiService apiService) {
        return (HomeViewModel)((Object)Preconditions.checkNotNull((Object)((Object)homeModule.provideAboutViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public HomeViewModel get() {
        return HomeModule_ProvideAboutViewModelFactory.provideAboutViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

