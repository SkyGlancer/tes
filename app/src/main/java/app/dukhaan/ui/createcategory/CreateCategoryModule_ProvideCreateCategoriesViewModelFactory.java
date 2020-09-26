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
package app.dukhaan.ui.createcategory;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.createcategory.CreateCategoriesViewModel;
import app.dukhaan.ui.createcategory.CreateCategoryModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CreateCategoryModule_ProvideCreateCategoriesViewModelFactory
implements Factory<CreateCategoriesViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final CreateCategoryModule module;

    public CreateCategoryModule_ProvideCreateCategoriesViewModelFactory(CreateCategoryModule createCategoryModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = createCategoryModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static CreateCategoryModule_ProvideCreateCategoriesViewModelFactory create(CreateCategoryModule createCategoryModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new CreateCategoryModule_ProvideCreateCategoriesViewModelFactory(createCategoryModule, provider, provider2);
    }

    public static CreateCategoriesViewModel provideCreateCategoriesViewModel(CreateCategoryModule createCategoryModule, DataRepository dataRepository, ApiService apiService) {
        return (CreateCategoriesViewModel)((Object)Preconditions.checkNotNull((Object)((Object)createCategoryModule.provideCreateCategoriesViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public CreateCategoriesViewModel get() {
        return CreateCategoryModule_ProvideCreateCategoriesViewModelFactory.provideCreateCategoriesViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

