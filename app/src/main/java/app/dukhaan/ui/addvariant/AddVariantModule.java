/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.addvariant.AddVariantViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.addvariant;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.addvariant.AddVariantViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class AddVariantModule {
    @Provides
    ViewModelProvider.Factory addVariantsViewModelProvider(AddVariantViewModel addVariantViewModel) {
        return new ViewModelProviderFactory((Object)addVariantViewModel);
    }

    @Provides
    AddVariantViewModel provideAddVariantsViewModel(DataRepository dataRepository, ApiService apiService) {
        return new AddVariantViewModel(dataRepository, apiService);
    }
}

