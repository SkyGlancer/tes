/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.account;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.account.AccountModule;
import app.dukhaan.ui.account.AccountViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AccountModule_AccountViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final AccountModule module;
    private final Provider<AccountViewModel> viewModelProvider;

    public AccountModule_AccountViewModelProviderFactory(AccountModule accountModule, Provider<AccountViewModel> provider) {
        this.module = accountModule;
        this.viewModelProvider = provider;
    }

    public static ViewModelProvider.Factory accountViewModelProvider(AccountModule accountModule, AccountViewModel accountViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)accountModule.accountViewModelProvider(accountViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public static AccountModule_AccountViewModelProviderFactory create(AccountModule accountModule, Provider<AccountViewModel> provider) {
        return new AccountModule_AccountViewModelProviderFactory(accountModule, provider);
    }

    public ViewModelProvider.Factory get() {
        return AccountModule_AccountViewModelProviderFactory.accountViewModelProvider(this.module, (AccountViewModel)((Object)this.viewModelProvider.get()));
    }
}

