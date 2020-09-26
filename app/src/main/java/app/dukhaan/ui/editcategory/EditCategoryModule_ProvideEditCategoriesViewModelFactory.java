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
package app.dukhaan.ui.editcategory;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.editcategory.EditCategoriesViewModel;
import app.dukhaan.ui.editcategory.EditCategoryModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class EditCategoryModule_ProvideEditCategoriesViewModelFactory
implements Factory<EditCategoriesViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final EditCategoryModule module;

    public EditCategoryModule_ProvideEditCategoriesViewModelFactory(EditCategoryModule editCategoryModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = editCategoryModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static EditCategoryModule_ProvideEditCategoriesViewModelFactory create(EditCategoryModule editCategoryModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new EditCategoryModule_ProvideEditCategoriesViewModelFactory(editCategoryModule, provider, provider2);
    }

    public static EditCategoriesViewModel provideEditCategoriesViewModel(EditCategoryModule editCategoryModule, DataRepository dataRepository, ApiService apiService) {
        return (EditCategoriesViewModel)((Object)Preconditions.checkNotNull((Object)((Object)editCategoryModule.provideEditCategoriesViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public EditCategoriesViewModel get() {
        return EditCategoryModule_ProvideEditCategoriesViewModelFactory.provideEditCategoriesViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

