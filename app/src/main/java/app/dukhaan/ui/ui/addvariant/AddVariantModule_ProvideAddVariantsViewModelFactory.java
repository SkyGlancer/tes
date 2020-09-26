package app.dukhaan.ui.ui.addvariant;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.addvariant.AddVariantModule;
import app.dukhaan.ui.addvariant.AddVariantViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AddVariantModule_ProvideAddVariantsViewModelFactory implements Factory<app.dukhaan.ui.addvariant.AddVariantViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.addvariant.AddVariantModule module;

   public AddVariantModule_ProvideAddVariantsViewModelFactory(app.dukhaan.ui.addvariant.AddVariantModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static AddVariantModule_ProvideAddVariantsViewModelFactory create(app.dukhaan.ui.addvariant.AddVariantModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new AddVariantModule_ProvideAddVariantsViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.addvariant.AddVariantViewModel provideAddVariantsViewModel(AddVariantModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.addvariant.AddVariantViewModel)Preconditions.checkNotNull(var0.provideAddVariantsViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public AddVariantViewModel get() {
      return provideAddVariantsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
