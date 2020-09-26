/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.ui.views.videotutorials;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.data.model.VideoTutorial;
import app.dukhaan.ui.views.videotutorials.VideoTutorialListItemCard;
import java.util.List;

public class VideoTutorialsAdapter
extends RecyclerView.Adapter<VideoHolder> {
    private List<VideoTutorial> videosList;

    public int getItemCount() {
        List<VideoTutorial> list = this.videosList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void onBindViewHolder(VideoHolder videoHolder, int n) {
        VideoTutorial videoTutorial = (VideoTutorial)this.videosList.get(n);
        videoHolder.card.setData(videoTutorial);
    }

    public VideoHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new VideoHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131558656, viewGroup, false));
    }

    public void setData(List<VideoTutorial> list) {
        this.videosList = list;
        this.notifyDataSetChanged();
    }

    public class VideoHolder
    extends RecyclerView.ViewHolder {
        VideoTutorialListItemCard card;

        public VideoHolder(View view) {
            super(view);
            this.card = (VideoTutorialListItemCard)view.findViewById(2131362640);
        }
    }

}

