package app.dukhaan.ui.ui.verifymobile;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.verifymobile.VerifyMobileViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class VerifyMobileModule {
   public VerifyMobileModule() {
   }

   @Provides
   VerifyMobileViewModel provideVerifyMobileViewModel(DataRepository var1, ApiService var2) {
      return new VerifyMobileViewModel(var1, var2);
   }

   @Provides
   Factory verifyMobileViewModelProvider(VerifyMobileViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }
}
