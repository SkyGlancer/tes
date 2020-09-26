/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.sync_contacts;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.sync_contacts.SyncContactsModule;
import app.dukhaan.ui.sync_contacts.SyncContactsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SyncContactsModule_ProvideSyncContactsViewModelFactory
implements Factory<SyncContactsViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final SyncContactsModule module;

    public SyncContactsModule_ProvideSyncContactsViewModelFactory(SyncContactsModule syncContactsModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = syncContactsModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static SyncContactsModule_ProvideSyncContactsViewModelFactory create(SyncContactsModule syncContactsModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new SyncContactsModule_ProvideSyncContactsViewModelFactory(syncContactsModule, provider, provider2);
    }

    public static SyncContactsViewModel provideSyncContactsViewModel(SyncContactsModule syncContactsModule, DataRepository dataRepository, ApiService apiService) {
        return (SyncContactsViewModel)((Object)Preconditions.checkNotNull((Object)((Object)syncContactsModule.provideSyncContactsViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public SyncContactsViewModel get() {
        return SyncContactsModule_ProvideSyncContactsViewModelFactory.provideSyncContactsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

