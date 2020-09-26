/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.app.ActionBar
 *  androidx.appcompat.widget.Toolbar
 *  androidx.databinding.ViewDataBinding
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.databinding.ActivityReportIssueBinding
 *  app.dukhaan.ui.reportissue.ReportIssueNavigator
 *  app.dukhaan.ui.reportissue.ReportIssueViewModel
 *  com.google.android.material.appbar.MaterialToolbar
 *  java.lang.CharSequence
 *  java.lang.Class
 */
package app.dukhaan.ui.reportissue;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.databinding.ActivityReportIssueBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.reportissue.-$$Lambda$ReportIssueActivity$FescBxDbp70lfa17zay-7McrVT4;
import app.dukhaan.ui.reportissue.ReportIssueNavigator;
import app.dukhaan.ui.reportissue.ReportIssueViewModel;
import app.dukhaan.util.ModalDialogs;
import com.google.android.material.appbar.MaterialToolbar;

public class ReportIssueActivity
extends BaseActivity<ActivityReportIssueBinding, ReportIssueViewModel>
implements ReportIssueNavigator {
    private ActivityReportIssueBinding binding;
    private ReportIssueViewModel viewModel;

    @Override
    public int getLayoutId() {
        return 2131558446;
    }

    @Override
    public Class<ReportIssueViewModel> getViewModel() {
        return ReportIssueViewModel.class;
    }

    public /* synthetic */ void lambda$onCreate$0$ReportIssueActivity(View view) {
        this.onBackPressed();
    }

    public void onApiError(ErrorResponse errorResponse) {
        ModalDialogs.showUnknownError((Activity)this);
    }

    @Override
    protected void onCreate(Bundle bundle, ReportIssueViewModel reportIssueViewModel, ActivityReportIssueBinding activityReportIssueBinding) {
        this.viewModel = reportIssueViewModel;
        this.binding = activityReportIssueBinding;
        this.setSupportActionBar((Toolbar)activityReportIssueBinding.toolbar);
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setTitle((CharSequence)"Report Issue");
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        activityReportIssueBinding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$ReportIssueActivity$FescBxDbp70lfa17zay-7McrVT4(this));
    }
}

