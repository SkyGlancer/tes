package app.dukhaan.ui.ui.splash;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.splash.SplashViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class SplashModule {
   public SplashModule() {
   }

   @Provides
   SplashViewModel provideSplashViewModel(DataRepository var1, ApiService var2) {
      return new SplashViewModel(var1, var2);
   }

   @Provides
   Factory splashViewModelProvider(SplashViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }
}
