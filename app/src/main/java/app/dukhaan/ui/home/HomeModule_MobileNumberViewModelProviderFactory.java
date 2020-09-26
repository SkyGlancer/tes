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
package app.dukhaan.ui.home;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.home.HomeModule;
import app.dukhaan.ui.home.HomeViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class HomeModule_MobileNumberViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final HomeModule module;
    private final Provider<HomeViewModel> viewModelProvider;

    public HomeModule_MobileNumberViewModelProviderFactory(HomeModule homeModule, Provider<HomeViewModel> provider) {
        this.module = homeModule;
        this.viewModelProvider = provider;
    }

    public static HomeModule_MobileNumberViewModelProviderFactory create(HomeModule homeModule, Provider<HomeViewModel> provider) {
        return new HomeModule_MobileNumberViewModelProviderFactory(homeModule, provider);
    }

    public static ViewModelProvider.Factory mobileNumberViewModelProvider(HomeModule homeModule, HomeViewModel homeViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)homeModule.mobileNumberViewModelProvider(homeViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return HomeModule_MobileNumberViewModelProviderFactory.mobileNumberViewModelProvider(this.module, (HomeViewModel)((Object)this.viewModelProvider.get()));
    }
}

