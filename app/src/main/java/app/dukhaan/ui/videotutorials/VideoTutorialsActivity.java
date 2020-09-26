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
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.MutableLiveData
 *  androidx.lifecycle.Observer
 *  androidx.recyclerview.widget.GridLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.ui.videotutorials.-$
 *  app.dukhaan.ui.videotutorials.-$$Lambda
 *  app.dukhaan.ui.videotutorials.-$$Lambda$VideoTutorialsActivity
 *  app.dukhaan.ui.videotutorials.-$$Lambda$VideoTutorialsActivity$1khE2KbCvUKCH-QERdDjHOQLYJU
 *  app.dukhaan.ui.videotutorials.VideoTutorialNavigator
 *  app.dukhaan.ui.videotutorials.VideoTutorialViewModel
 *  app.dukhaan.ui.views.videotutorials.VideoTutorialsAdapter
 *  com.google.android.material.appbar.MaterialToolbar
 *  java.lang.Class
 *  java.util.List
 */
package app.dukhaan.ui.videotutorials;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.databinding.ActivityVideoTutorialsBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.videotutorials.-$;
import app.dukhaan.ui.videotutorials.-$$Lambda$VideoTutorialsActivity$tWB5B1WBqUCuISQO_LLXGNAHFJ8;
import app.dukhaan.ui.videotutorials.VideoTutorialNavigator;
import app.dukhaan.ui.videotutorials.VideoTutorialViewModel;
import app.dukhaan.ui.views.videotutorials.VideoTutorialsAdapter;
import app.dukhaan.util.ModalDialogs;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.List;

public class VideoTutorialsActivity
extends BaseActivity<ActivityVideoTutorialsBinding, VideoTutorialViewModel>
implements VideoTutorialNavigator {
    VideoTutorialsAdapter adapter;
    ActivityVideoTutorialsBinding binding;
    VideoTutorialViewModel mViewModel;

    @Override
    public int getLayoutId() {
        return 2131558452;
    }

    @Override
    public Class<VideoTutorialViewModel> getViewModel() {
        return VideoTutorialViewModel.class;
    }

    public /* synthetic */ void lambda$onCreate$0$VideoTutorialsActivity(View view) {
        this.onBackPressed();
    }

    public /* synthetic */ void lambda$onCreate$1$VideoTutorialsActivity(List list) {
        this.adapter.setData(list);
    }

    public void onApiError(ErrorResponse errorResponse) {
        ModalDialogs.showUnknownError((Activity)this);
    }

    @Override
    protected void onCreate(Bundle bundle, VideoTutorialViewModel videoTutorialViewModel, ActivityVideoTutorialsBinding activityVideoTutorialsBinding) {
        this.mViewModel = videoTutorialViewModel;
        this.binding = activityVideoTutorialsBinding;
        this.setSupportActionBar((Toolbar)activityVideoTutorialsBinding.toolbar);
        this.enableToolbarUpNavigation();
        activityVideoTutorialsBinding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$VideoTutorialsActivity$tWB5B1WBqUCuISQO_LLXGNAHFJ8(this));
        this.adapter = new VideoTutorialsAdapter();
        GridLayoutManager gridLayoutManager = new GridLayoutManager((Context)this, 2, 1, false);
        activityVideoTutorialsBinding.recyclerview.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
        activityVideoTutorialsBinding.recyclerview.setAdapter((RecyclerView.Adapter)this.adapter);
        this.mViewModel.fetchVideoList();
        this.mViewModel.getVideoLiveData().observe((LifecycleOwner)this, (Observer)new -$.Lambda.VideoTutorialsActivity.1khE2KbCvUKCH-QERdDjHOQLYJU(this));
    }
}

