/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.goldsuccess.GoldSuccessViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.goldsuccess;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.goldsuccess.GoldSuccessViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class GoldSuccessModule {
    @Provides
    GoldSuccessViewModel goldSuccessViewModel(DataRepository dataRepository, ApiService apiService) {
        return new GoldSuccessViewModel(dataRepository, apiService);
    }

    @Provides
    ViewModelProvider.Factory goldSuccessViewModelProvider(GoldSuccessViewModel goldSuccessViewModel) {
        return new ViewModelProviderFactory((Object)goldSuccessViewModel);
    }
}

