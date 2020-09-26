package app.dukhaan.ui.ui.sync_contacts;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.sync_contacts.SyncContactsNavigator;

public class SyncContactsViewModel extends BaseViewModel<SyncContactsNavigator> {
   public SyncContactsViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }
}
