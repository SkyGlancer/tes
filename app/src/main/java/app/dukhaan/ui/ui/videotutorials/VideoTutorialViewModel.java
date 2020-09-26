package app.dukhaan.ui.ui.videotutorials;

import androidx.lifecycle.MutableLiveData;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.VideoTutorial;
import app.dukhaan.data.seed.VideoTutorialsSeedData;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.videotutorials.VideoTutorialNavigator;

import java.util.List;

public class VideoTutorialViewModel extends BaseViewModel<VideoTutorialNavigator> {
   private MutableLiveData<List<VideoTutorial>> videosList = new MutableLiveData();

   public VideoTutorialViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   public void fetchVideoList() {
      List var1 = VideoTutorialsSeedData.getVideosList();
      this.videosList.postValue(var1);
   }

   public MutableLiveData<List<VideoTutorial>> getVideoLiveData() {
      return this.videosList;
   }
}
