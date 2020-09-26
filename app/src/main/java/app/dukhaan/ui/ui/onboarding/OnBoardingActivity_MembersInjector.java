package app.dukhaan.ui.ui.onboarding;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.onboarding.OnBoardingActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class OnBoardingActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.onboarding.OnBoardingActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public OnBoardingActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.onboarding.OnBoardingActivity> create(Provider<Factory> var0) {
      return new OnBoardingActivity_MembersInjector(var0);
   }

   public void injectMembers(OnBoardingActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
