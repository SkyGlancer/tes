package app.dukhaan.ui.ui.editproduct;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.editproduct.EditProductViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class EditProdutModule {
   public EditProdutModule() {
   }

   @Provides
   Factory editProductViewModelProvider(EditProductViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   EditProductViewModel provideEditProductViewModel(DataRepository var1, ApiService var2) {
      return new EditProductViewModel(var1, var2);
   }
}
