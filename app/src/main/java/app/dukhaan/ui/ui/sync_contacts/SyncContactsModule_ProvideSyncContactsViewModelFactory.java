package app.dukhaan.ui.ui.sync_contacts;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.sync_contacts.SyncContactsModule;
import app.dukhaan.ui.sync_contacts.SyncContactsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SyncContactsModule_ProvideSyncContactsViewModelFactory implements Factory<app.dukhaan.ui.sync_contacts.SyncContactsViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.sync_contacts.SyncContactsModule module;

   public SyncContactsModule_ProvideSyncContactsViewModelFactory(app.dukhaan.ui.sync_contacts.SyncContactsModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static SyncContactsModule_ProvideSyncContactsViewModelFactory create(app.dukhaan.ui.sync_contacts.SyncContactsModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new SyncContactsModule_ProvideSyncContactsViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.sync_contacts.SyncContactsViewModel provideSyncContactsViewModel(SyncContactsModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.sync_contacts.SyncContactsViewModel)Preconditions.checkNotNull(var0.provideSyncContactsViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public SyncContactsViewModel get() {
      return provideSyncContactsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
