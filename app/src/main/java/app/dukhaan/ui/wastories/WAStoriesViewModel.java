/*
 * Decompiled with CFR 0.0.
 */
package app.dukhaan.ui.wastories;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.wastories.WAStoriesNavigator;

public class WAStoriesViewModel
extends BaseViewModel<WAStoriesNavigator> {
    public WAStoriesViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }
}

