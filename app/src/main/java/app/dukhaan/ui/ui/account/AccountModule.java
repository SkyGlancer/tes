package app.dukhaan.ui.ui.account;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.account.AccountViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class AccountModule {
   public AccountModule() {
   }

   @Provides
   Factory accountViewModelProvider(AccountViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   AccountViewModel provideAccountViewModel(DataRepository var1, ApiService var2) {
      return new AccountViewModel(var1, var2);
   }
}
