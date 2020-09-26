package app.dukhaan.ui.ui.videofullscreen;

import android.content.Intent;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;

public abstract class YouTubeFailureRecoveryActivity extends YouTubeBaseActivity implements OnInitializedListener {
   private static final int RECOVERY_DIALOG_REQUEST = 1;

   public YouTubeFailureRecoveryActivity() {
   }

   protected abstract Provider getYouTubePlayerProvider();

   protected void onActivityResult(int var1, int var2, Intent var3) {
      if (var1 == 1) {
         this.getYouTubePlayerProvider().initialize(this.getString(R.string.google_api_key), this);
      }

   }

   public void onInitializationFailure(Provider var1, YouTubeInitializationResult var2) {
      if (var2.isUserRecoverableError()) {
         var2.getErrorDialog(this, 1).show();
      } else {
         Toast.makeText(this, String.format(this.getString(R.string.error_player), var2.toString()), 1).show();
      }

   }
}
