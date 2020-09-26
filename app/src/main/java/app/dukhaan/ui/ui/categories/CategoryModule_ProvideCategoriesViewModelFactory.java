package app.dukhaan.ui.ui.categories;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.categories.CategoriesViewModel;
import app.dukhaan.ui.categories.CategoryModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CategoryModule_ProvideCategoriesViewModelFactory implements Factory<app.dukhaan.ui.categories.CategoriesViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.categories.CategoryModule module;

   public CategoryModule_ProvideCategoriesViewModelFactory(app.dukhaan.ui.categories.CategoryModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static CategoryModule_ProvideCategoriesViewModelFactory create(app.dukhaan.ui.categories.CategoryModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new CategoryModule_ProvideCategoriesViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.categories.CategoriesViewModel provideCategoriesViewModel(CategoryModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.categories.CategoriesViewModel)Preconditions.checkNotNull(var0.provideCategoriesViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public CategoriesViewModel get() {
      return provideCategoriesViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
