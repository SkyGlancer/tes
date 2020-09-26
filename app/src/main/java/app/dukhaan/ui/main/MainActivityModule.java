/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.main.MainActivityViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.main;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.main.MainActivityViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    @Provides
    ViewModelProvider.Factory businessDetailsViewModelProvider(MainActivityViewModel mainActivityViewModel) {
        return new ViewModelProviderFactory((Object)mainActivityViewModel);
    }

    @Provides
    MainActivityViewModel provideBusinessDetailsViewModel(DataRepository dataRepository, ApiService apiService) {
        return new MainActivityViewModel(dataRepository, apiService);
    }
}

