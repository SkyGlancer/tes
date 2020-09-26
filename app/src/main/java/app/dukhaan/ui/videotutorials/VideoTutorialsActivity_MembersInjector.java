/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.MembersInjector
 *  java.lang.Object
 *  javax.inject.Provider
 */
package app.dukhaan.ui.videotutorials;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.videotutorials.VideoTutorialsActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class VideoTutorialsActivity_MembersInjector
implements MembersInjector<VideoTutorialsActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public VideoTutorialsActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<VideoTutorialsActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new VideoTutorialsActivity_MembersInjector(provider);
    }

    public void injectMembers(VideoTutorialsActivity videoTutorialsActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(videoTutorialsActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

