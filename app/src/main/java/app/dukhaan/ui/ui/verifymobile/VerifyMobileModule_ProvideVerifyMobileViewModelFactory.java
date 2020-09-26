package app.dukhaan.ui.ui.verifymobile;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.verifymobile.VerifyMobileModule;
import app.dukhaan.ui.verifymobile.VerifyMobileViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class VerifyMobileModule_ProvideVerifyMobileViewModelFactory implements Factory<app.dukhaan.ui.verifymobile.VerifyMobileViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.verifymobile.VerifyMobileModule module;

   public VerifyMobileModule_ProvideVerifyMobileViewModelFactory(app.dukhaan.ui.verifymobile.VerifyMobileModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static VerifyMobileModule_ProvideVerifyMobileViewModelFactory create(app.dukhaan.ui.verifymobile.VerifyMobileModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new VerifyMobileModule_ProvideVerifyMobileViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.verifymobile.VerifyMobileViewModel provideVerifyMobileViewModel(VerifyMobileModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.verifymobile.VerifyMobileViewModel)Preconditions.checkNotNull(var0.provideVerifyMobileViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public VerifyMobileViewModel get() {
      return provideVerifyMobileViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
