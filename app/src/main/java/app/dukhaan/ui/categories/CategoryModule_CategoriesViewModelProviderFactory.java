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
package app.dukhaan.ui.categories;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.categories.CategoriesViewModel;
import app.dukhaan.ui.categories.CategoryModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CategoryModule_CategoriesViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final CategoryModule module;
    private final Provider<CategoriesViewModel> viewModelProvider;

    public CategoryModule_CategoriesViewModelProviderFactory(CategoryModule categoryModule, Provider<CategoriesViewModel> provider) {
        this.module = categoryModule;
        this.viewModelProvider = provider;
    }

    public static ViewModelProvider.Factory categoriesViewModelProvider(CategoryModule categoryModule, CategoriesViewModel categoriesViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)categoryModule.categoriesViewModelProvider(categoriesViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public static CategoryModule_CategoriesViewModelProviderFactory create(CategoryModule categoryModule, Provider<CategoriesViewModel> provider) {
        return new CategoryModule_CategoriesViewModelProviderFactory(categoryModule, provider);
    }

    public ViewModelProvider.Factory get() {
        return CategoryModule_CategoriesViewModelProviderFactory.categoriesViewModelProvider(this.module, (CategoriesViewModel)((Object)this.viewModelProvider.get()));
    }
}

