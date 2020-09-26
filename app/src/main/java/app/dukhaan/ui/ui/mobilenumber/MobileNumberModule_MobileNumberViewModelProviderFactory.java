package app.dukhaan.ui.ui.mobilenumber;

import app.dukhaan.ui.mobilenumber.MobileNumberModule;
import app.dukhaan.ui.mobilenumber.MobileNumberViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MobileNumberModule_MobileNumberViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.mobilenumber.MobileNumberModule module;
   private final Provider<app.dukhaan.ui.mobilenumber.MobileNumberViewModel> viewModelProvider;

   public MobileNumberModule_MobileNumberViewModelProviderFactory(app.dukhaan.ui.mobilenumber.MobileNumberModule var1, Provider<app.dukhaan.ui.mobilenumber.MobileNumberViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static MobileNumberModule_MobileNumberViewModelProviderFactory create(app.dukhaan.ui.mobilenumber.MobileNumberModule var0, Provider<app.dukhaan.ui.mobilenumber.MobileNumberViewModel> var1) {
      return new MobileNumberModule_MobileNumberViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory mobileNumberViewModelProvider(MobileNumberModule var0, app.dukhaan.ui.mobilenumber.MobileNumberViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.mobileNumberViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return mobileNumberViewModelProvider(this.module, (MobileNumberViewModel)this.viewModelProvider.get());
   }
}
