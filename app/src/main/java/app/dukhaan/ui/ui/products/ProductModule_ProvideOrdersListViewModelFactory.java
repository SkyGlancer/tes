package app.dukhaan.ui.ui.products;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.products.ProductModule;
import app.dukhaan.ui.products.ProductsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ProductModule_ProvideOrdersListViewModelFactory implements Factory<app.dukhaan.ui.products.ProductsViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.products.ProductModule module;

   public ProductModule_ProvideOrdersListViewModelFactory(app.dukhaan.ui.products.ProductModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static ProductModule_ProvideOrdersListViewModelFactory create(app.dukhaan.ui.products.ProductModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new ProductModule_ProvideOrdersListViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.products.ProductsViewModel provideOrdersListViewModel(ProductModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.products.ProductsViewModel)Preconditions.checkNotNull(var0.provideOrdersListViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public ProductsViewModel get() {
      return provideOrdersListViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
