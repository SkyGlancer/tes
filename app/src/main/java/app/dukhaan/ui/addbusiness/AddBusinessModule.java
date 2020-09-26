/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.addbusiness.AddBusinessViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.addbusiness;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.addbusiness.AddBusinessViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class AddBusinessModule {
    @Provides
    ViewModelProvider.Factory businessDetailsViewModelProvider(AddBusinessViewModel addBusinessViewModel) {
        return new ViewModelProviderFactory((Object)addBusinessViewModel);
    }

    @Provides
    AddBusinessViewModel provideBusinessDetailsViewModel(DataRepository dataRepository, ApiService apiService) {
        return new AddBusinessViewModel(dataRepository, apiService);
    }
}

