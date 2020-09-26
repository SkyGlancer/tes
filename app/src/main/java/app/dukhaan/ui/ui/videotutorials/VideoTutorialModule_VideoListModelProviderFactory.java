package app.dukhaan.ui.ui.videotutorials;

import app.dukhaan.ui.videotutorials.VideoTutorialModule;
import app.dukhaan.ui.videotutorials.VideoTutorialViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class VideoTutorialModule_VideoListModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.videotutorials.VideoTutorialModule module;
   private final Provider<app.dukhaan.ui.videotutorials.VideoTutorialViewModel> viewModelProvider;

   public VideoTutorialModule_VideoListModelProviderFactory(app.dukhaan.ui.videotutorials.VideoTutorialModule var1, Provider<app.dukhaan.ui.videotutorials.VideoTutorialViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static VideoTutorialModule_VideoListModelProviderFactory create(app.dukhaan.ui.videotutorials.VideoTutorialModule var0, Provider<app.dukhaan.ui.videotutorials.VideoTutorialViewModel> var1) {
      return new VideoTutorialModule_VideoListModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory videoListModelProvider(VideoTutorialModule var0, app.dukhaan.ui.videotutorials.VideoTutorialViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.videoListModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return videoListModelProvider(this.module, (VideoTutorialViewModel)this.viewModelProvider.get());
   }
}
