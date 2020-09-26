package app.dukhaan.ui.ui.onboarding_setps;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsModule;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OnboardingStepsModule_ProvideOnboardingStepsViewModelFactory implements Factory<app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.onboarding_setps.OnboardingStepsModule module;

   public OnboardingStepsModule_ProvideOnboardingStepsViewModelFactory(app.dukhaan.ui.onboarding_setps.OnboardingStepsModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static OnboardingStepsModule_ProvideOnboardingStepsViewModelFactory create(app.dukhaan.ui.onboarding_setps.OnboardingStepsModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new OnboardingStepsModule_ProvideOnboardingStepsViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel provideOnboardingStepsViewModel(OnboardingStepsModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel)Preconditions.checkNotNull(var0.provideOnboardingStepsViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public OnboardingStepsViewModel get() {
      return provideOnboardingStepsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
