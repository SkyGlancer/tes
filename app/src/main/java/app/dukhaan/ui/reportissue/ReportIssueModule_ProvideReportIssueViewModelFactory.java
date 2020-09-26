/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.reportissue;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.reportissue.ReportIssueModule;
import app.dukhaan.ui.reportissue.ReportIssueViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ReportIssueModule_ProvideReportIssueViewModelFactory
implements Factory<ReportIssueViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final ReportIssueModule module;

    public ReportIssueModule_ProvideReportIssueViewModelFactory(ReportIssueModule reportIssueModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = reportIssueModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static ReportIssueModule_ProvideReportIssueViewModelFactory create(ReportIssueModule reportIssueModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new ReportIssueModule_ProvideReportIssueViewModelFactory(reportIssueModule, provider, provider2);
    }

    public static ReportIssueViewModel provideReportIssueViewModel(ReportIssueModule reportIssueModule, DataRepository dataRepository, ApiService apiService) {
        return (ReportIssueViewModel)((Object)Preconditions.checkNotNull((Object)((Object)reportIssueModule.provideReportIssueViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public ReportIssueViewModel get() {
        return ReportIssueModule_ProvideReportIssueViewModelFactory.provideReportIssueViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

