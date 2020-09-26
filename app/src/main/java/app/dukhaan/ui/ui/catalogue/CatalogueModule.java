package app.dukhaan.ui.ui.catalogue;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.catalogue.CatalogueViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class CatalogueModule {
   public CatalogueModule() {
   }

   @Provides
   Factory catalogueViewModelProvider(CatalogueViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   CatalogueViewModel provideCatalogueStepsViewModel(DataRepository var1, ApiService var2) {
      return new CatalogueViewModel(var1, var2);
   }
}
