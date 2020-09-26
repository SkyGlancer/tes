/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  app.dukhaan.app.GlideRequest
 *  app.dukhaan.databinding.LayoutVideoTutorialListItemBinding
 *  app.dukhaan.ui.videofullscreen.YoutubeFullScreenActivity
 *  com.bumptech.glide.request.target.ViewTarget
 *  com.google.android.material.imageview.ShapeableImageView
 *  com.google.android.material.shape.ShapeAppearanceModel
 *  com.google.android.material.shape.ShapeAppearanceModel$Builder
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.ui.views.videotutorials;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import app.dukhaan.app.GlideApp;
import app.dukhaan.app.GlideRequest;
import app.dukhaan.data.model.VideoTutorial;
import app.dukhaan.databinding.LayoutVideoTutorialListItemBinding;
import app.dukhaan.ui.videofullscreen.YoutubeFullScreenActivity;
import com.bumptech.glide.request.target.ViewTarget;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.ShapeAppearanceModel;

public class VideoTutorialListItemCard
extends FrameLayout {
    LayoutVideoTutorialListItemBinding binding;
    VideoTutorial videoTutorial;

    public VideoTutorialListItemCard(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public VideoTutorialListItemCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public VideoTutorialListItemCard(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void applyStyle() {
        if (this.videoTutorial == null) {
            return;
        }
        this.loadThumbnail();
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        this.binding = LayoutVideoTutorialListItemBinding.inflate((LayoutInflater)((LayoutInflater)context.getSystemService("layout_inflater")), (ViewGroup)this, (boolean)true);
    }

    private void loadThumbnail() {
        float f = this.getResources().getDimension(2131165688);
        this.binding.thumbnail.setShapeAppearanceModel(this.binding.thumbnail.getShapeAppearanceModel().toBuilder().setAllCorners(0, f).build());
        if (!TextUtils.isEmpty((CharSequence)this.videoTutorial.videoId)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getContext().getString(2131952032));
            stringBuilder.append(this.videoTutorial.videoId);
            stringBuilder.append("/0.jpg");
            String string2 = stringBuilder.toString();
            GlideApp.with((View)this).load(string2).into((ImageView)this.binding.thumbnail);
        }
        this.binding.thumbnail.setOnClickListener(new OnClickListener(){

            public void onClick(View view) {
                VideoTutorialListItemCard.this.getContext().startActivity(new Intent(VideoTutorialListItemCard.this.getContext(), YoutubeFullScreenActivity.class).putExtra("videoid", VideoTutorialListItemCard.this.videoTutorial.videoId));
            }
        });
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.applyStyle();
    }

    public void setData(VideoTutorial videoTutorial) {
        this.videoTutorial = videoTutorial;
        this.applyStyle();
    }

}

