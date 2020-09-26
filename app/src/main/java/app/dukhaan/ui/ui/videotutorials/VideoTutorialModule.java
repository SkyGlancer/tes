package app.dukhaan.ui.ui.videotutorials;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.videotutorials.VideoTutorialViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class VideoTutorialModule {
   public VideoTutorialModule() {
   }

   @Provides
   VideoTutorialViewModel provideVideoListViewModel(DataRepository var1, ApiService var2) {
      return new VideoTutorialViewModel(var1, var2);
   }

   @Provides
   Factory videoListModelProvider(VideoTutorialViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }
}
