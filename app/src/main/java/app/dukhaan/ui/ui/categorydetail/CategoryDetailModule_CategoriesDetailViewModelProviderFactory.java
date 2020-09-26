package app.dukhaan.ui.ui.categorydetail;

import app.dukhaan.ui.categorydetail.CategoryDetailModule;
import app.dukhaan.ui.categorydetail.CategoryDetailViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CategoryDetailModule_CategoriesDetailViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.categorydetail.CategoryDetailModule module;
   private final Provider<app.dukhaan.ui.categorydetail.CategoryDetailViewModel> viewModelProvider;

   public CategoryDetailModule_CategoriesDetailViewModelProviderFactory(app.dukhaan.ui.categorydetail.CategoryDetailModule var1, Provider<app.dukhaan.ui.categorydetail.CategoryDetailViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static androidx.lifecycle.ViewModelProvider.Factory categoriesDetailViewModelProvider(app.dukhaan.ui.categorydetail.CategoryDetailModule var0, app.dukhaan.ui.categorydetail.CategoryDetailViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.categoriesDetailViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public static CategoryDetailModule_CategoriesDetailViewModelProviderFactory create(CategoryDetailModule var0, Provider<app.dukhaan.ui.categorydetail.CategoryDetailViewModel> var1) {
      return new CategoryDetailModule_CategoriesDetailViewModelProviderFactory(var0, var1);
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return categoriesDetailViewModelProvider(this.module, (CategoryDetailViewModel)this.viewModelProvider.get());
   }
}
