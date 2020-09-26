/*
 * Decompiled with CFR 0.0.
 */
package app.dukhaan.ui.privacy;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.privacy.PrivacyPolicyNavigator;

public class PrivacyPolicyViewModel
extends BaseViewModel<PrivacyPolicyNavigator> {
    public PrivacyPolicyViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }
}

