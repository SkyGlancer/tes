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
package app.dukhaan.ui.account;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.account.AccountModule;
import app.dukhaan.ui.account.AccountViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AccountModule_ProvideAccountViewModelFactory
implements Factory<AccountViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final AccountModule module;

    public AccountModule_ProvideAccountViewModelFactory(AccountModule accountModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = accountModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static AccountModule_ProvideAccountViewModelFactory create(AccountModule accountModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new AccountModule_ProvideAccountViewModelFactory(accountModule, provider, provider2);
    }

    public static AccountViewModel provideAccountViewModel(AccountModule accountModule, DataRepository dataRepository, ApiService apiService) {
        return (AccountViewModel)((Object)Preconditions.checkNotNull((Object)((Object)accountModule.provideAccountViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public AccountViewModel get() {
        return AccountModule_ProvideAccountViewModelFactory.provideAccountViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

