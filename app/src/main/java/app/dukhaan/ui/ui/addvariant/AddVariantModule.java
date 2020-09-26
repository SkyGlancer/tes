package app.dukhaan.ui.ui.addvariant;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.addvariant.AddVariantViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class AddVariantModule {
   public AddVariantModule() {
   }

   @Provides
   Factory addVariantsViewModelProvider(AddVariantViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   AddVariantViewModel provideAddVariantsViewModel(DataRepository var1, ApiService var2) {
      return new AddVariantViewModel(var1, var2);
   }
}
