/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.videotutorials;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.videotutorials.VideoTutorialModule;
import app.dukhaan.ui.videotutorials.VideoTutorialViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class VideoTutorialModule_VideoListModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final VideoTutorialModule module;
    private final Provider<VideoTutorialViewModel> viewModelProvider;

    public VideoTutorialModule_VideoListModelProviderFactory(VideoTutorialModule videoTutorialModule, Provider<VideoTutorialViewModel> provider) {
        this.module = videoTutorialModule;
        this.viewModelProvider = provider;
    }

    public static VideoTutorialModule_VideoListModelProviderFactory create(VideoTutorialModule videoTutorialModule, Provider<VideoTutorialViewModel> provider) {
        return new VideoTutorialModule_VideoListModelProviderFactory(videoTutorialModule, provider);
    }

    public static ViewModelProvider.Factory videoListModelProvider(VideoTutorialModule videoTutorialModule, VideoTutorialViewModel videoTutorialViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)videoTutorialModule.videoListModelProvider(videoTutorialViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return VideoTutorialModule_VideoListModelProviderFactory.videoListModelProvider(this.module, (VideoTutorialViewModel)((Object)this.viewModelProvider.get()));
    }
}

