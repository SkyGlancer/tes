/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
 *  com.google.android.youtube.player.YouTubePlayer
 *  com.google.android.youtube.player.YouTubePlayer$OnFullscreenListener
 *  com.google.android.youtube.player.YouTubePlayer$OnInitializedListener
 *  com.google.android.youtube.player.YouTubePlayer$Provider
 *  com.google.android.youtube.player.YouTubePlayerView
 *  java.lang.String
 */
package app.dukhaan.ui.videofullscreen;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.dukhaan.databinding.ActivityYoutubeFullScreenBinding;
import app.dukhaan.ui.videofullscreen.YouTubeFailureRecoveryActivity;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeFullScreenActivity
extends YouTubeFailureRecoveryActivity
implements YouTubePlayer.OnFullscreenListener {
    public static final String EXTRA_VIDEOID = "videoid";
    ActivityYoutubeFullScreenBinding binding;
    String title;
    String videoId;
    TextView videoTitle;
    YouTubePlayer youTubePlayer;

    private void doLayout() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)this.binding.player.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return this.binding.player;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.doLayout();
    }

    protected void onCreate(Bundle bundle) {
        ActivityYoutubeFullScreenBinding activityYoutubeFullScreenBinding;
        super.onCreate(bundle);
        this.binding = activityYoutubeFullScreenBinding = ActivityYoutubeFullScreenBinding.inflate(this.getLayoutInflater());
        this.setContentView((View)activityYoutubeFullScreenBinding.getRoot());
        this.videoId = this.getIntent().getExtras().getString(EXTRA_VIDEOID);
        this.binding.player.initialize(this.getString(2131951793), (YouTubePlayer.OnInitializedListener)this);
    }

    public void onFullscreen(boolean bl) {
        this.doLayout();
    }

    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean bl) {
        this.youTubePlayer = youTubePlayer;
        youTubePlayer.addFullscreenControlFlag(8);
        youTubePlayer.setOnFullscreenListener((YouTubePlayer.OnFullscreenListener)this);
        if (!bl) {
            youTubePlayer.cueVideo(this.videoId);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.getResources().getConfiguration().orientation == 2) {
            this.getWindow().addFlags(1024);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)this.binding.player.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
    }
}

