package app.dukhaan.ui.ui.sync_contacts;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.sync_contacts.SyncContactsActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SyncContactsActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.sync_contacts.SyncContactsActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public SyncContactsActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.sync_contacts.SyncContactsActivity> create(Provider<Factory> var0) {
      return new SyncContactsActivity_MembersInjector(var0);
   }

   public void injectMembers(SyncContactsActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
