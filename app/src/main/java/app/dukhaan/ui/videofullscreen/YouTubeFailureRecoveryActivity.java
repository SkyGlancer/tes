/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.Intent
 *  android.widget.Toast
 *  com.google.android.youtube.player.YouTubeBaseActivity
 *  com.google.android.youtube.player.YouTubeInitializationResult
 *  com.google.android.youtube.player.YouTubePlayer
 *  com.google.android.youtube.player.YouTubePlayer$OnInitializedListener
 *  com.google.android.youtube.player.YouTubePlayer$Provider
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.videofullscreen;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

public abstract class YouTubeFailureRecoveryActivity
extends YouTubeBaseActivity
implements YouTubePlayer.OnInitializedListener {
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    protected abstract YouTubePlayer.Provider getYouTubePlayerProvider();

    protected void onActivityResult(int n, int n2, Intent intent) {
        if (n == 1) {
            this.getYouTubePlayerProvider().initialize(this.getString(2131951793), (YouTubePlayer.OnInitializedListener)this);
        }
    }

    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog((Activity)this, 1).show();
            return;
        }
        String string2 = this.getString(2131951776);
        Object[] arrobject = new Object[]{youTubeInitializationResult.toString()};
        Toast.makeText((Context)this, (CharSequence)String.format((String)string2, (Object[])arrobject), (int)1).show();
    }
}

