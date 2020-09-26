package app.dukhaan.ui.ui.wastories;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.wastories.WAStoriesModule;
import app.dukhaan.ui.wastories.WAStoriesViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class WAStoriesModule_WaStoriesListViewModelFactory implements Factory<app.dukhaan.ui.wastories.WAStoriesViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.wastories.WAStoriesModule module;

   public WAStoriesModule_WaStoriesListViewModelFactory(app.dukhaan.ui.wastories.WAStoriesModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static WAStoriesModule_WaStoriesListViewModelFactory create(app.dukhaan.ui.wastories.WAStoriesModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new WAStoriesModule_WaStoriesListViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.wastories.WAStoriesViewModel waStoriesListViewModel(WAStoriesModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.wastories.WAStoriesViewModel)Preconditions.checkNotNull(var0.waStoriesListViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public WAStoriesViewModel get() {
      return waStoriesListViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
