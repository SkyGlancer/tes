/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.videotutorials;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.videotutorials.VideoTutorialModule;
import app.dukhaan.ui.videotutorials.VideoTutorialViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class VideoTutorialModule_ProvideVideoListViewModelFactory
implements Factory<VideoTutorialViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final VideoTutorialModule module;

    public VideoTutorialModule_ProvideVideoListViewModelFactory(VideoTutorialModule videoTutorialModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = videoTutorialModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static VideoTutorialModule_ProvideVideoListViewModelFactory create(VideoTutorialModule videoTutorialModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new VideoTutorialModule_ProvideVideoListViewModelFactory(videoTutorialModule, provider, provider2);
    }

    public static VideoTutorialViewModel provideVideoListViewModel(VideoTutorialModule videoTutorialModule, DataRepository dataRepository, ApiService apiService) {
        return (VideoTutorialViewModel)((Object)Preconditions.checkNotNull((Object)((Object)videoTutorialModule.provideVideoListViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public VideoTutorialViewModel get() {
        return VideoTutorialModule_ProvideVideoListViewModelFactory.provideVideoListViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

