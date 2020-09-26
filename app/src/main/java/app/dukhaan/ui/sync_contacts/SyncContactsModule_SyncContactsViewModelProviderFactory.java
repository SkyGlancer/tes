/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.sync_contacts;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.sync_contacts.SyncContactsModule;
import app.dukhaan.ui.sync_contacts.SyncContactsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SyncContactsModule_SyncContactsViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final SyncContactsModule module;
    private final Provider<SyncContactsViewModel> viewModelProvider;

    public SyncContactsModule_SyncContactsViewModelProviderFactory(SyncContactsModule syncContactsModule, Provider<SyncContactsViewModel> provider) {
        this.module = syncContactsModule;
        this.viewModelProvider = provider;
    }

    public static SyncContactsModule_SyncContactsViewModelProviderFactory create(SyncContactsModule syncContactsModule, Provider<SyncContactsViewModel> provider) {
        return new SyncContactsModule_SyncContactsViewModelProviderFactory(syncContactsModule, provider);
    }

    public static ViewModelProvider.Factory syncContactsViewModelProvider(SyncContactsModule syncContactsModule, SyncContactsViewModel syncContactsViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)syncContactsModule.syncContactsViewModelProvider(syncContactsViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return SyncContactsModule_SyncContactsViewModelProviderFactory.syncContactsViewModelProvider(this.module, (SyncContactsViewModel)((Object)this.viewModelProvider.get()));
    }
}

