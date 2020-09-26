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
package app.dukhaan.ui.marketing;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.marketing.MarketingModule;
import app.dukhaan.ui.marketing.MarketingViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MarketingModule_ProvideMarketingStepsViewModelFactory
implements Factory<MarketingViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final MarketingModule module;

    public MarketingModule_ProvideMarketingStepsViewModelFactory(MarketingModule marketingModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = marketingModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static MarketingModule_ProvideMarketingStepsViewModelFactory create(MarketingModule marketingModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new MarketingModule_ProvideMarketingStepsViewModelFactory(marketingModule, provider, provider2);
    }

    public static MarketingViewModel provideMarketingStepsViewModel(MarketingModule marketingModule, DataRepository dataRepository, ApiService apiService) {
        return (MarketingViewModel)((Object)Preconditions.checkNotNull((Object)((Object)marketingModule.provideMarketingStepsViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public MarketingViewModel get() {
        return MarketingModule_ProvideMarketingStepsViewModelFactory.provideMarketingStepsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

