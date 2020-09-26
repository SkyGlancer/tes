package app.dukhaan.ui.ui.categories;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.categories.CategoriesViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class CategoryModule {
   public CategoryModule() {
   }

   @Provides
   Factory categoriesViewModelProvider(CategoriesViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   CategoriesViewModel provideCategoriesViewModel(DataRepository var1, ApiService var2) {
      return new CategoriesViewModel(var1, var2);
   }
}
