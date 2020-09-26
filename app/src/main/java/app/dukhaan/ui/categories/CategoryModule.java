/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.categories.CategoriesViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.categories;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.categories.CategoriesViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class CategoryModule {
    @Provides
    ViewModelProvider.Factory categoriesViewModelProvider(CategoriesViewModel categoriesViewModel) {
        return new ViewModelProviderFactory((Object)categoriesViewModel);
    }

    @Provides
    CategoriesViewModel provideCategoriesViewModel(DataRepository dataRepository, ApiService apiService) {
        return new CategoriesViewModel(dataRepository, apiService);
    }
}

