package app.dukhaan.ui.ui.wastories;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.wastories.WAStoriesNavigator;

public class WAStoriesViewModel extends BaseViewModel<WAStoriesNavigator> {
   public WAStoriesViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }
}
