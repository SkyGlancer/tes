package app.dukhaan.ui.ui.home;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.home.HomeModule;
import app.dukhaan.ui.home.HomeViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class HomeModule_ProvideAboutViewModelFactory implements Factory<app.dukhaan.ui.home.HomeViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.home.HomeModule module;

   public HomeModule_ProvideAboutViewModelFactory(app.dukhaan.ui.home.HomeModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static HomeModule_ProvideAboutViewModelFactory create(app.dukhaan.ui.home.HomeModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new HomeModule_ProvideAboutViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.home.HomeViewModel provideAboutViewModel(HomeModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.home.HomeViewModel)Preconditions.checkNotNull(var0.provideAboutViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public HomeViewModel get() {
      return provideAboutViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
