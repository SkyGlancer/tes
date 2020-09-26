package app.dukhaan.ui.ui.videofullscreen;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import app.dukhaan.databinding.ActivityYoutubeFullScreenBinding;
import app.dukhaan.ui.videofullscreen.YouTubeFailureRecoveryActivity;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;

public class YoutubeFullScreenActivity extends YouTubeFailureRecoveryActivity implements OnFullscreenListener {
   public static final String EXTRA_VIDEOID = "videoid";
   ActivityYoutubeFullScreenBinding binding;
   String title;
   String videoId;
   TextView videoTitle;
   YouTubePlayer youTubePlayer;

   public YoutubeFullScreenActivity() {
   }

   private void doLayout() {
      LayoutParams var1 = (LayoutParams)this.binding.player.getLayoutParams();
      var1.width = -1;
      var1.height = -1;
   }

   protected Provider getYouTubePlayerProvider() {
      return this.binding.player;
   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      this.doLayout();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ActivityYoutubeFullScreenBinding var2 = ActivityYoutubeFullScreenBinding.inflate(this.getLayoutInflater());
      this.binding = var2;
      this.setContentView(var2.getRoot());
      this.videoId = this.getIntent().getExtras().getString(R.string."videoid");
      this.binding.player.initialize(this.getString(R.string.google_api_key), this);
   }

   public void onFullscreen(boolean var1) {
      this.doLayout();
   }

   public void onInitializationSuccess(Provider var1, YouTubePlayer var2, boolean var3) {
      this.youTubePlayer = var2;
      var2.addFullscreenControlFlag(8);
      var2.setOnFullscreenListener(this);
      if (!var3) {
         var2.cueVideo(this.videoId);
      }

   }

   public void onResume() {
      super.onResume();
      if (this.getResources().getConfiguration().orientation == 2) {
         this.getWindow().addFlags(1024);
         LayoutParams var1 = (LayoutParams)this.binding.player.getLayoutParams();
         var1.width = -1;
         var1.height = -1;
      }

   }
}
