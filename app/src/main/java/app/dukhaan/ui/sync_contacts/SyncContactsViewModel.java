/*
 * Decompiled with CFR 0.0.
 */
package app.dukhaan.ui.sync_contacts;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.sync_contacts.SyncContactsNavigator;

public class SyncContactsViewModel
extends BaseViewModel<SyncContactsNavigator> {
    public SyncContactsViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }
}

