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
package app.dukhaan.ui.home;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.home.HomeFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class HomeFragment_MembersInjector
implements MembersInjector<HomeFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public HomeFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<HomeFragment> create(Provider<ViewModelProvider.Factory> provider) {
        return new HomeFragment_MembersInjector(provider);
    }

    public void injectMembers(HomeFragment homeFragment) {
        BaseFragment_MembersInjector.injectViewModelFactory(homeFragment, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

