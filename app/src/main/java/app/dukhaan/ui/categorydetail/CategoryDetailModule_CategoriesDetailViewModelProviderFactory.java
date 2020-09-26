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
package app.dukhaan.ui.categorydetail;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.categorydetail.CategoryDetailModule;
import app.dukhaan.ui.categorydetail.CategoryDetailViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CategoryDetailModule_CategoriesDetailViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final CategoryDetailModule module;
    private final Provider<CategoryDetailViewModel> viewModelProvider;

    public CategoryDetailModule_CategoriesDetailViewModelProviderFactory(CategoryDetailModule categoryDetailModule, Provider<CategoryDetailViewModel> provider) {
        this.module = categoryDetailModule;
        this.viewModelProvider = provider;
    }

    public static ViewModelProvider.Factory categoriesDetailViewModelProvider(CategoryDetailModule categoryDetailModule, CategoryDetailViewModel categoryDetailViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)categoryDetailModule.categoriesDetailViewModelProvider(categoryDetailViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public static CategoryDetailModule_CategoriesDetailViewModelProviderFactory create(CategoryDetailModule categoryDetailModule, Provider<CategoryDetailViewModel> provider) {
        return new CategoryDetailModule_CategoriesDetailViewModelProviderFactory(categoryDetailModule, provider);
    }

    public ViewModelProvider.Factory get() {
        return CategoryDetailModule_CategoriesDetailViewModelProviderFactory.categoriesDetailViewModelProvider(this.module, (CategoryDetailViewModel)((Object)this.viewModelProvider.get()));
    }
}

