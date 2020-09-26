package app.dukhaan.ui.ui.editproduct;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.editproduct.EditProductViewModel;
import app.dukhaan.ui.editproduct.EditProdutModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class EditProdutModule_ProvideEditProductViewModelFactory implements Factory<app.dukhaan.ui.editproduct.EditProductViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.editproduct.EditProdutModule module;

   public EditProdutModule_ProvideEditProductViewModelFactory(app.dukhaan.ui.editproduct.EditProdutModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static EditProdutModule_ProvideEditProductViewModelFactory create(app.dukhaan.ui.editproduct.EditProdutModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new EditProdutModule_ProvideEditProductViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.editproduct.EditProductViewModel provideEditProductViewModel(EditProdutModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.editproduct.EditProductViewModel)Preconditions.checkNotNull(var0.provideEditProductViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public EditProductViewModel get() {
      return provideEditProductViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
