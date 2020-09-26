package app.dukhaan.ui.ui.verifyotp;

import app.dukhaan.ui.verifyotp.VerifyOtpModule;
import app.dukhaan.ui.verifyotp.VerifyOtpViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class VerifyOtpModule_VerifyOtpViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.verifyotp.VerifyOtpModule module;
   private final Provider<app.dukhaan.ui.verifyotp.VerifyOtpViewModel> viewModelProvider;

   public VerifyOtpModule_VerifyOtpViewModelProviderFactory(app.dukhaan.ui.verifyotp.VerifyOtpModule var1, Provider<app.dukhaan.ui.verifyotp.VerifyOtpViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static VerifyOtpModule_VerifyOtpViewModelProviderFactory create(app.dukhaan.ui.verifyotp.VerifyOtpModule var0, Provider<app.dukhaan.ui.verifyotp.VerifyOtpViewModel> var1) {
      return new VerifyOtpModule_VerifyOtpViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory verifyOtpViewModelProvider(VerifyOtpModule var0, app.dukhaan.ui.verifyotp.VerifyOtpViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.verifyOtpViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return verifyOtpViewModelProvider(this.module, (VerifyOtpViewModel)this.viewModelProvider.get());
   }
}
