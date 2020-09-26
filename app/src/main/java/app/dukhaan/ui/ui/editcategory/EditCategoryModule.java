package app.dukhaan.ui.ui.editcategory;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.editcategory.EditCategoriesViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class EditCategoryModule {
   public EditCategoryModule() {
   }

   @Provides
   Factory editCategoriesViewModelProvider(EditCategoriesViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   EditCategoriesViewModel provideEditCategoriesViewModel(DataRepository var1, ApiService var2) {
      return new EditCategoriesViewModel(var1, var2);
   }
}
