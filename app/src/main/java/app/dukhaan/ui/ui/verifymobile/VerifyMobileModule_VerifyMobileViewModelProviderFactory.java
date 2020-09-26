package app.dukhaan.ui.ui.verifymobile;

import app.dukhaan.ui.verifymobile.VerifyMobileModule;
import app.dukhaan.ui.verifymobile.VerifyMobileViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class VerifyMobileModule_VerifyMobileViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.verifymobile.VerifyMobileModule module;
   private final Provider<app.dukhaan.ui.verifymobile.VerifyMobileViewModel> viewModelProvider;

   public VerifyMobileModule_VerifyMobileViewModelProviderFactory(app.dukhaan.ui.verifymobile.VerifyMobileModule var1, Provider<app.dukhaan.ui.verifymobile.VerifyMobileViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static VerifyMobileModule_VerifyMobileViewModelProviderFactory create(app.dukhaan.ui.verifymobile.VerifyMobileModule var0, Provider<app.dukhaan.ui.verifymobile.VerifyMobileViewModel> var1) {
      return new VerifyMobileModule_VerifyMobileViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory verifyMobileViewModelProvider(VerifyMobileModule var0, app.dukhaan.ui.verifymobile.VerifyMobileViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.verifyMobileViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return verifyMobileViewModelProvider(this.module, (VerifyMobileViewModel)this.viewModelProvider.get());
   }
}
