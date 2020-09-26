package app.dukhaan.ui.ui.home;

import app.dukhaan.ui.home.HomeModule;
import app.dukhaan.ui.home.HomeViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class HomeModule_MobileNumberViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.home.HomeModule module;
   private final Provider<app.dukhaan.ui.home.HomeViewModel> viewModelProvider;

   public HomeModule_MobileNumberViewModelProviderFactory(app.dukhaan.ui.home.HomeModule var1, Provider<app.dukhaan.ui.home.HomeViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static HomeModule_MobileNumberViewModelProviderFactory create(app.dukhaan.ui.home.HomeModule var0, Provider<app.dukhaan.ui.home.HomeViewModel> var1) {
      return new HomeModule_MobileNumberViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory mobileNumberViewModelProvider(HomeModule var0, app.dukhaan.ui.home.HomeViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.mobileNumberViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return mobileNumberViewModelProvider(this.module, (HomeViewModel)this.viewModelProvider.get());
   }
}
