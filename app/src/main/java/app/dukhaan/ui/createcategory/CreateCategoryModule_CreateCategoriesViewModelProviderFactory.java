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
package app.dukhaan.ui.createcategory;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.createcategory.CreateCategoriesViewModel;
import app.dukhaan.ui.createcategory.CreateCategoryModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CreateCategoryModule_CreateCategoriesViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final CreateCategoryModule module;
    private final Provider<CreateCategoriesViewModel> viewModelProvider;

    public CreateCategoryModule_CreateCategoriesViewModelProviderFactory(CreateCategoryModule createCategoryModule, Provider<CreateCategoriesViewModel> provider) {
        this.module = createCategoryModule;
        this.viewModelProvider = provider;
    }

    public static CreateCategoryModule_CreateCategoriesViewModelProviderFactory create(CreateCategoryModule createCategoryModule, Provider<CreateCategoriesViewModel> provider) {
        return new CreateCategoryModule_CreateCategoriesViewModelProviderFactory(createCategoryModule, provider);
    }

    public static ViewModelProvider.Factory createCategoriesViewModelProvider(CreateCategoryModule createCategoryModule, CreateCategoriesViewModel createCategoriesViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)createCategoryModule.createCategoriesViewModelProvider(createCategoriesViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return CreateCategoryModule_CreateCategoriesViewModelProviderFactory.createCategoriesViewModelProvider(this.module, (CreateCategoriesViewModel)((Object)this.viewModelProvider.get()));
    }
}

