/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.products.ProductsViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.products;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.products.ProductsViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class ProductModule {
    @Provides
    ViewModelProvider.Factory productsViewModelProvider(ProductsViewModel productsViewModel) {
        return new ViewModelProviderFactory((Object)productsViewModel);
    }

    @Provides
    ProductsViewModel provideOrdersListViewModel(DataRepository dataRepository, ApiService apiService) {
        return new ProductsViewModel(dataRepository, apiService);
    }
}

