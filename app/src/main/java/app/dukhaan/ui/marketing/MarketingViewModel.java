/*
 * Decompiled with CFR 0.0.
 */
package app.dukhaan.ui.marketing;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.marketing.MarketingNavigator;

public class MarketingViewModel
extends BaseViewModel<MarketingNavigator> {
    public MarketingViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }
}

