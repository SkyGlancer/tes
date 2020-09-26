package app.dukhaan.ui.ui.createcategory;

import app.dukhaan.ui.createcategory.CreateCategoriesViewModel;
import app.dukhaan.ui.createcategory.CreateCategoryModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CreateCategoryModule_CreateCategoriesViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.createcategory.CreateCategoryModule module;
   private final Provider<app.dukhaan.ui.createcategory.CreateCategoriesViewModel> viewModelProvider;

   public CreateCategoryModule_CreateCategoriesViewModelProviderFactory(app.dukhaan.ui.createcategory.CreateCategoryModule var1, Provider<app.dukhaan.ui.createcategory.CreateCategoriesViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static CreateCategoryModule_CreateCategoriesViewModelProviderFactory create(app.dukhaan.ui.createcategory.CreateCategoryModule var0, Provider<app.dukhaan.ui.createcategory.CreateCategoriesViewModel> var1) {
      return new CreateCategoryModule_CreateCategoriesViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory createCategoriesViewModelProvider(CreateCategoryModule var0, app.dukhaan.ui.createcategory.CreateCategoriesViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.createCategoriesViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return createCategoriesViewModelProvider(this.module, (CreateCategoriesViewModel)this.viewModelProvider.get());
   }
}
