package app.dukhaan.ui.ui.categorydetail;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.categorydetail.CategoryDetailModule;
import app.dukhaan.ui.categorydetail.CategoryDetailViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CategoryDetailModule_ProvideCategoriesDetailsViewModelFactory implements Factory<app.dukhaan.ui.categorydetail.CategoryDetailViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.categorydetail.CategoryDetailModule module;

   public CategoryDetailModule_ProvideCategoriesDetailsViewModelFactory(app.dukhaan.ui.categorydetail.CategoryDetailModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static CategoryDetailModule_ProvideCategoriesDetailsViewModelFactory create(app.dukhaan.ui.categorydetail.CategoryDetailModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new CategoryDetailModule_ProvideCategoriesDetailsViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.categorydetail.CategoryDetailViewModel provideCategoriesDetailsViewModel(CategoryDetailModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.categorydetail.CategoryDetailViewModel)Preconditions.checkNotNull(var0.provideCategoriesDetailsViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public CategoryDetailViewModel get() {
      return provideCategoriesDetailsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
