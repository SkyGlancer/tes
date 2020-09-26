package app.dukhaan.ui.ui.splash;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.splash.SplashActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SplashActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.splash.SplashActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public SplashActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.splash.SplashActivity> create(Provider<Factory> var0) {
      return new SplashActivity_MembersInjector(var0);
   }

   public void injectMembers(SplashActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
