package app.dukhaan.ui.ui.onboarding_setps;

import app.dukhaan.ui.onboarding_setps.OnboardingStepsModule;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OnboardingStepsModule_OnboardingStepsViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.onboarding_setps.OnboardingStepsModule module;
   private final Provider<app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel> viewModelProvider;

   public OnboardingStepsModule_OnboardingStepsViewModelProviderFactory(app.dukhaan.ui.onboarding_setps.OnboardingStepsModule var1, Provider<app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static OnboardingStepsModule_OnboardingStepsViewModelProviderFactory create(app.dukhaan.ui.onboarding_setps.OnboardingStepsModule var0, Provider<app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel> var1) {
      return new OnboardingStepsModule_OnboardingStepsViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory onboardingStepsViewModelProvider(OnboardingStepsModule var0, app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.onboardingStepsViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return onboardingStepsViewModelProvider(this.module, (OnboardingStepsViewModel)this.viewModelProvider.get());
   }
}
