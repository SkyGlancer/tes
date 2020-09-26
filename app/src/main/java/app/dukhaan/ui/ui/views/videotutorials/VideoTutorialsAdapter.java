package app.dukhaan.ui.ui.views.videotutorials;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import app.dukhaan.data.model.VideoTutorial;
import java.util.List;

public class VideoTutorialsAdapter extends Adapter<app.dukhaan.ui.views.videotutorials.VideoTutorialsAdapter.VideoHolder> {
   private List<VideoTutorial> videosList;

   public VideoTutorialsAdapter() {
   }

   public int getItemCount() {
      List var1 = this.videosList;
      int var2;
      if (var1 == null) {
         var2 = 0;
      } else {
         var2 = var1.size();
      }

      return var2;
   }

   public void onBindViewHolder(app.dukhaan.ui.views.videotutorials.VideoTutorialsAdapter.VideoHolder var1, int var2) {
      VideoTutorial var3 = (VideoTutorial)this.videosList.get(var2);
      var1.card.setData(var3);
   }

   public app.dukhaan.ui.views.videotutorials.VideoTutorialsAdapter.VideoHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new app.dukhaan.ui.views.videotutorials.VideoTutorialsAdapter.VideoHolder(this, LayoutInflater.from(var1.getContext()).inflate(video_tutorial_item, var1, false));
   }

   public void setData(List<VideoTutorial> var1) {
      this.videosList = var1;
      this.notifyDataSetChanged();
   }
}
