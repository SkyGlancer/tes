package app.dukhaan.ui.ui.reportissue;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.privacy.PrivacyPolicyNavigator;

public class ReportIssueViewModel extends BaseViewModel<PrivacyPolicyNavigator> {
   public ReportIssueViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }
}
