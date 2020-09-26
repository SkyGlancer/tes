package app.dukhaan.ui.ui.addbusiness;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.addbusiness.AddBusinessViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class AddBusinessModule {
   public AddBusinessModule() {
   }

   @Provides
   Factory businessDetailsViewModelProvider(AddBusinessViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   AddBusinessViewModel provideBusinessDetailsViewModel(DataRepository var1, ApiService var2) {
      return new AddBusinessViewModel(var1, var2);
   }
}
