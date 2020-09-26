package app.dukhaan.ui.ui.sync_contacts;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.sync_contacts.SyncContactsViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class SyncContactsModule {
   public SyncContactsModule() {
   }

   @Provides
   SyncContactsViewModel provideSyncContactsViewModel(DataRepository var1, ApiService var2) {
      return new SyncContactsViewModel(var1, var2);
   }

   @Provides
   Factory syncContactsViewModelProvider(SyncContactsViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }
}
