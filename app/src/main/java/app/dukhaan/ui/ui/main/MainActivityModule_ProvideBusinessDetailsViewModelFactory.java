package app.dukhaan.ui.ui.main;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.main.MainActivityModule;
import app.dukhaan.ui.main.MainActivityViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MainActivityModule_ProvideBusinessDetailsViewModelFactory implements Factory<app.dukhaan.ui.main.MainActivityViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.main.MainActivityModule module;

   public MainActivityModule_ProvideBusinessDetailsViewModelFactory(app.dukhaan.ui.main.MainActivityModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static MainActivityModule_ProvideBusinessDetailsViewModelFactory create(app.dukhaan.ui.main.MainActivityModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new MainActivityModule_ProvideBusinessDetailsViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.main.MainActivityViewModel provideBusinessDetailsViewModel(MainActivityModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.main.MainActivityViewModel)Preconditions.checkNotNull(var0.provideBusinessDetailsViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public MainActivityViewModel get() {
      return provideBusinessDetailsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
