package app.dukhaan.ui.ui.sync_contacts;

import app.dukhaan.ui.sync_contacts.SyncContactsModule;
import app.dukhaan.ui.sync_contacts.SyncContactsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SyncContactsModule_SyncContactsViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.sync_contacts.SyncContactsModule module;
   private final Provider<app.dukhaan.ui.sync_contacts.SyncContactsViewModel> viewModelProvider;

   public SyncContactsModule_SyncContactsViewModelProviderFactory(app.dukhaan.ui.sync_contacts.SyncContactsModule var1, Provider<app.dukhaan.ui.sync_contacts.SyncContactsViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static SyncContactsModule_SyncContactsViewModelProviderFactory create(app.dukhaan.ui.sync_contacts.SyncContactsModule var0, Provider<app.dukhaan.ui.sync_contacts.SyncContactsViewModel> var1) {
      return new SyncContactsModule_SyncContactsViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory syncContactsViewModelProvider(SyncContactsModule var0, app.dukhaan.ui.sync_contacts.SyncContactsViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.syncContactsViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return syncContactsViewModelProvider(this.module, (SyncContactsViewModel)this.viewModelProvider.get());
   }
}
