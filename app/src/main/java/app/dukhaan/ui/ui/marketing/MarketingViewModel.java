package app.dukhaan.ui.ui.marketing;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.marketing.MarketingNavigator;

public class MarketingViewModel extends BaseViewModel<MarketingNavigator> {
   public MarketingViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }
}
