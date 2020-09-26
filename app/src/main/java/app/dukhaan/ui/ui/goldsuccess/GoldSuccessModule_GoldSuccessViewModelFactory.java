package app.dukhaan.ui.ui.goldsuccess;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.goldsuccess.GoldSuccessModule;
import app.dukhaan.ui.goldsuccess.GoldSuccessViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class GoldSuccessModule_GoldSuccessViewModelFactory implements Factory<app.dukhaan.ui.goldsuccess.GoldSuccessViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.goldsuccess.GoldSuccessModule module;

   public GoldSuccessModule_GoldSuccessViewModelFactory(app.dukhaan.ui.goldsuccess.GoldSuccessModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static GoldSuccessModule_GoldSuccessViewModelFactory create(app.dukhaan.ui.goldsuccess.GoldSuccessModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new GoldSuccessModule_GoldSuccessViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.goldsuccess.GoldSuccessViewModel goldSuccessViewModel(GoldSuccessModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.goldsuccess.GoldSuccessViewModel)Preconditions.checkNotNull(var0.goldSuccessViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public GoldSuccessViewModel get() {
      return goldSuccessViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
