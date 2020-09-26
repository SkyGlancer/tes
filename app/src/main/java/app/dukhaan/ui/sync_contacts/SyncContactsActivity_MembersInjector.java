/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.MembersInjector
 *  java.lang.Object
 *  javax.inject.Provider
 */
package app.dukhaan.ui.sync_contacts;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.sync_contacts.SyncContactsActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SyncContactsActivity_MembersInjector
implements MembersInjector<SyncContactsActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public SyncContactsActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<SyncContactsActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new SyncContactsActivity_MembersInjector(provider);
    }

    public void injectMembers(SyncContactsActivity syncContactsActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(syncContactsActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

