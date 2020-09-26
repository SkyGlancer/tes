package app.dukhaan.ui.ui.addvariant;

import app.dukhaan.ui.addvariant.AddVariantModule;
import app.dukhaan.ui.addvariant.AddVariantViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AddVariantModule_AddVariantsViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.addvariant.AddVariantModule module;
   private final Provider<app.dukhaan.ui.addvariant.AddVariantViewModel> viewModelProvider;

   public AddVariantModule_AddVariantsViewModelProviderFactory(app.dukhaan.ui.addvariant.AddVariantModule var1, Provider<app.dukhaan.ui.addvariant.AddVariantViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static androidx.lifecycle.ViewModelProvider.Factory addVariantsViewModelProvider(app.dukhaan.ui.addvariant.AddVariantModule var0, app.dukhaan.ui.addvariant.AddVariantViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.addVariantsViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public static AddVariantModule_AddVariantsViewModelProviderFactory create(AddVariantModule var0, Provider<app.dukhaan.ui.addvariant.AddVariantViewModel> var1) {
      return new AddVariantModule_AddVariantsViewModelProviderFactory(var0, var1);
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return addVariantsViewModelProvider(this.module, (AddVariantViewModel)this.viewModelProvider.get());
   }
}
