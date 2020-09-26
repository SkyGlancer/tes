package app.dukhaan.ui.ui.editcategory;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.editcategory.EditCategoriesViewModel;
import app.dukhaan.ui.editcategory.EditCategoryModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class EditCategoryModule_ProvideEditCategoriesViewModelFactory implements Factory<app.dukhaan.ui.editcategory.EditCategoriesViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.editcategory.EditCategoryModule module;

   public EditCategoryModule_ProvideEditCategoriesViewModelFactory(app.dukhaan.ui.editcategory.EditCategoryModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static EditCategoryModule_ProvideEditCategoriesViewModelFactory create(app.dukhaan.ui.editcategory.EditCategoryModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new EditCategoryModule_ProvideEditCategoriesViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.editcategory.EditCategoriesViewModel provideEditCategoriesViewModel(EditCategoryModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.editcategory.EditCategoriesViewModel)Preconditions.checkNotNull(var0.provideEditCategoriesViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public EditCategoriesViewModel get() {
      return provideEditCategoriesViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
