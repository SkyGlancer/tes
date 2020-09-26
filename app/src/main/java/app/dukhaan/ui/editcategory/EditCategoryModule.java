/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.editcategory.EditCategoriesViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.editcategory;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.editcategory.EditCategoriesViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class EditCategoryModule {
    @Provides
    ViewModelProvider.Factory editCategoriesViewModelProvider(EditCategoriesViewModel editCategoriesViewModel) {
        return new ViewModelProviderFactory((Object)editCategoriesViewModel);
    }

    @Provides
    EditCategoriesViewModel provideEditCategoriesViewModel(DataRepository dataRepository, ApiService apiService) {
        return new EditCategoriesViewModel(dataRepository, apiService);
    }
}

