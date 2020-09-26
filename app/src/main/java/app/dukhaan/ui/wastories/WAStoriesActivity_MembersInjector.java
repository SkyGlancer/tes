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
package app.dukhaan.ui.wastories;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.wastories.WAStoriesActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class WAStoriesActivity_MembersInjector
implements MembersInjector<WAStoriesActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public WAStoriesActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<WAStoriesActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new WAStoriesActivity_MembersInjector(provider);
    }

    public void injectMembers(WAStoriesActivity wAStoriesActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(wAStoriesActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

