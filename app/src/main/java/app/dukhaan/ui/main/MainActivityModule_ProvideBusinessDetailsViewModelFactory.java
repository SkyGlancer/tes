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
package app.dukhaan.ui.main;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.main.MainActivityModule;
import app.dukhaan.ui.main.MainActivityViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MainActivityModule_ProvideBusinessDetailsViewModelFactory
implements Factory<MainActivityViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final MainActivityModule module;

    public MainActivityModule_ProvideBusinessDetailsViewModelFactory(MainActivityModule mainActivityModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = mainActivityModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static MainActivityModule_ProvideBusinessDetailsViewModelFactory create(MainActivityModule mainActivityModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new MainActivityModule_ProvideBusinessDetailsViewModelFactory(mainActivityModule, provider, provider2);
    }

    public static MainActivityViewModel provideBusinessDetailsViewModel(MainActivityModule mainActivityModule, DataRepository dataRepository, ApiService apiService) {
        return (MainActivityViewModel)((Object)Preconditions.checkNotNull((Object)((Object)mainActivityModule.provideBusinessDetailsViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public MainActivityViewModel get() {
        return MainActivityModule_ProvideBusinessDetailsViewModelFactory.provideBusinessDetailsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

