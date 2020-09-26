package app.dukhaan.ui.ui.products;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.products.ProductsFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ProductsFragment_MembersInjector implements MembersInjector<app.dukhaan.ui.products.ProductsFragment> {
   private final Provider<Factory> viewModelFactoryProvider;

   public ProductsFragment_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.products.ProductsFragment> create(Provider<Factory> var0) {
      return new ProductsFragment_MembersInjector(var0);
   }

   public void injectMembers(ProductsFragment var1) {
      BaseFragment_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
