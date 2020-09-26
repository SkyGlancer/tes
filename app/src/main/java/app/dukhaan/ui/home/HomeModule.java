/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.home.HomeViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.home;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.home.HomeViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {
    @Provides
    ViewModelProvider.Factory mobileNumberViewModelProvider(HomeViewModel homeViewModel) {
        return new ViewModelProviderFactory((Object)homeViewModel);
    }

    @Provides
    HomeViewModel provideAboutViewModel(DataRepository dataRepository, ApiService apiService) {
        return new HomeViewModel(dataRepository, apiService);
    }
}

