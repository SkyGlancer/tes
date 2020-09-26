package app.dukhaan.ui.ui.addvariant;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.addvariant.AddVariantNavigator;

public class AddVariantViewModel extends BaseViewModel<AddVariantNavigator> {
   public AddVariantViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }
}
