/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.editproduct.EditProductViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.editproduct;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.editproduct.EditProductViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class EditProdutModule {
    @Provides
    ViewModelProvider.Factory editProductViewModelProvider(EditProductViewModel editProductViewModel) {
        return new ViewModelProviderFactory((Object)editProductViewModel);
    }

    @Provides
    EditProductViewModel provideEditProductViewModel(DataRepository dataRepository, ApiService apiService) {
        return new EditProductViewModel(dataRepository, apiService);
    }
}

