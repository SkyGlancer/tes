/*
 * Decompiled with CFR 0.0.
 */
package app.dukhaan.ui.addvariant;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.addvariant.AddVariantNavigator;

public class AddVariantViewModel
extends BaseViewModel<AddVariantNavigator> {
    public AddVariantViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }
}

