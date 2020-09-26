package app.dukhaan.ui.ui.reportissue;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.reportissue.ReportIssueActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ReportIssueActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.reportissue.ReportIssueActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public ReportIssueActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.reportissue.ReportIssueActivity> create(Provider<Factory> var0) {
      return new ReportIssueActivity_MembersInjector(var0);
   }

   public void injectMembers(ReportIssueActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
