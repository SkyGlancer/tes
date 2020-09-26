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
package app.dukhaan.ui.catalogue;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.catalogue.CatalogueFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CatalogueFragment_MembersInjector
implements MembersInjector<CatalogueFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public CatalogueFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<CatalogueFragment> create(Provider<ViewModelProvider.Factory> provider) {
        return new CatalogueFragment_MembersInjector(provider);
    }

    public void injectMembers(CatalogueFragment catalogueFragment) {
        BaseFragment_MembersInjector.injectViewModelFactory(catalogueFragment, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

