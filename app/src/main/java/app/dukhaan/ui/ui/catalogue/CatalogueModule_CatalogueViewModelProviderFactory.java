package app.dukhaan.ui.ui.catalogue;

import app.dukhaan.ui.catalogue.CatalogueModule;
import app.dukhaan.ui.catalogue.CatalogueViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CatalogueModule_CatalogueViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.catalogue.CatalogueModule module;
   private final Provider<app.dukhaan.ui.catalogue.CatalogueViewModel> viewModelProvider;

   public CatalogueModule_CatalogueViewModelProviderFactory(app.dukhaan.ui.catalogue.CatalogueModule var1, Provider<app.dukhaan.ui.catalogue.CatalogueViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static androidx.lifecycle.ViewModelProvider.Factory catalogueViewModelProvider(app.dukhaan.ui.catalogue.CatalogueModule var0, app.dukhaan.ui.catalogue.CatalogueViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.catalogueViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public static CatalogueModule_CatalogueViewModelProviderFactory create(CatalogueModule var0, Provider<app.dukhaan.ui.catalogue.CatalogueViewModel> var1) {
      return new CatalogueModule_CatalogueViewModelProviderFactory(var0, var1);
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return catalogueViewModelProvider(this.module, (CatalogueViewModel)this.viewModelProvider.get());
   }
}
