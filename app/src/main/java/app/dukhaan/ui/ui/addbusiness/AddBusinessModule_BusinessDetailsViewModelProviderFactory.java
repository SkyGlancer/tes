package app.dukhaan.ui.ui.addbusiness;

import app.dukhaan.ui.addbusiness.AddBusinessModule;
import app.dukhaan.ui.addbusiness.AddBusinessViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AddBusinessModule_BusinessDetailsViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.addbusiness.AddBusinessModule module;
   private final Provider<app.dukhaan.ui.addbusiness.AddBusinessViewModel> viewModelProvider;

   public AddBusinessModule_BusinessDetailsViewModelProviderFactory(app.dukhaan.ui.addbusiness.AddBusinessModule var1, Provider<app.dukhaan.ui.addbusiness.AddBusinessViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static androidx.lifecycle.ViewModelProvider.Factory businessDetailsViewModelProvider(app.dukhaan.ui.addbusiness.AddBusinessModule var0, app.dukhaan.ui.addbusiness.AddBusinessViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.businessDetailsViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public static AddBusinessModule_BusinessDetailsViewModelProviderFactory create(AddBusinessModule var0, Provider<app.dukhaan.ui.addbusiness.AddBusinessViewModel> var1) {
      return new AddBusinessModule_BusinessDetailsViewModelProviderFactory(var0, var1);
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return businessDetailsViewModelProvider(this.module, (AddBusinessViewModel)this.viewModelProvider.get());
   }
}
