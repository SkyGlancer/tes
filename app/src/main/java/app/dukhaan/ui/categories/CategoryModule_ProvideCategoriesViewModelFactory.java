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
package app.dukhaan.ui.categories;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.categories.CategoriesViewModel;
import app.dukhaan.ui.categories.CategoryModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CategoryModule_ProvideCategoriesViewModelFactory
implements Factory<CategoriesViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final CategoryModule module;

    public CategoryModule_ProvideCategoriesViewModelFactory(CategoryModule categoryModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = categoryModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static CategoryModule_ProvideCategoriesViewModelFactory create(CategoryModule categoryModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new CategoryModule_ProvideCategoriesViewModelFactory(categoryModule, provider, provider2);
    }

    public static CategoriesViewModel provideCategoriesViewModel(CategoryModule categoryModule, DataRepository dataRepository, ApiService apiService) {
        return (CategoriesViewModel)((Object)Preconditions.checkNotNull((Object)((Object)categoryModule.provideCategoriesViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public CategoriesViewModel get() {
        return CategoryModule_ProvideCategoriesViewModelFactory.provideCategoriesViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

