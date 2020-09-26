/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.wastories.WAStoriesViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.wastories;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.wastories.WAStoriesViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class WAStoriesModule {
    @Provides
    WAStoriesViewModel waStoriesListViewModel(DataRepository dataRepository, ApiService apiService) {
        return new WAStoriesViewModel(dataRepository, apiService);
    }

    @Provides
    ViewModelProvider.Factory waStoriesModelProvider(WAStoriesViewModel wAStoriesViewModel) {
        return new ViewModelProviderFactory((Object)wAStoriesViewModel);
    }
}

