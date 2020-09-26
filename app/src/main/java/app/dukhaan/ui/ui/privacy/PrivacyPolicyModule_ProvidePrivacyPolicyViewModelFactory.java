package app.dukhaan.ui.ui.privacy;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.privacy.PrivacyPolicyModule;
import app.dukhaan.ui.privacy.PrivacyPolicyViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PrivacyPolicyModule_ProvidePrivacyPolicyViewModelFactory implements Factory<app.dukhaan.ui.privacy.PrivacyPolicyViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.privacy.PrivacyPolicyModule module;

   public PrivacyPolicyModule_ProvidePrivacyPolicyViewModelFactory(app.dukhaan.ui.privacy.PrivacyPolicyModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static PrivacyPolicyModule_ProvidePrivacyPolicyViewModelFactory create(app.dukhaan.ui.privacy.PrivacyPolicyModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new PrivacyPolicyModule_ProvidePrivacyPolicyViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.privacy.PrivacyPolicyViewModel providePrivacyPolicyViewModel(PrivacyPolicyModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.privacy.PrivacyPolicyViewModel)Preconditions.checkNotNull(var0.providePrivacyPolicyViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public PrivacyPolicyViewModel get() {
      return providePrivacyPolicyViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
