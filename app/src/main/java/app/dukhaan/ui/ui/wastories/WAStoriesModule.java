package app.dukhaan.ui.ui.wastories;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.wastories.WAStoriesViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class WAStoriesModule {
   public WAStoriesModule() {
   }

   @Provides
   WAStoriesViewModel waStoriesListViewModel(DataRepository var1, ApiService var2) {
      return new WAStoriesViewModel(var1, var2);
   }

   @Provides
   Factory waStoriesModelProvider(WAStoriesViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }
}
