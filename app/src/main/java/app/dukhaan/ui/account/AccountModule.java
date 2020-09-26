/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.account.AccountViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.account;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.account.AccountViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class AccountModule {
    @Provides
    ViewModelProvider.Factory accountViewModelProvider(AccountViewModel accountViewModel) {
        return new ViewModelProviderFactory((Object)accountViewModel);
    }

    @Provides
    AccountViewModel provideAccountViewModel(DataRepository dataRepository, ApiService apiService) {
        return new AccountViewModel(dataRepository, apiService);
    }
}

