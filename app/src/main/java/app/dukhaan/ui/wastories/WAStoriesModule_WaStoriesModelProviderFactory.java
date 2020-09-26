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
package app.dukhaan.ui.wastories;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.wastories.WAStoriesModule;
import app.dukhaan.ui.wastories.WAStoriesViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class WAStoriesModule_WaStoriesModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final WAStoriesModule module;
    private final Provider<WAStoriesViewModel> viewModelProvider;

    public WAStoriesModule_WaStoriesModelProviderFactory(WAStoriesModule wAStoriesModule, Provider<WAStoriesViewModel> provider) {
        this.module = wAStoriesModule;
        this.viewModelProvider = provider;
    }

    public static WAStoriesModule_WaStoriesModelProviderFactory create(WAStoriesModule wAStoriesModule, Provider<WAStoriesViewModel> provider) {
        return new WAStoriesModule_WaStoriesModelProviderFactory(wAStoriesModule, provider);
    }

    public static ViewModelProvider.Factory waStoriesModelProvider(WAStoriesModule wAStoriesModule, WAStoriesViewModel wAStoriesViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)wAStoriesModule.waStoriesModelProvider(wAStoriesViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return WAStoriesModule_WaStoriesModelProviderFactory.waStoriesModelProvider(this.module, (WAStoriesViewModel)((Object)this.viewModelProvider.get()));
    }
}

