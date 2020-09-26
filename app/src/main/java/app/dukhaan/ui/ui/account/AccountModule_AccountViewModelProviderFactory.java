package app.dukhaan.ui.ui.account;

import app.dukhaan.ui.account.AccountModule;
import app.dukhaan.ui.account.AccountViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AccountModule_AccountViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.account.AccountModule module;
   private final Provider<app.dukhaan.ui.account.AccountViewModel> viewModelProvider;

   public AccountModule_AccountViewModelProviderFactory(app.dukhaan.ui.account.AccountModule var1, Provider<app.dukhaan.ui.account.AccountViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static androidx.lifecycle.ViewModelProvider.Factory accountViewModelProvider(app.dukhaan.ui.account.AccountModule var0, app.dukhaan.ui.account.AccountViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.accountViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public static AccountModule_AccountViewModelProviderFactory create(AccountModule var0, Provider<app.dukhaan.ui.account.AccountViewModel> var1) {
      return new AccountModule_AccountViewModelProviderFactory(var0, var1);
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return accountViewModelProvider(this.module, (AccountViewModel)this.viewModelProvider.get());
   }
}
