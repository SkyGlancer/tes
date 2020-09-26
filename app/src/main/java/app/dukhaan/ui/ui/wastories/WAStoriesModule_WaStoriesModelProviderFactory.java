package app.dukhaan.ui.ui.wastories;

import app.dukhaan.ui.wastories.WAStoriesModule;
import app.dukhaan.ui.wastories.WAStoriesViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class WAStoriesModule_WaStoriesModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.wastories.WAStoriesModule module;
   private final Provider<app.dukhaan.ui.wastories.WAStoriesViewModel> viewModelProvider;

   public WAStoriesModule_WaStoriesModelProviderFactory(app.dukhaan.ui.wastories.WAStoriesModule var1, Provider<app.dukhaan.ui.wastories.WAStoriesViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static WAStoriesModule_WaStoriesModelProviderFactory create(app.dukhaan.ui.wastories.WAStoriesModule var0, Provider<app.dukhaan.ui.wastories.WAStoriesViewModel> var1) {
      return new WAStoriesModule_WaStoriesModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory waStoriesModelProvider(WAStoriesModule var0, app.dukhaan.ui.wastories.WAStoriesViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.waStoriesModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return waStoriesModelProvider(this.module, (WAStoriesViewModel)this.viewModelProvider.get());
   }
}
