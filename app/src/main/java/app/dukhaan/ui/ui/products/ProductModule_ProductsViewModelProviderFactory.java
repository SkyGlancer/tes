package app.dukhaan.ui.ui.products;

import app.dukhaan.ui.products.ProductModule;
import app.dukhaan.ui.products.ProductsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ProductModule_ProductsViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.products.ProductModule module;
   private final Provider<app.dukhaan.ui.products.ProductsViewModel> viewModelProvider;

   public ProductModule_ProductsViewModelProviderFactory(app.dukhaan.ui.products.ProductModule var1, Provider<app.dukhaan.ui.products.ProductsViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static ProductModule_ProductsViewModelProviderFactory create(app.dukhaan.ui.products.ProductModule var0, Provider<app.dukhaan.ui.products.ProductsViewModel> var1) {
      return new ProductModule_ProductsViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory productsViewModelProvider(ProductModule var0, app.dukhaan.ui.products.ProductsViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.productsViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return productsViewModelProvider(this.module, (ProductsViewModel)this.viewModelProvider.get());
   }
}
