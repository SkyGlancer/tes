/*
 * Decompiled with CFR 0.0.
 */
package app.dukhaan.ui.mobilenumber;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.mobilenumber.MobileNumberNavigator;

public class MobileNumberViewModel
extends BaseViewModel<MobileNumberNavigator> {
    public MobileNumberViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }
}

