/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.sync_contacts.SyncContactsViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.sync_contacts;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.sync_contacts.SyncContactsViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class SyncContactsModule {
    @Provides
    SyncContactsViewModel provideSyncContactsViewModel(DataRepository dataRepository, ApiService apiService) {
        return new SyncContactsViewModel(dataRepository, apiService);
    }

    @Provides
    ViewModelProvider.Factory syncContactsViewModelProvider(SyncContactsViewModel syncContactsViewModel) {
        return new ViewModelProviderFactory((Object)syncContactsViewModel);
    }
}

