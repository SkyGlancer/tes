package app.dukhaan.ui.ui.createcategory;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.createcategory.CreateCategoriesViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class CreateCategoryModule {
   public CreateCategoryModule() {
   }

   @Provides
   Factory createCategoriesViewModelProvider(CreateCategoriesViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   CreateCategoriesViewModel provideCreateCategoriesViewModel(DataRepository var1, ApiService var2) {
      return new CreateCategoriesViewModel(var1, var2);
   }
}
