package app.dukhaan.ui.ui.reportissue;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.reportissue.ReportIssueModule;
import app.dukhaan.ui.reportissue.ReportIssueViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ReportIssueModule_ProvideReportIssueViewModelFactory implements Factory<app.dukhaan.ui.reportissue.ReportIssueViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.reportissue.ReportIssueModule module;

   public ReportIssueModule_ProvideReportIssueViewModelFactory(app.dukhaan.ui.reportissue.ReportIssueModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static ReportIssueModule_ProvideReportIssueViewModelFactory create(app.dukhaan.ui.reportissue.ReportIssueModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new ReportIssueModule_ProvideReportIssueViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.reportissue.ReportIssueViewModel provideReportIssueViewModel(ReportIssueModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.reportissue.ReportIssueViewModel)Preconditions.checkNotNull(var0.provideReportIssueViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public ReportIssueViewModel get() {
      return provideReportIssueViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
