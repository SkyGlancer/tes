package app.dukhaan.ui.ui.videotutorials;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.videotutorials.VideoTutorialModule;
import app.dukhaan.ui.videotutorials.VideoTutorialViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class VideoTutorialModule_ProvideVideoListViewModelFactory implements Factory<app.dukhaan.ui.videotutorials.VideoTutorialViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.videotutorials.VideoTutorialModule module;

   public VideoTutorialModule_ProvideVideoListViewModelFactory(app.dukhaan.ui.videotutorials.VideoTutorialModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static VideoTutorialModule_ProvideVideoListViewModelFactory create(app.dukhaan.ui.videotutorials.VideoTutorialModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new VideoTutorialModule_ProvideVideoListViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.videotutorials.VideoTutorialViewModel provideVideoListViewModel(VideoTutorialModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.videotutorials.VideoTutorialViewModel)Preconditions.checkNotNull(var0.provideVideoListViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public VideoTutorialViewModel get() {
      return provideVideoListViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
