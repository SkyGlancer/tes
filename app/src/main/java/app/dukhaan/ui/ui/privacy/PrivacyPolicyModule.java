package app.dukhaan.ui.ui.privacy;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.privacy.PrivacyPolicyViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class PrivacyPolicyModule {
   public PrivacyPolicyModule() {
   }

   @Provides
   Factory privacyPolicyViewModelProvider(PrivacyPolicyViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   PrivacyPolicyViewModel providePrivacyPolicyViewModel(DataRepository var1, ApiService var2) {
      return new PrivacyPolicyViewModel(var1, var2);
   }
}
