/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.catalogue.CatalogueViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.catalogue;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.catalogue.CatalogueViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class CatalogueModule {
    @Provides
    ViewModelProvider.Factory catalogueViewModelProvider(CatalogueViewModel catalogueViewModel) {
        return new ViewModelProviderFactory((Object)catalogueViewModel);
    }

    @Provides
    CatalogueViewModel provideCatalogueStepsViewModel(DataRepository dataRepository, ApiService apiService) {
        return new CatalogueViewModel(dataRepository, apiService);
    }
}

