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
package app.dukhaan.ui.addbusiness;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.addbusiness.AddBusinessModule;
import app.dukhaan.ui.addbusiness.AddBusinessViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AddBusinessModule_ProvideBusinessDetailsViewModelFactory
implements Factory<AddBusinessViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final AddBusinessModule module;

    public AddBusinessModule_ProvideBusinessDetailsViewModelFactory(AddBusinessModule addBusinessModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = addBusinessModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static AddBusinessModule_ProvideBusinessDetailsViewModelFactory create(AddBusinessModule addBusinessModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new AddBusinessModule_ProvideBusinessDetailsViewModelFactory(addBusinessModule, provider, provider2);
    }

    public static AddBusinessViewModel provideBusinessDetailsViewModel(AddBusinessModule addBusinessModule, DataRepository dataRepository, ApiService apiService) {
        return (AddBusinessViewModel)((Object)Preconditions.checkNotNull((Object)((Object)addBusinessModule.provideBusinessDetailsViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public AddBusinessViewModel get() {
        return AddBusinessModule_ProvideBusinessDetailsViewModelFactory.provideBusinessDetailsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

