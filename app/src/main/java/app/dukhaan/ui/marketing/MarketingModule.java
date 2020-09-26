/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.marketing.MarketingViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.marketing;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.marketing.MarketingViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class MarketingModule {
    @Provides
    ViewModelProvider.Factory marketingViewModelProvider(MarketingViewModel marketingViewModel) {
        return new ViewModelProviderFactory((Object)marketingViewModel);
    }

    @Provides
    MarketingViewModel provideMarketingStepsViewModel(DataRepository dataRepository, ApiService apiService) {
        return new MarketingViewModel(dataRepository, apiService);
    }
}

