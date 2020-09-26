package app.dukhaan.ui.ui.editbusiness;

import app.dukhaan.ui.editbusiness.EditBusinessModule;
import app.dukhaan.ui.editbusiness.EditBusinessViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class EditBusinessModule_BusinessEditDetailsViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.editbusiness.EditBusinessModule module;
   private final Provider<app.dukhaan.ui.editbusiness.EditBusinessViewModel> viewModelProvider;

   public EditBusinessModule_BusinessEditDetailsViewModelProviderFactory(app.dukhaan.ui.editbusiness.EditBusinessModule var1, Provider<app.dukhaan.ui.editbusiness.EditBusinessViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static androidx.lifecycle.ViewModelProvider.Factory businessEditDetailsViewModelProvider(app.dukhaan.ui.editbusiness.EditBusinessModule var0, app.dukhaan.ui.editbusiness.EditBusinessViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.businessEditDetailsViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public static EditBusinessModule_BusinessEditDetailsViewModelProviderFactory create(EditBusinessModule var0, Provider<app.dukhaan.ui.editbusiness.EditBusinessViewModel> var1) {
      return new EditBusinessModule_BusinessEditDetailsViewModelProviderFactory(var0, var1);
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return businessEditDetailsViewModelProvider(this.module, (EditBusinessViewModel)this.viewModelProvider.get());
   }
}
