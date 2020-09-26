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
package app.dukhaan.ui.verifymobile;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.verifymobile.VerifyMobileModule;
import app.dukhaan.ui.verifymobile.VerifyMobileViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class VerifyMobileModule_ProvideVerifyMobileViewModelFactory
implements Factory<VerifyMobileViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final VerifyMobileModule module;

    public VerifyMobileModule_ProvideVerifyMobileViewModelFactory(VerifyMobileModule verifyMobileModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = verifyMobileModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static VerifyMobileModule_ProvideVerifyMobileViewModelFactory create(VerifyMobileModule verifyMobileModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new VerifyMobileModule_ProvideVerifyMobileViewModelFactory(verifyMobileModule, provider, provider2);
    }

    public static VerifyMobileViewModel provideVerifyMobileViewModel(VerifyMobileModule verifyMobileModule, DataRepository dataRepository, ApiService apiService) {
        return (VerifyMobileViewModel)((Object)Preconditions.checkNotNull((Object)((Object)verifyMobileModule.provideVerifyMobileViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public VerifyMobileViewModel get() {
        return VerifyMobileModule_ProvideVerifyMobileViewModelFactory.provideVerifyMobileViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

