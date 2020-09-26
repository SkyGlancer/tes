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
package app.dukhaan.ui.privacy;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.privacy.PrivacyPolicyModule;
import app.dukhaan.ui.privacy.PrivacyPolicyViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PrivacyPolicyModule_ProvidePrivacyPolicyViewModelFactory
implements Factory<PrivacyPolicyViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final PrivacyPolicyModule module;

    public PrivacyPolicyModule_ProvidePrivacyPolicyViewModelFactory(PrivacyPolicyModule privacyPolicyModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = privacyPolicyModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static PrivacyPolicyModule_ProvidePrivacyPolicyViewModelFactory create(PrivacyPolicyModule privacyPolicyModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new PrivacyPolicyModule_ProvidePrivacyPolicyViewModelFactory(privacyPolicyModule, provider, provider2);
    }

    public static PrivacyPolicyViewModel providePrivacyPolicyViewModel(PrivacyPolicyModule privacyPolicyModule, DataRepository dataRepository, ApiService apiService) {
        return (PrivacyPolicyViewModel)((Object)Preconditions.checkNotNull((Object)((Object)privacyPolicyModule.providePrivacyPolicyViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public PrivacyPolicyViewModel get() {
        return PrivacyPolicyModule_ProvidePrivacyPolicyViewModelFactory.providePrivacyPolicyViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

