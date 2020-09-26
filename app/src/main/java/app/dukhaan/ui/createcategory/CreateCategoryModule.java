/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.createcategory.CreateCategoriesViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.createcategory;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.createcategory.CreateCategoriesViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class CreateCategoryModule {
    @Provides
    ViewModelProvider.Factory createCategoriesViewModelProvider(CreateCategoriesViewModel createCategoriesViewModel) {
        return new ViewModelProviderFactory((Object)createCategoriesViewModel);
    }

    @Provides
    CreateCategoriesViewModel provideCreateCategoriesViewModel(DataRepository dataRepository, ApiService apiService) {
        return new CreateCategoriesViewModel(dataRepository, apiService);
    }
}

