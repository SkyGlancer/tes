package app.dukhaan.ui.ui.products;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.products.ProductsViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class ProductModule {
   public ProductModule() {
   }

   @Provides
   Factory productsViewModelProvider(ProductsViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   ProductsViewModel provideOrdersListViewModel(DataRepository var1, ApiService var2) {
      return new ProductsViewModel(var1, var2);
   }
}
