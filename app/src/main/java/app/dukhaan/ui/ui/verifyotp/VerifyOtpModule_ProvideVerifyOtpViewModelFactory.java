package app.dukhaan.ui.ui.verifyotp;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.verifyotp.VerifyOtpModule;
import app.dukhaan.ui.verifyotp.VerifyOtpViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class VerifyOtpModule_ProvideVerifyOtpViewModelFactory implements Factory<app.dukhaan.ui.verifyotp.VerifyOtpViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.verifyotp.VerifyOtpModule module;

   public VerifyOtpModule_ProvideVerifyOtpViewModelFactory(app.dukhaan.ui.verifyotp.VerifyOtpModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static VerifyOtpModule_ProvideVerifyOtpViewModelFactory create(app.dukhaan.ui.verifyotp.VerifyOtpModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new VerifyOtpModule_ProvideVerifyOtpViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.verifyotp.VerifyOtpViewModel provideVerifyOtpViewModel(VerifyOtpModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.verifyotp.VerifyOtpViewModel)Preconditions.checkNotNull(var0.provideVerifyOtpViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public VerifyOtpViewModel get() {
      return provideVerifyOtpViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
