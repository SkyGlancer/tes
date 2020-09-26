/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.MembersInjector
 *  java.lang.Object
 *  javax.inject.Provider
 */
package app.dukhaan.ui.products;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.products.ProductsFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ProductsFragment_MembersInjector
implements MembersInjector<ProductsFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public ProductsFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<ProductsFragment> create(Provider<ViewModelProvider.Factory> provider) {
        return new ProductsFragment_MembersInjector(provider);
    }

    public void injectMembers(ProductsFragment productsFragment) {
        BaseFragment_MembersInjector.injectViewModelFactory(productsFragment, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

