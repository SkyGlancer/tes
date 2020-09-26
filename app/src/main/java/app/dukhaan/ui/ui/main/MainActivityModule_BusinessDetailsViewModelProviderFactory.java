package app.dukhaan.ui.ui.main;

import app.dukhaan.ui.main.MainActivityModule;
import app.dukhaan.ui.main.MainActivityViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MainActivityModule_BusinessDetailsViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.main.MainActivityModule module;
   private final Provider<app.dukhaan.ui.main.MainActivityViewModel> viewModelProvider;

   public MainActivityModule_BusinessDetailsViewModelProviderFactory(app.dukhaan.ui.main.MainActivityModule var1, Provider<app.dukhaan.ui.main.MainActivityViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static androidx.lifecycle.ViewModelProvider.Factory businessDetailsViewModelProvider(app.dukhaan.ui.main.MainActivityModule var0, app.dukhaan.ui.main.MainActivityViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.businessDetailsViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public static MainActivityModule_BusinessDetailsViewModelProviderFactory create(MainActivityModule var0, Provider<app.dukhaan.ui.main.MainActivityViewModel> var1) {
      return new MainActivityModule_BusinessDetailsViewModelProviderFactory(var0, var1);
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return businessDetailsViewModelProvider(this.module, (MainActivityViewModel)this.viewModelProvider.get());
   }
}
