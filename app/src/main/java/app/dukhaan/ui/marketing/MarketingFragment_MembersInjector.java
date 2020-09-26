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
package app.dukhaan.ui.marketing;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.marketing.MarketingFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MarketingFragment_MembersInjector
implements MembersInjector<MarketingFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public MarketingFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<MarketingFragment> create(Provider<ViewModelProvider.Factory> provider) {
        return new MarketingFragment_MembersInjector(provider);
    }

    public void injectMembers(MarketingFragment marketingFragment) {
        BaseFragment_MembersInjector.injectViewModelFactory(marketingFragment, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

