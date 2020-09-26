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
package app.dukhaan.ui.wastories;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.wastories.WAStoriesModule;
import app.dukhaan.ui.wastories.WAStoriesViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class WAStoriesModule_WaStoriesListViewModelFactory
implements Factory<WAStoriesViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final WAStoriesModule module;

    public WAStoriesModule_WaStoriesListViewModelFactory(WAStoriesModule wAStoriesModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = wAStoriesModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static WAStoriesModule_WaStoriesListViewModelFactory create(WAStoriesModule wAStoriesModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new WAStoriesModule_WaStoriesListViewModelFactory(wAStoriesModule, provider, provider2);
    }

    public static WAStoriesViewModel waStoriesListViewModel(WAStoriesModule wAStoriesModule, DataRepository dataRepository, ApiService apiService) {
        return (WAStoriesViewModel)((Object)Preconditions.checkNotNull((Object)((Object)wAStoriesModule.waStoriesListViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public WAStoriesViewModel get() {
        return WAStoriesModule_WaStoriesListViewModelFactory.waStoriesListViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

