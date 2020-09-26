package app.dukhaan.ui.ui.goldsuccess;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.goldsuccess.GoldSuccessViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class GoldSuccessModule {
   public GoldSuccessModule() {
   }

   @Provides
   GoldSuccessViewModel goldSuccessViewModel(DataRepository var1, ApiService var2) {
      return new GoldSuccessViewModel(var1, var2);
   }

   @Provides
   Factory goldSuccessViewModelProvider(GoldSuccessViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }
}
