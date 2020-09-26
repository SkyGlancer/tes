package app.dukhaan.ui.ui.catalogue;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.catalogue.CatalogueNavigator;

public class CatalogueViewModel extends BaseViewModel<CatalogueNavigator> {
   public CatalogueViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }
}
