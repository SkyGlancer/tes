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
package app.dukhaan.ui.catalogue;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.catalogue.CatalogueModule;
import app.dukhaan.ui.catalogue.CatalogueViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CatalogueModule_ProvideCatalogueStepsViewModelFactory
implements Factory<CatalogueViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final CatalogueModule module;

    public CatalogueModule_ProvideCatalogueStepsViewModelFactory(CatalogueModule catalogueModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = catalogueModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static CatalogueModule_ProvideCatalogueStepsViewModelFactory create(CatalogueModule catalogueModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new CatalogueModule_ProvideCatalogueStepsViewModelFactory(catalogueModule, provider, provider2);
    }

    public static CatalogueViewModel provideCatalogueStepsViewModel(CatalogueModule catalogueModule, DataRepository dataRepository, ApiService apiService) {
        return (CatalogueViewModel)((Object)Preconditions.checkNotNull((Object)((Object)catalogueModule.provideCatalogueStepsViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public CatalogueViewModel get() {
        return CatalogueModule_ProvideCatalogueStepsViewModelFactory.provideCatalogueStepsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

