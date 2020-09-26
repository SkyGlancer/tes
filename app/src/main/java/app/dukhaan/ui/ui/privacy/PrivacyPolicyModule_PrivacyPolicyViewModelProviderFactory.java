package app.dukhaan.ui.ui.privacy;

import app.dukhaan.ui.privacy.PrivacyPolicyModule;
import app.dukhaan.ui.privacy.PrivacyPolicyViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PrivacyPolicyModule_PrivacyPolicyViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.privacy.PrivacyPolicyModule module;
   private final Provider<app.dukhaan.ui.privacy.PrivacyPolicyViewModel> viewModelProvider;

   public PrivacyPolicyModule_PrivacyPolicyViewModelProviderFactory(app.dukhaan.ui.privacy.PrivacyPolicyModule var1, Provider<app.dukhaan.ui.privacy.PrivacyPolicyViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static PrivacyPolicyModule_PrivacyPolicyViewModelProviderFactory create(app.dukhaan.ui.privacy.PrivacyPolicyModule var0, Provider<app.dukhaan.ui.privacy.PrivacyPolicyViewModel> var1) {
      return new PrivacyPolicyModule_PrivacyPolicyViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory privacyPolicyViewModelProvider(PrivacyPolicyModule var0, app.dukhaan.ui.privacy.PrivacyPolicyViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.privacyPolicyViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return privacyPolicyViewModelProvider(this.module, (PrivacyPolicyViewModel)this.viewModelProvider.get());
   }
}
