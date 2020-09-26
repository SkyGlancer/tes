package app.dukhaan.ui.ui.reportissue;

import app.dukhaan.ui.reportissue.ReportIssueModule;
import app.dukhaan.ui.reportissue.ReportIssueViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ReportIssueModule_ReportIssueViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.reportissue.ReportIssueModule module;
   private final Provider<app.dukhaan.ui.reportissue.ReportIssueViewModel> viewModelProvider;

   public ReportIssueModule_ReportIssueViewModelProviderFactory(app.dukhaan.ui.reportissue.ReportIssueModule var1, Provider<app.dukhaan.ui.reportissue.ReportIssueViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static ReportIssueModule_ReportIssueViewModelProviderFactory create(app.dukhaan.ui.reportissue.ReportIssueModule var0, Provider<app.dukhaan.ui.reportissue.ReportIssueViewModel> var1) {
      return new ReportIssueModule_ReportIssueViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory reportIssueViewModelProvider(ReportIssueModule var0, app.dukhaan.ui.reportissue.ReportIssueViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.reportIssueViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return reportIssueViewModelProvider(this.module, (ReportIssueViewModel)this.viewModelProvider.get());
   }
}
