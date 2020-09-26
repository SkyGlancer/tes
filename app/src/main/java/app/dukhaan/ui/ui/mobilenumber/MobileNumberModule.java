package app.dukhaan.ui.ui.mobilenumber;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.mobilenumber.MobileNumberViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class MobileNumberModule {
   public MobileNumberModule() {
   }

   @Provides
   Factory mobileNumberViewModelProvider(MobileNumberViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   MobileNumberViewModel provideAboutViewModel(DataRepository var1, ApiService var2) {
      return new MobileNumberViewModel(var1, var2);
   }
}
