/*
 * Decompiled with CFR 0.0.
 */
package app.dukhaan.ui.verifymobile;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.verifymobile.VerifyMobileNavigator;

public class VerifyMobileViewModel
extends BaseViewModel<VerifyMobileNavigator> {
    public VerifyMobileViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }
}

