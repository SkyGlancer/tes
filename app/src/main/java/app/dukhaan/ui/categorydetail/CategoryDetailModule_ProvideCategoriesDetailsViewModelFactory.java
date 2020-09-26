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
package app.dukhaan.ui.categorydetail;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.categorydetail.CategoryDetailModule;
import app.dukhaan.ui.categorydetail.CategoryDetailViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CategoryDetailModule_ProvideCategoriesDetailsViewModelFactory
implements Factory<CategoryDetailViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final CategoryDetailModule module;

    public CategoryDetailModule_ProvideCategoriesDetailsViewModelFactory(CategoryDetailModule categoryDetailModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = categoryDetailModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static CategoryDetailModule_ProvideCategoriesDetailsViewModelFactory create(CategoryDetailModule categoryDetailModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new CategoryDetailModule_ProvideCategoriesDetailsViewModelFactory(categoryDetailModule, provider, provider2);
    }

    public static CategoryDetailViewModel provideCategoriesDetailsViewModel(CategoryDetailModule categoryDetailModule, DataRepository dataRepository, ApiService apiService) {
        return (CategoryDetailViewModel)((Object)Preconditions.checkNotNull((Object)((Object)categoryDetailModule.provideCategoriesDetailsViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public CategoryDetailViewModel get() {
        return CategoryDetailModule_ProvideCategoriesDetailsViewModelFactory.provideCategoriesDetailsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

