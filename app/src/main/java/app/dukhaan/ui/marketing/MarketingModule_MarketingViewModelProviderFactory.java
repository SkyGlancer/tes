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
package app.dukhaan.ui.marketing;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.marketing.MarketingModule;
import app.dukhaan.ui.marketing.MarketingViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MarketingModule_MarketingViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final MarketingModule module;
    private final Provider<MarketingViewModel> viewModelProvider;

    public MarketingModule_MarketingViewModelProviderFactory(MarketingModule marketingModule, Provider<MarketingViewModel> provider) {
        this.module = marketingModule;
        this.viewModelProvider = provider;
    }

    public static MarketingModule_MarketingViewModelProviderFactory create(MarketingModule marketingModule, Provider<MarketingViewModel> provider) {
        return new MarketingModule_MarketingViewModelProviderFactory(marketingModule, provider);
    }

    public static ViewModelProvider.Factory marketingViewModelProvider(MarketingModule marketingModule, MarketingViewModel marketingViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)marketingModule.marketingViewModelProvider(marketingViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return MarketingModule_MarketingViewModelProviderFactory.marketingViewModelProvider(this.module, (MarketingViewModel)((Object)this.viewModelProvider.get()));
    }
}

