package app.dukhaan.ui.ui.reportissue;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.reportissue.ReportIssueViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class ReportIssueModule {
   public ReportIssueModule() {
   }

   @Provides
   ReportIssueViewModel provideReportIssueViewModel(DataRepository var1, ApiService var2) {
      return new ReportIssueViewModel(var1, var2);
   }

   @Provides
   Factory reportIssueViewModelProvider(ReportIssueViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }
}
