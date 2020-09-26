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
package app.dukhaan.ui.splash;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.splash.SplashModule;
import app.dukhaan.ui.splash.SplashViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SplashModule_SplashViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final SplashModule module;
    private final Provider<SplashViewModel> viewModelProvider;

    public SplashModule_SplashViewModelProviderFactory(SplashModule splashModule, Provider<SplashViewModel> provider) {
        this.module = splashModule;
        this.viewModelProvider = provider;
    }

    public static SplashModule_SplashViewModelProviderFactory create(SplashModule splashModule, Provider<SplashViewModel> provider) {
        return new SplashModule_SplashViewModelProviderFactory(splashModule, provider);
    }

    public static ViewModelProvider.Factory splashViewModelProvider(SplashModule splashModule, SplashViewModel splashViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)splashModule.splashViewModelProvider(splashViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return SplashModule_SplashViewModelProviderFactory.splashViewModelProvider(this.module, (SplashViewModel)((Object)this.viewModelProvider.get()));
    }
}

