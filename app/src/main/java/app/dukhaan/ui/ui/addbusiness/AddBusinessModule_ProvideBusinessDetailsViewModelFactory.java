package app.dukhaan.ui.ui.addbusiness;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.addbusiness.AddBusinessModule;
import app.dukhaan.ui.addbusiness.AddBusinessViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AddBusinessModule_ProvideBusinessDetailsViewModelFactory implements Factory<app.dukhaan.ui.addbusiness.AddBusinessViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.addbusiness.AddBusinessModule module;

   public AddBusinessModule_ProvideBusinessDetailsViewModelFactory(app.dukhaan.ui.addbusiness.AddBusinessModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static AddBusinessModule_ProvideBusinessDetailsViewModelFactory create(app.dukhaan.ui.addbusiness.AddBusinessModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new AddBusinessModule_ProvideBusinessDetailsViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.addbusiness.AddBusinessViewModel provideBusinessDetailsViewModel(AddBusinessModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.addbusiness.AddBusinessViewModel)Preconditions.checkNotNull(var0.provideBusinessDetailsViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public AddBusinessViewModel get() {
      return provideBusinessDetailsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
