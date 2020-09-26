/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.products;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.products.ProductModule;
import app.dukhaan.ui.products.ProductsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ProductModule_ProvideOrdersListViewModelFactory
implements Factory<ProductsViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final ProductModule module;

    public ProductModule_ProvideOrdersListViewModelFactory(ProductModule productModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = productModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static ProductModule_ProvideOrdersListViewModelFactory create(ProductModule productModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new ProductModule_ProvideOrdersListViewModelFactory(productModule, provider, provider2);
    }

    public static ProductsViewModel provideOrdersListViewModel(ProductModule productModule, DataRepository dataRepository, ApiService apiService) {
        return (ProductsViewModel)((Object)Preconditions.checkNotNull((Object)((Object)productModule.provideOrdersListViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public ProductsViewModel get() {
        return ProductModule_ProvideOrdersListViewModelFactory.provideOrdersListViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

