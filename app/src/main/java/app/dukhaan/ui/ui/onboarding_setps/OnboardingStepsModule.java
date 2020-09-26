package app.dukhaan.ui.ui.onboarding_setps;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class OnboardingStepsModule {
   public OnboardingStepsModule() {
   }

   @Provides
   Factory onboardingStepsViewModelProvider(OnboardingStepsViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   OnboardingStepsViewModel provideOnboardingStepsViewModel(DataRepository var1, ApiService var2) {
      return new OnboardingStepsViewModel(var1, var2);
   }
}
