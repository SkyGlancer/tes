package app.dukhaan.ui.ui.views.videotutorials;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import app.dukhaan.app.GlideApp;
import app.dukhaan.data.model.VideoTutorial;
import app.dukhaan.databinding.LayoutVideoTutorialListItemBinding;
import app.dukhaan.ui.views.videotutorials.VideoTutorialListItemCard.1;

public class VideoTutorialListItemCard extends FrameLayout {
   LayoutVideoTutorialListItemBinding binding;
   VideoTutorial videoTutorial;

   public VideoTutorialListItemCard(Context var1) {
      super(var1);
      this.init(var1, (AttributeSet)null, 0);
   }

   public VideoTutorialListItemCard(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1, var2, 0);
   }

   public VideoTutorialListItemCard(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1, var2, var3);
   }

   private void applyStyle() {
      if (this.videoTutorial != null) {
         this.loadThumbnail();
      }
   }

   private void init(Context var1, AttributeSet var2, int var3) {
      this.binding = LayoutVideoTutorialListItemBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"), this, true);
   }

   private void loadThumbnail() {
      float var1 = this.getResources().getDimension(thumbnail_min_corner_radius);
      this.binding.thumbnail.setShapeAppearanceModel(this.binding.thumbnail.getShapeAppearanceModel().toBuilder().setAllCorners(0, var1).build());
      if (!TextUtils.isEmpty(this.videoTutorial.videoId)) {
         StringBuilder var2 = new StringBuilder();
         var2.append(this.getContext().getString(R.string.youtube_thumbnai));
         var2.append(this.videoTutorial.videoId);
         var2.append("/0.jpg");
         String var3 = var2.toString();
         GlideApp.with(this).load(var3).into(this.binding.thumbnail);
      }

      this.binding.thumbnail.setOnClickListener(new 1(this));
   }

   protected void onFinishInflate() {
      super.onFinishInflate();
      this.applyStyle();
   }

   public void setData(VideoTutorial var1) {
      this.videoTutorial = var1;
      this.applyStyle();
   }
}
