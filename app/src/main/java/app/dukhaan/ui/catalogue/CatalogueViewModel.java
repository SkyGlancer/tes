/*
 * Decompiled with CFR 0.0.
 */
package app.dukhaan.ui.catalogue;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.catalogue.CatalogueNavigator;

public class CatalogueViewModel
extends BaseViewModel<CatalogueNavigator> {
    public CatalogueViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }
}

