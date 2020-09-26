/*
 * Decompiled with CFR 0.0.
 */
package app.dukhaan.ui.reportissue;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.privacy.PrivacyPolicyNavigator;

public class ReportIssueViewModel
extends BaseViewModel<PrivacyPolicyNavigator> {
    public ReportIssueViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }
}

