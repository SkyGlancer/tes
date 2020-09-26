/*
 * Decompiled with CFR 0.0.
 */
package app.dukhaan.ui.categorydetail;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.categorydetail.CategoryDetailNaivigator;

public class CategoryDetailViewModel
extends BaseViewModel<CategoryDetailNaivigator> {
    public CategoryDetailViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }
}

