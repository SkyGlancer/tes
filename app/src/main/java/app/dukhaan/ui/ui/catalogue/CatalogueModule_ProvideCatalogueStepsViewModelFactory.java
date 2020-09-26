package app.dukhaan.ui.ui.catalogue;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.catalogue.CatalogueModule;
import app.dukhaan.ui.catalogue.CatalogueViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CatalogueModule_ProvideCatalogueStepsViewModelFactory implements Factory<app.dukhaan.ui.catalogue.CatalogueViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.catalogue.CatalogueModule module;

   public CatalogueModule_ProvideCatalogueStepsViewModelFactory(app.dukhaan.ui.catalogue.CatalogueModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static CatalogueModule_ProvideCatalogueStepsViewModelFactory create(app.dukhaan.ui.catalogue.CatalogueModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new CatalogueModule_ProvideCatalogueStepsViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.catalogue.CatalogueViewModel provideCatalogueStepsViewModel(CatalogueModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.catalogue.CatalogueViewModel)Preconditions.checkNotNull(var0.provideCatalogueStepsViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public CatalogueViewModel get() {
      return provideCatalogueStepsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
