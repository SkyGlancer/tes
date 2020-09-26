/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.widget.Toolbar
 *  androidx.databinding.ViewDataBinding
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.ui.wastories.WAStoriesListAdapter
 *  app.dukhaan.ui.wastories.WAStoriesNavigator
 *  app.dukhaan.ui.wastories.WAStoriesViewModel
 *  com.google.android.material.appbar.MaterialToolbar
 *  java.lang.Class
 */
package app.dukhaan.ui.wastories;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.databinding.ActivityWaStoriesBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.wastories.-$$Lambda$WAStoriesActivity$a7diIVawRW1DIVDw-gRvQ2ZqCUs;
import app.dukhaan.ui.wastories.WAStoriesListAdapter;
import app.dukhaan.ui.wastories.WAStoriesNavigator;
import app.dukhaan.ui.wastories.WAStoriesViewModel;
import app.dukhaan.util.ModalDialogs;
import com.google.android.material.appbar.MaterialToolbar;

public class WAStoriesActivity
extends BaseActivity<ActivityWaStoriesBinding, WAStoriesViewModel>
implements WAStoriesNavigator {
    ActivityWaStoriesBinding binding;
    WAStoriesViewModel mViewModel;

    @Override
    public int getLayoutId() {
        return 2131558451;
    }

    @Override
    public Class<WAStoriesViewModel> getViewModel() {
        return WAStoriesViewModel.class;
    }

    public /* synthetic */ void lambda$onCreate$0$WAStoriesActivity(View view) {
        this.onBackPressed();
    }

    public void onApiError(ErrorResponse errorResponse) {
        ModalDialogs.showUnknownError((Activity)this);
    }

    @Override
    protected void onCreate(Bundle bundle, WAStoriesViewModel wAStoriesViewModel, ActivityWaStoriesBinding activityWaStoriesBinding) {
        this.mViewModel = wAStoriesViewModel;
        this.binding = activityWaStoriesBinding;
        this.setSupportActionBar((Toolbar)activityWaStoriesBinding.toolbar);
        this.enableToolbarUpNavigation();
        activityWaStoriesBinding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$WAStoriesActivity$a7diIVawRW1DIVDw-gRvQ2ZqCUs(this));
        WAStoriesListAdapter wAStoriesListAdapter = new WAStoriesListAdapter((Context)this);
        activityWaStoriesBinding.viewPager.setAdapter((PagerAdapter)wAStoriesListAdapter);
    }
}

