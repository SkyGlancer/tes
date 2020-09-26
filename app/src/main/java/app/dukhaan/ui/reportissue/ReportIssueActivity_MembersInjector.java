/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.MembersInjector
 *  java.lang.Object
 *  javax.inject.Provider
 */
package app.dukhaan.ui.reportissue;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.reportissue.ReportIssueActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ReportIssueActivity_MembersInjector
implements MembersInjector<ReportIssueActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public ReportIssueActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<ReportIssueActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new ReportIssueActivity_MembersInjector(provider);
    }

    public void injectMembers(ReportIssueActivity reportIssueActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(reportIssueActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

