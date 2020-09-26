package app.dukhaan.ui.ui.videotutorials;

import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.databinding.ActivityVideoTutorialsBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.videotutorials.VideoTutorialNavigator;
import app.dukhaan.ui.videotutorials.VideoTutorialViewModel;
import app.dukhaan.ui.views.videotutorials.VideoTutorialsAdapter;
import app.dukhaan.util.ModalDialogs;

public class VideoTutorialsActivity extends BaseActivity<ActivityVideoTutorialsBinding, VideoTutorialViewModel> implements VideoTutorialNavigator {
   VideoTutorialsAdapter adapter;
   ActivityVideoTutorialsBinding binding;
   VideoTutorialViewModel mViewModel;

   public VideoTutorialsActivity() {
   }

   public int getLayoutId() {
      return activity_video_tutorials;
   }

   public Class<VideoTutorialViewModel> getViewModel() {
      return VideoTutorialViewModel.class;
   }

   public void onApiError(ErrorResponse var1) {
      ModalDialogs.showUnknownError(this);
   }

   protected void onCreate(Bundle var1, VideoTutorialViewModel var2, ActivityVideoTutorialsBinding var3) {
      this.mViewModel = var2;
      this.binding = var3;
      this.setSupportActionBar(var3.toolbar);
      this.enableToolbarUpNavigation();
      var3.toolbar.setNavigationOnClickListener(new _$$Lambda$VideoTutorialsActivity$tWB5B1WBqUCuISQO_LLXGNAHFJ8(this));
      this.adapter = new VideoTutorialsAdapter();
      GridLayoutManager var4 = new GridLayoutManager(this, 2, 1, false);
      var3.recyclerview.setLayoutManager(var4);
      var3.recyclerview.setAdapter(this.adapter);
      this.mViewModel.fetchVideoList();
      this.mViewModel.getVideoLiveData().observe(this, new _$$Lambda$VideoTutorialsActivity$1khE2KbCvUKCH_QERdDjHOQLYJU(this));
   }
}
