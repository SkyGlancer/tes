package app.dukhaan.ui.ui.account;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.account.AccountModule;
import app.dukhaan.ui.account.AccountViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AccountModule_ProvideAccountViewModelFactory implements Factory<app.dukhaan.ui.account.AccountViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.account.AccountModule module;

   public AccountModule_ProvideAccountViewModelFactory(app.dukhaan.ui.account.AccountModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static AccountModule_ProvideAccountViewModelFactory create(app.dukhaan.ui.account.AccountModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new AccountModule_ProvideAccountViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.account.AccountViewModel provideAccountViewModel(AccountModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.account.AccountViewModel)Preconditions.checkNotNull(var0.provideAccountViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public AccountViewModel get() {
      return provideAccountViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
