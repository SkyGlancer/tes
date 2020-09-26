package app.dukhaan.ui.ui.splash;

import app.dukhaan.ui.splash.SplashModule;
import app.dukhaan.ui.splash.SplashViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SplashModule_SplashViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.splash.SplashModule module;
   private final Provider<app.dukhaan.ui.splash.SplashViewModel> viewModelProvider;

   public SplashModule_SplashViewModelProviderFactory(app.dukhaan.ui.splash.SplashModule var1, Provider<app.dukhaan.ui.splash.SplashViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static SplashModule_SplashViewModelProviderFactory create(app.dukhaan.ui.splash.SplashModule var0, Provider<app.dukhaan.ui.splash.SplashViewModel> var1) {
      return new SplashModule_SplashViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory splashViewModelProvider(SplashModule var0, app.dukhaan.ui.splash.SplashViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.splashViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return splashViewModelProvider(this.module, (SplashViewModel)this.viewModelProvider.get());
   }
}
