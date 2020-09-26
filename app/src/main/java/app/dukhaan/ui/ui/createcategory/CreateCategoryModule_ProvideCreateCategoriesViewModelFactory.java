package app.dukhaan.ui.ui.createcategory;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.createcategory.CreateCategoriesViewModel;
import app.dukhaan.ui.createcategory.CreateCategoryModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CreateCategoryModule_ProvideCreateCategoriesViewModelFactory implements Factory<app.dukhaan.ui.createcategory.CreateCategoriesViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.createcategory.CreateCategoryModule module;

   public CreateCategoryModule_ProvideCreateCategoriesViewModelFactory(app.dukhaan.ui.createcategory.CreateCategoryModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static CreateCategoryModule_ProvideCreateCategoriesViewModelFactory create(app.dukhaan.ui.createcategory.CreateCategoryModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new CreateCategoryModule_ProvideCreateCategoriesViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.createcategory.CreateCategoriesViewModel provideCreateCategoriesViewModel(CreateCategoryModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.createcategory.CreateCategoriesViewModel)Preconditions.checkNotNull(var0.provideCreateCategoriesViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public CreateCategoriesViewModel get() {
      return provideCreateCategoriesViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
