/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.viewbinding.ViewBinding
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import app.dukhaan.ui.views.videotutorials.VideoTutorialListItemCard;

public final class VideoTutorialItemBinding
implements ViewBinding {
    private final VideoTutorialListItemCard rootView;
    public final VideoTutorialListItemCard videoCard;

    private VideoTutorialItemBinding(VideoTutorialListItemCard videoTutorialListItemCard, VideoTutorialListItemCard videoTutorialListItemCard2) {
        this.rootView = videoTutorialListItemCard;
        this.videoCard = videoTutorialListItemCard2;
    }

    public static VideoTutorialItemBinding bind(View view) {
        if (view != null) {
            VideoTutorialListItemCard videoTutorialListItemCard = (VideoTutorialListItemCard)view;
            return new VideoTutorialItemBinding(videoTutorialListItemCard, videoTutorialListItemCard);
        }
        throw new NullPointerException("rootView");
    }

    public static VideoTutorialItemBinding inflate(LayoutInflater layoutInflater) {
        return VideoTutorialItemBinding.inflate(layoutInflater, null, false);
    }

    public static VideoTutorialItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558656, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return VideoTutorialItemBinding.bind(view);
    }

    public VideoTutorialListItemCard getRoot() {
        return this.rootView;
    }
}

