package app.dukhaan.ui.ui.categories;

import app.dukhaan.ui.categories.CategoriesViewModel;
import app.dukhaan.ui.categories.CategoryModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CategoryModule_CategoriesViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.categories.CategoryModule module;
   private final Provider<app.dukhaan.ui.categories.CategoriesViewModel> viewModelProvider;

   public CategoryModule_CategoriesViewModelProviderFactory(app.dukhaan.ui.categories.CategoryModule var1, Provider<app.dukhaan.ui.categories.CategoriesViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static androidx.lifecycle.ViewModelProvider.Factory categoriesViewModelProvider(app.dukhaan.ui.categories.CategoryModule var0, app.dukhaan.ui.categories.CategoriesViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.categoriesViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public static CategoryModule_CategoriesViewModelProviderFactory create(CategoryModule var0, Provider<app.dukhaan.ui.categories.CategoriesViewModel> var1) {
      return new CategoryModule_CategoriesViewModelProviderFactory(var0, var1);
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return categoriesViewModelProvider(this.module, (CategoriesViewModel)this.viewModelProvider.get());
   }
}
