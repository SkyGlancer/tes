/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.MutableLiveData
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.ui.videotutorials;

import androidx.lifecycle.MutableLiveData;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.VideoTutorial;
import app.dukhaan.data.seed.VideoTutorialsSeedData;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.videotutorials.VideoTutorialNavigator;
import java.util.List;

public class VideoTutorialViewModel
extends BaseViewModel<VideoTutorialNavigator> {
    private MutableLiveData<List<VideoTutorial>> videosList = new MutableLiveData();

    public VideoTutorialViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    public void fetchVideoList() {
        List<VideoTutorial> list = VideoTutorialsSeedData.getVideosList();
        this.videosList.postValue(list);
    }

    public MutableLiveData<List<VideoTutorial>> getVideoLiveData() {
        return this.videosList;
    }
}

