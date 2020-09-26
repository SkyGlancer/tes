package app.dukhaan.ui.ui.home;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.home.HomeViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {
   public HomeModule() {
   }

   @Provides
   Factory mobileNumberViewModelProvider(HomeViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   HomeViewModel provideAboutViewModel(DataRepository var1, ApiService var2) {
      return new HomeViewModel(var1, var2);
   }
}
