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
package app.dukhaan.ui.splash;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.splash.SplashActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SplashActivity_MembersInjector
implements MembersInjector<SplashActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public SplashActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<SplashActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new SplashActivity_MembersInjector(provider);
    }

    public void injectMembers(SplashActivity splashActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(splashActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

