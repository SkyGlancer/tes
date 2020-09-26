package app.dukhaan.ui.ui.reportissue;

import android.os.Bundle;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.databinding.ActivityReportIssueBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.reportissue.ReportIssueNavigator;
import app.dukhaan.ui.reportissue.ReportIssueViewModel;
import app.dukhaan.util.ModalDialogs;

public class ReportIssueActivity extends BaseActivity<ActivityReportIssueBinding, ReportIssueViewModel> implements ReportIssueNavigator {
   private ActivityReportIssueBinding binding;
   private ReportIssueViewModel viewModel;

   public ReportIssueActivity() {
   }

   public int getLayoutId() {
      return activity_report_issue;
   }

   public Class<ReportIssueViewModel> getViewModel() {
      return ReportIssueViewModel.class;
   }

   public void onApiError(ErrorResponse var1) {
      ModalDialogs.showUnknownError(this);
   }

   protected void onCreate(Bundle var1, ReportIssueViewModel var2, ActivityReportIssueBinding var3) {
      this.viewModel = var2;
      this.binding = var3;
      this.setSupportActionBar(var3.toolbar);
      if (this.getSupportActionBar() != null) {
         this.getSupportActionBar().setTitle("Report Issue");
         this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      }

      var3.toolbar.setNavigationOnClickListener(new _$$Lambda$ReportIssueActivity$FescBxDbp70lfa17zay_7McrVT4(this));
   }
}
