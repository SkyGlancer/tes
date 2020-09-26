package app.dukhaan.ui.ui.splash;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.splash.SplashModule;
import app.dukhaan.ui.splash.SplashViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SplashModule_ProvideSplashViewModelFactory implements Factory<app.dukhaan.ui.splash.SplashViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.splash.SplashModule module;

   public SplashModule_ProvideSplashViewModelFactory(app.dukhaan.ui.splash.SplashModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static SplashModule_ProvideSplashViewModelFactory create(app.dukhaan.ui.splash.SplashModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new SplashModule_ProvideSplashViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.splash.SplashViewModel provideSplashViewModel(SplashModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.splash.SplashViewModel)Preconditions.checkNotNull(var0.provideSplashViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public SplashViewModel get() {
      return provideSplashViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
