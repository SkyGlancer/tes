package app.dukhaan.ui.ui.videotutorials;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.videotutorials.VideoTutorialsActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class VideoTutorialsActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.videotutorials.VideoTutorialsActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public VideoTutorialsActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.videotutorials.VideoTutorialsActivity> create(Provider<Factory> var0) {
      return new VideoTutorialsActivity_MembersInjector(var0);
   }

   public void injectMembers(VideoTutorialsActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
