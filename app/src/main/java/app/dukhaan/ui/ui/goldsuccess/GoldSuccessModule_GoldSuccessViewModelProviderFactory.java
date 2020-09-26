package app.dukhaan.ui.ui.goldsuccess;

import app.dukhaan.ui.goldsuccess.GoldSuccessModule;
import app.dukhaan.ui.goldsuccess.GoldSuccessViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class GoldSuccessModule_GoldSuccessViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.goldsuccess.GoldSuccessModule module;
   private final Provider<app.dukhaan.ui.goldsuccess.GoldSuccessViewModel> viewModelProvider;

   public GoldSuccessModule_GoldSuccessViewModelProviderFactory(app.dukhaan.ui.goldsuccess.GoldSuccessModule var1, Provider<app.dukhaan.ui.goldsuccess.GoldSuccessViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static GoldSuccessModule_GoldSuccessViewModelProviderFactory create(app.dukhaan.ui.goldsuccess.GoldSuccessModule var0, Provider<app.dukhaan.ui.goldsuccess.GoldSuccessViewModel> var1) {
      return new GoldSuccessModule_GoldSuccessViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory goldSuccessViewModelProvider(GoldSuccessModule var0, app.dukhaan.ui.goldsuccess.GoldSuccessViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.goldSuccessViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return goldSuccessViewModelProvider(this.module, (GoldSuccessViewModel)this.viewModelProvider.get());
   }
}
