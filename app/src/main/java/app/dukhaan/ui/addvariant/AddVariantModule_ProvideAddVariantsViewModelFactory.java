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
package app.dukhaan.ui.addvariant;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.addvariant.AddVariantModule;
import app.dukhaan.ui.addvariant.AddVariantViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AddVariantModule_ProvideAddVariantsViewModelFactory
implements Factory<AddVariantViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final AddVariantModule module;

    public AddVariantModule_ProvideAddVariantsViewModelFactory(AddVariantModule addVariantModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = addVariantModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static AddVariantModule_ProvideAddVariantsViewModelFactory create(AddVariantModule addVariantModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new AddVariantModule_ProvideAddVariantsViewModelFactory(addVariantModule, provider, provider2);
    }

    public static AddVariantViewModel provideAddVariantsViewModel(AddVariantModule addVariantModule, DataRepository dataRepository, ApiService apiService) {
        return (AddVariantViewModel)((Object)Preconditions.checkNotNull((Object)((Object)addVariantModule.provideAddVariantsViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public AddVariantViewModel get() {
        return AddVariantModule_ProvideAddVariantsViewModelFactory.provideAddVariantsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

