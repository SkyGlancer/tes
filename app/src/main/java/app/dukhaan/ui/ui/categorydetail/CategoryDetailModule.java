package app.dukhaan.ui.ui.categorydetail;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.categorydetail.CategoryDetailViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class CategoryDetailModule {
   public CategoryDetailModule() {
   }

   @Provides
   Factory categoriesDetailViewModelProvider(CategoryDetailViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   CategoryDetailViewModel provideCategoriesDetailsViewModel(DataRepository var1, ApiService var2) {
      return new CategoryDetailViewModel(var1, var2);
   }
}
