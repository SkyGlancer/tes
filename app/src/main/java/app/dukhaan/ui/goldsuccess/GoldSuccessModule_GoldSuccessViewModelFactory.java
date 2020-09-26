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
package app.dukhaan.ui.goldsuccess;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.goldsuccess.GoldSuccessModule;
import app.dukhaan.ui.goldsuccess.GoldSuccessViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class GoldSuccessModule_GoldSuccessViewModelFactory
implements Factory<GoldSuccessViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final GoldSuccessModule module;

    public GoldSuccessModule_GoldSuccessViewModelFactory(GoldSuccessModule goldSuccessModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = goldSuccessModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static GoldSuccessModule_GoldSuccessViewModelFactory create(GoldSuccessModule goldSuccessModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new GoldSuccessModule_GoldSuccessViewModelFactory(goldSuccessModule, provider, provider2);
    }

    public static GoldSuccessViewModel goldSuccessViewModel(GoldSuccessModule goldSuccessModule, DataRepository dataRepository, ApiService apiService) {
        return (GoldSuccessViewModel)((Object)Preconditions.checkNotNull((Object)((Object)goldSuccessModule.goldSuccessViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public GoldSuccessViewModel get() {
        return GoldSuccessModule_GoldSuccessViewModelFactory.goldSuccessViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

