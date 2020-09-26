package app.dukhaan.ui.ui.main;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.main.MainActivityViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
   public MainActivityModule() {
   }

   @Provides
   Factory businessDetailsViewModelProvider(MainActivityViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   MainActivityViewModel provideBusinessDetailsViewModel(DataRepository var1, ApiService var2) {
      return new MainActivityViewModel(var1, var2);
   }
}
