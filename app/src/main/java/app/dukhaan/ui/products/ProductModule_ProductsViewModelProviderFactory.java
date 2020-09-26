/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.products;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.products.ProductModule;
import app.dukhaan.ui.products.ProductsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ProductModule_ProductsViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final ProductModule module;
    private final Provider<ProductsViewModel> viewModelProvider;

    public ProductModule_ProductsViewModelProviderFactory(ProductModule productModule, Provider<ProductsViewModel> provider) {
        this.module = productModule;
        this.viewModelProvider = provider;
    }

    public static ProductModule_ProductsViewModelProviderFactory create(ProductModule productModule, Provider<ProductsViewModel> provider) {
        return new ProductModule_ProductsViewModelProviderFactory(productModule, provider);
    }

    public static ViewModelProvider.Factory productsViewModelProvider(ProductModule productModule, ProductsViewModel productsViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)productModule.productsViewModelProvider(productsViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return ProductModule_ProductsViewModelProviderFactory.productsViewModelProvider(this.module, (ProductsViewModel)((Object)this.viewModelProvider.get()));
    }
}

