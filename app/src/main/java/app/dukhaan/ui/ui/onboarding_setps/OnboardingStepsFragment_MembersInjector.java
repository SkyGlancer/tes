package app.dukhaan.ui.ui.onboarding_setps;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class OnboardingStepsFragment_MembersInjector implements MembersInjector<app.dukhaan.ui.onboarding_setps.OnboardingStepsFragment> {
   private final Provider<Factory> viewModelFactoryProvider;

   public OnboardingStepsFragment_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.onboarding_setps.OnboardingStepsFragment> create(Provider<Factory> var0) {
      return new OnboardingStepsFragment_MembersInjector(var0);
   }

   public void injectMembers(OnboardingStepsFragment var1) {
      BaseFragment_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
