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
package app.dukhaan.ui.catalogue;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.catalogue.CatalogueModule;
import app.dukhaan.ui.catalogue.CatalogueViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CatalogueModule_CatalogueViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final CatalogueModule module;
    private final Provider<CatalogueViewModel> viewModelProvider;

    public CatalogueModule_CatalogueViewModelProviderFactory(CatalogueModule catalogueModule, Provider<CatalogueViewModel> provider) {
        this.module = catalogueModule;
        this.viewModelProvider = provider;
    }

    public static ViewModelProvider.Factory catalogueViewModelProvider(CatalogueModule catalogueModule, CatalogueViewModel catalogueViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)catalogueModule.catalogueViewModelProvider(catalogueViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public static CatalogueModule_CatalogueViewModelProviderFactory create(CatalogueModule catalogueModule, Provider<CatalogueViewModel> provider) {
        return new CatalogueModule_CatalogueViewModelProviderFactory(catalogueModule, provider);
    }

    public ViewModelProvider.Factory get() {
        return CatalogueModule_CatalogueViewModelProviderFactory.catalogueViewModelProvider(this.module, (CatalogueViewModel)((Object)this.viewModelProvider.get()));
    }
}

