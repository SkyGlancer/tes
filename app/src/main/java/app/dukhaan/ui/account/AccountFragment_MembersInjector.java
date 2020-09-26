/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.MembersInjector
 *  java.lang.Object
 *  javax.inject.Provider
 */
package app.dukhaan.ui.account;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.account.AccountFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AccountFragment_MembersInjector
implements MembersInjector<AccountFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public AccountFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<AccountFragment> create(Provider<ViewModelProvider.Factory> provider) {
        return new AccountFragment_MembersInjector(provider);
    }

    public void injectMembers(AccountFragment accountFragment) {
        BaseFragment_MembersInjector.injectViewModelFactory(accountFragment, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

