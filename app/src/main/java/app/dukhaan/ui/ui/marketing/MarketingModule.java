package app.dukhaan.ui.ui.marketing;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.marketing.MarketingViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class MarketingModule {
   public MarketingModule() {
   }

   @Provides
   Factory marketingViewModelProvider(MarketingViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   MarketingViewModel provideMarketingStepsViewModel(DataRepository var1, ApiService var2) {
      return new MarketingViewModel(var1, var2);
   }
}
