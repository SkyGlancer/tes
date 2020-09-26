package app.dukhaan.ui.ui.verifyotp;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.verifyotp.VerifyOtpViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class VerifyOtpModule {
   public VerifyOtpModule() {
   }

   @Provides
   VerifyOtpViewModel provideVerifyOtpViewModel(DataRepository var1, ApiService var2) {
      return new VerifyOtpViewModel(var1, var2);
   }

   @Provides
   Factory verifyOtpViewModelProvider(VerifyOtpViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }
}
