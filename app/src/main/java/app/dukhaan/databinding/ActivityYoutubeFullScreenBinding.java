/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.viewbinding.ViewBinding
 *  com.google.android.youtube.player.YouTubePlayerView
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.databinding;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.youtube.player.YouTubePlayerView;

public final class ActivityYoutubeFullScreenBinding
implements ViewBinding {
    public final ConstraintLayout containerParent;
    public final YouTubePlayerView player;
    private final ConstraintLayout rootView;

    private ActivityYoutubeFullScreenBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, YouTubePlayerView youTubePlayerView) {
        this.rootView = constraintLayout;
        this.containerParent = constraintLayout2;
        this.player = youTubePlayerView;
    }

    public static ActivityYoutubeFullScreenBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout)view;
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView)view.findViewById(2131362397);
        if (youTubePlayerView != null) {
            return new ActivityYoutubeFullScreenBinding(constraintLayout, constraintLayout, youTubePlayerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(2131362397)));
    }

    public static ActivityYoutubeFullScreenBinding inflate(LayoutInflater layoutInflater) {
        return ActivityYoutubeFullScreenBinding.inflate(layoutInflater, null, false);
    }

    public static ActivityYoutubeFullScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558453, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return ActivityYoutubeFullScreenBinding.bind(view);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}

