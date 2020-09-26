/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.reportissue;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.reportissue.ReportIssueModule;
import app.dukhaan.ui.reportissue.ReportIssueViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ReportIssueModule_ReportIssueViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final ReportIssueModule module;
    private final Provider<ReportIssueViewModel> viewModelProvider;

    public ReportIssueModule_ReportIssueViewModelProviderFactory(ReportIssueModule reportIssueModule, Provider<ReportIssueViewModel> provider) {
        this.module = reportIssueModule;
        this.viewModelProvider = provider;
    }

    public static ReportIssueModule_ReportIssueViewModelProviderFactory create(ReportIssueModule reportIssueModule, Provider<ReportIssueViewModel> provider) {
        return new ReportIssueModule_ReportIssueViewModelProviderFactory(reportIssueModule, provider);
    }

    public static ViewModelProvider.Factory reportIssueViewModelProvider(ReportIssueModule reportIssueModule, ReportIssueViewModel reportIssueViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)reportIssueModule.reportIssueViewModelProvider(reportIssueViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return ReportIssueModule_ReportIssueViewModelProviderFactory.reportIssueViewModelProvider(this.module, (ReportIssueViewModel)((Object)this.viewModelProvider.get()));
    }
}

