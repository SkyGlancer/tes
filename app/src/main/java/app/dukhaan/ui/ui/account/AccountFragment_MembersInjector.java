package app.dukhaan.ui.ui.account;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.account.AccountFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AccountFragment_MembersInjector implements MembersInjector<app.dukhaan.ui.account.AccountFragment> {
   private final Provider<Factory> viewModelFactoryProvider;

   public AccountFragment_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.account.AccountFragment> create(Provider<Factory> var0) {
      return new AccountFragment_MembersInjector(var0);
   }

   public void injectMembers(AccountFragment var1) {
      BaseFragment_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
